/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import ejb.TrialEjbLocal;
import javax.annotation.security.DeclareRoles;
import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author shubham
 */
@Path("generic")
@RequestScoped
@DeclareRoles({"Admin"})
public class adminRest {

    @Context
    private UriInfo context;
    
   @EJB TrialEjbLocal tl;

    /**
     * Creates a new instance of adminRest
     */
    public adminRest() {
    }

    /**
     * Retrieves representation of an instance of rest.adminRest
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @RolesAllowed("Admin")
    @Path("/gethello")
    public String getHello() {
      
        return tl.sayHelloToAdmin();
      
    }

    /**
     * PUT method for updating or creating an instance of adminRest
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
