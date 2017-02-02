package app.login;

import app.DBC;
import app.user.UserController;
import app.util.Path;
import app.util.ViewUtil;
import spark.Request;
import spark.Response;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Samuel on 09-11-16.
 */
// create a customer (with an andress) in DataBase
public class User {
    public boolean createCustomer(String UsernameCustomer, String PasswordCustomer, String Level, String firstname, String LastName, String BirthDate, String CreditCardInfo, String MemberSince) {
        boolean usernameAvailibility = true;
        DBC databasePandaShop = new DBC();
        Statement stat = databasePandaShop.Connection();
        int countExistenceofUsername = 0;

        try {
            String query = ("select usernamecustomer from Customer where usernamecustomer = '" + UsernameCustomer + "' ;");
            ResultSet rs = stat.executeQuery(query);
            if (rs.next()) {
                countExistenceofUsername++;
            }
            rs.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }

        if (countExistenceofUsername == 1) {
            usernameAvailibility = false;
        }

        if (usernameAvailibility == true) {
            try{
                String query = ("insert into customer(usernamecustomer, passwordcustomer, userlevel ,firstname, lastname, birthdate, creditcardinfo, membersince) values('" + UsernameCustomer + "', '" + PasswordCustomer + "', '" + Level + "', '" + firstname + "', '" + LastName + "', '" + BirthDate + "', '" + CreditCardInfo + "', '" + MemberSince + "');");
                stat.executeUpdate(query);
                stat.getConnection().commit();
            } catch(Exception e){                System.err.println(e.getClass().getName() + ": " + e.getMessage());
                System.exit(0);

            }
        }
        return usernameAvailibility;

    }

    //delete customer from database
    public String deleteCustomer(String UsernameCustomer){
        try {
            DBC databasePandaShop = new DBC();
            Statement stat = databasePandaShop.Connection();
            String query = ("DELETE FROM Customer WHERE usernameCustomer = '" + UsernameCustomer + "';");
            stat.executeUpdate(query);
            stat.getConnection().commit();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }

        return UsernameCustomer;
    }

    // change a customer in DataBase
    public String alterCustomer(String columnName, String newData, String UsernameCustomer){

        try {
            DBC databasePandaShop = new DBC();
            Statement stat = databasePandaShop.Connection();
            String query = ("UPDATE Customer SET "+ columnName + " = '"+ newData +"' WHERE usernamecustomer = '"+ UsernameCustomer +"';");
            stat.executeUpdate(query);
            stat.getConnection().commit();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return columnName;
    }

    //delete customer from database
    public String createAdress(String UsernameCustomer, String city, String postalcode, String street, String househumber) {

            DBC databasePandaShop = new DBC();
            Statement stat = databasePandaShop.Connection();
            String query = ("insert into adress(adressid, city, postalcode ,street, housenumber) values('"+ UsernameCustomer+ "', '"+ city + "', '" + postalcode+ "', '" + street + "', '" + househumber + "');");
        try {stat.executeUpdate(query);
            stat.getConnection().commit();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return query;
    }


    // delete a adress from the DataBase
    public String deleteAdress(String UsernameCustomer){
        try {
            DBC databasePandaShop = new DBC();
            Statement stat = databasePandaShop.Connection();
            String query = ("DELETE FROM Adress WHERE adressid = '" + UsernameCustomer + "';");
            stat.executeUpdate(query);
            stat.getConnection().commit();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }

        return UsernameCustomer;
    }

    // create a product (in the wishlist) in the DataBase
    public String addWishproduct(String productid, String wishlistid, String quantity){

        DBC databasePandaShop = new DBC();
        Statement stat = databasePandaShop.Connection();
        String query = ("insert into wishlistproducts(productid, wishlistid, quantity) values('"+ productid+ "', '"+ wishlistid+ "', '"+ quantity+ "');");
        try {stat.executeUpdate(query);
            stat.getConnection().commit();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }

        return query;
    }

    // change a adress in the DataBase
    public String alterAdress(String columnName, String newData, String UsernameCustomer){

        try {
            DBC databasePandaShop = new DBC();
            Statement stat = databasePandaShop.Connection();
            String query = ("UPDATE Adress SET "+ columnName + " = '"+ newData +"' WHERE adressid = '"+ UsernameCustomer +"';");
            stat.executeUpdate(query);
            stat.getConnection().commit();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return columnName;
    }

    public static ArrayList<String> selectUsers(String valueName) throws SQLException {
        DBC dbc = new DBC();
        Statement stat = dbc.Connection();
        ArrayList<String> listOfUsers = null;

        try {
            String query = ("SELECT '" + valueName + "' AS usernamecustomer FROM customer");
            stat.getConnection().commit();
            ResultSet rs = stat.executeQuery(query);
            listOfUsers = new ArrayList<String>();
            if (rs.next()) {
                String getUserName = rs.getString(valueName);
                System.out.println(getUserName);
                listOfUsers.add(getUserName);
            }
            //rs.close();
            //dbc.Connection().close();
        } catch (Exception e) {
            System.out.println("brandBlusser");
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        } finally {
            if (stat != null) {
                stat.close();
            }
        }
        {
            return listOfUsers;
        }
    }

    public static String userController(Request request, Response response) {
        UserController userController = new UserController();
        Map<String, Object> model = new HashMap<>();
        String username = request.queryParams("username");
        String password = request.queryParams("password");
        int level = userController.login(username, password);

        if (level == 2) {
//            app.login.User login
            request.session().attribute("currentUser", username);
            model.put("authenticationSucceeded", true);
            model.put("asUser", true);
            model.put("username", username);
            response.redirect(Path.Web.PRODUCTS);
        } else if (level == 3) {
//            Admin login
            request.session().attribute("currentUser", username);
            model.put("asAdmin", true);
            model.put("authenticationSucceeded", true);
            model.put("username", username);
            response.redirect(Path.Web.ADMINHOME);
        } else {
            model.put("authenticationFailed", true);
        }
        return ViewUtil.render(request, model, Path.Template.LOGIN);
    }
}


