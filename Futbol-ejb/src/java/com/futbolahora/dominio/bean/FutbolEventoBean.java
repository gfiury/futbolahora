/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.futbolahora.dominio.bean;

import com.futbolahora.dominio.EventoGol;
import com.futbolahora.dominio.EventoGolDto;
import com.futbolahora.dominio.EventoPartido;
import com.futbolahora.dominio.EventoPartidoDto;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Guillermo
 */
@Stateless
@LocalBean
public class FutbolEventoBean {

    @PersistenceContext
    private EntityManager em;
        
    public void guardarEvento(EventoPartidoDto eventoPartido){
        try{
            TipoEvento tipo = TipoEvento.valueOf(eventoPartido.getClass().getSimpleName());
            switch(tipo){
                case EventoGolDto:
                    
                    break;
                default:break;
            }
            em.persist(eventoPartido);
        }
        catch(Exception ex){
            throw ex;
        }
    }
    
    private EventoGol eventoGolToDto(EventoGolDto dto){
        //EventoGol evento = eventoGolToEntity();
        return null;
    }
    
    private EventoGol eventoGolToEntity(EventoGolDto dto){
        return null;
    }
    
    private enum TipoEvento{
        EventoGolDto
    }
}
