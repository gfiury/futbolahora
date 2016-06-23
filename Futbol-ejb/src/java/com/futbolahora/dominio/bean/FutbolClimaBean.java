/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.futbolahora.dominio.bean;

import com.futbolahora.dominio.Ciudad;
import com.futbolahora.dominio.Clima;
import com.futbolahora.dominio.ClimaDto;
import java.util.Date;
import java.util.concurrent.ConcurrentHashMap;
import javax.ejb.Singleton;
import javax.ejb.LocalBean;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

/**
 *
 * @author Guillermo
 */
@Singleton
@LocalBean
public class FutbolClimaBean {

    private final ConcurrentHashMap hashClima;
    private final Client client;
    //Tiempo de 30 Minutos
    private final long MAX_TIME_CACHE = 1800000;
    
    public FutbolClimaBean(){
        client = ClientBuilder.newClient();
        hashClima = new ConcurrentHashMap();
    }
    
    //Guarda en cache el clima
    //Si se consulto el clima, se guarda la ciudad
    //y el momento en que se consulto
    //Si la consulta supera el tiempo de cache
    //se consulta nuevamente, sino se retorna actual
    public ClimaDto getClimaCiudad(Ciudad ciudad){
        Clima climaRegistrado = null;
        Date horaActual = new Date();
        
        if (hashClima.containsKey(ciudad)) {
            climaRegistrado = (Clima)hashClima.get(ciudad);
        }
        
        //Se calcula el tiempo en que
        //se consulto
        if (climaRegistrado != null) {
            Date fechaRegistro = climaRegistrado.getTiempo();
            if (refrescarClima(fechaRegistro, horaActual)) {
                climaRegistrado.setTiempo(horaActual);
                climaRegistrado.setClima(getClimaAccuWeahter(ciudad));
            }
            else{
                //Se retorna el clima que esta cacheado
            }
        }
        else{
            //No se consulto nunca la ciudad
            climaRegistrado = new Clima();
            climaRegistrado.setTiempo(horaActual);
            climaRegistrado.setClima(getClimaAccuWeahter(ciudad));
        }
        
        return toDto(climaRegistrado);
    }
    
    private String getClimaAccuWeahter(Ciudad ciudad){
        return "Soleado";
    }
    
    //Diferencia es mayor, se refresca clima
    private boolean refrescarClima(Date fechaInicio, Date fechaFin){
        //Diferencia en mili segundos
        long diferencia = (fechaFin.getTime() - fechaInicio.getTime());
        return diferencia > MAX_TIME_CACHE;
    }
    
    private ClimaDto toDto(Clima clima){
        ClimaDto dto = new ClimaDto();
        dto.setClima(clima.getClima());
        return dto;
    }
}
