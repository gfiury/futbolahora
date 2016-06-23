/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.futbolahora.dominio;

import java.util.Date;

/**
 *
 * @author Guillermo
 */
public class Clima {
    
    private Date tiempo;
    private String clima;
    
    public Clima(){
    }

    public Date getTiempo() {
        return (Date)this.tiempo.clone();
    }

    public void setTiempo(Date tiempo) {
        this.tiempo = (Date)tiempo.clone();
    }

    public String getClima() {
        return clima;
    }

    public void setClima(String clima) {
        this.clima = clima;
    }
}
