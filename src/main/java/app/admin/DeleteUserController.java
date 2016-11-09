package app.admin;

import app.DBC;
import app.util.Path;
import app.util.ViewUtil;
import spark.Request;
import spark.Response;
import spark.Route;

import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import static app.util.RequestUtil.getQueryUsername;

/**
 * Created by carlo on 09-11-16.
 */
public class DeleteUserController {
    public static Route delete = (Request request, Response response) -> {
        Map<String, Object> model = new HashMap<>();

        deleteCustomer("Kieter");
//        deleteAdress(getQueryUsername(request));
        model.put("deletesucces", true);

        return ViewUtil.render(request, model, Path.Template.ADMINHOME);
    };

    public static void deleteCustomer(String UsernameCustomer){
        DBC dbc = new DBC();
        try {
            Statement stat = dbc.Connection();
            String query = ("DELETE FROM customer WHERE usernamecustomer = '" + UsernameCustomer + "';");
            stat.getConnection().commit();
            stat.executeUpdate(query);
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    public static void deleteAdress(String UsernameCustomer){
        DBC dbc = new DBC();
        try {
            Statement stat = dbc.Connection();
            String query = ("DELETE FROM adress WHERE usernamecustomer = '" + UsernameCustomer + "';");
            stat.getConnection().commit();
            stat.executeUpdate(query);
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }

    }
}
