package br.com.reschoene.resources;

import br.com.reschoene.entities.Product;
import br.com.reschoene.services.ProductService;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/products")
public class ProductResource {
    @Inject
    ProductService productService;

    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    public List<Product> list() {
        return productService.listAll();
    }

    @GET
    @Path("/{id}")
    public Product findById(@PathParam("id") Long id) {
        return productService.findById(id);
    }

    @POST
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
    @Transactional
    public Product create(Product p) {
        return productService.create(p);
    }

    @PUT
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
    @Path("/{id}")
    @Transactional
    public Product update(@PathParam("id") Long id, Product p) {
        return productService.update(id, p);
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public void delete(@PathParam("id") Long id) {
        productService.delete(id);
    }

    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    @Path("/search/{code}")
    public Product search(@PathParam("code") String code) {
        return productService.findByCode(code);
    }

    @GET
    @Path("/count")
    public Long count() {
        return productService.count();
    }
}
