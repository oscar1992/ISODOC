/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.siscomputo.administracion.logic;

import co.com.siscomputo.endpoint.ProcesosEntity;
import co.com.siscomputo.utilidades.IurlWebService;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public class ProcesosLogic implements IurlWebService{

    private List procesos;



    public List getProcesos() {
        return procesos;
    }

    public void setProcesos(List procesos) {
        this.procesos = procesos;
    }
    /**
     * Método que permite traer la lista de procesos disponibles en el
     * sistema
     */
     public ArrayList<ProcesosEntity> listaProcesos() {
        ArrayList<ProcesosEntity> listaProc = new ArrayList<>();
        ArrayList<Object> listaObjeto;
        
        listaObjeto = (ArrayList<Object>) portUsuario().listaProcesos().getRetorna();
        for (Object obj : listaObjeto) {
            ProcesosEntity macros = (ProcesosEntity) obj;
            listaProc.add(macros);
        }
        return listaProc;
    }
    /**
     * Método que permite ingresar un proceso nuevo
     * @param proc
     * @return 
     */
    public  ProcesosEntity ingresaProceso(ProcesosEntity proc){
        
        ProcesosEntity procRta=null;
        try {
            procRta=portUsuario().ingresaProceso(proc);
        } catch (Exception e) {
            procRta=null;
            e.printStackTrace();
        }
        return procRta;
    }
    /**
     * Método que permite Actualizar un Proceso
     * @param procesosEntity
     * @return 
     */
    public String actualozarProceso(ProcesosEntity procesosEntity){
        
        String rta = "";
        try {
            if (portUsuario().actualizaProceso(procesosEntity) != null) {
                rta = "Ok";
            } else {
                rta = "Error";
            }
        } catch (Exception e) {
            e.printStackTrace();
            rta = "Exception";
        }
        return rta;
    }
    /**
     * Método que permite selecionar un proceso por ID
     * @param idProceso
     * @return 
     */
    public ProcesosEntity procesoPorId(int idProceso){
        
        return portUsuario().procesoPorID(idProceso);
    }
}
