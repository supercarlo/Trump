package app.admin;

import java.util.Date;

/**
 * Created by onno on 27-1-2017.
 */

public class UserObjects {
    String usernamecustomer;
    String passwordcustomer;
    String userlevel;
    String firstname;
    String lastname;
    Date birthdate;
    String creditcardinfo;
    Date membersince;


    public String getUsernamecustomer() {
        return usernamecustomer;
    }

    public String getPasswordcustomer() {
        return passwordcustomer;
    }

    public String getUserlevel() {
        return userlevel;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public String getCreditcardinfo() {
        return creditcardinfo;
    }

    public Date getMembersince() {
        return membersince;
    }
}

