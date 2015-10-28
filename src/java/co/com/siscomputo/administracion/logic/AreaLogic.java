/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.siscomputo.administracion.logic;

import co.com.siscomputo.endpoint.AreaEntity;
import co.com.siscomputo.endpoint.Usuario;
import co.com.siscomputo.endpoint.Usuario_Service;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public class AreaLogic {
    private Usuario_Service webService;
    private Usuario port;
    private List areas;
    
    /**
     * Funcion con la cual inicializo el service y el port de los WebServices
     */
    public void webService() {
        webService = new Usuario_Service();
        port = webService.getUsuarioPort();
    }

    public AreaLogic() {
        init();
    }
    
    public void init(){
        webService();
        areas=(List)port.listaAreas().getRetorna();
    }

    public List getAreas() {
        return areas;
    }

    public void setAreas(List areas) {
        this.areas = areas;
    }
    /**
     * Método que trae la lista de Areas
     * @return 
     */
    public ArrayList<AreaEntity> listaAreas(){
        ArrayList<AreaEntity> lista=new ArrayList<>();
        ArrayList<Object> listaObjeto;
        webService();
        listaObjeto=(ArrayList<Object>)port.listaAreas().getRetorna();
        for(Object item:listaObjeto){
            AreaEntity area=(AreaEntity)item;
            lista.add(area);
        }
        return lista;
    }
    /**
     * Método que permite ingresar un area
     * @param area
     * @return 
     */
    public AreaEntity ingresarArea(AreaEntity area){
        webService();
        AreaEntity areaRta=null;
        try {
            areaRta=port.insertarArea(area);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return areaRta;
    }
    /**
     * Método que actualizae un área
     * @param area
     * @return 
     */
    public String actualizarArea(AreaEntity area){
        webService();
        String rta="";
        try {
            if(port.actualizarArea(area)!=null){
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
