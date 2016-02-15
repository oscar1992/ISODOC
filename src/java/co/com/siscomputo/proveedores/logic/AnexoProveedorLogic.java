package co.com.siscomputo.proveedores.logic;

import co.com.siscomputo.endpoint.AnexoProveedorEntity;
import co.com.siscomputo.utilidades.IurlWebService;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public class AnexoProveedorLogic implements IurlWebService{
    private List anexoProveedor;
    
    /**
     * Funcion con la cual inicializo el service y el port de los WebServices
     */

    public List getAnexoProveedor() {
        return anexoProveedor;
    }

    public void setAnexoProveedor(List anexoProveedor) {
        this.anexoProveedor = anexoProveedor;
    }
    
    /**
     * Método que trae una lista de Anexos del proveedor
     * @return 
     */
    public ArrayList<AnexoProveedorEntity> listaAnexoProveedor(){
        ArrayList<AnexoProveedorEntity> listaaux=new ArrayList<>();
        ArrayList<Object> listaObjeto =(ArrayList<Object>) portProveedores().listaAnexoProveedor().getRetorna();
        for(Object obj:listaObjeto){
            AnexoProveedorEntity objectanexoProveedor=(AnexoProveedorEntity) obj;
            listaaux.add(objectanexoProveedor);
        }
        return listaaux;
    }
/**
     * Método que permite ingresar un Anexos del proveedornuevo
     * @param objeto
     * @return 
     */
    public AnexoProveedorEntity insertarAnexoProveedor(AnexoProveedorEntity objeto){
        AnexoProveedorEntity dispoRta=null;        
        try {
            dispoRta = portProveedores().insertarAnexoProveedor(objeto);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dispoRta;
    }
/**
     * Método que permite actualizar un Anexos del proveedor
     * @param metodo
     * @return 
     */
    public String actualizarAnexoProveedor(AnexoProveedorEntity objeto){
        String rta="";
        try {            
            if (portProveedores().actualizarAnexoProveedor(objeto) != null) {
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