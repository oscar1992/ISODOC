/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.siscomputo.administracion.logic;

import co.com.siscomputo.endpoint.ProcesosEntity;
import co.com.siscomputo.endpoint.Usuario;
import co.com.siscomputo.endpoint.Usuario_Service;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public class ProcesosLogic {
    private Usuario_Service webService;
    private Usuario port;
    private List procesos;

    /**
     * Funcion con la cual inicializo el service y el port de los WebServices
     */
    public void webService() {
        webService = new Usuario_Service();
        port = webService.getUsuarioPort();
    }

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
        webService();
        listaObjeto = (ArrayList<Object>) port.listaProcesos().getRetorna();
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
        webService();
        ProcesosEntity procRta=null;
        try {
            procRta=port.ingresaProceso(proc);
        } catch (Exception e) {
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
        webService();
        String rta = "";
        try {
            if (port.actualizaProceso(procesosEntity) != null) {
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
        webService();
        return port.procesoPorID(idProceso);
    }
}
