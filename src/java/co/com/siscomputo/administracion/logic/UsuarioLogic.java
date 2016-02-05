/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.siscomputo.administracion.logic;

import co.com.siscomputo.endpoint.UsuarioEntity;
import co.com.siscomputo.utilidades.IurlWebService;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author LENOVO
 */
public class UsuarioLogic implements IurlWebService{


    private List usuarios;

    public List getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List usuarios) {
        this.usuarios = usuarios;
    }

   

    public UsuarioLogic() {
        init();
    }

    @PostConstruct
    public void init() {
        
        usuarios = (List) portUsuario().listaUsuarios().getRetorna();
    }

    /**
     * Metodo que permite actualizar un usuario a traves del webService
     *
     * @param usuario Usuario a actualizar
     */
    public void actualizarUsuario(UsuarioEntity usuario) {
        
        if (portUsuario().actualizarUsuario(usuario) == null) {
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
        
        UsuarioEntity usuarioRta = null;
        try {
            usuarioRta = portUsuario().ingresarUsuario(usuario);
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
        
        listao = (ArrayList<Object>) portUsuario().listaUsuarios().getRetorna();
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
        
        String rta = "";
        try {
            if (portUsuario().actualizarUsuario(usuario) == null) {
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
        
        return portUsuario().usuarioPorId(idusuario);
    }
   
    /**
     * Método que trae una lista de usuarios asociados a una acción
     * @param idAccion 
     */
    public ArrayList<UsuarioEntity> usuariosPorAccion(int idAccion){
        
        ArrayList<UsuarioEntity>listaaux=new ArrayList<>();
        ArrayList<Object>listaObjeto=(ArrayList<Object>) portUsuario().listaUsuariosPorAccion(idAccion).getRetorna();
        for(Object obj:listaObjeto){
            UsuarioEntity usuarioEntity=(UsuarioEntity)obj;
            listaaux.add(usuarioEntity);
        }
        return listaaux;
    }
    /**
     * Método que retorna una lista de usuarios por id de grupo
     * @param idGrupo
     * @return 
     */
    public ArrayList<UsuarioEntity> usuariosPorGrupo(int idGrupo){
        
        ArrayList<UsuarioEntity>listaaux=new ArrayList<>();
        ArrayList<Object>listaObjeto=(ArrayList<Object>) portUsuario().usuariosPorGrupo(idGrupo).getRetorna();
        for(Object obj:listaObjeto){
            UsuarioEntity usuarioEntity=(UsuarioEntity)obj;
            listaaux.add(usuarioEntity);
        }
        return listaaux;
    }
}
