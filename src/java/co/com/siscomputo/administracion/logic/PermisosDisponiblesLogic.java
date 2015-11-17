/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.siscomputo.administracion.logic;

import co.com.siscomputo.endpoint.ListaAsignaPermisosModulo;
import co.com.siscomputo.endpoint.RolPermisoEntity;
import co.com.siscomputo.endpoint.Usuario;
import co.com.siscomputo.endpoint.Usuario_Service;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public class PermisosDisponiblesLogic {
    private Usuario_Service webService;
    private Usuario port;
    private List permisosDisponibles;
    
    
    /**
     * Funcion con la cual inicializo el service y el port de los WebServices
     */
    public void webService() {
        webService = new Usuario_Service();
        port = webService.getUsuarioPort();
    }

    public PermisosDisponiblesLogic() {
        listaPermisosDisponibles();
    }
    
    public List getPermisosDisponibles() {
        return permisosDisponibles;
    }

    public void setPermisosDisponibles(List permisosDisponibles) {
        this.permisosDisponibles = permisosDisponibles;
    }
    
    public void cargaListaPermisosDisponible(){
        permisosDisponibles=port.listaPermisosDisponibles();
    }
    /**
     * Método que retorna los permisos dsiponibles en el sistema
     * @return 
     */
    public ArrayList<ListaAsignaPermisosModulo>listaPermisosDisponibles(){
        webService();
        ArrayList<ListaAsignaPermisosModulo> lista=new ArrayList<>();
        lista=(ArrayList<ListaAsignaPermisosModulo>)port.listaPermisosDisponibles();
        return lista;
    }
    /**
     * Método que conulta los permisos disponibles por Rol
     * @param idRol
     * @return 
     */
    public ArrayList<RolPermisoEntity> listaRolPermiso(int idRol){
        
        webService();
        ArrayList<RolPermisoEntity> lista=new ArrayList<>();
        ArrayList<Object> listaObjeto=(ArrayList<Object>) port.listaRolPermiso(idRol).getRetorna();
        for(Object obj:listaObjeto){
            RolPermisoEntity rolPermisosEntity=(RolPermisoEntity) obj;
            System.out.println("PER: "+rolPermisosEntity.getIdPermiso().getNombrePermiso());
            lista.add(rolPermisosEntity);
        }
        return lista;
    }
}
