/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.futbolahora.dominio;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Guillermo
 */
public class PartidoDto implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private Long id;
    private Date fechaComienzoPartido;
    private EstadioDto estadio;
    private EquipoDto local;
    private EquipoDto visitante;
    private int scoreLocal;
    private int scoreVisitante;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFechaComienzoPartido() {
        return fechaComienzoPartido;
    }

    public void setFechaComienzoPartido(Date fechaComienzoPartido) {
        this.fechaComienzoPartido = fechaComienzoPartido;
    }

    public EstadioDto getEstadio() {
        return estadio;
    }

    public void setEstadio(EstadioDto estadio) {
        this.estadio = estadio;
    }

    public EquipoDto getLocal() {
        return local;
    }

    public void setLocal(EquipoDto local) {
        this.local = local;
    }

    public EquipoDto getVisitante() {
        return visitante;
    }

    public void setVisitante(EquipoDto visitante) {
        this.visitante = visitante;
    }

    public int getScoreLocal() {
        return scoreLocal;
    }

    public void setScoreLocal(int scoreLocal) {
        this.scoreLocal = scoreLocal;
    }

    public int getScoreVisitante() {
        return scoreVisitante;
    }

    public void setScoreVisitante(int scoreVisitante) {
        this.scoreVisitante = scoreVisitante;
    }
    
    
}
