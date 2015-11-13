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
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public class UsuarioRolLogic {

    private Usuario_Service webService;
    private Usuario port;
    private List listaUsuarioRoll;

    /**
     * Funcion con la cual inicializo el service y el port de los WebServices
     */
    public void webService() {
        webService = new Usuario_Service();
        port = webService.getUsuarioPort();
    }

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
        webService();
        ArrayList<UsuarioRolEntity> lista = new ArrayList<>();
        ArrayList<Object> listaObjeto = (ArrayList<Object>) port.listaUsuarioRol(IdUsusario).getRetorna();
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
        webService();
        ArrayList<UsuarioRolEntity> lista = new ArrayList<>();
        ArrayList<Object> listaObjeto = (ArrayList<Object>) port.listaUsuarioRolporAreaUsuario(idArea, idUsuario).getRetorna();
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
        webService();
        String rta = "";
        try {
            if (port.actualizarUsuarioRol(usuarioRol) != null) {
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
     * @param usuarioRol
     * @return
     */
    public ObjetoRetornaEntity ingresaUsuarioRol(ArrayList<String> rolNombres, UsuarioEntity usuario, int idArea) {
        webService();
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
            port.limpiaUsuarioRoles(usuario.getIdUsuario(), idArea);
            usuRta = port.insertarUsuarioRol(listaUsuarioRol);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return usuRta;
    }

}
