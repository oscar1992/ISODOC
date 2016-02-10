/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.siscomputo.gestiondocumental.bean;

import co.com.siscomputo.administracion.logic.AccionLogic;
import co.com.siscomputo.endpoint.AccionEntity;
import co.com.siscomputo.endpoint.DocumentoEntity;
import co.com.siscomputo.gestiondocumental.logic.DocumentoLogic;
import co.com.siscomputo.utilidades.ComparadorAccion2;
import co.com.siscomputo.utilidades.MensajesJSF;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;

/**
 *
 * @author LENOVO
 */
@ManagedBean(name = "DatosDocumento")
@ViewScoped
public class DatosDocumento implements Serializable {

    private DocumentoEntity objetoDocumento;
    private AccionEntity accionSiguiente;
    private boolean botonSiguiente;
    private String nombreSiguiente;

    public DocumentoEntity getObjetoDocumento() {
        return objetoDocumento;
    }

    public void setObjetoDocumento(DocumentoEntity objetoDocumento) {
        this.objetoDocumento = objetoDocumento;
    }

    public boolean isBotonSiguiente() {
        return botonSiguiente;
    }

    public void setBotonSiguiente(boolean botonSiguiente) {
        this.botonSiguiente = botonSiguiente;
    }

    public String getNombreSiguiente() {
        return nombreSiguiente;
    }

    public void setNombreSiguiente(String nombreSiguiente) {
        this.nombreSiguiente = nombreSiguiente;
    }

    public DatosDocumento() {
        //cargaDocumento();
    }

    @PostConstruct
    public void init() {
        botonSiguiente = true;
        cargaDocumento();
        tieneSiguienteAccion();
        //context.update(":MoverDocumento:datos");
    }

    public void cargaDocumento() {
        objetoDocumento = new DocumentoEntity();
        objetoDocumento = (DocumentoEntity) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("documento");
        if (objetoDocumento == null) {

        } else {
            System.out.println("DOC: " + objetoDocumento.getTituloDocumento());
        }

    }

    /**
     * Método que pasa un documento de acción
     */
    public void siguienteAccion() {

        objetoDocumento.setAccionDocumento(accionSiguiente);
        int id = ((DocumentoEntity) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("documento")).getIdDocumento();
        objetoDocumento.setIdDocumento(id);
        System.out.println("idDOCUE: ");
        DocumentoLogic documentoLogic = new DocumentoLogic();
        String valida = documentoLogic.actualizarDocumento(objetoDocumento);
        FacesMessage msg = null;
        if ("Ok".equalsIgnoreCase(valida)) {
            msg = new FacesMessage("", "actualización de Documento correcto");
        } else {
            msg = new FacesMessage("", "actualización de Documento incorrecto");
        }

        RequestContext context = RequestContext.getCurrentInstance();
        context.update(":MoverDocumento");

    }

    public void tieneSiguienteAccion() {
        AccionEntity accionaux = objetoDocumento.getAccionDocumento();
        System.out.println("Acción: " + accionaux.getNombreAccion() + " - " + accionaux.getOrdenAccion());
        AccionLogic accionLogic = new AccionLogic();
        ArrayList<AccionEntity> listaAcciones = new ArrayList<>();
        listaAcciones = accionLogic.listaAccion();
        Collections.sort(listaAcciones, new ComparadorAccion2());
        Iterator itr = listaAcciones.iterator();
        while (itr.hasNext()) {
            AccionEntity accion = (AccionEntity) itr.next();
            //if(Integer.parseInt(accion.getOrdenAccion())==Integer.parseInt(accionSiguiente.getOrdenAccion())){
            if (accion.getOrdenAccion().equals(accionaux.getOrdenAccion())) {
                if (itr.hasNext()) {
                    accionSiguiente = (AccionEntity) itr.next();
                    nombreSiguiente = accionSiguiente.getNombreAccion();
                    
                }
                System.out.println("tiene: " + accionaux.getNombreAccion());
            } else {
                System.out.println("no tiene: " + accion.getNombreAccion() + "-" + accion.getOrdenAccion() + "-" + accionaux.getOrdenAccion());

            }
        }
        if(accionSiguiente==null){
            botonSiguiente=false;
        }else{
            System.out.println("lleno?");
        }
    }

    /**
     * Método que permite actualizar un Documento
     */
    public void actualizarDocumento() {
        DocumentoLogic metodoRecuperacionLogic = new DocumentoLogic();
        String valida = metodoRecuperacionLogic.actualizarDocumento(objetoDocumento);
        FacesMessage msg = null;
        if ("Ok".equalsIgnoreCase(valida)) {
            MensajesJSF.muestraMensajes("Documento actualizado Correctamente: " + objetoDocumento.getTituloDocumento(), "Mensaje");
        } else {
            MensajesJSF.muestraMensajes("Documento actualizado Incorrectamente: " + objetoDocumento.getTituloDocumento(), "Error");
        }
        RequestContext conte = RequestContext.getCurrentInstance();
        conte.update(":MoverDocumento");
    }

}
