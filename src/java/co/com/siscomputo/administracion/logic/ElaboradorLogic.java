package co.com.siscomputo.administracion.logic;

import co.com.siscomputo.endpoint.ElaboradorEntity;
import co.com.siscomputo.utilidades.IurlWebService;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public class ElaboradorLogic implements IurlWebService{

    private List elaborador;
    

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
        
        ArrayList<ElaboradorEntity> listaaux=new ArrayList<>();
        ArrayList<Object> listaObjeto =(ArrayList<Object>) portAdministracion().listaElaborador().getRetorna();
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
        
        ElaboradorEntity dispoRta=null;        
        try {
            dispoRta = portAdministracion().insertarElaborador(objeto);
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
        
        String rta="";
        try {            
            if (portAdministracion().actualizarElaborador(objeto) != null) {
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
        
        return portAdministracion().elaboradorPorId(elaborador);
    }
}