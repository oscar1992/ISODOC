package co.com.siscomputo.administracion.bean;

import co.com.siscomputo.administracion.logic.ProcesosLogic;
import co.com.siscomputo.administracion.logic.UsuarioProcesoLogic;
import co.com.siscomputo.endpoint.AccionEntity;
import co.com.siscomputo.endpoint.ProcesosEntity;
import co.com.siscomputo.endpoint.UsuarioProcesoEntity;
import co.com.siscomputo.endpoint.MenuPermisosEntity;
import co.com.siscomputo.endpoint.ObjetoRetornaEntity;
import co.com.siscomputo.endpoint.UsuarioEntity;
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
import org.primefaces.model.DualListModel;

/**
 *
 * @author LENOVO
 */
@ManagedBean(name = "UsuarioProceso")
@ViewScoped
public class UsuarioProcesoBean implements Serializable {

    private ArrayList<UsuarioProcesoEntity> lista;
    private ArrayList<UsuarioProcesoEntity> listaFiltro;
    private UsuarioProcesoEntity objetoUsuarioProceso;
    private Integer idUsuario;
    private Integer idAccion;
    private DualListModel<String> procesos;
    private ArrayList<String> procesosNombre;
    private ArrayList<String> procesosSeleccion;
    private UsuarioEntity usuarioEntity;
    private boolean ingresar;
    private boolean actualizar;
    private boolean eliminar;

    public ArrayList<UsuarioProcesoEntity> getLista() {
        return lista;
    }

    public void setLista(ArrayList<UsuarioProcesoEntity> lista) {
        this.lista = lista;
    }

    public ArrayList<UsuarioProcesoEntity> getListaFiltro() {
        return listaFiltro;
    }

    public void setListaFiltro(ArrayList<UsuarioProcesoEntity> listaFiltro) {
        this.listaFiltro = listaFiltro;
    }

    public UsuarioProcesoEntity getObjetoUsuarioProceso() {
        return objetoUsuarioProceso;
    }

    public void setObjetoUsuarioProceso(UsuarioProcesoEntity objetoUsuarioProceso) {
        this.objetoUsuarioProceso = objetoUsuarioProceso;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Integer getIdAccion() {
        return idAccion;
    }

    public void setIdAccion(Integer idAccion) {
        this.idAccion = idAccion;
    }

    public DualListModel<String> getMacros() {
        return procesos;
    }

    public void setMacros(DualListModel<String> procesos) {
        this.procesos = procesos;
    }

    public ArrayList<String> getMacrosNombre() {
        return procesosNombre;
    }

    public void setMacrosNombre(ArrayList<String> procesosNombre) {
        this.procesosNombre = procesosNombre;
    }

    public ArrayList<String> getMacrosSeleccion() {
        return procesosSeleccion;
    }

    public void setMacrosSeleccion(ArrayList<String> procesosSeleccion) {
        this.procesosSeleccion = procesosSeleccion;
    }

    public UsuarioEntity getUsuarioEntity() {
        return usuarioEntity;
    }

    public void setUsuarioEntity(UsuarioEntity usuarioEntity) {
        this.usuarioEntity = usuarioEntity;
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
        consultarUsuarioProceso();
        permisos();
    }

    public UsuarioProcesoBean() {
        objetoUsuarioProceso = new UsuarioProcesoEntity();
        
        usuarioEntity = new UsuarioEntity();
        procesos = new DualListModel<>();
        procesosNombre = new ArrayList<>();
        procesosSeleccion = new ArrayList<>();
        idAccion = null;
    }

    /**
     * Método que trae una lista de Usuario y su Proceso
     */
    public void consultarListaProcesos() {
        try {
            ProcesosLogic procesoLogic = new ProcesosLogic();
            ArrayList<ProcesosEntity> listaProcesos = procesoLogic.listaProcesos();
            for (ProcesosEntity procesos : listaProcesos) {
                procesosNombre.add(procesos.getNombrePreoceso());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void consultarUsuarioProceso() {
        if (idUsuario != null) {
            try {
                procesosSeleccion = new ArrayList<>();
                UsuarioProcesoLogic usuarioProcesoLogic = new UsuarioProcesoLogic();
                lista = usuarioProcesoLogic.listaUsuarioMacroporcesoPorUsuario(idUsuario);
                for (UsuarioProcesoEntity usu : lista) {
                    procesosSeleccion.add(usu.getIdProceso().getNombrePreoceso());
                }
                procesos = new DualListModel<>(procesosNombre, procesosSeleccion);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Método que trae la lista de Procesos asignados
     */
    public void consultarusuarioProcesoPorUsuarioAccion() {
        if (idUsuario != null) {
            try {
                procesosSeleccion = new ArrayList<>();
                UsuarioProcesoLogic usuarioProcesoLogic = new UsuarioProcesoLogic();
                lista = usuarioProcesoLogic.listaUsuarioMacroporcesoPorUsuarioAccion(idUsuario, idAccion);
                for (UsuarioProcesoEntity usu : lista) {
                    procesosSeleccion.add(usu.getIdProceso().getNombrePreoceso());
                }
                procesos = new DualListModel<>(procesosNombre, procesosSeleccion);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("USUARIO NULO");
        }
    }

    /**
     * Método que permite insertar un Usuario y su Proceso nuevo
     */
    public void instertarUsuarioProceso() {

        if (procesos.getTarget().size() > 0) {
            try {
                UsuarioProcesoLogic usuarioProcesoLogic = new UsuarioProcesoLogic();
                ObjetoRetornaEntity retorna = usuarioProcesoLogic.insertarUsuarioProceso((ArrayList<String>) procesos.getTarget(), usuarioEntity, idAccion);
                FacesMessage msg = null;
                if (retorna != null) {
                    MensajesJSF.muestraMensajes( "inserción de Usuario y su Proceso correcto", "Mensaje");

                } else {
                    MensajesJSF.muestraMensajes( "inserción de Usuario y su Proceso incorrecto", "Error");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            nuevoUsuarioProcesoObjeto();
        }

    }

 

    /**
     * Método que permite actualizar un Usuario y su Proceso
     */
    public void actualizarUsuarioProceso() {
        UsuarioProcesoLogic metodoRecuperacionLogic = new UsuarioProcesoLogic();
        String valida = metodoRecuperacionLogic.actualizarUsuarioProceso(objetoUsuarioProceso);
        FacesMessage msg = null;
        if ("Ok".equalsIgnoreCase(valida)) {
            MensajesJSF.muestraMensajes( "actualización de Usuario y su Proceso correcto", "Mensaje");
            actualizarUsuarioProcesoLista(objetoUsuarioProceso);
        } else {
            MensajesJSF.muestraMensajes( "actualización de Usuario y su Proceso incorrecto", "Error");
        }
        nuevoUsuarioProcesoObjeto();
        RequestContext.getCurrentInstance().execute("PF('actualizarUsuarioProceso').hide()");
    }

    /**
     * Método que actualiza visualmente la lista de Usuario y su Proceso
     *
     * @param objetoUsuarioProceso
     */
    private void actualizarUsuarioProcesoLista(UsuarioProcesoEntity objetoUsuarioProceso) {
        try {
            ArrayList<UsuarioProcesoEntity> listaaux = new ArrayList<>();
            if (lista != null) {
                for (UsuarioProcesoEntity item : lista) {
                    int v1 = objetoUsuarioProceso.getIdUsuarioProceso();
                    int v2 = item.getIdUsuarioProceso();
                    if (v1 == v2) {
                        listaaux.add(objetoUsuarioProceso);
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
     * Método que se invoca al seleccionar una fila de la tabla usuarios MacropProcesos    
     * @param event
     */
    public void onRowSelect(SelectEvent event) {
        objetoUsuarioProceso = (UsuarioProcesoEntity) event.getObject();
    }
    /**
     * Método que se invoca al seleccionar una fila de la tabla usuarios    
     * @param event
     */
    public void onRowSelect2(SelectEvent event) {
        System.out.println("limpia");
        idAccion=null;
        procesosSeleccion=new ArrayList<String>();
        procesosNombre=new ArrayList<String>();
        procesos=new DualListModel<>();
        usuarioEntity=(UsuarioEntity)event.getObject();
        idUsuario=usuarioEntity.getIdUsuario();
        consultarListaProcesos();
    }
    /**
     * Método que se invoca al seleccionar una fila de la tabla acciones
     * @param event
     */
    public void onRowSelect3(SelectEvent event){
        idUsuario=usuarioEntity.getIdUsuario();
        objetoUsuarioProceso.setIdAccion((AccionEntity)event.getObject());
        idAccion=objetoUsuarioProceso.getIdAccion().getIdAccion();
        consultarusuarioProcesoPorUsuarioAccion();
    }
    

    /**
     * Método que reinicia el objeto Usuario y su Proceso
     */
    public void nuevoUsuarioProcesoObjeto() {
        objetoUsuarioProceso = new UsuarioProcesoEntity();
        
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
