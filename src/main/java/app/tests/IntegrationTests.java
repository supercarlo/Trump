package app.tests;

import app.product.ProductDao;
import app.product.Products;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Samuel on 02-02-17.
 */
public class IntegrationTests {

    @Test
    public void loginPost() {
//        LoginController tester = new LoginController();
        Boolean name=true;
        Boolean name2=false;
        String name3="Pieter";
        String name4="class app.product.ProductDao";
        String name5="1";
        // assert statements
//        String result3 = String.valueOf(ProductDao.class);
//        Assert.assertEquals(name4, result3);
        ProductDao.products.add(new Products(name5, name3, name3, name3, name3, name3));
        Products result2 = ProductDao.getProductByID("1");
        //assertEquals(new Products(name5, name3, name3, name3, name3, name3), result2);
        assertEquals(new Products(name5, name3, name3, name3, name3, name3), result2);

    }

}
