package co.com.siscomputo.gestiondocumental.bean;

import co.com.siscomputo.gestiondocumental.logic.GrupoDocumentoLogic;
import co.com.siscomputo.endpoint.GrupoDocumentoEntity;
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
@ManagedBean(name = "GrupoDocumento")
@ViewScoped
public class GrupoDocumentoBean implements Serializable{
    private ArrayList<GrupoDocumentoEntity> lista;
    private ArrayList<GrupoDocumentoEntity> listaFiltro;
    private GrupoDocumentoEntity objetoGrupoDocumento;
    private GrupoDocumentoEntity objetoGrupoDocumentoInsercion;
    private boolean ingresar;
    private boolean actualizar;
    private boolean eliminar;

    public ArrayList<GrupoDocumentoEntity> getLista() {
        return lista;
    }

    public void setLista(ArrayList<GrupoDocumentoEntity> lista) {
        this.lista = lista;
    }

    public ArrayList<GrupoDocumentoEntity> getListaFiltro() {
        return listaFiltro;
    }

    public void setListaFiltro(ArrayList<GrupoDocumentoEntity> listaFiltro) {
        this.listaFiltro = listaFiltro;
    }

    public GrupoDocumentoEntity getObjetoGrupoDocumento() {
        return objetoGrupoDocumento;
    }

    public void setObjetoGrupoDocumento(GrupoDocumentoEntity objetoGrupoDocumento) {
        this.objetoGrupoDocumento = objetoGrupoDocumento;
    }

    public GrupoDocumentoEntity getObjetoGrupoDocumentoInsercion() {
        return objetoGrupoDocumentoInsercion;
    }

    public void setObjetoGrupoDocumentoInsercion(GrupoDocumentoEntity objetoGrupoDocumentoInsercion) {
        this.objetoGrupoDocumentoInsercion = objetoGrupoDocumentoInsercion;
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
        consultarGrupoDocumento();
        permisos();
    }
    public GrupoDocumentoBean() {
        objetoGrupoDocumento=new GrupoDocumentoEntity();
        objetoGrupoDocumentoInsercion=new GrupoDocumentoEntity();
    }
    /**
     * Método que trae una lista de Grupos por Documento
     */
    public void consultarGrupoDocumento(){
        try {
            GrupoDocumentoLogic grupoDocumentoLogic=new GrupoDocumentoLogic();
            lista=grupoDocumentoLogic.listaGrupoDocumento();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * Método que permite insertar un Grupos por Documento nuevo
     */
    public void instertarGrupoDocumento(){
        try {
            GrupoDocumentoLogic grupoDocumentoLogic=new GrupoDocumentoLogic();
            GrupoDocumentoEntity grupoDocumentoEntity=grupoDocumentoLogic.insertarGrupoDocumento(objetoGrupoDocumentoInsercion);
            FacesMessage msg=null;
            if(grupoDocumentoEntity!=null){
                msg=new FacesMessage("", "inserción de Grupos por Documento correcto");
                adicionarMetodoPtoteccionLista(grupoDocumentoEntity);
            }else{
                msg=new FacesMessage("", "inserción de Grupos por Documento incorrecto");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * Método que añade un Grupos por Documento visualmente
     * @param objetoGrupoDocumento 
     */
    private void adicionarMetodoPtoteccionLista(GrupoDocumentoEntity objetoGrupoDocumento) {
        lista.add(objetoGrupoDocumento);
    }
/**
     * Método que permite actualizar un Grupos por Documento
     */
    public void actualizarGrupoDocumento(){
        GrupoDocumentoLogic metodoRecuperacionLogic=new GrupoDocumentoLogic();
        String valida=metodoRecuperacionLogic.actualizarGrupoDocumento(objetoGrupoDocumento);
        FacesMessage msg=null;
        if("Ok".equalsIgnoreCase(valida)){
            msg=new FacesMessage("", "actualización de Grupos por Documento correcto");
            actualizarGrupoDocumentoLista(objetoGrupoDocumento);
        }else{
            msg=new FacesMessage("", "actualización de Grupos por Documento incorrecto");
        }
        nuevoGrupoDocumentoObjeto();
        RequestContext.getCurrentInstance().execute("PF('actualizarGrupoDocumento').hide()");
    }
    /**
     * Método que actualiza visualmente la lista de Grupos por Documento
     * @param objetoGrupoDocumento 
     */
    private void actualizarGrupoDocumentoLista(GrupoDocumentoEntity objetoGrupoDocumento) {
        try {
            ArrayList<GrupoDocumentoEntity>listaaux=new ArrayList<>();
            if(lista!=null){
                for(GrupoDocumentoEntity item:lista){
                    int v1=objetoGrupoDocumento.getIdGrupoDocumento();
                    int v2=item.getIdGrupoDocumento();
                    if(v1==v2){
                        listaaux.add(objetoGrupoDocumento);
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
        objetoGrupoDocumento=(GrupoDocumentoEntity)event.getObject();
    }
    /**
    Método que elimina un Grupos por Documento
    */
    public void eliminarGrupoDocumento(){
        GrupoDocumentoLogic metodoRecuperacionLogic=new GrupoDocumentoLogic();
        //objetoGrupoDocumento.setEstadoGrupoDocumento("E");
        metodoRecuperacionLogic.actualizarGrupoDocumento(objetoGrupoDocumento);
        eliminarGrupoDocumentoLista(objetoGrupoDocumento);
        RequestContext.getCurrentInstance().execute("PF('actualizarGrupoDocumento').hide()");
        nuevoGrupoDocumentoObjeto();
    }
    /**
     * Método que elimina visualmente un objeto de la lista
     * @param objetoGrupoDocumento 
     */
    private void eliminarGrupoDocumentoLista(GrupoDocumentoEntity objetoGrupoDocumento) {
        Iterator itr=lista.iterator();
        while(itr.hasNext()){
            GrupoDocumentoEntity metodoRecuperacionEntity=(GrupoDocumentoEntity) itr.next();
            if(metodoRecuperacionEntity.getIdGrupoDocumento()==objetoGrupoDocumento.getIdGrupoDocumento()){
                itr.remove();
            }
        }
    }
    /**
     * Método que reinicia el objeto Grupos por Documento
     */
    public void nuevoGrupoDocumentoObjeto() {
        objetoGrupoDocumento=new GrupoDocumentoEntity();
        objetoGrupoDocumentoInsercion=new GrupoDocumentoEntity();
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