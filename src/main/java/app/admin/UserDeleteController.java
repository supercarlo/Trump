package app.admin;

import app.DBC;
import app.util.Path;
import app.util.ViewUtil;
import spark.Request;
import spark.Response;
import spark.Route;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by carlo on 09-11-16.
 */
public class UserDeleteController {
    public static Route delete = (Request request, Response response) -> {
        Map<String, Object> model = new HashMap<>();
//        request.attribute("delete", request.pathInfo());
//        model.put("deletesucces", true);
        return ViewUtil.render(request, model, Path.Template.INDEX);
    };

    public static Route deletepost = (Request request, Response response) -> {
        Map<String, Object> model = new HashMap<>();
        request.attribute("delete", request.pathInfo());
        String var = request.session().attribute("modify");
        System.out.println(var);
        deleteCustomer(var);
      //deleteAdress(getQueryUsername(request));
        model.put("deletesucces", true);
        return ViewUtil.render(request, model, Path.Template.ADMINHOME);
    };

    public static void deleteCustomer(String UsernameCustomer){
        DBC dbc = new DBC();
        Statement stat = dbc.Connection();
        try {
            //Statement stat = dbc.Connection();
            int result = stat.executeUpdate("delete from customer where usernamecustomer = '"+UsernameCustomer+"'" );
            stat.getConnection().commit();

            if(result!=1){
                JOptionPane.showMessageDialog(null,"No record exists related to "+UsernameCustomer);
            }
            //stat.getConnection().commit();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }
//public static void deleteCustomer(String UsernameCustomer){
//    try {
//        DBC databasePandaShop = new DBC();
//        Statement stat = databasePandaShop.Connection();
//        String query = ("DELETE FROM Customer WHERE usernameCustomer = '" + UsernameCustomer + "';");
//        stat.executeUpdate(query);
//        stat.getConnection().commit();
//    } catch (Exception e) {
//        System.err.println(e.getClass().getName() + ": " + e.getMessage());
//        System.exit(0);
//    }
//
//}

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
