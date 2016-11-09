package app.login;

import app.util.Path;
import app.util.ViewUtil;
import spark.Request;
import spark.Response;
import spark.Route;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by carlo on 08-11-16.
 */
public class CustomerHomeController {
    public static Route customerhome = (Request request, Response response) -> {
        Map<String, Object> model = new HashMap<>();
        return ViewUtil.render(request, model, Path.Template.CUSTOMERHOME);
    };
}

