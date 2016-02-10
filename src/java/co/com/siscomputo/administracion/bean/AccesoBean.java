/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.siscomputo.administracion.bean;

import co.com.siscomputo.administracion.logic.LoginLogic;
import co.com.siscomputo.administracion.logic.MenuLogic;
import co.com.siscomputo.administracion.logic.UsuarioLogic;
import co.com.siscomputo.endpoint.MenuModuloEntity;
import co.com.siscomputo.endpoint.ObjetoLogin;
import co.com.siscomputo.endpoint.UsuarioEntity;
import co.com.siscomputo.utilidades.MensajesJSF;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author LENOVO
 */
@ManagedBean(name = "Acceso")
@ViewScoped
public class AccesoBean {

    private String nombreUsuario;
    private String claveUsuario;
    private UsuarioEntity objetoUsuario;

    private ObjetoLogin objetoLogin;

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombre) {
        this.nombreUsuario = nombre;
    }

    public String getClave() {
        return claveUsuario;
    }

    public void setClave(String clave) {
        this.claveUsuario = clave;
    }

    public ObjetoLogin getObjetoLogin() {
        return objetoLogin;
    }

    public void setObjetoLogin(ObjetoLogin objetoLogin) {
        this.objetoLogin = objetoLogin;
    }
     
    public void recupera(){       
        objetoUsuario = (UsuarioEntity) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
        objetoUsuario.setClave("");
    }
    /**
     * Métedo que evalua si el usuario tiene acceso al sistema
     *
     * @return
     */
    public String ingresoUsuario() {
        String url = "";
        LoginLogic loginLogic = new LoginLogic();
        try {
             String validaIngreso = loginLogic.ingresar(this.nombreUsuario, this.claveUsuario);
            if ("Ok".equalsIgnoreCase(validaIngreso)) {
                objetoLogin = loginLogic.getObjetoLogin();
                if ("InicioNuevo".equalsIgnoreCase(objetoLogin.getTrazaRespuesta())) {
                    UsuarioLogic usuarioLogic=new UsuarioLogic();
                    objetoUsuario = usuarioLogic.usuarioPorID(objetoLogin.getIdUsuario());                    
                    FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", objetoUsuario);
                    url = "/inicio/primerIngreso";
                } else {
                    if (objetoLogin.isAcceso()) {
                        if ("Ok".equalsIgnoreCase(loginLogic.datosUsuario(objetoLogin.getIdUsuario()))) {
                            objetoUsuario = loginLogic.getUsuarioObject();
                        }
                        url = "/inicio/principal";

                        MensajesJSF.muestraMensajes("Bienvenido", "Mensaje");

                        MenuLogic menuLogic = new MenuLogic();
                        ArrayList<MenuModuloEntity> menu = menuLogic.obtieneMenuPorUsuario(objetoLogin.getIdUsuario());
                        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("idUsuario", objetoLogin.getIdUsuario());
                        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("menu", menu);                        
                        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", objetoUsuario);
                        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("idModulo", -1);
                    } else {
                        MensajesJSF.muestraMensajes("Usuario/Clave incorrecto", "Error");
                        url = "index";
                    }
                }

            } else {
                MensajesJSF.muestraMensajes("Error de Conexión con el WebService", "Error");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return url;
    }

    /**
     * Método que cierra la sesión actual
     */    

    public UsuarioEntity getObjetoUsuario() {
        return objetoUsuario;
    }

    public void setObjetoUsuario(UsuarioEntity objetoUsuario) {
        this.objetoUsuario = objetoUsuario;
    }
    /**
     * M+etodo que cambia la contrasela la primera vez
     */
    public String contrasenaNueva(){
        UsuarioLogic usuarioLogic=new UsuarioLogic();
        usuarioLogic.actualizarUsuario(objetoUsuario);
        return "/ISODOC/index";
    }
}
