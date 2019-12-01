/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rests;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import models.Asistente;
import sessions.AsistenteFacade;

/**
 *
 * @author Familia
 */
@Path("asistentes")
public class AsistenteRest {
    //Importar el session
    @EJB
    private AsistenteFacade asistenteFacade;
    
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create (Asistente asistente){
         //asistenteFacade.create(asistente);
        System.out.println(" Helo " + asistente.getNombres());
        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();
        
        try{
            asistenteFacade.create(asistente);
            return Response.ok()
                            .entity(gson.toJson("El asistente fue creado exitosamente"))
                            .build();
        }catch (EJBException ex){
            return Response
                    .status(Response.Status.CONFLICT)
                    .entity(gson.toJson("Error"))
                    .build();
                    
            
        }catch(Exception ex){
            return Response.status(Response.Status.BAD_REQUEST).entity(gson.toJson("Error de persistencia")).build();
        }

    }
    
    
    
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<Asistente> findAll(){
        return asistenteFacade.findAll();
    }
    
    
    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Asistente findById(@PathParam("id") int id){
        return asistenteFacade.find(id);
    }
    
    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") int id, Asistente asistente){
       asistenteFacade.edit(asistente);
    }
    
    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") int id) {
        asistenteFacade.remove(asistenteFacade.find(id));
    }
    
    
    
    
}
