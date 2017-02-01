package app.login;

import app.DBC;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by Samuel on 09-11-16.
 */
public class User { // create a customer (with an andress) in DataBase
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
        }

        finally {
            if (stat != null) { stat.close(); }
        }
        {
            return listOfUsers;
        }

//        public static ArrayList<String> selectUsers() throws SQLException {
//            DBC dbc = new DBC();
//            Statement stat = dbc.Connection();
//            ArrayList<String> listOfUsers = null;
//
//            try {
//                String query = ("select usernamecustomer from customer");
//                stat.getConnection().commit();
//                ResultSet rs = stat.executeQuery(query);
//                listOfUsers = new ArrayList<String>();
//                while (rs.next()) {
//                    String username = rs.getString(1);
//                    listOfUsers.add(username);
//                }
//            } catch (Exception e) {
//                System.out.println("Error");
//            }
//            return listOfUsers;
//        }

    }

}
