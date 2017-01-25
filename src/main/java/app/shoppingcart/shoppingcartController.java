package app.shoppingcart;

/**
 * Created by onno on 25-1-2017.
 */
import app.util.Path;
import app.util.ViewUtil;
import spark.Request;
import spark.Response;
import spark.Route;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by onno on 19-1-2017.
 */
public class shoppingcartController {
    public static Route shoppingCart = (Request request, Response response) -> {
        Map<String, Object> model = new HashMap<>();
        return ViewUtil.render(request, model, Path.Template.INDEX);
    };
}