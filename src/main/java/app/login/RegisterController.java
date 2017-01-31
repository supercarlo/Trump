package app.login;

import app.admin.UsersController;
import app.user.UserController;
import app.util.Path;
import app.util.ViewUtil;
import spark.Request;
import spark.Response;
import spark.Route;

import java.util.HashMap;
import java.util.Map;
//import static app.Application.userDao;

/**
 * Created by carlo on 08-11-16.
 */
public class RegisterController {
    public static Route register = (Request request, Response response) -> {
        Map<String, Object> model = new HashMap<>();
        return ViewUtil.render(request, model, Path.Template.REGISTER);
    };

    public static Route registerpost = (Request request, Response response) -> {
        Map<String, Object> model = new HashMap<>();
        UsersController usersController = new UsersController();
        String firstname = request.queryParams("firstname");
        String lastname = request.queryParams("lastname");
        String username = request.queryParams("username");
        String password = request.queryParams("password");
        String birthyear = request.queryParams("birthyear");
        String birthmonth = request.queryParams("birthmonth");
        String birthday = request.queryParams("birthday");
        String creditcardnumber = request.queryParams("creditcardnumber");
        String birthDate = birthyear + "-"  + birthmonth + "-" + birthday;

        User customer = new User();
        boolean a = customer.createCustomer(username, password, "user", firstname, lastname, birthDate,  creditcardnumber, "2012-02-02" );
        System.out.println(a);


//            request.session().attribute("currentUser", firstname);
//            model.put("firstname", firstname);
//            response.redirect(Path.Web.CUSTOMERHOME);
//
//            request.session().attribute("currentUser", lastname);
//            model.put("lastname", lastname);
//            response.redirect(Path.Web.ADMINHOME);



        return ViewUtil.render(request, model, Path.Template.LOGIN);

    };
}