package co.com.siscomputo.administracion.logic;

import co.com.siscomputo.endpoint.GrupoUsuariosEntity;
import co.com.siscomputo.endpoint.ObjetoRetornaEntity;
import co.com.siscomputo.endpoint.UsuarioGrupoUsuarioEntity;
import co.com.siscomputo.utilidades.IurlWebService;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public class GrupoUsuariosLogic implements IurlWebService{

    private List grupoUsuarios;
    
    /**
     * Funcion con la cual inicializo el service y el portAdministracion() de los WebServices
     */


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
        
        ArrayList<GrupoUsuariosEntity> listaaux=new ArrayList<>();
        ArrayList<Object> listaObjeto =(ArrayList<Object>) portAdministracion().listaGrupoUsuarios().getRetorna();
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
        
        GrupoUsuariosEntity dispoRta=null;        
        try {
            dispoRta = portAdministracion().insertarGrupoUsuarios(objeto);
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
        
        String rta="";
        try {            
            if (portAdministracion().actualizarGrupoUsuarios(objeto) != null) {
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
     * Método que trae un grupo de Usuarios por Id
     * @param idGrupo
     * @return 
     */
    public GrupoUsuariosEntity grupoPorId(int idGrupo){
        
        GrupoUsuariosEntity grupoUsuariosEntity=new GrupoUsuariosEntity();
        try {
            grupoUsuariosEntity=portAdministracion().grupoUsuariosPorId(idGrupo);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return grupoUsuariosEntity;
    }
    
    public ArrayList<GrupoUsuariosEntity> grupoPorUsuario(int idUsuario){
        
        ArrayList<GrupoUsuariosEntity> grupoUsuariosEntity=new ArrayList<GrupoUsuariosEntity>();
        try {
            ObjetoRetornaEntity retorna=portAdministracion().grupoUsuariosPorUsuario(idUsuario);
            ArrayList<Object> listaObjeto=(ArrayList<Object>) retorna.getRetorna();
            for(Object obj:listaObjeto){
                UsuarioGrupoUsuarioEntity usuarioGrupoUsuarioEntity=(UsuarioGrupoUsuarioEntity) obj;
                grupoUsuariosEntity.add(usuarioGrupoUsuarioEntity.getGrupoUsuario());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return grupoUsuariosEntity;
    }
    
}