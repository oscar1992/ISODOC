package co.com.siscomputo.proveedores.bean;

import co.com.siscomputo.proveedores.logic.TipoTributarioLogic;
import co.com.siscomputo.endpoint.TipoTributarioEntity;
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
@ManagedBean(name = "TipoTributario")
@ViewScoped
public class TipoTributarioBean implements Serializable{
    private ArrayList<TipoTributarioEntity> lista;
    private ArrayList<TipoTributarioEntity> listaFiltro;
    private TipoTributarioEntity objetoTipoTributario;
    private TipoTributarioEntity objetoTipoTributarioInsercion;
    private boolean ingresar;
    private boolean actualizar;
    private boolean eliminar;

    public ArrayList<TipoTributarioEntity> getLista() {
        return lista;
    }

    public void setLista(ArrayList<TipoTributarioEntity> lista) {
        this.lista = lista;
    }

    public ArrayList<TipoTributarioEntity> getListaFiltro() {
        return listaFiltro;
    }

    public void setListaFiltro(ArrayList<TipoTributarioEntity> listaFiltro) {
        this.listaFiltro = listaFiltro;
    }

    public TipoTributarioEntity getObjetoTipoTributario() {
        return objetoTipoTributario;
    }

    public void setObjetoTipoTributario(TipoTributarioEntity objetoTipoTributario) {
        this.objetoTipoTributario = objetoTipoTributario;
    }

    public TipoTributarioEntity getObjetoTipoTributarioInsercion() {
        return objetoTipoTributarioInsercion;
    }

    public void setObjetoTipoTributarioInsercion(TipoTributarioEntity objetoTipoTributarioInsercion) {
        this.objetoTipoTributarioInsercion = objetoTipoTributarioInsercion;
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
        consultarTipoTributario();
        permisos();
    }
    public TipoTributarioBean() {
        objetoTipoTributario=new TipoTributarioEntity();
        objetoTipoTributarioInsercion=new TipoTributarioEntity();
    }
    /**
     * Método que trae una lista de Tipo Tributario
     */
    public void consultarTipoTributario(){
        try {
            TipoTributarioLogic tipoTributarioLogic=new TipoTributarioLogic();
            lista=tipoTributarioLogic.listaTipoTributario();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * Método que permite insertar un Tipo Tributario nuevo
     */
    public void instertarTipoTributario(){
        try {
            TipoTributarioLogic tipoTributarioLogic=new TipoTributarioLogic();
            TipoTributarioEntity tipoTributarioEntity=tipoTributarioLogic.insertarTipoTributario(objetoTipoTributarioInsercion);
            FacesMessage msg=null;
            if(tipoTributarioEntity!=null){
                msg=new FacesMessage("", "inserción de Tipo Tributario correcto");
                adicionarMetodoPtoteccionLista(tipoTributarioEntity);
            }else{
                msg=new FacesMessage("", "inserción de Tipo Tributario incorrecto");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        RequestContext.getCurrentInstance().execute("PF('insertarTipoTributario').hide()");
        RequestContext context = RequestContext.getCurrentInstance();
        context.update("IngresarModal:insertarTipoTributarioModal");
    }
    /**
     * Método que añade un Tipo Tributario visualmente
     * @param objetoTipoTributario 
     */
    private void adicionarMetodoPtoteccionLista(TipoTributarioEntity objetoTipoTributario) {
        lista.add(objetoTipoTributario);
    }
/**
     * Método que permite actualizar un Tipo Tributario
     */
    public void actualizarTipoTributario(){
        TipoTributarioLogic metodoRecuperacionLogic=new TipoTributarioLogic();
        String valida=metodoRecuperacionLogic.actualizarTipoTributario(objetoTipoTributario);
        FacesMessage msg=null;
        if("Ok".equalsIgnoreCase(valida)){
            msg=new FacesMessage("", "actualización de Tipo Tributario correcto");
            actualizarTipoTributarioLista(objetoTipoTributario);
        }else{
            msg=new FacesMessage("", "actualización de Tipo Tributario incorrecto");
        }
        nuevoTipoTributarioObjeto();
        RequestContext.getCurrentInstance().execute("PF('actualizarTipoTributario').hide()");
    }
    /**
     * Método que actualiza visualmente la lista de Tipo Tributario
     * @param objetoTipoTributario 
     */
    private void actualizarTipoTributarioLista(TipoTributarioEntity objetoTipoTributario) {
        try {
            ArrayList<TipoTributarioEntity>listaaux=new ArrayList<>();
            if(lista!=null){
                for(TipoTributarioEntity item:lista){
                    int v1=objetoTipoTributario.getIdTipoTributario();
                    int v2=item.getIdTipoTributario();
                    if(v1==v2){
                        listaaux.add(objetoTipoTributario);
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
        objetoTipoTributario=(TipoTributarioEntity)event.getObject();
    }
    /**
    Método que elimina un Tipo Tributario
    */
    public void eliminarTipoTributario(){
        TipoTributarioLogic metodoRecuperacionLogic=new TipoTributarioLogic();
        objetoTipoTributario.setEstadoTipoTributario("E");
        metodoRecuperacionLogic.actualizarTipoTributario(objetoTipoTributario);
        eliminarTipoTributarioLista(objetoTipoTributario);
        RequestContext.getCurrentInstance().execute("PF('actualizarTipoTributario').hide()");
        nuevoTipoTributarioObjeto();
    }
    /**
     * Método que elimina visualmente un objeto de la lista
     * @param objetoTipoTributario 
     */
    private void eliminarTipoTributarioLista(TipoTributarioEntity objetoTipoTributario) {
        Iterator itr=lista.iterator();
        while(itr.hasNext()){
            TipoTributarioEntity metodoRecuperacionEntity=(TipoTributarioEntity) itr.next();
            if(metodoRecuperacionEntity.getIdTipoTributario()==objetoTipoTributario.getIdTipoTributario()){
                itr.remove();
            }
        }
    }
    /**
     * Método que reinicia el objeto Tipo Tributario
     */
    public void nuevoTipoTributarioObjeto() {
        objetoTipoTributario=new TipoTributarioEntity();
        objetoTipoTributarioInsercion=new TipoTributarioEntity();
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