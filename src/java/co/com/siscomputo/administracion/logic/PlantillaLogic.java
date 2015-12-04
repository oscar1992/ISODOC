package co.com.siscomputo.administracion.logic;

import co.com.siscomputo.endpoint.Administacion;
import co.com.siscomputo.endpoint.Administacion_Service;
import co.com.siscomputo.endpoint.PlantillaEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public class PlantillaLogic {
    private Administacion_Service webService;
    private Administacion port;
    private List plantilla;
    
    /**
     * Funcion con la cual inicializo el service y el port de los WebServices
     */
    public void webService() {
        webService = new Administacion_Service();
        port = webService.getAdministacionPort();
    }

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
        webService();
        ArrayList<PlantillaEntity> listaaux=new ArrayList<>();
        ArrayList<Object> listaObjeto =(ArrayList<Object>) port.listaPlantilla().getRetorna();
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
        webService();
        PlantillaEntity dispoRta=null;        
        try {
            dispoRta = port.insertarPlantilla(objeto);
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
        webService();
        String rta="";
        try {            
            if (port.actualizarPlantilla(objeto) != null) {
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
     */
    public PlantillaEntity PlantillaPorId(int idPlantilla){
        webService();
        return port.plantillaPorIdlantilla(idPlantilla);
    }
}