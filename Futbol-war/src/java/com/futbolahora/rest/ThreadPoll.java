package com.futbolahora.rest;

import com.futbolahora.dominio.bean.UserTokenBean;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.HttpsURLConnection;

/**
 *
 * @author nico
 */
public class ThreadPoll extends Thread {
    String deviceCode;
    String clientId;
    String clientSecret;
    
    

    public ThreadPoll(String device,String client,String secret) {
        deviceCode = device;
        clientId = client;
        clientSecret = secret;
    }
    
    public void run() {
        System.out.println(deviceCode);
        try {
            poll(deviceCode, clientId,clientSecret);
        } catch (InterruptedException ex) {
            //Logger.getLogger(ThreadPoll.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            //Logger.getLogger(ThreadPoll.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     public void poll(String deviceCode,String clientId,String clientSecret) throws InterruptedException, MalformedURLException, IOException{
        Gson transformer = new GsonBuilder().create();
        
        UserTokenBean userTokenBean;
        
        String url = "https://www.googleapis.com/oauth2/v4/token";
        URL obj = new URL(url);
        HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();

        //add reuqest header
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type","application/x-www-form-urlencoded");
        String urlParameters = "client_id=" + clientId + "&client_secret=" + clientSecret + "&code=" + deviceCode + "&grant_type=http://oauth.net/grant_type/device/1.0";

        con.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        wr.writeBytes(urlParameters);
        wr.flush();
        wr.close();
        
        int responseCode = con.getResponseCode();
        
        if (responseCode != 400){
            
            BufferedReader in = new BufferedReader(
            new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
            }
            in.close();

            userTokenBean = transformer.fromJson(response.toString(), UserTokenBean.class);           
            
        }
        
               
        
    }
   
}
