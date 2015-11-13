/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.siscomputo.utilidades;

import java.io.IOException;
import java.io.Serializable;
import javax.faces.application.ViewExpiredException;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

/**
 *
 * @author LENOVO
 */
@ManagedBean(name = "Valida")
public class ValidaSesion implements Serializable{
    private ExternalContext contexto=FacesContext.getCurrentInstance().getExternalContext();  
    /**
     * Método que evalua la validez de la sesión
     */
    public void valida(){              
        if(contexto.getSessionMap().size()==0||contexto.getSessionMap().get("idUsuario")==null){                        
            try {
            contexto.redirect("/ISODOC/index.jsf");
        } catch (IOException ex) {
            throw new ViewExpiredException();
        }
                        
        }else{
            System.out.println("vive");
        }
        System.out.println("sesion: "+contexto.getSessionMap().size()); 
        System.out.println("sesion: "+contexto.getSessionMap().get("idUsuario")); 
        
    }
    /**
     * Método que cierra la sesión
     */
    public void cerrar(){
        System.out.println("Sale");
        try {
            contexto.redirect("/ISODOC/index.jsf");
        } catch (IOException ex) {
            throw new ViewExpiredException();   
        }
        contexto.invalidateSession();
         
    }
}
