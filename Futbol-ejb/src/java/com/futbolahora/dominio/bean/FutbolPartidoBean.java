/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.futbolahora.dominio.bean;

import com.futbolahora.dominio.Partido;
import com.futbolahora.dominio.PartidoDto;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
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
public class FutbolPartidoBean {

    @PersistenceContext
    private EntityManager em;
    
    @EJB
    private FutbolEquipoBean equipoBean;
    
    @EJB
    private FutbolEstadioBean estadioBean;
        
    public List<PartidoDto> getPartidos() {
        try{
            Query query = em.createQuery("SELECT p FROM Partido p");
            return toDto((List<Partido>) query.getResultList());
        }
        catch(Exception ex){
            //Error al obtener los partidos
            //se retorna coleccion vacia
            return null;
        }
    }
    
    public PartidoDto findPartidoById(Long id) {
        return toDto(em.find(Partido.class, id));
    }
    
    private List<PartidoDto> toDto(List<Partido> partidos){
        List<PartidoDto> partidosDto = new ArrayList<>();
        partidos.stream().forEach((partido) -> {
            partidosDto.add(toDto(partido));
        });
        return partidosDto;
    }
    
    private PartidoDto toDto(Partido partido) {
        PartidoDto dto = new PartidoDto();
        dto.setId(partido.getId());
        dto.setEstadio(estadioBean.toDto(partido.getEstadio()));
        dto.setLocal(equipoBean.toDto(partido.getLocal()));
        dto.setVisitante(equipoBean.toDto(partido.getVisitante()));
        dto.setFechaComienzoPartido(partido.getFechaComienzoPartido());
        dto.setScoreLocal(partido.getScoreLocal());
        dto.setScoreVisitante(partido.getScoreVisistante());
        return dto;
    }
    
}
