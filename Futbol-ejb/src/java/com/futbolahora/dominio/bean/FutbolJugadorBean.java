/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.futbolahora.dominio.bean;

import com.futbolahora.dominio.Jugador;
import com.futbolahora.dominio.JugadorDto;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Guillermo
 */
@Stateless
@LocalBean
public class FutbolJugadorBean {

    @PersistenceContext
    private EntityManager em;
        
    public List<JugadorDto> getJugadoresLocalByPartidoId(Long id){
        try{
            Query query = em.createQuery("SELECT p.jugadoresLocal FROM Partido p where p.id = :partidoId");
            return toDto((List<Jugador>) query.setParameter("partidoId", id).getResultList());
        }
        catch(Exception ex){
            //Error al obtener los partidos
            //se retorna equipo vacío
            return null;
        }
    }
    
    public List<JugadorDto> getJugadoresVisitanteByPartidoId(Long id){
        try{
            Query query = em.createQuery("SELECT p.jugadoresVisitante FROM Partido p where p.id = :partidoId");
            return toDto((List<Jugador>) query.setParameter("partidoId", id).getResultList());
        }
        catch(Exception ex){
            //Error al obtener los partidos
            //se retorna equipo vacío
            return null;
        }
    }
    
    private List<JugadorDto> toDto(List<Jugador> jugadores){
        List<JugadorDto> jugadoresDto = new ArrayList<>();
        jugadores.stream().forEach((jugador) -> {
            jugadoresDto.add(toDto(jugador));
        });
        return jugadoresDto;
    }
    
    private JugadorDto toDto(Jugador jugador) {
        JugadorDto dto = new JugadorDto();
        dto.setId(jugador.getId());
        return dto;
    }
}
