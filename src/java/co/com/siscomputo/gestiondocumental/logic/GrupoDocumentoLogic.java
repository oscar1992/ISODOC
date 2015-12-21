package co.com.siscomputo.gestiondocumental.logic;

import co.com.siscomputo.endpoint.Administacion;
import co.com.siscomputo.endpoint.Administacion_Service;
import co.com.siscomputo.endpoint.GrupoDocumentoEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public class GrupoDocumentoLogic {private Administacion_Service webService;
    private Administacion port;
    private List grupoDocumento;
    
    /**
     * Funcion con la cual inicializo el service y el port de los WebServices
     */
    public void webService() {
        webService = new Administacion_Service();
        port = webService.getAdministacionPort();
    }

    public List getGrupoDocumento() {
        return grupoDocumento;
    }

    public void setGrupoDocumento(List grupoDocumento) {
        this.grupoDocumento = grupoDocumento;
    }
    
    /**
     * Método que trae una lista de Grupos por Documento
     * @return 
     */
    public ArrayList<GrupoDocumentoEntity> listaGrupoDocumento(){
        webService();
        ArrayList<GrupoDocumentoEntity> listaaux=new ArrayList<>();
        ArrayList<Object> listaObjeto =(ArrayList<Object>) port.listaGrupoDocumento().getRetorna();
        for(Object obj:listaObjeto){
            GrupoDocumentoEntity objectgrupoDocumento=(GrupoDocumentoEntity) obj;
            listaaux.add(objectgrupoDocumento);
        }
        return listaaux;
    }
/**
     * Método que permite ingresar un Grupos por Documentonuevo
     * @param objeto
     * @return 
     */
    public GrupoDocumentoEntity insertarGrupoDocumento(GrupoDocumentoEntity objeto){
        webService();
        GrupoDocumentoEntity dispoRta=null;        
        try {
            dispoRta = port.insertarGrupoDocumento(objeto);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dispoRta;
    }
/**
     * Método que permite actualizar un Grupos por Documento
     * @param metodo
     * @return 
     */
    public String actualizarGrupoDocumento(GrupoDocumentoEntity objeto){
        webService();
        String rta="";
        try {            
            if (port.actualizarGrupoDocumento(objeto) != null) {
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