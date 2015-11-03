/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.siscomputo.administracion.bean;

import co.com.siscomputo.administracion.logic.PermisosDisponiblesLogic;
import co.com.siscomputo.endpoint.ListaAsignaPermisosModulo;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author LENOVO
 */
@ManagedBean(name = "PermisosDisponibles")
@ViewScoped
public class permisosDisponiblesBean {
    private ArrayList<ListaAsignaPermisosModulo> lista;
    private ArrayList<ListaAsignaPermisosModulo> listaFiltro;
    private ListaAsignaPermisosModulo permisoObjeto;

    public ArrayList<ListaAsignaPermisosModulo> getLista() {
        return lista;
    }

    public void setLista(ArrayList<ListaAsignaPermisosModulo> lista) {
        this.lista = lista;
    }

    public ArrayList<ListaAsignaPermisosModulo> getListaFiltro() {
        return listaFiltro;
    }

    public void setListaFiltro(ArrayList<ListaAsignaPermisosModulo> listaFiltro) {
        this.listaFiltro = listaFiltro;
    }

    public ListaAsignaPermisosModulo getPermisoObjeto() {
        return permisoObjeto;
    }

    public void setPermisoObjeto(ListaAsignaPermisosModulo permisoObjeto) {
        this.permisoObjeto = permisoObjeto;
    }

    
    @PostConstruct
    public void cargaLista(){
        try {
            PermisosDisponiblesLogic permisosDisponiblesLogic = new PermisosDisponiblesLogic();
            lista = permisosDisponiblesLogic.listaPermisosDisponibles();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
