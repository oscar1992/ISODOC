/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.siscomputo.administracion.bean;

import co.com.siscomputo.administracion.logic.ProcesosLogic;
import co.com.siscomputo.administracion.logic.SubProcesosLogic;
import co.com.siscomputo.endpoint.MenuPermisosEntity;
import co.com.siscomputo.endpoint.ProcesosEntity;
import co.com.siscomputo.endpoint.SubprocesoEntity;
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
@ManagedBean(name = "Subprocesos")
@ViewScoped
public class SubprocesoBean implements Serializable{

    private ArrayList<SubprocesoEntity> listaSubproceso;
    private ArrayList<SubprocesoEntity> listaSubprocesoFiltro;
    private SubprocesoEntity subProcesoObjeto;
    private boolean ingresar;
    private boolean actualizar;
    private boolean eliminar;

    public ArrayList<SubprocesoEntity> getListaSubproceso() {
        return listaSubproceso;
    }

    public void setListaSubproceso(ArrayList<SubprocesoEntity> listaSubproceso) {
        this.listaSubproceso = listaSubproceso;
    }

    public ArrayList<SubprocesoEntity> getListaSubprocesoFiltro() {
        return listaSubprocesoFiltro;
    }

    public void setListaSubprocesoFiltro(ArrayList<SubprocesoEntity> listaSubprocesoFiltro) {
        this.listaSubprocesoFiltro = listaSubprocesoFiltro;
    }

    public SubprocesoEntity getSubProcesoObjeto() {
        return subProcesoObjeto;
    }

    public void setSubProcesoObjeto(SubprocesoEntity subProcesoObjeto) {
        this.subProcesoObjeto = subProcesoObjeto;
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
    
    
    public SubprocesoBean() {
        
    }
    @PostConstruct
    public void init(){
        consultarSubprocesos();
        permisos();
    }
    /**
     * Método que trae la lista de Subprocesos del servicio Web
     */
    public void consultarSubprocesos() {
        try {
            SubProcesosLogic subProcesosLogic = new SubProcesosLogic();
            listaSubproceso = subProcesosLogic.listaSubprocesos();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Método que ingresa un subprocesos nuevo a traves del servicio web
     */
    public void ingresarSubproceso() {
        try {
            SubProcesosLogic subProcesosLogic = new SubProcesosLogic();
            SubprocesoEntity subprocesoEntity = subProcesosLogic.ingresaProceso(subProcesoObjeto);
            FacesMessage msg = null;
            if (subprocesoEntity != null) {
                msg = new FacesMessage("", "Subproceso Ingresado Correctamente: " + subprocesoEntity.getNombreSubproceso());
                adicionarSubprocesosLista(subprocesoEntity);
            } else {
                msg = new FacesMessage("", "Subproceso Ingresado Correctamente: " + subprocesoEntity.getNombreSubproceso());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        RequestContext.getCurrentInstance().execute("PF('insertarSubprocesos').hide()");
        nuveoSubproceso();
    }

    /**
     * Método que actualiza la lista visualmente
     *
     * @param subprocesoEntity
     */
    private void adicionarSubprocesosLista(SubprocesoEntity subprocesoEntity) {
        ProcesosLogic procesosLogic = new ProcesosLogic();
        ProcesosEntity procesosEntity = procesosLogic.procesoPorId(subprocesoEntity.getIdProcesos().getIdProcesos());
        subprocesoEntity.setIdProcesos(procesosEntity);
        listaSubproceso.add(subprocesoEntity);
    }

    public void actualizarProceso() {
        SubProcesosLogic subProcesosLogic = new SubProcesosLogic();
        String valida = subProcesosLogic.actualizarSubproceso(subProcesoObjeto);
        FacesMessage msg = null;
        if ("Ok".equalsIgnoreCase(valida)) {
            actualizarListaSubproceso(subProcesoObjeto);
        } else if ("Error".equalsIgnoreCase(valida)) {

        }
        RequestContext.getCurrentInstance().execute("PF('actualizarSubprocesos').hide()");
    }

    /**
     * Método que reinicia un objeto Proceso después de ser usado
     */
    public void nuveoSubproceso() {
        subProcesoObjeto = new SubprocesoEntity();
        ProcesosEntity procesosEntity = new ProcesosEntity();
        procesosEntity.setIdProcesos(-1);
        subProcesoObjeto.setIdProcesos(procesosEntity);
    }

    /**
     * Método que actualiza la lista de Subprocesos visualmente     *
     * @param subProcesoObjeto
     */
    private void actualizarListaSubproceso(SubprocesoEntity subProcesoObjeto) {
        try {
            ArrayList<SubprocesoEntity> listaaux = new ArrayList<>();
            if (listaSubproceso != null) {
                for (SubprocesoEntity subproc : listaSubproceso) {
                    if (subProcesoObjeto.getIdSubproceso() == subproc.getIdSubproceso()) {
                        ProcesosLogic procesosLogic = new ProcesosLogic();
                        ProcesosEntity procesosEntity = procesosLogic.procesoPorId(subProcesoObjeto.getIdProcesos().getIdProcesos());
                        subProcesoObjeto.setIdProcesos(procesosEntity);
                        listaaux.add(subProcesoObjeto);
                    } else {
                        listaaux.add(subproc);
                    }
                }
            }
            this.listaSubproceso = new ArrayList<>();
            this.listaSubproceso = listaaux;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * Método que se llama con la seleción de un Subproceso
     * @param event 
     */
    public void onRowSelect(SelectEvent event){
        subProcesoObjeto=(SubprocesoEntity) event.getObject();
        if(subProcesoObjeto.getIdProcesos()==null){
            ProcesosEntity proc=new ProcesosEntity();
            proc.setIdProcesos(-1);
            subProcesoObjeto.setIdProcesos(proc);
        }
    }
    /**
     * Método que "elimina" un Subproceso actualizando su estado
     */
    public void eliminarSubproceso(){
        System.out.println("SUBPRO: "+subProcesoObjeto.getNombreSubproceso());
        SubProcesosLogic subProcesosLogic=new SubProcesosLogic();
        subProcesoObjeto.setEstadoSubproceso("E");
        subProcesosLogic.actualizarSubproceso(subProcesoObjeto);
        eliminarSubprocesoLista(subProcesoObjeto);
        RequestContext.getCurrentInstance().execute("PF('eliminarSubprocesos').hide()");
    }
    /**
     * Método que elimina un Subproceso de la tabla visual
     * @param subProcesoObjeto 
     */
    private void eliminarSubprocesoLista(SubprocesoEntity subProcesoObjeto) {
        Iterator itr=listaSubproceso.iterator();
        while (itr.hasNext()) {
            SubprocesoEntity subproc=(SubprocesoEntity) itr.next();
            if(subProcesoObjeto.getIdSubproceso()==subproc.getIdSubproceso()){
                itr.remove();
            }            
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
