package co.com.siscomputo.administracion.logic;

import co.com.siscomputo.endpoint.Administacion;
import co.com.siscomputo.endpoint.Administacion_Service;
import co.com.siscomputo.endpoint.NivelEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public class NivelLogic {

    private Administacion_Service webService;
    private Administacion port;
    private List nivel;

    /**
     * Funcion con la cual inicializo el service y el port de los WebServices
     */
    public void webService() {
        webService = new Administacion_Service();
        port = webService.getAdministacionPort();
    }

    public List getNivel() {
        return nivel;
    }

    public void setNivel(List nivel) {
        this.nivel = nivel;
    }

    /**
     * Método que trae una lista de Nivel de Proceso
     *
     * @return
     */
    public ArrayList<NivelEntity> listaNivel() {
        webService();
        ArrayList<NivelEntity> listaaux = new ArrayList<>();
        ArrayList<Object> listaObjeto = (ArrayList<Object>) port.listaNivel().getRetorna();
        for (Object obj : listaObjeto) {
            NivelEntity objectnivel = (NivelEntity) obj;
            listaaux.add(objectnivel);
        }
        return listaaux;
    }

    /**
     * Método que permite ingresar un Nivel de Procesonuevo
     *
     * @param objeto
     * @return
     */
    public NivelEntity insertarNivel(NivelEntity objeto) {
        webService();
        NivelEntity dispoRta = null;
        try {
            dispoRta = port.insertarNivel(objeto);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dispoRta;
    }

    /**
     * Método que permite actualizar un Nivel de Proceso
     *
     * @param metodo
     * @return
     */
    public String actualizarNivel(NivelEntity objeto) {
        webService();
        String rta = "";
        try {
            if (port.actualizarNivel(objeto) != null) {
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
