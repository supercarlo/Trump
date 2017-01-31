package app.admin;

import app.DBC;
import app.product.Products;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by onno on 27-1-2017.
 */
public class UseradminchangeDAO {
        UserObjects u;
        DBC dbc = new DBC();
        Statement stat = dbc.Connection();

        public List<UserObjects> users = new ArrayList<>();

        public void addAllUsers() {
            try {
                String query = ("select usernamecustomer, passwordcustomer, userlevel, firstname, lastname, birthdate, creditcardinfo, membersince from customer");
                stat.getConnection().commit();
                ResultSet rs = stat.executeQuery(query);

                while (rs.next()) {
                    users.add(new UserObjects(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getDate(6),rs.getString(7),rs.getDate(8)));
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
            if (users.iterator().hasNext()) {
                u = users.get(Integer.valueOf(usernamecustomer)-1);
            } else {
                u = users.get(users.size()-1);
            }
            return u;
        }
}


