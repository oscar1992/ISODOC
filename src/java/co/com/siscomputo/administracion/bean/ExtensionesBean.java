package co.com.siscomputo.administracion.bean;

import co.com.siscomputo.administracion.logic.ExtensionesLogic;
import co.com.siscomputo.endpoint.ExtensionesEntity;
import co.com.siscomputo.endpoint.MenuPermisosEntity;
import java.util.ArrayList;
import java.io.Serializable;
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
@ManagedBean(name = "Extensiones")
@ViewScoped
public class ExtensionesBean implements Serializable {

    private ArrayList<ExtensionesEntity> lista;
    private ArrayList<ExtensionesEntity> listaFiltro;
    private ExtensionesEntity objetoExtensiones;
    private ExtensionesEntity objetoExtensionesInsercion;
    private boolean ingresar;
    private boolean actualizar;
    private boolean eliminar;

    public ArrayList<ExtensionesEntity> getLista() {
        return lista;
    }

    public void setLista(ArrayList<ExtensionesEntity> lista) {
        this.lista = lista;
    }

    public ArrayList<ExtensionesEntity> getListaFiltro() {
        return listaFiltro;
    }

    public void setListaFiltro(ArrayList<ExtensionesEntity> listaFiltro) {
        this.listaFiltro = listaFiltro;
    }

    public ExtensionesEntity getObjetoExtensiones() {
        return objetoExtensiones;
    }

    public void setObjetoExtensiones(ExtensionesEntity objetoExtensiones) {
        this.objetoExtensiones = objetoExtensiones;
    }

    public ExtensionesEntity getObjetoExtensionesInsercion() {
        return objetoExtensionesInsercion;
    }

    public void setObjetoExtensionesInsercion(ExtensionesEntity objetoExtensionesInsercion) {
        this.objetoExtensionesInsercion = objetoExtensionesInsercion;
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
        consultarExtensiones();
        permisos();
    }

    public ExtensionesBean() {
        objetoExtensiones = new ExtensionesEntity();
        objetoExtensionesInsercion = new ExtensionesEntity();
    }

    /**
     * Método que trae una lista de Extensiones de Archivo
     */
    public void consultarExtensiones() {
        try {
            ExtensionesLogic extensionesLogic = new ExtensionesLogic();
            lista = extensionesLogic.listaExtensiones();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Método que permite insertar un Extensiones de Archivo nuevo
     */
    public void instertarExtensiones() {
        try {
            ExtensionesLogic extensionesLogic = new ExtensionesLogic();
            ExtensionesEntity extensionesEntity = extensionesLogic.insertarExtensiones(objetoExtensionesInsercion);
            FacesMessage msg = null;
            if (extensionesEntity != null) {
                msg = new FacesMessage("", "inserción de Extensiones de Archivo correcto");
                adicionarMetodoPtoteccionLista(extensionesEntity);
            } else {
                msg = new FacesMessage("", "inserción de Extensiones de Archivo incorrecto");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Método que añade un Extensiones de Archivo visualmente
     *
     * @param objetoExtensiones
     */
    private void adicionarMetodoPtoteccionLista(ExtensionesEntity objetoExtensiones) {
        lista.add(objetoExtensiones);
    }

    /**
     * Método que permite actualizar un Extensiones de Archivo
     */
    public void actualizarExtensiones() {
        ExtensionesLogic metodoRecuperacionLogic = new ExtensionesLogic();
        String valida = metodoRecuperacionLogic.actualizarExtensiones(objetoExtensiones);
        FacesMessage msg = null;
        if ("Ok".equalsIgnoreCase(valida)) {
            msg = new FacesMessage("", "actualización de Extensiones de Archivo correcto");
            actualizarExtensionesLista(objetoExtensiones);
        } else {
            msg = new FacesMessage("", "actualización de Extensiones de Archivo incorrecto");
        }
        nuevoExtensionesObjeto();
        RequestContext.getCurrentInstance().execute("PF('actualizarExtensiones').hide()");
    }

    /**
     * Método que actualiza visualmente la lista de Extensiones de Archivo
     *
     * @param objetoExtensiones
     */
    private void actualizarExtensionesLista(ExtensionesEntity objetoExtensiones) {
        try {
            ArrayList<ExtensionesEntity> listaaux = new ArrayList<>();
            if (lista != null) {
                for (ExtensionesEntity item : lista) {
                    int v1 = objetoExtensiones.getIdExtensiones();
                    int v2 = item.getIdExtensiones();
                    if (v1 == v2) {
                        listaaux.add(objetoExtensiones);
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
        objetoExtensiones = (ExtensionesEntity) event.getObject();
    }

    /**
     * Método que elimina un Extensiones de Archivo
     */
    public void eliminarExtensiones() {
        ExtensionesLogic metodoRecuperacionLogic = new ExtensionesLogic();
        metodoRecuperacionLogic.actualizarExtensiones(objetoExtensiones);
        eliminarExtensionesLista(objetoExtensiones);
        RequestContext.getCurrentInstance().execute("PF('actualizarExtensiones').hide()");
        nuevoExtensionesObjeto();
    }

    /**
     * Método que elimina visualmente un objeto de la lista
     *
     * @param objetoExtensiones
     */
    private void eliminarExtensionesLista(ExtensionesEntity objetoExtensiones) {
        Iterator itr = lista.iterator();
        while (itr.hasNext()) {
            ExtensionesEntity metodoRecuperacionEntity = (ExtensionesEntity) itr.next();
            if (metodoRecuperacionEntity.getIdExtensiones() == objetoExtensiones.getIdExtensiones()) {
                itr.remove();
            }
        }
    }

    /**
     * Método que reinicia el objeto Extensiones de Archivo
     */
    public void nuevoExtensionesObjeto() {
        objetoExtensiones = new ExtensionesEntity();
        objetoExtensionesInsercion = new ExtensionesEntity();
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
