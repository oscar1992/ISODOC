/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.siscomputo.administracion.bean;

import co.com.siscomputo.administracion.logic.MetodoRecuperacionLogic;
import co.com.siscomputo.endpoint.MenuPermisosEntity;
import co.com.siscomputo.endpoint.MetodoRecuperacionEntity;
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
@ManagedBean(name = "MetodoRecuperacion")
@ViewScoped
public class MetodoRecuperacionBean {
    ArrayList<MetodoRecuperacionEntity> lista;
    ArrayList<MetodoRecuperacionEntity> listaFiltro;
    MetodoRecuperacionEntity metodoRecuperacionObjeto;
    private boolean ingresar;
    private boolean actualizar;
    private boolean eliminar;

    public ArrayList<MetodoRecuperacionEntity> getLista() {
        return lista;
    }

    public void setLista(ArrayList<MetodoRecuperacionEntity> lista) {
        this.lista = lista;
    }

    public ArrayList<MetodoRecuperacionEntity> getListaFiltro() {
        return listaFiltro;
    }

    public void setListaFiltro(ArrayList<MetodoRecuperacionEntity> listaFiltro) {
        this.listaFiltro = listaFiltro;
    }

    public MetodoRecuperacionEntity getMetodoRecuperacionObjeto() {
        return metodoRecuperacionObjeto;
    }

    public void setMetodoRecuperacionObjeto(MetodoRecuperacionEntity metodoRecuperacionObjeto) {
        this.metodoRecuperacionObjeto = metodoRecuperacionObjeto;
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
    public void init(){
        consultarMetodoRecuperacion();
        permisos();
    }

    public MetodoRecuperacionBean() {
        metodoRecuperacionObjeto=new MetodoRecuperacionEntity();
    }
    /**
     * Método que tra una lista de Métodos Disponibles
     */
    public void consultarMetodoRecuperacion(){
        try {
            MetodoRecuperacionLogic metodoRecuperacionLogic=new MetodoRecuperacionLogic();
            lista=metodoRecuperacionLogic.listaMetodosRecuperacion();            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * Método que permite insertar un Método de Recuperación nuevo
     */
    public void instertarMetodoRecuperacion(){
        try {
            MetodoRecuperacionLogic metodoRecuperacionLogic=new MetodoRecuperacionLogic();
            MetodoRecuperacionEntity metodoRecuperacionEntity=metodoRecuperacionLogic.inserttarMetodoRecuperaciom(metodoRecuperacionObjeto);
            FacesMessage msg=null;
            if(metodoRecuperacionEntity!=null){
                msg=new FacesMessage("", "inserción de Método de Recuperación correcto");
                adicionarMetodocuperacionLista(metodoRecuperacionObjeto);
            }else{
                msg=new FacesMessage("", "inserción de Método de Recuperación incorrecto");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * Método que añade un Método de Recuperación visualmente
     * @param metodoRecuperacionObjeto 
     */
    private void adicionarMetodocuperacionLista(MetodoRecuperacionEntity metodoRecuperacionObjeto) {
        lista.add(metodoRecuperacionObjeto);
    }
    /**
     * Método que permite actualizar un Método de Recuperación
     */
    public void actualizarMetodoRecuperacion(){
        MetodoRecuperacionLogic metodoRecuperacionLogic=new MetodoRecuperacionLogic();
        String valida=metodoRecuperacionLogic.actualizarMetodoRecuperacion(metodoRecuperacionObjeto);
        FacesMessage msg=null;
        if("Ok".equalsIgnoreCase(valida)){
            msg=new FacesMessage("", "actualización de Método de Recuperación correcto");
            actualizarMetodoRecuperacionLista(metodoRecuperacionObjeto);
        }else{
            msg=new FacesMessage("", "actualización de Método de Recuperación incorrecto");
        }
        nuevoMetodoRecuperacionObjeto();
        RequestContext.getCurrentInstance().execute("PF('actualizarMetodoRecuperacion').hide()");
    }
    /**
     * Método que actualiza visualmente la lista de Métodos de Recuperación
     * @param metodoRecuperacionObjeto 
     */
    private void actualizarMetodoRecuperacionLista(MetodoRecuperacionEntity metodoRecuperacionObjeto) {
        try {
            ArrayList<MetodoRecuperacionEntity>listaaux=new ArrayList<>();
            if(lista!=null){
                for(MetodoRecuperacionEntity item:lista){
                    System.out.println("V1: "+metodoRecuperacionObjeto.getIdMetodoRecuperacion());
                    System.out.println("V2: "+item.getIdMetodoRecuperacion());
                    int v1=metodoRecuperacionObjeto.getIdMetodoRecuperacion();
                    int v2=item.getIdMetodoRecuperacion();
                    if(v1==v2){
                        listaaux.add(metodoRecuperacionObjeto);
                    }else{
                        listaaux.add(item);
                    }
                }
            }
            this.lista=new ArrayList<>();
            this.lista=listaaux;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * Método que se invoca al seleccionar una fila de la tabla
     * @param event 
     */
    public void onRowSelect(SelectEvent event){
        metodoRecuperacionObjeto=(MetodoRecuperacionEntity)event.getObject();
    }
    /**
    Método que elimina un Método de Recuperación
    */
    public void eliminarMetodoRecuperacion(){
        MetodoRecuperacionLogic metodoRecuperacionLogic=new MetodoRecuperacionLogic();
        metodoRecuperacionObjeto.setEstadoMetodoRecuperacion("E");
        metodoRecuperacionLogic.actualizarMetodoRecuperacion(metodoRecuperacionObjeto);
        eliminarMetodoRecuperacionLista(metodoRecuperacionObjeto);
        RequestContext.getCurrentInstance().execute("PF('actualizarMetodoRecuperacion').hide()");
        nuevoMetodoRecuperacionObjeto();
    }
    /**
     * Método que elimina visualmente un objeto de la lista
     * @param metodoRecuperacionObjeto 
     */
    private void eliminarMetodoRecuperacionLista(MetodoRecuperacionEntity metodoRecuperacionObjeto) {
        Iterator itr=lista.iterator();
        while(itr.hasNext()){
            MetodoRecuperacionEntity metodoRecuperacionEntity=(MetodoRecuperacionEntity) itr.next();
            if(metodoRecuperacionEntity.getIdMetodoRecuperacion()==metodoRecuperacionObjeto.getIdMetodoRecuperacion()){
                itr.remove();
            }
        }
    }
    /**
     * Método que reinicia el objeto Método de recuperación
     */
    public void nuevoMetodoRecuperacionObjeto() {
        metodoRecuperacionObjeto=new MetodoRecuperacionEntity();
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
