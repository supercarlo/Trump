package app.login;

import app.util.Path;
import app.util.ViewUtil;
import spark.Request;
import spark.Response;
import spark.Route;

import java.util.HashMap;
import java.util.Map;

import static app.Application.bookDao;
import static app.Application.userDao;

/**
 * Created by carlo on 08-11-16.
 */
public class RegisterController {
    public static Route register = (Request request, Response response) -> {
        Map<String, Object> model = new HashMap<>();
        return ViewUtil.render(request, model, Path.Template.REGISTER);
    };
}