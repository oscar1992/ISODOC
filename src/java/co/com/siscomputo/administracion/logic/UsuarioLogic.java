/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.siscomputo.administracion.logic;

import co.com.siscomputo.endpoint.Usuario;
import co.com.siscomputo.endpoint.UsuarioEntity;
import co.com.siscomputo.endpoint.Usuario_Service;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author LENOVO
 */
public class UsuarioLogic {

    private Usuario_Service webService;
    private Usuario port;
    private List usuarios;

    public List getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List usuarios) {
        this.usuarios = usuarios;
    }

    /**
     * Funcion con la cual inicializo el service y el port de los WebServices
     */
    public void webService() {
        webService = new Usuario_Service();
        port = webService.getUsuarioPort();
    }

    public UsuarioLogic() {
        init();
    }

    @PostConstruct
    public void init() {
        webService();
        usuarios = (List) port.listaUsuarios().getRetorna();
    }

    /**
     * Metodo que permite actualizar un usuario a traves del webService
     *
     * @param usuario Usuario a actualizar
     */
    public void actualizarUsuario(UsuarioEntity usuario) {
        webService();
        if (port.actualizarUsuario(usuario) == null) {
            FacesMessage msg = new FacesMessage("Eliminación", "Usuario no Eliminado");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        } else {
            FacesMessage msg = new FacesMessage("Eliminación", "Usuario Eliminado Correctamente");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }

    /**
     * Funcion en la cual llama a el webService para el ingreso de un usuario
     *
     *
     * @param usuario
     * @return
     */
    public UsuarioEntity ingresarUsuario(UsuarioEntity usuario) {
        webService();
        UsuarioEntity usuarioRta = null;
        try {
            usuarioRta = port.ingresarUsuario(usuario);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return usuarioRta;
    }

    /**
     * Metodo que consulta la lista de Usuarios
     *
     * @return
     */
    public ArrayList<UsuarioEntity> listaUsuarios() {
        ArrayList<UsuarioEntity> lista = new ArrayList<>();
        ArrayList<Object> listao;
        webService();
        listao = (ArrayList<Object>) port.listaUsuarios().getRetorna();
        for (Object item : listao) {
            UsuarioEntity usu = (UsuarioEntity) item;

            lista.add(usu);
        }
        return lista;
    }

    /**
     * Metodo que permite actualizar un usuario a traves del webService
     *
     * @param usuario Usuario a actualizar
     * @return
     */
    public String logicActualizarUsuario(UsuarioEntity usuario) {
        webService();
        String rta = "";
        try {
            if (port.actualizarUsuario(usuario) == null) {
                rta = "Ok";
                FacesMessage msg = new FacesMessage("Actualización", "Usuario no Actualizado  ");
                FacesContext.getCurrentInstance().addMessage(null, msg);
            } else {
                rta = "Error";                
                FacesMessage msg = new FacesMessage("Actualización", "Usuario Actualizado Correctamente");
                FacesContext.getCurrentInstance().addMessage(null, msg);
            }
        } catch (Exception e) {
            e.printStackTrace();
            rta = "Exception";
        }
        return rta;
    }
    /**
     * Método que permite selecionar un usuario por ID
     * @param idusuario
     * @return 
     */
    public UsuarioEntity usuarioPorID(int idusuario) {
        webService();
        return port.usuarioPorId(idusuario);
    }
    
    /**
     * Método que trae una lista de las relaciones entre usuarios y procesos, filtradas por usuario y por acción
     * @return 
     */
    public ArrayList<UsuarioEntity> listaUsuarioMacroporcesoPorUsuarioAccion(int idUsuario, int idAccion, int tipo){
        webService();
        ArrayList<UsuarioEntity> listaaux=new ArrayList<>();
        ArrayList<Object> listaObjeto =(ArrayList<Object>) port.listaUsuarioMacroProcesosPorUsuarioAccion(idUsuario, idAccion, tipo).getRetorna();
        for(Object obj:listaObjeto){
            UsuarioEntity objectusuarioMacroproceso=(UsuarioEntity) obj;
            listaaux.add(objectusuarioMacroproceso);
        }
        return listaaux;
    }
}
