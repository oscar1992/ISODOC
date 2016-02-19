package co.com.siscomputo.proveedores.logic;

import co.com.siscomputo.endpoint.ContratosEntity;
import co.com.siscomputo.utilidades.IurlWebService;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public class ContratoLogic implements IurlWebService{
    private List contratos;
    
    /**
     * Funcion con la cual inicializo el service y el port de los WebServices
     */

    public List getContratos() {
        return contratos;
    }

    public void setContratos(List contratos) {
        this.contratos = contratos;
    }
    
    /**
     * Método que trae una lista de Contrato
     * @return 
     */
    public ArrayList<ContratosEntity> listaContratos(){
        ArrayList<ContratosEntity> listaaux=new ArrayList<>();
        ArrayList<Object> listaObjeto =(ArrayList<Object>) portProveedores().listaContratos().getRetorna();
        for(Object obj:listaObjeto){
            ContratosEntity objectcontratos=(ContratosEntity) obj;
            listaaux.add(objectcontratos);
        }
        return listaaux;
    }
/**
     * Método que permite ingresar un Contratonuevo
     * @param objeto
     * @return 
     */
    public ContratosEntity insertarContratos(ContratosEntity objeto){
        ContratosEntity dispoRta=null;        
        try {
            dispoRta = portProveedores().insertarContrato(objeto);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dispoRta;
    }
/**
     * Método que permite actualizar un Contrato
     * @param metodo
     * @return 
     */
    public String actualizarContratos(ContratosEntity objeto){
        String rta="";
        try {            
            if (portProveedores().actualizarContrato(objeto) != null) {
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