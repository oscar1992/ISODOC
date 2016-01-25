/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.siscomputo.administracion.bean;

import co.com.siscomputo.administracion.logic.CiudadLogic;
import co.com.siscomputo.administracion.logic.DepartamentoLogic;
import co.com.siscomputo.endpoint.CiudadEntity;
import co.com.siscomputo.endpoint.DepartamentoEntity;
import co.com.siscomputo.endpoint.MenuPermisosEntity;
import co.com.siscomputo.utilidades.MensajesJSF;
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
@ManagedBean(name = "Ciudades")
@ViewScoped
public class CiudadBean {

    private ArrayList<CiudadEntity> lista;
    private ArrayList<CiudadEntity> listaFiltro;
    private CiudadEntity ciudadObjeto;
    private CiudadEntity ciudadObjetoInsercion;
    private boolean ingresar;
    private boolean actualizar;
    private boolean eliminar;

    @PostConstruct
    public void init() {
        consultarCiudades();
        permisos();
    }

    public ArrayList<CiudadEntity> getLista() {
        return lista;
    }

    public void setLista(ArrayList<CiudadEntity> lista) {
        this.lista = lista;
    }

    public ArrayList<CiudadEntity> getListaFiltro() {
        return listaFiltro;
    }

    public void setListaFiltro(ArrayList<CiudadEntity> listaFiltro) {
        this.listaFiltro = listaFiltro;
    }

    public CiudadEntity getCiudadObjeto() {
        return ciudadObjeto;
    }

    public void setCiudadObjeto(CiudadEntity ciudadObjeto) {
        this.ciudadObjeto = ciudadObjeto;
    }

    public CiudadEntity getCiudadObjetoInsercion() {
        return ciudadObjetoInsercion;
    }

    public void setCiudadObjetoInsercion(CiudadEntity ciudadObjetoInsercion) {
        this.ciudadObjetoInsercion = ciudadObjetoInsercion;
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
     * Método que trae la lista de ciudades del servicio web
     */
    public void consultarCiudades() {
        try {
            CiudadLogic ciudadLogic = new CiudadLogic();
            lista = ciudadLogic.listaCiudades();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Método que ingresa una Ciudad nueva a traves del servicio web
     */
    public void ingresarCiudad() {
        try {
            CiudadLogic ciudadLogic = new CiudadLogic();
            CiudadEntity ciudadEntity = ciudadLogic.ingresaCiudad(ciudadObjetoInsercion);
            FacesMessage msg = null;
            if (ciudadEntity != null) {
                MensajesJSF.muestraMensajes("Ciudad ingresada Correctamente: " + ciudadEntity.getNombreCiudad(), "Mensaje");
                adicionarCiudadLista(ciudadEntity);
            } else {
                MensajesJSF.muestraMensajes("Ciudad ingresada Incorrectamente: " + ciudadEntity.getNombreCiudad(), "Error");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        ciudadObjeto = new CiudadEntity();
        RequestContext.getCurrentInstance().execute("PF('insertarCiudad').hide()");
    }

    /**
     * Método que añade a la lista la Ciudad en la vista
     *
     * @param ciudadEntity
     */
    private void adicionarCiudadLista(CiudadEntity ciudadEntity) {
        lista.add(ciudadEntity);
    }

    /**
     * Método que envia una ciudad para ser actualizada
     */
    public void actualizarCiudad() {
        CiudadLogic ciudadLogic = new CiudadLogic();
        String valida = ciudadLogic.actualizarCiudad(ciudadObjeto);
        FacesMessage msg = null;
        if ("Ok".equalsIgnoreCase(valida)) {
            actualizarListaCiudad(ciudadObjeto);
            MensajesJSF.muestraMensajes("Ciudad actualizada Correctamente: " + ciudadObjeto.getNombreCiudad(), "Mensaje");
        } else if ("Error".equalsIgnoreCase(valida)) {
            MensajesJSF.muestraMensajes("Ciudad actualizada Incorrectamente: " + ciudadObjeto.getNombreCiudad(), "Error");
        }
        nuevaCiuidadObjeto();
        RequestContext.getCurrentInstance().execute("PF('actualizarCiudad').hide()");
    }

    /**
     * Método que añade a la lista la Ciudad en la vista
     *
     * @param ciudadObjeto
     */
    private void actualizarListaCiudad(CiudadEntity ciudadObjeto) {
        try {
            ArrayList<CiudadEntity> listaaux = new ArrayList<>();
            if (lista != null) {
                for (CiudadEntity item : lista) {
                    if (ciudadObjeto.getIdCiudad() == item.getIdCiudad()) {
                        DepartamentoLogic departamentoLogic = new DepartamentoLogic();
                        DepartamentoEntity departamento = departamentoLogic.deptoPorID(ciudadObjeto.getCiudadDepartamento().getIdDepartamento());
                        listaaux.add(ciudadObjeto);
                    } else {
                        listaaux.add(item);
                    }
                }
            }
            this.lista = null;
            this.lista = listaaux;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Método que se llama con la selección de una Ciudad
     *
     * @param event
     */
    public void onRowSelect(SelectEvent event) {
        //ciudadObjeto=(CiudadEntity)event.getObject();
        if (ciudadObjeto.getCiudadDepartamento() == null) {
            DepartamentoEntity departamento = new DepartamentoEntity();
            departamento.setIdDepartamento(-1);
            ciudadObjeto.setCiudadDepartamento(departamento);
        }
    }

    /**
     * Método que "elimna" una Ciudad actualizando su estado
     */
    public void eliminarCiudad() {
        System.out.println("CIUD: " + ciudadObjeto.getNombreCiudad() + "-" + ciudadObjeto.getIdCiudad());
        CiudadLogic ciudadLogic = new CiudadLogic();
        ciudadObjeto.setEstadoCiudad("E");
        ciudadLogic.actualizarCiudad(ciudadObjeto);
        eliminarCiudadLista(ciudadObjeto);
        ciudadObjeto = new CiudadEntity();
        RequestContext.getCurrentInstance().execute("PF('eliminarCiudad').hide()");
        nuevaCiuidadObjeto();
        MensajesJSF.muestraMensajes("Ciudad eliminada Correctamente: " + ciudadObjeto.getNombreCiudad(), "Mensaje");
    }

    /**
     * Método que elimina visualmente una Ciudad
     *
     * @param ciudadObjeto
     */
    private void eliminarCiudadLista(CiudadEntity ciudadObjeto) {
        Iterator itr = lista.iterator();
        while (itr.hasNext()) {
            CiudadEntity ciudad = (CiudadEntity) itr.next();
            if (ciudad.getIdCiudad() == ciudadObjeto.getIdCiudad()) {
                itr.remove();
            }

        }
    }

    /**
     * Método que limpia el objeto después de ser usado por algún otro método
     */
    public void nuevaCiuidadObjeto() {
        ciudadObjeto = new CiudadEntity();
        ciudadObjetoInsercion = new CiudadEntity();

        DepartamentoEntity departamento = new DepartamentoEntity();
        departamento.setIdDepartamento(-1);
        ciudadObjeto.setCiudadDepartamento(departamento);
        ciudadObjetoInsercion.setCiudadDepartamento(departamento);

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
