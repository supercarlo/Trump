package app.shoppingcart;

import app.product.ProductDao;
import app.product.Products;
import static app.Application.ProductDao;
import java.util.ArrayList;

public class shoppingcartDAO {
    Products p;
    ArrayList<Products> shoppingcartproducts = new ArrayList<>();

    public Iterable<Products> getAllProductsInCart() {
        return shoppingcartproducts;
    }

    public void addProductToCart(String id) {
//        System.out.println(id);
//        shoppingcartproducts.add(ProductDao.products.get(Integer.valueOf(id)));
        shoppingcartproducts.add(ProductDao.getProductByID(id));
    }
}
