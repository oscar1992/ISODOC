package co.com.siscomputo.proveedores.bean;

import co.com.siscomputo.proveedores.logic.TipoProveedorLogic;
import co.com.siscomputo.endpoint.TipoProveedorEntity;
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
@ManagedBean(name = "TipoProveedor")
@ViewScoped
public class TipoProveedorBean implements Serializable{
    private ArrayList<TipoProveedorEntity> lista;
    private ArrayList<TipoProveedorEntity> listaFiltro;
    private TipoProveedorEntity objetoTipoProveedor;
    private TipoProveedorEntity objetoTipoProveedorInsercion;
    private boolean ingresar;
    private boolean actualizar;
    private boolean eliminar;

    public ArrayList<TipoProveedorEntity> getLista() {
        return lista;
    }

    public void setLista(ArrayList<TipoProveedorEntity> lista) {
        this.lista = lista;
    }

    public ArrayList<TipoProveedorEntity> getListaFiltro() {
        return listaFiltro;
    }

    public void setListaFiltro(ArrayList<TipoProveedorEntity> listaFiltro) {
        this.listaFiltro = listaFiltro;
    }

    public TipoProveedorEntity getObjetoTipoProveedor() {
        return objetoTipoProveedor;
    }

    public void setObjetoTipoProveedor(TipoProveedorEntity objetoTipoProveedor) {
        this.objetoTipoProveedor = objetoTipoProveedor;
    }

    public TipoProveedorEntity getObjetoTipoProveedorInsercion() {
        return objetoTipoProveedorInsercion;
    }

    public void setObjetoTipoProveedorInsercion(TipoProveedorEntity objetoTipoProveedorInsercion) {
        this.objetoTipoProveedorInsercion = objetoTipoProveedorInsercion;
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
        consultarTipoProveedor();
        permisos();
    }
    public TipoProveedorBean() {
        objetoTipoProveedor=new TipoProveedorEntity();
        objetoTipoProveedorInsercion=new TipoProveedorEntity();
    }
    /**
     * Método que trae una lista de Tipo de Proveedor
     */
    public void consultarTipoProveedor(){
        try {
            TipoProveedorLogic tipoProveedorLogic=new TipoProveedorLogic();
            lista=tipoProveedorLogic.listaTipoProveedor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * Método que permite insertar un Tipo de Proveedor nuevo
     */
    public void instertarTipoProveedor(){
        try {
            TipoProveedorLogic tipoProveedorLogic=new TipoProveedorLogic();
            TipoProveedorEntity tipoProveedorEntity=tipoProveedorLogic.insertarTipoProveedor(objetoTipoProveedorInsercion);
            FacesMessage msg=null;
            if(tipoProveedorEntity!=null){
                msg=new FacesMessage("", "inserción de Tipo de Proveedor correcto");
                adicionarMetodoPtoteccionLista(tipoProveedorEntity);
            }else{
                msg=new FacesMessage("", "inserción de Tipo de Proveedor incorrecto");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        RequestContext.getCurrentInstance().execute("PF('insertarTipoProveedor').hide()");
        RequestContext context = RequestContext.getCurrentInstance();
        context.update("IngresarModal:insertarTipoProveedorModal");
    }
    /**
     * Método que añade un Tipo de Proveedor visualmente
     * @param objetoTipoProveedor 
     */
    private void adicionarMetodoPtoteccionLista(TipoProveedorEntity objetoTipoProveedor) {
        lista.add(objetoTipoProveedor);
    }
/**
     * Método que permite actualizar un Tipo de Proveedor
     */
    public void actualizarTipoProveedor(){
        TipoProveedorLogic metodoRecuperacionLogic=new TipoProveedorLogic();
        String valida=metodoRecuperacionLogic.actualizarTipoProveedor(objetoTipoProveedor);
        FacesMessage msg=null;
        if("Ok".equalsIgnoreCase(valida)){
            msg=new FacesMessage("", "actualización de Tipo de Proveedor correcto");
            actualizarTipoProveedorLista(objetoTipoProveedor);
        }else{
            msg=new FacesMessage("", "actualización de Tipo de Proveedor incorrecto");
        }
        nuevoTipoProveedorObjeto();
        RequestContext.getCurrentInstance().execute("PF('actualizarTipoProveedor').hide()");
    }
    /**
     * Método que actualiza visualmente la lista de Tipo de Proveedor
     * @param objetoTipoProveedor 
     */
    private void actualizarTipoProveedorLista(TipoProveedorEntity objetoTipoProveedor) {
        try {
            ArrayList<TipoProveedorEntity>listaaux=new ArrayList<>();
            if(lista!=null){
                for(TipoProveedorEntity item:lista){
                    int v1=objetoTipoProveedor.getIdTipoProveedor();
                    int v2=item.getIdTipoProveedor();
                    if(v1==v2){
                        listaaux.add(objetoTipoProveedor);
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
        objetoTipoProveedor=(TipoProveedorEntity)event.getObject();
    }
    /**
    Método que elimina un Tipo de Proveedor
    */
    public void eliminarTipoProveedor(){
        TipoProveedorLogic metodoRecuperacionLogic=new TipoProveedorLogic();
        objetoTipoProveedor.setEstadoTipoProveedor("E");
        metodoRecuperacionLogic.actualizarTipoProveedor(objetoTipoProveedor);
        eliminarTipoProveedorLista(objetoTipoProveedor);
        RequestContext.getCurrentInstance().execute("PF('actualizarTipoProveedor').hide()");
        nuevoTipoProveedorObjeto();
    }
    /**
     * Método que elimina visualmente un objeto de la lista
     * @param objetoTipoProveedor 
     */
    private void eliminarTipoProveedorLista(TipoProveedorEntity objetoTipoProveedor) {
        Iterator itr=lista.iterator();
        while(itr.hasNext()){
            TipoProveedorEntity metodoRecuperacionEntity=(TipoProveedorEntity) itr.next();
            if(metodoRecuperacionEntity.getIdTipoProveedor()==objetoTipoProveedor.getIdTipoProveedor()){
                itr.remove();
            }
        }
    }
    /**
     * Método que reinicia el objeto Tipo de Proveedor
     */
    public void nuevoTipoProveedorObjeto() {
        objetoTipoProveedor=new TipoProveedorEntity();
        objetoTipoProveedorInsercion=new TipoProveedorEntity();
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