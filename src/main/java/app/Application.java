package app;

import app.admin.UserChangeController;
import app.admin.UserDeleteController;
import app.admin.UsersController;
import app.book.Panda1;
import app.index.IndexController;
import app.login.*;
import app.product.ProductController;
import app.util.Filters;
import app.util.Path;
import app.util.ViewUtil;

import static spark.Spark.*;
import static spark.debug.DebugScreen.enableDebugScreen;

public class Application {

    // Declare dependencies
    public static void main(String[] args) {

        // Instantiate your dependencies
        // Configure Spark
        port(4567);
        staticFiles.location("/public");
        staticFiles.expireTime(600L);
        enableDebugScreen();

        // Set up before-filters (called before each get/post)
        before("*",                  Filters.addTrailingSlashes);
        before("*",                  Filters.handleLocaleChange);

        // Set up routes
        get(Path.Web.INDEX,          IndexController.serveIndexPage);
        get(Path.Web.CUSTOMERHOME,   CustomerHomeController.customerhome);
        get(Path.Web.ADMINHOME,      AdminHomeController.adminhome);
        post(Path.Web.ADMINHOME,     AdminHomeController.adminhomepost);
        get(Path.Web.REGISTER,       RegisterController.register);
        post(Path.Web.REGISTER,      RegisterController.registerpost);
        get(Path.Web.USERS,          UsersController.users);
        post(Path.Web.USERS,         UsersController.userspost);
        get(Path.Web.LOGIN,          LoginController.serveLoginPage);
        post(Path.Web.LOGIN,         LoginController.handleLoginPost);
        post(Path.Web.LOGOUT,        LoginController.handleLogoutPost);
        get(Path.Web.DELETE,         UserDeleteController.delete);
        post(Path.Web.DELETE,        UserDeleteController.deletepost);
        get(Path.Web.USERCHANGE,     UserChangeController.userchange);
        post(Path.Web.USERCHANGE,    UserChangeController.userchangepost);
        get(Path.Web.PRODUCTS,       ProductController.products);
        get(Path.Web.PANDA1,        Panda1.panda1);
        get("*",                     ViewUtil.notFound);


        //Set up after-filters (called after each get/post)
        after("*",                   Filters.addGzipHeader);

    }

}
