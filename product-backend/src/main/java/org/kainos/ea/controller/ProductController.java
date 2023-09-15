package org.kainos.ea.controller;

import io.swagger.annotations.Api;
import org.kainos.ea.exception.*;
import org.kainos.ea.model.ProductRequest;
import org.kainos.ea.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Api("Engineering Academy Dropwizard Product API")
@Path("/api")
public class ProductController {
    private ProductService productService = new ProductService();

    private final static Logger logger = LoggerFactory.getLogger(ProductService.class);

    @GET
    @Path("/products")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProducts() {
        try {
            return Response.ok(productService.getAllProducts()).build();
        } catch (FailedToGetProductsException e) {
            logger.error("Product not found! Error: {}", e.getMessage());

            return Response.serverError().build();
        }
    }

    @GET
    @Path("/products/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProductsById(@PathParam("id") int id) {
        try {
            return Response.ok(productService.getProductById(id)).build();
        } catch (FailedToGetProductException e) {
            logger.error("Failed to get a product! Error: {}", e.getMessage());

            return Response.serverError().build();
        } catch (ProductDoesNotExistException e) {
            logger.error("Product does not exist! Id: {} Error: {}", id, e.getMessage());

            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }

    @POST
    @Path("/products")
    @Produces(MediaType.APPLICATION_JSON)
    public Response createProduct(ProductRequest product, @QueryParam("token") String token) {
        try {
            return Response.ok(productService.createProduct(product)).build();
        } catch (FailedToCreateProductException e) {
            logger.error("Failed to create Product! Error: {}", e.getMessage());

            return Response.serverError().build();
        } catch (InvalidProductException e) {
            logger.error("Invalid Product data! Error: {}", e.getMessage());

            return Response.status(Response.Status.BAD_REQUEST).entity(new ResponseMessage(e.getMessage())).build();
        }
    }
}
