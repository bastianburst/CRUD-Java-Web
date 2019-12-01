/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

/**
 *
 * @author SISVDG
 */
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJBException;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.ws.rs.core.Response;

/**
 *
 * @author leoandresm
 */
public class RestUtils {

    private static final SimpleDateFormat DATETIME_FORMAT = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd-MM-yyyy");
    private static final SimpleDateFormat TIME_FORMAT = new SimpleDateFormat("HH:mm");

    public static Response addSuccessResponse(Object obj) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();
        return Response.ok()
                .entity(gson.toJson(obj))
                .build();
    }

    public static Response addErrorResponse(Object obj, Response.Status status) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();
        return Response
                .status(status)
                .entity(gson.toJson(obj))
                .build();
    }

    public static Response addErrorResponse(EJBException ex) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();
        String msg = "";
        Throwable cause = ex.getCause();
        if (cause != null) {
            if (cause instanceof ConstraintViolationException) {
                ConstraintViolationException constraintViolationException = (ConstraintViolationException) cause;
                for (ConstraintViolation<?> constraintViolation : constraintViolationException.getConstraintViolations()) {
                    msg += "{";
                    msg += "entity: " + constraintViolation.getLeafBean().toString() + ",";
                    msg += "field: " + constraintViolation.getPropertyPath().toString() + ",";
                    msg += "invalidValue: " + constraintViolation.getInvalidValue().toString() + ",";
                    msg += "error: " + constraintViolation.getMessage();
                    msg += "}";
                }
            } else {
                msg = cause.getLocalizedMessage();
            }
        }
        if (msg.length() > 0) {
            return Response.status(Response.Status.BAD_REQUEST).entity(gson.toJson(msg)).build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST).entity(gson.toJson("Error de persistencia")).build();
        }
    }  

}