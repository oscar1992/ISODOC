/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.siscomputo.proveedores.bean;

import co.com.siscomputo.endpoint.LineaEntity;
import co.com.siscomputo.endpoint.TipoProveedorEntity;
import co.com.siscomputo.endpoint.TipoTributarioEntity;
import co.com.siscomputo.proveedores.logic.LineaLogic;
import co.com.siscomputo.proveedores.logic.TipoProveedorLogic;
import co.com.siscomputo.proveedores.logic.TipoTributarioLogic;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author LENOVO
 */
@ManagedBean(name = "ListaProveedoresBean")
public class ListaProveedoresBean implements Serializable{
    private HashMap<String, Integer>listaLineas;
    private HashMap<String, Integer>listaTipoProveedor;
    private HashMap<String, Integer>listaTipoTributaria;
    
    

    public HashMap<String, Integer> getListaLineas() {
        iniciaListaLineas();
        return listaLineas;
    }

    public void setListaLineas(HashMap<String, Integer> listaLineas) {
        this.listaLineas = listaLineas;
    }
    
    public void iniciaListaLineas(){
        listaLineas=new HashMap<String, Integer>();
        LineaLogic lineaLogic=new LineaLogic();
        ArrayList<LineaEntity> listaLineasWS=lineaLogic.listaLinea();
        for(LineaEntity linea:listaLineasWS){
            listaLineas.put(linea.getTipoLinea(), linea.getIdLinea());
        }
    }

    public HashMap<String, Integer> getListaTipoProveedor() {
        iniciaListaTipoProveedor();
        return listaTipoProveedor;
    }

    public void setListaTipoProveedor(HashMap<String, Integer> listaTipoProveedor) {
        this.listaTipoProveedor = listaTipoProveedor;
    }
    
    public void iniciaListaTipoProveedor(){
        listaTipoProveedor=new HashMap<String, Integer>();
        TipoProveedorLogic tipoProveedorLogic=new TipoProveedorLogic();
        ArrayList<TipoProveedorEntity>listaTipoProveedorWS=tipoProveedorLogic.listaTipoProveedor();
        for(TipoProveedorEntity tipo:listaTipoProveedorWS){
            listaTipoProveedor.put(tipo.getNombreTipoProveedor(), tipo.getIdTipoProveedor());
        }
    }

    public HashMap<String, Integer> getListaTipoTributaria() {
        return listaTipoTributaria;
    }

    public void setListaTipoTributaria(HashMap<String, Integer> listaTipoTributaria) {
        this.listaTipoTributaria = listaTipoTributaria;
    }
    
    public void iniciaListaTipoTributaria(){
        listaTipoTributaria=new HashMap<String, Integer>();
        TipoTributarioLogic tipoTributarioLogicLogic=new TipoTributarioLogic();
        ArrayList<TipoTributarioEntity>listaTipoTributariaWS=tipoTributarioLogicLogic.listaTipoTributario();
        for(TipoTributarioEntity tipo:listaTipoTributariaWS){
            listaTipoProveedor.put(tipo.getNombreTipoTributario(), tipo.getIdTipoTributario());
        }
    }
}
