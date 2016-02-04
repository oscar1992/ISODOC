/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.siscomputo.administracion.logic;

import co.com.siscomputo.endpoint.RutasEntity;
import co.com.siscomputo.utilidades.IurlWebService;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public class RutasLogic implements IurlWebService{
    private List rutas;

    public List getRutas() {
        return rutas;
    }

    public void setRutas(List rutas) {
        this.rutas = rutas;
    }
    /**
     * Método que trae una lista de rutas
     * @return 
     */
    public ArrayList<RutasEntity> listaRutas(){
        ArrayList<RutasEntity> lista=new ArrayList<>();
        ArrayList<Object> listaObjeto;
        listaObjeto=(ArrayList<Object>) portAdministracion().listaRutas().getRetorna();
        for(Object item:listaObjeto){
            RutasEntity ruta=(RutasEntity) item;
            lista.add(ruta);
        }
        return lista;
    }
    /**
     * Método que permite ingresar una ruta nueva
     * @param ruta
     * @return 
     */
    public RutasEntity ingresaRuta(RutasEntity ruta){
        RutasEntity rutRta=null;
        try {
            rutRta=portAdministracion().insertarRutas(ruta);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rutRta;
    }
    /**
     * Método que permite actializar una ruta
     * @param ruta
     * @return 
     */
    public String actualizarRuta(RutasEntity ruta){
        String rta="";
        try {
            if(portAdministracion().actulizarRutas(ruta)!=null){
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
    
    public RutasEntity rutasPorTipo(String tipo){
        RutasEntity rutRta=null;
        try {
            rutRta=portAdministracion().rutaPorTipo(tipo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rutRta;
    }
}
