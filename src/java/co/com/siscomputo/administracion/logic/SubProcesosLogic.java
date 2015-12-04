/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.siscomputo.administracion.logic;

import co.com.siscomputo.endpoint.ProcesosEntity;
import co.com.siscomputo.endpoint.SubprocesoEntity;
import co.com.siscomputo.endpoint.Usuario;
import co.com.siscomputo.endpoint.Usuario_Service;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public class SubProcesosLogic {
    private Usuario_Service webService;
    private Usuario port;
    private List subProcesos;

    /**
     * Funcion con la cual inicializo el service y el port de los WebServices
     */
    public void webService() {
        webService = new Usuario_Service();
        port = webService.getUsuarioPort();
    }

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
        webService();
        listaObjeto=(ArrayList<Object>) port.listaSubProcesos().getRetorna();
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
        webService();
        SubprocesoEntity subRta=null;
        try {
            subRta=port.ingresaSubProceso(subproc);
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
        webService();
        String rta="";
        try {
            if(port.actualizaSubProceso(subproc)!=null){
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
        webService();
        return port.subProcesoPorID(idsubProceso);
    }
}
