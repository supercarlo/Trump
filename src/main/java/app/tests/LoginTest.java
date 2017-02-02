package app.tests;

/**
 * Created by Samuel on 23-01-17.
 */

import app.login.RegisterController;
import app.login.User;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.assertEquals;

@FixMethodOrder(MethodSorters.JVM)
public class LoginTest {

    //Testing the testing method
    @Test
    public void nameTester() {
        RegisterController tester = new RegisterController();
        Boolean name=true;
        Boolean name2=false;
        String name3="Pieter";
        // assert statements
       Boolean result2 = tester.multiplyString(name);
        assertEquals(name, result2);
        Boolean result3 = tester.multiplyString(name);
        assertEquals(name, result3);
    }

//    @Test
//    public void loginPost() {
////        LoginController tester = new LoginController();
//        Boolean name=true;
//        Boolean name2=false;
//        String name3="Pieter";
//        String name4="class app.product.ProductDao";
//        String name5="1";
//        // assert statements
////        String result3 = String.valueOf(ProductDao.class);
////        Assert.assertEquals(name4, result3);
//        ProductDao.products.add(new Products(name5, name3, name3, name3, name3, name3));
//        Products result2 = ProductDao.getProductByID("1");
//        //assertEquals(new Products(name5, name3, name3, name3, name3, name3), result2);
//        assertEquals(new Products(name5, name3, name3, name3, name3, name3), result2);
////        Boolean result3 = tester.handleLoginPost(name);
////        Assert.assertEquals(name, result3);
//    }

    //Testing the adress queries
    @Test
    public void createAdressTester() {
        User tester = new User();
        String name="2";
        String name2="Toos";
        String name3="Pieter";
        String name4="city";
        // assert statements
        String result = tester.createAdress(name, name2, name3, name, name3);
        assertEquals("insert into adress(adressid, city, postalcode ,street, housenumber) values('"+name+"', '"+name2+"', '"+name3+"', '"+name+"', '"+name3+"');", result);
        String result1 = tester.alterAdress(name4, name2, name3);
        assertEquals("city", result1);
        String result2 = tester.deleteAdress(name);
        assertEquals(name, result2);
    }

    //Testing the user queries
    @Test
    public void createCustomerTester() {
        User tester = new User();
        String name="02-12-2016";
        String name2="Toos";
        String name3="Pieter";
        String name4="userlevel";
        String name5="admin";
        // assert statements
        Boolean result = tester.createCustomer(name3, name2, name3, name2, name3,name,name3,name);
        assertEquals(true, result);
        String result1 = tester.alterCustomer(name4, name2, name3);
        assertEquals("userlevel", result1);
        String result2 = tester.deleteCustomer(name3);
        assertEquals(name3, result2);
//        Boolean Remcodeletteveel = tester.createCustomer(name5, name5, name5, name2, name3,name,name3,name);
//        Assert.assertEquals(true, Remcodeletteveel);
  }

    //Testing the wishlist queries
    @Test
    public void wishlistTester() {
        User tester = new User();
        String name="02-12-2016";
        String name2="Toos";
        String name3="2";
        // assert statements
        String result = tester.addWishproduct(name3, name2, name3);
        assertEquals("insert into wishlistproducts(productid, wishlistid, quantity) values('"+name3+"', '"+name2+"', '"+name3+"');", result);
    }
}
