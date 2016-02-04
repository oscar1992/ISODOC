/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.siscomputo.administracion.logic;

import co.com.siscomputo.endpoint.AreaEntity;
import co.com.siscomputo.utilidades.IurlWebService;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public class AreaLogic implements IurlWebService{

    private List areas;
    


    public AreaLogic() {
        init();
    }
    
    public void init(){
        
        areas=(List)portUsuario().listaAreas().getRetorna();
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
        
        listaObjeto=(ArrayList<Object>)portUsuario().listaAreas().getRetorna();
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
        
        AreaEntity areaRta=null;
        try {
            areaRta=portUsuario().insertarArea(area);
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
        
        String rta="";
        try {
            if(portUsuario().actualizarArea(area)!=null){
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
