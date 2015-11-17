/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.siscomputo.administracion.bean;

import co.com.siscomputo.administracion.logic.PermisosDisponiblesLogic;
import co.com.siscomputo.endpoint.ListaAsignaPermisosModulo;
import co.com.siscomputo.endpoint.ListaAsignaPermisosPermiso;
import co.com.siscomputo.endpoint.PermisosEntity;
import co.com.siscomputo.endpoint.RolPermisoEntity;
import java.io.Serializable;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.event.ItemSelectEvent;

/**
 *
 * @author LENOVO
 */
@ManagedBean(name = "PermisosDisponibles")
@ViewScoped
public class permisosDisponiblesBean implements Serializable {

    private ArrayList<ListaAsignaPermisosModulo> listaPermisos;
    private ArrayList<RolPermisoEntity> listaSeleccion;
    private ArrayList<String> listaSeleccionados;
    private Integer idRol;

    public ArrayList<ListaAsignaPermisosModulo> getListaPermisos() {
        return listaPermisos;
    }

    public void setListaPermisos(ArrayList<ListaAsignaPermisosModulo> listaPermisos) {
        this.listaPermisos = listaPermisos;
    }

    public ArrayList<RolPermisoEntity> getListaSeleccion() {
        return listaSeleccion;
    }

    public void setListaSeleccion(ArrayList<RolPermisoEntity> listaSeleccion) {
        this.listaSeleccion = listaSeleccion;
    }

    public ArrayList<String> getListaSeleccionados() {
        return listaSeleccionados;
    }

    public void setListaSeleccionados(ArrayList<String> listaSeleccionados) {
        this.listaSeleccionados = listaSeleccionados;
    }


    public Integer getIdRol() {
        return idRol;
    }

    public void setIdRol(Integer idRol) {
        this.idRol = idRol;
    }

    @PostConstruct
    public void init() {
        listaSeleccion = new ArrayList<>();
        System.out.println("ROL: "+idRol);
        cargaAcordeon();
        
    }

    /**
     * Método que carga el acordeon para mostrar los permisos
     */
    public void cargaAcordeon() {
        PermisosDisponiblesLogic permisosDisponiblesLogic = new PermisosDisponiblesLogic();
        listaPermisos = permisosDisponiblesLogic.listaPermisosDisponibles();
    }
    /**
     * Método que carga los chulos de acuerdo al rol
     */
    public void camabiaRol() {
        listaSeleccionados = new ArrayList<>();
        PermisosDisponiblesLogic permisosDisponiblesLogic = new PermisosDisponiblesLogic();
        if (idRol != null) {
            ArrayList<RolPermisoEntity> listaRpe = permisosDisponiblesLogic.listaRolPermiso(idRol);
            listaSeleccionados=new ArrayList<>();
            for(RolPermisoEntity rpe:listaRpe){
                //System.out.println("PER: "+rpe.getIdPermiso().getNombrePermiso());
                listaSeleccionados.add(""+rpe.getIdPermiso().getIdPermiso());
            }
        }
        
    }
    
    public void actualizarRolPermiso(){
        System.out.println("ROL: "+idRol);
        System.out.println("TAMA: "+listaSeleccionados.size());
    }
    
    public void itemSelect(){
       for(String per:listaSeleccionados){
           System.out.println("ID: "+per);
       }
    }
}
