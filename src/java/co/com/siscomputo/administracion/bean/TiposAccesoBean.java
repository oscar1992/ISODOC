package co.com.siscomputo.administracion.bean;

import co.com.siscomputo.administracion.logic.TiposAccesoLogic;
import co.com.siscomputo.endpoint.TiposAccesoEntity;
import co.com.siscomputo.endpoint.MenuPermisosEntity;
import co.com.siscomputo.utilidades.MensajesJSF;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;
import javax.faces.context.FacesContext;

/**
 *
 * @author LENOVO
 */
@ManagedBean(name = "TiposAcceso")
@ViewScoped
public class TiposAccesoBean implements Serializable {

    private ArrayList<TiposAccesoEntity> lista;
    private ArrayList<TiposAccesoEntity> listaFiltro;
    private TiposAccesoEntity objetoTiposAcceso;
    private TiposAccesoEntity objetoTiposAccesoInsercion;
    private boolean ingresar;
    private boolean actualizar;
    private boolean eliminar;

    public ArrayList<TiposAccesoEntity> getLista() {
        return lista;
    }

    public void setLista(ArrayList<TiposAccesoEntity> lista) {
        this.lista = lista;
    }

    public ArrayList<TiposAccesoEntity> getListaFiltro() {
        return listaFiltro;
    }

    public void setListaFiltro(ArrayList<TiposAccesoEntity> listaFiltro) {
        this.listaFiltro = listaFiltro;
    }

    public TiposAccesoEntity getObjetoTiposAcceso() {
        return objetoTiposAcceso;
    }

    public void setObjetoTiposAcceso(TiposAccesoEntity objetoTiposAcceso) {
        this.objetoTiposAcceso = objetoTiposAcceso;
    }

    public TiposAccesoEntity getObjetoTiposAccesoInsercion() {
        return objetoTiposAccesoInsercion;
    }

    public void setObjetoTiposAccesoInsercion(TiposAccesoEntity objetoTiposAccesoInsercion) {
        this.objetoTiposAccesoInsercion = objetoTiposAccesoInsercion;
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
        consultarTiposAcceso();
        permisos();
    }

    public TiposAccesoBean() {
        objetoTiposAcceso = new TiposAccesoEntity();
        objetoTiposAccesoInsercion = new TiposAccesoEntity();
    }

    /**
     * Método que tra una lista de Tipo de Acceso
     */
    public void consultarTiposAcceso() {
        try {
            TiposAccesoLogic tiposAccesoLogic = new TiposAccesoLogic();
            lista = tiposAccesoLogic.listaTiposAcceso();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Método que permite insertar un Tipo de Acceso nuevo
     */
    public void instertarTiposAcceso() {
        try {
            TiposAccesoLogic tiposAccesoLogic = new TiposAccesoLogic();
            TiposAccesoEntity tiposAccesoEntity = tiposAccesoLogic.insertarTiposAcceso(objetoTiposAccesoInsercion);
            FacesMessage msg = null;
            if (tiposAccesoEntity != null) {
                MensajesJSF.muestraMensajes( "inserción de Tipo de Acceso correcto", "Mensaje");
                adicionarMetodoPtoteccionLista(tiposAccesoEntity);
            } else {
                MensajesJSF.muestraMensajes( "inserción de Tipo de Acceso incorrecto", "Error");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Método que añade un Tipo de Acceso visualmente
     *
     * @param objetoTiposAcceso
     */
    private void adicionarMetodoPtoteccionLista(TiposAccesoEntity objetoTiposAcceso) {
        lista.add(objetoTiposAcceso);
    }

    /**
     * Método que permite actualizar un Tipo de Acceso
     */
    public void actualizarTiposAcceso() {
        TiposAccesoLogic metodoRecuperacionLogic = new TiposAccesoLogic();
        String valida = metodoRecuperacionLogic.actualizarTiposAcceso(objetoTiposAcceso);
        FacesMessage msg = null;
        if ("Ok".equalsIgnoreCase(valida)) {
            MensajesJSF.muestraMensajes( "actualización de Tipo de Acceso correcto", "Mensaje");
            actualizarTiposAccesoLista(objetoTiposAcceso);
        } else {
            MensajesJSF.muestraMensajes( "actualización de Tipo de Acceso incorrecto", "Error");
        }

        RequestContext.getCurrentInstance().execute("PF('actualizarTiposAcceso').hide()");
    }

    /**
     * Método que actualiza visualmente la lista de Tipo de Acceso
     *
     * @param objetoTiposAcceso
     */
    private void actualizarTiposAccesoLista(TiposAccesoEntity objetoTiposAcceso) {
        try {
            ArrayList<TiposAccesoEntity> listaaux = new ArrayList<>();
            if (lista != null) {
                for (TiposAccesoEntity item : lista) {
                    System.out.println("V1: " + objetoTiposAcceso.getIdTiposAcceso());
                    System.out.println("V2: " + item.getIdTiposAcceso());
                    int v1 = objetoTiposAcceso.getIdTiposAcceso();
                    int v2 = item.getIdTiposAcceso();
                    if (v1 == v2) {
                        listaaux.add(objetoTiposAcceso);
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
     * Método que se invoca al seleccionar una fila de la tabla
     *
     * @param event
     */
    public void onRowSelect(SelectEvent event) {
        objetoTiposAcceso = (TiposAccesoEntity) event.getObject();
    }

    /**
     * Método que elimina un Tipo de Acceso
     */
    public void eliminarTiposAcceso() {
        TiposAccesoLogic metodoRecuperacionLogic = new TiposAccesoLogic();
        objetoTiposAcceso.setEstadoTiposAcceso("E");
        metodoRecuperacionLogic.actualizarTiposAcceso(objetoTiposAcceso);
        eliminarTiposAccesoLista(objetoTiposAcceso);
        RequestContext.getCurrentInstance().execute("PF('actualizarTiposAcceso').hide()");
        nuevoTiposAccesoObjeto();
        MensajesJSF.muestraMensajes( "Eliminación de Tipo de Acceso correcto", "Mensaje");
    }

    /**
     * Método que elimina visualmente un objeto de la lista
     *
     * @param objetoTiposAcceso
     */
    private void eliminarTiposAccesoLista(TiposAccesoEntity objetoTiposAcceso) {
        Iterator itr = lista.iterator();
        while (itr.hasNext()) {
            TiposAccesoEntity metodoRecuperacionEntity = (TiposAccesoEntity) itr.next();
            if (metodoRecuperacionEntity.getIdTiposAcceso() == objetoTiposAcceso.getIdTiposAcceso()) {
                itr.remove();
            }
        }
    }

    /**
     * Método que reinicia el objeto Tipo de Acceso
     */
    public void nuevoTiposAccesoObjeto() {
        objetoTiposAcceso = new TiposAccesoEntity();
        objetoTiposAccesoInsercion = new TiposAccesoEntity();
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
                    //System.out.println("nn: " + nivel2.getNombrePermiso() + "-" + nivel2.getAsociadoMenu() + " - " + idPer);
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
