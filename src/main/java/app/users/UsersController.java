package app.users;

import app.util.Path;
import app.util.ViewUtil;
import spark.Request;
import spark.Response;
import spark.Route;

import java.util.HashMap;
import java.util.Map;

import static app.Application.UserDAO;
import static app.admin.UsersController.selectUsers;
import static app.util.JsonUtil.dataToJson;
import static app.util.RequestUtil.*;
import static app.util.RequestUtil.getQueryUsername;

/**
 * Created by carlo on 30-01-17.
 */
public class UsersController {
    public static Route getAllUsers = (Request request, Response response) -> {
        if (clientAcceptsHtml(request)) {
            HashMap<String, Object> model = new HashMap<>();
            model.put("users", UserDAO.getAllUsers());
            return ViewUtil.render(request, model, Path.Template.USERS);
        }
        if (clientAcceptsJson(request)) {
            return dataToJson(UserDAO.getAllUsers());
        }
        return ViewUtil.notAcceptable.handle(request, response);
    };

    public static Route getOneUser = (Request request, Response response) -> {
        Map<String, Object> model = new HashMap<>();
        request.attribute("alter", request.pathInfo());
        model.put("user", UserDAO.getUsernameByParam(getParamUsername(request)));
        return ViewUtil.render(request, model, Path.Template.USER);
    };

    public static Route deleteUSer = (Request request, Response response) -> {

        if (clientAcceptsHtml(request)) {
            HashMap<String, Object> model = new HashMap<>();

            UserDAO.deleteUser(getParamUsername(request));

            model.put("user", UserDAO.getUsernameByParam(getParamUsername(request)));
            model.put("user", UserDAO.getUsernameByParam(getParamUsername(request)));
            //UserDAO.deleteUser(getParamUsername(request));

            return ViewUtil.render(request, model, Path.Template.USER);
        }
        if (clientAcceptsJson(request)) {
            return dataToJson(UserDAO.getUsernameByParam(getParamUsername(request)));
        }
        return ViewUtil.notAcceptable.handle(request, response);
    };

    public static Route alterUser = (Request request, Response response) -> {

        if (clientAcceptsHtml(request)) {
            HashMap<String, Object> model = new HashMap<>();
            model.put("user", UserDAO.getUsernameByParam(getParamUsername(request)));
            return ViewUtil.render(request, model, Path.Template.ALTERUSER);
        }
        if (clientAcceptsJson(request)) {
            return dataToJson(UserDAO.getUsernameByParam(getParamUsername(request)));
        }
        return ViewUtil.notAcceptable.handle(request, response);
    };
}
