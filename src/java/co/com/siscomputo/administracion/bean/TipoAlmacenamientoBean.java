package co.com.siscomputo.administracion.bean;

import co.com.siscomputo.administracion.logic.TipoAlmacenamientoLogic;
import co.com.siscomputo.endpoint.TipoAlmacenamientoEntity;
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
@ManagedBean(name = "TipoAlmacenamiento")
@ViewScoped
public class TipoAlmacenamientoBean implements Serializable {

    private ArrayList<TipoAlmacenamientoEntity> lista;
    private ArrayList<TipoAlmacenamientoEntity> listaFiltro;
    private TipoAlmacenamientoEntity objetoTipoAlmacenamiento;
    private TipoAlmacenamientoEntity objetoTipoAlmacenamientoInsercion;
    private boolean ingresar;
    private boolean actualizar;
    private boolean eliminar;

    public ArrayList<TipoAlmacenamientoEntity> getLista() {
        return lista;
    }

    public void setLista(ArrayList<TipoAlmacenamientoEntity> lista) {
        this.lista = lista;
    }

    public ArrayList<TipoAlmacenamientoEntity> getListaFiltro() {
        return listaFiltro;
    }

    public void setListaFiltro(ArrayList<TipoAlmacenamientoEntity> listaFiltro) {
        this.listaFiltro = listaFiltro;
    }

    public TipoAlmacenamientoEntity getObjetoTipoAlmacenamiento() {
        return objetoTipoAlmacenamiento;
    }

    public void setObjetoTipoAlmacenamiento(TipoAlmacenamientoEntity objetoTipoAlmacenamiento) {
        this.objetoTipoAlmacenamiento = objetoTipoAlmacenamiento;
    }

    public TipoAlmacenamientoEntity getObjetoTipoAlmacenamientoInsercion() {
        return objetoTipoAlmacenamientoInsercion;
    }

    public void setObjetoTipoAlmacenamientoInsercion(TipoAlmacenamientoEntity objetoTipoAlmacenamientoInsercion) {
        this.objetoTipoAlmacenamientoInsercion = objetoTipoAlmacenamientoInsercion;
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
        consultarTipoAlmacenamiento();
        permisos();
    }

    public TipoAlmacenamientoBean() {
        objetoTipoAlmacenamiento = new TipoAlmacenamientoEntity();
        objetoTipoAlmacenamientoInsercion = new TipoAlmacenamientoEntity();
    }

    /**
     * Método que tra una lista de Tipo de Almacenamiento
     */
    public void consultarTipoAlmacenamiento() {
        try {
            TipoAlmacenamientoLogic tipoAlmacenamientoLogic = new TipoAlmacenamientoLogic();
            lista = tipoAlmacenamientoLogic.listaTipoAlmacenamiento();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Método que permite insertar un Tipo de Almacenamiento nuevo
     */
    public void instertarTipoAlmacenamiento() {
        try {
            TipoAlmacenamientoLogic tipoAlmacenamientoLogic = new TipoAlmacenamientoLogic();
            TipoAlmacenamientoEntity tipoAlmacenamientoEntity = tipoAlmacenamientoLogic.insertarTipoAlmacenamiento(objetoTipoAlmacenamientoInsercion);
            FacesMessage msg = null;
            if (tipoAlmacenamientoEntity != null) {
                MensajesJSF.muestraMensajes( "inserción de Tipo de Almacenamiento correcto", "Mensaje");
                adicionarMetodoPtoteccionLista(tipoAlmacenamientoEntity);
            } else {
                MensajesJSF.muestraMensajes( "inserción de Tipo de Almacenamiento incorrecto", "Error");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Método que añade un Tipo de Almacenamiento visualmente
     *
     * @param objetoTipoAlmacenamiento
     */
    private void adicionarMetodoPtoteccionLista(TipoAlmacenamientoEntity objetoTipoAlmacenamiento) {
        lista.add(objetoTipoAlmacenamiento);
    }

    /**
     * Método que permite actualizar un Tipo de Almacenamiento
     */
    public void actualizarTipoAlmacenamiento() {
        TipoAlmacenamientoLogic metodoRecuperacionLogic = new TipoAlmacenamientoLogic();
        String valida = metodoRecuperacionLogic.actualizarTipoAlmacenamiento(objetoTipoAlmacenamiento);
        FacesMessage msg = null;
        if ("Ok".equalsIgnoreCase(valida)) {
            MensajesJSF.muestraMensajes( "actualización de Tipo de Almacenamiento correcto", "Mensaje");
            actualizarTipoAlmacenamientoLista(objetoTipoAlmacenamiento);
        } else {
            MensajesJSF.muestraMensajes( "actualización de Tipo de Almacenamiento incorrecto", "Error");
        }
        nuevoTipoAlmacenamientoObjeto();
        RequestContext.getCurrentInstance().execute("PF('actualizarTipoAlmacenamiento').hide()");
    }

    /**
     * Método que actualiza visualmente la lista de Tipo de Almacenamiento
     *
     * @param objetoTipoAlmacenamiento
     */
    private void actualizarTipoAlmacenamientoLista(TipoAlmacenamientoEntity objetoTipoAlmacenamiento) {
        try {
            ArrayList<TipoAlmacenamientoEntity> listaaux = new ArrayList<>();
            if (lista != null) {
                for (TipoAlmacenamientoEntity item : lista) {
                    System.out.println("V1: " + objetoTipoAlmacenamiento.getIdTipoAlmacenamiento());
                    System.out.println("V2: " + item.getIdTipoAlmacenamiento());
                    int v1 = objetoTipoAlmacenamiento.getIdTipoAlmacenamiento();
                    int v2 = item.getIdTipoAlmacenamiento();
                    if (v1 == v2) {
                        listaaux.add(objetoTipoAlmacenamiento);
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
        objetoTipoAlmacenamiento = (TipoAlmacenamientoEntity) event.getObject();
    }

    /**
     * Método que elimina un Tipo de Almacenamiento
     */
    public void eliminarTipoAlmacenamiento() {
        TipoAlmacenamientoLogic metodoRecuperacionLogic = new TipoAlmacenamientoLogic();
        objetoTipoAlmacenamiento.setEstadoTipoAlmacenamiento("E");
        metodoRecuperacionLogic.actualizarTipoAlmacenamiento(objetoTipoAlmacenamiento);
        eliminarTipoAlmacenamientoLista(objetoTipoAlmacenamiento);
        RequestContext.getCurrentInstance().execute("PF('actualizarTipoAlmacenamiento').hide()");
        nuevoTipoAlmacenamientoObjeto();
        MensajesJSF.muestraMensajes( "Eliminación de Tipo de Almacenamiento correcto", "Mensaje");
    }

    /**
     * Método que elimina visualmente un objeto de la lista
     *
     * @param objetoTipoAlmacenamiento
     */
    private void eliminarTipoAlmacenamientoLista(TipoAlmacenamientoEntity objetoTipoAlmacenamiento) {
        Iterator itr = lista.iterator();
        while (itr.hasNext()) {
            TipoAlmacenamientoEntity metodoRecuperacionEntity = (TipoAlmacenamientoEntity) itr.next();
            if (metodoRecuperacionEntity.getIdTipoAlmacenamiento() == objetoTipoAlmacenamiento.getIdTipoAlmacenamiento()) {
                itr.remove();
            }
        }
    }

    /**
     * Método que reinicia el objeto Tipo de Almacenamiento
     */
    public void nuevoTipoAlmacenamientoObjeto() {
        objetoTipoAlmacenamiento = new TipoAlmacenamientoEntity();
        objetoTipoAlmacenamientoInsercion = new TipoAlmacenamientoEntity();
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
