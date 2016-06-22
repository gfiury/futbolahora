/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.futbolahora.dominio.bean;

import com.futbolahora.dominio.Equipo;
import com.futbolahora.dominio.EquipoDto;
import com.futbolahora.dominio.Jugador;
import com.futbolahora.dominio.JugadorDto;
import com.futbolahora.dominio.Partido;
import com.futbolahora.dominio.PartidoDto;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Guillermo
 */
@Stateless
public class FutbolJugadorBean implements FutbolJugadorBeanLocal {

    @PersistenceContext
    private EntityManager em;
        
    @Override
    public List<JugadorDto> getJugadoresLocalByPartidoId(Long id){
        try{
            Query query = em.createQuery("SELECT p.jugadoresLocal FROM Partido p where p.id = :partidoId");
            return toDto((List<Jugador>) query.getResultList());
        }
        catch(Exception ex){
            //Error al obtener los partidos
            //se retorna equipo vacío
            return null;
        }
    }
    
    @Override
    public List<JugadorDto> getJugadoresVisitanteByPartidoId(Long id){
        try{
            Query query = em.createQuery("SELECT p.jugadoresVisitante FROM Partido p where p.id = :partidoId");
            return toDto((List<Jugador>) query.getResultList());
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
