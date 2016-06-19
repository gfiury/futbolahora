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
public class EventoTarjeta extends EventoPartido {
    
    private Equipo equipo;
    private Jugador jugador;
    private boolean tarjetaAmarilla;
    private boolean expulsion;

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    public boolean isTarjetaAmarilla() {
        return tarjetaAmarilla;
    }

    public void setTarjetaAmarilla(boolean tarjetaAmarilla) {
        this.tarjetaAmarilla = tarjetaAmarilla;
    }

    public boolean isExpulsion() {
        return expulsion;
    }

    public void setExpulsion(boolean expulsion) {
        this.expulsion = expulsion;
    }
}
