package app.product;

import app.DBC;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;

public class ProductDao {
    DBC dbc = new DBC();
    Statement stat = dbc.Connection();

    public static List<Products> products = new ArrayList<>();

    public void addAllProducts() {
        try {
            String query = ("select productid, info, image, nameproduct, price, categoryname from product");
            stat.getConnection().commit();
            ResultSet rs = stat.executeQuery(query);
            while (rs.next()) {
                products.add(new Products(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6)));
            }
        } catch (Exception e) {
            System.out.println("Error");
        }
    }


    public Iterable<Products> getAllProducts() {
        products.clear();
        addAllProducts();
        return products;
    }

    public Products getProductByID(String id) {
        return products.stream().filter(p -> p.getID().equals(id)).findFirst().orElse(null);
    }
}