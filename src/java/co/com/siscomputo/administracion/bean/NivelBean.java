package co.com.siscomputo.administracion.bean;

import co.com.siscomputo.administracion.logic.NivelLogic;
import co.com.siscomputo.endpoint.NivelEntity;
import co.com.siscomputo.endpoint.MenuPermisosEntity;
import java.util.ArrayList;
import java.io.Serializable;
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
@ManagedBean(name = "Nivel")
@ViewScoped
public class NivelBean implements Serializable{
    private ArrayList<NivelEntity> lista;
    private ArrayList<NivelEntity> listaFiltro;
    private NivelEntity objetoNivel;
    private NivelEntity objetoNivelInsercion;
    private boolean ingresar;
    private boolean actualizar;
    private boolean eliminar;

    public ArrayList<NivelEntity> getLista() {
        return lista;
    }

    public void setLista(ArrayList<NivelEntity> lista) {
        this.lista = lista;
    }

    public ArrayList<NivelEntity> getListaFiltro() {
        return listaFiltro;
    }

    public void setListaFiltro(ArrayList<NivelEntity> listaFiltro) {
        this.listaFiltro = listaFiltro;
    }

    public NivelEntity getObjetoNivel() {
        return objetoNivel;
    }

    public void setObjetoNivel(NivelEntity objetoNivel) {
        this.objetoNivel = objetoNivel;
    }

    public NivelEntity getObjetoNivelInsercion() {
        return objetoNivelInsercion;
    }

    public void setObjetoNivelInsercion(NivelEntity objetoNivelInsercion) {
        this.objetoNivelInsercion = objetoNivelInsercion;
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
        consultarNivel();
        permisos();
    }
    public NivelBean() {
        objetoNivel=new NivelEntity();
        objetoNivelInsercion=new NivelEntity();
    }
    /**
     * Método que trae una lista de Nivel de Proceso
     */
    public void consultarNivel(){
        try {
            NivelLogic nivelLogic=new NivelLogic();
            lista=nivelLogic.listaNivel();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * Método que permite insertar un Nivel de Proceso nuevo
     */
    public void instertarNivel(){
        try {
            NivelLogic nivelLogic=new NivelLogic();
            NivelEntity nivelEntity=nivelLogic.insertarNivel(objetoNivelInsercion);
            FacesMessage msg=null;
            if(nivelEntity!=null){
                msg=new FacesMessage("", "inserción de Nivel de Proceso correcto");
                adicionarMetodoPtoteccionLista(nivelEntity);
            }else{
                msg=new FacesMessage("", "inserción de Nivel de Proceso incorrecto");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * Método que añade un Nivel de Proceso visualmente
     * @param objetoNivel 
     */
    private void adicionarMetodoPtoteccionLista(NivelEntity objetoNivel) {
        lista.add(objetoNivel);
    }
/**
     * Método que permite actualizar un Nivel de Proceso
     */
    public void actualizarNivel(){
        NivelLogic metodoRecuperacionLogic=new NivelLogic();
        String valida=metodoRecuperacionLogic.actualizarNivel(objetoNivel);
        FacesMessage msg=null;
        if("Ok".equalsIgnoreCase(valida)){
            msg=new FacesMessage("", "actualización de Nivel de Proceso correcto");
            actualizarNivelLista(objetoNivel);
        }else{
            msg=new FacesMessage("", "actualización de Nivel de Proceso incorrecto");
        }
        nuevoNivelObjeto();
        RequestContext.getCurrentInstance().execute("PF('actualizarNivel').hide()");
    }
    /**
     * Método que actualiza visualmente la lista de Nivel de Proceso
     * @param objetoNivel 
     */
    private void actualizarNivelLista(NivelEntity objetoNivel) {
        try {
            ArrayList<NivelEntity>listaaux=new ArrayList<>();
            if(lista!=null){
                for(NivelEntity item:lista){
                    int v1=objetoNivel.getIdNivel();
                    int v2=item.getIdNivel();
                    if(v1==v2){
                        listaaux.add(objetoNivel);
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
        objetoNivel=(NivelEntity)event.getObject();
    }
    /**
    Método que elimina un Nivel de Proceso
    */
    public void eliminarNivel(){
        NivelLogic metodoRecuperacionLogic=new NivelLogic();
        objetoNivel.setEstadoNivel("E");
        metodoRecuperacionLogic.actualizarNivel(objetoNivel);
        eliminarNivelLista(objetoNivel);
        RequestContext.getCurrentInstance().execute("PF('actualizarNivel').hide()");
        nuevoNivelObjeto();
    }
    /**
     * Método que elimina visualmente un objeto de la lista
     * @param objetoNivel 
     */
    private void eliminarNivelLista(NivelEntity objetoNivel) {
        Iterator itr=lista.iterator();
        while(itr.hasNext()){
            NivelEntity metodoRecuperacionEntity=(NivelEntity) itr.next();
            if(metodoRecuperacionEntity.getIdNivel()==objetoNivel.getIdNivel()){
                itr.remove();
            }
        }
    }
    /**
     * Método que reinicia el objeto Nivel de Proceso
     */
    public void nuevoNivelObjeto() {
        objetoNivel=new NivelEntity();
        objetoNivelInsercion=new NivelEntity();
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