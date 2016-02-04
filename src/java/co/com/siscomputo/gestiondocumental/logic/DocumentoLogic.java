package co.com.siscomputo.gestiondocumental.logic;

import co.com.siscomputo.endpoint.AccionEntity;
import co.com.siscomputo.endpoint.DocumentoEntity;
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
public class DocumentoLogic implements IurlWebService{

    private List documento;
    
 

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
        
        ArrayList<DocumentoEntity> listaaux=new ArrayList<>();
        ArrayList<Object> listaObjeto =(ArrayList<Object>) portGestion().listaDocumento().getRetorna();
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
        
        DocumentoEntity dispoRta=null;        
        try {
            dispoRta = portGestion().insertarDocumento(objeto);
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
        
        String rta="";
        try {            
            if (portGestion().actualizarDocumento(objeto) != null) {
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
        
        ArrayList<DocumentoEntity> listaretorna=new ArrayList<>();
        try {
            ArrayList<Object>listaObjeto=new ArrayList<>();
            listaObjeto=(ArrayList<Object>) portGestion().listaDocumentoPorAccion(accion).getRetorna();
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