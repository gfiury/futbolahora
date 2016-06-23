/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.futbolahora.dominio.bean;

import com.futbolahora.dominio.Equipo;
import com.futbolahora.dominio.EquipoDto;
import com.futbolahora.dominio.EventoGol;
import com.futbolahora.dominio.EventoGolDto;
import com.futbolahora.dominio.Jugador;
import com.futbolahora.dominio.JugadorDto;
import com.futbolahora.dominio.Partido;
import com.futbolahora.dominio.PartidoDto;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Topic;
import javax.jms.Session;
import javax.jms.TopicConnectionFactory;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Guillermo
 */
@Stateless
@LocalBean
public class FutbolEventoGolBean {

    @PersistenceContext
    private EntityManager em;
    
    @EJB
    private FutbolEquipoBean equipoBean;
    
    @EJB
    private FutbolPartidoBean partidoBean;
    
    @EJB
    private FutbolJugadorBean jugadorBean;
    
    @Resource(lookup = "jms/ConnectionFactory")
    private TopicConnectionFactory connectionFactory;
    
    @Resource(lookup = "jms/Queue")
    private Topic topic;
    
    public EventoGolDto addEventoGol(EquipoDto equipoDto, JugadorDto jugadorDto, 
                                       PartidoDto partidoDto, EventoGolDto dto){
        Equipo equipo = em.find(Equipo.class, equipoDto.getId());
        Jugador jugador = em.find(Jugador.class, jugadorDto.getId());
        Partido partido = em.find(Partido.class, partidoDto.getId());
        return crearEventoGol(equipo, jugador, partido, dto);
    }
    
    private void sendNotification(EventoGolDto dto) throws JMSException {
        Connection connection = null;
        
        try {
            connection = connectionFactory.createConnection();
            Session session = connection.createSession();
            MessageProducer producer = session.createProducer(topic);
            //System.out.println(dto);
            ObjectMessage msg = session.createObjectMessage(dto);
            producer.send(msg);
            session.close();
            connection.close();
        } catch (JMSException ex) {
            //Logger.getLogger(BookBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            if (connection != null) {
                connection.close();
            }

        }
    }
    
    private EventoGolDto crearEventoGol(Equipo equipo, Jugador jugador, 
                                        Partido partido, EventoGolDto dto){
        try{
            EventoGol evento = eventoGolToEntity(dto);
            evento.setEquipo(equipo);
            evento.setJugador(jugador);
            evento.setPartido(partido);
            em.persist(evento);
            EventoGolDto result = eventoGolToDto(evento);
            sendNotification(result);
            return result;
        }
        catch(Exception ex){
            return null;
        }
    }
    
    private EventoGol eventoGolToEntity(EventoGolDto dto){
        EventoGol eventoG = new EventoGol();
        eventoG.setTiempoEvento(dto.getTiempoEvento());
        return eventoG;
    }
    
    private EventoGolDto eventoGolToDto(EventoGol evento){
        EventoGolDto dto = new EventoGolDto();
        dto.setId(evento.getId());
        dto.setTiempoEvento(evento.getTiempoEvento());
        dto.setEquipo(equipoBean.toDto(evento.getEquipo()));
        dto.setPartido(partidoBean.toDto(evento.getPartido()));
        dto.setJugador(jugadorBean.toDto(evento.getJugador()));
        return dto;
    }
    
    public EventoGolDto findEventoGolById(Long id){
        return eventoGolToDto(em.find(EventoGol.class, id));
    }
}
