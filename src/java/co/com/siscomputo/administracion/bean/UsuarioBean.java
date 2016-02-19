/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.siscomputo.administracion.bean;

import co.com.siscomputo.administracion.logic.UsuarioLogic;
import co.com.siscomputo.endpoint.MenuPermisosEntity;
import co.com.siscomputo.endpoint.UsuarioEntity;
import co.com.siscomputo.utilidades.MensajesJSF;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author LENOVO
 */
@ManagedBean(name = "Usuario")
@ViewScoped
public class UsuarioBean implements Serializable {

    private UsuarioEntity usuarioObjeto;
    private UsuarioEntity usuarioObjetoInsercion;
    private boolean ingresar;
    private boolean actualizar;
    private boolean eliminar;
    private ArrayList<UsuarioEntity> list;
    private ArrayList<UsuarioEntity> listfiltro;

    @PostConstruct
    public void init() {

        consultaUsuarios();
        permisos();
    }

    public UsuarioBean() {
        usuarioObjeto = new UsuarioEntity();
        usuarioObjetoInsercion = new UsuarioEntity();
    }

    /**
     * Método con la cual cargo la lista de usuarios desde el boton
     */
    public void consultaUsuarios() {
        try {
            UsuarioLogic usuarioLogic = new UsuarioLogic();
            list = usuarioLogic.listaUsuarios();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<UsuarioEntity> getList() {
        return list;
    }

    public void setList(ArrayList<UsuarioEntity> list) {
        this.list = list;
    }

    public ArrayList<UsuarioEntity> getListfiltro() {
        return listfiltro;
    }

    public void setListfiltro(ArrayList<UsuarioEntity> listfiltro) {
        this.listfiltro = listfiltro;
    }

    public UsuarioEntity getUsuarioObjeto() {
        return usuarioObjeto;
    }

    public void setUsuarioObjeto(UsuarioEntity usuarioObjeto) {
        this.usuarioObjeto = usuarioObjeto;
    }

    public UsuarioEntity getUsuarioObjetoInsercion() {
        return usuarioObjetoInsercion;
    }

    public void setUsuarioObjetoInsercion(UsuarioEntity usuarioObjetoInsercion) {
        this.usuarioObjetoInsercion = usuarioObjetoInsercion;
    }

    /**
     * Funcion con la cual inserto un usuario en el sistema
     */
    public void ingresarUsuario() {
        try {

            UsuarioLogic logicaUsuario = new UsuarioLogic();
            UsuarioEntity usuarioInserto = logicaUsuario.ingresarUsuario(usuarioObjetoInsercion);
            FacesMessage msg = null;
            if (usuarioInserto != null) {
                MensajesJSF.muestraMensajes( "Usuario insertado correctamente: " + (usuarioObjetoInsercion.getNombre()), "Mensaje");
                adicionaUsuarioLista(usuarioInserto);
            } else {
                MensajesJSF.muestraMensajes( "Error al insertar el usuario: " + (usuarioObjetoInsercion.getNombre()), "Error");
            }
            RequestContext.getCurrentInstance().execute("PF('insertarUsuario').hide()");

        } catch (Error e) {
            e.printStackTrace();
        }
        nuevoObjetoUsuario();
        RequestContext conte=RequestContext.getCurrentInstance();
        conte.update("IngresarModal:insertarUsuarioModal");
    }

    /**
     * Funcion con la cual realizo la accion de actualizar un usuario
     */
    public void actualizarUsuario() {
        UsuarioLogic logicaUsusario = new UsuarioLogic();
        String valida = logicaUsusario.logicActualizarUsuario(usuarioObjeto);
        FacesMessage msg = null;
        if ("Ok".equalsIgnoreCase(valida)) {
            actualizaListaPorUsuario(usuarioObjeto);

        } else if ("Error".equalsIgnoreCase(valida)) {
            actualizaListaPorUsuario(usuarioObjeto);
        } else {

        }
        nuevoObjetoUsuario();
        RequestContext.getCurrentInstance().execute("PF('actualizarUsuario').hide()");
        
    }

    /**
     * Funcion con la cual actualizo el usuario en la lista en la cual se
     * muestra la tabla de la consulta
     *
     * @param objEntity
     */
    public void actualizaListaPorUsuario(UsuarioEntity objEntity) {
        try {
            ArrayList<UsuarioEntity> lista = new ArrayList<>();
            if (list != null) {
                for (UsuarioEntity item : list) {
                    if (objEntity.getIdUsuario() == item.getIdUsuario()) {
                        lista.add(objEntity);
                    } else {
                        lista.add(item);
                    }
                }
            }
            this.list = null;
            this.list = lista;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Funcion la cual adiciona un item a la lista de usuarios se utiliza cuando
     * yo inserte un usuario en el sistema
     *
     * @param objEntity
     */
    public void adicionaUsuarioLista(UsuarioEntity objEntity) {
        list.add(objEntity);
    }

    /**
     * Método que elimina visualmemte un usuario de la lista
     *
     * @param objEntity
     */
    public void eliminarUsuarioLista(UsuarioEntity objEntity) {
        Iterator itr = list.iterator();
        while (itr.hasNext()) {
            UsuarioEntity usu = (UsuarioEntity) itr.next();
            if (usu.getIdUsuario() == objEntity.getIdUsuario()) {
                itr.remove();
            }
        }
    }

    /**
     * Metodo que actualiza el estado del usuario selecionado a eliminado "E"
     */
    public void eliminarUsuario() {
        UsuarioLogic logicaUsusario = new UsuarioLogic();
        usuarioObjeto.setEstado("E");
        logicaUsusario.actualizarUsuario(usuarioObjeto);
        eliminarUsuarioLista(usuarioObjeto);
        usuarioObjeto = new UsuarioEntity();
        RequestContext.getCurrentInstance().execute("PF('actualizarUsuario').hide()");
        RequestContext.getCurrentInstance().execute("PF('confirmar').hide()");
        MensajesJSF.muestraMensajes( "Usuario eliminado correctamente: " + (usuarioObjeto.getNombre()), "Mensaje");
    }

    /**
     * Método que oculta el botón de ingresr
     */
    public void ocultaBoton() {
        ingresar = true;
        RequestContext.getCurrentInstance().execute("PF('botonI').hide()");
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
    
    public void nuevoObjetoUsuario(){
        usuarioObjeto=new UsuarioEntity();
        usuarioObjetoInsercion=new UsuarioEntity();
    }
    
    /**
     * Método que recoje el evento de la selecion de la tabla y obtiene el
     * objeto de la selección
     *
     * @param event
     */
    public void onRowSelect(SelectEvent event) {
        System.out.println("SEL: "+usuarioObjeto);
        usuarioObjeto = (UsuarioEntity) event.getObject();
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
