package co.com.siscomputo.administracion.logic;

import co.com.siscomputo.endpoint.Administacion;
import co.com.siscomputo.endpoint.Administacion_Service;
import co.com.siscomputo.endpoint.GrupoUsuariosEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public class GrupoUsuariosLogic {
    private Administacion_Service webService;
    private Administacion port;
    private List grupoUsuarios;
    
    /**
     * Funcion con la cual inicializo el service y el port de los WebServices
     */
    public void webService() {
        webService = new Administacion_Service();
        port = webService.getAdministacionPort();
    }

    public List getGrupoUsuarios() {
        return grupoUsuarios;
    }

    public void setGrupoUsuarios(List grupoUsuarios) {
        this.grupoUsuarios = grupoUsuarios;
    }
    
    /**
     * Método que trae una lista de Grupo de Usuarios
     * @return 
     */
    public ArrayList<GrupoUsuariosEntity> listaGrupoUsuarios(){
        webService();
        ArrayList<GrupoUsuariosEntity> listaaux=new ArrayList<>();
        ArrayList<Object> listaObjeto =(ArrayList<Object>) port.listaGrupoUsuarios().getRetorna();
        for(Object obj:listaObjeto){
            GrupoUsuariosEntity objectgrupoUsuarios=(GrupoUsuariosEntity) obj;
            listaaux.add(objectgrupoUsuarios);
        }
        return listaaux;
    }
/**
     * Método que permite ingresar un Grupo de Usuariosnuevo
     * @param objeto
     * @return 
     */
    public GrupoUsuariosEntity insertarGrupoUsuarios(GrupoUsuariosEntity objeto){
        webService();
        GrupoUsuariosEntity dispoRta=null;        
        try {
            dispoRta = port.insertarGrupoUsuarios(objeto);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dispoRta;
    }
/**
     * Método que permite actualizar un Grupo de Usuarios
     * @param metodo
     * @return 
     */
    public String actualizarGrupoUsuarios(GrupoUsuariosEntity objeto){
        webService();
        String rta="";
        try {            
            if (port.actualizarGrupoUsuarios(objeto) != null) {
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
    
    public GrupoUsuariosEntity grupoPorId(int idGrupo){
        webService();
        GrupoUsuariosEntity grupoUsuariosEntity=new GrupoUsuariosEntity();
        try {
            grupoUsuariosEntity=port.grupoUsuariosPorId(idGrupo);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return grupoUsuariosEntity;
    }
}