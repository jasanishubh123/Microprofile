/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.shopclient.client;

import java.util.Collection;
import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import jdk.nashorn.internal.runtime.regexp.joni.Config;
import model.Product;
import org.eclipse.microprofile.config.ConfigProvider;
import org.eclipse.microprofile.rest.client.annotation.ClientHeaderParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import token.GenerateToken;

/**
 *
 * @author shubham
 */


@RegisterRestClient(baseUri =  "http://localhost:8080/ProductResources/rest")
@ApplicationScoped
@Path("/product")
public interface ProductClient {
    
      @GET
    @ClientHeaderParam(name="Authorization", value="{generateJWTToken}")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Product> getAvailableProducts();
    
    default String generateJWTToken() {
        
      
         String token ="Bearer "+ GenerateToken.generateJWT();
       System.out.println("Product Token = "+token);
        return token;
    }
    
}
