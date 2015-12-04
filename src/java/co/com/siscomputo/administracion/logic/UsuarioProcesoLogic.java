package co.com.siscomputo.administracion.logic;

import co.com.siscomputo.endpoint.AccionEntity;
import co.com.siscomputo.endpoint.ProcesosEntity;
import co.com.siscomputo.endpoint.ObjetoRetornaEntity;
import co.com.siscomputo.endpoint.Usuario;
import co.com.siscomputo.endpoint.UsuarioEntity;
import co.com.siscomputo.endpoint.UsuarioProcesoEntity;
import co.com.siscomputo.endpoint.Usuario_Service;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public class UsuarioProcesoLogic {
    private Usuario_Service webService;
    private Usuario port;
    private List usuarioProceso;
    
    /**
     * Funcion con la cual inicializo el service y el port de los WebServices
     */
    public void webService() {
        webService = new Usuario_Service();
        port = webService.getUsuarioPort();
    }

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
        webService();
        ArrayList<UsuarioProcesoEntity> listaaux=new ArrayList<>();
        ArrayList<Object> listaObjeto =(ArrayList<Object>) port.listausuarioProcesos().getRetorna();
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
        webService();
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
            port.limpiaUsuarioMacroProceso(objeto.getIdUsuario(), idAccion);
            dispoRta = port.ingresarUsuarioProcesos(listaUsuarioProceso);
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
        webService();
        String rta="";
        try {            
            if (port.actualizarUsuarioProceso(objeto) != null) {
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
        webService();
        ArrayList<UsuarioProcesoEntity> listaaux=new ArrayList<>();
        ArrayList<Object> listaObjeto =(ArrayList<Object>) port.listaUsuarioProcesosPorUsuario(idUsuario).getRetorna();
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
        webService();
        ArrayList<UsuarioProcesoEntity> listaaux=new ArrayList<>();
        ArrayList<Object> listaObjeto =(ArrayList<Object>) port.listaUsuarioProcesosPorUsuarioAccion(idUsuario, idAccion).getRetorna();
        for(Object obj:listaObjeto){
            UsuarioProcesoEntity objectusuarioProceso=(UsuarioProcesoEntity) obj;
            listaaux.add(objectusuarioProceso);
        }
        return listaaux;
    }
}