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
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Guillermo
 */
@Entity
public class Jugador extends EntidadDominio implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private String nombreCompleto;
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;
    private int nroCamiseta;
    
    @ManyToMany(mappedBy="jugadoresLocal")
    private List<Partido> partidosLocal;
    
    @ManyToMany(mappedBy="jugadoresVisitante")
    private List<Partido> partidosVisitante;
  
    public Jugador(){
        partidosLocal = new ArrayList<>();
        partidosVisitante = new ArrayList<>();
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public Date getFechaNacimiento() {
        return this.fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getNroCamiseta() {
        return nroCamiseta;
    }

    public void setNroCamiseta(int nroCamiseta) {
        this.nroCamiseta = nroCamiseta;
    }
    
    public List<Partido> getPartidosLocal() {
        return partidosLocal;
    }

    public void setPartidosLocal(List<Partido> partidosLocal) {
        this.partidosLocal = partidosLocal;
    }
    
    public List<Partido> getPartidosVisitante() {
        return partidosVisitante;
    }

    public void setPartidosVisitante(List<Partido> partidosVisitante) {
        this.partidosVisitante = partidosVisitante;
    }
}
