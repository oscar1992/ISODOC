package co.com.siscomputo.proveedores.bean;

import co.com.siscomputo.proveedores.logic.AnexoProveedorLogic;
import co.com.siscomputo.endpoint.AnexoProveedorEntity;
import co.com.siscomputo.endpoint.MenuPermisosEntity;
import co.com.siscomputo.utilidades.MensajesJSF;
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
@ManagedBean(name = "AnexoProveedor")
@ViewScoped
public class AnexoProveedorBean implements Serializable{
    private ArrayList<AnexoProveedorEntity> lista;
    private ArrayList<AnexoProveedorEntity> listaFiltro;
    private AnexoProveedorEntity objetoAnexoProveedor;
    private AnexoProveedorEntity objetoAnexoProveedorInsercion;
    private boolean ingresar;
    private boolean actualizar;
    private boolean eliminar;

    public ArrayList<AnexoProveedorEntity> getLista() {
        return lista;
    }

    public void setLista(ArrayList<AnexoProveedorEntity> lista) {
        this.lista = lista;
    }

    public ArrayList<AnexoProveedorEntity> getListaFiltro() {
        return listaFiltro;
    }

    public void setListaFiltro(ArrayList<AnexoProveedorEntity> listaFiltro) {
        this.listaFiltro = listaFiltro;
    }

    public AnexoProveedorEntity getObjetoAnexoProveedor() {
        return objetoAnexoProveedor;
    }

    public void setObjetoAnexoProveedor(AnexoProveedorEntity objetoAnexoProveedor) {
        this.objetoAnexoProveedor = objetoAnexoProveedor;
    }

    public AnexoProveedorEntity getObjetoAnexoProveedorInsercion() {
        return objetoAnexoProveedorInsercion;
    }

    public void setObjetoAnexoProveedorInsercion(AnexoProveedorEntity objetoAnexoProveedorInsercion) {
        this.objetoAnexoProveedorInsercion = objetoAnexoProveedorInsercion;
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
        consultarAnexoProveedor();
        permisos();
    }
    public AnexoProveedorBean() {
        objetoAnexoProveedor=new AnexoProveedorEntity();
        objetoAnexoProveedorInsercion=new AnexoProveedorEntity();
    }
    /**
     * Método que trae una lista de Anexos del proveedor
     */
    public void consultarAnexoProveedor(){
        try {
            AnexoProveedorLogic anexoProveedorLogic=new AnexoProveedorLogic();
            lista=anexoProveedorLogic.listaAnexoProveedor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * Método que permite insertar un Anexos del proveedor nuevo
     */
    public void instertarAnexoProveedor(){
        try {
            AnexoProveedorLogic anexoProveedorLogic=new AnexoProveedorLogic();
            AnexoProveedorEntity anexoProveedorEntity=anexoProveedorLogic.insertarAnexoProveedor(objetoAnexoProveedorInsercion);
            FacesMessage msg=null;
            if(anexoProveedorEntity!=null){
                MensajesJSF.muestraMensajes("inserción de Anexos del proveedor correcto", "Mensaje");
                adicionarMetodoPtoteccionLista(anexoProveedorEntity);
            }else{
                MensajesJSF.muestraMensajes("inserción de Anexos del proveedor incorrecto", "Error");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        RequestContext.getCurrentInstance().execute("PF('insertarAnexoProveedor').hide()");
        RequestContext context = RequestContext.getCurrentInstance();
        context.update("IngresarModal:insertarAnexoProveedorModal");
    }
    /**
     * Método que añade un Anexos del proveedor visualmente
     * @param objetoAnexoProveedor 
     */
    private void adicionarMetodoPtoteccionLista(AnexoProveedorEntity objetoAnexoProveedor) {
        lista.add(objetoAnexoProveedor);
    }
/**
     * Método que permite actualizar un Anexos del proveedor
     */
    public void actualizarAnexoProveedor(){
        AnexoProveedorLogic metodoRecuperacionLogic=new AnexoProveedorLogic();
        String valida=metodoRecuperacionLogic.actualizarAnexoProveedor(objetoAnexoProveedor);
        FacesMessage msg=null;
        if("Ok".equalsIgnoreCase(valida)){
            MensajesJSF.muestraMensajes("actualización de Anexos del proveedor correcto", "Mensaje");
            actualizarAnexoProveedorLista(objetoAnexoProveedor);
        }else{
            MensajesJSF.muestraMensajes("actualización de Anexos del proveedor incorrecto", "Error");
        }
        nuevoAnexoProveedorObjeto();
        RequestContext.getCurrentInstance().execute("PF('actualizarAnexoProveedor').hide()");
    }
    /**
     * Método que actualiza visualmente la lista de Anexos del proveedor
     * @param objetoAnexoProveedor 
     */
    private void actualizarAnexoProveedorLista(AnexoProveedorEntity objetoAnexoProveedor) {
        try {
            ArrayList<AnexoProveedorEntity>listaaux=new ArrayList<>();
            if(lista!=null){
                for(AnexoProveedorEntity item:lista){
                    int v1=objetoAnexoProveedor.getIdAnexoProveedor();
                    int v2=item.getIdAnexoProveedor();
                    if(v1==v2){
                        listaaux.add(objetoAnexoProveedor);
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
        objetoAnexoProveedor=(AnexoProveedorEntity)event.getObject();
    }
    /**
    Método que elimina un Anexos del proveedor
    */
    public void eliminarAnexoProveedor(){
        AnexoProveedorLogic metodoRecuperacionLogic=new AnexoProveedorLogic();        
        metodoRecuperacionLogic.actualizarAnexoProveedor(objetoAnexoProveedor);
        eliminarAnexoProveedorLista(objetoAnexoProveedor);
        RequestContext.getCurrentInstance().execute("PF('actualizarAnexoProveedor').hide()");
        nuevoAnexoProveedorObjeto();
    }
    /**
     * Método que elimina visualmente un objeto de la lista
     * @param objetoAnexoProveedor 
     */
    private void eliminarAnexoProveedorLista(AnexoProveedorEntity objetoAnexoProveedor) {
        Iterator itr=lista.iterator();
        while(itr.hasNext()){
            AnexoProveedorEntity metodoRecuperacionEntity=(AnexoProveedorEntity) itr.next();
            if(metodoRecuperacionEntity.getIdAnexoProveedor()==objetoAnexoProveedor.getIdAnexoProveedor()){
                itr.remove();
            }
        }
    }
    /**
     * Método que reinicia el objeto Anexos del proveedor
     */
    public void nuevoAnexoProveedorObjeto() {
        objetoAnexoProveedor=new AnexoProveedorEntity();
        objetoAnexoProveedorInsercion=new AnexoProveedorEntity();
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