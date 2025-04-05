package org.product.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import io.smallrye.mutiny.Uni;
import org.product.entity.Product;
import org.product.service.ProductService;

import java.util.List;

@Path("/api/products") // More RESTful to use a base prefix like "/api"
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProductResource {

    @Inject
    ProductService productService;

    @POST
    public Uni<Product> create(Product product) {
        System.out.println("Creating product: " + product.name);
        try {
            return productService.create(product);
        } catch (Exception e) {
            e.printStackTrace();
            throw new WebApplicationException("Error creating product", 500);
        }
    }


    @GET
    public Uni<List<Product>> getAll() {
        return productService.listAll();
    }

    @GET
    @Path("/{id}")
    public Uni<Product> getById(@PathParam("id") Integer id) {
        return productService.getById(id);
    }

    @PUT
    @Path("/{id}")
    public Uni<Product> update(@PathParam("id") Integer id, Product product) {
        return productService.update(id, product);
    }

    @DELETE
    @Path("/{id}")
    public Uni<Boolean> delete(@PathParam("id") Integer id) {
        return productService.delete(id);
    }

  /*  @GET
    @Path("/{id}/available")
    public Uni<Boolean> checkAvailability(
            @PathParam("id") Integer id,
            @QueryParam("count") int count) {
        return productService.checkAvailability(id, count);
    }*/

    @GET
    @Path("/sorted/price")
    public Uni<List<Product>> getSortedByPrice() {
        return productService.getProductsSortedByPrice();
    }
}
