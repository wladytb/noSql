/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wladytb.servicemynubemongodb.webServices;

import com.wladytb.servicemynubemongodb.accesoDatos.filesDAO;
import com.wladytb.servicemynubemongodb.modelo.file;
import java.net.URI;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.json.JSONObject;

/**
 * REST Web Service
 *
 * @author wladi
 */
@Path("fileWS")
public class FileResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of FileResource
     */
    public FileResource() {
    }

    /**
     * Retrieves representation of an instance of
     * com.wladytb.servicemynubemongodb.webServices.FileResource
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    @Path("get")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response checkUser(@QueryParam("idUser") String idUser, @Context UriInfo uriInfo) {
        URI uri = uriInfo.getAbsolutePath();
        filesDAO flDAO = new filesDAO();
        file fl = new file("", idUser, "", "", "", "");
        return Response.created(uri).entity(flDAO.obtener(fl)).header("Access-Control-Allow-Origin", "*").header("Access-Control-Allow-Credentials", "true")
                .header("Access-Control-Allow-Methods", "POST, GET, PUT, UPDATE, OPTIONS")
                .header("Access-Control-Allow-Headers", "Access-Control-Allow-Headers, Origin,Accept, X-Requested-With, Content-Type, Access-Control-Request-Method, Access-Control-Request-Headers").build();
    }

    @Path("save")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response save(String data, @Context UriInfo uriInfo) {
        URI uri = uriInfo.getAbsolutePath();
        JSONObject dataObject = new JSONObject(data);
        filesDAO flDAO = new filesDAO();
        file fl = new file(dataObject.getString("idFile"),
                dataObject.getString("idUser"), dataObject.getString("name"),
                dataObject.getString("fileURL"), dataObject.getString("description"),
                dataObject.getString("type"));
        return Response.created(uri).entity(flDAO.insert(fl)).header("Access-Control-Allow-Origin", "*").header("Access-Control-Allow-Credentials", "true")
                .header("Access-Control-Allow-Methods", "POST, GET, PUT, UPDATE, OPTIONS")
                .header("Access-Control-Allow-Headers", "Access-Control-Allow-Headers, Origin,Accept, X-Requested-With, Content-Type, Access-Control-Request-Method, Access-Control-Request-Headers").build();
    }

    @Path("update")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(String data, @Context UriInfo uriInfo) {
        URI uri = uriInfo.getAbsolutePath();
        JSONObject dataObject = new JSONObject(data);
        filesDAO flDAO = new filesDAO();
        file fl = new file(dataObject.getString("idFile"),
                dataObject.getString("idUser"), dataObject.getString("name"),
                "", dataObject.getString("description"),
                "");
        return Response.created(uri).entity(flDAO.update(fl)).header("Access-Control-Allow-Origin", "*").header("Access-Control-Allow-Credentials", "true")
                .header("Access-Control-Allow-Methods", "POST, GET, PUT, UPDATE, OPTIONS")
                .header("Access-Control-Allow-Headers", "Access-Control-Allow-Headers, Origin,Accept, X-Requested-With, Content-Type, Access-Control-Request-Method, Access-Control-Request-Headers").build();
    }

    @Path("delete")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response delete(String data, @Context UriInfo uriInfo) {
        URI uri = uriInfo.getAbsolutePath();
        JSONObject dataObject = new JSONObject(data);
        filesDAO flDAO = new filesDAO();
        file fl = new file(dataObject.getString("idFile"), "", "", "", "", "");
        return Response.created(uri).entity(flDAO.delete(fl)).header("Access-Control-Allow-Origin", "*").header("Access-Control-Allow-Credentials", "true")
                .header("Access-Control-Allow-Methods", "POST, GET, PUT, UPDATE, OPTIONS")
                .header("Access-Control-Allow-Headers", "Access-Control-Allow-Headers, Origin,Accept, X-Requested-With, Content-Type, Access-Control-Request-Method, Access-Control-Request-Headers").build();
    }

    /**
     * PUT method for updating or creating an instance of FileResource
     *
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
