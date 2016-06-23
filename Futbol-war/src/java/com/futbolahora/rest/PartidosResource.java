/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.futbolahora.rest;

import com.futbolahora.dominio.EquipoDto;
import com.futbolahora.dominio.EstadioDto;
import com.futbolahora.dominio.EventoGolDto;
import com.futbolahora.dominio.JugadorDto;
import com.futbolahora.dominio.Partido;
import com.futbolahora.dominio.PartidoDto;
import com.futbolahora.dominio.bean.FutbolEquipoBean;
import com.futbolahora.dominio.bean.FutbolEstadioBean;
import com.futbolahora.dominio.bean.FutbolEventoGolBean;
import com.futbolahora.dominio.bean.FutbolJugadorBean;
import com.futbolahora.dominio.bean.FutbolPartidoBean;
import com.google.gson.Gson;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author Guillermo
 */
@Path("partidos")
public class PartidosResource {

    @EJB
    private FutbolPartidoBean partidoBean;
    
    @EJB
    private FutbolEquipoBean equipoBean;
    
    @EJB
    private FutbolJugadorBean jugadorBean;
    
    @EJB
    private FutbolEstadioBean estadioBean;
    
    @EJB
    private FutbolEventoGolBean eventoBean;
    
    private final Gson gson = new Gson();

    
    public PartidosResource() {
    }
    
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

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPartido(@PathParam("id") Long id) {
        PartidoDto dto = partidoBean.findPartidoById(id);
        return Response.ok().entity(gson.toJson(dto)).build();
    }
    
    @GET
    @Path("/{id}/estadio")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getEstadio(@PathParam("id") Long id) {
        EstadioDto estadio = estadioBean.getEstadioByPartidoId(id);
        return Response.ok().entity(estadio).build();
    }
    
    @GET
    @Path("/{id}/local")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getEquipoLocal(@PathParam("id") Long id) {
        EquipoDto equipoLoc = equipoBean.getEquipoLocalByPartidoId(id);
        return Response.ok().entity(equipoLoc).build();
    }
    
    @GET
    @Path("/{id}/visitante")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getEquipoVisitante(@PathParam("id") Long id) {
        EquipoDto equipoLoc = equipoBean.getEquipoVisitanteByPartidoId(id);
        return Response.ok().entity(equipoLoc).build();
    }
    
    @GET
    @Path("/{id}/local/jugadores")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getJugadoresLocal(@PathParam("id") Long id) {
        List<JugadorDto> list = jugadorBean.getJugadoresLocalByPartidoId(id);
        return Response.ok().entity(gson.toJson(list)).build();
    }
    
    @GET
    @Path("/{id}/visitante/jugadores")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getJugadoresVisitante(@PathParam("id") Long id) {
        List<JugadorDto> list = jugadorBean.getJugadoresVisitanteByPartidoId(id);
        return Response.ok().entity(gson.toJson(list)).build();
    }

    @POST
    @Path("/{id}/eventoGol")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response postJson(String json) {
        try{
            EventoGolDto dto = gson.fromJson(json, EventoGolDto.class);
            
            PartidoDto partido = partidoBean.findPartidoById(dto.getPartido().getId());
            EquipoDto equipo = equipoBean.findEquipoById(dto.getEquipo().getId());
            JugadorDto jugador = jugadorBean.findJugadorById(dto.getJugador().getId());
            
            EventoGolDto evento = eventoBean.addEventoGol(equipo, jugador, partido, dto);
            return Response.status(Response.Status.CREATED).entity(evento).build();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
            return null;
        }
    }

}
