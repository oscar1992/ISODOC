/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.siscomputo.administracion.bean;

import co.com.siscomputo.administracion.logic.PaisesLogic;
import co.com.siscomputo.endpoint.PaisEntity;
import java.io.Serializable;
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
@ManagedBean(name = "Paises")
@ViewScoped
public class PaisBean implements Serializable{
    private ArrayList<PaisEntity> lista;
    private ArrayList<PaisEntity> listaFiltro;
    private PaisEntity paisObjeto;

    public ArrayList<PaisEntity> getLista() {
        return lista;
    }

    public void setLista(ArrayList<PaisEntity> lista) {
        this.lista = lista;
    }

    public ArrayList<PaisEntity> getListaFiltro() {
        return listaFiltro;
    }

    public void setListaFiltro(ArrayList<PaisEntity> listaFiltro) {
        this.listaFiltro = listaFiltro;
    }

    public PaisEntity getPaisObjeto() {
        return paisObjeto;
    }

    public void setPaisObjeto(PaisEntity paisObjeto) {
        this.paisObjeto = paisObjeto;
    }
    
    @PostConstruct
    public void init(){
        consultarPaises();
    }

    public PaisBean() {
        paisObjeto=new PaisEntity();
    }
    
    
     /**
     * Método que trae la lista de Paises del servicio web
     */
     public void consultarPaises(){
         try {
             PaisesLogic paisesLogic=new PaisesLogic();
             lista=paisesLogic.listaPaises();
         } catch (Exception e) {
             e.printStackTrace();
         }
     }
     /**
     * Método que ingresa un Pais nuevo a traves del servicio web
     */
     public void ingresarPais(){
         try {
             PaisesLogic paisesLogic=new PaisesLogic();
             PaisEntity paisEntity=paisesLogic.ingresaPais(paisObjeto);
             FacesMessage msg=null;
             if(paisEntity!=null){
                 msg=new FacesMessage("", "País Ingresado Correctamente: "+paisEntity.getNombrePais());
                 adicionarPaisLista(paisEntity);
             }else{
                 msg=new FacesMessage("", "País Ingresado Incorrectamente: "+paisEntity.getNombrePais());
             }
         } catch (Exception e) {
             e.printStackTrace();
         }
         RequestContext.getCurrentInstance().execute("PF('insertarPais').hide()");
         nuevoPais();
     }
    /**
     * Método que añade a la lista el país en la vista
     * @param paisEntity 
     */
    private void adicionarPaisLista(PaisEntity paisEntity) {
        lista.add(paisObjeto);
    }
    /**
     * Método que envia un País para ser actualizada
     */
    public void actualizarPais(){
        PaisesLogic paisesLogic=new PaisesLogic();
        String valida=paisesLogic.actualizarPais(paisObjeto);
        FacesMessage msg=null;
        if("Ok".equalsIgnoreCase(valida)){
            actualizarListaPais(paisObjeto);
        }else if("Error".equalsIgnoreCase(valida)){
            
        }
        paisObjeto=new PaisEntity();
        RequestContext.getCurrentInstance().execute("PF('actualizarPais').hide()");
    }
    /**
     * Método que actualiza la lista visual de la tabla
     * @param paisObjeto  
     */
    private void actualizarListaPais(PaisEntity paisObjeto) {
        try {
            ArrayList<PaisEntity>listaaux=new ArrayList<>();
            if(lista!=null){
                for(PaisEntity item:lista){
                    if(paisObjeto.getIdPais()==item.getIdPais()){
                        listaaux.add(paisObjeto);
                    }else{
                        listaaux.add(item);
                    }
                }
            }
            this.lista=new ArrayList<>();
            this.lista=listaaux;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * Método que se llama con la selección de un País
     * @param event 
     */
    public void onRowSelect(SelectEvent event){
        paisObjeto=(PaisEntity) event.getObject();
    }
    /**
     * Método que "elimina" un Pais actualizando su estado
     */
    public void eliminarPais(){
        PaisesLogic paisesLogic=new PaisesLogic();
        paisObjeto.setEstadoPais("E");
        paisesLogic.actualizarPais(paisObjeto);
        eliminarPaisLista(paisObjeto);
        paisObjeto=new PaisEntity();
        RequestContext.getCurrentInstance().execute("PF('eliminarPais').hide()");
    }
    /**
     * Método que elimina un país en la tabla visual
     * @param paisObjeto 
     */
    private void eliminarPaisLista(PaisEntity paisObjeto) {
        Iterator itr=lista.iterator();
        while (itr.hasNext()) {
            PaisEntity pais=(PaisEntity)itr.next();
            if(pais.getIdPais()==paisObjeto.getIdPais()){
                itr.remove();
            }
        }
    }
    
    public void nuevoPais(){
        paisObjeto=new PaisEntity();
        System.out.println("PAIS: "+paisObjeto.getNombrePais());
    }
}
