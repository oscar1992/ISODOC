/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.siscomputo.administracion.bean;

import co.com.siscomputo.administracion.logic.PermisosDisponiblesLogic;
import co.com.siscomputo.endpoint.ListaAsignaPermisosModulo;
import co.com.siscomputo.endpoint.ListaAsignaPermisosPermiso;
import co.com.siscomputo.endpoint.RolPermisoEntity;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author LENOVO
 */
@ManagedBean(name = "PermisosDisponibles")
@ViewScoped
public class permisosDisponiblesBean implements Serializable {

    private List<ListaAsignaPermisosModulo> listaPermisosSistema;
    private List<Integer> listaSelecion;
    private ListaAsignaPermisosModulo permisoObjeto;
    private ArrayList<RolPermisoEntity> rolPermisolista;
    private int idRol;

    public List<ListaAsignaPermisosModulo> getListaPermisosSistema() {
        return listaPermisosSistema;
    }

    public void setListaPermisosSistema(List<ListaAsignaPermisosModulo> listaPermisosSistema) {
        this.listaPermisosSistema = listaPermisosSistema;
    }

    public List<Integer> getListaSelecion() {
        return listaSelecion;
    }

    public void setListaSelecion(List<Integer> listaSelecion) {
        this.listaSelecion = listaSelecion;
    }

    

    public ListaAsignaPermisosModulo getPermisoObjeto() {
        return permisoObjeto;
    }

    public void setPermisoObjeto(ListaAsignaPermisosModulo permisoObjeto) {
        this.permisoObjeto = permisoObjeto;
    }

    public ArrayList<RolPermisoEntity> getRolPermisolista() {
        return rolPermisolista;
    }

    public void setRolPermisolista(ArrayList<RolPermisoEntity> rolPermisolista) {
        this.rolPermisolista = rolPermisolista;
    }

    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }

    /**
     * Método que carga las listas
     */
    @PostConstruct
    public void cargaLista() {
        try {
            //idRol=1;
            listaSelecion=new ArrayList<>();
            PermisosDisponiblesLogic permisosDisponiblesLogic = new PermisosDisponiblesLogic();
            listaPermisosSistema = permisosDisponiblesLogic.listaPermisosDisponibles();
            rolPermisolista = new ArrayList<>();
            rolPermisolista = permisosDisponiblesLogic.listaRolPermiso(idRol);
            //listaSelecion = new ArrayList<>();
            //ListaAsignaPermisosPermiso permisoQuemado = listaPermisosSistema.get(0).getPermisoNivel1().get(0).getListaS().get(0).getListaS().get(1);
            //listaSelecion.add(permisoQuemado);
            //cargaChulos();
            System.out.println("Seleec: " + listaSelecion.size());
        } catch (Exception e) {
            System.out.println("ERROR2");
            e.printStackTrace();
        }
    }

    /**
     * Método que actualiza la lista de seleciones de acuerdo al rol
     * seleccionado
     */
    public void cambiaRol() {
        rolPermisolista = new ArrayList<>();
        PermisosDisponiblesLogic permisosDisponiblesLogic = new PermisosDisponiblesLogic();
        rolPermisolista = permisosDisponiblesLogic.listaRolPermiso(idRol);
        cargaChulos();
        System.out.println("Seleec: " + listaSelecion.size());
    }

    /**
     * Método que carga los permisos asignados al rol
     */
    public void cargaChulos() {
        listaSelecion = new ArrayList<>();
        //Itero los modulos
        for (ListaAsignaPermisosModulo modulos : listaPermisosSistema) {
            //Itero los permisos del nivel dos 
            for (ListaAsignaPermisosPermiso permNv1 : modulos.getPermisoNivel1()) {
                //Itero los puntos del menu lateral
                for (ListaAsignaPermisosPermiso permNv2 : permNv1.getListaS()) {
                    //Itero los permisos internos de cada crud
                    for (ListaAsignaPermisosPermiso permNv3 : permNv2.getListaS()) {
                        
                        if(comparaPermisos(permNv3.getPermiso().getIdPermiso())){
                            
                            listaSelecion.add(permNv3.getPermiso().getIdPermiso());
                        }else{
                             
                        }                        
                    }
                }
            }
        }
    }
    /**
     * Método que permite comparar los ID de un rol asignado con los del menú
     * @param idMenu
     * @return 
     */
    public boolean comparaPermisos(int idMenu) {
        boolean ret = false;
        for (RolPermisoEntity rpe : rolPermisolista) {            
            if (rpe.getIdPermiso().getIdPermiso() == idMenu) {                
                ret=true;
                break;
            } else {
                ret=false;
            }
        }        
        return ret;
    }
    /**
     * Método que actualiza la lista de permisos de un Rol
     */
    public void actualizarRolPermiso(){
        if(idRol!=0){
            System.out.println("TAMA: "+listaSelecion.size());
            for(Integer select: listaSelecion){
                System.out.println("permiso: "+select);
            }
        }else{
            System.out.println("Selcionar Rol");
        }
        
    }
}
