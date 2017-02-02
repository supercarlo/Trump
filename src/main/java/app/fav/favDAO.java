package app.fav;

import app.product.Products;

import java.util.ArrayList;

import static app.Application.ProductDao;

/**
 * Created by Remco on 1-2-2017.
 */
public class favDAO {
    ArrayList<Products> fav = new ArrayList<>();

    public Iterable<Products> getAllProductsInFav() {
        return fav;
    }

    public void addProductToFav(String id) {
        if (id != null) {
            fav.add(ProductDao.getProductByID(id));
        }
    }
}
