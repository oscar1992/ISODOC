package co.com.siscomputo.gestiondocumental.logic;

import co.com.siscomputo.endpoint.Administacion;
import co.com.siscomputo.endpoint.Administacion_Service;
import co.com.siscomputo.endpoint.GrupoDocumentoEntity;
import co.com.siscomputo.utilidades.IurlWebService;
import co.com.siscomputo.utilidades.SingletonDirecciones;
import java.util.ArrayList;
import java.util.List;
import javax.xml.ws.BindingProvider;

/**
 *
 * @author LENOVO
 */
public class GrupoDocumentoLogic implements IurlWebService{

    private List grupoDocumento;



    public List getGrupoDocumento() {
        return grupoDocumento;
    }

    public void setGrupoDocumento(List grupoDocumento) {
        this.grupoDocumento = grupoDocumento;
    }

    /**
     * Método que trae una lista de Grupos por Documento
     *
     * @return
     */
    public ArrayList<GrupoDocumentoEntity> listaGrupoDocumento() {
        
        ArrayList<GrupoDocumentoEntity> listaaux = new ArrayList<>();
        ArrayList<Object> listaObjeto = (ArrayList<Object>) portAdministracion().listaGrupoDocumento().getRetorna();
        for (Object obj : listaObjeto) {
            GrupoDocumentoEntity objectgrupoDocumento = (GrupoDocumentoEntity) obj;
            listaaux.add(objectgrupoDocumento);
        }
        return listaaux;
    }

    /**
     * Método que permite ingresar un Grupos por Documentonuevo
     *
     * @param objeto
     * @return
     */
    public GrupoDocumentoEntity insertarGrupoDocumento(GrupoDocumentoEntity objeto) {
        GrupoDocumentoEntity dispoRta = null;
        try {
            
            //System.out.println("OBJETOT: "+objeto.getFecha().toString());
            dispoRta = portAdministracion().insertarGrupoDocumento(objeto);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dispoRta;
    }

    /**
     * Método que permite actualizar un Grupos por Documento
     *
     * @param metodo
     * @return
     */
    public String actualizarGrupoDocumento(GrupoDocumentoEntity objeto) {
        
        String rta = "";
        try {
            if (portAdministracion().actualizarGrupoDocumento(objeto) != null) {
                rta = "Ok";
            } else {
                rta = "Error";
            }
        } catch (Exception e) {
            rta = "Error";
            e.printStackTrace();
        }
        return rta;
    }
}
