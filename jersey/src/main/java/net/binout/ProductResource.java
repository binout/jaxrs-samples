package net.binout;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/product")
public class ProductResource  {

    @Inject
    private ProductRepository repository;

    @GET
    @Path("/{name}")
    public Product getProduct(@PathParam("name") String name) {
        return repository.getProductByName(name);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addProduct(Product p) {
        repository.addProduct(p);
        return Response.status(Response.Status.CREATED).build();
    }
}
