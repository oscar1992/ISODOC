/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.siscomputo.administracion.logic;

import co.com.siscomputo.endpoint.AreaEntity;
import co.com.siscomputo.endpoint.ObjetoRetornaEntity;
import co.com.siscomputo.endpoint.RolesEntity;
import co.com.siscomputo.endpoint.Usuario;
import co.com.siscomputo.endpoint.UsuarioEntity;
import co.com.siscomputo.endpoint.UsuarioRolEntity;
import co.com.siscomputo.endpoint.Usuario_Service;
import co.com.siscomputo.utilidades.IurlWebService;
import co.com.siscomputo.utilidades.SingletonDirecciones;
import java.util.ArrayList;
import java.util.List;
import javax.xml.ws.BindingProvider;

/**
 *
 * @author LENOVO
 */
public class UsuarioRolLogic implements IurlWebService{


    private List listaUsuarioRoll;



    public List getListaUsuarioRoll() {
        return listaUsuarioRoll;
    }

    public void setListaUsuarioRoll(List listaUsuarioRoll) {
        this.listaUsuarioRoll = listaUsuarioRoll;
    }

    /**
     * Método que retorna una lista de roles por usuario
     *
     * @param IdUsusario
     * @return
     */
    public ArrayList<UsuarioRolEntity> listaUsuarioRol(int IdUsusario) {
        
        ArrayList<UsuarioRolEntity> lista = new ArrayList<>();
        ArrayList<Object> listaObjeto = (ArrayList<Object>) portUsuario().listaUsuarioRol(IdUsusario).getRetorna();
        for (Object obj : listaObjeto) {
            UsuarioRolEntity ure = (UsuarioRolEntity) obj;
            lista.add(ure);
        }
        return lista;
    }

    /**
     * Método que trae la lista de roles filtradas por usuario y por área
     *
     * @return
     */
    public ArrayList<UsuarioRolEntity> listaUsuarioRolPorAreaUsuario(int idUsuario, int idArea) {
        
        ArrayList<UsuarioRolEntity> lista = new ArrayList<>();
        ArrayList<Object> listaObjeto = (ArrayList<Object>) portUsuario().listaUsuarioRolporAreaUsuario(idArea, idUsuario).getRetorna();
        for (Object obj : listaObjeto) {
            UsuarioRolEntity ure = (UsuarioRolEntity) obj;
            lista.add(ure);
        }
        return lista;
    }

    /**
     * Método que permite actualizar una relación usuario-rol
     *
     * @param usuarioRol
     * @return
     */
    public String actualizarUsuarioRol(UsuarioRolEntity usuarioRol) {
        
        String rta = "";
        try {
            if (portUsuario().actualizarUsuarioRol(usuarioRol) != null) {
                rta = "Ok";
            } else {
                rta = "Error";
            }
        } catch (Exception e) {
            rta = "Excepción";
        }
        return rta;
    }

    /**
     * Método que inserta una relación usuario-rol nueva
     *
     * @param rolNombres
     * @param usuario
     * @param idArea
     * @return
     */
    public ObjetoRetornaEntity ingresaUsuarioRol(ArrayList<String> rolNombres, UsuarioEntity usuario, int idArea) {
        
        ObjetoRetornaEntity usuRta = null;
        RolesLogic rolesLogic = new RolesLogic();
        ArrayList<RolesEntity> listaRoles = new ArrayList<>();
        listaRoles = rolesLogic.listaRoles();
        ArrayList<UsuarioRolEntity> listaUsuarioRol = new ArrayList<>();
        AreaLogic areaLogic = new AreaLogic();
        ArrayList<AreaEntity> listaAreas = areaLogic.listaAreas();
        AreaEntity area = null;
        for (AreaEntity areas : listaAreas) {
            if (areas.getIdArea() == idArea) {
                area = areas;
                break;
            }
        }
        for (RolesEntity rol : listaRoles) {
            for (String nombreRol : rolNombres) {

                if (nombreRol.equalsIgnoreCase(rol.getNombreRol())) {
                    UsuarioRolEntity usuRol = new UsuarioRolEntity();
                    usuRol.setRol(rol);
                    usuRol.setUsuario(usuario);
                    usuRol.setArea(area);
                    listaUsuarioRol.add(usuRol);
                }
            }
        }
        try {
            System.out.println("LISTA: " + listaUsuarioRol.size() + " - " + usuario.getIdUsuario());
            portUsuario().limpiaUsuarioRoles(usuario.getIdUsuario(), idArea);
            usuRta = portUsuario().insertarUsuarioRol(listaUsuarioRol);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return usuRta;
    }

}
