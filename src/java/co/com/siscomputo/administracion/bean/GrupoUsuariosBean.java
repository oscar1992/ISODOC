package co.com.siscomputo.administracion.bean;

import co.com.siscomputo.administracion.logic.GrupoUsuariosLogic;
import co.com.siscomputo.endpoint.GrupoUsuariosEntity;
import co.com.siscomputo.endpoint.MenuPermisosEntity;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;
import javax.faces.context.FacesContext;

/**
 *
 * @author LENOVO
 */
@ManagedBean(name = "GrupoUsuarios")
@ViewScoped
public class GrupoUsuariosBean implements Serializable{
    private ArrayList<GrupoUsuariosEntity> lista;
    private ArrayList<GrupoUsuariosEntity> listaFiltro;
    private GrupoUsuariosEntity objetoGrupoUsuarios;
    private GrupoUsuariosEntity objetoGrupoUsuariosInsercion;
    private boolean ingresar;
    private boolean actualizar;
    private boolean eliminar;

    public ArrayList<GrupoUsuariosEntity> getLista() {
        return lista;
    }

    public void setLista(ArrayList<GrupoUsuariosEntity> lista) {
        this.lista = lista;
    }

    public ArrayList<GrupoUsuariosEntity> getListaFiltro() {
        return listaFiltro;
    }

    public void setListaFiltro(ArrayList<GrupoUsuariosEntity> listaFiltro) {
        this.listaFiltro = listaFiltro;
    }

    public GrupoUsuariosEntity getObjetoGrupoUsuarios() {
        return objetoGrupoUsuarios;
    }

    public void setObjetoGrupoUsuarios(GrupoUsuariosEntity objetoGrupoUsuarios) {
        this.objetoGrupoUsuarios = objetoGrupoUsuarios;
    }

    public GrupoUsuariosEntity getObjetoGrupoUsuariosInsercion() {
        return objetoGrupoUsuariosInsercion;
    }

    public void setObjetoGrupoUsuariosInsercion(GrupoUsuariosEntity objetoGrupoUsuariosInsercion) {
        this.objetoGrupoUsuariosInsercion = objetoGrupoUsuariosInsercion;
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
    
    @PostConstruct
    public void init(){
        consultarGrupoUsuarios();
        permisos();
    }
    public GrupoUsuariosBean() {
        objetoGrupoUsuarios=new GrupoUsuariosEntity();
        objetoGrupoUsuariosInsercion=new GrupoUsuariosEntity();
    }
    /**
     * Método que trae una lista de Grupo de Usuarios
     */
    public void consultarGrupoUsuarios(){
        try {
            GrupoUsuariosLogic grupoUsuariosLogic=new GrupoUsuariosLogic();
            lista=grupoUsuariosLogic.listaGrupoUsuarios();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * Método que permite insertar un Grupo de Usuarios nuevo
     */
    public void instertarGrupoUsuarios(){
        try {
            GrupoUsuariosLogic grupoUsuariosLogic=new GrupoUsuariosLogic();
            GrupoUsuariosEntity grupoUsuariosEntity=grupoUsuariosLogic.insertarGrupoUsuarios(objetoGrupoUsuariosInsercion);
            FacesMessage msg=null;
            if(grupoUsuariosEntity!=null){
                msg=new FacesMessage("", "inserción de Grupo de Usuarios correcto");
                adicionarMetodoPtoteccionLista(grupoUsuariosEntity);
            }else{
                msg=new FacesMessage("", "inserción de Grupo de Usuarios incorrecto");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * Método que añade un Grupo de Usuarios visualmente
     * @param objetoGrupoUsuarios 
     */
    private void adicionarMetodoPtoteccionLista(GrupoUsuariosEntity objetoGrupoUsuarios) {
        lista.add(objetoGrupoUsuarios);
    }
/**
     * Método que permite actualizar un Grupo de Usuarios
     */
    public void actualizarGrupoUsuarios(){
        GrupoUsuariosLogic metodoRecuperacionLogic=new GrupoUsuariosLogic();
        String valida=metodoRecuperacionLogic.actualizarGrupoUsuarios(objetoGrupoUsuarios);
        FacesMessage msg=null;
        if("Ok".equalsIgnoreCase(valida)){
            msg=new FacesMessage("", "actualización de Grupo de Usuarios correcto");
            actualizarGrupoUsuariosLista(objetoGrupoUsuarios);
        }else{
            msg=new FacesMessage("", "actualización de Grupo de Usuarios incorrecto");
        }
        nuevoGrupoUsuariosObjeto();
        RequestContext.getCurrentInstance().execute("PF('actualizarGrupoUsuarios').hide()");
    }
    /**
     * Método que actualiza visualmente la lista de Grupo de Usuarios
     * @param objetoGrupoUsuarios 
     */
    private void actualizarGrupoUsuariosLista(GrupoUsuariosEntity objetoGrupoUsuarios) {
        try {
            ArrayList<GrupoUsuariosEntity>listaaux=new ArrayList<>();
            if(lista!=null){
                for(GrupoUsuariosEntity item:lista){
                    int v1=objetoGrupoUsuarios.getIdGrupoUsuarios();
                    int v2=item.getIdGrupoUsuarios();
                    if(v1==v2){
                        listaaux.add(objetoGrupoUsuarios);
                    }else{
                        listaaux.add(item);
                    }
                }
            }
            this.lista=new ArrayList<>();
            this.lista=listaaux;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * Método que se invoca al seleccionar una fila de la tabla
     * @param event 
     */
    public void onRowSelect(SelectEvent event){
        objetoGrupoUsuarios=(GrupoUsuariosEntity)event.getObject();
    }
    /**
    Método que elimina un Grupo de Usuarios
    */
    public void eliminarGrupoUsuarios(){
        GrupoUsuariosLogic metodoRecuperacionLogic=new GrupoUsuariosLogic();
        objetoGrupoUsuarios.setEstadoGrupoUsuarios("E");
        metodoRecuperacionLogic.actualizarGrupoUsuarios(objetoGrupoUsuarios);
        eliminarGrupoUsuariosLista(objetoGrupoUsuarios);
        RequestContext.getCurrentInstance().execute("PF('actualizarGrupoUsuarios').hide()");
        nuevoGrupoUsuariosObjeto();
    }
    /**
     * Método que elimina visualmente un objeto de la lista
     * @param objetoGrupoUsuarios 
     */
    private void eliminarGrupoUsuariosLista(GrupoUsuariosEntity objetoGrupoUsuarios) {
        Iterator itr=lista.iterator();
        while(itr.hasNext()){
            GrupoUsuariosEntity metodoRecuperacionEntity=(GrupoUsuariosEntity) itr.next();
            if(metodoRecuperacionEntity.getIdGrupoUsuarios()==objetoGrupoUsuarios.getIdGrupoUsuarios()){
                itr.remove();
            }
        }
    }
    /**
     * Método que reinicia el objeto Grupo de Usuarios
     */
    public void nuevoGrupoUsuariosObjeto() {
        objetoGrupoUsuarios=new GrupoUsuariosEntity();
        objetoGrupoUsuariosInsercion=new GrupoUsuariosEntity();
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
                    //System.out.println("nn: " + nivel2.getNombrePermiso() + "-" + nivel2.getAsociadoMenu() + " - " + idPer);
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