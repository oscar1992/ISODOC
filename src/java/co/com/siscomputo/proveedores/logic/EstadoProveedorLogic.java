package co.com.siscomputo.proveedores.logic;

import co.com.siscomputo.endpoint.EstadoProveedorEntity;
import co.com.siscomputo.utilidades.IurlWebService;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public class EstadoProveedorLogic implements IurlWebService {

    private List estadoProveedor;

    /**
     * Funcion con la cual inicializo el service y el port de los WebServices
     */
    public List getEstadoProveedor() {
        return estadoProveedor;
    }

    public void setEstadoProveedor(List estadoProveedor) {
        this.estadoProveedor = estadoProveedor;
    }

    /**
     * Método que trae una lista de Estado de Proveedor
     *
     * @return
     */
    public ArrayList<EstadoProveedorEntity> listaEstadoProveedor() {
        ArrayList<EstadoProveedorEntity> listaaux = new ArrayList<>();
        ArrayList<Object> listaObjeto = (ArrayList<Object>) portProveedores().listaEstadoProveedor().getRetorna();
        for (Object obj : listaObjeto) {
            EstadoProveedorEntity objectestadoProveedor = (EstadoProveedorEntity) obj;
            listaaux.add(objectestadoProveedor);
        }
        return listaaux;
    }

    /**
     * Método que permite ingresar un Estado de Proveedornuevo
     *
     * @param objeto
     * @return
     */
    public EstadoProveedorEntity insertarEstadoProveedor(EstadoProveedorEntity objeto) {
        EstadoProveedorEntity dispoRta = null;
        try {
            dispoRta = portProveedores().insertarEstadoProveedor(objeto);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dispoRta;
    }

    /**
     * Método que permite actualizar un Estado de Proveedor
     *
     * @param metodo
     * @return
     */
    public String actualizarEstadoProveedor(EstadoProveedorEntity objeto) {
        String rta = "";
        try {
            if (portProveedores().actualizarEstadoProveedor(objeto) != null) {
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
