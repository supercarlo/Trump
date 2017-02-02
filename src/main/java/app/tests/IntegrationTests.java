package app.tests;

import app.product.ProductDao;
import app.product.Products;
import app.shoppingcart.shoppingcartDAO;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Samuel on 02-02-17.
 */
public class IntegrationTests {

    @Test
    public void loginPost() {
        String name1="1";
        String name2="Pieter";
        ProductDao.products.add(new Products(name1, name2, name2, name2, name2, name2));
        Products result2 = ProductDao.getProductByID("1");
        Assert.assertEquals(new Products(name1, name2, name2, name2, name2, name2), result2);

    }

    @Test
    public void shoppingCartTest() {
        String name5="onno";
        String result3 = shoppingcartDAO.addProductToCart(name5);
        Assert.assertEquals(name5, result3);

    }



}
