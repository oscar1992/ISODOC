package co.com.siscomputo.proveedores.logic;

import co.com.siscomputo.endpoint.ProveedoresEntity;
import co.com.siscomputo.utilidades.IurlWebService;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public class ProveedoresLogic implements IurlWebService{
    private List proveedores;
    
    /**
     * Funcion con la cual inicializo el service y el port de los WebServices
     * @return 
     */
    public List getProveedores() {
        return proveedores;
    }

    public void setProveedores(List proveedores) {
        this.proveedores = proveedores;
    }
    
    /**
     * Método que trae una lista de Proveedor
     * @return 
     */
    public ArrayList<ProveedoresEntity> listaProveedores(){
        ArrayList<ProveedoresEntity> listaaux=new ArrayList<>();
        ArrayList<Object> listaObjeto =(ArrayList<Object>) portProveedores().listaProveedor().getRetorna();
        for(Object obj:listaObjeto){
            ProveedoresEntity objectproveedores=(ProveedoresEntity) obj;
            listaaux.add(objectproveedores);
        }
        return listaaux;
    }
/**
     * Método que permite ingresar un Proveedornuevo
     * @param objeto
     * @return 
     */
    public ProveedoresEntity insertarProveedores(ProveedoresEntity objeto){
        ProveedoresEntity dispoRta=null;        
        try {
            dispoRta = portProveedores().insertarProveedor(objeto);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dispoRta;
    } 
/**
     * Método que permite actualizar un Proveedor
     * @param objeto
     * @return 
     */
    public String actualizarProveedores(ProveedoresEntity objeto){
        String rta="";
        try {            
            if (portProveedores().actualizarProveedor(objeto) != null) {
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