package co.com.siscomputo.gestiondocumental.logic;

import co.com.siscomputo.endpoint.Administacion;
import co.com.siscomputo.endpoint.Administacion_Service;
import co.com.siscomputo.endpoint.DocumentoProcesoEntity;
import co.com.siscomputo.endpoint.GestionDocumental;
import co.com.siscomputo.endpoint.GestionDocumental_Service;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public class DocumentoProcesoLogic {
    private GestionDocumental_Service webService;
    private GestionDocumental port;
    private List documentoProceso;
    
    /**
     * Funcion con la cual inicializo el service y el port de los WebServices
     */
    public void webService() {
        webService = new GestionDocumental_Service();
        port = webService.getGestionDocumentalPort();
    }

    public List getDocumentoProceso() {
        return documentoProceso;
    }

    public void setDocumentoProceso(List documentoProceso) {
        this.documentoProceso = documentoProceso;
    }
    
    /**
     * Método que trae una lista de Usuarios Asignados Sobre el Documento
     * @return 
     */
    public ArrayList<DocumentoProcesoEntity> listaDocumentoProceso(){
        webService();
        ArrayList<DocumentoProcesoEntity> listaaux=new ArrayList<>();
        ArrayList<Object> listaObjeto =(ArrayList<Object>) port.listaDocumentoProceso().getRetorna();
        for(Object obj:listaObjeto){
            DocumentoProcesoEntity objectdocumentoProceso=(DocumentoProcesoEntity) obj;
            listaaux.add(objectdocumentoProceso);
        }
        return listaaux;
    }
/**
     * Método que permite ingresar un Usuarios Asignados Sobre el Documentonuevo
     * @param objeto
     * @return 
     */
    public DocumentoProcesoEntity insertarDocumentoProceso(DocumentoProcesoEntity objeto){
        webService();
        DocumentoProcesoEntity dispoRta=null;        
        try {
            dispoRta = port.insertarDocumentoProceso(objeto);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dispoRta;
    }
/**
     * Método que permite actualizar un Usuarios Asignados Sobre el Documento
     * @param metodo
     * @return 
     */
    public String actualizarDocumentoProceso(DocumentoProcesoEntity objeto){
        webService();
        String rta="";
        try {            
            if (port.actualizarDocumentoProceso(objeto) != null) {
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