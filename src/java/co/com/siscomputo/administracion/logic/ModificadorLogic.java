package co.com.siscomputo.administracion.logic;

import co.com.siscomputo.endpoint.Administacion;
import co.com.siscomputo.endpoint.Administacion_Service;
import co.com.siscomputo.endpoint.ModificadorEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public class ModificadorLogic {private Administacion_Service webService;
    private Administacion port;
    private List modificador;
    
    /**
     * Funcion con la cual inicializo el service y el port de los WebServices
     */
    public void webService() {
        webService = new Administacion_Service();
        port = webService.getAdministacionPort();
    }

    public List getModificador() {
        return modificador;
    }

    public void setModificador(List modificador) {
        this.modificador = modificador;
    }
    
    /**
     * Método que trae una lista de Aprobador Modificador
     * @return 
     */
    public ArrayList<ModificadorEntity> listaModificador(){
        webService();
        ArrayList<ModificadorEntity> listaaux=new ArrayList<>();
        ArrayList<Object> listaObjeto =(ArrayList<Object>) port.listaModificador().getRetorna();
        for(Object obj:listaObjeto){
            ModificadorEntity objectmodificador=(ModificadorEntity) obj;
            listaaux.add(objectmodificador);
        }
        return listaaux;
    }
/**
     * Método que permite ingresar un Aprobador Modificadornuevo
     * @param objeto
     * @return 
     */
    public ModificadorEntity insertarModificador(ModificadorEntity objeto){
        webService();
        ModificadorEntity dispoRta=null;        
        try {
            dispoRta = port.insertarModificador(objeto);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dispoRta;
    }
/**
     * Método que permite actualizar un Aprobador Modificador
     * @param metodo
     * @return 
     */
    public String actualizarModificador(ModificadorEntity objeto){
        webService();
        String rta="";
        try {            
            if (port.actualizarModificador(objeto) != null) {
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
/**
     * Método que trae un solo Aprobador Modificador por ID
     * @param modificador
     * @return 
     */
    public ModificadorEntity modificadorPorID(int modificador){
        webService();
        return port.modificadorPorId(modificador);
    }
}