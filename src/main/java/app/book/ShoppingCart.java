package app.book;

import app.DBC;

import java.sql.Statement;

/**
 * Created by wrket on 17-Jan-17.
 */
public class ShoppingCart {


    public void AddShoppingCartItem(String costumer_id, String product_id){
        try {
            DBC databasePandaShop = new DBC();
            Statement stat = databasePandaShop.Connection();
            String query = ("Insert INTO shoppingcart VALUES (" + costumer_id + product_id +" );");
            stat.executeUpdate(query);
            stat.getConnection().commit();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }

    }


    public void RemoveShoppingCartItem(String costumer_id, String product_id){
        try {
            DBC databasePandaShop = new DBC();
            Statement stat = databasePandaShop.Connection();
            String query = ("DELETE From shoppingcart Where costumer_id =" + costumer_id + "AND product_id =" + product_id +" );");
            stat.executeUpdate(query);
            stat.getConnection().commit();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }

    }

    public void RemoveShoppingCart(String costumer_id){
        try {
            DBC databasePandaShop = new DBC();
            Statement stat = databasePandaShop.Connection();
            String query = ("DELETE From shoppingcart Where costumer_id =" + costumer_id +" );");
            stat.executeUpdate(query);
            stat.getConnection().commit();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }

    }

    public void SeeShoppingCart(String costumer_id){
        try {
            DBC databasePandaShop = new DBC();
            Statement stat = databasePandaShop.Connection();
            String query = ("Select product_id   From shoppingcart Where costumer_id =" + costumer_id +" );");
            stat.executeUpdate(query);
            stat.getConnection().commit();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }

    }
}
