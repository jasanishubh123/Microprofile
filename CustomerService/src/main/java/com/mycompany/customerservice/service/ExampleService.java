package com.mycompany.customerservice.service;

import com.mycompany.customerservice.config.Customer;
import com.mycompany.customerservice.model.CustomerModel;
import java.util.Collection;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/example")
public class ExampleService {

    @Inject CustomerModel cm;
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Customer> get(@QueryParam("condition")String cond,@QueryParam("rating")int rat) {
        return cm.getCustomersWithRating(cond, rat);
    }

}
