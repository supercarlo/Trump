package app.users;

import app.DBC;


import javax.swing.*;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by carlo on 30-01-17.
 */
public class UsersDAO {
    Users u;
    DBC dbc = new DBC();
    Statement stat = dbc.Connection();

    public List<Users> users = new ArrayList<>();

    public void addAllUsers() {
        try {
            String query = ("select usernamecustomer, passwordcustomer, userlevel, firstname, lastname, birthdate, creditcardinfo, membersince from customer");
            stat.getConnection().commit();
            ResultSet rs = stat.executeQuery(query);

            while (rs.next()) {
                users.add(new Users(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6),rs.getString(7),rs.getString(8)));
            }
        } catch (Exception e) {
            System.out.println("Error");
        }
    }

    public Iterable<Users> getAllUsers() {
        users.clear();
        addAllUsers();
        return users;
    }

    public Users getUsernameByParam(String usernamecustomer) {
        return users.stream().filter(u -> u.getUsernamecustomer().equals(usernamecustomer)).findFirst().orElse(null);
    }

    public void updateUser(String usernamecustomer) {
    }

    public void deleteUserqueries(String usernamecustomer) {
        DBC dbc = new DBC();
        Statement stat = dbc.Connection();
        try {
            //Statement stat = dbc.Connection();
            int result = stat.executeUpdate("delete from customer where usernamecustomer = '"+usernamecustomer+"'" );
            stat.getConnection().commit();

            if(result!=1){
                JOptionPane.showMessageDialog(null,"No record exists related to "+usernamecustomer);
            }
            //stat.getConnection().commit();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }
}