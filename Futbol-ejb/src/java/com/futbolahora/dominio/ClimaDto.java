/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.futbolahora.dominio;

import java.io.Serializable;

/**
 *
 * @author Guillermo
 */
public class ClimaDto implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private String clima;

    public String getClima() {
        return clima;
    }

    public void setClima(String clima) {
        this.clima = clima;
    }
}
