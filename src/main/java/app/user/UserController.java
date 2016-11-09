package app.user;

import app.DBC;
import org.mindrot.jbcrypt.*;

import java.sql.ResultSet;
import java.sql.Statement;

public class UserController {
    DBC dbc = new DBC();
    Statement stat = dbc.Connection();

    public Integer login(String customerUsername, String customerPassword) {
        int countExistenceofUsername = 0;
        int countExistenceofPassword = 0;
        int countExistenceofadmin = 0;
        int existence = 0;

        try {
            String query = ("select usernamecustomer from Customer where usernamecustomer = '" + customerUsername + "' ;");
            ResultSet rs = stat.executeQuery(query);

            if (rs.next()) {
                countExistenceofUsername ++; }
            rs.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }

        if (countExistenceofUsername == 1) {
            try {
                String query = ("select passwordcustomer from Customer where usernamecustomer = '" + customerUsername + "'  and passwordcustomer = '" + customerPassword + "' ;");
                ResultSet rs = stat.executeQuery(query);

                if(rs.next()) {
                    countExistenceofPassword ++; }
                rs.close();
            } catch (Exception e) {
                System.err.println(e.getClass().getName() + ": " + e.getMessage());
                System.exit(0);
            }
        }

        if (countExistenceofPassword == 1) {
            try {
                String query = ("select userlevel from Customer where usernamecustomer = '" + customerUsername + "' and userlevel = 'admin';");
                ResultSet rs = stat.executeQuery(query);

                if (rs.next()) {
                    countExistenceofadmin ++; }
                rs.close();
            } catch (Exception e) {
                System.err.println(e.getClass().getName() + ": " + e.getMessage());
                System.exit(0);
            }
        }
        existence = countExistenceofUsername + countExistenceofPassword + countExistenceofadmin;
        return existence;
    }
}

    // Authenticate the user by hashing the inputted password using the stored salt,
    // then comparing the generated hashed password to the stored hashed password
//    public static boolean authenticate(String username, String password) {
//        if (username.isEmpty() || password.isEmpty()) {
//            return false;
//        }
//        User user = userDao.getUserByUsername(username);
//        if (user == null) {
//            return false;
//        }
//        String hashedPassword = BCrypt.hashpw(password, user.getSalt());
//        return hashedPassword.equals(user.getHashedPassword());
//    }
//
//    // This method doesn't do anything, it's just included as an example
//    public static void setPassword(String username, String oldPassword, String newPassword) {
//        if (authenticate(username, oldPassword)) {
//            String newSalt = BCrypt.gensalt();
//            String newHashedPassword = BCrypt.hashpw(newSalt, newPassword);
//            // Update the user salt and password
//        }
//    }
//}
