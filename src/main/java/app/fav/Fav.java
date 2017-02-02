package app.fav;

import app.DBC;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static app.util.Path.Web.FAV;

/**
 * Created by wrket on 26-Jan-17.
 */
public class Fav {


    public List GetFAV(String usernamecustomer) {
        DBC databasePandaShop = new DBC();
        Statement stat = databasePandaShop.Connection();
        List myList = new ArrayList();
        try {
            String query = ("SElect p.nameproduct,p.productid from product p, favourites2 f where f.customername = " + usernamecustomer + " and f.product_id = p.productid;");
            ResultSet rs = stat.executeQuery(query);
            while (rs.next()) {
                List myList2 = new ArrayList();
                myList2.add(rs.getInt("productid"));
                myList2.add(rs.getString("nameproduct"));
                myList.add(myList2);
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
        String Header = "<table id=\"myTable\"> <tr> <th> Products</th><th> Delete</th>";
        TotalHTML += Header;
        for (int i = 0; i < favoutiteslist.size(); i++) {
            ArrayList temp=  (ArrayList)favoutiteslist.get(i);
            TotalHTML += "<tr>\n" +
                    "    <td>" + temp.get(1) +  "</td><td> <a href=\""+  FAV + "?iddelete=" + temp.get(0)  + "\"> <img src=\"https://www.bouwbakkie.nl/img/delete.png\" alt=\"HTML tutorial\" style=\"width:16px;height:16px;border:0;\"></a></td>"
                    + "  </tr>";
        }
        TotalHTML += "</table><br><br><br>";

        return TotalHTML;
    }

    public void AddFav(String Username, Integer product_id) {
        DBC databasePandaShop = new DBC();
        Statement stat = databasePandaShop.Connection();
        try {
            int already_exist = 0;
            String query = ("SELECT count(*) as counted from  favourites2 where customername = '" + Username + "' AND product_id =" + product_id + ";");
            ResultSet rs = stat.executeQuery(query);
            while (rs.next()) {
                already_exist = (rs.getInt("counted"));
            }
            if (already_exist == 0){
                stat.executeUpdate("INSERT INTO favourites2 (customername, product_id)\n" +
                        "VALUES ('" +
                        Username + "', " + product_id + "); ");
                stat.getConnection().commit();
                stat.close();
            }


        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);

        }
    }

    public void DeleteFav(String Username, Integer product_id) {
        DBC databasePandaShop = new DBC();
        Statement stat = databasePandaShop.Connection();
        try {
            stat.executeUpdate("DELETE From favourites2  where customername = '" +Username+ "' and product_id = "+ product_id +";");
            stat.getConnection().commit();
            stat.close();

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);

        }
    }
}
