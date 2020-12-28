package com.mycompany.productresources.service;

import com.mycompany.productresources.client.StockClient;
import com.mycompany.productresources.model.ProductModel;
import com.mycompany.stockresources.entity.Product;
import java.util.Collection;
import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.eclipse.microprofile.jwt.JsonWebToken;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@Path("/product")
public class ProductRest {

    @Inject JsonWebToken token;
    @Inject ProductModel model;
    @Inject @RestClient StockClient sc;
    
    @GET
    @RolesAllowed("Admin")
    @javax.ws.rs.Produces(MediaType.APPLICATION_JSON)
    public Collection<Product> getAvailableProduct() {
        
         System.out.println("Recieved Raw Token in Product "+ token.getRawToken());
         RowToken.setRtoken(token.getRawToken());
         System.out.println("Entered in product Resource..");
        Collection<Integer> allids = sc.getAvailableProductIds();
        return model.getAvailableProducts(allids);
        
        
        
    }

}
