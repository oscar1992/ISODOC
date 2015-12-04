package co.com.siscomputo.administracion.bean;

import co.com.siscomputo.administracion.logic.MacroProcesosLogic;
import co.com.siscomputo.administracion.logic.UsuarioMacroprocesoLogic;
import co.com.siscomputo.endpoint.AccionEntity;
import co.com.siscomputo.endpoint.MacroprocesosEntity;
import co.com.siscomputo.endpoint.UsuarioMacroprocesoEntity;
import co.com.siscomputo.endpoint.MenuPermisosEntity;
import co.com.siscomputo.endpoint.ObjetoRetornaEntity;
import co.com.siscomputo.endpoint.UsuarioEntity;
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
@ManagedBean(name = "UsuarioMacroproceso")
@ViewScoped
public class UsuarioMacroprocesoBean implements Serializable {

    private ArrayList<UsuarioMacroprocesoEntity> lista;
    private ArrayList<UsuarioMacroprocesoEntity> listaFiltro;
    private UsuarioMacroprocesoEntity objetoUsuarioMacroproceso;
    private Integer idUsuario;
    private Integer idAccion;
    private DualListModel<String> macros;
    private ArrayList<String> macrosNombre;
    private ArrayList<String> macrosSeleccion;
    private UsuarioEntity usuarioEntity;
    private boolean ingresar;
    private boolean actualizar;
    private boolean eliminar;

    public ArrayList<UsuarioMacroprocesoEntity> getLista() {
        return lista;
    }

    public void setLista(ArrayList<UsuarioMacroprocesoEntity> lista) {
        this.lista = lista;
    }

    public ArrayList<UsuarioMacroprocesoEntity> getListaFiltro() {
        return listaFiltro;
    }

    public void setListaFiltro(ArrayList<UsuarioMacroprocesoEntity> listaFiltro) {
        this.listaFiltro = listaFiltro;
    }

    public UsuarioMacroprocesoEntity getObjetoUsuarioMacroproceso() {
        return objetoUsuarioMacroproceso;
    }

    public void setObjetoUsuarioMacroproceso(UsuarioMacroprocesoEntity objetoUsuarioMacroproceso) {
        this.objetoUsuarioMacroproceso = objetoUsuarioMacroproceso;
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
        return macros;
    }

    public void setMacros(DualListModel<String> macros) {
        this.macros = macros;
    }

    public ArrayList<String> getMacrosNombre() {
        return macrosNombre;
    }

    public void setMacrosNombre(ArrayList<String> macrosNombre) {
        this.macrosNombre = macrosNombre;
    }

    public ArrayList<String> getMacrosSeleccion() {
        return macrosSeleccion;
    }

    public void setMacrosSeleccion(ArrayList<String> macrosSeleccion) {
        this.macrosSeleccion = macrosSeleccion;
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
        consultarUsuarioMacroproceso();
        permisos();
    }

    public UsuarioMacroprocesoBean() {
        objetoUsuarioMacroproceso = new UsuarioMacroprocesoEntity();
        
        usuarioEntity = new UsuarioEntity();
        macros = new DualListModel<>();
        macrosNombre = new ArrayList<>();
        macrosSeleccion = new ArrayList<>();
        idAccion = null;
    }

    /**
     * Método que trae una lista de Usuario y su MacroProceso
     */
    public void consultarListaMacroprocesos() {
        try {
            MacroProcesosLogic macroProcesosLogic = new MacroProcesosLogic();
            ArrayList<MacroprocesosEntity> listaMacroprocesos = macroProcesosLogic.listaMacroprocesos();
            for (MacroprocesosEntity macros : listaMacroprocesos) {
                macrosNombre.add(macros.getNombreMacroproceso());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void consultarUsuarioMacroproceso() {
        if (idUsuario != null) {
            try {
                macrosSeleccion = new ArrayList<>();
                UsuarioMacroprocesoLogic usuarioMacroprocesoLogic = new UsuarioMacroprocesoLogic();
                lista = usuarioMacroprocesoLogic.listaUsuarioMacroporcesoPorUsuario(idUsuario);
                for (UsuarioMacroprocesoEntity usu : lista) {
                    macrosSeleccion.add(usu.getIdMacroProceso().getNombreMacroproceso());
                }
                macros = new DualListModel<>(macrosNombre, macrosSeleccion);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Método que trae la lista de macroprocesos asignados
     */
    public void consultarusuarioMacroprocesoPorUsuarioAccion() {
        if (idUsuario != null) {
            try {
                macrosSeleccion = new ArrayList<>();
                UsuarioMacroprocesoLogic usuarioMacroprocesoLogic = new UsuarioMacroprocesoLogic();
                lista = usuarioMacroprocesoLogic.listaUsuarioMacroporcesoPorUsuarioAccion(idUsuario, idAccion);
                for (UsuarioMacroprocesoEntity usu : lista) {
                    macrosSeleccion.add(usu.getIdMacroProceso().getNombreMacroproceso());
                }
                macros = new DualListModel<>(macrosNombre, macrosSeleccion);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("USUARIO NULO");
        }
    }

    /**
     * Método que permite insertar un Usuario y su MacroProceso nuevo
     */
    public void instertarUsuarioMacroproceso() {

        if (macros.getTarget().size() > 0) {
            try {
                UsuarioMacroprocesoLogic usuarioMacroprocesoLogic = new UsuarioMacroprocesoLogic();
                ObjetoRetornaEntity retorna = usuarioMacroprocesoLogic.insertarUsuarioMacroproceso((ArrayList<String>) macros.getTarget(), usuarioEntity, idAccion);
                FacesMessage msg = null;
                if (retorna != null) {
                    msg = new FacesMessage("", "inserción de Usuario y su MacroProceso correcto");

                } else {
                    msg = new FacesMessage("", "inserción de Usuario y su MacroProceso incorrecto");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            nuevoUsuarioMacroprocesoObjeto();
        }

    }

 

    /**
     * Método que permite actualizar un Usuario y su MacroProceso
     */
    public void actualizarUsuarioMacroproceso() {
        UsuarioMacroprocesoLogic metodoRecuperacionLogic = new UsuarioMacroprocesoLogic();
        String valida = metodoRecuperacionLogic.actualizarUsuarioMacroproceso(objetoUsuarioMacroproceso);
        FacesMessage msg = null;
        if ("Ok".equalsIgnoreCase(valida)) {
            msg = new FacesMessage("", "actualización de Usuario y su MacroProceso correcto");
            actualizarUsuarioMacroprocesoLista(objetoUsuarioMacroproceso);
        } else {
            msg = new FacesMessage("", "actualización de Usuario y su MacroProceso incorrecto");
        }
        nuevoUsuarioMacroprocesoObjeto();
        RequestContext.getCurrentInstance().execute("PF('actualizarUsuarioMacroproceso').hide()");
    }

    /**
     * Método que actualiza visualmente la lista de Usuario y su MacroProceso
     *
     * @param objetoUsuarioMacroproceso
     */
    private void actualizarUsuarioMacroprocesoLista(UsuarioMacroprocesoEntity objetoUsuarioMacroproceso) {
        try {
            ArrayList<UsuarioMacroprocesoEntity> listaaux = new ArrayList<>();
            if (lista != null) {
                for (UsuarioMacroprocesoEntity item : lista) {
                    int v1 = objetoUsuarioMacroproceso.getIdUsuarioMacroproceso();
                    int v2 = item.getIdUsuarioMacroproceso();
                    if (v1 == v2) {
                        listaaux.add(objetoUsuarioMacroproceso);
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
        objetoUsuarioMacroproceso = (UsuarioMacroprocesoEntity) event.getObject();
    }
    /**
     * Método que se invoca al seleccionar una fila de la tabla usuarios    
     * @param event
     */
    public void onRowSelect2(SelectEvent event) {
        macrosNombre=new ArrayList<>();
        macrosSeleccion=new ArrayList<>();
        macros=new DualListModel<>(macrosNombre, macrosSeleccion);
        usuarioEntity=(UsuarioEntity)event.getObject();
        idUsuario=usuarioEntity.getIdUsuario();
        consultarListaMacroprocesos();
    }
    /**
     * Método que se invoca al seleccionar una fila de la tabla acciones
     * @param event
     */
    public void onRowSelect3(SelectEvent event){
        idUsuario=usuarioEntity.getIdUsuario();
        objetoUsuarioMacroproceso.setIdAccion((AccionEntity)event.getObject());
        idAccion=objetoUsuarioMacroproceso.getIdAccion().getIdAccion();
        consultarusuarioMacroprocesoPorUsuarioAccion();
    }
    

    /**
     * Método que reinicia el objeto Usuario y su MacroProceso
     */
    public void nuevoUsuarioMacroprocesoObjeto() {
        objetoUsuarioMacroproceso = new UsuarioMacroprocesoEntity();
        
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
