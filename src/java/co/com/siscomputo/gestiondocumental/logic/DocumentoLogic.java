package co.com.siscomputo.gestiondocumental.logic;

import co.com.siscomputo.endpoint.AccionEntity;
import co.com.siscomputo.endpoint.DocumentoEntity;
import co.com.siscomputo.utilidades.DateToCalendar;
import co.com.siscomputo.utilidades.IurlWebService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
     * Método que permite ingresar un Documentos nuevos
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
    /**
     * Llamado al web service que trae la lista de documentos filtrados
     * @param idTipoDocumental
     * @param idPlantilla
     * @param idAccion
     * @return 
     */
    public ArrayList<DocumentoEntity>documetosFiltrados(Integer idTipoDocumental, Integer idPlantilla, Integer idAccion, Date f1, Date f2){
        DateToCalendar dateToCalendar=new DateToCalendar();
        ArrayList<DocumentoEntity> listaretorna=new ArrayList<>();
        try {
            //System.out.println("F1: "+f1.toString());
            ArrayList<Object>listaObjeto=new ArrayList<>();
            listaObjeto=(ArrayList<Object>) portGestion().documetosFiltrados(idTipoDocumental, idPlantilla, idAccion, dateToCalendar.convertir(f1), dateToCalendar.convertir(f2)).getRetorna();
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