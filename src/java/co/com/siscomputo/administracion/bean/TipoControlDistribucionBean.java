package co.com.siscomputo.administracion.bean;

import co.com.siscomputo.administracion.logic.TipoControlDistribucionLogic;
import co.com.siscomputo.endpoint.TipoControlDistribucionEntity;
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
@ManagedBean(name = "TipoControlDistribucion")
@ViewScoped
public class TipoControlDistribucionBean implements Serializable {

    private ArrayList<TipoControlDistribucionEntity> lista;
    private ArrayList<TipoControlDistribucionEntity> listaFiltro;
    private TipoControlDistribucionEntity objetoTipoControlDistribucion;
    private TipoControlDistribucionEntity objetoTipoControlDistribucionInsercion;
    private boolean ingresar;
    private boolean actualizar;
    private boolean eliminar;

    public ArrayList<TipoControlDistribucionEntity> getLista() {
        return lista;
    }

    public void setLista(ArrayList<TipoControlDistribucionEntity> lista) {
        this.lista = lista;
    }

    public ArrayList<TipoControlDistribucionEntity> getListaFiltro() {
        return listaFiltro;
    }

    public void setListaFiltro(ArrayList<TipoControlDistribucionEntity> listaFiltro) {
        this.listaFiltro = listaFiltro;
    }

    public TipoControlDistribucionEntity getObjetoTipoControlDistribucion() {
        return objetoTipoControlDistribucion;
    }

    public void setObjetoTipoControlDistribucion(TipoControlDistribucionEntity objetoTipoControlDistribucion) {
        this.objetoTipoControlDistribucion = objetoTipoControlDistribucion;
    }

    public TipoControlDistribucionEntity getObjetoTipoControlDistribucionInsercion() {
        return objetoTipoControlDistribucionInsercion;
    }

    public void setObjetoTipoControlDistribucionInsercion(TipoControlDistribucionEntity objetoTipoControlDistribucionInsercion) {
        this.objetoTipoControlDistribucionInsercion = objetoTipoControlDistribucionInsercion;
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
        consultarTipoControlDistribucion();
        permisos();
    }

    public TipoControlDistribucionBean() {
        objetoTipoControlDistribucion = new TipoControlDistribucionEntity();
        objetoTipoControlDistribucionInsercion = new TipoControlDistribucionEntity();
    }

    /**
     * Método que tra una lista de Tipo de Control de distribución
     */
    public void consultarTipoControlDistribucion() {
        try {
            TipoControlDistribucionLogic tipoControlDistribucionLogic = new TipoControlDistribucionLogic();
            lista = tipoControlDistribucionLogic.listaTipoControlDistribucion();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Método que permite insertar un Tipo de Control de distribución nuevo
     */
    public void instertarTipoControlDistribucion() {
        try {
            TipoControlDistribucionLogic tipoControlDistribucionLogic = new TipoControlDistribucionLogic();
            TipoControlDistribucionEntity tipoControlDistribucionEntity = tipoControlDistribucionLogic.insertarTipoControlDistribucion(objetoTipoControlDistribucionInsercion);
            FacesMessage msg = null;
            if (tipoControlDistribucionEntity != null) {
                MensajesJSF.muestraMensajes( "inserción de Tipo de Control de distribución correcto", "Mensaje");
                adicionarMetodoPtoteccionLista(tipoControlDistribucionEntity);
            } else {
                MensajesJSF.muestraMensajes( "inserción de Tipo de Control de distribución incorrecto", "Error");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Método que añade un Tipo de Control de distribución visualmente
     *
     * @param objetoTipoControlDistribucion
     */
    private void adicionarMetodoPtoteccionLista(TipoControlDistribucionEntity objetoTipoControlDistribucion) {
        lista.add(objetoTipoControlDistribucion);
    }

    /**
     * Método que permite actualizar un Tipo de Control de distribución
     */
    public void actualizarTipoControlDistribucion() {
        TipoControlDistribucionLogic metodoRecuperacionLogic = new TipoControlDistribucionLogic();
        String valida = metodoRecuperacionLogic.actualizarTipoControlDistribucion(objetoTipoControlDistribucion);
        FacesMessage msg = null;
        if ("Ok".equalsIgnoreCase(valida)) {
            MensajesJSF.muestraMensajes( "actualización de Tipo de Control de distribución correcto", "Mensaje");
            actualizarTipoControlDistribucionLista(objetoTipoControlDistribucion);
        } else {
            MensajesJSF.muestraMensajes( "actualización de Tipo de Control de distribución incorrecto", "Error");
        }
        nuevoTipoControlDistribucionObjeto();
        RequestContext.getCurrentInstance().execute("PF('actualizarTipoControlDistribucion').hide()");
    }

    /**
     * Método que actualiza visualmente la lista de Tipo de Control de
     * distribución
     *
     * @param objetoTipoControlDistribucion
     */
    private void actualizarTipoControlDistribucionLista(TipoControlDistribucionEntity objetoTipoControlDistribucion) {
        try {
            ArrayList<TipoControlDistribucionEntity> listaaux = new ArrayList<>();
            if (lista != null) {
                for (TipoControlDistribucionEntity item : lista) {
                    System.out.println("V1: " + objetoTipoControlDistribucion.getIdTipoControlDistribucion());
                    System.out.println("V2: " + item.getIdTipoControlDistribucion());
                    int v1 = objetoTipoControlDistribucion.getIdTipoControlDistribucion();
                    int v2 = item.getIdTipoControlDistribucion();
                    if (v1 == v2) {
                        listaaux.add(objetoTipoControlDistribucion);
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
        objetoTipoControlDistribucion = (TipoControlDistribucionEntity) event.getObject();
    }

    /**
     * Método que elimina un Tipo de Control de distribución
     */
    public void eliminarTipoControlDistribucion() {
        TipoControlDistribucionLogic metodoRecuperacionLogic = new TipoControlDistribucionLogic();
        objetoTipoControlDistribucion.setEstadoTipoControlDistribucion("E");
        metodoRecuperacionLogic.actualizarTipoControlDistribucion(objetoTipoControlDistribucion);
        eliminarTipoControlDistribucionLista(objetoTipoControlDistribucion);
        RequestContext.getCurrentInstance().execute("PF('actualizarTipoControlDistribucion').hide()");
        nuevoTipoControlDistribucionObjeto();
        MensajesJSF.muestraMensajes( "actualización de Tipo de Control de distribución correcto", "Mensaje");
    }

    /**
     * Método que elimina visualmente un objeto de la lista
     *
     * @param objetoTipoControlDistribucion
     */
    private void eliminarTipoControlDistribucionLista(TipoControlDistribucionEntity objetoTipoControlDistribucion) {
        Iterator itr = lista.iterator();
        while (itr.hasNext()) {
            TipoControlDistribucionEntity metodoRecuperacionEntity = (TipoControlDistribucionEntity) itr.next();
            if (metodoRecuperacionEntity.getIdTipoControlDistribucion() == objetoTipoControlDistribucion.getIdTipoControlDistribucion()) {
                itr.remove();
            }
        }
    }

    /**
     * Método que reinicia el objeto Tipo de Control de distribución
     */
    public void nuevoTipoControlDistribucionObjeto() {
        objetoTipoControlDistribucion = new TipoControlDistribucionEntity();
        objetoTipoControlDistribucionInsercion = new TipoControlDistribucionEntity();
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
