/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.siscomputo.administracion.bean;

import co.com.siscomputo.administracion.logic.RolesLogic;
import co.com.siscomputo.endpoint.MenuPermisosEntity;
import co.com.siscomputo.endpoint.RolesEntity;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author LENOVO
 */

@ManagedBean(name = "Perfiles")
@ViewScoped
public class RolesBean implements Serializable{
    private ArrayList<RolesEntity> lista;
    private ArrayList<RolesEntity> listaFiltro;
    private RolesEntity rolesObjeto;
    private RolesEntity rolesObjetoInsercion;
    private boolean ingresar ;
    private boolean actualizar;
    private boolean eliminar;
    
    @PostConstruct
    public void init() {
        consultaRoles();
        permisos();
    }

    public RolesBean() {
        rolesObjeto=new RolesEntity();
        rolesObjetoInsercion=new RolesEntity();
    }
    
    
    public ArrayList<RolesEntity> getLista() {
        return lista;
    }

    public void setLista(ArrayList<RolesEntity> lista) {
        this.lista = lista;
    }

    public ArrayList<RolesEntity> getListaFiltro() {
        return listaFiltro;
    }

    public void setListaFiltro(ArrayList<RolesEntity> listaFiltro) {
        this.listaFiltro = listaFiltro;
    }

    public RolesEntity getRolesObjeto() {
        return rolesObjeto;
    }

    public void setRolesObjeto(RolesEntity rolesObjeto) {
        this.rolesObjeto = rolesObjeto;
    }

    public RolesEntity getRolesObjetoInsercion() {
        return rolesObjetoInsercion;
    }

    public void setRolesObjetoInsercion(RolesEntity rolesObjetoInsercion) {
        this.rolesObjetoInsercion = rolesObjetoInsercion;
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
    
    
    /**
     * Método que recoje el eveto de la seleción de la tabla y obtiene el objeto del perfil
     * @param event 
     */
    public void onRowSelect(SelectEvent event){
        rolesObjeto=(RolesEntity)event.getObject();
    }
    
    /**
     * Método que carga la lista de perfiles
     */
    public  void consultaRoles(){
        try{
            RolesLogic rolesLogic=new RolesLogic();
            lista=rolesLogic.listaRoles();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    /**
     * Método que permite ingresar un Rol nuevo
     */
    public void ingresarRol(){
        try{
            RolesLogic rolesLogic=new RolesLogic();
            RolesEntity rolEnttity=rolesLogic.ingresarRol(rolesObjetoInsercion);
            FacesMessage msg=null;
            if(rolEnttity!=null){
                msg=new FacesMessage("", "Rol Ingresado Correctamente: "+rolesObjeto.getNombreRol());
                adicionaRolLista(rolEnttity);
            }else{
                msg=new FacesMessage("", "Error al Ingresar Usuario: "+rolesObjeto.getNombreRol());
            }
            RequestContext.getCurrentInstance().execute("PF('insertarPerfil').hide()");
        }catch(Error e){
            e.printStackTrace();
        }
        
    }
    /**
     * Método que envia un rol para ser actualizado
     */
    public void actualizarRol(){
        RolesLogic rolesLogic=new RolesLogic();
        String valida=rolesLogic.actualizarUsuario(rolesObjeto);
        FacesMessage msg=null;
        if("Ok".equalsIgnoreCase(valida)){
            actualizaListaRol(rolesObjeto);
        }else if("Error".equalsIgnoreCase(valida)){
            actualizaListaRol(rolesObjeto);
        }
        rolesObjeto=new RolesEntity();
        RequestContext.getCurrentInstance().execute("PF('actualizarPerfil').hide()");
    }
    /**
     * Método para actualizar la lista de roles en la vista                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 ista
     * @param rol 
     */
    public void adicionaRolLista(RolesEntity rol){
        lista.add(rol);
    }
    /**
     * Método para actualizar la lista de Roles en la vista
     * @param rol 
     */
    public void actualizaListaRol(RolesEntity rol){
        try{
            ArrayList<RolesEntity> listaa=new ArrayList();
            if(lista!=null){
                for(RolesEntity item:lista){
                    if(rol.getIdRol()==item.getIdRol()){
                        listaa.add(rol);
                    }else{
                        listaa.add(item);
                    }
                }
            }
            this.lista=null;
            this.lista=listaa;
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    /**
     * Método que nevia un Rol al servicio Web para ser "eliminado"
     */
    public void eliminarRol(){
        RolesLogic rolesLogic=new RolesLogic();
        rolesObjeto.setEstadoRol("E");
        rolesLogic.actualizarUsuario(rolesObjeto);
        eliminarRolLista(rolesObjeto);
        rolesObjeto=new RolesEntity();
        RequestContext.getCurrentInstance().execute("PF('eliminarPerfil').hide()");
    }
    /**
     * Método que actualiza la lista de roles en la vista al eliminar un objeto
     * @param rolEntity 
     */
    public void eliminarRolLista(RolesEntity rolEntity){
        Iterator itr= lista.iterator();
        while (itr.hasNext()) {
            RolesEntity rol=(RolesEntity) itr.next();
            if(rol.getIdRol()==rolEntity.getIdRol()){
                itr.remove();
            }
            
        }
    }
    /**
     * Método para limpiar el objeto después de ser usado por otro método
     */
    public void nuevoObjetoPerfil(){
        rolesObjeto=new RolesEntity();
        rolesObjetoInsercion=new RolesEntity();
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
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              