/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.siscomputo.administracion.logic;

import co.com.siscomputo.endpoint.SubprocesoEntity;
import co.com.siscomputo.utilidades.IurlWebService;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public class SubProcesosLogic implements IurlWebService{

    private List subProcesos;



    public List getSubProcesos() {
        return subProcesos;
    }

    public void setSubProcesos(List subProcesos) {
        this.subProcesos = subProcesos;
    }
    /**
     * Método que permite traer la lista de Subprocesos disponibles en el
     * sistema
     * @return 
     */
    public ArrayList<SubprocesoEntity> listaSubprocesos(){
        ArrayList<SubprocesoEntity>listaSub= new ArrayList<>();
        ArrayList<Object> listaObjeto;
        
        listaObjeto=(ArrayList<Object>) portUsuario().listaSubProcesos().getRetorna();
        for(Object obj:listaObjeto){
            SubprocesoEntity subProceso=(SubprocesoEntity)obj;
            listaSub.add(subProceso);
        }
        return listaSub;
    }
    /**
     * Método que permite ingrear un subproceso nuevo
     * @param subproc
     * @return 
     */
    public SubprocesoEntity ingresaProceso(SubprocesoEntity subproc){
        
        SubprocesoEntity subRta=null;
        try {
            subRta=portUsuario().ingresaSubProceso(subproc);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return subRta;
    }
    /**
     * Método que permite Actualizar un Subproceso
     * @param subproc
     * @return 
     */
    public String actualizarSubproceso(SubprocesoEntity subproc){
        
        String rta="";
        try {
            if(portUsuario().actualizaSubProceso(subproc)!=null){
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
     * Método que permite selecionar un proceso por ID
     * @param idProceso
     * @return 
     */
    public SubprocesoEntity subProcesoPorId(int idsubProceso){
        
        return portUsuario().subProcesoPorID(idsubProceso);
    }
}
