/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.futbolahora.rest;

import com.futbolahora.dominio.PartidoDto;
import com.futbolahora.dominio.bean.FutbolPartidoBean;
import com.google.gson.Gson;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author Guillermo
 */
@Path("partidos")
public class PruebaResource {

    @EJB
    private FutbolPartidoBean partidoBean;
    
    private final Gson gson = new Gson();
    
    public PruebaResource() {
    }

    /**
     * Retrieves representation of an instance of com.futbolahora.rest.PruebaResource
     * @return an instance of java.lang.String
     */
    /*@GET
    @Produces("application/json")
    public String getHtml() {
        return "Test de json y prueba";
    }*/
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getJson() {
        try{
            List<PartidoDto> list = partidoBean.getPartidos();
            return Response.ok().entity(gson.toJson(list)).build();
        }
        catch(Exception ex){
            return Response.ok(ex.getMessage()).build();
        }
    }

    /**
     * PUT method for updating or creating an instance of PruebaResource
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("text/html")
    public void putHtml(String content) {
    }
}
