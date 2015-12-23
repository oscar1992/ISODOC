/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.siscomputo.gestiondocumental.entities;

import co.com.siscomputo.endpoint.AccionEntity;
import co.com.siscomputo.endpoint.DocumentoEntity;
import java.util.ArrayList;

/**
 *
 * @author LENOVO
 */
public class PorEstadoEntity {
    private ArrayList<DocumentoEntity> documentosAccion;
    private AccionEntity accion;

    public ArrayList<DocumentoEntity> getDocumentosAccion() {
        return documentosAccion;
    }

    public void setDocumentosAccion(ArrayList<DocumentoEntity> documentosAccion) {
        this.documentosAccion = documentosAccion;
    }

    
    public AccionEntity getAccion() {
        String nombre=accion.getNombreAccion().toUpperCase();
        accion.setNombreAccion(nombre);
        return accion;
    }

    public void setAccion(AccionEntity accion) {
        this.accion = accion;
    }
    
    
}
