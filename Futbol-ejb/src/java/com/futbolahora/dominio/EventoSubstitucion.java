/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.futbolahora.dominio;

/**
 *
 * @author Guillermo
 */
public class EventoSubstitucion extends EventoPartido {
    
    private Equipo equipo;
    private Jugador entra;
    private Jugador sale;

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public Jugador getEntra() {
        return entra;
    }

    public void setEntra(Jugador entra) {
        this.entra = entra;
    }

    public Jugador getSale() {
        return sale;
    }

    public void setSale(Jugador sale) {
        this.sale = sale;
    }
    
    
}
