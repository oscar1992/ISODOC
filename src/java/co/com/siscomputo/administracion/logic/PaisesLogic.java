/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.siscomputo.administracion.logic;

import co.com.siscomputo.endpoint.EmpresaEntity;
import co.com.siscomputo.endpoint.PaisEntity;
import co.com.siscomputo.endpoint.Usuario;
import co.com.siscomputo.endpoint.Usuario_Service;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public class PaisesLogic {
    private Usuario_Service webService;
    private Usuario port;
    private List paises;
    
    /**
     * Funcion con la cual inicializo el service y el port de los WebServices
     */
    public void webService() {
        webService = new Usuario_Service();
        port = webService.getUsuarioPort();
    }

    public List getPaises() {
        return paises;
    }

    public void setPaises(List paises) {
        this.paises = paises;
    }
    /**
     * Método que trae la lista de Paises
     * @return 
     */
    public ArrayList<PaisEntity> listaPaises(){
        ArrayList<PaisEntity> lista=new ArrayList<>();
        ArrayList<Object> listaobjeto;
        webService();
        listaobjeto=(ArrayList<Object>)port.listaPais().getRetorna();
        for(Object item:listaobjeto){
            PaisEntity pais=(PaisEntity)item;
            lista.add(pais);
        }
        return lista;
    }
    /**
     * Método que permite ingresar un Pais
     * @param paisEntity
     * @return 
     */
    public PaisEntity ingresaPais(PaisEntity paisEntity){
        webService();
        PaisEntity paisRta=null;
        try {
            paisRta=port.insertarPais(paisEntity);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return paisRta;
    }
    /**
     * Método que actualizae un País     
     * @return 
     */
    public String actualizarPais(PaisEntity paisEntity){
        webService();
        String rta="";
        try {
            if(port.actualizarPais(paisEntity)!=null){
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
    
    public PaisEntity paisPorId(int idPais){
        webService();
        return port.paisPorId(idPais);
    }
}
