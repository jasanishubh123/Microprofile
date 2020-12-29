/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.shopclient.client;

import com.mycompany.stockresources.entity.Product;
import java.util.Collection;
import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import jdk.nashorn.internal.runtime.regexp.joni.Config;

import org.eclipse.microprofile.config.ConfigProvider;
import org.eclipse.microprofile.rest.client.annotation.ClientHeaderParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

/**
 *
 * @author shubham
 */


@RegisterRestClient(baseUri =  "http://localhost:8080/ProductResourcesWOJWT/rest")
@ApplicationScoped
@Path("/product")
public interface ProductClient {
    
    @GET 
    @Path("getAvailableProduct")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Product> getAvailableProducts();
    
   
    @POST
    @Path("addProduct")
    @Consumes(MediaType.APPLICATION_JSON)
    public void addProduct(Product p);
    
    
    @GET 
    @Path("getProduct")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Product> getAllProducts();
    
    @DELETE
    @Path("removeProduct")
    public void removeProduct(@QueryParam("pid") int pid);
    
}
