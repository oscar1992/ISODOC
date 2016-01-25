package co.com.siscomputo.administracion.bean;

import co.com.siscomputo.administracion.logic.UsuarioGrupoUsuarioLogic;
import co.com.siscomputo.administracion.logic.UsuarioLogic;
import co.com.siscomputo.endpoint.GrupoUsuariosEntity;
import co.com.siscomputo.endpoint.UsuarioGrupoUsuarioEntity;
import co.com.siscomputo.endpoint.MenuPermisosEntity;
import co.com.siscomputo.endpoint.ObjetoRetornaEntity;
import co.com.siscomputo.endpoint.UsuarioEntity;
import co.com.siscomputo.utilidades.MensajesJSF;
import java.io.Serializable; 
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.event.SelectEvent;
import javax.faces.context.FacesContext;
import org.primefaces.model.DualListModel;

/**
 *
 * @author LENOVO
 */
@ManagedBean(name = "UsuarioGrupoUsuario")
@ViewScoped
public class UsuarioGrupoUsuarioBean implements Serializable {

    private UsuarioGrupoUsuarioEntity objetoUsuarioGrupoUsuario;
    private UsuarioGrupoUsuarioEntity objetoUsuarioGrupoUsuarioInsercion;
    private GrupoUsuariosEntity grupoUsuariosEntity;
    private ArrayList<UsuarioEntity> listaUsuarios;
    private DualListModel<String> listad;
    private ArrayList<String> listanombres;
    private ArrayList<String> listaseleccion;
    private Integer idGrupo;
    private boolean ingresar;
    private boolean actualizar;
    private boolean eliminar;

    public Integer getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(Integer idGrupo) {
        this.idGrupo = idGrupo;
    }

    public ArrayList<String> getListanombres() {
        return listanombres;
    }

    public void setListanombres(ArrayList<String> listanombres) {
        this.listanombres = listanombres;
    }

    public ArrayList<String> getListaseleccion() {
        return listaseleccion;
    }

    public void setListaseleccion(ArrayList<String> listaseleccion) {
        this.listaseleccion = listaseleccion;
    }

    public UsuarioGrupoUsuarioEntity getObjetoUsuarioGrupoUsuario() {
        return objetoUsuarioGrupoUsuario;
    }

    public void setObjetoUsuarioGrupoUsuario(UsuarioGrupoUsuarioEntity objetoUsuarioGrupoUsuario) {
        this.objetoUsuarioGrupoUsuario = objetoUsuarioGrupoUsuario;
    }

    public UsuarioGrupoUsuarioEntity getObjetoUsuarioGrupoUsuarioInsercion() {
        return objetoUsuarioGrupoUsuarioInsercion;
    }

    public void setObjetoUsuarioGrupoUsuarioInsercion(UsuarioGrupoUsuarioEntity objetoUsuarioGrupoUsuarioInsercion) {
        this.objetoUsuarioGrupoUsuarioInsercion = objetoUsuarioGrupoUsuarioInsercion;
    }

    public GrupoUsuariosEntity getGrupoUsuariosEntity() {
        return grupoUsuariosEntity;
    }

    public void setGrupoUsuariosEntity(GrupoUsuariosEntity grupoUsuariosEntity) {
        this.grupoUsuariosEntity = grupoUsuariosEntity;
    }

    public ArrayList<UsuarioEntity> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(ArrayList<UsuarioEntity> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    public DualListModel<String> getListad() {
        return listad;
    }

    public void setListad(DualListModel<String> listad) {
        this.listad = listad;
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

        //consultarUsuarioGrupoUsuario();
        permisos();
    }

    public UsuarioGrupoUsuarioBean() {
        objetoUsuarioGrupoUsuario = new UsuarioGrupoUsuarioEntity();
        objetoUsuarioGrupoUsuarioInsercion = new UsuarioGrupoUsuarioEntity();
        listad = new DualListModel<String>();
    }

    /**
     * Método que trae una lista de relacion entre Usuarios y Grupos de Usuarios
     */
    public void consultarUsuarioGrupoUsuario() {
        try {
            if (idGrupo != null) {
                UsuarioGrupoUsuarioLogic usuarioGrupoUsuarioLogic = new UsuarioGrupoUsuarioLogic();
                ArrayList<UsuarioEntity> listaaUsuarios = usuarioGrupoUsuarioLogic.listaUsuarioGrupoUsuarioPorGrupo(idGrupo);
                System.out.println("TAMA: "+listaaUsuarios.size());
                for(UsuarioEntity usu:listaaUsuarios){
                    System.out.println("SELECION: "+usu.getNombre());
                    listaseleccion.add(usu.getNombre());
                }
                
            }else{
                System.out.println("GRUPO VACIO");
            }
            //listaus = usuarioGrupoUsuarioLogic.listaUsuarioGrupoUsuario();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void consultarUsuarios() {
        System.out.println("consulta");
        try {
            UsuarioLogic usuarioLogic = new UsuarioLogic();
            listaUsuarios = usuarioLogic.listaUsuarios();
            listanombres = new ArrayList<String>();
            listaseleccion = new ArrayList<String>();
            consultarUsuarioGrupoUsuario();
            for (UsuarioEntity usu : listaUsuarios) {
                //System.out.println("cc: "+usu.getNombre());
                listanombres.add(usu.getNombre());
            }
            listad = new DualListModel<>(listanombres, listaseleccion);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Método que permite insertar un relacion entre Usuarios y Grupos de
     * Usuarios nuevo
     */
    public void instertarUsuarioGrupoUsuario() {
        try {
            UsuarioGrupoUsuarioLogic usuarioGrupoUsuarioLogic = new UsuarioGrupoUsuarioLogic();            
            ObjetoRetornaEntity insertRespuesta = usuarioGrupoUsuarioLogic.insertarUsuarioGrupoUsuario((ArrayList<String>) listad.getTarget(), idGrupo);
            FacesMessage msg = null;
            if (insertRespuesta != null) {
                MensajesJSF.muestraMensajes( "inserción de relacion entre Usuarios y Grupos de Usuarios correcto", "Mensaje");                
            } else {
                MensajesJSF.muestraMensajes( "inserción de relacion entre Usuarios y Grupos de Usuarios incorrecto", "Error");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Método que añade un relacion entre Usuarios y Grupos de Usuarios
     * visualmente
     *
     * @param objetoUsuarioGrupoUsuario
     */
    private void adicionarMetodoPtoteccionLista(UsuarioGrupoUsuarioEntity objetoUsuarioGrupoUsuario) {
        //lista.add(objetoUsuarioGrupoUsuario);
    }

    /**
     * Método que se invoca al seleccionar una fila de la tabla
     *
     *
     * @param event
     */
    public void onRowSelect(SelectEvent event) {
        grupoUsuariosEntity = new GrupoUsuariosEntity();
        grupoUsuariosEntity = (GrupoUsuariosEntity) event.getObject();
        idGrupo = grupoUsuariosEntity.getIdGrupoUsuarios();
        System.out.println("idgrupo: " + idGrupo);
        consultarUsuarios();
    }

    /**
     * Método que reinicia el objeto relacion entre Usuarios y Grupos de
     * Usuarios
     */
    public void nuevoUsuarioGrupoUsuarioObjeto() {
        objetoUsuarioGrupoUsuario = new UsuarioGrupoUsuarioEntity();
        objetoUsuarioGrupoUsuarioInsercion = new UsuarioGrupoUsuarioEntity();

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
