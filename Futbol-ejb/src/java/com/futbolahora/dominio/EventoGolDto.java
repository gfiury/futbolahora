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
public class EventoGolDto extends EventoPartidoDto {
    
    private EquipoDto equipoDto;
    private JugadorDto jugadorDto;

    public EquipoDto getEquipo() {
        return equipoDto;
    }

    public void setEquipo(EquipoDto equipo) {
        this.equipoDto = equipo;
    }

    public JugadorDto getJugador() {
        return jugadorDto;
    }

    public void setJugador(JugadorDto jugador) {
        this.jugadorDto = jugador;
    }   
}
