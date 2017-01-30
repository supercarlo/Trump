package app;

import app.admin.*;
import app.index.IndexController;
import app.login.*;
import app.product.ProductController;
import app.product.ProductDao;
import app.shoppingcart.shoppingcartController;
import app.shoppingcart.shoppingcartDAO;
import app.user.Order_historyController;
import app.util.Filters;
import app.util.Path;
import app.util.ViewUtil;

import static spark.Spark.*;
import static spark.debug.DebugScreen.enableDebugScreen;

public class Application {

    // Declare dependencies
    public static ProductDao ProductDao;
    public static shoppingcartDAO shoppingcartDAO;
    public static useradminchangeDAO useradminchangeDAO;
//    public static UserDao UserDao;

    public static void main(String[] args) {

        // Instantiate your dependencies
        ProductDao = new ProductDao();
        shoppingcartDAO = new shoppingcartDAO();
        useradminchangeDAO = new useradminchangeDAO();
//        UserDao = new UserDao();

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
        get(Path.Web.GRAPHS,      GraphsController.graphs);
        post(Path.Web.GRAPHS,     GraphsController.graphspost);
        get(Path.Web.ORDER_HISTORY,      Order_historyController.order_history);
        post(Path.Web.ORDER_HISTORY,     Order_historyController.order_historypost);
        get(Path.Web.REGISTER,       RegisterController.register);
        post(Path.Web.REGISTER,      RegisterController.registerpost);
        get(Path.Web.USERS,          UsersController.users);
        post(Path.Web.USERS,         UsersController.userspost);
        get(Path.Web.LOGIN,          LoginController.serveLoginPage);
        post(Path.Web.LOGIN,         LoginController.handleLoginPost);
        post(Path.Web.LOGOUT,        LoginController.handleLogoutPost);
        post(Path.Web.LOGIN,         LoginController.handleLoginPost);
        post(Path.Web.LOGOUT,        LoginController.handleLogoutPost);
        get(Path.Web.DELETE,         UserDeleteController.delete);
        post(Path.Web.DELETE,        UserDeleteController.deletepost);
        get(Path.Web.USERCHANGE,     UserChangeController.getAllUsers);
        post(Path.Web.USERCHANGE,    UserChangeController.userchangepost);
        get(Path.Web.PRODUCTS,       ProductController.getAllProducts);
        get(Path.Web.PRODUCT,        ProductController.getOneProduct);
        get(Path.Web.SHOPPINGCARTADD,   shoppingcartController.shoppingCart);
        get(Path.Web.SHOPPINGCART,   shoppingcartController.shoppingCart);
        get("*",                     ViewUtil.notFound);

        //Set up after-filters (called after each get/post)
        after("*",                   Filters.addGzipHeader);

    }

}
