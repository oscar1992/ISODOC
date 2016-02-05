package co.com.siscomputo.proveedores.bean;

import co.com.siscomputo.proveedores.logic.TipoDocumentoLogic;
import co.com.siscomputo.endpoint.TipoDocumentoEntity;
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
@ManagedBean(name = "TipoDocumento")
@ViewScoped
public class TipoDocumentoBean implements Serializable{
    private ArrayList<TipoDocumentoEntity> lista;
    private ArrayList<TipoDocumentoEntity> listaFiltro;
    private TipoDocumentoEntity objetoTipoDocumento;
    private TipoDocumentoEntity objetoTipoDocumentoInsercion;
    private boolean ingresar;
    private boolean actualizar;
    private boolean eliminar;

    public ArrayList<TipoDocumentoEntity> getLista() {
        return lista;
    }

    public void setLista(ArrayList<TipoDocumentoEntity> lista) {
        this.lista = lista;
    }

    public ArrayList<TipoDocumentoEntity> getListaFiltro() {
        return listaFiltro;
    }

    public void setListaFiltro(ArrayList<TipoDocumentoEntity> listaFiltro) {
        this.listaFiltro = listaFiltro;
    }

    public TipoDocumentoEntity getObjetoTipoDocumento() {
        return objetoTipoDocumento;
    }

    public void setObjetoTipoDocumento(TipoDocumentoEntity objetoTipoDocumento) {
        this.objetoTipoDocumento = objetoTipoDocumento;
    }

    public TipoDocumentoEntity getObjetoTipoDocumentoInsercion() {
        return objetoTipoDocumentoInsercion;
    }

    public void setObjetoTipoDocumentoInsercion(TipoDocumentoEntity objetoTipoDocumentoInsercion) {
        this.objetoTipoDocumentoInsercion = objetoTipoDocumentoInsercion;
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
        consultarTipoDocumento();
        permisos();
    }
    public TipoDocumentoBean() {
        objetoTipoDocumento=new TipoDocumentoEntity();
        objetoTipoDocumentoInsercion=new TipoDocumentoEntity();
    }
    /**
     * Método que trae una lista de Tipo de Documento
     */
    public void consultarTipoDocumento(){
        try {
            TipoDocumentoLogic tipoDocumentoLogic=new TipoDocumentoLogic();
            lista=tipoDocumentoLogic.listaTipoDocumento();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * Método que permite insertar un Tipo de Documento nuevo
     */
    public void instertarTipoDocumento(){
        try {
            TipoDocumentoLogic tipoDocumentoLogic=new TipoDocumentoLogic();
            TipoDocumentoEntity tipoDocumentoEntity=tipoDocumentoLogic.insertarTipoDocumento(objetoTipoDocumentoInsercion);
            FacesMessage msg=null;
            if(tipoDocumentoEntity!=null){
                MensajesJSF.muestraMensajes("inserción de Tipo de Documento correcto", "Mensaje");                
                adicionarMetodoPtoteccionLista(tipoDocumentoEntity);                
            }else{
                MensajesJSF.muestraMensajes("inserción de Tipo de Documento incorrecto", "Error");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        RequestContext.getCurrentInstance().execute("PF('insertarTipoDocumento').hide()");
        RequestContext context = RequestContext.getCurrentInstance();
        context.update("IngresarModal:insertarTipoDocumentoModal");
    }
    /**
     * Método que añade un Tipo de Documento visualmente
     * @param objetoTipoDocumento 
     */
    private void adicionarMetodoPtoteccionLista(TipoDocumentoEntity objetoTipoDocumento) {
        lista.add(objetoTipoDocumento);
    }
/**
     * Método que permite actualizar un Tipo de Documento
     */
    public void actualizarTipoDocumento(){
        TipoDocumentoLogic metodoRecuperacionLogic=new TipoDocumentoLogic();
        String valida=metodoRecuperacionLogic.actualizarTipoDocumento(objetoTipoDocumento);
        FacesMessage msg=null;
        if("Ok".equalsIgnoreCase(valida)){
            MensajesJSF.muestraMensajes("actualización de Tipo de Documento correcto", "Mensaje");            
            actualizarTipoDocumentoLista(objetoTipoDocumento);
        }else{
            MensajesJSF.muestraMensajes("actualización de Tipo de Documento incorrecto", "Error");
        }
        nuevoTipoDocumentoObjeto();
        RequestContext.getCurrentInstance().execute("PF('actualizarTipoDocumento').hide()");
    }
    /**
     * Método que actualiza visualmente la lista de Tipo de Documento
     * @param objetoTipoDocumento 
     */
    private void actualizarTipoDocumentoLista(TipoDocumentoEntity objetoTipoDocumento) {
        try {
            ArrayList<TipoDocumentoEntity>listaaux=new ArrayList<>();
            if(lista!=null){
                for(TipoDocumentoEntity item:lista){
                    int v1=objetoTipoDocumento.getIdTipoDocumento();
                    int v2=item.getIdTipoDocumento();
                    if(v1==v2){
                        listaaux.add(objetoTipoDocumento);
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
        objetoTipoDocumento=(TipoDocumentoEntity)event.getObject();
    }
    /**
    Método que elimina un Tipo de Documento
    */
    public void eliminarTipoDocumento(){
        TipoDocumentoLogic metodoRecuperacionLogic=new TipoDocumentoLogic();
        objetoTipoDocumento.setEstadoTipoDocumento("E");
        metodoRecuperacionLogic.actualizarTipoDocumento(objetoTipoDocumento);
        eliminarTipoDocumentoLista(objetoTipoDocumento);
        RequestContext.getCurrentInstance().execute("PF('actualizarTipoDocumento').hide()");
        nuevoTipoDocumentoObjeto();
    }
    /**
     * Método que elimina visualmente un objeto de la lista
     * @param objetoTipoDocumento 
     */
    private void eliminarTipoDocumentoLista(TipoDocumentoEntity objetoTipoDocumento) {
        Iterator itr=lista.iterator();
        while(itr.hasNext()){
            TipoDocumentoEntity metodoRecuperacionEntity=(TipoDocumentoEntity) itr.next();
            if(metodoRecuperacionEntity.getIdTipoDocumento()==objetoTipoDocumento.getIdTipoDocumento()){
                itr.remove();
            }
        }
    }
    /**
     * Método que reinicia el objeto Tipo de Documento
     */
    public void nuevoTipoDocumentoObjeto() {
        objetoTipoDocumento=new TipoDocumentoEntity();
        objetoTipoDocumentoInsercion=new TipoDocumentoEntity();
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