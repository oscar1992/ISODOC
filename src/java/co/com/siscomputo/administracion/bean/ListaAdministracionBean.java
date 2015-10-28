/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.siscomputo.administracion.bean;

import co.com.siscomputo.administracion.logic.SedesLogic;
import co.com.siscomputo.endpoint.SedeEntity;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author LENOVO
 */
@ManagedBean(name = "ListaAdministracionBean")
public class ListaAdministracionBean implements Serializable{
    private Map<String, String> listaEstados;
    private Map<String, Integer> listaSedes;
    
    @PostConstruct    
    public void init(){
        inicaListaEstados();
        iniciaListaSedes();
    }

    public Map<String, String> getListaEstados() {
        return listaEstados;
    }

    public void setListaEstados(Map<String, String> listaEstados) {
        this.listaEstados = listaEstados;
    }
    
    public void inicaListaEstados(){
        listaEstados = new HashMap<String, String>();
        listaEstados.put("Activo", "A");
        listaEstados.put("Eliminado", "E");
        listaEstados.put("Inactivo", "I");
    }

    public Map<String, Integer> getListaSedes() {
        return listaSedes;
    }

    public void setListaSedes(Map<String, Integer> listaSedes) {
        this.listaSedes = listaSedes;
    }
    
    public void iniciaListaSedes(){
        listaSedes=new HashMap<String, Integer>();
        SedesLogic sedesLogic=new SedesLogic();
        ArrayList<SedeEntity> listaSedesWS=(ArrayList<SedeEntity>) sedesLogic.getSedes();
        for(SedeEntity item:listaSedesWS){
            listaSedes.put(item.getNombreSede(), item.getIdSede());
        }
    }
}
