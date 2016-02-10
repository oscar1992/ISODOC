/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.siscomputo.gestiondocumental.bean;

import co.com.siscomputo.administracion.logic.AccionLogic;
import co.com.siscomputo.endpoint.AccionEntity;
import java.util.ArrayList;
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
    private Map<String, Integer> listaAccionesPorUsuario;
    private Integer idUsuario;
    
    
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
    
    public void accionPorUsuario(Integer idUsuario){
        this.idUsuario=idUsuario;
        iniciaListaAccionesPorUsuario();
    }
    
    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }
    
    public Map<String, Integer> getListaAccionesPorUsuario() {
        return listaAccionesPorUsuario;
    }

    public void setListaAccionesPorUsuario(Map<String, Integer> listaAccionesPorUsuario) {
        this.listaAccionesPorUsuario = listaAccionesPorUsuario;
    }
    
    public void iniciaListaAccionesPorUsuario(){
        listaAccionesPorUsuario=new HashMap<String, Integer>();
        AccionLogic accionLogic=new AccionLogic();
        ArrayList<AccionEntity> listaAccionesWS=accionLogic.accionPorUsuario(idUsuario);
        System.out.println("IDWS: "+idUsuario);
        for(AccionEntity acc:listaAccionesWS){
            System.out.println("añade?");
            listaAccionesPorUsuario.put(acc.getNombreAccion(), acc.getIdAccion());
        }
    }
}
