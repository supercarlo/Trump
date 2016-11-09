package app.admin;

import app.DBC;
import app.util.Path;
import app.util.ViewUtil;
import spark.Request;
import spark.Response;
import spark.Route;

import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import static app.util.RequestUtil.getQueryUsername;

/**
 * Created by carlo on 09-11-16.
 */
public class UserChangeController {
    public static Route userchange = (Request request, Response response) -> {
        Map<String, Object> model = new HashMap<>();
        return ViewUtil.render(request, model, Path.Template.USERCHANGE);
    };
}
