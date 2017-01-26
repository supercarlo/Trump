package app.user;

import app.DBC;

import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by wrket on 26-Jan-17.
 */
public class ORDER_HISTORY {


    public String ShowOrderHistory(String usernamecustomer) {
        DBC databasePandaShop = new DBC();
        Statement stat = databasePandaShop.Connection();
        String returnstatement = "";
        try {
            String query = ("SELECT oh.* from orders_history oh, orders_history_customer_junctiontable ohcj where ohcj.usernamecustomer =" + usernamecustomer + "AND ohcj.orderid = oh.orderid;");
            ResultSet rs = stat.executeQuery(query);
            while (rs.next()) {
                returnstatement+= Integer.toString(rs.getInt("orderid")) + "     ";
                returnstatement+= Integer.toString(rs.getInt("poduct_id")) + "     ";
                returnstatement+= Double.toString(rs.getDouble("price")) + "        ";
                returnstatement+= Integer.toString(rs.getInt("quantity")) + "<br>";
            }
            rs.close();
            return returnstatement;
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
            return "";
        }
    }
}