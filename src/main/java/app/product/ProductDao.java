package app.product;

import app.DBC;
import com.google.common.collect.ImmutableList;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ProductDao {
    DBC dbc = new DBC();
    Statement stat = dbc.Connection();

    public ArrayList<Products> products = new ArrayList();

    public void addAllProducts() {
        products.clear();
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
        return products;
    }

    public Products getProductByID(String id) {
        System.out.println(products.stream().filter(p -> p.getID().equals(id)).findFirst().orElse(null));
        return products.stream().filter(p -> p.getID().equals(id)).findFirst().orElse(null);
    }

    public Products getRandomProduct() {
        return products.get(new Random().nextInt(products.size()));
    }
}
