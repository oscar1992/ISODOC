/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.siscomputo.gestiondocumental.bean;

import java.util.HashMap;
import java.util.Map;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author LENOVO
 */
@ManagedBean(name = "ListaGestionDocumentalBean")
public class ListaGestionDocumentalBean {
    private Map<String, String> listaTipoControl;

    public Map<String, String> getListaTipoControl() {
        iniciaListaTipoControl();
        return listaTipoControl;
    }

    public void setListaTipoControl(Map<String, String> listaTipoControl) {
        this.listaTipoControl = listaTipoControl;
    }
    
    
    public void iniciaListaTipoControl(){
        listaTipoControl=new HashMap<String, String>();
        listaTipoControl.put("Copia Controlada", "Controlada");
        listaTipoControl.put("Copia No Controlada", "No Controlada");
    }
}
