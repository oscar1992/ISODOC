/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.siscomputo.proveedores.bean;

import co.com.siscomputo.endpoint.FormasPagoEntity;
import co.com.siscomputo.endpoint.LineaEntity;
import co.com.siscomputo.endpoint.TipoCuentaEntity;
import co.com.siscomputo.endpoint.TipoDocumentoEntity;
import co.com.siscomputo.endpoint.TipoProveedorEntity;
import co.com.siscomputo.endpoint.TipoTributarioEntity;
import co.com.siscomputo.proveedores.logic.FormasPagoLogic;
import co.com.siscomputo.proveedores.logic.LineaLogic;
import co.com.siscomputo.proveedores.logic.TipoCuentaLogic;
import co.com.siscomputo.proveedores.logic.TipoDocumentoLogic;
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
    private HashMap<String, Integer>listaTipoCuenta;
    private HashMap<String, Integer>listaFormaPago;
    private HashMap<String, Integer>listaTipoDocumento;
    
    

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
        iniciaListaTipoTributaria();
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
            listaTipoTributaria.put(tipo.getNombreTipoTributario(), tipo.getIdTipoTributario());
        }
    }

    public HashMap<String, Integer> getListaTipoCuenta() {
        iniciaListaTipoCuenta();
        return listaTipoCuenta;
    }

    public void setListaTipoCuenta(HashMap<String, Integer> listaTipoCuenta) {
        this.listaTipoCuenta = listaTipoCuenta;
    }
    
    public void iniciaListaTipoCuenta(){
        listaTipoCuenta=new HashMap<String, Integer>();
        TipoCuentaLogic tipoCuentaLogic=new TipoCuentaLogic();
        ArrayList<TipoCuentaEntity>listaTipoCuentaWS=tipoCuentaLogic.listaTipoCuenta();
        for(TipoCuentaEntity tipo:listaTipoCuentaWS){
            listaTipoCuenta.put(tipo.getTipoTipoCuenta(), tipo.getIdTipoCuenta());
        }
    }

    public HashMap<String, Integer> getListaFormaPago() {
        iniciaListaFormaPago();
        return listaFormaPago;
    }

    public void setListaFormaPago(HashMap<String, Integer> listaFormaPago) {
        this.listaFormaPago = listaFormaPago;
    }
    
    public void iniciaListaFormaPago(){
        listaFormaPago=new HashMap<String, Integer>();
        FormasPagoLogic formasPagoLogic=new FormasPagoLogic();
        ArrayList<FormasPagoEntity>listaFormaPagoWS=formasPagoLogic.listaFormasPago();
        for(FormasPagoEntity pago:listaFormaPagoWS){
            listaFormaPago.put(pago.getTipoFormaPago(), pago.getIdFormasPagos());
        }
    }

    public HashMap<String, Integer> getListaTipoDocumento() {
        return listaTipoDocumento;
    }

    public void setListaTipoDocumento(HashMap<String, Integer> listaTipoDocumento) {
        this.listaTipoDocumento = listaTipoDocumento;
    }
    
    public void iniciaListaTipoDocumento(){
        listaTipoDocumento=new HashMap<String, Integer>();
        TipoDocumentoLogic tipoDocumentoLogic=new TipoDocumentoLogic();
        ArrayList<TipoDocumentoEntity>listaTipoDocumentoWS=tipoDocumentoLogic.listaTipoDocumento();
        for(TipoDocumentoEntity documento:listaTipoDocumentoWS){
            listaTipoDocumento.put(documento.getTipoTipoDocumento(), documento.getIdTipoDocumento());
        }
    }
}
