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
public class EstadioDto implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private Long id;
    private String nombre;
    private CiudadDto ciudadDto;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public CiudadDto getCiudadDto() {
        return ciudadDto;
    }

    public void setCiudadDto(CiudadDto ciudadDto) {
        this.ciudadDto = ciudadDto;
    }
}
