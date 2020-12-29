/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.productresources.client;


import java.util.Collection;
import javax.annotation.security.RolesAllowed;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.annotation.ClientHeaderParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

/**
 *
 * @author shubham
 */


@RegisterRestClient(baseUri = "http://localhost:8080/StockResourcesWOJWT/rest")
@Path("/stock")
public interface StockClient {
    
    
    @GET
//    @RolesAllowed("Admin")
    @Produces(MediaType.APPLICATION_JSON)
    Collection<Integer> getAvailableProductIds();
    
    
    
  
    
    
}
