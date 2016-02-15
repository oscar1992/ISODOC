package co.com.siscomputo.proveedores.bean;

import co.com.siscomputo.proveedores.logic.TipoCuentaLogic;
import co.com.siscomputo.endpoint.TipoCuentaEntity;
import co.com.siscomputo.endpoint.MenuPermisosEntity;
import co.com.siscomputo.utilidades.MensajesJSF;
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
@ManagedBean(name = "TipoCuenta")
@ViewScoped
public class TipoCuentaBean implements Serializable {

    private ArrayList<TipoCuentaEntity> lista;
    private ArrayList<TipoCuentaEntity> listaFiltro;
    private TipoCuentaEntity objetoTipoCuenta;
    private TipoCuentaEntity objetoTipoCuentaInsercion;
    private boolean ingresar;
    private boolean actualizar;
    private boolean eliminar;

    public ArrayList<TipoCuentaEntity> getLista() {
        return lista;
    }

    public void setLista(ArrayList<TipoCuentaEntity> lista) {
        this.lista = lista;
    }

    public ArrayList<TipoCuentaEntity> getListaFiltro() {
        return listaFiltro;
    }

    public void setListaFiltro(ArrayList<TipoCuentaEntity> listaFiltro) {
        this.listaFiltro = listaFiltro;
    }

    public TipoCuentaEntity getObjetoTipoCuenta() {
        return objetoTipoCuenta;
    }

    public void setObjetoTipoCuenta(TipoCuentaEntity objetoTipoCuenta) {
        this.objetoTipoCuenta = objetoTipoCuenta;
    }

    public TipoCuentaEntity getObjetoTipoCuentaInsercion() {
        return objetoTipoCuentaInsercion;
    }

    public void setObjetoTipoCuentaInsercion(TipoCuentaEntity objetoTipoCuentaInsercion) {
        this.objetoTipoCuentaInsercion = objetoTipoCuentaInsercion;
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
        consultarTipoCuenta();
        permisos();
    }

    public TipoCuentaBean() {
        objetoTipoCuenta = new TipoCuentaEntity();
        objetoTipoCuentaInsercion = new TipoCuentaEntity();
    }

    /**
     * Método que trae una lista de Tipo de Cuenta
     */
    public void consultarTipoCuenta() {
        try {
            TipoCuentaLogic tipoCuentaLogic = new TipoCuentaLogic();
            lista = tipoCuentaLogic.listaTipoCuenta();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Método que permite insertar un Tipo de Cuenta nuevo
     */
    public void instertarTipoCuenta() {
        try {
            TipoCuentaLogic tipoCuentaLogic = new TipoCuentaLogic();
            TipoCuentaEntity tipoCuentaEntity = tipoCuentaLogic.insertarTipoCuenta(objetoTipoCuentaInsercion);
            FacesMessage msg = null;
            if (tipoCuentaEntity != null) {
                MensajesJSF.muestraMensajes("inserción de Tipo de Cuenta correcto", "Mensaje");                
                adicionarMetodoPtoteccionLista(tipoCuentaEntity);
            } else {
                MensajesJSF.muestraMensajes("inserción de Tipo de Cuenta incorrecto", "Error");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        RequestContext.getCurrentInstance().execute("PF('insertarTipoCuenta').hide()");
        RequestContext context = RequestContext.getCurrentInstance();
        context.update("IngresarModal:insertarTipoCuentaModal");
    }

    /**
     * Método que añade un Tipo de Cuenta visualmente
     *
     * @param objetoTipoCuenta
     */
    private void adicionarMetodoPtoteccionLista(TipoCuentaEntity objetoTipoCuenta) {
        lista.add(objetoTipoCuenta);
    }

    /**
     * Método que permite actualizar un Tipo de Cuenta
     */
    public void actualizarTipoCuenta() {
        TipoCuentaLogic metodoRecuperacionLogic = new TipoCuentaLogic();
        String valida = metodoRecuperacionLogic.actualizarTipoCuenta(objetoTipoCuenta);
        FacesMessage msg = null;
        if ("Ok".equalsIgnoreCase(valida)) {
            MensajesJSF.muestraMensajes("actualización de Tipo de Cuenta correcto", "Mensaje");  
            actualizarTipoCuentaLista(objetoTipoCuenta);
        } else {
            MensajesJSF.muestraMensajes("actualización de Tipo de Cuenta incorrecto", "Error");  
        }
        nuevoTipoCuentaObjeto();
        RequestContext.getCurrentInstance().execute("PF('actualizarTipoCuenta').hide()");
    }

    /**
     * Método que actualiza visualmente la lista de Tipo de Cuenta
     *
     * @param objetoTipoCuenta
     */
    private void actualizarTipoCuentaLista(TipoCuentaEntity objetoTipoCuenta) {
        try {
            ArrayList<TipoCuentaEntity> listaaux = new ArrayList<>();
            if (lista != null) {
                for (TipoCuentaEntity item : lista) {
                    int v1 = objetoTipoCuenta.getIdTipoCuenta();
                    int v2 = item.getIdTipoCuenta();
                    if (v1 == v2) {
                        listaaux.add(objetoTipoCuenta);
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
        objetoTipoCuenta = (TipoCuentaEntity) event.getObject();
    }

    /**
     * Método que elimina un Tipo de Cuenta
     */
    public void eliminarTipoCuenta() {
        TipoCuentaLogic metodoRecuperacionLogic = new TipoCuentaLogic();
        objetoTipoCuenta.setEstadoTipoCuenta("E");
        metodoRecuperacionLogic.actualizarTipoCuenta(objetoTipoCuenta);
        eliminarTipoCuentaLista(objetoTipoCuenta);
        RequestContext.getCurrentInstance().execute("PF('actualizarTipoCuenta').hide()");
        nuevoTipoCuentaObjeto();
    }

    /**
     * Método que elimina visualmente un objeto de la lista
     *
     * @param objetoTipoCuenta
     */
    private void eliminarTipoCuentaLista(TipoCuentaEntity objetoTipoCuenta) {
        Iterator itr = lista.iterator();
        while (itr.hasNext()) {
            TipoCuentaEntity metodoRecuperacionEntity = (TipoCuentaEntity) itr.next();
            if (metodoRecuperacionEntity.getIdTipoCuenta() == objetoTipoCuenta.getIdTipoCuenta()) {
                itr.remove();
            }
        }
    }

    /**
     * Método que reinicia el objeto Tipo de Cuenta
     */
    public void nuevoTipoCuentaObjeto() {
        objetoTipoCuenta = new TipoCuentaEntity();
        objetoTipoCuentaInsercion = new TipoCuentaEntity();
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
