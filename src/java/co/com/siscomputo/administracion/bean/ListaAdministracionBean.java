/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.siscomputo.administracion.bean;

import co.com.siscomputo.administracion.logic.AreaLogic;
import co.com.siscomputo.administracion.logic.DepartamentoLogic;
import co.com.siscomputo.administracion.logic.MacroProcesosLogic;
import co.com.siscomputo.administracion.logic.PaisesLogic;
import co.com.siscomputo.administracion.logic.ProcesosLogic;
import co.com.siscomputo.administracion.logic.RolesLogic;
import co.com.siscomputo.administracion.logic.SedesLogic;
import co.com.siscomputo.endpoint.AreaEntity;
import co.com.siscomputo.endpoint.DepartamentoEntity;
import co.com.siscomputo.endpoint.MacroprocesosEntity;
import co.com.siscomputo.endpoint.PaisEntity;
import co.com.siscomputo.endpoint.ProcesosEntity;
import co.com.siscomputo.endpoint.RolPermisoEntity;
import co.com.siscomputo.endpoint.RolesEntity;
import co.com.siscomputo.endpoint.SedeEntity;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.swing.plaf.basic.BasicBorders;

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
    private Map<String, Integer> listaRoles;
    private Map<String, Integer> listaMacroProcesos;
    private Map<String, Integer> listaProcesos;
    private Map<String, Integer> listaAreas;
    private int seleccion;

    @PostConstruct
    public void init() {        
        
    }

    public int getSeleccion() {
        return seleccion;
    }

    public void setSeleccion(int seleccion) {
        this.seleccion = seleccion;
    }
    
    public Map<String, String> getListaEstados() {        
        inicaListaEstados();
        return listaEstados;
    }

    public void setListaEstados(Map<String, String> listaEstados) {
        this.listaEstados = listaEstados;
    }

    public void inicaListaEstados() {
        listaEstados = new HashMap<String, String>();
        listaEstados.put("Activo", "A");
        listaEstados.put("Inactivo", "I");
    }

    public Map<String, Integer> getListaSedes() {
        iniciaListaSedes();
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
        iniciaListaPaises();
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
        iniciaListaDepartamentos();
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

    public Map<String, Integer> getListaRoles() {
        iniciarListaRoles();
        return listaRoles;
    }

    public void setListaRoles(Map<String, Integer> listaRoles) {
        this.listaRoles = listaRoles;
    }
    
    public void iniciarListaRoles(){
        listaRoles=new HashMap<String, Integer>();
        RolesLogic rolesLogic=new RolesLogic();
        ArrayList<RolesEntity>listaRolPermisoWS=rolesLogic.listaRoles();
        for(RolesEntity rol:listaRolPermisoWS){
            listaRoles.put(rol.getNombreRol(), rol.getIdRol());
        }
    }

    public Map<String, Integer> getListaMacroProcesos() {
        iniciarMacroProcesos();
        return listaMacroProcesos;
    }

    public void setListamacroProcesos(Map<String, Integer> listamacroProcesos) {
        this.listaMacroProcesos = listamacroProcesos;
    }
    
    public void iniciarMacroProcesos(){
        listaMacroProcesos=new HashMap<String, Integer>();
        MacroProcesosLogic macroProcesosLogic=new MacroProcesosLogic();
        ArrayList<MacroprocesosEntity>listaMecroProcesosWS=macroProcesosLogic.listaMacroprocesos();
        for(MacroprocesosEntity macro:listaMecroProcesosWS){
            listaMacroProcesos.put(macro.getNombreMacroproceso(), macro.getIdMacroproceso());
        }
    }

    public Map<String, Integer> getListaProcesos() {
        iniciarProcesos();
        return listaProcesos;
    }

    public void setListaProcesos(Map<String, Integer> listaProcesos) {
        this.listaProcesos = listaProcesos;
    }
    
    public void iniciarProcesos(){
        listaProcesos=new HashMap<String, Integer>();
        ProcesosLogic procesosLogic=new ProcesosLogic();
        ArrayList<ProcesosEntity>listaProcesosWS=procesosLogic.listaProcesos();
        for(ProcesosEntity proceso:listaProcesosWS){
            listaProcesos.put(proceso.getNombrePreoceso(), proceso.getIdProcesos());
        }
    }

    public Map<String, Integer> getListaAreas() {
        iniciarAreas();
        return listaAreas;
    }

    public void setListaAreas(Map<String, Integer> listaAreas) {
        this.listaAreas = listaAreas;
    }
    
    public void iniciarAreas(){
        listaAreas=new HashMap<String, Integer>();
        AreaLogic areaLogic=new AreaLogic();
        ArrayList<AreaEntity>listaAreasWS=areaLogic.listaAreas();
        for(AreaEntity area:listaAreasWS){
            listaAreas.put(area.getNombreArea(), area.getIdArea());
        }
    }
}
