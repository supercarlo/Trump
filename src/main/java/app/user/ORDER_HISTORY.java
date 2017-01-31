package app.user;

import app.DBC;

import java.sql.Array;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wrket on 26-Jan-17.
 */
public class ORDER_HISTORY {


    public List GetOrderIDs(String usernamecustomer) {
        DBC databasePandaShop = new DBC();
        Statement stat = databasePandaShop.Connection();
        List myList = new ArrayList();
        try {
            String query = ("Select orderid from orders_history_customer_junctiontable where usernamecustomer = " + usernamecustomer + ";" );
            ResultSet rs = stat.executeQuery(query);
            while (rs.next()) {
                myList.add(rs.getInt("orderid"));
            }
            rs.close();
            return myList;
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
            return myList;
        }
    }
    public ArrayList ShowOrderHistory(List orderidlist) {
        DBC databasePandaShop = new DBC();
        Statement stat = databasePandaShop.Connection();
        ArrayList myList = new ArrayList();
        try {
            for (int i = 0; i < orderidlist.size(); i++) {
                String query = ("SELECT * from orders_history where orderid = " + orderidlist.get(i));
                ResultSet rs = stat.executeQuery(query);
                while (rs.next()) {
                    ArrayList myList2 = new ArrayList();
                    myList2.add(Integer.toString(rs.getInt("orderid")));
                    myList2.add(Integer.toString(rs.getInt("poduct_id")));
                    myList2.add(Double.toString(rs.getDouble("price")));
                    myList2.add(Integer.toString(rs.getInt("quantity")));
                    myList.add(myList2);
                }
                rs.close();

            }
            return myList;
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
            return myList;
        }
    }
    public String GenerateHTMLTable(List orderlist) {
        String Header = "<table>\n" +
                "  <tr>\n" +
                "    <th>Product Id</th>\n" +
                "    <th>Product Name</th>\n" +
                "    <th>Price</th>\n" +
                "    <th>Quantity</th>\n" +
                "    <th>Total Price</th>\n" +
                "  </tr>";

        




    }
}