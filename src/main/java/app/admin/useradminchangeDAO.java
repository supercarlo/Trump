package app.admin;

import app.DBC;
import app.admin.UserObjects;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.*;

/**
 * Created by onno on 27-1-2017.
 */
public class useradminchangeDAO {
        UserObjects u;
        DBC dbc = new DBC();
        Statement stat = dbc.Connection();

        public List<UserObjects> users = new ArrayList<>();

        public void addAllUsers() {
            try {
                String query = ("select usernamcustomer, passwordcustomer, userlevel, firstname, lastname, birthdate, creditcardinfo, membersince from customer");
                stat.getConnection().commit();
                ResultSet rs = stat.executeQuery(query);

                while (rs.next()) {
                    users.add(new UserObjects(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6),rs.getString(7),rs.getString(8)));
                }
            } catch (Exception e) {
                System.out.println("Error");
            }
        }

        public Iterable<UserObjects> getAllUsers() {
            users.clear();
            addAllUsers();
            return users;
        }

        public UserObjects getuserbyUsername(String usernamecustomer) {
            if (usernamecustomer == null) {
                u = null;
            }else if (users.iterator().hasNext()) {
                u = users.get(Integer.valueOf(usernamecustomer)-1);
            } else if (!users.iterator().hasNext()) {
                u = users.get(users.size() - 1);
            }
            return u;
        }
}


