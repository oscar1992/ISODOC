/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.siscomputo.gestiondocumental.entities;

import co.com.siscomputo.endpoint.AccionEntity;
import java.util.ArrayList;
import org.primefaces.model.DualListModel;

/**
 *
 * @author LENOVO
 */
public class GrupoUsuarioAccionProcesoEntity {
    private AccionEntity accion;
    private DualListModel seleccionDual;
    private ArrayList<String> nombres;
    private ArrayList<String> selecion;

    public AccionEntity getAccion() {
        return accion;
    }

    public void setAccion(AccionEntity accion) {
        this.accion = accion;
    }

    public DualListModel getSeleccionDual() {
        return seleccionDual;
    }

    public void setSeleccionDual(DualListModel seleccionDual) {
        this.seleccionDual = seleccionDual;
    }

    public ArrayList<String> getNombres() {
        return nombres;
    }

    public void setNombres(ArrayList<String> nombres) {
        this.nombres = nombres;
    }

    public ArrayList<String> getSelecion() {
        return selecion;
    }

    public void setSelecion(ArrayList<String> selecion) {
        this.selecion = selecion;
    }
    
}
