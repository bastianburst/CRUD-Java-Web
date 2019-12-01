/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rests;



import com.nimbusds.jose.JOSEException;
import com.nimbusds.jwt.JWTClaimsSet;
import java.io.IOException;
import java.security.Principal;
import java.text.ParseException;

import javax.annotation.Priority;
import javax.ejb.EJB;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.ext.Provider;
import org.joda.time.DateTime;


/**
 *
 * @author leoandresm
 */
@Provider
@Priority(Priorities.AUTHENTICATION)
public class SecurityFilter implements ContainerResponseFilter {
    @Override
    public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext) throws IOException {
        final MultivaluedMap<String,Object> headers = responseContext.getHeaders();

        headers.add("Access-Control-Allow-Methods", "GET, POST, PUT, OPTIONS, DELETE");
        headers.add("Access-Control-Allow-Origin", "*");
        if (requestContext.getMethod().equalsIgnoreCase("OPTIONS")) {
            headers.add("Access-Control-Allow-Headers", requestContext.getHeaderString("Access-Control-Request-Headers"));
        }
    }

   
}
