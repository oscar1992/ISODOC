package co.com.siscomputo.proveedores.bean;

import co.com.siscomputo.proveedores.logic.TipoMonedaLogic;
import co.com.siscomputo.endpoint.TipoMonedaEntity;
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
@ManagedBean(name = "TipoMoneda")
@ViewScoped
public class TipoMonedaBean implements Serializable{
    private ArrayList<TipoMonedaEntity> lista;
    private ArrayList<TipoMonedaEntity> listaFiltro;
    private TipoMonedaEntity objetoTipoMoneda;
    private TipoMonedaEntity objetoTipoMonedaInsercion;
    private boolean ingresar;
    private boolean actualizar;
    private boolean eliminar;

    public ArrayList<TipoMonedaEntity> getLista() {
        return lista;
    }

    public void setLista(ArrayList<TipoMonedaEntity> lista) {
        this.lista = lista;
    }

    public ArrayList<TipoMonedaEntity> getListaFiltro() {
        return listaFiltro;
    }

    public void setListaFiltro(ArrayList<TipoMonedaEntity> listaFiltro) {
        this.listaFiltro = listaFiltro;
    }

    public TipoMonedaEntity getObjetoTipoMoneda() {
        return objetoTipoMoneda;
    }

    public void setObjetoTipoMoneda(TipoMonedaEntity objetoTipoMoneda) {
        this.objetoTipoMoneda = objetoTipoMoneda;
    }

    public TipoMonedaEntity getObjetoTipoMonedaInsercion() {
        return objetoTipoMonedaInsercion;
    }

    public void setObjetoTipoMonedaInsercion(TipoMonedaEntity objetoTipoMonedaInsercion) {
        this.objetoTipoMonedaInsercion = objetoTipoMonedaInsercion;
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
        consultarTipoMoneda();
        permisos();
    }
    public TipoMonedaBean() {
        objetoTipoMoneda=new TipoMonedaEntity();
        objetoTipoMonedaInsercion=new TipoMonedaEntity();
    }
    /**
     * Método que trae una lista de Tipo de Moneda
     */
    public void consultarTipoMoneda(){
        try {
            TipoMonedaLogic tipoMonedaLogic=new TipoMonedaLogic();
            lista=tipoMonedaLogic.listaTipoMoneda();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * Método que permite insertar un Tipo de Moneda nuevo
     */
    public void instertarTipoMoneda(){
        try {
            TipoMonedaLogic tipoMonedaLogic=new TipoMonedaLogic();
            TipoMonedaEntity tipoMonedaEntity=tipoMonedaLogic.insertarTipoMoneda(objetoTipoMonedaInsercion);
            FacesMessage msg=null;
            if(tipoMonedaEntity!=null){
                MensajesJSF.muestraMensajes("inserción de Tipo de Moneda correcto", "Mensaje");
                adicionarMetodoPtoteccionLista(tipoMonedaEntity);
            }else{
                MensajesJSF.muestraMensajes("inserción de Tipo de Moneda incorrecto", "Error");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        RequestContext.getCurrentInstance().execute("PF('insertarTipoMoneda').hide()");
        RequestContext context = RequestContext.getCurrentInstance();
        context.update("IngresarModal:insertarTipoMonedaModal");
    }
    /**
     * Método que añade un Tipo de Moneda visualmente
     * @param objetoTipoMoneda 
     */
    private void adicionarMetodoPtoteccionLista(TipoMonedaEntity objetoTipoMoneda) {
        lista.add(objetoTipoMoneda);
    }
/**
     * Método que permite actualizar un Tipo de Moneda
     */
    public void actualizarTipoMoneda(){
        TipoMonedaLogic metodoRecuperacionLogic=new TipoMonedaLogic();
        String valida=metodoRecuperacionLogic.actualizarTipoMoneda(objetoTipoMoneda);
        FacesMessage msg=null;
        if("Ok".equalsIgnoreCase(valida)){
            MensajesJSF.muestraMensajes("actualización de Tipo de Moneda correcto", "Mensaje");
            actualizarTipoMonedaLista(objetoTipoMoneda);
        }else{
            MensajesJSF.muestraMensajes("actualización de Tipo de Moneda incorrecto", "Error");
        }
        nuevoTipoMonedaObjeto();
        RequestContext.getCurrentInstance().execute("PF('actualizarTipoMoneda').hide()");
    }
    /**
     * Método que actualiza visualmente la lista de Tipo de Moneda
     * @param objetoTipoMoneda 
     */
    private void actualizarTipoMonedaLista(TipoMonedaEntity objetoTipoMoneda) {
        try {
            ArrayList<TipoMonedaEntity>listaaux=new ArrayList<>();
            if(lista!=null){
                for(TipoMonedaEntity item:lista){
                    int v1=objetoTipoMoneda.getIdMoneda();
                    int v2=item.getIdMoneda();
                    if(v1==v2){
                        listaaux.add(objetoTipoMoneda);
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
        objetoTipoMoneda=(TipoMonedaEntity)event.getObject();
    }
    /**
    Método que elimina un Tipo de Moneda
    */
    public void eliminarTipoMoneda(){
        TipoMonedaLogic metodoRecuperacionLogic=new TipoMonedaLogic();
        objetoTipoMoneda.setEstadoMoneda("E");
        metodoRecuperacionLogic.actualizarTipoMoneda(objetoTipoMoneda);
        eliminarTipoMonedaLista(objetoTipoMoneda);
        RequestContext.getCurrentInstance().execute("PF('actualizarTipoMoneda').hide()");
        nuevoTipoMonedaObjeto();
    }
    /**
     * Método que elimina visualmente un objeto de la lista
     * @param objetoTipoMoneda 
     */
    private void eliminarTipoMonedaLista(TipoMonedaEntity objetoTipoMoneda) {
        Iterator itr=lista.iterator();
        while(itr.hasNext()){
            TipoMonedaEntity metodoRecuperacionEntity=(TipoMonedaEntity) itr.next();
            if(metodoRecuperacionEntity.getIdMoneda()==objetoTipoMoneda.getIdMoneda()){
                itr.remove();
            }
        }
    }
    /**
     * Método que reinicia el objeto Tipo de Moneda
     */
    public void nuevoTipoMonedaObjeto() {
        objetoTipoMoneda=new TipoMonedaEntity();
        objetoTipoMonedaInsercion=new TipoMonedaEntity();
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