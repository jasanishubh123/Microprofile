/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.eclipse.microprofile.config.Config;
import org.eclipse.microprofile.config.ConfigProvider;
import org.eclipse.microprofile.rest.client.annotation.ClientHeaderParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import token.GenerateToken;

/**
 *
 * @author shubham
 */
@RegisterRestClient(configKey = "myclient")
//@RegisterRestClient(configKey = "myclient")
//@ClientHeaderParam(name = "X-Application-Name",value = "MP-ClientApp")
@ClientHeaderParam(name = "Authorization", value = "{generateJWTToken}")
public interface RemoteClient {

    default String generateJWTToken() {
//        Config config = ConfigProvider.getConfig();
//        String token = "Bearer "+config.getValue("jwt-string", String.class);
        String token = "Bearer " + GenerateToken.generateJWT();
        System.out.println("Token = " + token);

        return token;

    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)

    public String get();

}
