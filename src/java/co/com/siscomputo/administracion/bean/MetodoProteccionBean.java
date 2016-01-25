package co.com.siscomputo.administracion.bean;

import co.com.siscomputo.administracion.logic.MetodoProteccionLogic;
import co.com.siscomputo.endpoint.MetodoProteccionEntity;
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
@ManagedBean(name = "MetodoProteccion")
@ViewScoped
public class MetodoProteccionBean implements Serializable {

    private ArrayList<MetodoProteccionEntity> lista;
    private ArrayList<MetodoProteccionEntity> listaFiltro;
    private MetodoProteccionEntity objetoMetodoProteccion;
    private MetodoProteccionEntity objetoMetodoProteccionInsercion;
    private boolean ingresar;
    private boolean actualizar;
    private boolean eliminar;

    public ArrayList<MetodoProteccionEntity> getLista() {
        return lista;
    }

    public void setLista(ArrayList<MetodoProteccionEntity> lista) {
        this.lista = lista;
    }

    public ArrayList<MetodoProteccionEntity> getListaFiltro() {
        return listaFiltro;
    }

    public void setListaFiltro(ArrayList<MetodoProteccionEntity> listaFiltro) {
        this.listaFiltro = listaFiltro;
    }

    public MetodoProteccionEntity getObjetoMetodoProteccion() {
        return objetoMetodoProteccion;
    }

    public void setObjetoMetodoProteccion(MetodoProteccionEntity objetoMetodoProteccion) {
        this.objetoMetodoProteccion = objetoMetodoProteccion;
    }

    public MetodoProteccionEntity getObjetoMetodoProteccionInsercion() {
        return objetoMetodoProteccionInsercion;
    }

    public void setObjetoMetodoProteccionInsercion(MetodoProteccionEntity objetoMetodoProteccionInsercion) {
        this.objetoMetodoProteccionInsercion = objetoMetodoProteccionInsercion;
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
        consultarMetodoProteccion();
        permisos();
    }

    public MetodoProteccionBean() {
        objetoMetodoProteccion = new MetodoProteccionEntity();
        objetoMetodoProteccionInsercion = new MetodoProteccionEntity();
    }

    /**
     * Método que tra una lista de Métodos de Protección
     */
    public void consultarMetodoProteccion() {
        try {
            MetodoProteccionLogic metodoProteccionLogic = new MetodoProteccionLogic();
            lista = metodoProteccionLogic.listaMetodoProteccion();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Método que permite insertar un Métodos de Protección nuevo
     */
    public void instertarMetodoProteccion() {
        try {
            MetodoProteccionLogic metodoProteccionLogic = new MetodoProteccionLogic();
            MetodoProteccionEntity metodoProteccionEntity = metodoProteccionLogic.insertarMetodoProteccion(objetoMetodoProteccionInsercion);
            FacesMessage msg = null;
            if (metodoProteccionEntity != null) {
                MensajesJSF.muestraMensajes( "inserción de Métodos de Protección correcto", "Mensaje");
                adicionarMetodoPtoteccionLista(metodoProteccionEntity);
            } else {
                MensajesJSF.muestraMensajes( "inserción de Métodos de Protección incorrecto", "Error");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Método que añade un Métodos de Protección visualmente
     *
     * @param objetoMetodoProteccion
     */
    private void adicionarMetodoPtoteccionLista(MetodoProteccionEntity objetoMetodoProteccion) {
        lista.add(objetoMetodoProteccion);
    }

    /**
     * Método que permite actualizar un Métodos de Protección
     */
    public void actualizarMetodoProteccion() {
        MetodoProteccionLogic metodoRecuperacionLogic = new MetodoProteccionLogic();
        String valida = metodoRecuperacionLogic.actualizarMetodoProteccion(objetoMetodoProteccion);
        FacesMessage msg = null;
        if ("Ok".equalsIgnoreCase(valida)) {
            MensajesJSF.muestraMensajes( "actualización de Métodos de Protección correcto", "Mensaje");
            actualizarMetodoProteccionLista(objetoMetodoProteccion);
        } else {
            MensajesJSF.muestraMensajes( "actualización de Métodos de Protección incorrecto", "Error");
        }
        nuevoMetodoProteccionObjeto();
        RequestContext.getCurrentInstance().execute("PF('actualizarMetodoProteccion').hide()");
    }

    /**
     * Método que actualiza visualmente la lista de Métodos de Protección
     *
     * @param objetoMetodoProteccion
     */
    private void actualizarMetodoProteccionLista(MetodoProteccionEntity objetoMetodoProteccion) {
        try {
            ArrayList<MetodoProteccionEntity> listaaux = new ArrayList<>();
            if (lista != null) {
                for (MetodoProteccionEntity item : lista) {
                    System.out.println("V1: " + objetoMetodoProteccion.getIdMetodoProteccion());
                    System.out.println("V2: " + item.getIdMetodoProteccion());
                    int v1 = objetoMetodoProteccion.getIdMetodoProteccion();
                    int v2 = item.getIdMetodoProteccion();
                    if (v1 == v2) {
                        listaaux.add(objetoMetodoProteccion);
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
        objetoMetodoProteccion = (MetodoProteccionEntity) event.getObject();
        System.out.println("QQ: " + objetoMetodoProteccion.getIdMetodoProteccion());
    }

    /**
     * Método que elimina un Métodos de Protección
     */
    public void eliminarMetodoProteccion() {
        MetodoProteccionLogic metodoRecuperacionLogic = new MetodoProteccionLogic();
        objetoMetodoProteccion.setEstadoMetodoProteccion("E");
        metodoRecuperacionLogic.actualizarMetodoProteccion(objetoMetodoProteccion);
        eliminarMetodoProteccionLista(objetoMetodoProteccion);
        RequestContext.getCurrentInstance().execute("PF('actualizarMetodoProteccion').hide()");
        nuevoMetodoProteccionObjeto();
        MensajesJSF.muestraMensajes( "Eliminación de Métodos de Protección correcto", "Mensaje");
    }

    /**
     * Método que elimina visualmente un objeto de la lista
     *
     * @param objetoMetodoProteccion
     */
    private void eliminarMetodoProteccionLista(MetodoProteccionEntity objetoMetodoProteccion) {
        Iterator itr = lista.iterator();
        while (itr.hasNext()) {
            MetodoProteccionEntity metodoRecuperacionEntity = (MetodoProteccionEntity) itr.next();
            if (metodoRecuperacionEntity.getIdMetodoProteccion() == objetoMetodoProteccion.getIdMetodoProteccion()) {
                itr.remove();
            }
        }
    }

    /**
     * Método que reinicia el objeto Métodos de Protección
     */
    public void nuevoMetodoProteccionObjeto() {
        objetoMetodoProteccion = new MetodoProteccionEntity();
        objetoMetodoProteccionInsercion = new MetodoProteccionEntity();
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
