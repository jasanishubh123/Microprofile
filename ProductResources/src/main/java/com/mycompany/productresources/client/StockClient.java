/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.productresources.client;

import com.mycompany.productresources.service.RowToken;
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


@RegisterRestClient(baseUri = "http://localhost:8080/StockResources/rest")
@Path("/stock")
public interface StockClient {
    
    
    @GET
    @ClientHeaderParam(name="Authorization",value = "{generateToken}")
    @RolesAllowed("Admin")
    @Produces(MediaType.APPLICATION_JSON)
    Collection<Integer> getAvailableProductIds();
    
    
    
    default  String generateToken(){
    
           String token;
           
             token = "Bearer "+RowToken.getRtoken();
            System.out.println("Stock Token = "+token);
            
            return token;
    
    }
    
    
}
