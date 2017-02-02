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

    public static Route purchasepost = (Request request, Response response) -> {
//        System.out.println("joe");
        Map<String, Object> model = new HashMap<>();
        //System.out.println(shoppingcartDAO.purchaseProductByID());
        String usernamecustomer = request.session().attribute("currentUser");

        shoppingcartDAO.purchaseProductByID(usernamecustomer);
        String productid = request.queryParams("productid");
        String price = request.queryParams("price");

//        String nameproduct = request.queryParams("password");
//        String price = request.queryParams("birthyear");
//        String categoryname = request.queryParams("birthmonth");
//        System.out.println(productid);
//        System.out.println(price);
//        System.out.println(usernamecustomer);

        return ViewUtil.render(request, model, Path.Template.INDEX);
    };

}
