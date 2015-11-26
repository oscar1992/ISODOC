/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.siscomputo.administracion.logic;

import co.com.siscomputo.endpoint.Administacion;
import co.com.siscomputo.endpoint.Administacion_Service;
import co.com.siscomputo.endpoint.MetodoRecuperacionEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public class MetodoRecuperacionLogic {
    private Administacion_Service webService;
    private Administacion port;
    private List metodosRecuperacion;
    
    /**
     * Funcion con la cual inicializo el service y el port de los WebServices
     */
    public void webService() {
        webService = new Administacion_Service();
        port = webService.getAdministacionPort();
    }

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
        webService();
        ArrayList<MetodoRecuperacionEntity> listaaux=new ArrayList<>();
        ArrayList<Object> listaObjeto =(ArrayList<Object>) port.listaMetodoRecuperacion().getRetorna();
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
        webService();
        MetodoRecuperacionEntity dispoRta=null;        
        try {
            dispoRta = port.insertarMetodoRecuperacion(metodo);
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
        webService();
        String rta="";
        try {            
            if (port.actualizarMetodoRecuperacion(metodo) != null) {
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
