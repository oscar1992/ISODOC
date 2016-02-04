/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.siscomputo.utilidades;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author LENOVO
 */
public class SingletonDirecciones {
    private String usuario;
    private String gestion;
    private String administracion;
    private String proveedrores;
    private static SingletonDirecciones direcciones;
    
    public static SingletonDirecciones getDirecciones(){
        if(direcciones==null){
            direcciones=new SingletonDirecciones();
        }
        return direcciones;
    }

    public SingletonDirecciones(){
        try {
            Context initCtx = new InitialContext();
            usuario = (String) initCtx.lookup("java:comp/env/usuario");
            gestion = (String) initCtx.lookup("java:comp/env/gestion");
            administracion = (String) initCtx.lookup("java:comp/env/administracion");
            proveedrores = (String) initCtx.lookup("java:comp/env/proveedores");            
            System.out.println("usu: "+usuario);
            System.out.println("usu: "+gestion);
            System.out.println("usu: "+administracion);
            System.out.println("usu: "+proveedrores);
        } catch (NamingException namingException) {
            System.out.println("ERROR leyendo la url del endpoint");
            namingException.printStackTrace();
        }
        
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getGestion() {
        return gestion;
    }

    public void setGestion(String gestion) {
        this.gestion = gestion;
    }

    public String getAdministracion() {
        return administracion;
    }

    public void setAdministracion(String administracion) {
        this.administracion = administracion;
    }

    
    
    
}
