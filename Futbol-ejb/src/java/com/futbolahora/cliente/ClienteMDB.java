/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.futbolahora.cliente;

import com.futbolahora.dominio.EventoPartidoDto;
import com.futbolahora.dominio.bean.FutbolEventoGolBean;
import java.io.Serializable;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

/**
 *
 * @author Guillermo
 */
@MessageDriven(activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "jms/Queue"),
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Topic")
})
public class ClienteMDB implements MessageListener {
    
    @EJB
    private MailBean mailBean;
    
    @EJB
    private FutbolEventoGolBean eventoGol;

    public ClienteMDB() {
    }
    
    @Override
    public void onMessage(Message message) {
        
        try {
            ObjectMessage om = (ObjectMessage) message;
            Serializable objectData = om.getObject();
            EventoPartidoDto evento = (EventoPartidoDto) objectData;
            //EventoPartidoDto eventoConDatos = (EventoGolDto)eventoGol.findEventoGolById(evento.getId());
            mailBean.enviarMail("nicoblank@gmail.com", "Mail de Futbol Ahora", evento.toString());
            
        } catch (JMSException ex) {
            //Logger.getLogger(PintorMDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
