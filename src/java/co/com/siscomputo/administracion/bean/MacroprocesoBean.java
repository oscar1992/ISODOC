/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.siscomputo.administracion.bean;

import co.com.siscomputo.administracion.logic.MacroProcesosLogic;
import co.com.siscomputo.endpoint.MacroprocesosEntity;
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
@ManagedBean(name = "MacroProcesos")
@ViewScoped
public class MacroprocesoBean implements Serializable{

    private ArrayList<MacroprocesosEntity> listaMacroprocesos;
    private ArrayList<MacroprocesosEntity> listaMacroprocesosFiltro;
    private MacroprocesosEntity MacroProcesoObjeto;

    public ArrayList<MacroprocesosEntity> getListaMacroprocesos() {
        return listaMacroprocesos;
    }

    public void setListaMacroprocesos(ArrayList<MacroprocesosEntity> listaMacroprocesos) {
        this.listaMacroprocesos = listaMacroprocesos;
    }

    public ArrayList<MacroprocesosEntity> getListaMacroprocesosFiltro() {
        return listaMacroprocesosFiltro;
    }

    public void setListaMacroprocesosFiltro(ArrayList<MacroprocesosEntity> listaMacroprocesosFiltro) {
        this.listaMacroprocesosFiltro = listaMacroprocesosFiltro;
    }

    public MacroprocesosEntity getMacroProcesoObjeto() {
        return MacroProcesoObjeto;
    }

    public void setMacroProcesoObjeto(MacroprocesosEntity MacroProcesoObjeto) {
        this.MacroProcesoObjeto = MacroProcesoObjeto;
    }

    @PostConstruct
    public void init() {
        consultarMacroprocesos();
    }

    public MacroprocesoBean() {
        MacroProcesoObjeto = new MacroprocesosEntity();
    }
    /**
     * Método que trae la lista de MacropProcesos del servicio web
     */
    public void consultarMacroprocesos(){
        try {
            MacroProcesosLogic macroProcesosLogic=new MacroProcesosLogic();
            listaMacroprocesos=macroProcesosLogic.listaMacroprocesos();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * Método que ingresa un MacroProcso nuevo a traves del servicio web
     */
    public void ingresarMacroprosesos() {
        try {
            MacroProcesosLogic macroProcesosLogic = new MacroProcesosLogic();
            MacroprocesosEntity macroprocesosEntity=macroProcesosLogic.ingresaMacroproceso(MacroProcesoObjeto);
            FacesMessage msg = null;
            if (macroprocesosEntity != null) {
                msg = new FacesMessage("", "Macroproceso Ingresado Correctamente: " + macroprocesosEntity.getNombreMacroproceso());
                adicionarMacroprocesoLista(macroprocesosEntity);
            } else {
                msg = new FacesMessage("", "Macroproceso Ingresado Incorrectamente: " + macroprocesosEntity.getNombreMacroproceso());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        RequestContext.getCurrentInstance().execute("PF('insertarMacro').hide()");
        nuevoMacroproceso();
    }

    /**
     * Método que actualiza la lista visualmente
     *
     * @param macroprocesosEntity
     */
    private void adicionarMacroprocesoLista(MacroprocesosEntity macroprocesosEntity) {
        listaMacroprocesos.add(macroprocesosEntity);
    }

    /**
     * Método que permite actualizar un MacroProceso
     */
    public void actualizarMacroProceso() {
        MacroProcesosLogic macroProcesosLogic = new MacroProcesosLogic();
        String valida = macroProcesosLogic.actualizarMacroProceso(MacroProcesoObjeto);
        FacesMessage msg = null;
        if ("Ok".equalsIgnoreCase(valida)) {
            actualizarListaMacroproceso(MacroProcesoObjeto);
        } else {

        }
        MacroProcesoObjeto = new MacroprocesosEntity();
        RequestContext.getCurrentInstance().execute("PF('actualizarMacroProcesos').hide()");
    }

    /**
     * Método que actualiza la lista de MacroProcesos visualmente
     *
     * @param MacroProcesoObjeto
     */
    private void actualizarListaMacroproceso(MacroprocesosEntity MacroProcesoObjeto) {
        try {
            ArrayList<MacroprocesosEntity> listaaux = new ArrayList<>();
            if (listaMacroprocesos != null) {
                for (MacroprocesosEntity macro : listaMacroprocesos) {
                    if (MacroProcesoObjeto.getIdMacroproceso() == macro.getIdMacroproceso()) {
                        listaaux.add(MacroProcesoObjeto);
                    } else {
                        listaaux.add(macro);
                    }
                }
            }
            this.listaMacroprocesos = new ArrayList<>();
            this.listaMacroprocesos = listaaux;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Método que se llama con la seleción de un macroproceso
     *
     * @param event
     */
    public void onRowSelect(SelectEvent event) {
        MacroProcesoObjeto = (MacroprocesosEntity) event.getObject();
    }
    /**
     * Método que "elimina" un macroProceso actualizando su estado
     */
    public void eliminarMacroproceso() {
        MacroProcesosLogic macroProcesosLogic = new MacroProcesosLogic();
        MacroProcesoObjeto.setEstadoMacroproceso("E");
        macroProcesosLogic.actualizarMacroProceso(MacroProcesoObjeto);
        eliminarMacroprocesoLista(MacroProcesoObjeto);
        MacroProcesoObjeto = new MacroprocesosEntity();
        RequestContext.getCurrentInstance().execute("PF('eliminarMacroProcesos').hide()");
    }
    
    /**
     * Método que elimina un Macroproceso de la tabla visual
     * @param MacroProcesoObjeto 
     */
    private void eliminarMacroprocesoLista(MacroprocesosEntity MacroProcesoObjeto) {
        Iterator itr=listaMacroprocesos.iterator();
        while (itr.hasNext()) {
            MacroprocesosEntity macro=(MacroprocesosEntity) itr.next();
            if(macro.getIdMacroproceso()==MacroProcesoObjeto.getIdMacroproceso()){
                itr.remove();
            }
            
        }
    }
    /**
     * Método que reinicia un objetoMacorproceso después de ser usado
     */
    public void nuevoMacroproceso() {
        MacroProcesoObjeto = new MacroprocesosEntity();
    }

    
}
