package co.com.siscomputo.administracion.logic;

import co.com.siscomputo.endpoint.NivelEntity;
import co.com.siscomputo.utilidades.IurlWebService;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public class NivelLogic implements IurlWebService{


    private List nivel;


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
        
        ArrayList<NivelEntity> listaaux = new ArrayList<>();
        ArrayList<Object> listaObjeto = (ArrayList<Object>) portAdministracion().listaNivel().getRetorna();
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
        
        NivelEntity dispoRta = null;
        try {
            dispoRta = portAdministracion().insertarNivel(objeto);
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
        
        String rta = "";
        try {
            if (portAdministracion().actualizarNivel(objeto) != null) {
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
    /**
     * Método que que trae un nivel por su ID     *
     * @param idNivel
     * @return
     */
    public NivelEntity nivelPorId(int idNivel) {
        
        NivelEntity dispoRta = null;
        try {
            dispoRta = portAdministracion().nivelPorId(idNivel);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dispoRta;
    }
    /**
     * Método que permite traer el nivel anterior al que se recibe de parametro por orden de Secuencia
     * @param idNivel
     * @return
     */
    public NivelEntity anterioNivel(int idNivel) {
        
        NivelEntity dispoRta = null;
        try {
            dispoRta = portAdministracion().anteriorNivel(idNivel);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dispoRta;
    }
}
