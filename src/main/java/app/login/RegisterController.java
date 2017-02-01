package app.login;

import app.admin.UsersController;
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
        Boolean a = customer.createCustomer(username, password, "user", firstname, lastname, birthDate,  creditcardnumber, "2012-02-02" );
        System.out.println(a);

        return ViewUtil.render(request, model, Path.Template.LOGIN);

    };

    public Boolean multiplyString(boolean name){
        System.out.println("Multiplication result is " +name);

        return true;
    }
}