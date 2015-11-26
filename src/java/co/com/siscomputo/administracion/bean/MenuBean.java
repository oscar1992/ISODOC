/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.siscomputo.administracion.bean;

import co.com.siscomputo.endpoint.MenuModuloEntity;
import co.com.siscomputo.endpoint.MenuPermisosEntity;
import co.com.siscomputo.endpoint.UsuarioEntity;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    private int idPermiso;
    private int numeroModulo;
    private String nombreModulo;
    private UsuarioEntity usuarioActual;
    private ArrayList<MenuPermisosEntity> menuLateral;
    private String miga;

    @PostConstruct
    public void init() {
        cargaMenu();

    }

    public MenuBean() {
        init();
    }

    public int getIdPermiso() {
        this.idPermiso=(int) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("idPermiso");
        return idPermiso;
    }

    public void setIdPermiso(int idPermiso) {
        
        this.idPermiso = idPermiso;
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
        idModulo=(int) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("idModulo");
        return idModulo;
    }
    /**
     * Método que redireciona entre modulos-permisos
     * @param ruta
     * @return 
     */
    public String setRutaModulo(String ruta) {
        try {
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("ruta", ruta);
            FacesContext.getCurrentInstance().getExternalContext().redirect(ruta);
            System.out.println("ROTA: "+ruta+"- "+numeroModulo);           
        } catch (IOException ex) {
            Logger.getLogger(MenuBean.class.getName()).log(Level.SEVERE, null, ex);
           
        }
        return ruta;
    }
    /**
     * Método que cambia el número y el nombre del medulo 
     * @param idModulo 
     */
    public void setIdModulo(int idModulo, String subMenu, Integer idPermiso) {
        if(idModulo!=-1) {
            this.idModulo = idModulo;
            setMenuLateral();
            this.nombreModulo+="/"+subMenu;
            //System.out.println("MenuLateral: " + menuLateral.size() + " - " + this.idModulo);
        } else  {
            this.numeroModulo=-1;
            this.nombreModulo="Inicio";
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("numeroModulo", numeroModulo);
            
            this.idModulo=-1;
            //System.out.println("MenuLateral: Inicio - " + this.idModulo);
        }
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("idPermiso", idPermiso);
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("nombreModulo", nombreModulo);
    }
    /**
     * Método que recupera el nombre del módulo de la sesión
     * @return 
     */
    public String getNombreModulo() {
        try {
            this.nombreModulo = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("nombreModulo");
            this.numeroModulo = (int) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("numeroModulo");
        } catch (Exception e) {
            this.nombreModulo="Inicio";
            numeroModulo = -1;
        }
        
        //System.out.println("NOMBRE: " + nombreModulo + " - " + numeroModulo);
        return nombreModulo;
    }

    public void setNombreModulo(String nombreModulo) {

        this.nombreModulo = nombreModulo;
    }

    public UsuarioEntity getUsuarioActual() {
        usuarioActual = (UsuarioEntity) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
        return usuarioActual;
    }

    public void setUsuarioActual(UsuarioEntity usuarioActual) {
        this.usuarioActual = usuarioActual;
    }

    public ArrayList<MenuPermisosEntity> getMenuLateral() {
        menuLateral = (ArrayList<MenuPermisosEntity>) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("menuLateral");
        try {
            for (MenuPermisosEntity item : menuLateral) {
                //System.out.println("T: " + item.getSubNivel().size());
                for (MenuPermisosEntity item2 : item.getSubNivel()) {
                   //System.out.println("TT: " + item2.getSubNivel().size());
                }

            }
        } catch (Exception e) {
        }
        return menuLateral;
    }

    public int getNumeroModulo() {
        try {
            numeroModulo = (int) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("numeroModulo");
        } catch (Exception e) {
            numeroModulo=-1;
        }
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

        //System.out.println("SET??: " + nombreModulo);
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("menuLateral", menuLateral);
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("nombreModulo", nombreModulo);
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("numeroModulo", numeroModulo);
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("idModulo", idModulo);
    }

    public String getMiga() {        
        return miga;
    }

    public void setMiga(String miga) {
        this.miga = miga;
    }
    /**
     * Método que pone en la sesión los datos del menú
     */
    public void cargaMenu() {
        menu = (ArrayList<MenuModuloEntity>) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("menu");
    }
    
    public String rutaIconoCambio(String ruta) {
        try {
            int numeroModulo=-1;
            try {
                numeroModulo = (int) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("numeroModulo");
                //System.out.println("nn: "+numeroModulo);
            } catch (Exception e) {
                //System.out.println("??");
                numeroModulo = -1;
            }
            String modulos = "modulos" + numeroModulo;
            String rte = ruta.replace("modulos2", modulos);
            //System.out.println("RTE: "+modulos);
            //System.out.println("RUTAX: " + rte);
            return rte;
        } catch (Exception e) {
            System.out.println("EXCEP2");
            return ruta;
        }
    }
}
