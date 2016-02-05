package co.com.siscomputo.proveedores.logic;

import co.com.siscomputo.endpoint.TipoDocumentoEntity;
import co.com.siscomputo.utilidades.IurlWebService;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public class TipoDocumentoLogic implements IurlWebService{
    private List tipoDocumento;
    
    /**
     * Funcion con la cual inicializo el service y el port de los WebServices
     */

    public List getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(List tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }
    
    /**
     * Método que trae una lista de Tipo de Documento
     * @return 
     */
    public ArrayList<TipoDocumentoEntity> listaTipoDocumento(){
        ArrayList<TipoDocumentoEntity> listaaux=new ArrayList<>();
        ArrayList<Object> listaObjeto =(ArrayList<Object>) portProveedores().listaTipoDocumento().getRetorna();
        for(Object obj:listaObjeto){
            TipoDocumentoEntity objecttipoDocumento=(TipoDocumentoEntity) obj;
            listaaux.add(objecttipoDocumento);
        }
        return listaaux;
    }
/**
     * Método que permite ingresar un Tipo de Documentonuevo
     * @param objeto
     * @return 
     */
    public TipoDocumentoEntity insertarTipoDocumento(TipoDocumentoEntity objeto){
        TipoDocumentoEntity dispoRta=null;        
        try {
            dispoRta = portProveedores().insertarTipoDocumento(objeto);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dispoRta;
    }
/**
     * Método que permite actualizar un Tipo de Documento
     * @param metodo
     * @return 
     */
    public String actualizarTipoDocumento(TipoDocumentoEntity objeto){
        String rta="";
        try {            
            if (portProveedores().actualizarTipoDocumento(objeto) != null) {
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