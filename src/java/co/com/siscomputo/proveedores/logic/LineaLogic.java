package co.com.siscomputo.proveedores.logic;

import co.com.siscomputo.endpoint.LineaEntity;
import co.com.siscomputo.utilidades.IurlWebService;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public class LineaLogic implements IurlWebService {

    private List linea;

    /**
     * Funcion con la cual inicializo el service y el port de los WebServices
     */
    public List getLinea() {
        return linea;
    }

    public void setLinea(List linea) {
        this.linea = linea;
    }

    /**
     * Método que trae una lista de Linea del Proveedor
     *
     * @return
     */
    public ArrayList<LineaEntity> listaLinea() {
        ArrayList<LineaEntity> listaaux = new ArrayList<>();
        ArrayList<Object> listaObjeto = (ArrayList<Object>) portProveedores().listaLinea().getRetorna();
        for (Object obj : listaObjeto) {
            LineaEntity objectlinea = (LineaEntity) obj;
            listaaux.add(objectlinea);
        }
        return listaaux;
    }

    /**
     * Método que permite ingresar un Linea del Proveedornuevo
     *
     * @param objeto
     * @return
     */
    public LineaEntity insertarLinea(LineaEntity objeto) {
        LineaEntity dispoRta = null;
        try {
            dispoRta = portProveedores().insertarLinea(objeto);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dispoRta;
    }

    /**
     * Método que permite actualizar un Linea del Proveedor
     *
     * @param metodo
     * @return
     */
    public String actualizarLinea(LineaEntity objeto) {
        String rta = "";
        try {
            if (portProveedores().actualizarLinea(objeto) != null) {
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
