/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.uniacademia.rs_avaliativa2.service;

import com.google.gson.Gson;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author savio
 */

@Path("/formatar")
public class ServiceFormatacao {
    
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/get/cpf={cpf}")
    public String formatarCPF(@PathParam("cpf") String cpf){
        Gson g = new Gson();
        try {
            
            if(cpf.length() != 11){
                return g.toJson("");
            }
            
            Double.parseDouble(cpf.trim()); //Evitar letras no cpf
            
            javax.swing.text.MaskFormatter mascara = new javax.swing.text.MaskFormatter("###.###.###-##");
            javax.swing.JFormattedTextField cpfFormatado = new javax.swing.JFormattedTextField(mascara);
           
            cpfFormatado.setText(cpf);
            return g.toJson(cpfFormatado.getText());
	} catch (Exception e) {
            return g.toJson("");
	}
    }
}
