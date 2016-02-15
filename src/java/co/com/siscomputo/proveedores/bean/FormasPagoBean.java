package co.com.siscomputo.proveedores.bean;

import co.com.siscomputo.proveedores.logic.FormasPagoLogic;
import co.com.siscomputo.endpoint.FormasPagoEntity;
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
@ManagedBean(name = "FormasPago")
@ViewScoped
public class FormasPagoBean implements Serializable{
    private ArrayList<FormasPagoEntity> lista;
    private ArrayList<FormasPagoEntity> listaFiltro;
    private FormasPagoEntity objetoFormasPago;
    private FormasPagoEntity objetoFormasPagoInsercion;
    private boolean ingresar;
    private boolean actualizar;
    private boolean eliminar;

    public ArrayList<FormasPagoEntity> getLista() {
        return lista;
    }

    public void setLista(ArrayList<FormasPagoEntity> lista) {
        this.lista = lista;
    }

    public ArrayList<FormasPagoEntity> getListaFiltro() {
        return listaFiltro;
    }

    public void setListaFiltro(ArrayList<FormasPagoEntity> listaFiltro) {
        this.listaFiltro = listaFiltro;
    }

    public FormasPagoEntity getObjetoFormasPago() {
        return objetoFormasPago;
    }

    public void setObjetoFormasPago(FormasPagoEntity objetoFormasPago) {
        this.objetoFormasPago = objetoFormasPago;
    }

    public FormasPagoEntity getObjetoFormasPagoInsercion() {
        return objetoFormasPagoInsercion;
    }

    public void setObjetoFormasPagoInsercion(FormasPagoEntity objetoFormasPagoInsercion) {
        this.objetoFormasPagoInsercion = objetoFormasPagoInsercion;
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
        consultarFormasPago();
        permisos();
    }
    public FormasPagoBean() {
        objetoFormasPago=new FormasPagoEntity();
        objetoFormasPagoInsercion=new FormasPagoEntity();
    }
    /**
     * Método que trae una lista de Forma de Pago
     */
    public void consultarFormasPago(){
        try {
            FormasPagoLogic formasPagoLogic=new FormasPagoLogic();
            lista=formasPagoLogic.listaFormasPago();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * Método que permite insertar un Forma de Pago nuevo
     */
    public void instertarFormasPago(){
        try {
            FormasPagoLogic formasPagoLogic=new FormasPagoLogic();
            FormasPagoEntity formasPagoEntity=formasPagoLogic.insertarFormasPago(objetoFormasPagoInsercion);
            FacesMessage msg=null;
            if(formasPagoEntity!=null){
                MensajesJSF.muestraMensajes("inserción de Tipo de Pago correcto", "Mensaje");                 
                adicionarMetodoPtoteccionLista(formasPagoEntity);
            }else{
                MensajesJSF.muestraMensajes("inserción de Tipo de Pago incorrecto", "Error"); 
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        RequestContext.getCurrentInstance().execute("PF('insertarFormasPago').hide()");
        RequestContext context = RequestContext.getCurrentInstance();
        context.update("IngresarModal:insertarFormasPagoModal");
    }
    /**
     * Método que añade un Forma de Pago visualmente
     * @param objetoFormasPago 
     */
    private void adicionarMetodoPtoteccionLista(FormasPagoEntity objetoFormasPago) {
        lista.add(objetoFormasPago);
    }
/**
     * Método que permite actualizar un Forma de Pago
     */
    public void actualizarFormasPago(){
        FormasPagoLogic metodoRecuperacionLogic=new FormasPagoLogic();
        String valida=metodoRecuperacionLogic.actualizarFormasPago(objetoFormasPago);
        FacesMessage msg=null;
        if("Ok".equalsIgnoreCase(valida)){
            MensajesJSF.muestraMensajes("actualización de Tipo de Pago correcto", "Mensaje");
            actualizarFormasPagoLista(objetoFormasPago);
        }else{
            MensajesJSF.muestraMensajes("actualización de Tipo de Pago incorrecto", "Error");
        }
        nuevoFormasPagoObjeto();
        RequestContext.getCurrentInstance().execute("PF('actualizarFormasPago').hide()");
    }
    /**
     * Método que actualiza visualmente la lista de Forma de Pago
     * @param objetoFormasPago 
     */
    private void actualizarFormasPagoLista(FormasPagoEntity objetoFormasPago) {
        try {
            ArrayList<FormasPagoEntity>listaaux=new ArrayList<>();
            if(lista!=null){
                for(FormasPagoEntity item:lista){
                    int v1=objetoFormasPago.getIdFormasPagos();
                    int v2=item.getIdFormasPagos();
                    if(v1==v2){
                        listaaux.add(objetoFormasPago);
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
        objetoFormasPago=(FormasPagoEntity)event.getObject();
    }
    /**
    Método que elimina un Forma de Pago
    */
    public void eliminarFormasPago(){
        FormasPagoLogic metodoRecuperacionLogic=new FormasPagoLogic();
        objetoFormasPago.setEstadoFormaPago("E");
        metodoRecuperacionLogic.actualizarFormasPago(objetoFormasPago);
        eliminarFormasPagoLista(objetoFormasPago);
        RequestContext.getCurrentInstance().execute("PF('actualizarFormasPago').hide()");
        nuevoFormasPagoObjeto();
    }
    /**
     * Método que elimina visualmente un objeto de la lista
     * @param objetoFormasPago 
     */
    private void eliminarFormasPagoLista(FormasPagoEntity objetoFormasPago) {
        Iterator itr=lista.iterator();
        while(itr.hasNext()){
            FormasPagoEntity metodoRecuperacionEntity=(FormasPagoEntity) itr.next();
            if(metodoRecuperacionEntity.getIdFormasPagos()==objetoFormasPago.getIdFormasPagos()){
                itr.remove();
            }
        }
    }
    /**
     * Método que reinicia el objeto Forma de Pago
     */
    public void nuevoFormasPagoObjeto() {
        objetoFormasPago=new FormasPagoEntity();
        objetoFormasPagoInsercion=new FormasPagoEntity();
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