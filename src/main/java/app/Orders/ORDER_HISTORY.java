package app.Orders;

import app.DBC;

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
            String query = ("Select orderid from orders_history_customer_junctiontable2 where usernamecustomer = " + usernamecustomer + ";");
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
                String query = ("SELECT * from order_history2 where orderid = " + orderidlist.get(i));
                ResultSet rs = stat.executeQuery(query);
                ArrayList myList3 = new ArrayList();
                while (rs.next()) {
                    ArrayList myList2 = new ArrayList();
                    //myList2.add(Integer.toString(rs.getInt("orderid")));
                    myList2.add(Integer.toString(rs.getInt("poduct_id")));
                    myList2.add(Double.toString(rs.getDouble("price")));
                    myList2.add(Integer.toString(rs.getInt("quantity")));
                    myList3.add(myList2);
                }
                rs.close();
                myList.add(myList3);
            }
            return myList;
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
            return myList;
        }
    }

    public String GenerateHTMLTable(List orderidlist, List orderslist) {
        String TotalHTML = "";
        String Header = "<table id=\"myTable\"> <tr> <th>Product Id</th> <th>Product Name</th> <th>Price</th> <th>Quantity</th> <th>Total Price</th> </tr>";
        for (int i = 0; i < orderidlist.size(); i++) {

            TotalHTML += "<b>ORDER: " + orderidlist.get(i) + "</b> <br>";
            TotalHTML += Header;
            ArrayList temp = (ArrayList) orderslist.get(i);
            for (int j = 0; j < temp.size(); j++) {
                ArrayList temp2 = (ArrayList) temp.get(j);

                TotalHTML += "<tr>\n" +
                        "    <td>" + temp2.get(0) + "</td>\n" +
                        "    <td> " +GetProductName(Integer.valueOf((String)temp2.get(0))) + "</td>\n" +
                        "    <td>" + temp2.get(1) + "</td>\n" +
                        "    <td>" + temp2.get(2) + "</td>\n" +
                        "    <td>" + (Double.valueOf((String) temp2.get(1)) * (Double.valueOf((String) temp2.get(2)))) + "</td>\n" +
                        "  </tr>";
            }
            TotalHTML += "</table><br><br><br>";


        }

        return TotalHTML;


    }

    public String GetProductName(int ID) {
        DBC databasePandaShop = new DBC();
        Statement stat = databasePandaShop.Connection();
        String returnstatement = "";
        try {
            String query = ("Select nameproduct from product where productid =" + ID + ";");
            ResultSet rs = stat.executeQuery(query);
            while (rs.next()) {
                returnstatement += rs.getString("nameproduct");
            }
            rs.close();
            return returnstatement;
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
            return returnstatement;
        }

    }
}