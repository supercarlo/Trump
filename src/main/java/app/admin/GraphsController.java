package app.admin;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.Template;
import org.apache.velocity.exception.ParseErrorException;
import org.apache.velocity.exception.ResourceNotFoundException;
import java.io.*;

import app.DBC;
import app.util.Path;
import app.util.ViewUtil;
import spark.Request;
import spark.Response;
import spark.Route;
import app.RequestWrapper;

import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by wrket on 19-Jan-17.
 */
public class GraphsController {

        public static Route graphs = (Request request, Response response) -> {
            Map<String, Object> model = new HashMap<>();
            VelocityContext context = new VelocityContext();
            GRAPHS graphs = new GRAPHS();
            request.url();
            model.put("graphmaker", graphs);
           //model.put("url", request.url());
            model.put("request", request);
            Template template =  null;
            return ViewUtil.render(request, model, Path.Template.GRAPHS);
        };

        public static Route graphspost = (Request request, Response response) -> {
            Map<String, Object> model = new HashMap<>();
            VelocityContext context = new VelocityContext();
            GRAPHS graphs = new GRAPHS();
            model.put("url", request.url());
            model.put("graphmaker", graphs);
            model.put("request", request);

            return ViewUtil.render(request, model, Path.Template.GRAPHS);
        };
    }


