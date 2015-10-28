/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.siscomputo.administracion.bean;

import co.com.siscomputo.administracion.logic.AreaLogic;
import co.com.siscomputo.administracion.logic.SedesLogic;
import co.com.siscomputo.endpoint.AreaEntity;
import co.com.siscomputo.endpoint.SedeEntity;
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
@ManagedBean(name = "Areas")
@ViewScoped
public class AreaBean {

    private ArrayList<AreaEntity> lista;
    private ArrayList<AreaEntity> listaFiltro;
    private AreaEntity areaObjeto;

    @PostConstruct
    public void init() {
        consultarAreas();
    }

    public AreaBean() {
        areaObjeto = new AreaEntity();
        areaObjeto.setIdSede(new SedeEntity());
    }

    public ArrayList<AreaEntity> getLista() {
        return lista;
    }

    public void setLista(ArrayList<AreaEntity> lista) {
        this.lista = lista;
    }

    public ArrayList<AreaEntity> getListaFiltro() {
        return listaFiltro;
    }

    public void setListaFiltro(ArrayList<AreaEntity> listaFiltro) {
        this.listaFiltro = listaFiltro;
    }

    public AreaEntity getAreaObjeto() {
        return areaObjeto;
    }

    public void setAreaObjeto(AreaEntity areaObjeto) {
        this.areaObjeto = areaObjeto;
    }

    /**
     * Método que trae la lista que cargó el servicio web
     */
    public void consultarAreas() {
        try {
            AreaLogic areaLogic = new AreaLogic();
            lista = areaLogic.listaAreas();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Método que permite ingresar un área nueva
     */
    public void ingresarArea() {
        try {
            AreaLogic areaLogic = new AreaLogic();
            AreaEntity areaEntity = areaLogic.ingresarArea(areaObjeto);
            FacesMessage msg = null;
            if (areaEntity != null) {
                msg = new FacesMessage("", "Area Ingresado Correctamente: " + areaEntity.getNombreArea());
                adicionaAreaLista(areaEntity);
            } else {
                msg = new FacesMessage("", "Error al Ingresar Usuario: " + areaEntity.getNombreArea());
            }
            RequestContext.getCurrentInstance().execute("PF('insertarArea').hide()");
        } catch (Exception e) {
            e.printStackTrace();
        }
        areaObjeto = new AreaEntity();
    }

    /**
     * Método que añade a la lista el área en la vista
     *
     * @param areaEntity
     */
    public void adicionaAreaLista(AreaEntity areaEntity) {
        lista.add(areaEntity);
    }

    /**
     * Método que envia un area para ser actualizada
     */
    public void actualizarArea() {
        AreaLogic areaLogic = new AreaLogic();
        System.out.println("OBJETO: " + areaObjeto.getNombreArea() + "-" + areaObjeto.getIdSede().getIdSede());
        String valida = areaLogic.actualizarArea(areaObjeto);
        FacesMessage msg = null;
        if ("Ok".equalsIgnoreCase(valida)) {
            actualizarListaAres(areaObjeto);
        } else if ("Error".equalsIgnoreCase(valida)) {

        }
        RequestContext.getCurrentInstance().execute("PF('actualizarArea').hide()");
        //areaObjeto = new AreaEntity();
    }

    public void actualizarListaAres(AreaEntity areaObjeto) {
        try {
            ArrayList<AreaEntity> listaa = new ArrayList<>();
            if (lista != null) {
                for (AreaEntity item : lista) {
                    if (areaObjeto.getIdArea() == item.getIdArea()) {
                        SedesLogic sedesLogic=new SedesLogic();
                        SedeEntity sede=sedesLogic.sedePorId(areaObjeto.getIdSede().getIdSede());
                        areaObjeto.setIdSede(sede);
                        listaa.add(areaObjeto);
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
     * Método que se llama con la selección de un Área
     *
     * @param event
     */
    public void onRowSelect(SelectEvent event) {
        areaObjeto = (AreaEntity) event.getObject();
        if (areaObjeto.getIdSede() == null) {
            SedeEntity sede = new SedeEntity();
            sede.setIdSede(-1);
            areaObjeto.setIdSede(sede);
        }
        System.out.println("OOOOO: " + areaObjeto.getNombreArea() + "-" + areaObjeto.getIdSede().getIdSede());
    }

    /**
     * Método que "elimna" un área actualizando su estado
     */
    public void eliminarArea() {
        AreaLogic areaLogic = new AreaLogic();
        areaObjeto.setEstadoArea("E");
        areaLogic.actualizarArea(areaObjeto);
        eliminarAreaLista(areaObjeto);
        areaObjeto = new AreaEntity();
        RequestContext.getCurrentInstance().execute("PF('eliminarArea').hide()");
    }

    /**
     * Método que elimina visualmente un área
     *
     * @param areaObjeto
     */
    public void eliminarAreaLista(AreaEntity areaObjeto) {
        Iterator itr = lista.iterator();
        while (itr.hasNext()) {
            AreaEntity area = (AreaEntity) itr.next();
            if (area.getIdArea() == areaObjeto.getIdArea()) {
                itr.remove();
            }

        }
    }
    /**
     * Método que limpia el objeto después de ser usado por algún otro método
     */
    public void nuevoAreaObjeto() {
        System.out.println("Nuevo");
        areaObjeto = new AreaEntity();
        SedeEntity sede = new SedeEntity();
        sede.setIdSede(-1);
        areaObjeto.setIdSede(sede);
    }
}
