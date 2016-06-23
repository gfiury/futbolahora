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
public class CiudadDto implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private Long id;
    private String nombreCiudad;
    private String paisCiudad;
    private String region;
    private ClimaDto clima;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public ClimaDto getClima() {
        return clima;
    }

    public void setClima(ClimaDto clima) {
        this.clima = clima;
    }
}
