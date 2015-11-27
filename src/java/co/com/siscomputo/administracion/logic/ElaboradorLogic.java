package co.com.siscomputo.administracion.logic;

import co.com.siscomputo.endpoint.Administacion;
import co.com.siscomputo.endpoint.Administacion_Service;
import co.com.siscomputo.endpoint.ElaboradorEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public class ElaboradorLogic {private Administacion_Service webService;
    private Administacion port;
    private List elaborador;
    
    /**
     * Funcion con la cual inicializo el service y el port de los WebServices
     */
    public void webService() {
        webService = new Administacion_Service();
        port = webService.getAdministacionPort();
    }

    public List getElaborador() {
        return elaborador;
    }

    public void setElaborador(List elaborador) {
        this.elaborador = elaborador;
    }
    
    /**
     * Método que trae una lista de Aprobador Elaborador
     * @return 
     */
    public ArrayList<ElaboradorEntity> listaElaborador(){
        webService();
        ArrayList<ElaboradorEntity> listaaux=new ArrayList<>();
        ArrayList<Object> listaObjeto =(ArrayList<Object>) port.listaElaborador().getRetorna();
        for(Object obj:listaObjeto){
            ElaboradorEntity objectelaborador=(ElaboradorEntity) obj;
            listaaux.add(objectelaborador);
        }
        return listaaux;
    }
/**
     * Método que permite ingresar un Aprobador Elaboradornuevo
     * @param objeto
     * @return 
     */
    public ElaboradorEntity insertarElaborador(ElaboradorEntity objeto){
        webService();
        ElaboradorEntity dispoRta=null;        
        try {
            dispoRta = port.insertarElaborador(objeto);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dispoRta;
    }
/**
     * Método que permite actualizar un Aprobador Elaborador
     * @param metodo
     * @return 
     */
    public String actualizarElaborador(ElaboradorEntity objeto){
        webService();
        String rta="";
        try {            
            if (port.actualizarElaborador(objeto) != null) {
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
     * Método que trae un solo Aprobador Elaborador por ID
     * @param elaborador
     * @return 
     */
    public ElaboradorEntity elaboradorPorID(int elaborador){
        webService();
        return port.elaboradorPorId(elaborador);
    }
}