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
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("partidos")
public class PartidosResource {
    
    @EJB
    private FutbolPartidoBean partidoBean;
    
    private final Gson gson = new Gson();

    public PartidosResource() {
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getJson(@QueryParam("withBooks") boolean withBooks) {
        List<PartidoDto> list = partidoBean.getPartidos();
        return Response.ok().entity(gson.toJson(list)).build();
    }
    
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPartido(@PathParam("id") Long id) {
        PartidoDto dto = partidoBean.findPartidoById(id);
        return Response.ok().entity(gson.toJson(dto)).build();
    }
    
    @GET
    @Path("/{id}/local")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getEquipoLocal(@PathParam("id") Long id) {
        /*List<BookDto> list = bookBean.getBooksByAuthorId(id);
        return Response.ok().entity(gson.toJson(list)).build();*/
        return null;
    }
    
    @GET
    @Path("/{id}/visitante")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getEquipoVisitante(@PathParam("id") Long id) {
        /*List<BookDto> list = bookBean.getBooksByAuthorId(id);
        return Response.ok().entity(gson.toJson(list)).build();*/
        return null;
    }
    
    @GET
    @Path("/{id}/local/jugadores")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getJugadoresLocal(@PathParam("id") Long authorId) {
        /*List<BookDto> list = bookBean.getBooksByAuthorId(bookId);
        return Response.ok().entity(gson.toJson(list)).build();*/
        return null;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response postJson(String json) {
        /*AuthorDto author = authorBean.createAuthor(gson.fromJson(json, AuthorDto.class));
        return Response.status(Response.Status.CREATED).entity(author).build();*/
        return null;
    }
    
    @POST
    @Path("/{id}/books")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response postBook(@PathParam("id") Long id, String json) {
        /*AuthorDto authorDto = authorBean.findAuthorById(id);
        BookDto bookDto = authorBean.addBook(authorDto, gson.fromJson(json, BookDto.class));
        return Response.status(Response.Status.CREATED).entity(bookDto).build();*/
        return null;
    }
}
