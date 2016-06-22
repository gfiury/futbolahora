/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.futbolahora.dominio;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


public class Sistema {
    
    @PersistenceContext
    private EntityManager em;
        
    private static Sistema instancia;
    
    public static Sistema getInstancia(){
        if (instancia == null) {
            instancia = new Sistema();
        }
        
        return instancia;
    }
    
    private Sistema(){
        
    }
    
    
}
