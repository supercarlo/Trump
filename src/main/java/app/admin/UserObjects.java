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
    String birthdate;
    String creditcardinfo;
    String membersince;

    public UserObjects(String usernamecustomer, String passwordcustomer, String userlevel, String firstname, String lastname, String birthdate, String creditcardinfo, String membersince) {
    }

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

    public String getBirthdate() {
        return birthdate;
    }

    public String getCreditcardinfo() {
        return creditcardinfo;
    }

    public String getMembersince() {
        return membersince;
    }
}

