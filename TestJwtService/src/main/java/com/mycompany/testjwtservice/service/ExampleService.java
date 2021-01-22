package com.mycompany.testjwtservice.service;


import javax.annotation.security.RolesAllowed;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/example")
public class ExampleService {

    @RolesAllowed("Admin")
    @GET
    @Path("getHello")
    @Produces(MediaType.APPLICATION_JSON)
    public String getHello() {
        return "Hello World";
    }

}
