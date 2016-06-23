/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.futbolahora.dominio;

import java.util.Date;

/**
 *
 * @author Guillermo
 */
public abstract class EventoPartidoDto {
    
    private Long id;
    private PartidoDto partido;
    private Date tiempoEvento;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public PartidoDto getPartido() {
        return partido;
    }

    public void setPartido(PartidoDto partido) {
        this.partido = partido;
    }
    
    public Date getTiempoEvento() {
        return (Date)this.tiempoEvento.clone();
    }

    public void setTiempoEvento(Date tiempoEvento) {
        this.tiempoEvento = (Date)tiempoEvento.clone();
    }
}
