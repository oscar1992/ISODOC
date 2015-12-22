/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.siscomputo.gestiondocumental.entities;

import co.com.siscomputo.endpoint.AccionEntity;
import co.com.siscomputo.endpoint.GrupoUsuariosEntity;
import java.util.ArrayList;
import org.primefaces.model.DualListModel;

/**
 *
 * @author LENOVO
 */
public class GrupoUsuarioAccionProcesoEntity {
    private AccionEntity accion;
    private DualListModel<GrupoUsuariosEntity> seleccionDual;
    private ArrayList<String> nombres;
    private ArrayList<String> selecion;
    private String fechaLimite;

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



    

    public String getFechaLimite() {
        String retorna = fechaLimite;
        int dia = 0;
        int mes = 0;
        try {
            dia = Integer.parseInt(fechaLimite.substring(0, 2));
            mes = Integer.parseInt(fechaLimite.substring(3, 5));
        } catch (NumberFormatException numberFormatException) {
        }
        if(dia>31){            
            //System.out.println("se pasó");
            retorna = fechaLimite.replaceAll(""+dia, "31");
        }
        if(mes>12){            
            //System.out.println("se pasó mm");
            retorna = fechaLimite.replaceAll(""+mes, "12");
        }
        
        return retorna;
    }

    public void setFechaLimite(String fechaLimite) {
        this.fechaLimite = fechaLimite;
    }

    
}
