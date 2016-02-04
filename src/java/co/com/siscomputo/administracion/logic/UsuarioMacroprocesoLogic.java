package co.com.siscomputo.administracion.logic;

import co.com.siscomputo.endpoint.AccionEntity;
import co.com.siscomputo.endpoint.MacroprocesosEntity;
import co.com.siscomputo.endpoint.ObjetoRetornaEntity;
import co.com.siscomputo.endpoint.UsuarioEntity;
import co.com.siscomputo.endpoint.UsuarioMacroprocesoEntity;
import co.com.siscomputo.utilidades.IurlWebService;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public class UsuarioMacroprocesoLogic implements IurlWebService{
    
    private List usuarioMacroproceso;
    


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
        
        ArrayList<UsuarioMacroprocesoEntity> listaaux=new ArrayList<>();
        ArrayList<Object> listaObjeto =(ArrayList<Object>) portUsuario().listaUsuarioMacroproceso().getRetorna();
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
    public ObjetoRetornaEntity insertarUsuarioMacroproceso(ArrayList<String> macrosNombres,UsuarioEntity objeto, int idAccion){
        
        ObjetoRetornaEntity dispoRta=null;        
        MacroProcesosLogic macroProcesosLogic=new MacroProcesosLogic();
        ArrayList<MacroprocesosEntity> listMacros=macroProcesosLogic.listaMacroprocesos();
        ArrayList<UsuarioMacroprocesoEntity> listaUsuarioMacroproceso=new ArrayList<>();
        AccionLogic accionLogic=new AccionLogic();
        ArrayList<AccionEntity> listaAcciones=accionLogic.listaAccion();
        AccionEntity accion=null;
        for(AccionEntity acciones:listaAcciones){
            if(acciones.getIdAccion()==idAccion){
                accion=acciones;
                break;
            }
        }
        for(MacroprocesosEntity macros: listMacros){
            for(String nombreMacro: macrosNombres){
                if(nombreMacro.equalsIgnoreCase(macros.getNombreMacroproceso())){
                    UsuarioMacroprocesoEntity usuarioMacroprocesoEntity=new UsuarioMacroprocesoEntity();
                    usuarioMacroprocesoEntity.setIdMacroProceso(macros);
                    usuarioMacroprocesoEntity.setIdUsuario(objeto);
                    usuarioMacroprocesoEntity.setIdAccion(accion);
                    listaUsuarioMacroproceso.add(usuarioMacroprocesoEntity);
                }
            }
        }
        try {
            portUsuario().limpiaUsuarioMacroProceso(objeto.getIdUsuario(), idAccion);
            dispoRta = portUsuario().ingresarUsuarioMacroproceso(listaUsuarioMacroproceso);
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
        
        String rta="";
        try {            
            if (portUsuario().actualizarusuarioMacroproceso(objeto) != null) {
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
     * Método que trae una lista de las relaciones entre usuarios y procesos, filtradas por usuario
     * @return 
     */
    public ArrayList<UsuarioMacroprocesoEntity> listaUsuarioMacroporcesoPorUsuario(int idUsuario){
        
        ArrayList<UsuarioMacroprocesoEntity> listaaux=new ArrayList<>();
        ArrayList<Object> listaObjeto =(ArrayList<Object>) portUsuario().listaUsuarioMacroProcesosPorUsuario(idUsuario).getRetorna();
        for(Object obj:listaObjeto){
            UsuarioMacroprocesoEntity objectusuarioMacroproceso=(UsuarioMacroprocesoEntity) obj;
            listaaux.add(objectusuarioMacroproceso);
        }
        return listaaux;
    }
    /**
     * Método que trae una lista de las relaciones entre usuarios y procesos, filtradas por usuario y por acción
     * @return 
     */
    public ArrayList<UsuarioMacroprocesoEntity> listaUsuarioMacroporcesoPorUsuarioAccion(int idUsuario, int idAccion){
        
        ArrayList<UsuarioMacroprocesoEntity> listaaux=new ArrayList<>();
        ArrayList<Object> listaObjeto =(ArrayList<Object>) portUsuario().listaUsuarioMacroProcesosPorUsuarioAccion(idUsuario, idAccion).getRetorna();
        for(Object obj:listaObjeto){
            UsuarioMacroprocesoEntity objectusuarioMacroproceso=(UsuarioMacroprocesoEntity) obj;
            listaaux.add(objectusuarioMacroproceso);
}
        return listaaux;
    }
}