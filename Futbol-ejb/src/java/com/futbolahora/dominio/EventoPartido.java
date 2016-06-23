/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.futbolahora.dominio;

import java.util.Date;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Guillermo
 */
@MappedSuperclass
public abstract class EventoPartido extends EntidadDominio {
    
    
    private Partido partido;
    @Temporal(TemporalType.TIME)
    private Date tiempoEvento;

    public Partido getPartido() {
        return partido;
    }

    public void setPartido(Partido partido) {
        this.partido = partido;
    }
    
    public Date getTiempoEvento() {
        return (Date)this.tiempoEvento.clone();
    }

    public void setTiempoEvento(Date tiempoEvento) {
        this.tiempoEvento = (Date)tiempoEvento.clone();
    }
}
