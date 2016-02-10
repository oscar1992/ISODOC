package co.com.siscomputo.proveedores.logic;

import co.com.siscomputo.endpoint.CuentasProveedoresEntity;
import co.com.siscomputo.utilidades.IurlWebService;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public class CuentasProveedoresLogic implements IurlWebService {

    private List cuentasProveedores;

    /**
     * Funcion con la cual inicializo el service y el port de los WebServices
     */
    public List getCuentasProveedores() {
        return cuentasProveedores;
    }

    public void setCuentasProveedores(List cuentasProveedores) {
        this.cuentasProveedores = cuentasProveedores;
    }

    /**
     * Método que trae una lista de Tipo de Cuenta de Proveedor
     *
     * @return
     */
    public ArrayList<CuentasProveedoresEntity> listaCuentasProveedores() {
        ArrayList<CuentasProveedoresEntity> listaaux = new ArrayList<>();
        ArrayList<Object> listaObjeto = (ArrayList<Object>) portProveedores().listaCuentasProveedores().getRetorna();
        for (Object obj : listaObjeto) {
            CuentasProveedoresEntity objectcuentasProveedores = (CuentasProveedoresEntity) obj;
            listaaux.add(objectcuentasProveedores);
        }
        return listaaux;
    }

    /**
     * Método que permite ingresar un Tipo de Cuenta de Proveedornuevo
     *
     * @param objeto
     * @return
     */
    public CuentasProveedoresEntity insertarCuentasProveedores(CuentasProveedoresEntity objeto) {
        CuentasProveedoresEntity dispoRta = null;
        try {
            dispoRta = portProveedores().insertarCuentasProveedores(objeto);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dispoRta;
    }

    /**
     * Método que permite actualizar un Tipo de Cuenta de Proveedor
     *
     * @param metodo
     * @return
     */
    public String actualizarCuentasProveedores(CuentasProveedoresEntity objeto) {
        String rta = "";
        try {
            if (portProveedores().actualizarCuentasProveedores(objeto) != null) {
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
