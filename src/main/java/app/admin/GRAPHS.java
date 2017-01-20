package app.admin;

import app.DBC;

import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by wrket on 19-Jan-17.
 */
public class GRAPHS {
    public int CreationsPerYear(String year, String monthnumber){
        DBC databasePandaShop = new DBC();
        Statement stat = databasePandaShop.Connection();

        try {
            String query = ("SELECT count(*) as CREATIONS from customer where date_part('month', membersince)=" +   monthnumber + "AND date_part('year', membersince)= " + year + ";");
            ResultSet rs = stat.executeQuery(query);
            if (rs.next()) {
                return rs.getInt("CREATIONS");
            }
            rs.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
            return 0;
        }
        return 0;
    }
}
