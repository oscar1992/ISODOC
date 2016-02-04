/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.siscomputo.administracion.logic;

import co.com.siscomputo.endpoint.ObjetoLogin;
import co.com.siscomputo.endpoint.UsuarioEntity;
import co.com.siscomputo.utilidades.IurlWebService;

/**
 *
 * @author LENOVO
 */
public class LoginLogic implements IurlWebService{
    private ObjetoLogin objetoLogin;
    private UsuarioEntity usuarioObject;

    public UsuarioEntity getUsuarioObject() {
        return usuarioObject;
    }

    public void setUsuarioObject(UsuarioEntity usuarioObject) {
        this.usuarioObject = usuarioObject;
    }
    
    
    
    public ObjetoLogin getObjetoLogin() {
        return objetoLogin;
    }

    public void setObjetoLogin(ObjetoLogin objetoLogin) {
        this.objetoLogin = objetoLogin;
    }
    


    
    /**
     * Método que realiza el llamado al Webservice del Login
     * @param usuarioNombre
     * @param clave
     * @return 
     */
    public String ingresar(String usuarioNombre, String clave){
        String rta="";
        try {
            
            objetoLogin=portUsuario().login(usuarioNombre, clave);
            rta="Ok";
        } catch (Exception e) {
            e.printStackTrace();
            rta="Error "+e;
        }
        return rta;
    }
    /**
     * Método que trae los datos de usuario que ingresa
     * @param idUsuario
     * @return 
     */
    public String datosUsuario(int idUsuario){
        String rta="";
        try {
            usuarioObject=portUsuario().usuarioPorId(idUsuario);
            rta="Ok";
        } catch (Exception e) {
            rta="Error "+e;
        }
        return rta;
    }
    
}
