/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.siscomputo.proveedores.bean;

import co.com.siscomputo.endpoint.AnexoContratoEntity;
import co.com.siscomputo.proveedores.logic.AnexoContratoLogic;
import co.com.siscomputo.utilidades.MensajesJSF;

/**
 *
 * @author LENOVO
 */
public class AnexoContratoBean {
    private AnexoContratoEntity objetoAnexoInsercion;

    public AnexoContratoEntity getObjetoAnexoInsercion() {
        return objetoAnexoInsercion;
    }

    public void setObjetoAnexoInsercion(AnexoContratoEntity objetoAnexoInsercion) {
        this.objetoAnexoInsercion = objetoAnexoInsercion;
    }
    
    /**
     * Método que permite insertar un Anexos del proveedor nuevo
     */
    public void instertarAnexoContrato(){
        try {
            AnexoContratoLogic anexoContratoLogic=new AnexoContratoLogic();
            AnexoContratoEntity anexoContratoEntity=anexoContratoLogic.insertarAnexoContrato(objetoAnexoInsercion);            
            
            if(anexoContratoEntity!=null){
                MensajesJSF.muestraMensajes("inserción de Anexos del proveedor correcto", "Mensaje");
                
            }else{
                MensajesJSF.muestraMensajes("inserción de Anexos del proveedor incorrecto", "Error");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
}
