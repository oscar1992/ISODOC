/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.siscomputo.utilidades;

import co.com.siscomputo.endpoint.Administacion;
import co.com.siscomputo.endpoint.Administacion_Service;
import co.com.siscomputo.endpoint.GestionDocumental;
import co.com.siscomputo.endpoint.GestionDocumental_Service;
import co.com.siscomputo.endpoint.Proveedores;
import co.com.siscomputo.endpoint.Proveedores_Service;
import co.com.siscomputo.endpoint.Usuario;
import co.com.siscomputo.endpoint.Usuario_Service;
import java.net.URL;

/**
 *Funcion que consulta el port del servicio web de usuarios
 * @author Oscar
 */

public interface IurlWebService {
    
    /**
     * Funcion que consulta el port del webservice de Usuario
     * @return 
     */
    default Usuario portUsuario(){
        Usuario port = null;
                
        try {
            SingletonDirecciones singl = SingletonDirecciones.getDirecciones();
            String url = singl.getUsuario();
            Usuario_Service webService= new Usuario_Service(new URL(url));
            port = webService.getUsuarioPort();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return port;
    }
    
    default Administacion portAdministracion(){
        Administacion port=null;
        try {
            SingletonDirecciones singl= SingletonDirecciones.getDirecciones();
            String url=singl.getAdministracion();
            Administacion_Service webService=new Administacion_Service(new URL(url));
            port=webService.getAdministacionPort();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return port;
    }
    
    default GestionDocumental portGestion(){
        GestionDocumental port=null;
        try {
            SingletonDirecciones singl= SingletonDirecciones.getDirecciones();
            String url=singl.getGestion();
            GestionDocumental_Service webService=new GestionDocumental_Service(new URL(url));
            port=webService.getGestionDocumentalPort();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return port;
    }
    
    default Proveedores portProveedores(){
        Proveedores port=null;
        try {
            SingletonDirecciones singl= SingletonDirecciones.getDirecciones();
            String url=singl.getProveedrores();
            Proveedores_Service webService=new Proveedores_Service(new URL(url));
            port=webService.getProveedoresPort();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return port;
    }
}
