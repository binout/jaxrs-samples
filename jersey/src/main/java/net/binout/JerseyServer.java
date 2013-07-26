package net.binout;

import com.google.common.util.concurrent.AbstractIdleService;
import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.sun.jersey.api.container.httpserver.HttpServerFactory;
import com.sun.jersey.api.core.DefaultResourceConfig;
import com.sun.jersey.api.core.ResourceConfig;
import com.sun.jersey.core.spi.component.ioc.IoCComponentProviderFactory;
import com.sun.jersey.guice.spi.container.GuiceComponentProviderFactory;
import com.sun.net.httpserver.HttpServer;
import org.codehaus.jackson.jaxrs.JacksonJsonProvider;

import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * User: binout
 * Date: 26/07/13
 */
public class JerseyServer extends AbstractIdleService {

    public static final int PORT = 8080;

    private HttpServer httpServer;

    public JerseyServer() throws IOException {
        ProductApplication app = new ProductApplication();
        Set<Class<?>> resources = new LinkedHashSet<>(app.getClasses());
        resources.add(JacksonJsonProvider.class);
        ResourceConfig config = new DefaultResourceConfig(resources);
        Injector injector = Guice.createInjector(new AbstractModule() {
            @Override
            protected void configure() {
                bind(ProductRepository.class).toInstance(new ProductRepository());
            }
        });
        IoCComponentProviderFactory ioc = new GuiceComponentProviderFactory(config, injector);
        httpServer = HttpServerFactory.create("http://localhost:" + PORT + "/", config, ioc);
    }

    public int getPort() {
        return PORT;
    }

    @Override
    protected void startUp() throws Exception {
        httpServer.start();
    }

    @Override
    protected void shutDown() throws Exception {
        httpServer.stop(1);
    }

    public static void main(String[] args) throws Exception {
        new JerseyServer().startAndWait();
    }
}
