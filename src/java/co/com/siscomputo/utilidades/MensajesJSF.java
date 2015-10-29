/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.siscomputo.utilidades;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author LENOVO
 */
public class MensajesJSF {

    /**
     * Funcion la cual muestra los mensajes
     *
     * @param mensaje
     * @param tipo
     */
    public static void muestraMensajes(String mensaje, String tipo) {
        FacesMessage message = null;
        if ("Error".equalsIgnoreCase(tipo)) {
            message = new FacesMessage(FacesMessage.SEVERITY_ERROR, mensaje, null);
        } else if ("Mensaje".equalsIgnoreCase(tipo)) {
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, mensaje, null);
        } else {
            message = new FacesMessage(FacesMessage.SEVERITY_WARN, mensaje, null);
        }

        FacesContext.getCurrentInstance().addMessage(null, message);

    }
}
