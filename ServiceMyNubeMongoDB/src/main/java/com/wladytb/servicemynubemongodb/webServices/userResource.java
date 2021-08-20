/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wladytb.servicemynubemongodb.webServices;

import com.wladytb.servicemynubemongodb.accesoDatos.userDAO;
import com.wladytb.servicemynubemongodb.modelo.user;
import java.net.URI;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.json.JSONObject;

/**
 * REST Web Service
 *
 * @author wladi
 */
@Path("userWS")
public class userResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of userResource
     */
    public userResource() {
    }

    /**
     * Retrieves representation of an instance of
     * com.wladytb.servicemynubemongodb.webServices.userResource
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    @Path("save")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response saveUser(String data, @Context UriInfo uriInfo) {
        URI uri = uriInfo.getAbsolutePath();
        JSONObject dataObject = new JSONObject(data);
        userDAO usDAO = new userDAO();
        user us = new user("",
                dataObject.getString("userName"),
                dataObject.getString("password"),
                dataObject.getString("email"),
                dataObject.getString("photo"));
        return Response.created(uri).entity(usDAO.insert(us)).header("Access-Control-Allow-Origin", "*").header("Access-Control-Allow-Credentials", "true")
                .header("Access-Control-Allow-Methods", "POST, GET, PUT, UPDATE, OPTIONS")
                .header("Access-Control-Allow-Headers", "Access-Control-Allow-Headers, Origin,Accept, X-Requested-With, Content-Type, Access-Control-Request-Method, Access-Control-Request-Headers").build();
    }

    @Path("verificar")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response checkUser(String data, @Context UriInfo uriInfo) {
        URI uri = uriInfo.getAbsolutePath();
        JSONObject dataObject = new JSONObject(data);
        userDAO usDAO = new userDAO();
        user us = new user("",dataObject.getString("userName"),dataObject.getString("password"),"","");
        return Response.created(uri).entity(usDAO.verificar(us)).header("Access-Control-Allow-Origin", "*").header("Access-Control-Allow-Credentials", "true")
                .header("Access-Control-Allow-Methods", "POST, GET, PUT, UPDATE, OPTIONS")
                .header("Access-Control-Allow-Headers", "Access-Control-Allow-Headers, Origin,Accept, X-Requested-With, Content-Type, Access-Control-Request-Method, Access-Control-Request-Headers").build();
    }

    /**
     * PUT method for updating or creating an instance of userResource
     *
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
