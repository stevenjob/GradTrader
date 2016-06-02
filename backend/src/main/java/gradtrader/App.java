package gradtrader;

import io.dropwizard.Application;
import io.dropwizard.Configuration;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;


public class App extends Application<Configuration> {

    public static final String ASSETS_SERVLET_NAME = "assets-servlet";

    public static void main(String[] args) throws Exception {
    	new App().run(new String[]{"server", "config.yml"});
    }

    @Override
    public void initialize(Bootstrap<Configuration> bootstrap) {

    }

    @Override
    public void run(Configuration configuration, Environment environment) {

    }
}
