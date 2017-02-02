package app.admin;

import app.DBC;
import app.util.Path;
import app.util.ViewUtil;
import spark.Request;
import spark.Response;
import spark.Route;

import javax.swing.*;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import static app.admin.UsersController.selectUsers;
import static app.util.RequestUtil.getQueryUsername;

/**
 * Created by carlo on 09-11-16.
 */
public class UserAlterController {
    public static Route alter = (Request request, Response response) -> {
        Map<String, Object> model = new HashMap<>();
        request.attribute("alter", request.pathInfo());
        model.put("altersucces", true);
        return ViewUtil.render(request, model, Path.Template.INDEX);
    };

//    public static Route alterpost = (Request request, Response response) -> {
//        Map<String, Object> model = new HashMap<>();
//        request.attribute("alter", request.pathInfo());
//        String var = request.session().attribute("modify");
//        System.out.println(var);
//        model.put("users", selectUsers());
//        //deleteCustomer(var);
//        //deleteAdress(getQueryUsername(request));
//        //model.put("deletesucces", true);
//        return ViewUtil.render(request, model, Path.Template.ALTERUSER);
//    };

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

}
