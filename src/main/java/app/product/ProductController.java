package app.product;

import app.DBC;
import app.util.Path;
import app.util.ViewUtil;
import spark.Request;
import spark.Response;
import spark.Route;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Samuel on 16-01-17.
 */
public class ProductController {
    public static Route products = (Request request, Response response) -> {
        Map<String, Object> model = new HashMap<>();

        DBC dbc = new DBC();
        Statement stat = dbc.Connection();

        try {
            String query = ("select productid, info, image, nameproduct, price, categoryname from product");
            stat.getConnection().commit();
            ResultSet rs = stat.executeQuery(query);
            ArrayList<String> listOfProductsID = new ArrayList<String>();
            ArrayList<String> listOfProductsInfo = new ArrayList<String>();
            ArrayList<String> listOfProductsImage = new ArrayList<String>();
            ArrayList<String> listOfProductsName = new ArrayList<String>();
            ArrayList<String> listOfProductsPrice = new ArrayList<String>();
            ArrayList<String> listOfProductsCategory = new ArrayList<String>();

            while (rs.next()) {
                listOfProductsID.add(rs.getString(1));
                listOfProductsInfo.add(rs.getString(2));
                listOfProductsImage.add(rs.getString(3));
                listOfProductsName.add(rs.getString(4));
                listOfProductsPrice.add(rs.getString(5));
                listOfProductsCategory.add(rs.getString(6));

                model.put("listOfProductsID", listOfProductsID);
                model.put("listOfProductsInfo", listOfProductsInfo);
                model.put("listOfProductsImage", listOfProductsImage);
                model.put("listOfProductsName", listOfProductsName);
                model.put("listOfProductsPrice", listOfProductsPrice);
                model.put("listOfProductsCategory", listOfProductsCategory);
            }
        } catch (Exception e) {
            System.out.println("Error");
        }
        return ViewUtil.render(request, model, Path.Template.PRODUCTS);
    };

//    public static ArrayList<String> selectProducts() throws SQLException {
//        DBC dbc = new DBC();
//        Statement stat = dbc.Connection();
//        ArrayList<String> listOfProductsData = null;
//
//        try {
//            String query = ("select productid, info, image, nameproduct, price, categoryname from product");
//            stat.getConnection().commit();
//            ResultSet rs = stat.executeQuery(query);
//            listOfProductsData = new ArrayList<String>();
//            while (rs.next()) {
//                String productid = rs.getString(0);
//                String info = rs.getString(1);
//                String image = rs.getString(2);
//                String nameproduct = rs.getString(3);
//                String price = rs.getString(4);
//                String category = rs.getString(5);
//
//                listOfProductsData.add(productid);
//                listOfProductsData.add(info);
//                listOfProductsData.add(image);
//                listOfProductsData.add(nameproduct);
//                listOfProductsData.add(price);
//                listOfProductsData.add(category);
//            }
//        } catch (Exception e) {
//            System.out.println("Error");
//        }
//        return listOfProductsData;
//
//
//    }

}