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

import static app.Application.useradminchangeDAO;
import static app.util.JsonUtil.dataToJson;
import static app.util.RequestUtil.*;
import static app.util.RequestUtil.clientAcceptsJson;
import static app.util.RequestUtil.getParamID;

/**
 * Created by carlo on 09-11-16.
 */
//public class UserChangeController {
//    public static Route userchange = (Request request, Response response) -> {
//        Map<String, Object> model = new HashMap<>();
//        return ViewUtil.render(request, model, Path.Template.USERCHANGE);
//    };
//
//    public static Route userchangepost = (Request request, Response response) -> {
//        Map<String, Object> model = new HashMap<>();
//        return ViewUtil.render(request, model, Path.Template.USERCHANGE);
//    };
//}
public class UserChangeController {
    public static Route getAllUsers = (Request request, Response response) -> {
        if (clientAcceptsHtml(request)) {
            HashMap<String, Object> model = new HashMap<>();
            model.put("Users", useradminchangeDAO.getAllUsers());
            return ViewUtil.render(request, model, Path.Template.USERCHANGES);
        }
        if (clientAcceptsJson(request)) {
            return dataToJson(useradminchangeDAO.getAllUsers());
        }
        return ViewUtil.notAcceptable.handle(request, response);
    };

    public static Route userchangepost = (Request request, Response response) -> {
        if (clientAcceptsHtml(request)) {
            HashMap<String, Object> model = new HashMap<>();
            model.put("admin", useradminchangeDAO.getuserbyUsername(getParamID(request)));
            return ViewUtil.render(request, model, Path.Template.USERCHANGES);
        }
        if (clientAcceptsJson(request)) {
            return dataToJson(useradminchangeDAO.getuserbyUsername(getParamID(request)));
        }
        return ViewUtil.notAcceptable.handle(request, response);
    };
}
