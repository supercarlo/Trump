package app.shoppingcart;

import app.DBC;

import java.sql.Statement;

/**
 * Created by onno on 25-1-2017.
 */
public class shoppingcartQueries {
    public void addItemToShoppingCart(String UsernameCustomer, String productid, String quantity) {
        try {
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

}
