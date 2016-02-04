package co.com.siscomputo.administracion.logic;

import co.com.siscomputo.endpoint.AccionEntity;
import co.com.siscomputo.endpoint.ProcesosEntity;
import co.com.siscomputo.endpoint.ObjetoRetornaEntity;
import co.com.siscomputo.endpoint.UsuarioEntity;
import co.com.siscomputo.endpoint.UsuarioProcesoEntity;
import co.com.siscomputo.utilidades.IurlWebService;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public class UsuarioProcesoLogic implements IurlWebService{

    private List usuarioProceso;
    


    public List getUsuarioProceso() {
        return usuarioProceso;
    }

    public void setUsuarioProceso(List usuarioProceso) {
        this.usuarioProceso = usuarioProceso;
    }
    
    /**
     * Método que trae una lista de Usuario y su MacroProceso
     * @return 
     */
    public ArrayList<UsuarioProcesoEntity> listaUsuarioProceso(){
        
        ArrayList<UsuarioProcesoEntity> listaaux=new ArrayList<>();
        ArrayList<Object> listaObjeto =(ArrayList<Object>) portUsuario().listausuarioProcesos().getRetorna();
        for(Object obj:listaObjeto){
            UsuarioProcesoEntity objectusuarioProceso=(UsuarioProcesoEntity) obj;
            listaaux.add(objectusuarioProceso);
        }
        return listaaux;
    }
/**
     * Método que permite ingresar un Usuario y su MacroProcesonuevo
     * @param objeto
     * @return 
     */
    public ObjetoRetornaEntity insertarUsuarioProceso(ArrayList<String> procesosNombres,UsuarioEntity objeto, int idAccion){
        
        ObjetoRetornaEntity dispoRta=null;        
        ProcesosLogic procesosLogic=new ProcesosLogic();
        ArrayList<ProcesosEntity> listprocesos=procesosLogic.listaProcesos();
        ArrayList<UsuarioProcesoEntity> listaUsuarioProceso=new ArrayList<>();
        AccionLogic accionLogic=new AccionLogic();
        ArrayList<AccionEntity> listaAcciones=accionLogic.listaAccion();
        AccionEntity accion=null;
        for(AccionEntity acciones:listaAcciones){
            if(acciones.getIdAccion()==idAccion){
                accion=acciones;
                break;
            }
        }
        for(ProcesosEntity procesos: listprocesos){
            for(String nombreMacro: procesosNombres){
                if(nombreMacro.equalsIgnoreCase(procesos.getNombrePreoceso())){
                    UsuarioProcesoEntity usuarioProcesoEntity=new UsuarioProcesoEntity();
                    usuarioProcesoEntity.setIdProceso(procesos);
                    usuarioProcesoEntity.setIdUsuario(objeto);
                    usuarioProcesoEntity.setIdAccion(accion);
                    listaUsuarioProceso.add(usuarioProcesoEntity);
                }
            }
        }
        try {
            portUsuario().limpiaUsuarioMacroProceso(objeto.getIdUsuario(), idAccion);
            dispoRta = portUsuario().ingresarUsuarioProcesos(listaUsuarioProceso);
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
    public String actualizarUsuarioProceso(UsuarioProcesoEntity objeto){
        
        String rta="";
        try {            
            if (portUsuario().actualizarUsuarioProceso(objeto) != null) {
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
    public ArrayList<UsuarioProcesoEntity> listaUsuarioMacroporcesoPorUsuario(int idUsuario){
        
        ArrayList<UsuarioProcesoEntity> listaaux=new ArrayList<>();
        ArrayList<Object> listaObjeto =(ArrayList<Object>) portUsuario().listaUsuarioProcesosPorUsuario(idUsuario).getRetorna();
        for(Object obj:listaObjeto){
            UsuarioProcesoEntity objectusuarioProceso=(UsuarioProcesoEntity) obj;
            listaaux.add(objectusuarioProceso);
        }
        return listaaux;
    }
    /**
     * Método que trae una lista de las relaciones entre usuarios y procesos, filtradas por usuario y por acción
     * @return 
     */
    public ArrayList<UsuarioProcesoEntity> listaUsuarioMacroporcesoPorUsuarioAccion(int idUsuario, int idAccion){
        
        ArrayList<UsuarioProcesoEntity> listaaux=new ArrayList<>();
        ArrayList<Object> listaObjeto =(ArrayList<Object>) portUsuario().listaUsuarioProcesosPorUsuarioAccion(idUsuario, idAccion).getRetorna();
        for(Object obj:listaObjeto){
            UsuarioProcesoEntity objectusuarioProceso=(UsuarioProcesoEntity) obj;
            listaaux.add(objectusuarioProceso);
        }
        return listaaux;
    }
}