/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.siscomputo.administracion.bean;

import co.com.siscomputo.administracion.logic.AccionLogic;
import co.com.siscomputo.administracion.logic.AreaLogic;
import co.com.siscomputo.administracion.logic.DepartamentoLogic;
import co.com.siscomputo.administracion.logic.MacroProcesosLogic;
import co.com.siscomputo.administracion.logic.NivelLogic;
import co.com.siscomputo.administracion.logic.PaisesLogic;
import co.com.siscomputo.administracion.logic.PlantillaLogic;
import co.com.siscomputo.administracion.logic.ProcesoLogic;
import co.com.siscomputo.administracion.logic.ProcesosLogic;
import co.com.siscomputo.administracion.logic.RolesLogic;
import co.com.siscomputo.administracion.logic.SedesLogic;
import co.com.siscomputo.administracion.logic.SubProcesosLogic;
import co.com.siscomputo.administracion.logic.TiposDocumentalesLogic;
import co.com.siscomputo.endpoint.AccionEntity;
import co.com.siscomputo.endpoint.AreaEntity;
import co.com.siscomputo.endpoint.DepartamentoEntity;
import co.com.siscomputo.endpoint.MacroprocesosEntity;
import co.com.siscomputo.endpoint.NivelEntity;
import co.com.siscomputo.endpoint.PaisEntity;
import co.com.siscomputo.endpoint.PlantillaEntity;
import co.com.siscomputo.endpoint.ProcesoEntity;
import co.com.siscomputo.endpoint.ProcesosEntity;
import co.com.siscomputo.endpoint.RolesEntity;
import co.com.siscomputo.endpoint.SedeEntity;
import co.com.siscomputo.endpoint.SubprocesoEntity;
import co.com.siscomputo.endpoint.TiposDocumentalesEntity;
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
    private Map<String, Integer> listaRoles;
    private Map<String, Integer> listaMacroProcesos;
    private Map<String, Integer> listaProcesos;
    private Map<String, Integer> listaSubProcesos;
    private Map<String, Integer> listaAreas;
    private Map<String, String> listaGeneracionTipoDocumental;
    private Map<String, Integer> listaTipoDocumento;
    private Map<String, Integer> listaPlantillas;
    private Map<String, Integer> listaNivelProceso;
    private Map<String, Integer> listaProcesoAsociado;
    private Map<String, Integer> listaAcciones;
    private Map<String, Integer> listaProceso;
    private int seleccion;
    private Integer idMacroProceso;
    private Integer idProceso;

    @PostConstruct
    public void init() {        
        
    }

    public Integer getIdMacroProceso() {
        return idMacroProceso;
    }

    public void setIdMacroProceso(Integer idMacroProceso) {
        this.idMacroProceso = idMacroProceso;
    }

    public Integer getIdProceso() {
        return idProceso;
    }

    public void setIdProceso(Integer idProceso) {
        this.idProceso = idProceso;
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
    /**
     * Método que inicializa la lista de estados
     */
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
    /**
     * Método que inicializa la lista de sedes
     */
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
    /**
     * Método que inicializa la lista de paises
     */
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
    /**
     * Método que inicializa la lista de departamentos
     */
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
    /**
     * Método que inicializa la lista de roles
     */
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
    /*
    *Método que filtra la lista de procesos por macro-proceso
    */
    public void idMacrio(int idMacro){
        System.out.println("MM: "+idMacro);
        idMacroProceso=idMacro;
        iniciarProcesos();
    }
    /**
     * Método que inicializa la lista de macro procesos
     */
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
    /**
     * Método que filtra los subprosesos por el id del proceso que los contiene
     * @param idProceso 
     */
    public void idCambiaProceso(int idProceso){
        this.idProceso=idProceso;
        iniciarSubProcesos();
    }
    /**
     * Método que inicializa la lista de procesos
     */
    public void iniciarProcesos(){
        listaProcesos=new HashMap<String, Integer>();
        ProcesosLogic procesosLogic=new ProcesosLogic();
        ArrayList<ProcesosEntity>listaProcesosWS=procesosLogic.listaProcesos();
        for(ProcesosEntity proceso:listaProcesosWS){
            if(idMacroProceso==null){
                listaProcesos.put(proceso.getNombrePreoceso(), proceso.getIdProcesos());
            }else{
                if(proceso.getIdMacroProceso().getIdMacroproceso()==idMacroProceso){
                    listaProcesos.put(proceso.getNombrePreoceso()+"-"+proceso.getIdProcesos(), proceso.getIdProcesos());
                }
            }
            
        }
    }

    public Map<String, Integer> getListaAreas() {
        iniciarAreas();
        return listaAreas;
    }

    public void setListaAreas(Map<String, Integer> listaAreas) {
        this.listaAreas = listaAreas;
    }
    /**
     * Método que inicializa la lista de areas
     */
    public void iniciarAreas(){
        listaAreas=new HashMap<String, Integer>();
        AreaLogic areaLogic=new AreaLogic();
        ArrayList<AreaEntity>listaAreasWS=areaLogic.listaAreas();
        for(AreaEntity area:listaAreasWS){
            listaAreas.put(area.getNombreArea(), area.getIdArea());
        }
    }

    public Map<String, String> getListaGeneracionTipoDocumental() {
        iniciarListaGeneracionTipoDocumental();
        return listaGeneracionTipoDocumental;
    }

    public void setListaGeneracionTipoDocumental(Map<String, String> listaGeneracionTipoDocumental) {
        this.listaGeneracionTipoDocumental = listaGeneracionTipoDocumental;
    }
    /**
     * Método que inicializa la lista de tipos de generaciones de tipos documentales
     */
    public void iniciarListaGeneracionTipoDocumental(){
        listaGeneracionTipoDocumental=new HashMap<String, String>();
        listaGeneracionTipoDocumental.put("Automático", "Automático");
        listaGeneracionTipoDocumental.put("Manual", "Manual");
    }

    public Map<String, Integer> getListaTipoDocumento() {
        iniciarTipoDocumento();
        return listaTipoDocumento;
    }

    public void setListaTipoDocumento(Map<String, Integer> listaTipoDocumento) {
        this.listaTipoDocumento = listaTipoDocumento;
    }

    public void iniciarTipoDocumento(){
        listaTipoDocumento=new HashMap<String, Integer>();
        TiposDocumentalesLogic tiposDocumentalesLogic=new TiposDocumentalesLogic();
        ArrayList<TiposDocumentalesEntity>listaTiposDocumentalesWS=tiposDocumentalesLogic.listaTiposDocumentales();
        for(TiposDocumentalesEntity tipos:listaTiposDocumentalesWS){
            listaTipoDocumento.put(tipos.getNombreTipoDocumental(), tipos.getIdTipoDocumental());
        }
    }

    public Map<String, Integer> getListaPlantillas() {
        iniciarPlantillas();
        return listaPlantillas;
    }

    public void setListaPlantillas(Map<String, Integer> listaPlantillas) {
        this.listaPlantillas = listaPlantillas;
    }
    
    public void iniciarPlantillas(){
        listaPlantillas=new HashMap<String, Integer>();
        PlantillaLogic plantillaLogic=new PlantillaLogic();
        ArrayList<PlantillaEntity>listaPlantillaWS=plantillaLogic.listaPlantilla();
        for(PlantillaEntity plantilla:listaPlantillaWS){
            listaPlantillas.put(plantilla.getNombrePlantilla(), plantilla.getIdPlantilla());
        }
    }

    public Map<String, Integer> getListaSubProcesos() {
        iniciarSubProcesos();
        return listaSubProcesos;
    }

    public void setListaSubProcesos(Map<String, Integer> listaSubProcesos) {
        this.listaSubProcesos = listaSubProcesos;
    }
    
    public void iniciarSubProcesos(){
        listaSubProcesos=new HashMap<String, Integer>();
        SubProcesosLogic subProcesosLogic=new SubProcesosLogic();
        ArrayList<SubprocesoEntity>listaSubprocesoWS=subProcesosLogic.listaSubprocesos();
        for(SubprocesoEntity subpro:listaSubprocesoWS){
            if(idProceso==null){
                listaSubProcesos.put(subpro.getNombreSubproceso(), subpro.getIdSubproceso());
            }else{
                if(subpro.getIdProcesos().getIdProcesos()==idProceso){
                    listaSubProcesos.put(subpro.getNombreSubproceso(), subpro.getIdSubproceso());
                }
            }
            
        }
    }

    public Map<String, Integer> getListaNivelProceso() {
        iniciaroListaNivelProceso();
        return listaNivelProceso;
    }

    public void setListaNivelProceso(Map<String, Integer> listaNivelProceso) {
        this.listaNivelProceso = listaNivelProceso;
    }
    
    public void iniciaroListaNivelProceso(){
        listaNivelProceso=new HashMap<String, Integer>();
        NivelLogic nivelLogic=new NivelLogic();
        ArrayList<NivelEntity>listaNivelWS=nivelLogic.listaNivel();
        for(NivelEntity nivel: listaNivelWS){            
            listaNivelProceso.put(nivel.getNombreNivel(), nivel.getIdNivel());
        }
        
    }

    public Map<String, Integer> getListaProcesoAsociado() {
        iniciarListaProcesoAsociado();
        return listaProcesoAsociado;
    }

    public void setListaProcesoAsociado(Map<String, Integer> listaProcesoAsociado) {
        this.listaProcesoAsociado = listaProcesoAsociado;
    }
    
    public void iniciarListaProcesoAsociado(){
        listaProcesoAsociado=new HashMap<String, Integer>();
        ProcesoLogic procesoLogic=new ProcesoLogic();
        ArrayList<ProcesoEntity>listaProcesoWS=procesoLogic.listaProceso();
        for(ProcesoEntity proceso:listaProcesoWS){
            listaProcesoAsociado.put(proceso.getNombreProceso(), proceso.getIdProceso());
        }
    }

    public Map<String, Integer> getListaAcciones() {
        iniciarlistaAcciones();
        return listaAcciones;
    }

    public void setListaAcciones(Map<String, Integer> listaAcciones) {
        this.listaAcciones = listaAcciones;
    }
    
    public void iniciarlistaAcciones(){
        listaAcciones=new HashMap<String, Integer>();
        AccionLogic accionLogic=new AccionLogic();
        ArrayList<AccionEntity>listaAccionesWS=accionLogic.listaAccion();
        for(AccionEntity accion:listaAccionesWS){
            listaAcciones.put(accion.getNombreAccion(), accion.getIdAccion());
        }
    }
    
    public Map<String, Integer> getListaProceso() {
        iniciarListaProceso();
        return listaProceso;
    }

    public void setListaProceso(Map<String, Integer> listaProceso) {
        this.listaProceso = listaProceso;
    }
    
    public void iniciarListaProceso(){
        listaProceso=new HashMap<String, Integer>();
        ProcesoLogic procesoLogic=new ProcesoLogic();
        ArrayList<ProcesoEntity>listaProcesoWS=procesoLogic.listaProceso();
        for(ProcesoEntity proceso:listaProcesoWS){
            listaProceso.put(proceso.getNombreProceso(), proceso.getIdProceso());
        }
    }
}
