/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.siscomputo.gestiondocumental.bean;

import co.com.siscomputo.administracion.logic.AccionLogic;
import co.com.siscomputo.endpoint.AccionEntity;
import co.com.siscomputo.endpoint.DocumentoEntity;
import co.com.siscomputo.endpoint.MenuPermisosEntity;
import co.com.siscomputo.gestiondocumental.entities.PorEstadoEntity;
import co.com.siscomputo.gestiondocumental.logic.DocumentoLogic;
import java.io.Serializable;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author LENOVO
 */
@ManagedBean(name = "PorEstado")
@ViewScoped
public class PorEstadoBean implements Serializable {

    private ArrayList<DocumentoEntity> lista;
    private ArrayList<DocumentoEntity> listaFiltro;
    private ArrayList<PorEstadoEntity> documentosAccion;
    private PorEstadoEntity objetoDocumento;
    private boolean ingresar;
    private boolean actualizar;
    private boolean eliminar;

    public ArrayList<DocumentoEntity> getLista() {
        return lista;
    }

    public void setLista(ArrayList<DocumentoEntity> lista) {
        this.lista = lista;
    }

    public ArrayList<DocumentoEntity> getListaFiltro() {
        return listaFiltro;
    }

    public void setListaFiltro(ArrayList<DocumentoEntity> listaFiltro) {
        this.listaFiltro = listaFiltro;
    }

    public ArrayList<PorEstadoEntity> getDocumentosAccion() {
        return documentosAccion;
    }

    public void setDocumentosAccion(ArrayList<PorEstadoEntity> documentosAccion) {
        this.documentosAccion = documentosAccion;
    }

    public PorEstadoEntity getObjetoDocumento() {
        return objetoDocumento;
    }

    public void setObjetoDocumento(PorEstadoEntity objetoDocumento) {
        this.objetoDocumento = objetoDocumento;
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
    public void init() {
        permisos();
        cargaPorAccion();
        //objetoDocumento = new DocumentoEntity();
    }

    public PorEstadoBean() {
        nuevo();
    }

    /**
     * Método que carga los documentos separados por la acción "Estado" en el
     * que se encuentren
     */
    public void cargaPorAccion() {

        documentosAccion = new ArrayList<>();
        AccionLogic accionLogic = new AccionLogic();
        ArrayList<AccionEntity> listaAccion = accionLogic.listaAccion();
        DocumentoLogic documentoLogic = new DocumentoLogic();
        ArrayList<DocumentoEntity> listasDocumentos = new ArrayList<>();

        for (AccionEntity accion : listaAccion) {
            PorEstadoEntity porEstadoEntity = new PorEstadoEntity();
            porEstadoEntity.setAccion(accion);
            listasDocumentos = documentoLogic.documetosPorAccion(accion);
            porEstadoEntity.setDocumentosAccion(listasDocumentos);
            documentosAccion.add(porEstadoEntity);
        }

    }

    /**
     * Método que se invoca al seleccionar una fila de la tabla
     *
     * @param event
     */
    public void onRowSelect(SelectEvent event) {
        //objetoDocumento=new DocumentoEntity();
        DocumentoEntity doc = (DocumentoEntity) event.getObject();
        System.out.println("Selección: " + event.getObject().getClass().getCanonicalName());
    }

    /**
     * Método que inicializa las variables del bean
     */
    public void nuevo() {
        objetoDocumento = new PorEstadoEntity();
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
                    //System.out.println("nn: " + nivel2.getNombrePermiso() + "-" + nivel2.getAsociadoMenu() + " - " + idPer);
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
