package app.util;

import lombok.*;

public class Path {

    // The @Getter methods are needed in order to access
    // the variables from Velocity Templates
    public static class Web {
        @Getter public static final String INDEX = "/index/";
        @Getter public static final String LOGIN = "/login/";
        @Getter public static final String LOGOUT = "/logout/";
        @Getter public static final String BOOKS = "/books/";
        @Getter public static final String ONE_BOOK = "/books/:isbn/";
        @Getter public static final String CUSTOMERHOME = "/customerhome/";
        @Getter public static final String ADMINHOME = "/adminhome/";
        @Getter public static final String REGISTER = "/register/";
        @Getter public static final String USERS = "/users/";
        @Getter public static final String DELETE = "/delete/";
    }

    public static class Template {
        public final static String INDEX = "/velocity/index/index.vm";
        public final static String LOGIN = "/velocity/login/login.vm";
        public final static String BOOKS_ALL = "/velocity/book/all.vm";
        public static final String BOOKS_ONE = "/velocity/book/one.vm";
        public static final String NOT_FOUND = "/velocity/notFound.vm";
        public final static String CUSTOMERHOME = "/velocity/index/customerhome.vm";
        public final static String ADMINHOME = "/velocity/index/adminhome.vm";
        public final static String REGISTER = "/velocity/index/register.vm";
        public final static String USERS = "/velocity/index/users.vm";

    }

}
