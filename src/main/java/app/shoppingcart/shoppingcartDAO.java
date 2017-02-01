package app.shoppingcart;

import app.product.ProductDao;
import app.product.Products;
import spark.Request;

import static app.Application.loginController;
import static app.Application.ProductDao;
import java.util.ArrayList;
import java.util.Objects;

public class shoppingcartDAO {
    ArrayList<Products> shoppingcartproducts = new ArrayList<>();

    public Iterable<Products> getAllProductsInCart() {
        return shoppingcartproducts;
    }

    public void addProductToCart(String id) {
        if (id != null) {
            shoppingcartproducts.add(ProductDao.getProductByID(id));
        }
    }
}
