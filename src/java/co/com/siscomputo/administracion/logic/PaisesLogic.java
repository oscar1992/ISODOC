/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.siscomputo.administracion.logic;

import co.com.siscomputo.endpoint.PaisEntity;
import co.com.siscomputo.utilidades.IurlWebService;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public class PaisesLogic implements IurlWebService{

    private List paises;
    


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
        
        listaobjeto=(ArrayList<Object>)portUsuario().listaPais().getRetorna();
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
        
        PaisEntity paisRta=null;
        try {
            paisRta=portUsuario().insertarPais(paisEntity);
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
        
        String rta="";
        try {
            if(portUsuario().actualizarPais(paisEntity)!=null){
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
     * Método que permite selecionar un país por su ID
     * @param idPais
     * @return 
     */
    public PaisEntity paisPorId(int idPais){
        
        return portUsuario().paisPorId(idPais);
    }
}
