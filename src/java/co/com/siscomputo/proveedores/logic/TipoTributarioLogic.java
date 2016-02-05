package co.com.siscomputo.proveedores.logic;

import co.com.siscomputo.endpoint.TipoTributarioEntity;
import co.com.siscomputo.utilidades.IurlWebService;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public class TipoTributarioLogic implements IurlWebService {

    private List tipoTributario;

    /**
     * Funcion con la cual inicializo el service y el port de los WebServices
     */
    public List getTipoTributario() {
        return tipoTributario;
    }

    public void setTipoTributario(List tipoTributario) {
        this.tipoTributario = tipoTributario;
    }

    /**
     * Método que trae una lista de Tipo Tributario
     *
     * @return
     */
    public ArrayList<TipoTributarioEntity> listaTipoTributario() {
        ArrayList<TipoTributarioEntity> listaaux = new ArrayList<>();
        ArrayList<Object> listaObjeto = (ArrayList<Object>) portProveedores().listaTipoTributario().getRetorna();
        for (Object obj : listaObjeto) {
            TipoTributarioEntity objecttipoTributario = (TipoTributarioEntity) obj;
            listaaux.add(objecttipoTributario);
        }
        return listaaux;
    }

    /**
     * Método que permite ingresar un Tipo Tributarionuevo
     *
     * @param objeto
     * @return
     */
    public TipoTributarioEntity insertarTipoTributario(TipoTributarioEntity objeto) {
        TipoTributarioEntity dispoRta = null;
        try {
            dispoRta = portProveedores().insertarTipoTributario(objeto);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dispoRta;
    }

    /**
     * Método que permite actualizar un Tipo Tributario
     *
     * @param metodo
     * @return
     */
    public String actualizarTipoTributario(TipoTributarioEntity objeto) {
        String rta = "";
        try {
            if (portProveedores().actualizarTipoTributario(objeto) != null) {
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
