/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.futbolahora.dominio;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Transient;

/**
 *
 * @author Guillermo
 */
@Entity
public class Ciudad extends EntidadDominio implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private String nombreCiudad;
    private String paisCiudad;
    private String region;
    private String locationKey;

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

    public String getLocationKey() {
        return locationKey;
    }

    public void setLocationKey(String locationKey) {
        this.locationKey = locationKey;
    }
    
}
