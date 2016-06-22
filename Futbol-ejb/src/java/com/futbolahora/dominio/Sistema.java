/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.futbolahora.dominio;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


public class Sistema {
    
    @PersistenceContext
    private EntityManager em;
        
    private static Sistema instancia;
    
    public static Sistema getInstancia(){
        if (instancia == null) {
            instancia = new Sistema();
        }
        
        return instancia;
    }
    
    private Sistema(){
        crearDatosPrueba();
    }
    
    private void crearDatosPrueba(){
        Partido partido = new Partido();
        
        Equipo equipoLocal = new Equipo();
        equipoLocal.setNombre("Uruguay");
        em.persist(equipoLocal);
        
        partido.setLocal(equipoLocal);
        
        Jugador muslera = crearJugador("Fernando Muslera", 1);
        partido.agregarJugadorLocal(muslera);
        
        Jugador godin = crearJugador("Diego Godin", 2);
        partido.agregarJugadorLocal(godin);
        
        Jugador joseG = crearJugador("Josema Gimenez", 3);
        partido.agregarJugadorLocal(joseG);
        
        Jugador maxiPe = crearJugador("El mono Pereira", 4);
        partido.agregarJugadorLocal(maxiPe);
        
        Jugador palito = crearJugador("Palito Pereira", 5);
        partido.agregarJugadorLocal(palito);
        
        Jugador cacha = crearJugador("El cacha", 6);
        partido.agregarJugadorLocal(cacha);
        
        Jugador cebolla = crearJugador("El cebolla", 7);
        partido.agregarJugadorLocal(cebolla);
        
        Jugador tata = crearJugador("Tata Gonzalez", 8);
        partido.agregarJugadorLocal(tata);
        
        Jugador lodeiro = crearJugador("Nicolas Lodeiro", 9);
        partido.agregarJugadorLocal(lodeiro);
        
        Jugador pato = crearJugador("Pato Sanchez", 12);
        partido.agregarJugadorLocal(pato);
        
        Jugador suarez = crearJugador("Luis Suarez", 10);
        partido.agregarJugadorLocal(suarez);
        
        //VISITANTE
        
        Equipo equipoVisitante = new Equipo();
        equipoVisitante.setNombre("Argentina");
        em.persist(equipoVisitante);
        
        partido.setVisitante(equipoVisitante);
        
        Jugador romero = crearJugador("Sergio Romero", 1);
        partido.agregarJugadorVisitante(romero);
        
        Jugador rojo = crearJugador("Marcos Rojo", 2);
        partido.agregarJugadorVisitante(rojo);
        
        Jugador otamendi = crearJugador("Nicolás Otamendi", 3);
        partido.agregarJugadorVisitante(otamendi);
        
        Jugador mori = crearJugador("Ramiro Funes Mori", 4);
        partido.agregarJugadorVisitante(mori);
        
        Jugador mascherano = crearJugador("Javier Mascherano", 5);
        partido.agregarJugadorVisitante(mascherano);
        
        Jugador banega = crearJugador("Éver Banega", 6);
        partido.agregarJugadorVisitante(banega);
        
        Jugador biglia = crearJugador("Lucas Biglia", 7);
        partido.agregarJugadorVisitante(biglia);
        
        Jugador messi = crearJugador("Lionel Messi", 10);
        partido.agregarJugadorVisitante(messi);
        
        Jugador higuain = crearJugador("Gonzalo Higuaín", 9);
        partido.agregarJugadorVisitante(higuain);
        
        Jugador diMaria = crearJugador("Angel Di María", 11);
        partido.agregarJugadorVisitante(diMaria);
        
        Jugador lavezzi = crearJugador("Ezequiel Lavezzi", 8);
        partido.agregarJugadorVisitante(lavezzi);
        
        em.persist(partido);
        
    }
    
    private Jugador crearJugador(String nombre, int camiseta){
        Jugador jugador = new Jugador();
        jugador.setNombreCompleto(nombre);
        jugador.setNroCamiseta(camiseta);
        em.persist(jugador);
        return jugador;
    }
}
