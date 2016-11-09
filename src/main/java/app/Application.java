package app;

import app.admin.UserChangeController;
import app.admin.UserDeleteController;
import app.admin.UsersController;
import app.book.*;
import app.index.*;
import app.login.*;
import app.util.*;
import static spark.Spark.*;
import static spark.debug.DebugScreen.*;

public class Application {

    // Declare dependencies
    public static BookDao bookDao;

    public static void main(String[] args) {

        // Instantiate your dependencies
        bookDao = new BookDao();

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
        get(Path.Web.REGISTER,       RegisterController.register);
        get(Path.Web.USERS,          UsersController.users);
        post(Path.Web.USERS,         UsersController.userspost);
        get(Path.Web.BOOKS,          BookController.fetchAllBooks);
        get(Path.Web.ONE_BOOK,       BookController.fetchOneBook);
        get(Path.Web.LOGIN,          LoginController.serveLoginPage);
        post(Path.Web.LOGIN,         LoginController.handleLoginPost);
        post(Path.Web.LOGOUT,        LoginController.handleLogoutPost);
        get(Path.Web.DELETE,         UserDeleteController.delete);
        post(Path.Web.DELETE,        UserDeleteController.deletepost);
        get(Path.Web.USERCHANGE,     UserChangeController.userchange);
        get("*",                     ViewUtil.notFound);


        //Set up after-filters (called after each get/post)
        after("*",                   Filters.addGzipHeader);

    }

}
