package com.mycompany.sampleapp.service;

import javafx.scene.media.Media;
import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.eclipse.microprofile.jwt.JsonWebToken;

@Path("/example")
public class ExampleService {

    @Inject JsonWebToken token;
    
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @RolesAllowed("Admin")
    public String get() {
        return "Hello world from "+token.getName()+" Roles = "+token.getGroups();
    }

}
