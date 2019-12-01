/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rests;


import javax.ws.rs.ApplicationPath;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.filter.RolesAllowedDynamicFeature;

/**
 *
 * @author leoandresm
 */
@ApplicationPath("webresources")
public class ApplicationConfig extends ResourceConfig {

    public ApplicationConfig() {
        packages("rests;");
        register(RolesAllowedDynamicFeature.class);
    }
    
    public void filter(ContainerRequestContext requestContext, ContainerResponseContext response) {
        response.getHeaders().putSingle("Access-Control-Allow-Origin", "*");
        response.getHeaders().putSingle("Access-Control-Allow-Methods", "OPTIONS, GET, POST, PUT, DELETE");
        response.getHeaders().putSingle("Access-Control-Allow-Headers", "Content-Type, Authorization");
    }
    

}

