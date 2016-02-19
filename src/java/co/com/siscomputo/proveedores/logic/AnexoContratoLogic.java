/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.siscomputo.proveedores.logic;

import co.com.siscomputo.endpoint.AnexoContratoEntity;
import co.com.siscomputo.utilidades.IurlWebService;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public class AnexoContratoLogic implements IurlWebService{
    private List anexosContrato;

    public List getAnexosContrato() {
        return anexosContrato;
    }

    public void setAnexosContrato(List anexosContrato) {
        this.anexosContrato = anexosContrato;
    }
    
    /**
     * Método que trae una lista de Anexos de los contratos
     * @return 
     */
    public ArrayList<AnexoContratoEntity> listaAnexoContrato(){
        ArrayList<AnexoContratoEntity> listaaux=new ArrayList<>();
        ArrayList<Object> listaObjeto =(ArrayList<Object>) portProveedores().listarAnexosContratos().getRetorna();
        for(Object obj:listaObjeto){
            AnexoContratoEntity objectanexoContrato=(AnexoContratoEntity) obj;
            listaaux.add(objectanexoContrato);
        }
        return listaaux;
    }
    
    /**
     * Método que permite ingresar un Anexos del contrato nuevo
     * @param objeto
     * @return 
     */
    public AnexoContratoEntity insertarAnexoContrato(AnexoContratoEntity objeto){
        AnexoContratoEntity dispoRta=null;        
        try {
            dispoRta = portProveedores().actualizarAnexoContrato(objeto);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dispoRta;
    }
/**
     * Método que permite actualizar un Anexos del contrato
     * @param objeto
     * @return 
     */
    public String actualizarAnexoContrato(AnexoContratoEntity objeto){
        String rta="";
        try {            
            if (portProveedores().actualizarAnexoContrato(objeto) != null) {
                rta = "Ok";
            } else {
                rta = "Error";
            }
        } catch (Exception e) {
            rta="Error";
            e.printStackTrace();            
        }
        return rta;
    }

}
