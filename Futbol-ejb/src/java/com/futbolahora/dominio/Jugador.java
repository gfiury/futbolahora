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
@Entity
public class Jugador extends EntidadDominio {
    
    private String nombreCompleto;
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;
    private Ciudad ciudadNacimiento;
    private int nroCamiseta;
    private Posicion posicion;

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Ciudad getCiudadNacimiento() {
        return ciudadNacimiento;
    }

    public void setCiudadNacimiento(Ciudad ciudadNacimiento) {
        this.ciudadNacimiento = ciudadNacimiento;
    }

    public int getNroCamiseta() {
        return nroCamiseta;
    }

    public void setNroCamiseta(int nroCamiseta) {
        this.nroCamiseta = nroCamiseta;
    }

    public Posicion getPosicion() {
        return posicion;
    }

    public void setPosicion(Posicion posicion) {
        this.posicion = posicion;
    }
    
    public enum Posicion{
        Golero,
        Defensa,
        Medio_Campista,
        Delantero
    }
}
