package app.product;

import app.DBC;

import java.sql.ResultSet;
import java.sql.Statement;
import com.google.common.collect.*;
import java.util.*;
/**
 * Created by onno on 17-1-2017.
 */
public class ProductQueries {
    DBC dbc = new DBC();
    Statement stat = dbc.Connection();

    public boolean addProduct(String productID, String info, String image, String nameProduct, String price, String categoryName) {
        boolean productAvailibility = true;
        int countExistenceofProduct = 0;
        try {
            String query = ("select productid from Customer where productid = '" + productID + "' ;");
            ResultSet rs = stat.executeQuery(query);
            if (rs.next()) {
                countExistenceofProduct++;
            }
            rs.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }

        if (countExistenceofProduct == 1) {
            productAvailibility = false;
        }

        if (productAvailibility == true) {
            try {
                String query = ("insert into product(productid, info, image ,nameproduct, price, categoryname) values('" + productID + "', '" + info + "', '" + image + "', '" + nameProduct + "', '" + price + "', '" + categoryName + "');");
                stat.executeUpdate(query);
                stat.getConnection().commit();
            } catch (Exception e) {
                System.err.println(e.getClass().getName() + ": " + e.getMessage());
                System.exit(0);

            }
        }
        return productAvailibility;
    }

    public void deleteProduct(String productId){
        try {
            String query = ("DELETE FROM product WHERE productid = '" + productId + "';");
            stat.executeUpdate(query);
            stat.getConnection().commit();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }

    }
    public void alterProduct(String columnName, String newData, String productId){

        try {
            String query = ("UPDATE product SET '"+ columnName + "' = '"+ newData +"' WHERE productid = '"+ productId +"';");
            stat.executeUpdate(query);
            stat.getConnection().commit();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    public boolean addProductCategory(String categoryName, String description) {
        boolean productcategoryAvailibility = true;
        int countExistenceofProductCategory = 0;
        try {
            String query = ("select categoryname from Customer where categoryname = '" + categoryName + "' ;");
            ResultSet rs = stat.executeQuery(query);
            if (rs.next()) {
                countExistenceofProductCategory++;
            }
            rs.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }

        if (countExistenceofProductCategory == 1) {
            productcategoryAvailibility = false;
        }

        if (productcategoryAvailibility == true) {
            try {
                String query = ("insert into productcategory(categoryname, description) values('" + categoryName + "', '" + description + "');");
                stat.executeUpdate(query);
                stat.getConnection().commit();
            } catch (Exception e) {
                System.err.println(e.getClass().getName() + ": " + e.getMessage());
                System.exit(0);

            }
        }
        return productcategoryAvailibility;
    }
    public void deleteProductCategory(String categoryName){
        try {
            String query = ("DELETE FROM productcategory WHERE categoryname = '" + categoryName + "';");
            stat.executeUpdate(query);
            stat.getConnection().commit();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }

    }
    public void alterProductcategory(String columnName, String newData, String categoryName){

        try {
            DBC databasePandaShop = new DBC();
            Statement stat = databasePandaShop.Connection();
            String query = ("UPDATE productcategory SET '"+ columnName + "' = '"+ newData +"' WHERE categoryname = '"+ categoryName +"';");
            stat.executeUpdate(query);
            stat.getConnection().commit();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

}
