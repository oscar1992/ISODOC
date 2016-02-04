/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.siscomputo.administracion.logic;

import co.com.siscomputo.endpoint.MacroprocesosEntity;
import co.com.siscomputo.utilidades.IurlWebService;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public class MacroProcesosLogic implements IurlWebService{

    private List MacroProcesos;



    public List getMacroProcesos() {
        return MacroProcesos;
    }

    public void setMacroProcesos(List MacroProcesos) {
        this.MacroProcesos = MacroProcesos;
    }

    public MacroProcesosLogic() {
    }

    /**
     * Método que permite traer la lista de macroprocesos disponibles en el
     * sistema
     *
     * @return
     */
    public ArrayList<MacroprocesosEntity> listaMacroprocesos() {
        ArrayList<MacroprocesosEntity> listaMacro = new ArrayList<>();
        ArrayList<Object> listaObjeto;
        
        listaObjeto = (ArrayList<Object>) portUsuario().listaMacroProcesos().getRetorna();
        for (Object obj : listaObjeto) {
            MacroprocesosEntity macros = (MacroprocesosEntity) obj;
            listaMacro.add(macros);
        }
        return listaMacro;
    }

    /**
     * Método que permite ingresar un macroproceso nuevo
     *
     * @param macro
     * @return
     */
    public MacroprocesosEntity ingresaMacroproceso(MacroprocesosEntity macro) {
        
        MacroprocesosEntity macroRta = null;
        try {
            macroRta = portUsuario().ingresaMacroProceso(macro);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return macroRta;
    }
    /**
     * Método que permite Actualizar un MacroProceso
     * @param macro
     * @return 
     */
    public String actualizarMacroProceso(MacroprocesosEntity macro) {
        
        String rta = "";
        try {
            if (portUsuario().actualizaMacroProceso(macro) != null) {
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
     * Método que permite selecionar un macro proceso por su ID
     * @param idMacrop
     * @return 
     */
    public MacroprocesosEntity macroProcesoPorId(int idMacrop){
        
        return portUsuario().macroPorId(idMacrop);
    }
}
