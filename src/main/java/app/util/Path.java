package app.util;

import lombok.*;

public class Path {

    // The @Getter methods are needed in order to access
    // the variables from Velocity Templates
    public static class Web {
        @Getter public static final String INDEX = "/index/";
        @Getter public static final String LOGIN = "/login/";
        @Getter public static final String LOGOUT = "/logout/";
        @Getter public static final String PRODUCTS = "/products/";
        @Getter public static final String PRODUCT = "/products/:ID/";
        @Getter public static final String CUSTOMERHOME = "/customerhome/";
        @Getter public static final String ADMINHOME = "/adminhome/";
        @Getter public static final String GRAPHS = "/graphs/";
        @Getter public static final String ORDER_HISTORY = "/order_history/";
        @Getter public static final String REGISTER = "/register/";
        @Getter public static final String USERS = "/users/";
        @Getter public static final String DELETE = "/index/";
        @Getter public static final String USERCHANGE = "/userchange/";
        @Getter public static final String SHOPPINGCART= "/shoppingcart/";
        @Getter public static final String SHOPPINGCARTADD= "/shoppingcart/:ID/";
    }

    public static class Template {
        public final static String INDEX = "/velocity/index/index.vm";
        public final static String LOGIN = "/velocity/login/login.vm";
        public final static String PRODUCTS = "/velocity/products/all.vm";
        public static final String PRODUCT = "/velocity/products/one.vm";
        public static final String NOT_FOUND = "/velocity/notFound.vm";
        public static final String ORDER_HISTORY = "/velocity/index/Order_history.vm";
        public final static String CUSTOMERHOME = "/velocity/index/customerhome.vm";
        public final static String ADMINHOME = "/velocity/index/adminhome.vm";
        public final static String GRAPHS = "/velocity/index/graphs.vm";
        public final static String REGISTER = "/velocity/index/register.vm";
        public final static String USERS = "/velocity/index/users.vm";
        public final static String USERCHANGE = "/velocity/index/userchange.vm";
        public final static String SHOPPINGCART = "/velocity/products/shoppingcart.vm";
    }
}
