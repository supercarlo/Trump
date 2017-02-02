package app.fav;

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
public class favController {

        public static Route fav = (Request request, Response response) -> {
            Map<String, Object> model = new HashMap<>();
            Fav fav = new Fav();
            VelocityContext context = new VelocityContext();

            request.url();

            if (request.queryParams("id") != null && (request.session().attribute("currentUser") !=null ))
            {
                fav.AddFav(request.session().attribute("currentUser"), Integer.valueOf(request.queryParams("id")));
            }
            if (request.queryParams("iddelete") != null && (request.session().attribute("currentUser") !=null ))
            {
                fav.DeleteFav(request.session().attribute("currentUser"), Integer.valueOf(request.queryParams("iddelete")));
            }
           //model.put("url", request.url());
            model.put("fav", fav);
            model.put("request", request);
            model.put("username", request.session().attribute("currentUser"));
            Template template =  null;



            return ViewUtil.render(request, model, Path.Template.FAV);
        };

        public static Route favpost = (Request request, Response response) -> {
            Map<String, Object> model = new HashMap<>();
            VelocityContext context = new VelocityContext();;

            model.put("request", request);

            return ViewUtil.render(request, model, Path.Template.FAV);
        };
    }


