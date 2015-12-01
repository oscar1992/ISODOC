package co.com.siscomputo.administracion.logic;

import co.com.siscomputo.endpoint.Administacion_Service;
import co.com.siscomputo.endpoint.Usuario;
import co.com.siscomputo.endpoint.UsuarioMacroprocesoEntity;
import co.com.siscomputo.endpoint.Usuario_Service;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public class UsuarioMacroprocesoLogic {
    private Usuario_Service webService;
    private Usuario port;
    private List usuarioMacroproceso;
    
    /**
     * Funcion con la cual inicializo el service y el port de los WebServices
     */
    public void webService() {
        webService = new Usuario_Service();
        port = webService.getUsuarioPort();
    }

    public List getUsuarioMacroproceso() {
        return usuarioMacroproceso;
    }

    public void setUsuarioMacroproceso(List usuarioMacroproceso) {
        this.usuarioMacroproceso = usuarioMacroproceso;
    }
    
    /**
     * Método que trae una lista de Usuario y su MacroProceso
     * @return 
     */
    public ArrayList<UsuarioMacroprocesoEntity> listaUsuarioMacroproceso(){
        webService();
        ArrayList<UsuarioMacroprocesoEntity> listaaux=new ArrayList<>();
        ArrayList<Object> listaObjeto =(ArrayList<Object>) port.listaUsuarioMacroproceso().getRetorna();
        for(Object obj:listaObjeto){
            UsuarioMacroprocesoEntity objectusuarioMacroproceso=(UsuarioMacroprocesoEntity) obj;
            listaaux.add(objectusuarioMacroproceso);
        }
        return listaaux;
    }
/**
     * Método que permite ingresar un Usuario y su MacroProcesonuevo
     * @param objeto
     * @return 
     */
    public UsuarioMacroprocesoEntity insertarUsuarioMacroproceso(UsuarioMacroprocesoEntity objeto){
        webService();
        UsuarioMacroprocesoEntity dispoRta=null;        
        try {
            dispoRta = port.ingresarUsuarioMacroproceso(objeto);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dispoRta;
    }
/**
     * Método que permite actualizar un Usuario y su MacroProceso
     * @param metodo
     * @return 
     */
    public String actualizarUsuarioMacroproceso(UsuarioMacroprocesoEntity objeto){
        webService();
        String rta="";
        try {            
            if (port.actualizarusuarioMacroproceso(objeto) != null) {
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
    public ArrayList<UsuarioMacroprocesoEntity> listaUsuarioMacroporcesoPorUsuario(int iUsuario){
        webService();
        ArrayList<UsuarioMacroprocesoEntity> listaaux=new ArrayList<>();
        ArrayList<Object> listaObjeto =(ArrayList<Object>) port.listaUsuarioMacroproceso().getRetorna();
        for(Object obj:listaObjeto){
            UsuarioMacroprocesoEntity objectusuarioMacroproceso=(UsuarioMacroprocesoEntity) obj;
            listaaux.add(objectusuarioMacroproceso);
        }
        return listaaux;
    }
}