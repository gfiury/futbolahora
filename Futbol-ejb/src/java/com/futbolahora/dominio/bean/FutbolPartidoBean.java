/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.futbolahora.dominio.bean;

import com.futbolahora.dominio.Partido;
import java.util.Collection;
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
    public Collection<Partido> getPartidos() {
        try{
            Query query = em.createQuery("SELECT p FROM Partido p");
            return (Collection<Partido>) query.getResultList();
        }
        catch(Exception ex){
            //Error al obtener los partidos
            //se retorna coleccion vacia
            return null;
        }
    }
}
