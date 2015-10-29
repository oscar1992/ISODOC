/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.siscomputo.administracion.bean;

import co.com.siscomputo.administracion.logic.DepartamentoLogic;
import co.com.siscomputo.administracion.logic.PaisesLogic;
import co.com.siscomputo.endpoint.DepartamentoEntity;
import co.com.siscomputo.endpoint.PaisEntity;
import java.util.ArrayList;
import java.util.Iterator;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author LENOVO
 */
@ManagedBean(name = "Departamentos")
@ViewScoped
public class DepartamentoBean {
    private ArrayList<DepartamentoEntity> lista;
    private ArrayList<DepartamentoEntity> listaFiltro;
    private DepartamentoEntity departamentoObjeto;

    public ArrayList<DepartamentoEntity> getLista() {
        return lista;
    }

    public void setLista(ArrayList<DepartamentoEntity> lista) {
        this.lista = lista;
    }

    public ArrayList<DepartamentoEntity> getListaFiltro() {
        return listaFiltro;
    }

    public void setListaFiltro(ArrayList<DepartamentoEntity> listaFiltro) {
        this.listaFiltro = listaFiltro;
    }

    public DepartamentoEntity getDepartamentoObjeto() {
        return departamentoObjeto;
    }

    public void setDepartamentoObjeto(DepartamentoEntity departamentoObjeto) {
        this.departamentoObjeto = departamentoObjeto;
    }
    @PostConstruct
    public void init(){
        consultarDepartamentos();
    }

    public DepartamentoBean() {
        departamentoObjeto=new DepartamentoEntity();
        departamentoObjeto.setIdPais(new PaisEntity());
    }
    /**
     * Método que trae la lista de Empresas del servicio web
     */
    public void consultarDepartamentos(){
        try {
            DepartamentoLogic departamentoLogic=new DepartamentoLogic();
            lista=departamentoLogic.listaDepartamentos();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * Método que ingresa un Departamento nueva a traves del servicio web
     */
    public void ingresarDepartamento(){
        try {
            DepartamentoLogic departamentoLogic=new DepartamentoLogic();
            DepartamentoEntity departamentoEntity=departamentoLogic.ingresaDepartameto(departamentoObjeto);
            FacesMessage msg=null;
            if(departamentoEntity!=null){
                msg=new FacesMessage("", "Departamento Ingresado Correctamente: "+departamentoEntity.getNombreDepartamento());
                adicionarDepartamentoLista(departamentoEntity);
            }else{
                msg=new FacesMessage("", "Departamento Ingresado Incorrectamente: "+departamentoEntity.getNombreDepartamento());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        departamentoObjeto=new DepartamentoEntity();
        RequestContext.getCurrentInstance().execute("PF('insertarDepartamento').hide()");
        
    }
    /**
     * Método que añade a la lista el departamento en la vista
     * @param departamentoEntity 
     */
    private void adicionarDepartamentoLista(DepartamentoEntity departamentoEntity) {
        lista.add(departamentoEntity);
    }
    /**
     * Método que envia un Departamento para ser actualizado
     */
    public void actualizarDepartamento(){
        DepartamentoLogic departamentoLogic=new DepartamentoLogic();
        String valida=departamentoLogic.actualizarDepartamento(departamentoObjeto);
        FacesMessage msg=null;
        if("Ok".equalsIgnoreCase(valida)){
            actualizarListaDepartamento(departamentoObjeto);
        }else if("Error".equalsIgnoreCase(valida)){
            
        }
        RequestContext.getCurrentInstance().execute("PF('actualizarDepartamento').hide()");
    }
    /**
     * Método que actualiza la lista visual de la tabla
     * @param departamentoObjeto 
     */
    private void actualizarListaDepartamento(DepartamentoEntity departamentoObjeto) {
        try {
            ArrayList<DepartamentoEntity>listaa=new ArrayList<>();
            if(lista!=null){
                for(DepartamentoEntity item:lista){
                    if(departamentoObjeto.getIdDepartamento()==item.getIdDepartamento()){
                        PaisesLogic paisesLogic=new PaisesLogic();
                        PaisEntity pais=paisesLogic.paisPorId(departamentoObjeto.getIdPais().getIdPais());
                        departamentoObjeto.setIdPais(pais);
                        listaa.add(departamentoObjeto);
                    }else{
                        listaa.add(item);
                    }
                }
            }
            this.lista=new ArrayList<>();
            this.lista=listaa;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * Método que se llama con la selsción de un Departamento
     * @param event 
     */
    public void onRowSelect(SelectEvent event){
        departamentoObjeto=(DepartamentoEntity)event.getObject();
        if(departamentoObjeto.getIdPais()==null){
            PaisEntity pais=new PaisEntity();
            pais.setIdPais(-1);;
            departamentoObjeto.setIdPais(pais);
        }
    }
    /**
     * Método que "elimina" un Departamento actualizando su estado
     */
    public void eliminarDepartamento(){
        DepartamentoLogic departamentoLogic=new DepartamentoLogic();
        departamentoObjeto.setEstadoDepartamento("E");
        departamentoLogic.actualizarDepartamento(departamentoObjeto);
        eliminarDepartamentoLista(departamentoObjeto);
        departamentoObjeto=new DepartamentoEntity();
        RequestContext.getCurrentInstance().execute("PF('eliminarDepartamento').hide()");
        
    }
    /**
     * Método que elimina una Empresa en la tabla visual
     * @param departamentoObjeto 
     */
    private void eliminarDepartamentoLista(DepartamentoEntity departamentoObjeto) {
        Iterator itr=lista.iterator();
        while (itr.hasNext()) {
            DepartamentoEntity departamentoEntity=(DepartamentoEntity)itr.next();
            if(departamentoEntity.getIdDepartamento()==departamentoObjeto.getIdDepartamento()){
                itr.remove();
            }
            
        }
    }
    
    public void nuevoDepartamentoObjeto(){
        departamentoObjeto=new DepartamentoEntity();
        PaisEntity pais=new PaisEntity();
        pais.setIdPais(-1);
        departamentoObjeto.setIdPais(pais);
    }
}
