package co.com.siscomputo.proveedores.bean;

import co.com.siscomputo.proveedores.logic.LineaLogic;
import co.com.siscomputo.endpoint.LineaEntity;
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
@ManagedBean(name = "Linea")
@ViewScoped
public class LineaBean implements Serializable{
    private ArrayList<LineaEntity> lista;
    private ArrayList<LineaEntity> listaFiltro;
    private LineaEntity objetoLinea;
    private LineaEntity objetoLineaInsercion;
    private boolean ingresar;
    private boolean actualizar;
    private boolean eliminar;

    public ArrayList<LineaEntity> getLista() {
        return lista;
    }

    public void setLista(ArrayList<LineaEntity> lista) {
        this.lista = lista;
    }

    public ArrayList<LineaEntity> getListaFiltro() {
        return listaFiltro;
    }

    public void setListaFiltro(ArrayList<LineaEntity> listaFiltro) {
        this.listaFiltro = listaFiltro;
    }

    public LineaEntity getObjetoLinea() {
        return objetoLinea;
    }

    public void setObjetoLinea(LineaEntity objetoLinea) {
        this.objetoLinea = objetoLinea;
    }

    public LineaEntity getObjetoLineaInsercion() {
        return objetoLineaInsercion;
    }

    public void setObjetoLineaInsercion(LineaEntity objetoLineaInsercion) {
        this.objetoLineaInsercion = objetoLineaInsercion;
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
        consultarLinea();
        permisos();
    }
    public LineaBean() {
        objetoLinea=new LineaEntity();
        objetoLineaInsercion=new LineaEntity();
    }
    /**
     * Método que trae una lista de Linea del Proveedor
     */
    public void consultarLinea(){
        try {
            LineaLogic lineaLogic=new LineaLogic();
            lista=lineaLogic.listaLinea();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * Método que permite insertar un Linea del Proveedor nuevo
     */
    public void instertarLinea(){
        try {
            LineaLogic lineaLogic=new LineaLogic();
            LineaEntity lineaEntity=lineaLogic.insertarLinea(objetoLineaInsercion);
            FacesMessage msg=null;
            if(lineaEntity!=null){
                MensajesJSF.muestraMensajes("inserción de Linea del Proveedor correcto", "Mensaje");
                adicionarMetodoPtoteccionLista(lineaEntity);
            }else{
                MensajesJSF.muestraMensajes("inserción de Linea del Proveedor incorrecto", "Error");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * Método que añade un Linea del Proveedor visualmente
     * @param objetoLinea 
     */
    private void adicionarMetodoPtoteccionLista(LineaEntity objetoLinea) {
        lista.add(objetoLinea);
    }
/**
     * Método que permite actualizar un Linea del Proveedor
     */
    public void actualizarLinea(){
        LineaLogic metodoRecuperacionLogic=new LineaLogic();
        String valida=metodoRecuperacionLogic.actualizarLinea(objetoLinea);
        FacesMessage msg=null;
        if("Ok".equalsIgnoreCase(valida)){
            MensajesJSF.muestraMensajes("actualización de Linea del Proveedor correcto", "Mensaje");            
            actualizarLineaLista(objetoLinea);
        }else{
            MensajesJSF.muestraMensajes("actualización de Linea del Proveedor incorrecto", "Error");
        }
        nuevoLineaObjeto();
        RequestContext.getCurrentInstance().execute("PF('actualizarLinea').hide()");
    }
    /**
     * Método que actualiza visualmente la lista de Linea del Proveedor
     * @param objetoLinea 
     */
    private void actualizarLineaLista(LineaEntity objetoLinea) {
        try {
            ArrayList<LineaEntity>listaaux=new ArrayList<>();
            if(lista!=null){
                for(LineaEntity item:lista){
                    int v1=objetoLinea.getIdLinea();
                    int v2=item.getIdLinea();
                    if(v1==v2){
                        listaaux.add(objetoLinea);
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
        objetoLinea=(LineaEntity)event.getObject();
    }
    /**
    Método que elimina un Linea del Proveedor
    */
    public void eliminarLinea(){
        LineaLogic metodoRecuperacionLogic=new LineaLogic();
        objetoLinea.setEstadoLinea("E");
        metodoRecuperacionLogic.actualizarLinea(objetoLinea);
        eliminarLineaLista(objetoLinea);
        RequestContext.getCurrentInstance().execute("PF('actualizarLinea').hide()");
        nuevoLineaObjeto();
    }
    /**
     * Método que elimina visualmente un objeto de la lista
     * @param objetoLinea 
     */
    private void eliminarLineaLista(LineaEntity objetoLinea) {
        Iterator itr=lista.iterator();
        while(itr.hasNext()){
            LineaEntity metodoRecuperacionEntity=(LineaEntity) itr.next();
            if(metodoRecuperacionEntity.getIdLinea()==objetoLinea.getIdLinea()){
                itr.remove();
            }
        }
    }
    /**
     * Método que reinicia el objeto Linea del Proveedor
     */
    public void nuevoLineaObjeto() {
        objetoLinea=new LineaEntity();
        objetoLineaInsercion=new LineaEntity();
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