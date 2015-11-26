/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.siscomputo.administracion.logic;

import co.com.siscomputo.endpoint.Administacion;
import co.com.siscomputo.endpoint.Administacion_Service;
import co.com.siscomputo.endpoint.DisposicionesEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public class DisposicionesLogic {
    private Administacion_Service webService;
    private Administacion port;
    private List disposiciones;
    
    /**
     * Funcion con la cual inicializo el service y el port de los WebServices
     */
    public void webService() {
        webService = new Administacion_Service();
        port = webService.getAdministacionPort();
    }

    public List getDisposiciones() {
        return disposiciones;
    }

    public void setDisposiciones(List disposiciones) {
        this.disposiciones = disposiciones;
    }
    /**
     * Método que trae la lista de disposiciones disponibles en el sistema
     * @return 
     */
    public ArrayList<DisposicionesEntity> listaDisposiciones(){
        ArrayList<DisposicionesEntity> lista=new ArrayList<>();
        ArrayList<Object> listaObjeto=new ArrayList<>();
        webService();
        listaObjeto=(ArrayList<Object>) port.listaDisposiciones().getRetorna();
        for(Object obj:listaObjeto){
            DisposicionesEntity disposicion=(DisposicionesEntity) obj;
            lista.add(disposicion);
        }
        return lista;
    }
    /**
     * Método que envía una nueva disposición opara ser guardada
     * @param disposicion
     * @return 
     */
    public DisposicionesEntity ingresaDisposicion(DisposicionesEntity disposicion){
        webService();
        DisposicionesEntity dispoRta=null;        
        try {
            dispoRta = port.insertarDisposicion(disposicion);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dispoRta;
    }
    /**
     * Método que permite actualizar una disposición
     * @param disposicion
     * @return 
     */
    public String actualizarDisposicion(DisposicionesEntity disposicion){
        webService();
        String rta="";
        try {            
            if (port.actualizarDisposicion(disposicion) != null) {
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
