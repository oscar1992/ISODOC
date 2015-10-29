/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.siscomputo.administracion.logic;

import co.com.siscomputo.endpoint.CiudadEntity;
import co.com.siscomputo.endpoint.Usuario;
import co.com.siscomputo.endpoint.Usuario_Service;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public class CiudadLogic {
    private Usuario_Service webService;
    private Usuario port;
    private List ciudades;
    
    
    /**
     * Funcion con la cual inicializo el service y el port de los WebServices
     */
    public void webService() {
        webService = new Usuario_Service();
        port = webService.getUsuarioPort();
    }

    public List getCiudades() {
        return ciudades;
    }

    public void setCiudades(List ciudades) {
        this.ciudades = ciudades;
    }
    /**
     * Método que trae la lista de Ciudades
     * @return 
     */
    public ArrayList<CiudadEntity>listaCiudades(){
        ArrayList<CiudadEntity> lista=new ArrayList<>();
        ArrayList<Object> listaObjeto;
        webService();
        listaObjeto=(ArrayList<Object>) port.listaCiudades().getRetorna();
        for(Object item:listaObjeto){
            CiudadEntity ciudad=(CiudadEntity)item;
            lista.add(ciudad);
        }
        return lista;
    }
    /**
     * Método que permite ingresar una Sede
     * @param ciudad
     * @return 
     */
    public CiudadEntity ingresaCiudad(CiudadEntity ciudad){
        webService();
        CiudadEntity ciudadRta=null;
        try {
            ciudadRta=port.insertarCiudad(ciudad);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ciudadRta;
    }
    /**
     * Método que actualizae una ciudad
     * @param ciudad
     * @return 
     */
    public String actualizarCiudad(CiudadEntity ciudad){
        webService();
        String rta="";
        try {
            if(port.actualizarCiudad(ciudad)!=null){
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
}
