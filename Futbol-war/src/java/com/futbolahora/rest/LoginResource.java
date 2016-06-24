package com.futbolahora.rest;

import com.futbolahora.dominio.bean.UserCodeBean;
import com.futbolahora.dominio.bean.UserTokenBean;
//import javax.json.Json;
//import javax.ws.rs.core.Context;
//import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
//import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import javax.ejb.EJB;
import javax.net.ssl.HttpsURLConnection;
import javax.ws.rs.PathParam;


/**
 * REST Web Service
 *
 * @author nico
 */
@Path("login")
public class LoginResource {
    
    @EJB
    private UserCodeBean userCodeBean;
    
    @EJB
    private UserTokenBean userTokenBean;
    
    private final Gson gson = new Gson();

    public LoginResource() throws Exception{
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response login() throws MalformedURLException, IOException {
        UserCodeBean userCodeBean;
        Gson transformer = new GsonBuilder().create(); 
        
        String url = "https://accounts.google.com/o/oauth2/device/code";
        URL obj = new URL(url);
        HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();

        //add reuqest header
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type","application/x-www-form-urlencoded");
        String urlParameters = "client_id=580821823936-t6i61f73a5nri81thor6k8ffo9ukfkdu.apps.googleusercontent.com&scope=email profile";

        con.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        wr.writeBytes(urlParameters);
        wr.flush();
        wr.close();
        
        BufferedReader in = new BufferedReader(
        new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
        }
        in.close();
                
        userCodeBean = transformer.fromJson(response.toString(), UserCodeBean.class);
        
        /*
        ThreadPoll poll = new ThreadPoll(userCodeBean.getDevice_code(),"580821823936-t6i61f73a5nri81thor6k8ffo9ukfkdu.apps.googleusercontent.com","byRqHI3PuIzmGD6XoAOv0w7h");
        poll.start();
        */
        return Response.ok().entity(gson.toJson(userCodeBean)).build();
       
    }
    
    @GET
    @Path("/{deviceCode}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSessionID(@PathParam("deviceCode") String deviceCode) throws MalformedURLException, IOException, InterruptedException {
        Gson transformer = new GsonBuilder().create();
        
        UserTokenBean userTokenBean;
        String clientId = "580821823936-t6i61f73a5nri81thor6k8ffo9ukfkdu.apps.googleusercontent.com";
        String clientSecret = "byRqHI3PuIzmGD6XoAOv0w7h";
        
        String url = "https://www.googleapis.com/oauth2/v4/token";
        
        
        int responseCode = 400;
        int contador = 0;
        deviceCode = deviceCode.replace("*", "/");
        
        while (responseCode == 400 && contador < 10) {
            URL obj = new URL(url);
            HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();
            
            //add reuqest header
            if (contador == 0){
                con.setRequestMethod("POST");
                con.setRequestProperty("Content-Type","application/x-www-form-urlencoded");                            
            }
            String urlParameters = "client_id=" + clientId + "&client_secret=" + clientSecret + "&code=" + deviceCode + "&grant_type=http://oauth.net/grant_type/device/1.0";
            con.setDoOutput(true);
            DataOutputStream wr = new DataOutputStream(con.getOutputStream());
            wr.writeBytes(urlParameters);
            wr.flush();
            wr.close();

            responseCode = con.getResponseCode();
            Thread.sleep(5000);
            contador += 1;
            
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
            con.disconnect();
        }
        
        
        
        
        
        
        return null;//Response.ok().entity(gson.toJson(dto)).build();
    }
    
   
}
