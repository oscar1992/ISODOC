/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.siscomputo.gestiondocumental.entities;

import co.com.siscomputo.endpoint.ProcesoEntity;
import java.util.ArrayList;

/**
 *
 * @author LENOVO
 */
public class ArbolProcesoEntity {
    private String nombreProceso;
    private int idProceso;
    private ArrayList<ArbolProcesoEntity>listaProcesos;

    public String getNombreProceso() {
        return nombreProceso;
    }

    public void setNombreProceso(String nombreProceso) {
        this.nombreProceso = nombreProceso;
    }

    public int getIdProceso() {
        return idProceso;
    }

    public void setIdProceso(int idProceso) {
        this.idProceso = idProceso;
    }

    public ArrayList<ArbolProcesoEntity> getListaProcesos() {
        return listaProcesos;
    }

    public void setListaProcesos(ArrayList<ArbolProcesoEntity> listaProcesos) {
        this.listaProcesos = listaProcesos;
    }

    
}
