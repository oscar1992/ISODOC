/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.siscomputo.administracion.bean;

import co.com.siscomputo.administracion.logic.PermisosDisponiblesLogic;
import co.com.siscomputo.endpoint.ListaAsignaPermisosModulo;
import co.com.siscomputo.endpoint.ListaAsignaPermisosPermiso;
import co.com.siscomputo.endpoint.MenuPermisosEntity;
import co.com.siscomputo.endpoint.PermisosEntity;
import co.com.siscomputo.endpoint.RolPermisoEntity;
import java.io.Serializable;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
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
    private boolean ingresar;
    private boolean actualizar;
    private boolean eliminar;

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

    public boolean isIngresar() {
        return ingresar;
    }

    public void setIngresar(boolean ingresar) {
        this.ingresar = ingresar;
    }

    public boolean isActualizar() {
        return actualizar;
    }

    public void setActualizar(boolean actualizar) {
        this.actualizar = actualizar;
    }

    public boolean isEliminar() {
        return eliminar;
    }

    public void setEliminar(boolean eliminar) {
        this.eliminar = eliminar;
    }

    @PostConstruct
    public void init() {
        listaSeleccion = new ArrayList<>();
        System.out.println("ROL: " + idRol);
        cargaAcordeon();
        permisos();
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
            listaSeleccionados = new ArrayList<>();
            for (RolPermisoEntity rpe : listaRpe) {
                //System.out.println("PER: "+rpe.getIdPermiso().getNombrePermiso());
                listaSeleccionados.add("" + rpe.getIdPermiso().getIdPermiso());
            }
        }

    }

    /**
     * Método que permite actualizar un permiso
     */
    public void actualizarRolPermiso() {
        System.out.println("ROL: " + idRol);
        System.out.println("TAMA: " + listaSeleccionados.size());
        for (String permiso : listaSeleccionados) {
            System.out.println("PP: " + permiso);
        }
    }

    /**
     * Método que se llama al detectar un cambio en las selecciones
     */
    public void itemSelect() {
        for (String per : listaSeleccionados) {
            System.out.println("ID: " + per);
        }
    }

    /**
     * Método que evalua los accesos al formulario
     */
    public void permisos() {
        ingresar = false;
        actualizar = false;
        eliminar = false;
        ArrayList<MenuPermisosEntity> permisos = (ArrayList<MenuPermisosEntity>) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("menuLateral");
        for (MenuPermisosEntity permisoObj : permisos) {
            for (MenuPermisosEntity nivel1 : permisoObj.getSubNivel()) {
                for (MenuPermisosEntity nivel2 : nivel1.getSubNivel()) {
                    int idPer = (int) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("idPermiso");
                    System.out.println("nn: " + nivel2.getNombrePermiso() + "-" + nivel2.getAsociadoMenu() + " - " + idPer);
                    if (idPer == nivel2.getAsociadoMenu()) {
                        switch (nivel2.getNombrePermiso()) {
                            case "insert":
                                ingresar = true;
                                break;
                            case "update":
                                actualizar = true;
                                break;
                            case "delete":
                                eliminar = true;
                                break;
                        }
                    }
                }
            }
        }
    }
}
