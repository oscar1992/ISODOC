package co.com.siscomputo.administracion.logic;

import co.com.siscomputo.endpoint.ExtensionesEntity;
import co.com.siscomputo.utilidades.IurlWebService;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public class ExtensionesLogic implements IurlWebService{

    private List extensiones;

    /**
     * Funcion con la cual inicializo el service y el port de los WebServices
     */
    public List getExtensiones() {
        return extensiones;
    }

    public void setExtensiones(List extensiones) {
        this.extensiones = extensiones;
    }

    /**
     * Método que trae una lista de Extensiones de Archivo
     *
     * @return
     */
    public ArrayList<ExtensionesEntity> listaExtensiones() {
        ArrayList<ExtensionesEntity> listaaux = new ArrayList<>();
        ArrayList<Object> listaObjeto = (ArrayList<Object>) portAdministracion().listaExtensiones().getRetorna();
        for (Object obj : listaObjeto) {
            ExtensionesEntity objectextensiones = (ExtensionesEntity) obj;
            listaaux.add(objectextensiones);
        }
        return listaaux;
    }

    /**
     * Método que permite ingresar un Extensiones de Archivonuevo
     *
     * @param objeto
     * @return
     */
    public ExtensionesEntity insertarExtensiones(ExtensionesEntity objeto) {
        ExtensionesEntity dispoRta = null;
        try {
            dispoRta = portAdministracion().insertarExtensiones(objeto);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dispoRta;
    }

    /**
     * Método que permite actualizar un Extensiones de Archivo     *
     * @param metodo
     * @return
     */
    public String actualizarExtensiones(ExtensionesEntity objeto) {
        String rta = "";
        try {
            if (portAdministracion().actualizarExtensiones(objeto) != null) {
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
