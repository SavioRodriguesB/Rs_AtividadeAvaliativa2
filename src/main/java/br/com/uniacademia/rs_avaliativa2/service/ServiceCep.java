/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.uniacademia.rs_avaliativa2.service;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.json.JSONObject;

/**
 *
 * @author savio
 */

@Path("/cep")
public class ServiceCep {
    private final String USER_AGENT = "Mozilla/5.0";
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/get/cep={cep}")
    public String buscarCEP(@PathParam("cep") String cep){
        Gson g = new Gson();
        try {
            
            if(cep.length() != 8){
                return g.toJson("");
            }
            
            Double.parseDouble(cep.trim()); //Evitar letras no cpf
            
            String url = "http://viacep.com.br/ws/" + cep + "/json/";
            String json = sendGet(url);
            return json;
	} catch (Exception e) {
            return g.toJson("");
	}
    }
    
    
    private String sendGet(String url) throws Exception {
       Gson g = new Gson();
       URL obj = new URL(url);
       HttpURLConnection con = (HttpURLConnection) obj.openConnection();
       
       // optional default is GET
       con.setRequestMethod("GET");

       //add request header
       con.setRequestProperty("User-Agent", USER_AGENT);

       int responseCode = con.getResponseCode();
       System.out.println("\nSending 'GET' request to URL : " + url);
       System.out.println("Response Code : " + responseCode);

       BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
       String linha = "";
       
       for (int i = 0; i < 12; i++) {
            linha = linha.concat(in.readLine());
       }
       in.close();
       return linha;
    }
}
