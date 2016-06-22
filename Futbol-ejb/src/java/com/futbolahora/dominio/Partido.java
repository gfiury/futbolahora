/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.futbolahora.dominio;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Guillermo
 */
@Entity
public class Partido extends EntidadDominio {
    
    private Estadio estadio;
    @Temporal(TemporalType.DATE)
    private Date fechaComienzoPartido;
    private Equipo local;
    private Equipo visitante;
    private ArrayList<Jugador> jugadoresLocal;
    private ArrayList<Jugador> jugadoresVisitante;
    private int scoreLocal;
    private int scoreVisistante;
    
    //Falta clima

    public Estadio getEstadio() {
        return estadio;
    }

    public void setEstadio(Estadio estadio) {
        this.estadio = estadio;
    }

    public Date getFechaComienzoPartido() {
        return fechaComienzoPartido;
    }

    public void setFechaComienzoPartido(Date fechaComienzoPartido) {
        this.fechaComienzoPartido = fechaComienzoPartido;
    }
    
    public Equipo getLocal() {
        return local;
    }

    public void setLocal(Equipo local) {
        this.local = local;
    }

    public Equipo getVisitante() {
        return visitante;
    }

    public void setVisitante(Equipo visitante) {
        this.visitante = visitante;
    }

    public int getScoreLocal() {
        return scoreLocal;
    }

    public void setScoreLocal(int scoreLocal) {
        this.scoreLocal = scoreLocal;
    }

    public int getScoreVisistante() {
        return scoreVisistante;
    }

    public void setScoreVisistante(int scoreVisistante) {
        this.scoreVisistante = scoreVisistante;
    }
    
    public Collection<Jugador> getJugadoresLocal() {
        return jugadoresLocal;
    }
    
    public void agregarJugadorLocal(Jugador jugador){
        this.jugadoresLocal.add(jugador);
    }

    public Collection<Jugador> getJugadoresVisitante() {
        return jugadoresVisitante;
    }
    
    public void agregarJugadorVisitante(Jugador jugador){
        this.jugadoresVisitante.add(jugador);
    }
}
