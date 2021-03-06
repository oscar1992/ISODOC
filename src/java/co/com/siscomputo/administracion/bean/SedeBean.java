/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.siscomputo.administracion.bean;

import co.com.siscomputo.administracion.logic.SedesLogic;
import co.com.siscomputo.endpoint.MenuPermisosEntity;
import co.com.siscomputo.endpoint.SedeEntity;
import co.com.siscomputo.utilidades.MensajesJSF;
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
@ManagedBean(name = "Sedes")
@ViewScoped
public class SedeBean implements Serializable {

    private ArrayList<SedeEntity> lista;
    private ArrayList<SedeEntity> listaFiltro;
    private SedeEntity sedeObjeto;
    private SedeEntity sedeObjetoInsercion;
    private boolean ingresar;
    private boolean actualizar;
    private boolean eliminar;

    @PostConstruct
    public void init() {
        consultarSedes();
        permisos();
    }

    public ArrayList<SedeEntity> getLista() {
        return lista;
    }

    public void setLista(ArrayList<SedeEntity> lista) {
        this.lista = lista;
    }

    public ArrayList<SedeEntity> getListaFiltro() {
        return listaFiltro;
    }

    public void setListaFiltro(ArrayList<SedeEntity> listaFiltro) {
        this.listaFiltro = listaFiltro;
    }

    public SedeEntity getSedeObjeto() {
        return sedeObjeto;
    }

    public void setSedeObjeto(SedeEntity sedeObjeto) {
        this.sedeObjeto = sedeObjeto;
    }

    public SedeEntity getSedeObjetoInsercion() {
        return sedeObjetoInsercion;
    }

    public void setSedeObjetoInsercion(SedeEntity sedeObjetoInsercion) {
        this.sedeObjetoInsercion = sedeObjetoInsercion;
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
     * Método que trae la lista de sedes del servicio web
     */
    public void consultarSedes() {
        try {
            SedesLogic sedesLogic = new SedesLogic();
            lista = sedesLogic.listaSedes();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Método que ingresa una sede nueva a traves del servicio web
     */
    public void ingresarSede() {
        try {
            SedesLogic sedesLogic = new SedesLogic();
            SedeEntity sedeEntity = sedesLogic.ingresaSede(sedeObjetoInsercion);
            FacesMessage msg = null;
            if (sedeEntity != null) {
                MensajesJSF.muestraMensajes( "Sede ingresada Correctamente: " + sedeEntity.getNombreSede(), "Mensaje");
                adicionaSedeLista(sedeEntity);
            } else {
                MensajesJSF.muestraMensajes( "Error ingresando Sede Correctamente: " + sedeEntity.getNombreSede(), "Error");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        nuevaSedeObjeto();
        RequestContext.getCurrentInstance().execute("PF('insertarSede').hide()");
    }

    /**
     * Método que añade a la lista la sede en la vista
     *
     * @param sedeEntity
     */
    private void adicionaSedeLista(SedeEntity sedeEntity) {
        lista.add(sedeEntity);
    }

    /**
     * Método que envia una sede para ser actualizada
     *
     */
    public void actualizarSede() {
        SedesLogic sedesLogic = new SedesLogic();
        String valida = sedesLogic.actualizarSede(sedeObjeto);
        FacesMessage msg = null;
        if ("Ok".equalsIgnoreCase(valida)) {
            actualizarListaSedes(sedeObjeto);
            MensajesJSF.muestraMensajes( "Sede actualizada Correctamente: " + sedeObjeto.getNombreSede(), "Mensaje");
        } else if ("Error".equalsIgnoreCase(valida)) {
            MensajesJSF.muestraMensajes( "Error actualizando Sede Correctamente: " + sedeObjeto.getNombreSede(), "Error");
        }
        nuevaSedeObjeto();
        RequestContext.getCurrentInstance().execute("PF('actualizarSede').hide()");
    }

    /**
     * Método que actualiza la lista visual de la tabla
     *
     * @param sedeEntity
     */
    public void actualizarListaSedes(SedeEntity sedeEntity) {
        try {
            ArrayList<SedeEntity> listaa = new ArrayList<>();
            if (lista != null) {
                for (SedeEntity item : lista) {
                    if (sedeEntity.getIdSede() == item.getIdSede()) {
                        listaa.add(sedeEntity);
                    } else {
                        listaa.add(item);
                    }
                }
            }
            this.lista = null;
            this.lista = listaa;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Método que se llama con la selsción de una sede
     *
     * @param event
     */
    public void onRowSelect(SelectEvent event) {
        //sedeObjeto=(SedeEntity) event.getObject();        
        System.out.println("OBJETO: " + sedeObjeto.getNombreSede());
    }

    /**
     * Método que "elimina" una sede actualizando su estado
     */
    public void eliminarSede() {
        SedesLogic sedesLogic = new SedesLogic();
        sedeObjeto.setEstadoSede("E");
        sedesLogic.actualizarSede(sedeObjeto);
        eliminarSedeLista(sedeObjeto);

        RequestContext.getCurrentInstance().execute("PF('eliminarSede').hide()");
        nuevaSedeObjeto();
        MensajesJSF.muestraMensajes( "Sede eliminada Correctamente: " + sedeObjeto.getNombreSede(), "Mensaje");
    }

    /**
     * Método que elimina visualmente una sede
     *
     * @param sedeObjeto
     */
    public void eliminarSedeLista(SedeEntity sedeObjeto) {
        Iterator itr = lista.iterator();
        while (itr.hasNext()) {
            SedeEntity sede = (SedeEntity) itr.next();
            if (sede.getIdSede() == sedeObjeto.getIdSede()) {
                itr.remove();
            }
        }
    }

    /**
     * Método que limpia el objeto después de ser usado por algún otro método
     */
    public void nuevaSedeObjeto() {
        sedeObjeto = new SedeEntity();
        sedeObjetoInsercion = new SedeEntity();
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
