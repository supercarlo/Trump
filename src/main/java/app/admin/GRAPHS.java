package app.admin;

import app.DBC;

import java.sql.Array;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by wrket on 19-Jan-17.
 */
public class GRAPHS {



    public int CreationsPerYear(String year, String monthnumber){
        DBC databasePandaShop = new DBC();
        Statement stat = databasePandaShop.Connection();
        int returnstatement = 0;
        try {
            String query = ("SELECT count(*) as CREATIONS from customer where date_part('month', membersince)=" +   monthnumber + "AND date_part('year', membersince)= " + year + ";");
            ResultSet rs = stat.executeQuery(query);
            if (rs.next()) {
                returnstatement = rs.getInt("CREATIONS");
            }
            rs.close();
            return returnstatement;
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
            return 0;
        }
    }

    public String TypeOfproductdataPoints(){
        DBC databasePandaShop = new DBC();
        Statement stat = databasePandaShop.Connection();
        String returnstatement = "[";

        try {
            String query = ("select categoryname, count(*) as counttypes from product group by categoryname;");
            ResultSet rs = stat.executeQuery(query);
            while (rs.next()) {
                int amount = (rs.getInt("counttypes"));
                String label = rs.getString("categoryname");
                returnstatement += "{ y:" + amount+", legendText:\""+ label + "\", indexLabel:\""+ label + "\"},";

            }
            returnstatement +="]";
            rs.close();
            return returnstatement;

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
            return null;
            //return Array array = new Array[0,0];
        }
    }
    public String ProductOrderAmountDataPoints(){
        DBC databasePandaShop = new DBC();
        Statement stat = databasePandaShop.Connection();
        String returnstatement = "[";

        try {
            String query = ("select nameproduct, count(nameproduct) as amountordered from orders group by nameproduct;");
            ResultSet rs = stat.executeQuery(query);
            while (rs.next()) {
                int amount = (rs.getInt("amountordered"));
                String label = rs.getString("nameproduct");
                returnstatement += "{ label:\"" + label +"\",  y:"+  amount +"  },";

            }
            returnstatement +="]";
            rs.close();
            return returnstatement;

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
            return null;
            //return Array array = new Array[0,0];
        }
    }
}
