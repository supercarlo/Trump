package app.fav;

import app.DBC;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wrket on 26-Jan-17.
 */
public class Fav {


    public List GetFAV(String usernamecustomer) {
        DBC databasePandaShop = new DBC();
        Statement stat = databasePandaShop.Connection();
        List myList = new ArrayList();
        try {
            String query = ("SElect p.nameproduct from product p, favourites f where f.customername = " + usernamecustomer + " and f.product_id = p.productid;");
            ResultSet rs = stat.executeQuery(query);
            while (rs.next()) {
                myList.add(rs.getString("nameproduct"));
            }
            rs.close();
            return myList;
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
            return myList;
        }
    }


    public String GenerateHTMLTable(List favoutiteslist) {
        String TotalHTML = "";
        String Header = "<table id=\"myTable\"> <tr> <th> Products</th>";
        TotalHTML+=Header;
        for (int i = 0; i < favoutiteslist.size(); i++) {
            TotalHTML += "<tr>\n" +
                    "    <td>" + favoutiteslist.get(i) + "</td>\n" +
                    "  </tr>";
        }
        TotalHTML += "</table><br><br><br>";

        return  TotalHTML;
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