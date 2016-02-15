package co.com.siscomputo.proveedores.logic;

import co.com.siscomputo.endpoint.FormasPagoEntity;
import co.com.siscomputo.utilidades.IurlWebService;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public class FormasPagoLogic implements IurlWebService{
    private List formasPago;
    
    /**
     * Funcion con la cual inicializo el service y el port de los WebServices
     */

    public List getFormasPago() {
        return formasPago;
    }

    public void setFormasPago(List formasPago) {
        this.formasPago = formasPago;
    }
    
    /**
     * Método que trae una lista de Forma de Pago
     * @return 
     */
    public ArrayList<FormasPagoEntity> listaFormasPago(){
        ArrayList<FormasPagoEntity> listaaux=new ArrayList<>();
        ArrayList<Object> listaObjeto =(ArrayList<Object>) portProveedores().listaFormaPago().getRetorna();
        for(Object obj:listaObjeto){
            FormasPagoEntity objectformasPago=(FormasPagoEntity) obj;
            listaaux.add(objectformasPago);
        }
        return listaaux;
    }
/**
     * Método que permite ingresar un Forma de Pagonuevo
     * @param objeto
     * @return 
     */
    public FormasPagoEntity insertarFormasPago(FormasPagoEntity objeto){
        FormasPagoEntity dispoRta=null;        
        try {
            dispoRta = portProveedores().insertarFormaPago(objeto);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dispoRta;
    }
/**
     * Método que permite actualizar un Forma de Pago
     * @param metodo
     * @return 
     */
    public String actualizarFormasPago(FormasPagoEntity objeto){
        String rta="";
        try {            
            if (portProveedores().actualizarFormaPago(objeto) != null) {
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