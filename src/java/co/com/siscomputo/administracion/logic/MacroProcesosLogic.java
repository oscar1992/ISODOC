/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.siscomputo.administracion.logic;

import co.com.siscomputo.endpoint.MacroprocesosEntity;
import co.com.siscomputo.endpoint.Usuario;
import co.com.siscomputo.endpoint.Usuario_Service;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public class MacroProcesosLogic {

    private Usuario_Service webService;
    private Usuario port;
    private List MacroProcesos;

    /**
     * Funcion con la cual inicializo el service y el port de los WebServices
     */
    public void webService() {
        webService = new Usuario_Service();
        port = webService.getUsuarioPort();
    }

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
        webService();
        listaObjeto = (ArrayList<Object>) port.listaMacroProcesos().getRetorna();
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
        webService();
        MacroprocesosEntity macroRta = null;
        try {
            macroRta = port.ingresaMacroProceso(macro);
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
        webService();
        String rta = "";
        try {
            if (port.actualizaMacroProceso(macro) != null) {
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
    
    public MacroprocesosEntity macroProcesoPorId(int idMacrop){
        webService();
        return port.macroPorId(idMacrop);
    }
}
