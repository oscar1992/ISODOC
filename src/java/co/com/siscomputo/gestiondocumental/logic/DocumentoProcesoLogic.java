package co.com.siscomputo.gestiondocumental.logic;

import co.com.siscomputo.endpoint.Administacion;
import co.com.siscomputo.endpoint.Administacion_Service;
import co.com.siscomputo.endpoint.DocumentoProcesoEntity;
import co.com.siscomputo.endpoint.GestionDocumental;
import co.com.siscomputo.endpoint.GestionDocumental_Service;
import co.com.siscomputo.utilidades.IurlWebService;
import co.com.siscomputo.utilidades.SingletonDirecciones;
import java.util.ArrayList;
import java.util.List;
import javax.xml.ws.BindingProvider;

/**
 *
 * @author LENOVO
 */
public class DocumentoProcesoLogic implements IurlWebService{

    
    private List documentoProceso;


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
        
        ArrayList<DocumentoProcesoEntity> listaaux=new ArrayList<>();
        ArrayList<Object> listaObjeto =(ArrayList<Object>) portGestion().listaDocumentoProceso().getRetorna();
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
        
        DocumentoProcesoEntity dispoRta=null;        
        try {
            dispoRta = portGestion().insertarDocumentoProceso(objeto);
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
        
        String rta="";
        try {            
            if (portGestion().actualizarDocumentoProceso(objeto) != null) {
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