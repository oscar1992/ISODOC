/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.siscomputo.administracion.bean;

import co.com.siscomputo.endpoint.MenuModuloEntity;
import co.com.siscomputo.endpoint.MenuPermisosEntity;
import co.com.siscomputo.endpoint.UsuarioEntity;
import java.io.Serializable;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author LENOVO
 */
@ManagedBean(name = "Menus")
@ViewScoped
public class MenuBean implements Serializable {

    private ArrayList<MenuModuloEntity> menu;
    private int idUsuario;
    private int idModulo;
    private String nombreModulo;
    private UsuarioEntity usuarioActual;
    private ArrayList<MenuPermisosEntity> menuLateral;

    @PostConstruct
    public void init() {
        cargaMenu();
        setMenuLateral();
    }

    public MenuBean() {

        init();
    }

    public ArrayList<MenuModuloEntity> getMenu() {
        return menu;
    }

    public void setMenu(ArrayList<MenuModuloEntity> menu) {
        this.menu = menu;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdModulo() {
        return idModulo;
    }

    public String setRutaModulo(String ruta) {
        return ruta;
    }

    public void setIdModulo(int idModulo) {
        this.idModulo = idModulo;
        setMenuLateral();
    }

    public String getNombreModulo() {
        return nombreModulo;
    }

    public void setNombreModulo(String nombreModulo) {
        this.nombreModulo = nombreModulo;
    }

    public UsuarioEntity getUsuarioActual() {
        return usuarioActual;
    }

    public void setUsuarioActual(UsuarioEntity usuarioActual) {
        this.usuarioActual = usuarioActual;
    }

    public ArrayList<MenuPermisosEntity> getMenuLateral() {
        return menuLateral;
    }
    /**
     * Método que cambia el menú lateral
     */
    public void setMenuLateral() {
        
            for (MenuModuloEntity item : menu) {
                
                if (idModulo == item.getIdModulo()) {
                    
                    nombreModulo = item.getNombre();
                    this.menuLateral = (ArrayList<MenuPermisosEntity>) item.getSubNivel();
                }
            }
        
    }

    public void cargaMenu() {
        menu = (ArrayList<MenuModuloEntity>) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("menu");

    }
}
