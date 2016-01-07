/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.siscomputo.administracion.logic;

import co.com.siscomputo.endpoint.RolesEntity;
import co.com.siscomputo.endpoint.Usuario;
import co.com.siscomputo.endpoint.Usuario_Service;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author LENOVO
 */
public class RolesLogic {
    private Usuario_Service webService;
    private Usuario port;
    private List roles;
    
    /**
     * Funcion con la cual inicializo el service y el port de los WebServices
     */
    public void webService() {
        webService = new Usuario_Service();
        port = webService.getUsuarioPort();
    }

    public RolesLogic() {
        init();
    }
    
    public void init(){
        webService();
        roles=(List)port.listaRoles().getRetorna();
    }
    
    public List getRoles() {
        return roles;
    }

    public void setRoles(List roles) {
        this.roles = roles;
    }
    /**
     * Método que trae la lista de roles del sistema
     * @return 
     */
    public ArrayList<RolesEntity> listaRoles(){
        ArrayList<RolesEntity> lista=new ArrayList<>();
        ArrayList<Object> listaObjeto;
        webService();
        listaObjeto=(ArrayList<Object>)port.listaRoles().getRetorna();
        for(Object item:listaObjeto){
            RolesEntity rol=(RolesEntity)item;
            lista.add(rol);
        }
        return lista;
    }
    /**
     * Método que envia el rol para ser insertado por el webService
     * @param rol
     * @return 
     */
    public RolesEntity ingresarRol(RolesEntity rol){
        webService();
        RolesEntity rolRta=null;
        try{
            rolRta=port.ingresarRol(rol);
        }catch(Error e){
            e.printStackTrace();
        }
        return rolRta;
    }
    /**
     * Método que envia el rol para ser actualizado
     * @param rol
     * @return 
     */
    public String actualizarUsuario(RolesEntity rol){
        webService();
        String rta="";
        try {
            if(port.actualizarRol(rol)!=null){
                rta="Ok";
            }else{
                rta="Error";
            }            
        } catch (Exception e) {
            e.printStackTrace();
            rta="Exception";
        }
        return rta;
    }
    /**
     * Método que trae un rol filtrado por su ID
     * @param idRol
     * @return 
     */
    public RolesEntity rolPorId(int idRol){
        webService();
        RolesEntity rolRta=null;
        try{
            rolRta=port.rolPorId(idRol);
        }catch(Error e){
            e.printStackTrace();
        }
        return rolRta;
    }
}
