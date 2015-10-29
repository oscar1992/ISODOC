/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.siscomputo.administracion.bean;

import co.com.siscomputo.administracion.logic.DepartamentoLogic;
import co.com.siscomputo.administracion.logic.PaisesLogic;
import co.com.siscomputo.administracion.logic.SedesLogic;
import co.com.siscomputo.endpoint.DepartamentoEntity;
import co.com.siscomputo.endpoint.PaisEntity;
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
public class ListaAdministracionBean implements Serializable {

    private Map<String, String> listaEstados;
    private Map<String, Integer> listaSedes;
    private Map<String, Integer> listaPaises;
    private Map<String, Integer> listaDepartamentos;

    @PostConstruct
    public void init() {
        inicaListaEstados();
        iniciaListaSedes();
        iniciaListaPaises();
        iniciaListaDepartamentos();
    }

    public Map<String, String> getListaEstados() {
        return listaEstados;
    }

    public void setListaEstados(Map<String, String> listaEstados) {
        this.listaEstados = listaEstados;
    }

    public void inicaListaEstados() {
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

    public void iniciaListaSedes() {
        listaSedes = new HashMap<String, Integer>();
        SedesLogic sedesLogic = new SedesLogic();
        ArrayList<SedeEntity> listaSedesWS = (ArrayList<SedeEntity>) sedesLogic.getSedes();
        for (SedeEntity item : listaSedesWS) {
            listaSedes.put(item.getNombreSede(), item.getIdSede());
        }
    }

    public Map<String, Integer> getListaPaises() {
        return listaPaises;
    }

    public void setListaPaises(Map<String, Integer> listaPaises) {
        this.listaPaises = listaPaises;
    }

    public void iniciaListaPaises() {
        listaPaises = new HashMap<String, Integer>();
        PaisesLogic paisesLogic = new PaisesLogic();
        ArrayList<PaisEntity> listaPaisesWS = paisesLogic.listaPaises();
        for (PaisEntity item : listaPaisesWS) {
            listaPaises.put(item.getNombrePais(), item.getIdPais());
        }
    }

    public Map<String, Integer> getListaDepartamentos() {
        return listaDepartamentos;
    }

    public void setListaDepartamentos(Map<String, Integer> listaDepartamentos) {
        this.listaDepartamentos = listaDepartamentos;
    }

    public void iniciaListaDepartamentos() {
        listaDepartamentos=new HashMap<String, Integer>();
        DepartamentoLogic departamentoLogic=new DepartamentoLogic();
        ArrayList<DepartamentoEntity>listaDeptosWS=departamentoLogic.listaDepartamentos();
        for(DepartamentoEntity item: listaDeptosWS){
            listaDepartamentos.put(item.getNombreDepartamento(), item.getIdDepartamento());
        }
    }
}
