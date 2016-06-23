/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.futbolahora.dominio.bean;

import com.futbolahora.dominio.Estadio;
import com.futbolahora.dominio.EstadioDto;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Guillermo
 */
@Stateless
@LocalBean
public class FutbolEstadioBean {

    @PersistenceContext
    private EntityManager em;
    
    @EJB
    private FutbolCiudadBean ciudadBean;
        
    public EstadioDto getEstadioByPartidoId(Long id){
        try{
            Query query = em.createQuery("SELECT p.estadio FROM Partido p where p.id = :partidoId");
            return toDto((Estadio)query.setParameter("partidoId", id).getSingleResult());
        }
        catch(Exception ex){
            //Error al obtener los partidos
            //se retorna equipo vacío
            return null;
        }
    }
    
    public EstadioDto toDto(Estadio estadio) {
        EstadioDto dto = new EstadioDto();
        dto.setId(estadio.getId());
        dto.setNombre(estadio.getNombre());
        dto.setCiudadDto(ciudadBean.toDto(estadio.getCiudad()));
        return dto;
    }
}
