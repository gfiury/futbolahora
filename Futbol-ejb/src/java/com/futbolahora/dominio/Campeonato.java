/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.futbolahora.dominio;

import java.util.ArrayList;
import javax.persistence.Entity;

/**
 *
 * @author Guillermo
 */
@Entity
public class Campeonato extends EntidadDominio {
    
    private String nombre;
    private ArrayList<Partido> partidos;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public void agregarPartido(Partido partido){
        partidos.add(partido);
    }
}
