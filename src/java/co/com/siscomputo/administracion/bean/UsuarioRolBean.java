/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.siscomputo.administracion.bean;

import co.com.siscomputo.administracion.logic.RolesLogic;
import co.com.siscomputo.administracion.logic.UsuarioRolLogic;
import co.com.siscomputo.endpoint.AreaEntity;
import co.com.siscomputo.endpoint.MenuPermisosEntity;
import co.com.siscomputo.endpoint.ObjetoRetornaEntity;
import co.com.siscomputo.endpoint.RolesEntity;
import co.com.siscomputo.endpoint.UsuarioEntity;
import co.com.siscomputo.endpoint.UsuarioRolEntity;
import java.io.Serializable;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.DualListModel;

/**
 *
 * @author LENOVO
 */
@ManagedBean(name = "UsuarioRol")
@ViewScoped
public class UsuarioRolBean implements Serializable {

    private ArrayList<UsuarioRolEntity> listaUsuarioRol;
    private ArrayList<UsuarioRolEntity> listaUsuarioRolFiltro;
    private UsuarioRolEntity usuarioRolObjeto;
    private Integer idUsuaurio;
    private Integer idArea;
    private DualListModel<String> roles;
    private ArrayList<String> rolesNombre;
    private ArrayList<String> rolesSelecion;
    private UsuarioEntity usuarioObjeto;
    private boolean ingresar;
    private boolean actualizar;
    private boolean eliminar;
    

    public ArrayList<UsuarioRolEntity> getListaUsuarioRol() {
        return listaUsuarioRol;
    }

    public void setListaUsuarioRol(ArrayList<UsuarioRolEntity> listaUsuarioRol) {
        this.listaUsuarioRol = listaUsuarioRol;
    }

    public ArrayList<UsuarioRolEntity> getListaUsuarioRolFiltro() {
        return listaUsuarioRolFiltro;
    }

    public void setListaUsuarioRolFiltro(ArrayList<UsuarioRolEntity> listaUsuarioRolFiltro) {
        this.listaUsuarioRolFiltro = listaUsuarioRolFiltro;
    }

    public UsuarioRolEntity getUsuarioRolObjeto() {
        return usuarioRolObjeto;
    }

    public void setUsuarioRolObjeto(UsuarioRolEntity usuarioRolObjeto) {
        this.usuarioRolObjeto = usuarioRolObjeto;
    }

    public Integer getIdUsuaurio() {
        return idUsuaurio;
    }

    public void setIdUsuaurio(Integer idUsuaurio) {
        this.idUsuaurio = idUsuaurio;
    }

    public DualListModel<String> getRoles() {
        return roles;
    }

    public void setRoles(DualListModel<String> roles) {
        this.roles = roles;
    }

    public ArrayList<String> getRolesNombre() {
        return rolesNombre;
    }

    public void setRolesNombre(ArrayList<String> rolesNombre) {
        this.rolesNombre = rolesNombre;
    }

    public ArrayList<String> getRolesSelecion() {
        return rolesSelecion;
    }

    public void setRolesSelecion(ArrayList<String> rolesSelecion) {
        this.rolesSelecion = rolesSelecion;
    }

    public UsuarioEntity getUsuarioObjeto() {
        return usuarioObjeto;
    }

    public void setUsuarioObjeto(UsuarioEntity usuarioObjeto) {
        this.usuarioObjeto = usuarioObjeto;
    }

    public Integer getIdArea() {
        return idArea;
    }

    public void setIdArea(Integer idArea) {
        this.idArea = idArea;
    }

    public boolean isIngresar() {
        return ingresar;
    }

    public void setIngresar(boolean ingresar) {
        this.ingresar = ingresar;
    }

    public boolean isActualizar() {
        return actualizar;
    }

    public void setActualizar(boolean actualizar) {
        this.actualizar = actualizar;
    }

    public boolean isEliminar() {
        return eliminar;
    }

    public void setEliminar(boolean eliminar) {
        this.eliminar = eliminar;
    }
    

    
    public UsuarioRolBean() {
        
        consultarUsuarioRol();
    }

    @PostConstruct
    public void init() {
        usuarioRolObjeto=new UsuarioRolEntity();
        usuarioObjeto = new UsuarioEntity();
        roles = new DualListModel<>();
        rolesNombre = new ArrayList<>();
        rolesSelecion = new ArrayList<>();
        idArea=null;
        permisos();
        //consultarListaRoles();
        
    }
    
    
    /**
     * Método que trae la lista de los roles disponibles
     */
    public void consultarListaRoles() {
        RolesLogic rolesLogic = new RolesLogic();
        ArrayList<RolesEntity> listaRoles = rolesLogic.listaRoles();
        for (RolesEntity rol : listaRoles) {
            rolesNombre.add(rol.getNombreRol());
        }
    }

    /**
     * Método que consulta los roles que tiene un usuario
     */
    public void consultarUsuarioRol() {
        if (idUsuaurio != null) {
            try {
                rolesSelecion = new ArrayList<>();
                UsuarioRolLogic usuarioRolLogic = new UsuarioRolLogic();
                listaUsuarioRol = usuarioRolLogic.listaUsuarioRol(idUsuaurio);
                for (UsuarioRolEntity usu : listaUsuarioRol) {
                    System.out.println("NN: " + usu.getRol().getNombreRol());
                    rolesSelecion.add(usu.getRol().getNombreRol());
                }

                roles = new DualListModel<>(rolesNombre, rolesSelecion);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    /**
     * Método que trae la lista de roles asignados
     */
    public void consultarUsuarioRolPorAreaUsuario() {
        if (idUsuaurio != null) {
            try {
                rolesSelecion = new ArrayList<>();
                UsuarioRolLogic usuarioRolLogic = new UsuarioRolLogic();
                listaUsuarioRol = usuarioRolLogic.listaUsuarioRolPorAreaUsuario(idUsuaurio, idArea);
                for (UsuarioRolEntity usu : listaUsuarioRol) {
                    System.out.println("NN2: " + usu.getRol().getNombreRol());
                    rolesSelecion.add(usu.getRol().getNombreRol());
                }

                roles = new DualListModel<>(rolesNombre, rolesSelecion);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else{
            System.out.println("USUARIO NULO");
        }
    }

    /**
     * Método que permite ingersar una relación usuario - Rol nueva
     */
    public void ingresarUsuarioRol() {
        System.out.println("Ingresa: " + usuarioObjeto.getNombre() + " Rol: " + roles.getTarget().size());

        if (roles.getTarget().size()>0) {
            try {
                
                UsuarioRolLogic usuarioRolLogic = new UsuarioRolLogic();
                ObjetoRetornaEntity retorna = usuarioRolLogic.ingresaUsuarioRol((ArrayList<String>) roles.getTarget(), usuarioObjeto, idArea);
                FacesMessage msg = null;
                if (retorna.getRetorna() != null) {
                    msg = new FacesMessage("", "UsuarioRol Ingresado Correctamente: " + retorna.getRetorna());
                    
                } else {
                    msg = new FacesMessage("", "UsuarioRol Ingresado Incorrectamente: " + retorna.getRetorna());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        nuevoUsuarioRolObjeto();
    }

    

    /**
     * Método que actualiza una relación usuario-rol
     */
    public void actualizarUsuarioRol() {
        UsuarioRolLogic usuarioRolLogic = new UsuarioRolLogic();
        String valida = usuarioRolLogic.actualizarUsuarioRol(usuarioRolObjeto);
        FacesMessage msg = null;
        if ("Ok".equalsIgnoreCase(valida)) {
            actualizarListaUsuarioRol(usuarioRolObjeto);
        } else {

        }
        RequestContext.getCurrentInstance().execute("PF('actualizarUsuarioRol').hide()");
    }

    /**
     * Método que actualiza visualmente la lista usuario-rol
     *
     * @param usuarioRolObjeto
     */
    private void actualizarListaUsuarioRol(UsuarioRolEntity usuarioRolObjeto) {
        try {
            ArrayList<UsuarioRolEntity> listaaux = new ArrayList<>();
            if (listaUsuarioRol != null) {
                for (UsuarioRolEntity item : listaUsuarioRol) {
                    if (usuarioRolObjeto.getIdUsuarioRol() == item.getIdUsuarioRol()) {
                        listaaux.add(usuarioRolObjeto);
                    } else {
                        listaaux.add(item);
                    }
                }
            }
            this.listaUsuarioRol = new ArrayList<>();
            this.listaUsuarioRol = listaaux;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * M+etodo que se llama con la seleción de un UsuarioRol
     *
     * @param event
     */
    public void onRowSelect(SelectEvent event) {
        usuarioRolObjeto = (UsuarioRolEntity) event.getObject();

    }

    /**
     * Métood que limpia el objeto después de ser usado por otreo método
     */
    private void nuevoUsuarioRolObjeto() {
        usuarioRolObjeto = new UsuarioRolEntity();
    }
    /**
     * Método que seleciona el usuario
     * @param event 
     */
    public void onRowSelect2(SelectEvent event) {
        usuarioObjeto = (UsuarioEntity) event.getObject();
        System.out.println("usu: " + usuarioObjeto.getIdUsuario());
        idUsuaurio = usuarioObjeto.getIdUsuario();
        consultarListaRoles();
        
    }
    public void onRowSelect3(SelectEvent event){
        idUsuaurio=usuarioObjeto.getIdUsuario();                   
        usuarioRolObjeto.setArea((AreaEntity)event.getObject());
        idArea=usuarioRolObjeto.getArea().getIdArea();
        consultarUsuarioRolPorAreaUsuario();
        System.out.println("idarea: "+idArea);
    }
    
    /**
     * Método que evalua los accesos al formulario
     */
    public void permisos() {
        ingresar = false;
        actualizar = false;
        eliminar = false;
        ArrayList<MenuPermisosEntity> permisos = (ArrayList<MenuPermisosEntity>) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("menuLateral");
        for (MenuPermisosEntity permisoObj : permisos) {
            for (MenuPermisosEntity nivel1 : permisoObj.getSubNivel()) {
                for (MenuPermisosEntity nivel2 : nivel1.getSubNivel()) {
                    int idPer = (int) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("idPermiso");
                    System.out.println("nn: " + nivel2.getNombrePermiso() + "-" + nivel2.getAsociadoMenu() + " - " + idPer);
                    if (idPer == nivel2.getAsociadoMenu()) {
                        switch (nivel2.getNombrePermiso()) {
                            case "insert":
                                ingresar = true;
                                break;
                            case "update":
                                actualizar = true;
                                break;
                            case "delete":
                                eliminar = true;
                                break;
                        }
                    }
                }
            }
        }
    }
}
