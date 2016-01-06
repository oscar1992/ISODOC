package co.com.siscomputo.gestiondocumental.logic;

import co.com.siscomputo.endpoint.Administacion;
import co.com.siscomputo.endpoint.Administacion_Service;
import co.com.siscomputo.endpoint.DocumentoRolEntity;
import co.com.siscomputo.endpoint.GestionDocumental;
import co.com.siscomputo.endpoint.GestionDocumental_Service;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public class DocumentoRolLogic {
    private GestionDocumental_Service webService;
    private GestionDocumental port;
    private List documentoRol;
    
    /**
     * Funcion con la cual inicializo el service y el port de los WebServices
     */
    public void webService() {
        webService = new GestionDocumental_Service();
        port = webService.getGestionDocumentalPort();
    }

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
        webService();
        ArrayList<DocumentoRolEntity> listaaux=new ArrayList<>();
        ArrayList<Object> listaObjeto =(ArrayList<Object>) port.listaDocumentoRol().getRetorna();
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
        webService();
        DocumentoRolEntity dispoRta=null;        
        try {
            dispoRta = port.insertarDocumentoRol(objeto);
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
        webService();
        String rta="";
        try {            
            if (port.actualizarDocumentoRol(objeto) != null) {
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