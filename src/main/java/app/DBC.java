package app;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DBC {
    public Statement Connection() {
        Connection c = null;
        Statement stat = null;
        //Connection
        try {
            //Driver name + credentials + ip address check.
            Class.forName("org.postgresql.Driver");
<<<<<<< HEAD
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/pandaWebShop", "postgres","");
=======
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "123", "123");
>>>>>>> origin/master
            c.setAutoCommit(false);
            stat = c.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return stat;
    }
}