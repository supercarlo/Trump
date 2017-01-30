package app.login;

import app.user.UserController;
import app.util.Path;
import app.util.ViewUtil;
import spark.Request;
import spark.Response;
import spark.Route;

import java.util.HashMap;
import java.util.Map;

import static app.util.RequestUtil.removeSessionAttrLoggedOut;
import static app.util.RequestUtil.removeSessionAttrLoginRedirect;

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
//            app.login.User login
            request.session().attribute("currentUser", username);
            model.put("authenticationSucceeded", true);
            model.put("asUser", true);
            model.put("username", username);
            response.redirect(Path.Web.PRODUCTS);
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

//    public String getUserSession() {
//        return
//    };

    public static Route handleLogoutPost = (Request request, Response response) -> {
        request.session().removeAttribute("currentUser");
        request.session().attribute("loggedOut", true);
        response.redirect(Path.Web.LOGIN);
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
