/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.siscomputo.proveedores.bean;

import co.com.siscomputo.administracion.logic.CiudadLogic;
import co.com.siscomputo.endpoint.CiudadEntity;
import co.com.siscomputo.endpoint.EstadoProveedorEntity;
import co.com.siscomputo.endpoint.FormasPagoEntity;
import co.com.siscomputo.endpoint.LineaEntity;
import co.com.siscomputo.endpoint.ProveedoresEntity;
import co.com.siscomputo.endpoint.TipoCuentaEntity;
import co.com.siscomputo.endpoint.TipoDocumentoEntity;
import co.com.siscomputo.endpoint.TipoMonedaEntity;
import co.com.siscomputo.endpoint.TipoProveedorEntity;
import co.com.siscomputo.endpoint.TipoTributarioEntity;
import co.com.siscomputo.proveedores.logic.EstadoProveedorLogic;
import co.com.siscomputo.proveedores.logic.FormasPagoLogic;
import co.com.siscomputo.proveedores.logic.LineaLogic;
import co.com.siscomputo.proveedores.logic.ProveedoresLogic;
import co.com.siscomputo.proveedores.logic.TipoCuentaLogic;
import co.com.siscomputo.proveedores.logic.TipoDocumentoLogic;
import co.com.siscomputo.proveedores.logic.TipoMonedaLogic;
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
    private HashMap<String, Integer>listaEstadosProveedor;
    private HashMap<String, Integer>listaCiudadesProveedor;
    private HashMap<String, String>listaEstadosContrato;
    private HashMap<String, Integer>listaProveedores;
    private HashMap<String, Integer>listaTiposMoneda;
    
    
    
    

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

    public HashMap<String, Integer> getListaEstadosProveedor() {
        iniciaListaEstadoProveedores();
        return listaEstadosProveedor;
    }

    public void setListaEstadosProveedor(HashMap<String, Integer> listaEstadosProveedor) {
        this.listaEstadosProveedor = listaEstadosProveedor;
    }
    
    public void iniciaListaEstadoProveedores(){
        listaEstadosProveedor=new HashMap<String, Integer>();
        EstadoProveedorLogic estadoProveedorLogic=new EstadoProveedorLogic();
        ArrayList<EstadoProveedorEntity>listaEstadoProveedorWS=estadoProveedorLogic.listaEstadoProveedor();
        for(EstadoProveedorEntity estado:listaEstadoProveedorWS){
            listaEstadosProveedor.put(estado.getTipoEstadoProveedor(), estado.getIdEstadoProveedor());
        }
    }

    public HashMap<String, Integer> getListaCiudadesProveedor() {
        iniciaListaCiudadProveedor();
        return listaCiudadesProveedor;
    }

    public void setListaCiudadesProveedor(HashMap<String, Integer> listaCiudadesProveedor) {
        this.listaCiudadesProveedor = listaCiudadesProveedor;
    }
    
    public void iniciaListaCiudadProveedor(){
        listaCiudadesProveedor=new HashMap<String, Integer>();
        CiudadLogic ciudadLogic=new CiudadLogic();
        ArrayList<CiudadEntity>listaCiudadWS=ciudadLogic.listaCiudades();
        for(CiudadEntity ciudad:listaCiudadWS){
            listaCiudadesProveedor.put(ciudad.getNombreCiudad(), ciudad.getIdCiudad());
        }
    }

    public HashMap<String, String> getListaEstadosContrato() {
        iniciaListaEstadosContrato();
        return listaEstadosContrato;
    }

    public void setListaEstadosContrato(HashMap<String, String> listaEstadosContrato) {
        this.listaEstadosContrato = listaEstadosContrato;
    }
    
    
    public void iniciaListaEstadosContrato(){
        listaEstadosContrato=new HashMap<String, String>();
        listaEstadosContrato.put("Renovado", "Renovado");
        listaEstadosContrato.put("Vencido", "Vencido");
        listaEstadosContrato.put("Vigente", "Vigente");
    }

    public HashMap<String, Integer> getListaProveedores() {
        iniciaListaProveedores();
        return listaProveedores;
    }

    public void setListaProveedores(HashMap<String, Integer> listaProveedores) {
        this.listaProveedores = listaProveedores;
    }
    
    public void iniciaListaProveedores(){
        listaProveedores=new HashMap<String, Integer>();
        ProveedoresLogic proveedoresLogic=new ProveedoresLogic();
        ArrayList<ProveedoresEntity>listaProveedoresWS=proveedoresLogic.listaProveedores();
        for(ProveedoresEntity provee:listaProveedoresWS){
            listaProveedores.put(provee.getNombreProveedor(), provee.getIdProveedor());
        }
    }

    public HashMap<String, Integer> getListaTiposMoneda() {
        iniciaListaTiposMoneda();
        return listaTiposMoneda;
    }

    public void setListaTiposMoneda(HashMap<String, Integer> listaTiposMoneda) {
        this.listaTiposMoneda = listaTiposMoneda;
    }
    
    public void iniciaListaTiposMoneda(){
        listaTiposMoneda=new HashMap<String, Integer>();
        TipoMonedaLogic monedaLogic=new TipoMonedaLogic();
        ArrayList<TipoMonedaEntity>listaTipoMonedaWS=monedaLogic.listaTipoMoneda();
        for(TipoMonedaEntity moneda:listaTipoMonedaWS){
            listaTiposMoneda.put(moneda.getTipoMoneda(), moneda.getIdMoneda());
        }
    }
}
