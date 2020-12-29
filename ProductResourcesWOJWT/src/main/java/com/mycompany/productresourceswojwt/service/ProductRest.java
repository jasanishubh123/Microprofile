package com.mycompany.productresourceswojwt.service;

import com.mycompany.productresources.client.StockClient;
import com.mycompany.productresources.model.ProductModel;
import com.mycompany.stockresources.entity.Product;
import java.util.Collection;
import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.eclipse.microprofile.jwt.JsonWebToken;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@Path("/product")
public class ProductRest {

 
    @Inject ProductModel model;
    @Inject @RestClient StockClient sc;
    
    @GET
//    @RolesAllowed("Admin")
    @Path("getAvailableProduct")
    @javax.ws.rs.Produces(MediaType.APPLICATION_JSON)
    public Collection<Product> getAvailableProduct() {
        
         
         
         System.out.println("Entered in product Resource..");
        Collection<Integer> allids = sc.getAvailableProductIds();
        return model.getAvailableProducts(allids);
        
        
        
    }
    
    @POST
    @Path("addProduct")
    @Consumes(MediaType.APPLICATION_JSON)
    public void addProduct(Product p){
        System.out.println("In Rest");
        model.addProducts(p);
    }
    
    @GET 
    @Path("getProduct")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Product> getAllProducts(){
        return model.getAllProduct();
    };
    
    @DELETE
    @Path("removeProduct")
    public void removeProduct(@QueryParam("pid") int pid){
        model.removeProduct(pid);
    }

}
