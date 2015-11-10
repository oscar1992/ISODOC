/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.siscomputo.administracion.bean;

import co.com.siscomputo.administracion.logic.MacroProcesosLogic;
import co.com.siscomputo.administracion.logic.ProcesosLogic;
import co.com.siscomputo.endpoint.MacroprocesosEntity;
import co.com.siscomputo.endpoint.ProcesosEntity;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author LENOVO
 */
@ManagedBean(name = "Procesos")
@ViewScoped
public class ProcesosBean implements Serializable{
    private ArrayList<ProcesosEntity> listaProcesos;
    private ArrayList<ProcesosEntity> listaProcesosFiltro;
    private ProcesosEntity procesosObjeto;

    public ArrayList<ProcesosEntity> getListaProcesos() {
        return listaProcesos;
    }

    public void setListaProcesos(ArrayList<ProcesosEntity> listaProcesos) {
        this.listaProcesos = listaProcesos;
    }

    public ArrayList<ProcesosEntity> getListaProcesosFiltro() {
        return listaProcesosFiltro;
    }

    public void setListaProcesosFiltro(ArrayList<ProcesosEntity> listaProcesosFiltro) {
        this.listaProcesosFiltro = listaProcesosFiltro;
    }

    public ProcesosEntity getProcesosObjeto() {
        return procesosObjeto;
    }

    public void setProcesosObjeto(ProcesosEntity procesosObjeto) {
        this.procesosObjeto = procesosObjeto;
    }
    @PostConstruct
    public void init(){
        consultarProcesos();
    }
    
    public ProcesosBean() {
        
    }
    
    /**
     * Método que trae la lista de Procesos del servicio web
     */
    public void consultarProcesos(){
        try {
            ProcesosLogic procesosLogic=new ProcesosLogic();
            listaProcesos=procesosLogic.listaProcesos();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * Método que ingresa un Procso nuevo a traves del servicio web
     */
    public void ingresarProcesos(){
        try {
            ProcesosLogic procesosLogic=new ProcesosLogic();
            ProcesosEntity procesosEntity=procesosLogic.ingresaProceso(procesosObjeto);
            FacesMessage msg=null;
            if(procesosEntity!=null){
                msg = new FacesMessage("", "Proceso Ingresado Correctamente: " + procesosEntity.getNombrePreoceso());
                adicionarProcesoLista(procesosEntity);
            }else{
                msg = new FacesMessage("", "Proceso Ingresado Incorrectamente: " + procesosEntity.getNombrePreoceso());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        RequestContext.getCurrentInstance().execute("PF('insertarProceso').hide()");
        nuevoProceso();
    }
    /**
     * Método que actualiza la lista Visualente
     * @param procesosEntity 
     */
    private void adicionarProcesoLista(ProcesosEntity procesosEntity) {
        MacroProcesosLogic macroProcesosLogic=new MacroProcesosLogic();
        MacroprocesosEntity macro=macroProcesosLogic.macroProcesoPorId(procesosObjeto.getIdMacroProceso().getIdMacroproceso());
        procesosEntity.setIdMacroProceso(macro);
        listaProcesos.add(procesosEntity);
    }
    /**
     * Método que permite actualizar un Proceso
     */
    public void actualizarProceso(){
        ProcesosLogic procesosLogic=new ProcesosLogic();
        String valida=procesosLogic.actualozarProceso(procesosObjeto);
        FacesMessage msg=null;
        if("Ok".equalsIgnoreCase(valida)){
            
            actualizarListaProceso(procesosObjeto);
        }else if("Error".equalsIgnoreCase(valida)){
            
        }
        
        RequestContext.getCurrentInstance().execute("PF('actualizarProcesos').hide()");
    } 
    /**
     * Método que se llama con la seleción de un Proceso
     * @param event 
     */
    public void onRowSelect(SelectEvent event){
        procesosObjeto=(ProcesosEntity) event.getObject();
        if(procesosObjeto.getIdMacroProceso()==null){
            MacroprocesosEntity macro=new MacroprocesosEntity();
            macro.setIdMacroproceso(-1);
            procesosObjeto.setIdMacroProceso(macro);
        }
    }
    /**
     * Método que "elimina" un Proceso actualizando su estado
     */
    public void eliminarProceso(){
        ProcesosLogic procesosLogic=new ProcesosLogic();
        procesosObjeto.setEstadoProceso("E");
        procesosLogic.actualozarProceso(procesosObjeto);
        eliminarProcesoLista(procesosObjeto);
        
        RequestContext.getCurrentInstance().execute("PF('eliminarProcesos').hide()");
        nuevoProceso();
    }
    
    /**
     * Método que reinicia un objeto Proceso después de ser usado
     */
    public void nuevoProceso() {
        procesosObjeto=new ProcesosEntity();
        MacroprocesosEntity macroprocesosEntity=new MacroprocesosEntity();
        macroprocesosEntity.setIdMacroproceso(-1);
        procesosObjeto.setIdMacroProceso(macroprocesosEntity);
        
    }
    /**
     * Método que actualiza la lista de Procesos visualmente
     * @param procesosObjeto 
     */
    private void actualizarListaProceso(ProcesosEntity procesosObjeto) {
        try{
            ArrayList<ProcesosEntity> listaaux=new ArrayList<>();
            if(listaProcesos!=null){
                for(ProcesosEntity proceso: listaProcesos){
                    
                    if(procesosObjeto.getIdProcesos()== proceso.getIdProcesos()){
                        
                        MacroProcesosLogic macroProcesosLogic=new MacroProcesosLogic();
                        MacroprocesosEntity macro=macroProcesosLogic.macroProcesoPorId(procesosObjeto.getIdMacroProceso().getIdMacroproceso());
                        procesosObjeto.setIdMacroProceso(macro);
                        listaaux.add(procesosObjeto);
                    }else{
                        listaaux.add(proceso);
                    }
                }
            }
            this.listaProcesos=new ArrayList<>();
            this.listaProcesos=listaaux;
        }catch(Exception e){
            e.printStackTrace();
        }
        System.out.println("SALE");
    }
    /**
     * Método que elimina un Proceso de la tabla visual
     * @param procesosObjeto 
     */
    private void eliminarProcesoLista(ProcesosEntity procesosObjeto) {
        Iterator itr=listaProcesos.iterator();
        while(itr.hasNext()){
            ProcesosEntity procesos=(ProcesosEntity)itr.next();
            if(procesosObjeto.getIdProcesos()==procesos.getIdProcesos()){
                itr.remove();
            }
        }
    }
    
    
}
