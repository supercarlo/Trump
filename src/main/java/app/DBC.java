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
//            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Fietsdief","123", "123");
            c = DriverManager.getConnection("jdbc:postgresql://83.86.251.189:5432/postgres","postgres", "postgres");
            c.setAutoCommit(false);
            stat = c.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return stat;
    }
}