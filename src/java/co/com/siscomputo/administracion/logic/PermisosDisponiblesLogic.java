/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.siscomputo.administracion.logic;

import co.com.siscomputo.endpoint.ListaAsignaPermisosModulo;
import co.com.siscomputo.endpoint.RolPermisoEntity;
import co.com.siscomputo.utilidades.IurlWebService;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public class PermisosDisponiblesLogic implements IurlWebService{

    private List permisosDisponibles;


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
        permisosDisponibles=portUsuario().listaPermisosDisponibles();
    }
    /**
     * Método que retorna los permisos dsiponibles en el sistema
     * @return 
     */
    public ArrayList<ListaAsignaPermisosModulo>listaPermisosDisponibles(){
        
        ArrayList<ListaAsignaPermisosModulo> lista=new ArrayList<>();
        lista=(ArrayList<ListaAsignaPermisosModulo>)portUsuario().listaPermisosDisponibles();
        return lista;
    }
    /**
     * Método que conulta los permisos disponibles por Rol
     * @param idRol
     * @return 
     */
    public ArrayList<RolPermisoEntity> listaRolPermiso(int idRol){
        
        
        ArrayList<RolPermisoEntity> lista=new ArrayList<>();
        ArrayList<Object> listaObjeto=(ArrayList<Object>) portUsuario().listaRolPermiso(idRol).getRetorna();
        for(Object obj:listaObjeto){
            RolPermisoEntity rolPermisosEntity=(RolPermisoEntity) obj;
            System.out.println("PER: "+rolPermisosEntity.getIdPermiso().getNombrePermiso());
            lista.add(rolPermisosEntity);
        }
        return lista;
    }
}
