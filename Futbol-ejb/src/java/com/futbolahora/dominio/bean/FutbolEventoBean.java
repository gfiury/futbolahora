/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.futbolahora.dominio.bean;

import com.futbolahora.dominio.EventoPartido;
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
        
    public void guardarEvento(EventoPartido eventoPartido){
        try{
            em.persist(eventoPartido);
        }
        catch(Exception ex){
            throw ex;
        }
    }
}
