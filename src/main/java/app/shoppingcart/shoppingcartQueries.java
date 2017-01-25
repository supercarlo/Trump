package app.shoppingcart;

import app.DBC;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by onno on 25-1-2017.
 */
public class shoppingcartQueries {
    public void addItemToShoppingCart(String UsernameCustomer, String productid, String quantity) {
        try {
            //tested in sql, not tested in webpage
            DBC databasePandaShop = new DBC();
            Statement stat = databasePandaShop.Connection();
            String query = ("insert into shoppingcart(usernamecustomer, productid, quantity) values('"+ UsernameCustomer+ "', '"+ productid + "', '" + quantity+ "');");
            stat.executeUpdate(query);
            stat.getConnection().commit();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }
    public void deleteProductShoppingCart(String productId, String usernamecustomer){
        try {
            DBC databasePandaShop = new DBC();
            Statement stat = databasePandaShop.Connection();
            String query = ("DELETE FROM product WHERE productid = '" + productId + "' and usernamecustomer = '" + usernamecustomer + "' ;");
            stat.executeUpdate(query);
            stat.getConnection().commit();
            stat.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }

    }
    public static ArrayList<String> selectShoppingCartItems(String valueName, String usernamecustomer) throws SQLException {
        DBC dbc = new DBC();
        Statement stat = dbc.Connection();
        ArrayList<String> shoppingcartuserlist = null;

        try {
            //tested in sql, not tested in webpage
            String query = ("SELECT " + valueName + " AS shoppingcartuser FROM shoppingcart where usernamecustomer = '"+ usernamecustomer+ "');");
            stat.getConnection().commit();
            ResultSet rs = stat.executeQuery(query);
            shoppingcartuserlist = new ArrayList<String>();
            if (rs.next()) {
                String getProductId = rs.getString(valueName);
                System.out.println(getProductId);
                shoppingcartuserlist.add(getProductId);
            }
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        } finally {
            if (stat != null) {
                stat.close();
            }
        }
        {
            return shoppingcartuserlist;
        }

    }

}
