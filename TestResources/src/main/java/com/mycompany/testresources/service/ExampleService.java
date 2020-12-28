package com.mycompany.testresources.service;

import javax.annotation.security.RolesAllowed;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.eclipse.microprofile.jwt.JsonWebToken;

@Path("/example")
public class ExampleService {

    @Inject JsonWebToken token;
    
    @GET
    @RolesAllowed("Admin")
    @Produces(MediaType.TEXT_PLAIN)
    public String get() {
        return "Hello i am Service "+token.getName()+" "+token.getGroups();
    }

}
