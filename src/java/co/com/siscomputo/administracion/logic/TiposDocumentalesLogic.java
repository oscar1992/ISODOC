/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.siscomputo.administracion.logic;

import co.com.siscomputo.endpoint.TiposDocumentalesEntity;
import co.com.siscomputo.endpoint.Usuario;
import co.com.siscomputo.endpoint.Usuario_Service;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public class TiposDocumentalesLogic {
    private Usuario_Service webService;
    private Usuario port;
    private List TiposDocuemtales;
    
    /**
     * Funcion con la cual inicializo el service y el port de los WebServices
     */
    public void webService() {
        webService = new Usuario_Service();
        port = webService.getUsuarioPort();
    }

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
        webService();
        listaObjeto=(ArrayList<Object>) port.listaTipoDocuemtal().getRetorna();
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
        webService();
        TiposDocumentalesEntity tiposDrta=null;
        try {
            tiposDrta=port.insertarTiposDocumetales(tiposD);
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
        webService();
        String rta="";
        try {
            if(port.actualizarTipoDocumental(tiposD)!=null){
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
        webService();
        return port.tiposDocumetalesPorID(idTipos);
    }
}
