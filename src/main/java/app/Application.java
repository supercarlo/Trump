package app;

import app.admin.*;
import app.index.IndexController;
import app.login.*;
import app.fav.*;
import app.product.ProductController;
import app.product.ProductDao;
import app.shoppingcart.PurchaseController;
import app.shoppingcart.shoppingcartController;
import app.shoppingcart.shoppingcartDAO;
import app.Orders.Order_historyController;
import app.users.UsersController;
import app.users.UsersDAO;
import app.util.Filters;
import app.util.Path;
import app.util.ViewUtil;
import app.admin.UserAlterController;

import static spark.Spark.*;
import static spark.debug.DebugScreen.enableDebugScreen;

public class Application {

    // Declare dependencies
    public static LoginController loginController;
    public static ProductDao ProductDao;
    public static shoppingcartDAO shoppingcartDAO;
    public static UsersDAO UserDAO;
//    public static UserDao UserDao;

    public static void main(String[] args) {

        // Instantiate your dependencies
        loginController = new LoginController();
        ProductDao = new ProductDao();
        shoppingcartDAO = new shoppingcartDAO();
        UserDAO = new UsersDAO();
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
        get(Path.Web.LOGIN,          LoginController.serveLoginPage);
        post(Path.Web.LOGIN,         LoginController.handleLoginPost);
        post(Path.Web.LOGOUT,        LoginController.handleLogoutPost);
        post(Path.Web.LOGIN,         LoginController.handleLoginPost);
        post(Path.Web.LOGOUT,        LoginController.handleLogoutPost);
//        get(Path.Web.DELETE,         UserDeleteController.delete);
//        post(Path.Web.DELETE,        UserDeleteController.deletepost);
        get(Path.Web.PRODUCTS,       ProductController.getAllProducts);
        get(Path.Web.PRODUCT,        ProductController.getOneProduct);
        get(Path.Web.PRODUCTSBYCATEGORY,       ProductController.getFilterdProducts);
        get(Path.Web.SHOPPINGCARTADD,   shoppingcartController.shoppingCart);
        get(Path.Web.SHOPPINGCART,   shoppingcartController.shoppingCart);
        get(Path.Web.FAVADD,   favController.favpost);
        get(Path.Web.FAV,   favController.fav);
        get(Path.Web.DELETEFROMCART, shoppingcartController.deleteFromShoppingCart);
        post(Path.Web.USERS, UsersController.getAllUsers);
        get(Path.Web.USER, UsersController.getOneUser);
        get(Path.Web.ALTERUSER,       UsersController.alterUser);
        get(Path.Web.PURCHASES, PurchaseController.purchases);
        post(Path.Web.PURCHASES, shoppingcartController.purchasepost);
        //get(Path.Web.USER, UsersController.deleteUSer);
//        post(Path.Web.DELETEUSER,   UserDeleteController.delete);
        //post(Path.Web.ALTERUSER, UserAlterController.alterpost);

        get(Path.Web.USER, UsersController.getOneUser);
//        post(Path.Web.DELETEUSER,   UserDeleteController.delete);
        get(Path.Web.USER, UsersController.getOneUser);
        get("*",                     ViewUtil.notFound);

        //Set up after-filters (called after each get/post)
        after("*",                   Filters.addGzipHeader);

    }

}
