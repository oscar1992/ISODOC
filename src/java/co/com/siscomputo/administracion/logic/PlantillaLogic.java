package co.com.siscomputo.administracion.logic;

import co.com.siscomputo.endpoint.PlantillaEntity;
import co.com.siscomputo.utilidades.IurlWebService;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public class PlantillaLogic implements IurlWebService{

    private List plantilla;
 

    public List getPlantilla() {
        return plantilla;
    }

    public void setPlantilla(List plantilla) {
        this.plantilla = plantilla;
    }
    
    /**
     * Método que trae una lista de Plantilla de Gestión Documental
     * @return 
     */
    public ArrayList<PlantillaEntity> listaPlantilla(){
        
        ArrayList<PlantillaEntity> listaaux=new ArrayList<>();
        ArrayList<Object> listaObjeto =(ArrayList<Object>) portAdministracion().listaPlantilla().getRetorna();
        for(Object obj:listaObjeto){
            PlantillaEntity objectplantilla=(PlantillaEntity) obj;
            listaaux.add(objectplantilla);
        }
        return listaaux;
    }
/**
     * Método que permite ingresar un Plantilla de Gestión Documentalnuevo
     * @param objeto
     * @return 
     */
    public PlantillaEntity insertarPlantilla(PlantillaEntity objeto){
        
        PlantillaEntity dispoRta=null;        
        try {
            dispoRta = portAdministracion().insertarPlantilla(objeto);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dispoRta;
    }
/**
     * Método que permite actualizar un Plantilla de Gestión Documental
     * @param metodo
     * @return 
     */
    public String actualizarPlantilla(PlantillaEntity objeto){
        
        String rta="";
        try {            
            if (portAdministracion().actualizarPlantilla(objeto) != null) {
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
     * Método que devuelve una plantilla seleccionada por su ID
     * @param idPlantilla
     * @return 
     */
    public PlantillaEntity PlantillaPorId(int idPlantilla){
        
        return portAdministracion().plantillaPorIdlantilla(idPlantilla);
    }
}