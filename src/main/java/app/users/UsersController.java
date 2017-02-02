package app.users;

import app.login.User;
import app.util.Path;
import app.util.ViewUtil;
import spark.Request;
import spark.Response;
import spark.Route;

import java.util.HashMap;
import java.util.Map;

import static app.Application.UserDAO;
import static app.admin.UsersController.selectUsers;
import static app.util.JsonUtil.dataToJson;
import static app.util.RequestUtil.*;
import static app.util.RequestUtil.getQueryUsername;

/**
 * Created by carlo on 30-01-17.
 */
public class UsersController {
    public static Route getAllUsers = (Request request, Response response) -> {
        if (clientAcceptsHtml(request)) {
            System.out.println(" getallUser");
            HashMap<String, Object> model = new HashMap<>();
            model.put("users", UserDAO.getAllUsers());
            return ViewUtil.render(request, model, Path.Template.USERS);
        }
        if (clientAcceptsJson(request)) {
            return dataToJson(UserDAO.getAllUsers());
        }
        return ViewUtil.notAcceptable.handle(request, response);
    };

    public static Route getOneUser = (Request request, Response response) -> {
        System.out.println(" getOneUser");
        Map<String, Object> model = new HashMap<>();
        request.attribute("delete", request.pathInfo());
        model.put("user", UserDAO.getUsernameByParam(getParamUsername(request)));
        UserDAO.deleteUserqueries(getParamUsername(request));
        return ViewUtil.render(request, model, Path.Template.USER);
    };

    public static Route deleteUser = (Request request, Response response) -> {

        if (clientAcceptsHtml(request)) {
            HashMap<String, Object> model = new HashMap<>();

            model.put("user", UserDAO.getUsernameByParam(getParamUsername(request)));
            model.put("user", UserDAO.getUsernameByParam(getParamUsername(request)));
            UserDAO.deleteUserqueries(getParamUsername(request));

            return ViewUtil.render(request, model, Path.Template.USER);
        }
        if (clientAcceptsJson(request)) {
            return dataToJson(UserDAO.getUsernameByParam(getParamUsername(request)));
        }
        return ViewUtil.notAcceptable.handle(request, response);
    };

//    public static Route alterUserPage = (Request request, Response response) -> {
//        if (clientAcceptsHtml(request)) {
//            HashMap<String, Object> model = new HashMap<>();
//            model.put("user", UserDAO.getUsernameByParam(getParamUsername(request)));
//            return ViewUtil.render(request, model, Path.Template.ALTERUSERPAGE);
//        }
//        if (clientAcceptsJson(request)) {
//            return dataToJson(UserDAO.getUsernameByParam(getParamUsername(request)));
//        }
//        return ViewUtil.notAcceptable.handle(request, response);
//    };

    public static Route alterUser = (Request request, Response response) -> {
        Map<String, Object> model = new HashMap<>();
        String firstname = request.queryParams("firstname");
        String lastname = request.queryParams("lastname");
        String username = request.queryParams("username");
        String password = request.queryParams("password");
        String birthyear = request.queryParams("birthyear");
        String birthsmonth = request.queryParams("birthmonth");
        String birthday = request.queryParams("birthday");
        String creditcardnumber = request.queryParams("creditcardnumber");
        String birthDate = birthyear + "-"  + birthsmonth + "-" + birthday;

        User customer = new User();
        Boolean a = customer.createCustomer(username, password, "Orders", firstname, lastname, birthDate,  creditcardnumber, "2012-02-02" );
        System.out.println(a);

        return ViewUtil.render(request, model, Path.Template.ADMINHOME);
    };
}
