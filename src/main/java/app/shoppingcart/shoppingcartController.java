package app.shoppingcart;

import app.product.Products;
import app.util.Path;
import app.util.ViewUtil;
import spark.Request;
import spark.Response;
import spark.Route;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static app.Application.ProductDao;
import static app.Application.shoppingcartDAO;
import static app.util.JsonUtil.dataToJson;
import static app.util.RequestUtil.clientAcceptsHtml;
import static app.util.RequestUtil.clientAcceptsJson;
import static app.util.RequestUtil.getParamID;

public class shoppingcartController {
    public static Route shoppingCart = (Request request, Response response) -> {
        if (clientAcceptsHtml(request)) {
            HashMap<String, Object> model = new HashMap<>();
            shoppingcartDAO.addProductToCart(getParamID(request));
            model.put("products", shoppingcartDAO.getAllProductsInCart());
            return ViewUtil.render(request, model, Path.Template.SHOPPINGCART);
        }
        return ViewUtil.notAcceptable.handle(request, response);
    };
    public static Route deleteFromShoppingCart = (Request request, Response response) -> {
        if (clientAcceptsHtml(request)) {
            HashMap<String, Object> model = new HashMap<>();
            shoppingcartDAO.deleteProductFromCart();
            model.put("products", shoppingcartDAO.deleteProductFromCart());
            return ViewUtil.render(request, model, Path.Template.SHOPPINGCART);
        }
        return ViewUtil.notAcceptable.handle(request, response);
    };

}
