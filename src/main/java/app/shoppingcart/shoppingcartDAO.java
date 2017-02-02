package app.shoppingcart;

import app.DBC;
import app.product.ProductDao;
import app.product.Products;
import spark.Request;

import static app.Application.loginController;
import static app.Application.ProductDao;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class shoppingcartDAO {
    ArrayList<Products> shoppingcartproducts = new ArrayList<>();
    ArrayList<String> productidList = new ArrayList<>();
    ArrayList<String> usernameList = new ArrayList<>();

    public Iterable<Products> getAllProductsInCart() {
        return shoppingcartproducts;
    }

    public void addProductToCart(String id) {
        if (id != null) {
            shoppingcartproducts.add(ProductDao.getProductByID(id));
        }
    }

    public int AddOrderJunction(String Username) {
        int orderid = 0;
        DBC databasePandaShop = new DBC();
        Statement stat = databasePandaShop.Connection();
        try {
            String query = "select count(orderid) as neworderid from orders_history_customer_junctiontable; ";
            ResultSet rs = stat.executeQuery(query);

            if (rs.next()) {
                orderid = rs.getInt("neworderid") + 1; }
            rs.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }

        try {
            stat.executeUpdate ("INSERT INTO orders_history_customer_junctiontable (usernamecustomer, orderid)\n" + "VALUES ('" + Username + "'," + orderid + " );");
            stat.getConnection().commit();
            stat.close();

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);

        }
        return orderid;
    }
    public void AddOrder(Integer orderid,String poduct_id, double price){
        DBC databasePandaShop = new DBC();
        Statement stat = databasePandaShop.Connection();
        try {
            stat.executeUpdate ("INSERT INTO orders_history (usernamecustomer, poduct_id, price, quantity)\n" + "VALUES ('" + orderid + "''" + poduct_id + "''" + price + "''" + 1 + "'); ");
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
                String ID = temp.getID();
            System.out.println(username);
                productidList.add(ID);
            AddOrderJunction(username);

            //}
            System.out.println(temp.getID());
        }

    }
}
