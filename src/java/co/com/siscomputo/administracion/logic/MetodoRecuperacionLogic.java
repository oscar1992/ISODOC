/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.siscomputo.administracion.logic;

import co.com.siscomputo.endpoint.MetodoRecuperacionEntity;
import co.com.siscomputo.utilidades.IurlWebService;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public class MetodoRecuperacionLogic implements IurlWebService{

    private List metodosRecuperacion;
    


    public List getMetodosRecuperacion() {
        return metodosRecuperacion;
    }

    public void setMetodosRecuperacion(List metodosRecuperacion) {
        this.metodosRecuperacion = metodosRecuperacion;
    }
    /**
     * Método que trae una lista de métodos de recuperación
     * @return 
     */
    public ArrayList<MetodoRecuperacionEntity> listaMetodosRecuperacion(){
       
        ArrayList<MetodoRecuperacionEntity> listaaux=new ArrayList<>();
        ArrayList<Object> listaObjeto =(ArrayList<Object>) portAdministracion().listaMetodoRecuperacion().getRetorna();
        for(Object obj:listaObjeto){
            MetodoRecuperacionEntity metodoRecuperacionEntity=(MetodoRecuperacionEntity) obj;
            listaaux.add(metodoRecuperacionEntity);
        }
        return listaaux;
    }
    /**
     * Método que permite ingresar un método de recuperación nuevo
     * @param metodo
     * @return 
     */
    public MetodoRecuperacionEntity inserttarMetodoRecuperaciom(MetodoRecuperacionEntity metodo){
       
        MetodoRecuperacionEntity dispoRta=null;        
        try {
            dispoRta = portAdministracion().insertarMetodoRecuperacion(metodo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dispoRta;
    }
    /**
     * Método que permite actualizar un método de recuperación
     * @param metodo
     * @return 
     */
    public String actualizarMetodoRecuperacion(MetodoRecuperacionEntity metodo){
       
        String rta="";
        try {            
            if (portAdministracion().actualizarMetodoRecuperacion(metodo) != null) {
                rta = "Ok";
            } else {
                rta = "Error";
            }
        } catch (Exception e) {
            rta="Error";
            e.printStackTrace();            
        }
        return rta;
    }
}
