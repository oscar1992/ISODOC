package co.com.siscomputo.proveedores.bean;

import co.com.siscomputo.proveedores.logic.CuentasProveedoresLogic;
import co.com.siscomputo.endpoint.CuentasProveedoresEntity;
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
@ManagedBean(name = "CuentasProveedores")
@ViewScoped
public class CuentasProveedoresBean implements Serializable{
    private ArrayList<CuentasProveedoresEntity> lista;
    private ArrayList<CuentasProveedoresEntity> listaFiltro;
    private CuentasProveedoresEntity objetoCuentasProveedores;
    private CuentasProveedoresEntity objetoCuentasProveedoresInsercion;
    private boolean ingresar;
    private boolean actualizar;
    private boolean eliminar;

    public ArrayList<CuentasProveedoresEntity> getLista() {
        return lista;
    }

    public void setLista(ArrayList<CuentasProveedoresEntity> lista) {
        this.lista = lista;
    }

    public ArrayList<CuentasProveedoresEntity> getListaFiltro() {
        return listaFiltro;
    }

    public void setListaFiltro(ArrayList<CuentasProveedoresEntity> listaFiltro) {
        this.listaFiltro = listaFiltro;
    }

    public CuentasProveedoresEntity getObjetoCuentasProveedores() {
        return objetoCuentasProveedores;
    }

    public void setObjetoCuentasProveedores(CuentasProveedoresEntity objetoCuentasProveedores) {
        this.objetoCuentasProveedores = objetoCuentasProveedores;
    }

    public CuentasProveedoresEntity getObjetoCuentasProveedoresInsercion() {
        return objetoCuentasProveedoresInsercion;
    }

    public void setObjetoCuentasProveedoresInsercion(CuentasProveedoresEntity objetoCuentasProveedoresInsercion) {
        this.objetoCuentasProveedoresInsercion = objetoCuentasProveedoresInsercion;
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
        consultarCuentasProveedores();
        permisos();
    }
    public CuentasProveedoresBean() {
        objetoCuentasProveedores=new CuentasProveedoresEntity();
        objetoCuentasProveedoresInsercion=new CuentasProveedoresEntity();
    }
    /**
     * Método que trae una lista de Tipo de Cuenta de Proveedor
     */
    public void consultarCuentasProveedores(){
        try {
            CuentasProveedoresLogic cuentasProveedoresLogic=new CuentasProveedoresLogic();
            lista=cuentasProveedoresLogic.listaCuentasProveedores();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * Método que permite insertar un Tipo de Cuenta de Proveedor nuevo
     */
    public void instertarCuentasProveedores(){
        try {
            CuentasProveedoresLogic cuentasProveedoresLogic=new CuentasProveedoresLogic();
            CuentasProveedoresEntity cuentasProveedoresEntity=cuentasProveedoresLogic.insertarCuentasProveedores(objetoCuentasProveedoresInsercion);
            FacesMessage msg=null;
            if(cuentasProveedoresEntity!=null){
                msg=new FacesMessage("", "inserción de Tipo de Cuenta de Proveedor correcto");
                adicionarMetodoPtoteccionLista(cuentasProveedoresEntity);
            }else{
                msg=new FacesMessage("", "inserción de Tipo de Cuenta de Proveedor incorrecto");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        RequestContext.getCurrentInstance().execute("PF('insertarCuentasProveedores').hide()");
        RequestContext context = RequestContext.getCurrentInstance();
        context.update("IngresarModal:insertarCuentasProveedoresModal");
    }
    /**
     * Método que añade un Tipo de Cuenta de Proveedor visualmente
     * @param objetoCuentasProveedores 
     */
    private void adicionarMetodoPtoteccionLista(CuentasProveedoresEntity objetoCuentasProveedores) {
        lista.add(objetoCuentasProveedores);
    }
/**
     * Método que permite actualizar un Tipo de Cuenta de Proveedor
     */
    public void actualizarCuentasProveedores(){
        CuentasProveedoresLogic metodoRecuperacionLogic=new CuentasProveedoresLogic();
        String valida=metodoRecuperacionLogic.actualizarCuentasProveedores(objetoCuentasProveedores);
        FacesMessage msg=null;
        if("Ok".equalsIgnoreCase(valida)){
            msg=new FacesMessage("", "actualización de Tipo de Cuenta de Proveedor correcto");
            actualizarCuentasProveedoresLista(objetoCuentasProveedores);
        }else{
            msg=new FacesMessage("", "actualización de Tipo de Cuenta de Proveedor incorrecto");
        }
        nuevoCuentasProveedoresObjeto();
        RequestContext.getCurrentInstance().execute("PF('actualizarCuentasProveedores').hide()");
    }
    /**
     * Método que actualiza visualmente la lista de Tipo de Cuenta de Proveedor
     * @param objetoCuentasProveedores 
     */
    private void actualizarCuentasProveedoresLista(CuentasProveedoresEntity objetoCuentasProveedores) {
        try {
            ArrayList<CuentasProveedoresEntity>listaaux=new ArrayList<>();
            if(lista!=null){
                for(CuentasProveedoresEntity item:lista){
                    int v1=objetoCuentasProveedores.getIdCuentasProveedores();
                    int v2=item.getIdCuentasProveedores();
                    if(v1==v2){
                        listaaux.add(objetoCuentasProveedores);
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
        objetoCuentasProveedores=(CuentasProveedoresEntity)event.getObject();
    }
    /**
    Método que elimina un Tipo de Cuenta de Proveedor
    */
    public void eliminarCuentasProveedores(){
        CuentasProveedoresLogic metodoRecuperacionLogic=new CuentasProveedoresLogic();
        objetoCuentasProveedores.setEstadoCuentasProveedores("E");
        metodoRecuperacionLogic.actualizarCuentasProveedores(objetoCuentasProveedores);
        eliminarCuentasProveedoresLista(objetoCuentasProveedores);
        RequestContext.getCurrentInstance().execute("PF('actualizarCuentasProveedores').hide()");
        nuevoCuentasProveedoresObjeto();
    }
    /**
     * Método que elimina visualmente un objeto de la lista
     * @param objetoCuentasProveedores 
     */
    private void eliminarCuentasProveedoresLista(CuentasProveedoresEntity objetoCuentasProveedores) {
        Iterator itr=lista.iterator();
        while(itr.hasNext()){
            CuentasProveedoresEntity metodoRecuperacionEntity=(CuentasProveedoresEntity) itr.next();
            if(metodoRecuperacionEntity.getIdCuentasProveedores()==objetoCuentasProveedores.getIdCuentasProveedores()){
                itr.remove();
            }
        }
    }
    /**
     * Método que reinicia el objeto Tipo de Cuenta de Proveedor
     */
    public void nuevoCuentasProveedoresObjeto() {
        objetoCuentasProveedores=new CuentasProveedoresEntity();
        objetoCuentasProveedoresInsercion=new CuentasProveedoresEntity();
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