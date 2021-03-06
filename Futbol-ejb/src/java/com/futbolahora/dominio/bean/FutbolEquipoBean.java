/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.futbolahora.dominio.bean;

import com.futbolahora.dominio.Equipo;
import com.futbolahora.dominio.EquipoDto;
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
public class FutbolEquipoBean {

    @PersistenceContext
    private EntityManager em;
    
    public EquipoDto findEquipoById(Long id){
        return toDto(em.find(Equipo.class, id));
    }
        
    public EquipoDto getEquipoLocalByPartidoId(Long id){
        try{
            Query query = em.createQuery("SELECT p.local FROM Partido p where p.id = :partidoId");
            return toDto((Equipo)query.setParameter("partidoId", id).getSingleResult());
        }
        catch(Exception ex){
            //Error al obtener los partidos
            //se retorna equipo vacío
            return null;
        }
    }
    
    public EquipoDto getEquipoVisitanteByPartidoId(Long id){
        try{
            Query query = em.createQuery("SELECT p.visitante FROM Partido p where p.id = :partidoId");
            return toDto((Equipo)query.setParameter("partidoId", id).getSingleResult());
        }
        catch(Exception ex){
            //Error al obtener los partidos
            //se retorna equipo vacío
            return null;
        }
    }
    
    public EquipoDto toDto(Equipo equipo) {
        EquipoDto dto = new EquipoDto();
        dto.setId(equipo.getId());
        dto.setNombre(equipo.getNombre());
        return dto;
    }
}
