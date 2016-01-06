package co.com.siscomputo.gestiondocumental.bean;

import co.com.siscomputo.gestiondocumental.logic.DocumentoRolLogic;
import co.com.siscomputo.endpoint.DocumentoRolEntity;
import co.com.siscomputo.endpoint.MenuPermisosEntity;
import co.com.siscomputo.endpoint.RolesEntity;
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
@ManagedBean(name = "DocumentoRol")
@ViewScoped
public class DocumentoRolBean implements Serializable{
    private ArrayList<DocumentoRolEntity> lista;
    private ArrayList<DocumentoRolEntity> listaFiltro;
    private DocumentoRolEntity objetoDocumentoRol;
    private DocumentoRolEntity objetoDocumentoRolInsercion;
    private boolean ingresar;
    private boolean actualizar;
    private boolean eliminar;

    public ArrayList<DocumentoRolEntity> getLista() {
        return lista;
    }

    public void setLista(ArrayList<DocumentoRolEntity> lista) {
        this.lista = lista;
    }

    public ArrayList<DocumentoRolEntity> getListaFiltro() {
        return listaFiltro;
    }

    public void setListaFiltro(ArrayList<DocumentoRolEntity> listaFiltro) {
        this.listaFiltro = listaFiltro;
    }

    public DocumentoRolEntity getObjetoDocumentoRol() {
        return objetoDocumentoRol;
    }

    public void setObjetoDocumentoRol(DocumentoRolEntity objetoDocumentoRol) {
        this.objetoDocumentoRol = objetoDocumentoRol;
    }

    public DocumentoRolEntity getObjetoDocumentoRolInsercion() {
        return objetoDocumentoRolInsercion;
    }

    public void setObjetoDocumentoRolInsercion(DocumentoRolEntity objetoDocumentoRolInsercion) {
        this.objetoDocumentoRolInsercion = objetoDocumentoRolInsercion;
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
        consultarDocumentoRol();
        permisos();
    }
    public DocumentoRolBean() {
        nuevoDocumentoRolObjeto();
    }
    /**
     * Método que trae una lista de Documentos Rol
     */
    public void consultarDocumentoRol(){
        try {
            DocumentoRolLogic documentoRolLogic=new DocumentoRolLogic();
            lista=documentoRolLogic.listaDocumentoRol();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * Método que permite insertar un Documentos Rol nuevo
     */
    public void instertarDocumentoRol(){
        try {
            DocumentoRolLogic documentoRolLogic=new DocumentoRolLogic();
            DocumentoRolEntity documentoRolEntity=documentoRolLogic.insertarDocumentoRol(objetoDocumentoRolInsercion);
            FacesMessage msg=null;
            if(documentoRolEntity!=null){
                msg=new FacesMessage("", "inserción de Documentos Rol correcto");
                adicionarMetodoPtoteccionLista(documentoRolEntity);
            }else{
                msg=new FacesMessage("", "inserción de Documentos Rol incorrecto");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * Método que añade un Documentos Rol visualmente
     * @param objetoDocumentoRol 
     */
    private void adicionarMetodoPtoteccionLista(DocumentoRolEntity objetoDocumentoRol) {
        lista.add(objetoDocumentoRol);
    }
/**
     * Método que permite actualizar un Documentos Rol
     */
    public void actualizarDocumentoRol(){
        DocumentoRolLogic metodoRecuperacionLogic=new DocumentoRolLogic();
        String valida=metodoRecuperacionLogic.actualizarDocumentoRol(objetoDocumentoRol);
        FacesMessage msg=null;
        if("Ok".equalsIgnoreCase(valida)){
            msg=new FacesMessage("", "actualización de Documentos Rol correcto");
            actualizarDocumentoRolLista(objetoDocumentoRol);
        }else{
            msg=new FacesMessage("", "actualización de Documentos Rol incorrecto");
        }
        nuevoDocumentoRolObjeto();
        RequestContext.getCurrentInstance().execute("PF('actualizarDocumentoRol').hide()");
    }
    /**
     * Método que actualiza visualmente la lista de Documentos Rol
     * @param objetoDocumentoRol 
     */
    private void actualizarDocumentoRolLista(DocumentoRolEntity objetoDocumentoRol) {
        try {
            ArrayList<DocumentoRolEntity>listaaux=new ArrayList<>();
            if(lista!=null){
                for(DocumentoRolEntity item:lista){
                    int v1=objetoDocumentoRol.getIdDocumentoRol();
                    int v2=item.getIdDocumentoRol();
                    if(v1==v2){
                        listaaux.add(objetoDocumentoRol);
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
        objetoDocumentoRol=(DocumentoRolEntity)event.getObject();
    }
    /**
    Método que elimina un Documentos Rol
    */
    public void eliminarDocumentoRol(){
        DocumentoRolLogic metodoRecuperacionLogic=new DocumentoRolLogic();
        //objetoDocumentoRol.setEstadoDocumentoRol("E");
        metodoRecuperacionLogic.actualizarDocumentoRol(objetoDocumentoRol);
        eliminarDocumentoRolLista(objetoDocumentoRol);
        RequestContext.getCurrentInstance().execute("PF('actualizarDocumentoRol').hide()");
        nuevoDocumentoRolObjeto();
    }
    /**
     * Método que elimina visualmente un objeto de la lista
     * @param objetoDocumentoRol 
     */
    private void eliminarDocumentoRolLista(DocumentoRolEntity objetoDocumentoRol) {
        Iterator itr=lista.iterator();
        while(itr.hasNext()){
            DocumentoRolEntity metodoRecuperacionEntity=(DocumentoRolEntity) itr.next();
            if(metodoRecuperacionEntity.getIdDocumentoRol()==objetoDocumentoRol.getIdDocumentoRol()){
                itr.remove();
            }
        }
    }
    /**
     * Método que reinicia el objeto Documentos Rol
     */
    public void nuevoDocumentoRolObjeto() {
        RolesEntity rolesEntity=new RolesEntity();
        rolesEntity.setIdRol(-1);
        objetoDocumentoRol=new DocumentoRolEntity();
        objetoDocumentoRolInsercion=new DocumentoRolEntity();
        objetoDocumentoRol.setRolesentityDocumentoRol(rolesEntity);
        objetoDocumentoRolInsercion.setRolesentityDocumentoRol(rolesEntity);
        
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