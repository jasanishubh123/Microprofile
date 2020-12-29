package com.mycompany.stockresourceswojwt.service;

import com.mycompany.stockresources.model.stockModel;
import java.util.Collection;
import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/stock")
public class StockRest {

    @Inject stockModel stock;
    
    
    @GET
//    @RolesAllowed("Admin")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Integer> getAvailableProductsIds() {
        return stock.getNonZeroProductsIds();
    }

}
