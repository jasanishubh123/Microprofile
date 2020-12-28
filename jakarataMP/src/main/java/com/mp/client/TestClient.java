package com.mp.client;

import javax.ws.rs.GET;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@RegisterRestClient(baseUri = "http://localhost:8080/jakarataMP/rest/example")
public interface TestClient {
    
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    String get();
}
