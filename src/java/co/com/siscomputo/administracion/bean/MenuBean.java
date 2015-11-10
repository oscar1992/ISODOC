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
    private int numeroModulo;
    private String nombreModulo;
    private UsuarioEntity usuarioActual;
    private ArrayList<MenuPermisosEntity> menuLateral;

    @PostConstruct
    public void init() {
        cargaMenu();

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
        System.out.println("MenuLateral: " + menuLateral.size() + " - " + this.idModulo);
    }

    public String getNombreModulo() {
        try {
            numeroModulo = (int) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("numeroModulo");
        } catch (Exception e) {
            numeroModulo = 0;
        }
            this.nombreModulo = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("nombreModulo");
            System.out.println("NOMBRE: " + nombreModulo + " - " + numeroModulo);
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
        menuLateral = (ArrayList<MenuPermisosEntity>) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("menuLateral");

        return menuLateral;
    }

    public int getNumeroModulo() {
        return numeroModulo;
    }

    public void setNumeroModulo(int numeroModulo) {
        this.numeroModulo = numeroModulo;
    }

    /**
     * Método que cambia el menú lateral
     */
    public void setMenuLateral() {

        for (MenuModuloEntity item : menu) {

            if (idModulo == item.getIdModulo()) {
                nombreModulo = item.getNombre();
                this.menuLateral = (ArrayList<MenuPermisosEntity>) item.getSubNivel();
                this.numeroModulo = item.getOrden();

            }
        }
        for (MenuModuloEntity item : menu) {
            //item.setRutaIcono(rutaIconoCambio(item.getRutaIcono()));
        }
        System.out.println("SET??: " + nombreModulo);
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("menuLateral", menuLateral);
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("nombreModulo", nombreModulo);
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("numeroModulo", numeroModulo);
    }

    public String rutaIconoCambio(String ruta) {
        try {

            String modulos = "modulos" + numeroModulo;
            String rte = ruta.replace("modulos2", modulos);
            System.out.println("RUTA: " + rte);
            return rte;
        } catch (Exception e) {
            return ruta;
        }
    }

    public void cargaMenu() {
        menu = (ArrayList<MenuModuloEntity>) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("menu");

    }
}
