/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.futbolahora.dominio.bean;

import com.futbolahora.dominio.Equipo;
import com.futbolahora.dominio.EquipoDto;
import com.futbolahora.dominio.Partido;
import com.futbolahora.dominio.PartidoDto;
import com.futbolahora.dominio.Sistema;
import java.util.ArrayList;
import java.util.Collection;
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
public class FutbolPartidoBean implements FutbolPartidoBeanLocal {

    @PersistenceContext
    private EntityManager em;
        
    @Override
    public List<PartidoDto> getPartidos() {
        try{
            Sistema sis = Sistema.getInstancia();
            Query query = em.createQuery("SELECT p FROM Partido p");
            return toDto((List<Partido>) query.getResultList());
        }
        catch(Exception ex){
            //Error al obtener los partidos
            //se retorna coleccion vacia
            return null;
        }
    }
    
    @Override
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
        return dto;
    }
}
