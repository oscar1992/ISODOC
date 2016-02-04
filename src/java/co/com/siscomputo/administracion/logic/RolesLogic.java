/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.siscomputo.administracion.logic;

import co.com.siscomputo.endpoint.RolesEntity;
import co.com.siscomputo.utilidades.IurlWebService;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author LENOVO
 */
public class RolesLogic implements IurlWebService{

    private List roles;
    


    public RolesLogic() {
        init();
    }
    
    public void init(){
        
        roles=(List)portUsuario().listaRoles().getRetorna();
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
        
        listaObjeto=(ArrayList<Object>)portUsuario().listaRoles().getRetorna();
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
        
        RolesEntity rolRta=null;
        try{
            rolRta=portUsuario().ingresarRol(rol);
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
        
        String rta="";
        try {
            if(portUsuario().actualizarRol(rol)!=null){
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
        
        RolesEntity rolRta=null;
        try{
            rolRta=portUsuario().rolPorId(idRol);
        }catch(Error e){
            e.printStackTrace();
        }
        return rolRta;
    }
}
