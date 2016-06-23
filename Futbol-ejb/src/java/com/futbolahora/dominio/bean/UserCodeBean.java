/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.futbolahora.dominio.bean;

import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author nico
 */
@Stateless
@LocalBean
public class UserCodeBean {
    private String verification_url;
    private String expires_in;
    private String interval;
    private String device_code;
    private String user_code;

    public String getVerification_url() {
        return verification_url;
    }

    public String getExpires_in() {
        return expires_in;
    }

    public String getInterval() {
        return interval;
    }

    public String getDevice_code() {
        return device_code;
    }

    public String getUser_code() {
        return user_code;
    }

    public void setVerification_url(String verification_url) {
        this.verification_url = verification_url;
    }

    public void setExpires_in(String expires_in) {
        this.expires_in = expires_in;
    }

    public void setInterval(String interval) {
        this.interval = interval;
    }

    public void setDevice_code(String device_code) {
        this.device_code = device_code;
    }

    public void setUser_code(String user_code) {
        this.user_code = user_code;
    }
    
    
}
