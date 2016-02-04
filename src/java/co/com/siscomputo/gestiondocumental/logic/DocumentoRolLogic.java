package co.com.siscomputo.gestiondocumental.logic;

import co.com.siscomputo.endpoint.DocumentoRolEntity;
import co.com.siscomputo.utilidades.IurlWebService;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public class DocumentoRolLogic implements IurlWebService{

    private List documentoRol;
    


    public List getDocumentoRol() {
        return documentoRol;
    }

    public void setDocumentoRol(List documentoRol) {
        this.documentoRol = documentoRol;
    }
    
    /**
     * Método que trae una lista de Documentos Rol
     * @return 
     */
    public ArrayList<DocumentoRolEntity> listaDocumentoRol(){
        
        ArrayList<DocumentoRolEntity> listaaux=new ArrayList<>();
        ArrayList<Object> listaObjeto =(ArrayList<Object>) portGestion().listaDocumentoRol().getRetorna();
        for(Object obj:listaObjeto){
            DocumentoRolEntity objectdocumentoRol=(DocumentoRolEntity) obj;
            listaaux.add(objectdocumentoRol);
        }
        return listaaux;
    }
/**
     * Método que permite ingresar un Documentos Rolnuevo
     * @param objeto
     * @return 
     */
    public DocumentoRolEntity insertarDocumentoRol(DocumentoRolEntity objeto){
        
        DocumentoRolEntity dispoRta=null;        
        try {
            dispoRta = portGestion().insertarDocumentoRol(objeto);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dispoRta;
    }
/**
     * Método que permite actualizar un Documentos Rol
     * @param metodo
     * @return 
     */
    public String actualizarDocumentoRol(DocumentoRolEntity objeto){
        
        String rta="";
        try {            
            if (portGestion().actualizarDocumentoRol(objeto) != null) {
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