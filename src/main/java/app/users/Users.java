package app.users;

/**
 * Created by carlo on 30-01-17.
 */
public class Users {
    public Users(String usernamecustomer, String passwordcustomer, String userlevel, String firstname, String lastname, String birthdate, String creditcardinfo, String membersince) {
        this.usernamecustomer = usernamecustomer;
        this.passwordcustomer = passwordcustomer;
        this.userlevel = userlevel;
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthdate = birthdate;
        this.creditcardinfo = creditcardinfo;
        this.membersince = membersince;
    }

    String usernamecustomer;
    String passwordcustomer;
    String userlevel;
    String firstname;
    String lastname;
    String birthdate;
    String creditcardinfo;
    String membersince;

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
