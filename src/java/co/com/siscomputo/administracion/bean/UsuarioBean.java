/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.siscomputo.administracion.bean;

import co.com.siscomputo.administracion.logic.UsuarioLogic;
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

/**
 *
 * @author LENOVO
 */
@ManagedBean(name = "Usuario")
@ViewScoped
public class UsuarioBean implements Serializable {

    private UsuarioEntity usuarioObjeto;
    private boolean ingresar = false;
    private ArrayList<UsuarioEntity> list;
    private ArrayList<UsuarioEntity> listfiltro;

    @PostConstruct
    public void init() {
        consultaUsuarios();
    }

    public UsuarioBean() {
        usuarioObjeto=new UsuarioEntity();
    }
    
    
    /**
     * Método con la cual cargo la lista de usuarios desde el boton
     */
    public void consultaUsuarios() {
        try {
            UsuarioLogic usuarioLogic=new UsuarioLogic();
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

    /**
     * Funcion con la cual inserto un usuario en el sistema
     */
    public void ingresarUsuario() {
        try {

            UsuarioLogic logicaUsuario = new UsuarioLogic();
            UsuarioEntity usuarioInserto = logicaUsuario.ingresarUsuario(usuarioObjeto);
            FacesMessage msg = null;
            if (usuarioInserto != null) {
                msg = new FacesMessage("", "Usuario insertado correctamente: " + (usuarioObjeto.getNombre()));
                adicionaUsuarioLista(usuarioInserto);
            } else {
                msg = new FacesMessage("", "Error al insertar el usuario: " + (usuarioObjeto.getNombre()));
            }
            RequestContext.getCurrentInstance().execute("PF('insertarUsuario').hide()");

        } catch (Error e) {
            e.printStackTrace();
        }
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
        usuarioObjeto=new UsuarioEntity();
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
        usuarioObjeto=new UsuarioEntity();
        RequestContext.getCurrentInstance().execute("PF('eliminarUsuario').hide()");
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

    /**
     * Método que recoje el evento de la selecion de la tabla y obtiene el
     * objeto de la selección
     *
     * @param event
     */
    public void onRowSelect(SelectEvent event) {        
        usuarioObjeto = (UsuarioEntity) event.getObject();
    }
}
