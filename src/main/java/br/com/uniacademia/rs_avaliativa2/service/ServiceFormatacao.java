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
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/get/cnpj={cnpj}")
    public String formatarCNPJ(@PathParam("cnpj") String cnpj){
        Gson g = new Gson();
        try {
            
            if(cnpj.length() != 14){
                return g.toJson("");
            }
            
            Double.parseDouble(cnpj.trim()); //Evitar letras no cpf
            
            javax.swing.text.MaskFormatter mascara = new javax.swing.text.MaskFormatter("##.###.###/####-##");
            javax.swing.JFormattedTextField cnpjFormatado = new javax.swing.JFormattedTextField(mascara);
           
            cnpjFormatado.setText(cnpj);
            return g.toJson(cnpjFormatado.getText());
	} catch (Exception e) {
            return g.toJson("");
	}
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/get/cep={cep}")
    public String formatarCEP(@PathParam("cep") String cep){
        Gson g = new Gson();
        try {
            
            if(cep.length() != 8){
                return g.toJson("");
            }
            
            Double.parseDouble(cep.trim()); //Evitar letras no cpf
            
            javax.swing.text.MaskFormatter mascara = new javax.swing.text.MaskFormatter("#####-###");
            javax.swing.JFormattedTextField cepFormatado = new javax.swing.JFormattedTextField(mascara);
           
            cepFormatado.setText(cep);
            return g.toJson(cepFormatado.getText());
	} catch (Exception e) {
            return g.toJson("");
	}
    }
}
