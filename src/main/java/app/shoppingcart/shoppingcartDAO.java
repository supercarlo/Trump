package app.shoppingcart;

import app.product.Products;

import java.util.ArrayList;

public class shoppingcartDAO {
    public ArrayList<Products> shoppingcartproducts = new ArrayList<>();

    public Iterable<Products> getAllProductsInCart() {
        return shoppingcartproducts;
    }

    public String addProductToCart(String id) {
        if (id != null) {
            shoppingcartproducts.add(app.product.ProductDao.getProductByID(id));
        }
        return id;
    }

    public Iterable<Products> deleteProductFromCart() {
        shoppingcartproducts.clear();
        return shoppingcartproducts;
    }
}
