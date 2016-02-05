package co.com.siscomputo.proveedores.bean;

import co.com.siscomputo.proveedores.logic.EstadoProveedorLogic;
import co.com.siscomputo.endpoint.EstadoProveedorEntity;
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
@ManagedBean(name = "EstadoProveedor")
@ViewScoped
public class EstadoProveedorBean implements Serializable {

    private ArrayList<EstadoProveedorEntity> lista;
    private ArrayList<EstadoProveedorEntity> listaFiltro;
    private EstadoProveedorEntity objetoEstadoProveedor;
    private EstadoProveedorEntity objetoEstadoProveedorInsercion;
    private boolean ingresar;
    private boolean actualizar;
    private boolean eliminar;

    public ArrayList<EstadoProveedorEntity> getLista() {
        return lista;
    }

    public void setLista(ArrayList<EstadoProveedorEntity> lista) {
        this.lista = lista;
    }

    public ArrayList<EstadoProveedorEntity> getListaFiltro() {
        return listaFiltro;
    }

    public void setListaFiltro(ArrayList<EstadoProveedorEntity> listaFiltro) {
        this.listaFiltro = listaFiltro;
    }

    public EstadoProveedorEntity getObjetoEstadoProveedor() {
        return objetoEstadoProveedor;
    }

    public void setObjetoEstadoProveedor(EstadoProveedorEntity objetoEstadoProveedor) {
        this.objetoEstadoProveedor = objetoEstadoProveedor;
    }

    public EstadoProveedorEntity getObjetoEstadoProveedorInsercion() {
        return objetoEstadoProveedorInsercion;
    }

    public void setObjetoEstadoProveedorInsercion(EstadoProveedorEntity objetoEstadoProveedorInsercion) {
        this.objetoEstadoProveedorInsercion = objetoEstadoProveedorInsercion;
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
        consultarEstadoProveedor();
        permisos();
    }

    public EstadoProveedorBean() {
        objetoEstadoProveedor = new EstadoProveedorEntity();
        objetoEstadoProveedorInsercion = new EstadoProveedorEntity();
    }

    /**
     * Método que trae una lista de Estado de Proveedor
     */
    public void consultarEstadoProveedor() {
        try {
            EstadoProveedorLogic estadoProveedorLogic = new EstadoProveedorLogic();
            lista = estadoProveedorLogic.listaEstadoProveedor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Método que permite insertar un Estado de Proveedor nuevo
     */
    public void instertarEstadoProveedor() {
        try {
            EstadoProveedorLogic estadoProveedorLogic = new EstadoProveedorLogic();
            EstadoProveedorEntity estadoProveedorEntity = estadoProveedorLogic.insertarEstadoProveedor(objetoEstadoProveedorInsercion);
            FacesMessage msg = null;
            if (estadoProveedorEntity != null) {
                msg = new FacesMessage("", "inserción de Estado de Proveedor correcto");
                adicionarMetodoPtoteccionLista(estadoProveedorEntity);
            } else {
                msg = new FacesMessage("", "inserción de Estado de Proveedor incorrecto");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        RequestContext.getCurrentInstance().execute("PF('insertarEstadoProveedor').hide()");
        RequestContext context = RequestContext.getCurrentInstance();
        context.update("IngresarModal:insertarEstadoProveedorModal");
    }

    /**
     * Método que añade un Estado de Proveedor visualmente
     *
     * @param objetoEstadoProveedor
     */
    private void adicionarMetodoPtoteccionLista(EstadoProveedorEntity objetoEstadoProveedor) {
        lista.add(objetoEstadoProveedor);
    }

    /**
     * Método que permite actualizar un Estado de Proveedor
     */
    public void actualizarEstadoProveedor() {
        EstadoProveedorLogic metodoRecuperacionLogic = new EstadoProveedorLogic();
        String valida = metodoRecuperacionLogic.actualizarEstadoProveedor(objetoEstadoProveedor);
        FacesMessage msg = null;
        if ("Ok".equalsIgnoreCase(valida)) {
            msg = new FacesMessage("", "actualización de Estado de Proveedor correcto");
            actualizarEstadoProveedorLista(objetoEstadoProveedor);
        } else {
            msg = new FacesMessage("", "actualización de Estado de Proveedor incorrecto");
        }
        nuevoEstadoProveedorObjeto();
        RequestContext.getCurrentInstance().execute("PF('actualizarEstadoProveedor').hide()");
    }

    /**
     * Método que actualiza visualmente la lista de Estado de Proveedor
     *
     * @param objetoEstadoProveedor
     */
    private void actualizarEstadoProveedorLista(EstadoProveedorEntity objetoEstadoProveedor) {
        try {
            ArrayList<EstadoProveedorEntity> listaaux = new ArrayList<>();
            if (lista != null) {
                for (EstadoProveedorEntity item : lista) {
                    int v1 = objetoEstadoProveedor.getIdEstadoProveedor();
                    int v2 = item.getIdEstadoProveedor();
                    if (v1 == v2) {
                        listaaux.add(objetoEstadoProveedor);
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
        objetoEstadoProveedor = (EstadoProveedorEntity) event.getObject();
    }

    /**
     * Método que elimina un Estado de Proveedor
     */
    public void eliminarEstadoProveedor() {
        EstadoProveedorLogic metodoRecuperacionLogic = new EstadoProveedorLogic();
        objetoEstadoProveedor.setEstadoEstadoProveedor("E");
        metodoRecuperacionLogic.actualizarEstadoProveedor(objetoEstadoProveedor);
        eliminarEstadoProveedorLista(objetoEstadoProveedor);
        RequestContext.getCurrentInstance().execute("PF('actualizarEstadoProveedor').hide()");
        nuevoEstadoProveedorObjeto();
    }

    /**
     * Método que elimina visualmente un objeto de la lista
     *
     * @param objetoEstadoProveedor
     */
    private void eliminarEstadoProveedorLista(EstadoProveedorEntity objetoEstadoProveedor) {
        Iterator itr = lista.iterator();
        while (itr.hasNext()) {
            EstadoProveedorEntity metodoRecuperacionEntity = (EstadoProveedorEntity) itr.next();
            if (metodoRecuperacionEntity.getIdEstadoProveedor() == objetoEstadoProveedor.getIdEstadoProveedor()) {
                itr.remove();
            }
        }
    }

    /**
     * Método que reinicia el objeto Estado de Proveedor
     */
    public void nuevoEstadoProveedorObjeto() {
        objetoEstadoProveedor = new EstadoProveedorEntity();
        objetoEstadoProveedorInsercion = new EstadoProveedorEntity();
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
