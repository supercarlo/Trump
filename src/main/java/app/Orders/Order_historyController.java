package app.Orders;

import app.util.Path;
import app.util.ViewUtil;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import spark.Request;
import spark.Response;
import spark.Route;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wrket on 19-Jan-17.
 */
public class Order_historyController {

        public static Route order_history = (Request request, Response response) -> {
            Map<String, Object> model = new HashMap<>();
            ORDER_HISTORY order_history = new ORDER_HISTORY();
            VelocityContext context = new VelocityContext();

            request.url();


           //model.put("url", request.url());
            model.put("history", order_history);
            model.put("request", request);
            model.put("username", request.session().attribute("currentUser"));
            Template template =  null;



            return ViewUtil.render(request, model, Path.Template.ORDER_HISTORY);
        };

        public static Route order_historypost = (Request request, Response response) -> {
            Map<String, Object> model = new HashMap<>();
            VelocityContext context = new VelocityContext();;

            model.put("request", request);

            return ViewUtil.render(request, model, Path.Template.ORDER_HISTORY);
        };
    }


