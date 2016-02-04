/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.siscomputo.administracion.logic;

import co.com.siscomputo.endpoint.TiposDocumentalesEntity;
import co.com.siscomputo.utilidades.IurlWebService;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public class TiposDocumentalesLogic implements IurlWebService{

    private List TiposDocuemtales;
    
  

    public List getTiposDocuemtales() {
        return TiposDocuemtales;
    }

    public void setTiposDocuemtales(List TiposDocuemtales) {
        this.TiposDocuemtales = TiposDocuemtales;
    }
    /**
     * Método que trate la lista de los Tipos Documentales disponibles
     * @return 
     */
    public ArrayList<TiposDocumentalesEntity> listaTiposDocumentales(){
        ArrayList<TiposDocumentalesEntity>lista=new ArrayList<>();
        ArrayList<Object> listaObjeto;
        
        listaObjeto=(ArrayList<Object>) portUsuario().listaTipoDocuemtal().getRetorna();
        for(Object obj:listaObjeto){
            TiposDocumentalesEntity tiposd=(TiposDocumentalesEntity) obj;
            lista.add(tiposd);
        }
        return lista;
    }
    /**
     * Método que permite actualizar una tipo documental
     * @param tiposD
     * @return 
     */
    public TiposDocumentalesEntity ingresaTipoDocumental(TiposDocumentalesEntity tiposD){
        
        TiposDocumentalesEntity tiposDrta=null;
        try {
            tiposDrta=portUsuario().insertarTiposDocumetales(tiposD);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tiposDrta;
    }
    /**
     * Método que actualiza un Tipo documental
     * @param tiposD
     * @return 
     */
    public String actualizarTiposDocumental(TiposDocumentalesEntity tiposD){
        
        String rta="";
        try {
            if(portUsuario().actualizarTipoDocumental(tiposD)!=null){
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
     * Método que devuelve una plantilla seleccionada por su ID
     * @param idTipos 
     * @return  
     */
    public TiposDocumentalesEntity TipoDocumentalPorId(int idTipos){
        
        return portUsuario().tiposDocumetalesPorID(idTipos);
    }
}
