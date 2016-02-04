package co.com.siscomputo.administracion.bean;

import co.com.siscomputo.administracion.logic.RutasLogic;
import co.com.siscomputo.endpoint.RutasEntity;
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
@ManagedBean(name = "Rutas")
@ViewScoped
public class RutasBean implements Serializable{
    private ArrayList<RutasEntity> lista;
    private ArrayList<RutasEntity> listaFiltro;
    private RutasEntity objetoRutas;
    private RutasEntity objetoRutasInsercion;
    private boolean ingresar;
    private boolean actualizar;
    private boolean eliminar;

    public ArrayList<RutasEntity> getLista() {
        return lista;
    }

    public void setLista(ArrayList<RutasEntity> lista) {
        this.lista = lista;
    }

    public ArrayList<RutasEntity> getListaFiltro() {
        return listaFiltro;
    }

    public void setListaFiltro(ArrayList<RutasEntity> listaFiltro) {
        this.listaFiltro = listaFiltro;
    }

    public RutasEntity getObjetoRutas() {
        return objetoRutas;
    }

    public void setObjetoRutas(RutasEntity objetoRutas) {
        this.objetoRutas = objetoRutas;
    }

    public RutasEntity getObjetoRutasInsercion() {
        return objetoRutasInsercion;
    }

    public void setObjetoRutasInsercion(RutasEntity objetoRutasInsercion) {
        this.objetoRutasInsercion = objetoRutasInsercion;
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
        consultarRutas();
        permisos();
    }
    public RutasBean() {
        objetoRutas=new RutasEntity();
        objetoRutasInsercion=new RutasEntity();
    }
    /**
     * Método que trae una lista de Ruta de Capeta
     */
    public void consultarRutas(){
        try {
            RutasLogic rutasLogic=new RutasLogic();
            lista=rutasLogic.listaRutas();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * Método que permite insertar un Ruta de Capeta nuevo
     */
    public void instertarRutas(){
        try {
            RutasLogic rutasLogic=new RutasLogic();
            RutasEntity rutasEntity=rutasLogic.ingresaRuta(objetoRutasInsercion);
            FacesMessage msg=null;
            if(rutasEntity!=null){
                msg=new FacesMessage("", "inserción de Ruta de Capeta correcto");
                adicionarMetodoPtoteccionLista(rutasEntity);
            }else{
                msg=new FacesMessage("", "inserción de Ruta de Capeta incorrecto");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * Método que añade un Ruta de Capeta visualmente
     * @param objetoRutas 
     */
    private void adicionarMetodoPtoteccionLista(RutasEntity objetoRutas) {
        lista.add(objetoRutas);
    }
/**
     * Método que permite actualizar un Ruta de Capeta
     */
    public void actualizarRutas(){
        RutasLogic metodoRecuperacionLogic=new RutasLogic();
        String valida=metodoRecuperacionLogic.actualizarRuta(objetoRutas);
        FacesMessage msg=null;
        if("Ok".equalsIgnoreCase(valida)){
            msg=new FacesMessage("", "actualización de Ruta de Capeta correcto");
            actualizarRutasLista(objetoRutas);
        }else{
            msg=new FacesMessage("", "actualización de Ruta de Capeta incorrecto");
        }
        nuevoRutasObjeto();
        RequestContext.getCurrentInstance().execute("PF('actualizarRutas').hide()");
    }
    /**
     * Método que actualiza visualmente la lista de Ruta de Capeta
     * @param objetoRutas 
     */
    private void actualizarRutasLista(RutasEntity objetoRutas) {
        try {
            ArrayList<RutasEntity>listaaux=new ArrayList<>();
            if(lista!=null){
                for(RutasEntity item:lista){
                    int v1=objetoRutas.getIdRutas();
                    int v2=item.getIdRutas();
                    if(v1==v2){
                        listaaux.add(objetoRutas);
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
        objetoRutas=(RutasEntity)event.getObject();
    }
    /**
    Método que elimina un Ruta de Capeta
    */
    public void eliminarRutas(){
        RutasLogic metodoRecuperacionLogic=new RutasLogic();
        //objetoRutas.setEstadoRutas("E");
        metodoRecuperacionLogic.actualizarRuta(objetoRutas);
        eliminarRutasLista(objetoRutas);
        RequestContext.getCurrentInstance().execute("PF('actualizarRutas').hide()");
        nuevoRutasObjeto();
    }
    /**
     * Método que elimina visualmente un objeto de la lista
     * @param objetoRutas 
     */
    private void eliminarRutasLista(RutasEntity objetoRutas) {
        Iterator itr=lista.iterator();
        while(itr.hasNext()){
            RutasEntity metodoRecuperacionEntity=(RutasEntity) itr.next();
            if(metodoRecuperacionEntity.getIdRutas()==objetoRutas.getIdRutas()){
                itr.remove();
            }
        }
    }
    /**
     * Método que reinicia el objeto Ruta de Capeta
     */
    public void nuevoRutasObjeto() {
        objetoRutas=new RutasEntity();
        objetoRutasInsercion=new RutasEntity();
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