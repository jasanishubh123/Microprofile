/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.testjwt.client;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.annotation.ClientHeaderParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import token.GenerateToken;

/**
 *
 * @author shubham
 */


@RegisterRestClient(baseUri = "http://localhost:8080/TestJwtService/rest/example")
@ClientHeaderParam(name = "Authorization",value = "{generateToken}")
public interface clientTest {
    
     @GET
    @Path("getHello")
    @Produces(MediaType.APPLICATION_JSON)
    public String getHello();
    
    
    default String generateToken(){
        String token = GenerateToken.generateJWT();
        return "Bearer "+token;
    }
    
}
