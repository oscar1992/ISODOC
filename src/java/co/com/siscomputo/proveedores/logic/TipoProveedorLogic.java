package co.com.siscomputo.proveedores.logic;

import co.com.siscomputo.endpoint.TipoProveedorEntity;
import co.com.siscomputo.utilidades.IurlWebService;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public class TipoProveedorLogic implements IurlWebService {

    private List tipoProveedor;

    /**
     * Funcion con la cual inicializo el service y el port de los WebServices
     */
    public List getTipoProveedor() {
        return tipoProveedor;
    }

    public void setTipoProveedor(List tipoProveedor) {
        this.tipoProveedor = tipoProveedor;
    }

    /**
     * Método que trae una lista de Tipo de Proveedor
     *
     * @return
     */
    public ArrayList<TipoProveedorEntity> listaTipoProveedor() {
        ArrayList<TipoProveedorEntity> listaaux = new ArrayList<>();
        ArrayList<Object> listaObjeto = (ArrayList<Object>) portProveedores().listaTipoProveedor().getRetorna();
        for (Object obj : listaObjeto) {
            TipoProveedorEntity objecttipoProveedor = (TipoProveedorEntity) obj;
            listaaux.add(objecttipoProveedor);
        }
        return listaaux;
    }

    /**
     * Método que permite ingresar un Tipo de Proveedornuevo
     *
     * @param objeto
     * @return
     */
    public TipoProveedorEntity insertarTipoProveedor(TipoProveedorEntity objeto) {
        TipoProveedorEntity dispoRta = null;
        try {
            dispoRta = portProveedores().insertarTipoProveedor(objeto);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dispoRta;
    }

    /**
     * Método que permite actualizar un Tipo de Proveedor
     *
     * @param metodo
     * @return
     */
    public String actualizarTipoProveedor(TipoProveedorEntity objeto) {
        String rta = "";
        try {
            if (portProveedores().actualizarTipoProveedor(objeto) != null) {
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
