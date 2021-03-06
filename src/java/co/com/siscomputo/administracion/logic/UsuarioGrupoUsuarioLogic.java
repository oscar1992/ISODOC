package co.com.siscomputo.administracion.logic;

import co.com.siscomputo.endpoint.GrupoUsuariosEntity;
import co.com.siscomputo.endpoint.ObjetoRetornaEntity;
import co.com.siscomputo.endpoint.UsuarioEntity;
import co.com.siscomputo.endpoint.UsuarioGrupoUsuarioEntity;
import co.com.siscomputo.utilidades.IurlWebService;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public class UsuarioGrupoUsuarioLogic implements IurlWebService{

    private List usuarioGrupoUsuario;

    public List getUsuarioGrupoUsuario() {
        return usuarioGrupoUsuario;
    }

    public void setUsuarioGrupoUsuario(List usuarioGrupoUsuario) {
        this.usuarioGrupoUsuario = usuarioGrupoUsuario;
    }

    /**
     * Método que trae una lista de relacion entre Usuarios y Grupos de Usuarios
     *
     * @return
     */
    public ArrayList<UsuarioGrupoUsuarioEntity> listaUsuarioGrupoUsuario() {
        
        ArrayList<UsuarioGrupoUsuarioEntity> listaaux = new ArrayList<>();
        ArrayList<Object> listaObjeto = (ArrayList<Object>) portAdministracion().listaUsuarioGrupoUsuario().getRetorna();
        for (Object obj : listaObjeto) {
            UsuarioGrupoUsuarioEntity objectusuarioGrupoUsuario = (UsuarioGrupoUsuarioEntity) obj;
            listaaux.add(objectusuarioGrupoUsuario);
        }
        return listaaux;
    }

    /**
     * Método que permite ingresar un relacion entre Usuarios y Grupos de
     * Usuarios nuevos
     *
     * @param objeto
     * @param idGrupo
     * @return
     */
    public ObjetoRetornaEntity insertarUsuarioGrupoUsuario(ArrayList<String> objeto, int idGrupo) {
        
        ObjetoRetornaEntity dispoRta = null;
        try {
            UsuarioLogic usuarioLogic=new UsuarioLogic();
            ArrayList<UsuarioEntity> listaU=usuarioLogic.listaUsuarios();
            ArrayList<UsuarioGrupoUsuarioEntity> listaugu=new ArrayList<>();
            GrupoUsuariosLogic grupoUsuariosLogic=new GrupoUsuariosLogic();
            GrupoUsuariosEntity grupoUsuariosEntity=grupoUsuariosLogic.grupoPorId(idGrupo);
            for(UsuarioEntity usu:listaU){
                for(String nom:objeto){
                    if(nom.equals(usu.getNombre())){
                        
                        UsuarioGrupoUsuarioEntity ugu=new UsuarioGrupoUsuarioEntity();
                        ugu.setGrupoUsuario(grupoUsuariosEntity);
                        ugu.setUsuario(usu);
                        listaugu.add(ugu);
                    }
                }
            }
            portAdministracion().limpiaUsuarioGrupoUsuario(idGrupo);
            dispoRta = portAdministracion().insertarUsuarioGrupoUsuario(listaugu);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dispoRta;
    }

    /**
     * Método que permite actualizar un relacion entre Usuarios y Grupos de
     * Usuarios
     *
     * @param objeto 
     * @return
     */
    public String actualizarUsuarioGrupoUsuario(UsuarioGrupoUsuarioEntity objeto) {
        
        String rta = "";
        try {
            if (portAdministracion().actualizarUsuarioGrupoUsuario(objeto) != null) {
                rta = "Ok";
            } else {
                rta = "Error";
            }
        } catch (Exception e) {
            rta = "Error";
            e.printStackTrace();
        }
        return rta;
    }
    /**
     * Método que trae una lista de relacion entre Usuarios y Grupos de Usuarios Filtrados por Id de Grupo
     *
     * @param idGrupo
     * @return
     */
    public ArrayList<UsuarioEntity> listaUsuarioGrupoUsuarioPorGrupo(int idGrupo) {
        
        ArrayList<UsuarioEntity> listaaux = new ArrayList<>();
        ArrayList<Object> listaObjeto = (ArrayList<Object>) portAdministracion().listaUsuarioGrupoUsuarioPorGrupo(idGrupo).getRetorna();
        for (Object obj : listaObjeto) {
            UsuarioEntity objectusuarioGrupoUsuario = (UsuarioEntity) obj;
            listaaux.add(objectusuarioGrupoUsuario);
        }
        return listaaux;
    }
}
