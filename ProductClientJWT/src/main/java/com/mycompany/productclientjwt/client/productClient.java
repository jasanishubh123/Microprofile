/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.productclientjwt.client;

import com.mycompany.productclientjwt.managedBean.MyToken;
import com.mycompany.productresourcejwt.entity.Product;
import java.util.Collection;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.annotation.ClientHeaderParam;
import org.eclipse.microprofile.rest.client.annotation.RegisterClientHeaders;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import token.GenerateToken;
import token.MPJWTToken;

/**
 *
 * @author shubham
 */

@RegisterRestClient(baseUri = "http://localhost:8080/ProductResourceJWT/rest")
@ClientHeaderParam(name = "Authorization" ,value ="{generateToken}")
@Path("/product")
public interface productClient {
    
    
    
    default String generateToken(){
        
        
//        if(MyToken.getRtoken() != null){
//            System.out.println("TOKEN NOT NULL IN SESSION -");
//            String token = MyToken.getRtoken();
//            System.out.println(token);
//            return token;
//        }else {
//            System.out.println("TOKEN NULL");
//            String token ="Bearer "+ GenerateToken.generateJWT();
//            MyToken.setRtoken(token);
//            System.out.println(token);
//            return  token;
//        }
        
         String token ="Bearer "+ GenerateToken.generateJWT();
            MyToken.setRtoken(token);
            return  token;
         
    }
    
    
    @GET
    @Path("getProducts")
    @javax.ws.rs.Produces(MediaType.APPLICATION_JSON)
    public Collection<Product> getProducts();
    
    @POST
    @Path("addProduct")
    @Consumes(MediaType.APPLICATION_JSON)
    public void addProduct(Product p);
    
    @PUT
    @Path("updateProduct")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateProduct(Product p);
    
    @DELETE
    @Path("deleteProduct")
    public void removeProduct(@QueryParam("id")int id);
    
}
