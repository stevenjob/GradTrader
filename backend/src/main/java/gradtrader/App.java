package gradtrader;

import io.dropwizard.Application;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

import org.atmosphere.cpr.AtmosphereServlet;
import org.atmosphere.cpr.ApplicationConfig;
import javax.servlet.ServletRegistration;

public class App extends Application<GradTraderConfiguration> {


    public static void main(String[] args) throws Exception {
    	new App().run(args);
    }

    @Override
    public void initialize(Bootstrap<GradTraderConfiguration> bootstrap) {
        bootstrap.addBundle(new AssetsBundle("/assets/", "/", "index.html"));
    }

    @Override
    public void run(GradTraderConfiguration configuration, Environment environment) {
       final HelloWorldResource resource = new HelloWorldResource(
               configuration.getTemplate(),
               configuration.getDefaultName()
           );

       final TemplateHealthCheck healthCheck =
               new TemplateHealthCheck(configuration.getTemplate());
       environment.healthChecks().register("template", healthCheck);
       environment.jersey().register(resource);

       
       runWebSocketServer(environment);
       
       
    }
    
    private void runWebSocketServer(Environment environment){
	    AtmosphereServlet servlet = new AtmosphereServlet();
	    servlet.framework().addInitParameter("com.sun.jersey.config.property.packages", "gradtrader.websockets");
	    servlet.framework().addInitParameter(ApplicationConfig.WEBSOCKET_CONTENT_TYPE, "application/json");
	    servlet.framework().addInitParameter(ApplicationConfig.WEBSOCKET_SUPPORT, "true");
	     
	    ServletRegistration.Dynamic servletHolder = environment.servlets().addServlet("WSService", servlet);
	    servletHolder.addMapping("/websockets/*");
    }

}
