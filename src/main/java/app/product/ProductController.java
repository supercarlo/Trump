package app.product;

import app.fav.Fav;
import app.util.Path;
import app.util.ViewUtil;
import spark.Request;
import spark.Response;
import spark.Route;

import java.util.HashMap;
import java.util.Map;

import static app.Application.ProductDao;
import static app.util.JsonUtil.dataToJson;
import static app.util.RequestUtil.*;

/**
 * Created by carlo on 23-01-17.
 */
public class ProductController {
    public static Route getAllProducts = (Request request, Response response) -> {
        if (clientAcceptsHtml(request)) {
            HashMap<String, Object> model = new HashMap<>();
            Fav fav = new Fav();
            model.put("fav", fav);
            model.put("products", ProductDao.getAllProducts());
            return ViewUtil.render(request, model, Path.Template.PRODUCTS);
        }
        if (clientAcceptsJson(request)) {
            return dataToJson(ProductDao.getAllProducts());
        }
        return ViewUtil.notAcceptable.handle(request, response);
    };

    public static Route getOneProduct = (Request request, Response response) -> {
        if (clientAcceptsHtml(request)) {
            HashMap<String, Object> model = new HashMap<>();
            Fav fav = new Fav();
            model.put("fav", fav);
            model.put("username", request.session().attribute("currentUser"));
            model.put("product", ProductDao.getProductByID(getParamID(request)));
            return ViewUtil.render(request, model, Path.Template.PRODUCT);
        }
        if (clientAcceptsJson(request)) {
            return dataToJson(ProductDao.getProductByID(getParamID(request)));
        }
        return ViewUtil.notAcceptable.handle(request, response);
    };
}