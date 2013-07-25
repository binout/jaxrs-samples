package net.binout;

import com.google.common.util.concurrent.AbstractIdleService;
import com.sun.net.httpserver.HttpServer;
import org.jboss.resteasy.plugins.server.sun.http.HttpContextBuilder;

import java.io.IOException;
import java.net.InetSocketAddress;

/**
 * User: binout
 * Date: 13/07/13
 */
public class RestEasyServer extends AbstractIdleService {

    public static final int PORT = 8080;
    private HttpServer httpServer;

    public RestEasyServer() throws IOException {
        httpServer = HttpServer.create(new InetSocketAddress(PORT), 10);
        HttpContextBuilder contextBuilder = new HttpContextBuilder();
        contextBuilder.getDeployment().setApplication(new ProductApplication());
        contextBuilder.bind(httpServer);
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
        new RestEasyServer().startAndWait();
    }
}
