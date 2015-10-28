/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.siscomputo.administracion.logic;

import co.com.siscomputo.endpoint.MenuModuloEntity;
import co.com.siscomputo.endpoint.ModuloEntity;
import co.com.siscomputo.endpoint.Usuario;
import co.com.siscomputo.endpoint.Usuario_Service;
import java.util.ArrayList;

/**
 *
 * @author LENOVO
 */
public class MenuLogic {
    private Usuario_Service webService;
    private Usuario port;
    
    
    /**
     * Funcion con la cual inicializo el service y el port de los WebServices
     */
    public void webService() {
        webService = new Usuario_Service();
        port = webService.getUsuarioPort();
    }

    
    /**
     * Funcion con la cual obtengo todos los modulos a los cuales el usuario
     * tiene acceso
     *
     * @param idUsuario int Identificador primario de la tabla de usuarios
     * @return Lista de modulos
     */
    public ArrayList<ModuloEntity> obtieneModulos(int idUsuario) {
        ArrayList<ModuloEntity> rta = new ArrayList<>();
        ArrayList<Object> listaObjetoModulo=null;
        try {
            webService();
            listaObjetoModulo=(ArrayList<Object>) port.listaModulos(idUsuario).getRetorna();
            for(Object item: listaObjetoModulo){
                ModuloEntity me=(ModuloEntity)item;
                rta.add(me);
            }
            

        } catch (Exception e) {
            e.printStackTrace();
        }
        return rta;
    }
    
    
    /**
     * Funcion la cual obtiene el menu de los permisos filtrados por usuario
     * @param idUsuario
     * @return 
     */
    
    public ArrayList<MenuModuloEntity> obtieneMenuPorUsuario(int idUsuario){
        ArrayList<MenuModuloEntity>rta=null;
        try {
            webService();
            rta=(ArrayList<MenuModuloEntity>) port.menuDatosporUsuario(idUsuario);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rta;
    }
}
