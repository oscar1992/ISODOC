package co.com.siscomputo.gestiondocumental.bean;

import co.com.siscomputo.administracion.logic.AccionLogic;
import co.com.siscomputo.administracion.logic.GrupoProcesoLogic;
import co.com.siscomputo.administracion.logic.UsuarioLogic;
import co.com.siscomputo.endpoint.AccionEntity;
import co.com.siscomputo.endpoint.DocumentoEntity;
import co.com.siscomputo.gestiondocumental.logic.DocumentoProcesoLogic;
import co.com.siscomputo.endpoint.DocumentoProcesoEntity;
import co.com.siscomputo.endpoint.GrupoProcesoEntity;
import co.com.siscomputo.endpoint.MenuPermisosEntity;
import co.com.siscomputo.endpoint.ProcesoEntity;
import co.com.siscomputo.endpoint.UsuarioEntity;
import co.com.siscomputo.gestiondocumental.entities.ArbolProcesoEntity;
import co.com.siscomputo.gestiondocumental.entities.GrupoUsuarioAccionProcesoEntity;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;
import javax.faces.context.FacesContext;
import org.primefaces.model.DualListModel;
import org.primefaces.model.TreeNode;

/**
 *
 * @author LENOVO
 */
@ManagedBean(name = "DocumentoProceso")
@ViewScoped
public class DocumentoProcesoBean implements Serializable {

    private ArrayList<DocumentoProcesoEntity> lista;
    private ArrayList<DocumentoProcesoEntity> listaFiltro;
    private DocumentoProcesoEntity objetoDocumentoProceso;
    private Integer idUsuario;
    private Integer idAccion;
    private Integer tipo;
    private ArrayList<DualListModel<String>> asignaLista;
    private ArrayList<ArrayList<String>> asignaNombre;
    private ArrayList<ArrayList<String>> asignaSeleccion;
    private ArrayList<GrupoUsuarioAccionProcesoEntity> usuarioAccionProcesoEntity;
    private UsuarioEntity usuarioEntity;
    private DocumentoEntity objetoDocumento;
    private boolean ingresar;
    private boolean actualizar;
    private boolean eliminar;

    public ArrayList<GrupoUsuarioAccionProcesoEntity> getUsuarioAccionProcesoEntity() {
        return usuarioAccionProcesoEntity;
    }

    public void setUsuarioAccionProcesoEntity(ArrayList<GrupoUsuarioAccionProcesoEntity> usuarioAccionProcesoEntity) {
        this.usuarioAccionProcesoEntity = usuarioAccionProcesoEntity;
    }

   

    
    public ArrayList<DocumentoProcesoEntity> getLista() {
        return lista;
    }

    public void setLista(ArrayList<DocumentoProcesoEntity> lista) {
        this.lista = lista;
    }

    public ArrayList<DocumentoProcesoEntity> getListaFiltro() {
        return listaFiltro;
    }

    public void setListaFiltro(ArrayList<DocumentoProcesoEntity> listaFiltro) {
        this.listaFiltro = listaFiltro;
    }

    public DocumentoProcesoEntity getObjetoDocumentoProceso() {
        return objetoDocumentoProceso;
    }

    public void setObjetoDocumentoProceso(DocumentoProcesoEntity objetoDocumentoProceso) {
        this.objetoDocumentoProceso = objetoDocumentoProceso;
    }

    public DocumentoEntity getObjetoDocumento() {
        return objetoDocumento;
    }

    public void setObjetoDocumento(DocumentoEntity objetoDocumento) {
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

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Integer getIdProceso() {
        return idAccion;
    }

    public void setIdProceso(Integer idAccion) {
        this.idAccion = idAccion;
    }

    public Integer getIdAccion() {
        return idAccion;
    }

    public void setIdAccion(Integer idAccion) {
        this.idAccion = idAccion;
    }

    public Integer getTipo() {
        return tipo;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }

    public ArrayList<DualListModel<String>> getAsignaLista() {
        return asignaLista;
    }

    public void setAsignaLista(ArrayList<DualListModel<String>> asignaLista) {
        this.asignaLista = asignaLista;
    }

    public ArrayList<ArrayList<String>> getAsignaNombre() {
        return asignaNombre;
    }

    public void setAsignaNombre(ArrayList<ArrayList<String>> asignaNombre) {
        this.asignaNombre = asignaNombre;
    }

    public ArrayList<ArrayList<String>> getAsignaSeleccion() {
        return asignaSeleccion;
    }

    public void setAsignaSeleccion(ArrayList<ArrayList<String>> asignaSeleccion) {
        this.asignaSeleccion = asignaSeleccion;
    }

    public UsuarioEntity getUsuarioEntity() {
        return usuarioEntity;
    }

    public void setUsuarioEntity(UsuarioEntity usuarioEntity) {
        this.usuarioEntity = usuarioEntity;
    }

    @PostConstruct
    public void init() {
        //consultarDocumentoMacroProceso();
        iniciaAcciones();
        permisos();
    }

    public DocumentoProcesoBean() {
        objetoDocumentoProceso = new DocumentoProcesoEntity();
        usuarioEntity = new UsuarioEntity();
        asignaLista = new ArrayList<>();
        asignaNombre = new ArrayList<>();
        asignaSeleccion = new ArrayList<>();
        idAccion = null;
    }

    public void iniciaAcciones(){
        AccionLogic accionLogic=new AccionLogic();
        ArrayList<AccionEntity> listaAccion = new ArrayList<>();
        listaAccion=accionLogic.listaAccion();
        ArrayList<GrupoProcesoEntity> listaGrupos=new ArrayList<>();
        GrupoProcesoLogic grupoProcesoLogic=new GrupoProcesoLogic();        
        ArrayList<String>nombres;
        ArrayList<String>selecion=new ArrayList<>();
        DualListModel lista=new DualListModel();
        GrupoUsuarioAccionProcesoEntity usuaccipro=new GrupoUsuarioAccionProcesoEntity();         
        usuarioAccionProcesoEntity=new ArrayList<>();
        for(AccionEntity accion: listaAccion){
            usuaccipro=new GrupoUsuarioAccionProcesoEntity();
            nombres=new ArrayList<>();
            lista=new DualListModel();
            listaGrupos=grupoProcesoLogic.listaGruposProcesosPorAccion(accion.getIdAccion());
            usuaccipro.setAccion(accion);
            System.out.println("ACCION: "+accion.getNombreAccion());
            for(GrupoProcesoEntity grupoproceso:listaGrupos){
                System.out.println("NOMBRE: "+grupoproceso.getGrupoUsuarioProceso().getNombreGrupoUsuarios());
                nombres.add(grupoproceso.getGrupoUsuarioProceso().getNombreGrupoUsuarios());
            }
            usuaccipro.setNombres(nombres);
            usuaccipro.setSelecion(selecion);
            lista=new DualListModel(nombres, selecion);
            usuaccipro.setSeleccionDual(lista);
            usuarioAccionProcesoEntity.add(usuaccipro);
        }
    }
    /**
     * Método que permite insertar un Usuarios Asignados Sobre el Documento
     * nuevo
     */
    public void instertarDocumentoProceso() {
        try {
            DocumentoProcesoLogic documentoProcesoLogic = new DocumentoProcesoLogic();
            DocumentoProcesoEntity documentoProcesoEntity = documentoProcesoLogic.insertarDocumentoProceso(objetoDocumentoProceso);
            FacesMessage msg = null;
            if (documentoProcesoEntity != null) {
                msg = new FacesMessage("", "inserción de Usuarios Asignados Sobre el Documento correcto");
                adicionarMetodoPtoteccionLista(objetoDocumentoProceso);
            } else {
                msg = new FacesMessage("", "inserción de Usuarios Asignados Sobre el Documento incorrecto");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Método que añade un Usuarios Asignados Sobre el Documento visualmente
     *
     * @param objetoDocumentoProceso
     */
    private void adicionarMetodoPtoteccionLista(DocumentoProcesoEntity objetoDocumentoProceso) {
        lista.add(objetoDocumentoProceso);
    }

    /**
     * Método que permite actualizar un Usuarios Asignados Sobre el Documento
     */
    public void actualizarDocumentoProceso() {
        DocumentoProcesoLogic metodoRecuperacionLogic = new DocumentoProcesoLogic();
        String valida = metodoRecuperacionLogic.actualizarDocumentoProceso(objetoDocumentoProceso);
        FacesMessage msg = null;
        if ("Ok".equalsIgnoreCase(valida)) {
            msg = new FacesMessage("", "actualización de Usuarios Asignados Sobre el Documento correcto");
            actualizarDocumentoProcesoLista(objetoDocumentoProceso);
        } else {
            msg = new FacesMessage("", "actualización de Usuarios Asignados Sobre el Documento incorrecto");
        }
        nuevoDocumentoProcesoObjeto();
        RequestContext.getCurrentInstance().execute("PF('actualizarDocumentoProceso').hide()");
    }

    /**
     * Método que actualiza visualmente la lista de Usuarios Asignados Sobre el
     * Documento
     *
     * @param objetoDocumentoProceso
     */
    private void actualizarDocumentoProcesoLista(DocumentoProcesoEntity objetoDocumentoProceso) {
        try {
            ArrayList<DocumentoProcesoEntity> listaaux = new ArrayList<>();
            if (lista != null) {
                for (DocumentoProcesoEntity item : lista) {
                    int v1 = objetoDocumentoProceso.getIdDocumentoProceso();
                    int v2 = item.getIdDocumentoProceso();
                    if (v1 == v2) {
                        listaaux.add(objetoDocumentoProceso);
                    } else {
                        listaaux.add(item);
                    }
                }
            }
            this.lista = new ArrayList<>();
            this.lista = listaaux;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Método que se invoca al seleccionar una fila de la tabla
     *
     * @param event
     */
    public void onRowSelect(SelectEvent event) {
        objetoDocumentoProceso = (DocumentoProcesoEntity) event.getObject();
    }

    /**
     * Método que elimina un Usuarios Asignados Sobre el Documento
     */
    public void eliminarDocumentoProceso() {
        DocumentoProcesoLogic metodoRecuperacionLogic = new DocumentoProcesoLogic();
        //objetoDocumentoProceso.setEstadoDocumentoProceso("E");
        metodoRecuperacionLogic.actualizarDocumentoProceso(objetoDocumentoProceso);
        eliminarDocumentoProcesoLista(objetoDocumentoProceso);
        RequestContext.getCurrentInstance().execute("PF('actualizarDocumentoProceso').hide()");
        nuevoDocumentoProcesoObjeto();
    }

    /**
     * Método que elimina visualmente un objeto de la lista
     *
     * @param objetoDocumentoProceso
     */
    private void eliminarDocumentoProcesoLista(DocumentoProcesoEntity objetoDocumentoProceso) {
        Iterator itr = lista.iterator();
        while (itr.hasNext()) {
            DocumentoProcesoEntity metodoRecuperacionEntity = (DocumentoProcesoEntity) itr.next();
            if (metodoRecuperacionEntity.getIdDocumentoProceso() == objetoDocumentoProceso.getIdDocumentoProceso()) {
                itr.remove();
            }
        }
    }

    /**
     * Método que reinicia el objeto Usuarios Asignados Sobre el Documento
     */
    public void nuevoDocumentoProcesoObjeto() {
        objetoDocumentoProceso = new DocumentoProcesoEntity();
    }

    public void evalua(TreeNode proceso) {
        ProcesoEntity procesoEntity=new ProcesoEntity();
        procesoEntity=(ProcesoEntity) proceso.getData();
        System.out.println("INGRESA: "+procesoEntity.getNombreProceso());
        
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
