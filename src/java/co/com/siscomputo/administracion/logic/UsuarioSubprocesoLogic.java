package co.com.siscomputo.administracion.logic;

import co.com.siscomputo.endpoint.AccionEntity;
import co.com.siscomputo.endpoint.SubprocesoEntity;
import co.com.siscomputo.endpoint.ObjetoRetornaEntity;
import co.com.siscomputo.endpoint.UsuarioEntity;
import co.com.siscomputo.endpoint.UsuarioSubprocesoEntity;
import co.com.siscomputo.utilidades.IurlWebService;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public class UsuarioSubprocesoLogic implements IurlWebService{

    private List usuarioSubproceso;
    


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
        
        ArrayList<UsuarioSubprocesoEntity> listaaux=new ArrayList<>();
        ArrayList<Object> listaObjeto =(ArrayList<Object>) portUsuario().listaUsuarioSubproceso().getRetorna();
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
            portUsuario().limpiaUsuarioSubproceso(objeto.getIdUsuario(), idAccion);
            dispoRta = portUsuario().ingresarUsuarioSubproceso(listaUsuarioSubproceso);
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
        
        String rta="";
        try {            
            if (portUsuario().actualizarUsuarioSubproceso(objeto) != null) {
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
        
        ArrayList<UsuarioSubprocesoEntity> listaaux=new ArrayList<>();
        ArrayList<Object> listaObjeto =(ArrayList<Object>) portUsuario().listaUsuarioSubprocesosPorUsuario(idUsuario).getRetorna();
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
        
        ArrayList<UsuarioSubprocesoEntity> listaaux=new ArrayList<>();
        ArrayList<Object> listaObjeto =(ArrayList<Object>) portUsuario().listaUsuarioSubprocesosPorUsuarioAccion(idUsuario, idAccion).getRetorna();
        for(Object obj:listaObjeto){
            UsuarioSubprocesoEntity objectusuarioSubproceso=(UsuarioSubprocesoEntity) obj;
            listaaux.add(objectusuarioSubproceso);
        }
        return listaaux;
    }
}