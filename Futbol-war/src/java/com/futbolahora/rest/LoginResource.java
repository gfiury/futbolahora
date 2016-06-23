/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.futbolahora.rest;

//import javax.json.JsonObject;
import javax.json.Json;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
//import javax.ws.rs.POST;
import javax.ws.rs.Path;
//import javax.ws.rs.PUT;
//import javax.ws.rs.client.Client;
//import javax.ws.rs.client.ClientBuilder;
//import javax.ws.rs.client.Entity;
//import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
//import javax.ws.rs.client.Invocation.Builder;
import com.google.gson.Gson;
//import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;


/**
 * REST Web Service
 *
 * @author nico
 */
@Path("login")
public class LoginResource {
    private final Gson gson = new Gson();

    public LoginResource() throws Exception{
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response login() throws MalformedURLException, IOException {
        
        String responseStr = "";
        String url = "https://accounts.google.com/o/oauth2/device/code";
        URL obj = new URL(url);
        HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();

        //add reuqest header
        con.setRequestMethod("POST");
        //con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
        con.setRequestProperty("Content-Type","application/x-www-form-urlencoded");
        String urlParameters = "client_id=580821823936-t6i61f73a5nri81thor6k8ffo9ukfkdu.apps.googleusercontent.com&scope=email profile";

        // Send post request
        con.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        wr.writeBytes(urlParameters);
        wr.flush();
        wr.close();

        int responseCode = con.getResponseCode();
        
        BufferedReader in = new BufferedReader(
        new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
        }
        in.close();
        
        //responseStr = response.toString();
        for (int i = 0; i < response.length() -1; i++) {
            char indice = response.charAt(i);
            if(indice != '"'){
                responseStr += indice;
            }
            else{
                responseStr += "\"";
            }
        }
        //'"'
        //print result
        //System.out.println(response.toString());

        
        return Response.ok().entity(gson.toJson(responseStr)).build();
       
       //return "holaa mundo";
    }
}
