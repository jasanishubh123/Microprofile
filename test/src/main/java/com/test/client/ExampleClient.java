
package com.test.client;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@RegisterRestClient(baseUri = "http://localhost:8080/test/rest/example")
public interface ExampleClient
{
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String get();

    

}