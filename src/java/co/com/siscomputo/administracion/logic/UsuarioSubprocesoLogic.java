package co.com.siscomputo.administracion.logic;

import co.com.siscomputo.endpoint.AccionEntity;
import co.com.siscomputo.endpoint.SubprocesoEntity;
import co.com.siscomputo.endpoint.ObjetoRetornaEntity;
import co.com.siscomputo.endpoint.Usuario;
import co.com.siscomputo.endpoint.UsuarioEntity;
import co.com.siscomputo.endpoint.UsuarioSubprocesoEntity;
import co.com.siscomputo.endpoint.Usuario_Service;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public class UsuarioSubprocesoLogic {
    private Usuario_Service webService;
    private Usuario port;
    private List usuarioSubproceso;
    
    /**
     * Funcion con la cual inicializo el service y el port de los WebServices
     */
    public void webService() {
        webService = new Usuario_Service();
        port = webService.getUsuarioPort();
    }

    public List getUsuarioSubproceso() {
        return usuarioSubproceso;
    }

    public void setUsuarioSubproceso(List usuarioSubproceso) {
        this.usuarioSubproceso = usuarioSubproceso;
    }
    
    /**
     * Método que trae una lista de Usuario y su SubProceso
     * @return 
     */
    public ArrayList<UsuarioSubprocesoEntity> listaUsuarioSubproceso(){
        webService();
        ArrayList<UsuarioSubprocesoEntity> listaaux=new ArrayList<>();
        ArrayList<Object> listaObjeto =(ArrayList<Object>) port.listaUsuarioSubproceso().getRetorna();
        for(Object obj:listaObjeto){
            UsuarioSubprocesoEntity objectusuarioSubproceso=(UsuarioSubprocesoEntity) obj;
            listaaux.add(objectusuarioSubproceso);
        }
        return listaaux;
    }
/**
     * Método que permite ingresar un Usuario y su SubProcesonuevo
     * @param objeto
     * @return 
     */
    public ObjetoRetornaEntity insertarUsuarioSubproceso(ArrayList<String> subproNombres,UsuarioEntity objeto, int idAccion){
        webService();
        ObjetoRetornaEntity dispoRta=null;        
        SubProcesosLogic subProcesosLogic=new SubProcesosLogic();
        ArrayList<SubprocesoEntity> listMacros=subProcesosLogic.listaSubprocesos();
        ArrayList<UsuarioSubprocesoEntity> listaUsuarioSubproceso=new ArrayList<>();
        AccionLogic accionLogic=new AccionLogic();
        ArrayList<AccionEntity> listaAcciones=accionLogic.listaAccion();
        AccionEntity accion=null;
        for(AccionEntity acciones:listaAcciones){
            if(acciones.getIdAccion()==idAccion){
                accion=acciones;
                break;
            }
        }
        for(SubprocesoEntity subpro: listMacros){
            for(String nombreMacro: subproNombres){
                if(nombreMacro.equalsIgnoreCase(subpro.getNombreSubproceso())){
                    UsuarioSubprocesoEntity usuarioSubprocesoEntity=new UsuarioSubprocesoEntity();
                    usuarioSubprocesoEntity.setIdSubprocesoEntity(subpro);
                    usuarioSubprocesoEntity.setIdUsuario(objeto);
                    usuarioSubprocesoEntity.setIdAccion(accion);
                    listaUsuarioSubproceso.add(usuarioSubprocesoEntity);
                }
            }
        }
        try {
            port.limpiaUsuarioSubproceso(objeto.getIdUsuario(), idAccion);
            dispoRta = port.ingresarUsuarioSubproceso(listaUsuarioSubproceso);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dispoRta;
    }
/**
     * Método que permite actualizar un Usuario y su SubProceso
     * @param metodo
     * @return 
     */
    public String actualizarUsuarioSubproceso(UsuarioSubprocesoEntity objeto){
        webService();
        String rta="";
        try {            
            if (port.actualizarUsuarioSubproceso(objeto) != null) {
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
    public ArrayList<UsuarioSubprocesoEntity> listaUsuarioMacroporcesoPorUsuario(int idUsuario){
        webService();
        ArrayList<UsuarioSubprocesoEntity> listaaux=new ArrayList<>();
        ArrayList<Object> listaObjeto =(ArrayList<Object>) port.listaUsuarioSubprocesosPorUsuario(idUsuario).getRetorna();
        for(Object obj:listaObjeto){
            UsuarioSubprocesoEntity objectusuarioSubproceso=(UsuarioSubprocesoEntity) obj;
            listaaux.add(objectusuarioSubproceso);
        }
        return listaaux;
    }
    /**
     * Método que trae una lista de las relaciones entre usuarios y procesos, filtradas por usuario y por acción
     * @return 
     */
    public ArrayList<UsuarioSubprocesoEntity> listaUsuarioMacroporcesoPorUsuarioAccion(int idUsuario, int idAccion){
        webService();
        ArrayList<UsuarioSubprocesoEntity> listaaux=new ArrayList<>();
        ArrayList<Object> listaObjeto =(ArrayList<Object>) port.listaUsuarioSubprocesosPorUsuarioAccion(idUsuario, idAccion).getRetorna();
        for(Object obj:listaObjeto){
            UsuarioSubprocesoEntity objectusuarioSubproceso=(UsuarioSubprocesoEntity) obj;
            listaaux.add(objectusuarioSubproceso);
        }
        return listaaux;
    }
}