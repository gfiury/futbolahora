/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.futbolahora.dominio;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Guillermo
 */
public abstract class EventoPartido extends EntidadDominio {
    
    private Partido partido;
    @Temporal(TemporalType.TIME)
    private Date tiempoEvento;
    private InstanciaPartido instancia;

    public Partido getPartido() {
        return partido;
    }

    public void setPartido(Partido partido) {
        this.partido = partido;
    }
    
    public Date getTiempoEvento() {
        return tiempoEvento;
    }

    public void setTiempoEvento(Date tiempoEvento) {
        this.tiempoEvento = tiempoEvento;
    }
    
    public InstanciaPartido getInstancia() {
        return instancia;
    }

    public void setInstancia(InstanciaPartido instancia) {
        this.instancia = instancia;
    }
}
