package app.admin;

import app.DBC;
import app.util.Path;
import app.util.ViewUtil;
import spark.Request;
import spark.Response;
import spark.Route;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by carlo on 08-11-16.
 */
public class UsersController {
    public static Route users = (Request request, Response response) -> {
        Map<String, Object> model = new HashMap<>();
        System.out.println("Niet anders");
        model.put("users", selectUsers());
        return ViewUtil.render(request, model, Path.Template.USERS);
    };

    public static Route userspost = (Request request, Response response) -> {
        Map<String, Object> model = new HashMap<>();
        model.put("users", selectUsers());
//        String username = request.attributes().iterator().next();
//        request.session().attribute("modify", username);
        System.out.println("Anders");
        return ViewUtil.render(request, model, Path.Template.USERCHANGE);
    };

    public static ArrayList<String> selectUsers() throws SQLException {
        DBC dbc = new DBC();
        Statement stat = dbc.Connection();
        ArrayList<String> listOfUsers = null;

        try {
            String query = ("select usernamecustomer from customer");
            stat.getConnection().commit();
            ResultSet rs = stat.executeQuery(query);
            listOfUsers = new ArrayList<String>();
            while (rs.next()) {
                String username = rs.getString(1);
                listOfUsers.add(username);
            }
        } catch (Exception e) {
            System.out.println("Error");
        }
        return listOfUsers;


    }

}