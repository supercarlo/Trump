package app.shoppingcart;

import app.DBC;
import app.product.Products;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import static app.Application.ProductDao;

public class shoppingcartDAO {
    static ArrayList<Products> shoppingcartproducts = new ArrayList<>();
    ArrayList<String> productidList = new ArrayList<>();
    ArrayList<String> usernameList = new ArrayList<>();

    public Iterable<Products> getAllProductsInCart() {
        return shoppingcartproducts;
    }

    public static String addProductToCart(String id) {
        if (id != null) {
            shoppingcartproducts.add(ProductDao.getProductByID(id));
        }
        return id;
    }

    public int AddOrderJunction(String Username) {
        int orderid = 0;
        DBC databasePandaShop = new DBC();
        Statement stat = databasePandaShop.Connection();
        try {
            String query = "select count(orderid) as neworderid from orders_history_customer_junctiontable2; ";
            ResultSet rs = stat.executeQuery(query);

            if (rs.next()) {
                orderid = rs.getInt("neworderid") + 1; }
            rs.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }

        try {
            stat.executeUpdate ("INSERT INTO orders_history_customer_junctiontable2 (usernamecustomer, orderid)\n" + "VALUES ('" + Username + "'," + orderid + " );");
            stat.getConnection().commit();
            stat.close();

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);

        }
        return orderid;
    }
    public void AddOrder(Integer orderid,String poduct_id, String price){
        int rowid = 0;
        DBC databasePandaShop = new DBC();
        Statement stat = databasePandaShop.Connection();
        try {
            String query = "select count(rowid) as newrowid from orders_history; ";
            ResultSet rs = stat.executeQuery(query);

            if (rs.next()) {
                rowid = rs.getInt("newrowid") + 1; }
            rs.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        int quantity = 1;
        try {
            stat.executeUpdate ("INSERT INTO orders_history (rowid, orderid, poduct_id, price, quantity)\n" + "VALUES ('" + rowid + "','" + orderid + "','" + poduct_id + "','" + price + "','" + quantity + "'); ");
            stat.getConnection().commit();
            stat.close();

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);

        }
    }

    public Iterable<Products> deleteProductFromCart() {
        shoppingcartproducts.clear();

        return shoppingcartproducts;
    }

    public void purchaseProductByID(String username) {
//        while (shoppingcartproducts.iterator().hasNext()) {
//            if (shoppingcartproducts.iterator().hasNext()) {
//                purchases.add(shoppingcartproducts.iterator().next().getID());
//                shoppingcartproducts.iterator().next();
//            }
//        }
        for (int i = 0; i < shoppingcartproducts.size(); i++ )
        {
            Products temp = shoppingcartproducts.get(i);
            //for (int j = 0; j < shoppingcartproducts.size(); j++ ) {
                //String temp = shoppingcartproducts.get(i);

//                Double price = (Dotemp.getPrice());
            System.out.println(username);
                //productidList.add(ID);
            int  orderid = AddOrderJunction(username);


            //}
            AddOrder(orderid, temp.getID(), temp.getPrice());
        }

    }
}
