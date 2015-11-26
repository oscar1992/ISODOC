/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.siscomputo.administracion.bean;

import co.com.siscomputo.administracion.logic.TiposDocumentalesLogic;
import co.com.siscomputo.endpoint.MenuPermisosEntity;
import co.com.siscomputo.endpoint.TiposDocumentalesEntity;
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
@ManagedBean(name = "TiposDocuemntales")
@ViewScoped
public class TiposDocuemntalesBean implements Serializable{

    private ArrayList<TiposDocumentalesEntity> lista;
    private ArrayList<TiposDocumentalesEntity> listaFiltro;
    private TiposDocumentalesEntity tiposDobjeto;
    private boolean ingresar;
    private boolean actualizar;
    private boolean eliminar;

    public ArrayList<TiposDocumentalesEntity> getLista() {
        return lista;
    }

    public void setLista(ArrayList<TiposDocumentalesEntity> lista) {
        this.lista = lista;
    }

    public ArrayList<TiposDocumentalesEntity> getListaFiltro() {
        return listaFiltro;
    }

    public void setListaFiltro(ArrayList<TiposDocumentalesEntity> listaFiltro) {
        this.listaFiltro = listaFiltro;
    }

    public TiposDocumentalesEntity getTiposDobjeto() {
        return tiposDobjeto;
    }

    public void setTiposDobjeto(TiposDocumentalesEntity tiposDobjeto) {
        this.tiposDobjeto = tiposDobjeto;
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
    public void init() {
        consultarTiposDocumentales();
        permisos();

    }

    public TiposDocuemntalesBean() {
        tiposDobjeto=new TiposDocumentalesEntity();
        System.out.println("TT");
    }

    /**
     * Método que trae la lista de tipos documentales
     */
    public void consultarTiposDocumentales() {
        try {
            TiposDocumentalesLogic tiposDocumentalesLogic = new TiposDocumentalesLogic();
            lista = tiposDocumentalesLogic.listaTiposDocumentales();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    /**
     * Método que permite insertar un nuevo tipo documental
     */
    public void ingresarTiposDocumentales() {
        
        try {
            TiposDocumentalesLogic tiposDocumentalesLogic = new TiposDocumentalesLogic();
            TiposDocumentalesEntity tiposDocumentalesEntity = tiposDocumentalesLogic.ingresaTipoDocumental(tiposDobjeto);
            FacesMessage msg = null;
            if (tiposDocumentalesEntity != null) {
                msg = new FacesMessage("", "Tipo Documental Ingresado Correctamente" + tiposDocumentalesEntity.getNombreTipoDocumental());
                adicionarTipoDocuemtalLista(tiposDocumentalesEntity);
            } else {
                msg = new FacesMessage("", "Tipo Documental Ingresado Inorrectamente" + tiposDocumentalesEntity.getNombreTipoDocumental());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        RequestContext.getCurrentInstance().execute("PF('insertarTipoDocumental').hide()");
        nuevoTipoDocumental();
        
    }

    /**
     * Método que permite actualizar visualmente la lista e tipos documentales
     *
     * @param tiposDocumentalesEntity
     */
    private void adicionarTipoDocuemtalLista(TiposDocumentalesEntity tiposDocumentalesEntity) {
        lista.add(tiposDocumentalesEntity);
    }

    /**
     * Método que permite limpiar el objeto tipo documental
     */
    private void nuevoTipoDocumental() {
        tiposDobjeto = new TiposDocumentalesEntity();
        System.out.println("NN");
    }

    /**
     * Método que permite actualizar un Tipo documental
     */
    public void actualizarTipoDocumental() {
        TiposDocumentalesLogic tiposDocumentalesLogic = new TiposDocumentalesLogic();
        String valida = tiposDocumentalesLogic.actualizarTiposDocumental(tiposDobjeto);
        FacesMessage msg = null;
        if ("Ok".equalsIgnoreCase(valida)) {
            actualizarListaTiposDocumentales(tiposDobjeto);
        } else if ("Error".equalsIgnoreCase(valida)) {

        }
        tiposDobjeto = new TiposDocumentalesEntity();
        
    }

    /**
     * Método que actualiza la lista visualmente
     *
     * @param tiposDobjeto
     */
    private void actualizarListaTiposDocumentales(TiposDocumentalesEntity tiposDobjeto) {
        try {
            ArrayList<TiposDocumentalesEntity> listaaux = new ArrayList<>();
            if (lista != null) {
                for (TiposDocumentalesEntity item : lista) {
                    if (tiposDobjeto.getIdTipoDocumental() == item.getIdTipoDocumental()) {
                        listaaux.add(tiposDobjeto);
                    } else {
                        listaaux.add(item);
                    }
                }
            }
            this.lista = new ArrayList<>();
            this.lista = listaaux;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Método que se llama en la selecciónn de un Tipo Documental
     *
     * @param event
     */
    public void onRowSelect(SelectEvent event) {
        tiposDobjeto = (TiposDocumentalesEntity) event.getObject();
        
    }

    /**
     * Método que "elimina" el tipo Documental
     */
    public void eliminarTipoDocumental() {
        TiposDocumentalesLogic tiposDocumentalesLogic = new TiposDocumentalesLogic();
        tiposDobjeto.setEstadoTipoDocuemtal("E");
        tiposDocumentalesLogic.actualizarTiposDocumental(tiposDobjeto);
        eliminarListaTiposDocumentales(tiposDobjeto);
        tiposDobjeto = new TiposDocumentalesEntity();
        RequestContext.getCurrentInstance().execute("PF('actualizarTipoDocumental').hide()");
     
    }

    /**
     * Método que elimina el objeto visualmente
     * @param tiposDobjeto
     */
    private void eliminarListaTiposDocumentales(TiposDocumentalesEntity tiposDobjeto) {
        Iterator itr = lista.iterator();
        while (itr.hasNext()) {
            TiposDocumentalesEntity tipoD = (TiposDocumentalesEntity) itr.next();
            if (tipoD.getIdTipoDocumental() == tiposDobjeto.getIdTipoDocumental()) {
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
                    System.out.println("nn: " + nivel2.getNombrePermiso() + "-" + nivel2.getAsociadoMenu() + " - " + idPer + " - " + nivel2.getAsociadoNivel());
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
