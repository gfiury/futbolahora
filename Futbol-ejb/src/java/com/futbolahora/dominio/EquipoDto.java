/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.futbolahora.dominio;

import java.io.Serializable;


public class EquipoDto implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
