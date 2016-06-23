/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.futbolahora.cliente;

import java.util.Properties;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;

/**
 *
 * @author Guillermo
 */
@Stateless
@LocalBean
public class MailBean {

    public void enviarMail(String to, String subject, String body) {
        //TODO: cambiar from, username y password
        final String from = "martinboxgonzalez@outlook.com";
        final String password = "Martin222";
        String host = "smtp-mail.outlook.com";
        int port = 587;
        try {
           MultiPartEmail email = new MultiPartEmail();
           Authenticator auth = new DefaultAuthenticator(from, password);
           email.setDebug(true);
           email.setSmtpPort(port);
           email.setAuthenticator(auth);
           email.setHostName(host);
           email.setFrom(from);
           email.setSubject(subject);
           email.setMsg(body);
           email.addTo(to);
           email.setTLS(true);
           
           email.send();
        } catch (EmailException e) {
            throw new RuntimeException(e);
        }
   }
}
