package net.binout;

import com.google.common.util.concurrent.AbstractIdleService;
import org.restlet.Component;
import org.restlet.data.Protocol;
import org.restlet.ext.jaxrs.JaxRsApplication;

/**
 * User: binout
 * Date: 13/07/13
 */
public class RestletServer extends AbstractIdleService {

    private Component component;

    public RestletServer() {
        component = new Component();
        component.getServers().add(Protocol.HTTP, 8182);
        JaxRsApplication application = new JaxRsApplication(component.getContext());
        application.add(new ProductApplication());
        component.getDefaultHost().attach(application);
    }

    public int getPort() {
        return component.getServers().get(0).getPort();
    }

    @Override
    protected void startUp() throws Exception {
        component.start();
    }

    @Override
    protected void shutDown() throws Exception {
        component.stop();
    }

    public static void main(String[] args) throws Exception {
        new RestletServer().startAndWait();
    }
}
