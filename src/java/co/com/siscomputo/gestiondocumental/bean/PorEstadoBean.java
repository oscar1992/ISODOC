/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.siscomputo.gestiondocumental.bean;

import co.com.siscomputo.administracion.logic.AccionLogic;
import co.com.siscomputo.administracion.logic.GrupoUsuariosLogic;
import co.com.siscomputo.endpoint.AccionEntity;
import co.com.siscomputo.endpoint.DocumentoEntity;
import co.com.siscomputo.endpoint.GrupoUsuariosEntity;
import co.com.siscomputo.endpoint.MenuPermisosEntity;
import co.com.siscomputo.gestiondocumental.entities.PorEstadoEntity;
import co.com.siscomputo.gestiondocumental.logic.DocumentoLogic;
import co.com.siscomputo.utilidades.ComparadorAccion;
import co.com.siscomputo.utilidades.ComparadorAccion2;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;
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
    private DocumentoEntity objetoDocumento;
    private ArrayList<AccionEntity> listaAccionesSistema;
    private ArrayList<AccionEntity> listaAccionesUsuario;
    private AccionEntity objetoAccion;
    private AccionEntity accionSiguiente;
    private Integer idAccion;
    private String nombreSiguiente;
    private boolean mostrarTabla;
    private boolean botonSiguiente;
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

    public DocumentoEntity getObjetoDocumento() {
        return objetoDocumento;
    }

    public void setObjetoDocumento(DocumentoEntity objetoDocumento) {
        this.objetoDocumento = objetoDocumento;
    }

    public ArrayList<AccionEntity> getListaAccionesSistema() {
        return listaAccionesSistema;
    }

    public void setListaAccionesSistema(ArrayList<AccionEntity> listaAccionesSistema) {
        this.listaAccionesSistema = listaAccionesSistema;
    }

    public ArrayList<AccionEntity> getListaAccionesUsuario() {
        return listaAccionesUsuario;
    }

    public void setListaAccionesUsuario(ArrayList<AccionEntity> listaAccionesUsuario) {
        this.listaAccionesUsuario = listaAccionesUsuario;
    }

    public AccionEntity getObjetoAccion() {
        return objetoAccion;
    }

    public void setObjetoAccion(AccionEntity objetoAccion) {
        this.objetoAccion = objetoAccion;
    }

    public Integer getIdAccion() {
        return idAccion;
    }

    public void setIdAccion(Integer idAccion) {
        this.idAccion = idAccion;
    }

    public boolean isMostrarTabla() {
        return mostrarTabla;
    }

    public void setMostrarTabla(boolean mostrarTabla) {
        this.mostrarTabla = mostrarTabla;
    }

    public boolean isBotonSiguiente() {
        return botonSiguiente;
    }

    public void setBotonSiguiente(boolean botonSiguiente) {
        this.botonSiguiente = botonSiguiente;
    }

    public String getNombreSiguiente() {
        return nombreSiguiente;
    }

    public void setNombreSiguiente(String nombreSiguiente) {
        this.nombreSiguiente = nombreSiguiente;
    }

    public AccionEntity getAccionSiguiente() {
        return accionSiguiente;
    }

    public void setAccionSiguiente(AccionEntity accionSiguiente) {
        this.accionSiguiente = accionSiguiente;
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
        cargaAcciones();
        //objetoDocumento = new DocumentoEntity();        
        idAccion = null;
    }

    /**
     * Método que se llama al selecionar una accion, este carga los documentos
     * asociados a la acción seleccionada
     */
    public void objeto() {
        System.out.println("OBJETOA: " + idAccion);
        cargaPorAccion();
        mostrarTabla = true;

    }

    public PorEstadoBean() {
        botonSiguiente = true;
        nuevo();
    }

    /**
     * Método que carga los documentos separados por la acción "Estado" en el
     * que se encuentren
     */
    public void cargaPorAccion() {
        if (idAccion != null) {
            documentosAccion = new ArrayList<>();
            AccionLogic accionLogic = new AccionLogic();
            objetoAccion = accionLogic.accionPorId(idAccion);
            if (ultimaAccion(objetoAccion)) {
                botonSiguiente = false;
            } else {
                Collections.sort(listaAccionesSistema, new ComparadorAccion2());
                //Collections.reverse(listaAcciones);
                Iterator itr = listaAccionesSistema.iterator();
                accionSiguiente = new AccionEntity();
                while (itr.hasNext()) {
                    AccionEntity accionEntity = (AccionEntity) itr.next();
                    if (accionEntity.getOrdenAccion().equals(objetoAccion.getOrdenAccion())) {
                        if (itr.hasNext()) {
                            accionSiguiente = (AccionEntity) itr.next();
                        }
                    }
                }
                nombreSiguiente = accionSiguiente.getNombreAccion();
                botonSiguiente = true;
            }
            //System.out.println("BOTÖN: "+botonSiguiente+" - "+accionSiguiente.getNombreAccion());
            DocumentoLogic documentoLogic = new DocumentoLogic();
            lista = documentoLogic.documetosPorAccion(objetoAccion);
        }
    }
    /**
     * Método que pasa un documento de acción
     */
    public void siguienteAccion() {
        
        objetoDocumento.setAccionDocumento(accionSiguiente);
        int id = (int) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("idDocumento");
        objetoDocumento.setIdDocumento(id);
        System.out.println("idDOCUE: ");
        DocumentoLogic documentoLogic = new DocumentoLogic();
        String valida = documentoLogic.actualizarDocumento(objetoDocumento);
        FacesMessage msg = null;
        if ("Ok".equalsIgnoreCase(valida)) {
            msg = new FacesMessage("", "actualización de Documento correcto");
        } else {
            msg = new FacesMessage("", "actualización de Documento incorrecto");
        }        
        lista = documentoLogic.documetosPorAccion(objetoAccion);
        RequestContext context = RequestContext.getCurrentInstance();
        context.update(":DocumentoAccion:tablaDocumento");
        RequestContext.getCurrentInstance().execute("PF('actualizarDocumento').hide()");

    }

    /**
     * Método que carga la lista de acciones disponibles
     */
    public void cargaAcciones() {
        AccionLogic accionLogic = new AccionLogic();
        int idUsuario = (int) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("idUsuario");
        listaAccionesUsuario = accionLogic.accionPorUsuario(idUsuario);
        listaAccionesSistema = accionLogic.listaAccion();
        System.out.println("ID Usuario: " + idUsuario);
        ArrayList<GrupoUsuariosEntity> listaGrupos = new ArrayList<>();
        GrupoUsuariosLogic grupoUsuariosLogic = new GrupoUsuariosLogic();
        listaGrupos = grupoUsuariosLogic.grupoPorUsuario(idUsuario);
        for (GrupoUsuariosEntity grupo : listaGrupos) {
            System.out.println("GRUPO: " + grupo.getNombreGrupoUsuarios());
        }
    }

    /**
     * Método que se invoca al seleccionar una fila de la tabla
     *
     * @param event
     */
    public void onRowSelect(SelectEvent event) {
        objetoDocumento = new DocumentoEntity();
        objetoDocumento = (DocumentoEntity) event.getObject();
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("Documento", objetoDocumento);
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("idDocumento", objetoDocumento.getIdDocumento());
        System.out.println("Envía: " + objetoDocumento.getIdDocumento());
        RequestContext context = RequestContext.getCurrentInstance();
        context.update(":MoverDocumento:nom");

    }

    /*
     Método que evalua si la accipon selecionada posee una acción siguinete o es la última de la secuencia
     */
    public boolean ultimaAccion(AccionEntity accionEntity) {
        boolean retorna = false;
        AccionLogic accionLogic = new AccionLogic();
        ArrayList<AccionEntity> listaAccionAux = accionLogic.listaAccion();
        Collections.sort(listaAccionAux, new ComparadorAccion());
        if (!listaAccionAux.isEmpty()) {
            int mayor = Integer.parseInt(listaAccionAux.get(0).getOrdenAccion());
            //System.out.println("Mayor: " + mayor);
            if (mayor == Integer.parseInt(accionEntity.getOrdenAccion())) {
                retorna = true;
            }
        }

        return retorna;
    }

    /**
     * Método que inicializa las variables del bean
     */
    public void nuevo() {
        objetoDocumento = new DocumentoEntity();
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
