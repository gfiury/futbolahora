/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.futbolahora.dominio;

import javax.persistence.Entity;

/**
 *
 * @author Guillermo
 */
@Entity
public class Ciudad extends EntidadDominio {
    
    private String nombreCiudad;
    private String paisCiudad;
    private String region;

    public String getNombreCiudad() {
        return nombreCiudad;
    }

    public void setNombreCiudad(String nombreCiudad) {
        this.nombreCiudad = nombreCiudad;
    }

    public String getPaisCiudad() {
        return paisCiudad;
    }

    public void setPaisCiudad(String paisCiudad) {
        this.paisCiudad = paisCiudad;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }
    
}
