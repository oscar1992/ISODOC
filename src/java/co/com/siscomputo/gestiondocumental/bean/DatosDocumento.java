/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.siscomputo.gestiondocumental.bean;

import co.com.siscomputo.endpoint.AccionEntity;
import co.com.siscomputo.endpoint.DocumentoEntity;
import co.com.siscomputo.gestiondocumental.logic.DocumentoLogic;
import java.io.Serializable;
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
public class DatosDocumento implements Serializable{
    private DocumentoEntity objetoDocumento;

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
    public void init(){
        botonSiguiente=true;
        cargaDocumento();
        
        //context.update(":MoverDocumento:datos");
    }
    
    public void cargaDocumento(){
        objetoDocumento=new DocumentoEntity();
        objetoDocumento = (DocumentoEntity) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("Documento");
        if(objetoDocumento==null){            
            
        }else{
            System.out.println("DOC: " + objetoDocumento.getTituloDocumento());
        }
        
    }
    
    
    
    public void siguienteAccion(){
        //objetoDocumento.setAccionDocumento(accionSiguiente);
        DocumentoLogic documentoLogic=new DocumentoLogic();
        String valida = documentoLogic.actualizarDocumento(objetoDocumento);
        FacesMessage msg = null;
        if ("Ok".equalsIgnoreCase(valida)) {
            msg = new FacesMessage("", "actualización de Documento correcto");
            
        } else {
            msg = new FacesMessage("", "actualización de Documento incorrecto");
        }
        //RequestContext context = RequestContext.getCurrentInstance();
        
        //RequestContext.getCurrentInstance().execute("PF('actualizarDocumento').hide()");
        
    }
}
