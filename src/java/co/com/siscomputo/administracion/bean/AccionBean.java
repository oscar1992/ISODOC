package co.com.siscomputo.administracion.bean;

import co.com.siscomputo.administracion.logic.AccionLogic;
import co.com.siscomputo.endpoint.AccionEntity;
import co.com.siscomputo.endpoint.MenuPermisosEntity;
import co.com.siscomputo.utilidades.ComparadorAccion2;
import co.com.siscomputo.utilidades.MensajesJSF;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
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
@ManagedBean(name = "Accion")
@ViewScoped
public class AccionBean implements Serializable {

    private ArrayList<AccionEntity> lista;
    private ArrayList<AccionEntity> listaFiltro;
    private AccionEntity objetoAccion;
    private AccionEntity objetoAccionInsercion;
    private boolean ingresar;
    private boolean actualizar;
    private boolean eliminar;

    public ArrayList<AccionEntity> getLista() {
        return lista;
    }

    public void setLista(ArrayList<AccionEntity> lista) {
        this.lista = lista;
    }

    public ArrayList<AccionEntity> getListaFiltro() {
        return listaFiltro;
    }

    public void setListaFiltro(ArrayList<AccionEntity> listaFiltro) {
        this.listaFiltro = listaFiltro;
    }

    public AccionEntity getObjetoAccion() {
        return objetoAccion;
    }

    public void setObjetoAccion(AccionEntity objetoAccion) {
        this.objetoAccion = objetoAccion;
    }

    public AccionEntity getObjetoAccionInsercion() {
        return objetoAccionInsercion;
    }

    public void setObjetoAccionInsercion(AccionEntity objetoAccionInsercion) {
        this.objetoAccionInsercion = objetoAccionInsercion;
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
        consultarAccion();
        inicializarNuevaAccion();
        permisos();
    }

    public AccionBean() {
        objetoAccion = new AccionEntity();
        objetoAccionInsercion = new AccionEntity();
    }

    /**
     * Método que trae una lista de Acción
     */
    public void consultarAccion() {
        try {
            AccionLogic accionLogic = new AccionLogic();
            lista = accionLogic.listaAccion();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Método que permite insertar un Acción nuevo
     */
    public void instertarAccion() {
        try {
            AccionLogic accionLogic = new AccionLogic();
            AccionEntity accionEntity = accionLogic.insertarAccion(objetoAccionInsercion);
            FacesMessage msg = null;
            if (accionEntity != null) {
                MensajesJSF.muestraMensajes("inserción de Acción correcto", "Mensaje");
                adicionarMetodoPtoteccionLista(accionEntity);
            } else {
                MensajesJSF.muestraMensajes("inserción de Acción incorrecto", "Error");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Método que añade un Acción visualmente
     *
     * @param objetoAccion
     */
    private void adicionarMetodoPtoteccionLista(AccionEntity objetoAccion) {
        lista.add(objetoAccion);
    }

    /**
     * Método que permite actualizar un Acción
     */
    public void actualizarAccion() {
        AccionLogic metodoRecuperacionLogic = new AccionLogic();
        String valida = metodoRecuperacionLogic.actualizarAccion(objetoAccion);
        FacesMessage msg = null;
        if ("Ok".equalsIgnoreCase(valida)) {
            MensajesJSF.muestraMensajes("actualización de Acción correcto", "Mensaje");
            actualizarAccionLista(objetoAccion);
        } else {
            MensajesJSF.muestraMensajes("actualización de Acción incorrecto", "Error");
        }
        nuevoAccionObjeto();
        RequestContext.getCurrentInstance().execute("PF('actualizarAccion').hide()");
    }

    /**
     * Método que actualiza visualmente la lista de Acción
     *
     * @param objetoAccion
     */
    private void actualizarAccionLista(AccionEntity objetoAccion) {
        try {
            ArrayList<AccionEntity> listaaux = new ArrayList<>();
            if (lista != null) {
                for (AccionEntity item : lista) {
                    int v1 = objetoAccion.getIdAccion();
                    int v2 = item.getIdAccion();
                    if (v1 == v2) {
                        listaaux.add(objetoAccion);
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
        objetoAccion = (AccionEntity) event.getObject();
    }

    /**
     * Método que elimina un Acción
     */
    public void eliminarAccion() {
        Collections.sort(lista, new ComparadorAccion2());
        AccionLogic metodoRecuperacionLogic = new AccionLogic();
        for (AccionEntity accion : lista) {
            if (Integer.parseInt(accion.getOrdenAccion()) > Integer.parseInt(objetoAccion.getOrdenAccion())) {
                String orden = String.valueOf(Integer.parseInt(accion.getOrdenAccion()) - 1);
                accion.setOrdenAccion(orden);
                String valida = metodoRecuperacionLogic.actualizarAccion(accion);
                if ("Ok".equalsIgnoreCase(valida)) {
                    System.out.println("Cambio de orden OK");
                } else {
                    System.out.println("Cambio de orden Fallido");
                }
            }
        }
        objetoAccion.setOrdenAccion("0");
        objetoAccion.setEstadoAccion("E");
        metodoRecuperacionLogic.actualizarAccion(objetoAccion);
        eliminarAccionLista(objetoAccion);
        siguienteOrden();
        RequestContext conte=RequestContext.getCurrentInstance();
        conte.update("IngresarModal:insertarAccionModal");
        RequestContext.getCurrentInstance().execute("PF('actualizarAccion').hide()");
        MensajesJSF.muestraMensajes("Eliminación de Acción correcto", "Mensaje");
    }

    /**
     * Método que elimina visualmente un objeto de la lista
     *
     * @param objetoAccion
     */
    private void eliminarAccionLista(AccionEntity objetoAccion) {
        Iterator itr = lista.iterator();
        while (itr.hasNext()) {
            AccionEntity metodoRecuperacionEntity = (AccionEntity) itr.next();
            if (metodoRecuperacionEntity.getIdAccion() == objetoAccion.getIdAccion()) {
                itr.remove();
            }
        }
    }

    /**
     * Método que reinicia el objeto Acción
     */
    public void nuevoAccionObjeto() {
        objetoAccion = new AccionEntity();
        objetoAccionInsercion = new AccionEntity();
    }

    public void validaSecuencia(Integer secu) {
        for (AccionEntity accion : lista) {
            if (Integer.parseInt(accion.getOrdenAccion()) == secu) {
                objetoAccionInsercion.setOrdenAccion("Orden ya seleccionado");
                objetoAccion.setOrdenAccion("Orden ya seleccionado");
            }
        }
    }
    /**
     * Método que trael el siguiente número de orden de la acción
     */
    public void siguienteOrden(){
        try {
            System.out.println("Siguiente");
            AccionEntity accionEntity = Collections.max(lista, new ComparadorAccion2());
            objetoAccionInsercion.setOrdenAccion(""+(Integer.parseInt(accionEntity.getOrdenAccion())+1));
        } catch (Exception e) {
            objetoAccionInsercion.setOrdenAccion("0");
        }
    }
    
    public void inicializarNuevaAccion(){

        nuevoAccionObjeto();
        siguienteOrden();
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
