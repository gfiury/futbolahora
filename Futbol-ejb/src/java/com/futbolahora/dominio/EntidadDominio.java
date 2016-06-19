/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.futbolahora.dominio;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 *
 * @author Guillermo
 */
@MappedSuperclass
public class EntidadDominio {
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "sequenceGenerator")
    protected Long id;

    public Long getId() {
        return id;
    }
}
