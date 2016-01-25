package co.com.siscomputo.administracion.bean;

import co.com.siscomputo.administracion.logic.SubProcesosLogic;
import co.com.siscomputo.administracion.logic.UsuarioSubprocesoLogic;
import co.com.siscomputo.endpoint.AccionEntity;
import co.com.siscomputo.endpoint.SubprocesoEntity;
import co.com.siscomputo.endpoint.UsuarioSubprocesoEntity;
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
@ManagedBean(name = "UsuarioSubproceso")
@ViewScoped
public class UsuarioSubprocesoBean implements Serializable {

    private ArrayList<UsuarioSubprocesoEntity> lista;
    private ArrayList<UsuarioSubprocesoEntity> listaFiltro;
    private UsuarioSubprocesoEntity objetoUsuarioSubproceso;
    private Integer idUsuario;
    private Integer idAccion;
    private DualListModel<String> subpro;
    private ArrayList<String> subproNombre;
    private ArrayList<String> subproSeleccion;
    private UsuarioEntity usuarioEntity;
    private boolean ingresar;
    private boolean actualizar;
    private boolean eliminar;

    public ArrayList<UsuarioSubprocesoEntity> getLista() {
        return lista;
    }

    public void setLista(ArrayList<UsuarioSubprocesoEntity> lista) {
        this.lista = lista;
    }

    public ArrayList<UsuarioSubprocesoEntity> getListaFiltro() {
        return listaFiltro;
    }

    public void setListaFiltro(ArrayList<UsuarioSubprocesoEntity> listaFiltro) {
        this.listaFiltro = listaFiltro;
    }

    public UsuarioSubprocesoEntity getObjetoUsuarioSubproceso() {
        return objetoUsuarioSubproceso;
    }

    public void setObjetoUsuarioSubproceso(UsuarioSubprocesoEntity objetoUsuarioSubproceso) {
        this.objetoUsuarioSubproceso = objetoUsuarioSubproceso;
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
        return subpro;
    }

    public void setMacros(DualListModel<String> subpro) {
        this.subpro = subpro;
    }

    public ArrayList<String> getMacrosNombre() {
        return subproNombre;
    }

    public void setMacrosNombre(ArrayList<String> subproNombre) {
        this.subproNombre = subproNombre;
    }

    public ArrayList<String> getMacrosSeleccion() {
        return subproSeleccion;
    }

    public void setMacrosSeleccion(ArrayList<String> subproSeleccion) {
        this.subproSeleccion = subproSeleccion;
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
        consultarUsuarioSubproceso();
        permisos();
    }

    public UsuarioSubprocesoBean() {
        objetoUsuarioSubproceso = new UsuarioSubprocesoEntity();
        
        usuarioEntity = new UsuarioEntity();
        subpro = new DualListModel<>();
        subproNombre = new ArrayList<>();
        subproSeleccion = new ArrayList<>();
        idAccion = null;
    }

    /**
     * Método que trae una lista de Usuario y su SubProceso
     */
    public void consultarListaSubprocesos() {
        try {
            SubProcesosLogic macroProcesosLogic = new SubProcesosLogic();
            ArrayList<SubprocesoEntity> listaSubprocesos = macroProcesosLogic.listaSubprocesos();
            for (SubprocesoEntity subpro : listaSubprocesos) {
                subproNombre.add(subpro.getNombreSubproceso());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void consultarUsuarioSubproceso() {
        if (idUsuario != null) {
            try {
                subproSeleccion = new ArrayList<>();
                UsuarioSubprocesoLogic usuarioSubprocesoLogic = new UsuarioSubprocesoLogic();
                lista = usuarioSubprocesoLogic.listaUsuarioMacroporcesoPorUsuario(idUsuario);
                for (UsuarioSubprocesoEntity usu : lista) {
                    subproSeleccion.add(usu.getIdSubprocesoEntity().getNombreSubproceso());
                }
                subpro = new DualListModel<>(subproNombre, subproSeleccion);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Método que trae la lista de macroprocesos asignados
     */
    public void consultarusuarioSubprocesoPorUsuarioAccion() {
        if (idUsuario != null) {
            try {
                subproSeleccion = new ArrayList<>();
                UsuarioSubprocesoLogic usuarioSubprocesoLogic = new UsuarioSubprocesoLogic();
                lista = usuarioSubprocesoLogic.listaUsuarioMacroporcesoPorUsuarioAccion(idUsuario, idAccion);
                for (UsuarioSubprocesoEntity usu : lista) {
                    subproSeleccion.add(usu.getIdSubprocesoEntity().getNombreSubproceso());
                }
                subpro = new DualListModel<>(subproNombre, subproSeleccion);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("USUARIO NULO");
        }
    }

    /**
     * Método que permite insertar un Usuario y su SubProceso nuevo
     */
    public void instertarUsuarioSubproceso() {

        if (subpro.getTarget().size() > 0) {
            try {
                UsuarioSubprocesoLogic usuarioSubprocesoLogic = new UsuarioSubprocesoLogic();
                ObjetoRetornaEntity retorna = usuarioSubprocesoLogic.insertarUsuarioSubproceso((ArrayList<String>) subpro.getTarget(), usuarioEntity, idAccion);
                FacesMessage msg = null;
                if (retorna != null) {
                    MensajesJSF.muestraMensajes( "inserción de Usuario y su SubProceso correcto", "Mensaje");

                } else {
                    MensajesJSF.muestraMensajes( "inserción de Usuario y su SubProceso incorrecto", "Error");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            nuevoUsuarioSubprocesoObjeto();
        }

    }

 

    /**
     * Método que permite actualizar un Usuario y su SubProceso
     */
    public void actualizarUsuarioSubproceso() {
        UsuarioSubprocesoLogic metodoRecuperacionLogic = new UsuarioSubprocesoLogic();
        String valida = metodoRecuperacionLogic.actualizarUsuarioSubproceso(objetoUsuarioSubproceso);
        FacesMessage msg = null;
        if ("Ok".equalsIgnoreCase(valida)) {
            MensajesJSF.muestraMensajes( "actualización de Usuario y su SubProceso correcto", "Mensaje");
            actualizarUsuarioSubprocesoLista(objetoUsuarioSubproceso);
        } else {
            MensajesJSF.muestraMensajes( "actualización de Usuario y su SubProceso incorrecto", "Error");
        }
        nuevoUsuarioSubprocesoObjeto();
        RequestContext.getCurrentInstance().execute("PF('actualizarUsuarioSubproceso').hide()");
    }

    /**
     * Método que actualiza visualmente la lista de Usuario y su SubProceso
     *
     * @param objetoUsuarioSubproceso
     */
    private void actualizarUsuarioSubprocesoLista(UsuarioSubprocesoEntity objetoUsuarioSubproceso) {
        try {
            ArrayList<UsuarioSubprocesoEntity> listaaux = new ArrayList<>();
            if (lista != null) {
                for (UsuarioSubprocesoEntity item : lista) {
                    int v1 = objetoUsuarioSubproceso.getIdUsuarioSubproceso();
                    int v2 = item.getIdUsuarioSubproceso();
                    if (v1 == v2) {
                        listaaux.add(objetoUsuarioSubproceso);
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
        objetoUsuarioSubproceso = (UsuarioSubprocesoEntity) event.getObject();
    }
    /**
     * Método que se invoca al seleccionar una fila de la tabla usuarios    
     * @param event
     */
    public void onRowSelect2(SelectEvent event) {
        subproNombre=new ArrayList<>();
        subproSeleccion=new ArrayList<>();
        subpro=new DualListModel<>(subproNombre, subproSeleccion);
        usuarioEntity=(UsuarioEntity)event.getObject();
        idUsuario=usuarioEntity.getIdUsuario();
        consultarListaSubprocesos();
    }
    /**
     * Método que se invoca al seleccionar una fila de la tabla acciones
     * @param event
     */
    public void onRowSelect3(SelectEvent event){
        idUsuario=usuarioEntity.getIdUsuario();
        objetoUsuarioSubproceso.setIdAccion((AccionEntity)event.getObject());
        idAccion=objetoUsuarioSubproceso.getIdAccion().getIdAccion();
        consultarusuarioSubprocesoPorUsuarioAccion();
    }
    

    /**
     * Método que reinicia el objeto Usuario y su SubProceso
     */
    public void nuevoUsuarioSubprocesoObjeto() {
        objetoUsuarioSubproceso = new UsuarioSubprocesoEntity();
        
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
