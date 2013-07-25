package net.binout;

import com.github.kevinsawicki.http.HttpRequest;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static org.junit.Assert.assertEquals;


public class ProductResourceTest {

    private static RestEasyServer server;

    @BeforeClass
    public static void start_server() throws Exception {
        server = new RestEasyServer();
        server.startUp();
    }

    @AfterClass
    public static void stop_server() throws Exception {
        server.shutDown();
    }

    @Test
    public void get_and_add_product() throws Exception {
        String baseUrl = "http://localhost:" + server.getPort() + "/";
        int getCode = HttpRequest.get(baseUrl + "product/toto").code();
        assertEquals(Response.Status.NO_CONTENT.getStatusCode(), getCode);

        String json = "{\"name\":\"toto\"}";
        int postCode = HttpRequest.post(baseUrl + "product").contentType(MediaType.APPLICATION_JSON).send(json.getBytes()).code();
        assertEquals(Response.Status.CREATED.getStatusCode(), postCode);

        HttpRequest httpGetProductRequest = HttpRequest.get(baseUrl + "product/toto").acceptJson();
        getCode = httpGetProductRequest.code();
        assertEquals(Response.Status.OK.getStatusCode(), getCode);
        assertEquals(json, httpGetProductRequest.body());
    }

}
