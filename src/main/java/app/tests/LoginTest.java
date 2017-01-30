package app.tests;

/**
 * Created by Samuel on 23-01-17.
 */

import app.login.User;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
@FixMethodOrder(MethodSorters.JVM)
public class LoginTest {

    @Test
    public void nameTester() {
//        RegisterController tester = new RegisterController();
        Boolean name=true;
        String name2="Toos";
        String name3="Pieter";
        // assert statements
//        String result2 = tester.multiplyString(name);
//        assertEquals(name, result2);
//        String result3 = tester.multiplyString(name2);
//        assertEquals(name2, result3);
//        String result4 = tester.multiplyString(name3);
//        assertEquals(name3, result4);
//        String result = tester.multiplyString("name");
//        assertEquals("name", result);
//        Boolean result0 = RegisterController.multiplyString(true);
//        assertEquals(true, result0);
    }

    @Test
    public void createAdressTester() {
        User tester = new User();
        String name="2";
        String name2="Toos";
        String name3="Pieter";
        String name4="city";
        // assert statements
//        String result = tester.createAdress(name, name2, name3, name, name3);
//        assertEquals("insert into adress(usernamecustomer, city, postalcode ,street, housenumber) values('"+name+"', '"+name2+"', '"+name3+"', '"+name+"', '"+name3+"');", result);
//        String result1 = tester.alterAdress(name4, name2, name3);
//        assertEquals("city", result1);
//        String result2 = tester.deleteAdress(name);
//        assertEquals(name, result2);
    }

    @Test
    public void createCustomerTester() {
        User tester = new User();
        String name="02-12-2016";
        String name2="Toos";
        String name3="Pieter";
        String name4="userlevel";
        // assert statements
//        Boolean result = tester.createCustomer(name3, name2, name3, name2, name3,name,name3,name);
//        assertEquals(true, result);
//        String result1 = tester.alterCustomer(name4, name2, name3);
//        assertEquals("userlevel", result1);
//        String result2 = tester.deleteCustomer(name3);
//        assertEquals(name3, result2);
  }

    @Test
    public void wishlistTester() {
        User tester = new User();
        String name="02-12-2016";
        String name2="Toos";
        String name3="2";
        // assert statements
//        String result = tester.addWishproduct(name3, name2, name3);
//        assertEquals("insert into wishlistproducts(productid, wishlistid, quantity) values('"+name3+"', '"+name2+"', '"+name3+"');", result);
    }
}
