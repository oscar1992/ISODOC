package co.com.siscomputo.proveedores.logic;

import co.com.siscomputo.endpoint.TipoCuentaEntity;
import co.com.siscomputo.utilidades.IurlWebService;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public class TipoCuentaLogic implements IurlWebService{
    private List tipoCuenta;
    
    /**
     * Funcion con la cual inicializo el service y el port de los WebServices
     */

    public List getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(List tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }
    
    /**
     * Método que trae una lista de Tipo de Cuenta
     * @return 
     */
    public ArrayList<TipoCuentaEntity> listaTipoCuenta(){
        ArrayList<TipoCuentaEntity> listaaux=new ArrayList<>();
        ArrayList<Object> listaObjeto =(ArrayList<Object>) portProveedores().listaTipoCuenta().getRetorna();
        for(Object obj:listaObjeto){
            TipoCuentaEntity objecttipoCuenta=(TipoCuentaEntity) obj;
            listaaux.add(objecttipoCuenta);
        }
        return listaaux;
    }
/**
     * Método que permite ingresar un Tipo de Cuentanuevo
     * @param objeto
     * @return 
     */
    public TipoCuentaEntity insertarTipoCuenta(TipoCuentaEntity objeto){
        TipoCuentaEntity dispoRta=null;        
        try {
            dispoRta = portProveedores().insertarTipoCuenta(objeto);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dispoRta;
    }
/**
     * Método que permite actualizar un Tipo de Cuenta
     * @param metodo
     * @return 
     */
    public String actualizarTipoCuenta(TipoCuentaEntity objeto){
        String rta="";
        try {            
            if (portProveedores().actualizarTipoCuenta(objeto) != null) {
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