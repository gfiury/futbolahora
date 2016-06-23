/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.futbolahora.dominio;

import java.io.Serializable;

/**
 *
 * @author Guillermo
 */
public class EventoGolDto extends EventoPartidoDto implements Serializable {
    
    private static final long serialVersionUID = 1L;
        
    private EquipoDto equipo;
    private JugadorDto jugador;

    public EquipoDto getEquipo() {
        return equipo;
    }

    public void setEquipo(EquipoDto equipo) {
        this.equipo = equipo;
    }

    public JugadorDto getJugador() {
        return jugador;
    }

    public void setJugador(JugadorDto jugador) {
        this.jugador = jugador;
    }

    @Override
    public String toString() {
        /*String str = "GOOOOOL de " + equipo.toString();
        str += "\nJugador: " + jugador.toString();
        str += "\nTiempo: " + getTiempoEvento().toString();
        
        str += "\nPARTIDO " + getPartido().getLocal() + " vs " + 
        getPartido().getVisitante();
        
        return str;*/
        
        return "Datos del Evento no disponibles";
    }
    
    
}
