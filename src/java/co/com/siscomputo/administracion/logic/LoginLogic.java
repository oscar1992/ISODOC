/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.siscomputo.administracion.logic;

import co.com.siscomputo.endpoint.ObjetoLogin;
import co.com.siscomputo.endpoint.Usuario;
import co.com.siscomputo.endpoint.UsuarioEntity;
import co.com.siscomputo.endpoint.Usuario_Service;

/**
 *
 * @author LENOVO
 */
public class LoginLogic {
    private Usuario_Service webService;
    private Usuario port;
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
     * Funcion con la cual inicializo el service y el port de los WebServices
     */
    public void webService() {
        webService = new Usuario_Service();
        port = webService.getUsuarioPort();
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
            webService();
            objetoLogin=port.login(usuarioNombre, clave);
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
            webService();
            usuarioObject=port.usuarioPorId(idUsuario);
            rta="Ok";
        } catch (Exception e) {
            rta="Error "+e;
        }
        return rta;
    }
    
}
