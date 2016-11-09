package app.login;

import app.DBC;
import app.user.*;
import app.util.*;
import spark.*;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;
import static app.util.RequestUtil.*;

public class LoginController {
    public static Route serveLoginPage = (Request request, Response response) -> {
        Map<String, Object> model = new HashMap<>();
        model.put("loggedOut", removeSessionAttrLoggedOut(request));
        model.put("loginRedirect", removeSessionAttrLoginRedirect(request));
        return ViewUtil.render(request, model, Path.Template.LOGIN);
    };

    public static Route handleLoginPost = (Request request, Response response) -> {
        Map<String, Object> model = new HashMap<>();
        UserController userController = new UserController();
        String username = request.queryParams("username");
        String password = request.queryParams("password");
        int level = userController.login(username, password);

        if (level == 2) {
//            User login
            request.session().attribute("currentUser", username);
            model.put("authenticationSucceeded", true);
            model.put("asUser", true);
            model.put("username", username);
            response.redirect(Path.Web.CUSTOMERHOME);
        } else if (level == 3) {
//            Admin login
            request.session().attribute("currentUser", username);
            model.put("asAdmin", true);
            model.put("authenticationSucceeded", true);
            model.put("username", username);
            response.redirect(Path.Web.ADMINHOME);
        } else {
            model.put("authenticationFailed", true);
        }
        return ViewUtil.render(request, model, Path.Template.LOGIN);
    };

//        if (!UserController.authenticate(getQueryUsername(request), getQueryPassword(request))) {
//            model.put("authenticationFailed", true);
//            return ViewUtil.render(request, model, Path.Template.LOGIN);
//        }
//        model.put("authenticationSucceeded", true);
//        request.session().attribute("currentUser", getQueryUsername(request));
//        if (getQueryLoginRedirect(request) != null) {
//            response.redirect(getQueryLoginRedirect(request));
//        }
//        return ViewUtil.render(request, model, Path.Template.LOGIN);
//    };

    public static Route handleLogoutPost = (Request request, Response response) -> {
        request.session().removeAttribute("currentUser");
        request.session().attribute("loggedOut", true);
        response.redirect(Path.Web.INDEX);
        return null;
    };

    // The origin of the request (request.pathInfo()) is saved in the session so
    // the user can be redirected back after login
    public static void ensureUserIsLoggedIn(Request request, Response response) {
        if (request.session().attribute("currentUser") == null) {
            request.session().attribute("loginRedirect", request.pathInfo());
            response.redirect(Path.Web.LOGIN);
        }
    };

}
