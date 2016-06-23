/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.futbolahora.dominio.bean;

import com.futbolahora.dominio.Ciudad;
import com.futbolahora.dominio.CiudadDto;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author Guillermo
 */
@Stateless
@LocalBean
public class FutbolCiudadBean {

    public CiudadDto toDto(Ciudad ciudad){
        CiudadDto dto = new CiudadDto();
        dto.setId(ciudad.getId());
        dto.setNombreCiudad(ciudad.getNombreCiudad());
        dto.setPaisCiudad(ciudad.getPaisCiudad());
        dto.setRegion(ciudad.getRegion());
        return dto;
    }
}
