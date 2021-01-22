/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.productresourcejwt.service;

import com.mycompany.productresourcejwt.entity.Product;
import com.mycompany.productresourcejwt.model.productModel;
import java.util.Collection;
import javax.annotation.security.RolesAllowed;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import org.eclipse.microprofile.jwt.JsonWebToken;

/**
 *
 * @author shubham
 */

@Path("/product")
public class productRest {
    
    @Inject productModel pm;
    @Inject JsonWebToken token;
    
    
    @RolesAllowed("Admin")
    @GET
    @Path("getProducts")
    @javax.ws.rs.Produces(MediaType.APPLICATION_JSON)
    public Collection<Product> getProducts(){
        return pm.getProduts();
    }
    
    @RolesAllowed("Admin")
    @POST
    @Path("addProduct")
    @Consumes(MediaType.APPLICATION_JSON)
    public void addProduct(Product p){
        pm.addUpdateProduct(p);
    }
    
    @RolesAllowed("Admin")
    @PUT
    @Path("updateProduct")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateProduct(Product p){
        pm.addUpdateProduct(p);
    }
    
    @RolesAllowed("Admin")
    @DELETE
    @Path("deleteProduct")
    public void removeProduct(@QueryParam("id")int id){
        pm.removeProduct(id);
    }
    
    
}
