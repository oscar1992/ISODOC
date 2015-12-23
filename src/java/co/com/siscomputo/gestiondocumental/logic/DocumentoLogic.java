package co.com.siscomputo.gestiondocumental.logic;

import co.com.siscomputo.endpoint.AccionEntity;
import co.com.siscomputo.endpoint.DocumentoEntity;
import co.com.siscomputo.endpoint.GestionDocumental;
import co.com.siscomputo.endpoint.GestionDocumental_Service;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public class DocumentoLogic {
    private GestionDocumental_Service webService;
    private GestionDocumental port;
    private List documento;
    
    /**
     * Funcion con la cual inicializo el service y el port de los WebServices
     */
    public void webService() {
        webService = new GestionDocumental_Service();
        port = webService.getGestionDocumentalPort();
    }

    public List getDocumento() {
        return documento;
    }

    public void setDocumento(List documento) {
        this.documento = documento;
    }
    
    /**
     * Método que trae una lista de Documento
     * @return 
     */
    public ArrayList<DocumentoEntity> listaDocumento(){
        webService();
        ArrayList<DocumentoEntity> listaaux=new ArrayList<>();
        ArrayList<Object> listaObjeto =(ArrayList<Object>) port.listaDocumento().getRetorna();
        for(Object obj:listaObjeto){
            DocumentoEntity objectdocumento=(DocumentoEntity) obj;
            listaaux.add(objectdocumento);
        }
        return listaaux;
    }
/**
     * Método que permite ingresar un Documentonuevo
     * @param objeto
     * @return 
     */
    public DocumentoEntity insertarDocumento(DocumentoEntity objeto){
        webService();
        DocumentoEntity dispoRta=null;        
        try {
            dispoRta = port.insertarDocumento(objeto);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dispoRta;
    }
/**
     * Método que permite actualizar un Documento
     * @param metodo
     * @return 
     */
    public String actualizarDocumento(DocumentoEntity objeto){
        webService();
        String rta="";
        try {            
            if (port.actualizarDocumento(objeto) != null) {
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
    
    public ArrayList<DocumentoEntity> documetosPorAccion(AccionEntity accion){
        webService();
        ArrayList<DocumentoEntity> listaretorna=new ArrayList<>();
        try {
            ArrayList<Object>listaObjeto=new ArrayList<>();
            listaObjeto=(ArrayList<Object>) port.listaDocumentoPorAccion(accion).getRetorna();
            for(Object obj:listaObjeto){
                DocumentoEntity documentoEntity=(DocumentoEntity) obj;
                listaretorna.add(documentoEntity);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaretorna;
    }
}