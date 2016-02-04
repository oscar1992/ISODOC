package co.com.siscomputo.administracion.logic;

import co.com.siscomputo.endpoint.ModificadorEntity;
import co.com.siscomputo.utilidades.IurlWebService;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public class ModificadorLogic implements IurlWebService{

    private List modificador;


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
        
        ArrayList<ModificadorEntity> listaaux=new ArrayList<>();
        ArrayList<Object> listaObjeto =(ArrayList<Object>) portAdministracion().listaModificador().getRetorna();
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
        
        ModificadorEntity dispoRta=null;        
        try {
            dispoRta = portAdministracion().insertarModificador(objeto);
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
        
        String rta="";
        try {            
            if (portAdministracion().actualizarModificador(objeto) != null) {
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
        
        return portAdministracion().modificadorPorId(modificador);
    }
}