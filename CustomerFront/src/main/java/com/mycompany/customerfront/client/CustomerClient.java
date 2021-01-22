/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.customerfront.client;

import com.mycompany.customerfront.config.Customer;
import java.util.Collection;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

/**
 *
 * @author shubham
 */

@RegisterRestClient(baseUri = "http://localhost:8080/CustomerService/rest")
@Path("/example")
public interface CustomerClient {
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Customer> get(@QueryParam("condition")String cond,@QueryParam("rating")int rat);

}
