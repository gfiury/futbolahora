/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.futbolahora.dominio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Guillermo
 */
@Entity
public class Partido extends EntidadDominio implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @ManyToOne
    private Estadio estadio;
    @Temporal(TemporalType.DATE)
    private Date fechaComienzoPartido;
    @ManyToOne
    private Equipo local;
    @ManyToOne
    private Equipo visitante;
    @ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(name="jugadores_local")
    private List<Jugador> jugadoresLocal;
    @ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(name="jugadores_visitante")
    private List<Jugador> jugadoresVisitante;
    private int scoreLocal;
    private int scoreVisistante;
    
    //Falta clima
    
    public Partido(){
        jugadoresLocal = new ArrayList<>();
        jugadoresVisitante = new ArrayList<>();
    }

    public Estadio getEstadio() {
        return estadio;
    }

    public void setEstadio(Estadio estadio) {
        this.estadio = estadio;
    }

    public Date getFechaComienzoPartido() {
        return (Date)this.fechaComienzoPartido.clone();
    }

    public void setFechaComienzoPartido(Date fechaComienzoPartido) {
        this.fechaComienzoPartido = (Date)fechaComienzoPartido.clone();
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
    
    public List<Jugador> getJugadoresLocal() {
        return jugadoresLocal;
    }

    public void setJugadoresLocal(List<Jugador> jugadoresLocal) {
        this.jugadoresLocal = jugadoresLocal;
    }
    
    public void agregarJugadorLocal(Jugador jugador){
        this.jugadoresLocal.add(jugador);
    }

    public List<Jugador> getJugadoresVisitante() {
        return jugadoresVisitante;
    }

    public void setJugadoresVisitante(List<Jugador> jugadoresVisitante) {
        this.jugadoresVisitante = jugadoresVisitante;
    }
    
    public void agregarJugadorVisitante(Jugador jugador){
        this.jugadoresVisitante.add(jugador);
    } 
    
}
