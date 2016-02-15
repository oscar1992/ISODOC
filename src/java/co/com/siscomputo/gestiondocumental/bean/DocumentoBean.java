package co.com.siscomputo.gestiondocumental.bean;

import co.com.siscomputo.administracion.bean.ListaAdministracionBean;
import co.com.siscomputo.administracion.logic.AccionLogic;
import co.com.siscomputo.administracion.logic.GrupoProcesoLogic;
import co.com.siscomputo.administracion.logic.NivelLogic;
import co.com.siscomputo.administracion.logic.PlantillaLogic;
import co.com.siscomputo.administracion.logic.ProcesoLogic;
import co.com.siscomputo.administracion.logic.TiposDocumentalesLogic;
import co.com.siscomputo.endpoint.AccionEntity;
import co.com.siscomputo.gestiondocumental.logic.DocumentoLogic;
import co.com.siscomputo.endpoint.DocumentoEntity;
import co.com.siscomputo.endpoint.EmpresaEntity;
import co.com.siscomputo.endpoint.GrupoDocumentoEntity;
import co.com.siscomputo.endpoint.GrupoProcesoEntity;
import co.com.siscomputo.endpoint.GrupoUsuariosEntity;
import co.com.siscomputo.endpoint.MacroprocesosEntity;
import co.com.siscomputo.endpoint.MenuPermisosEntity;
import co.com.siscomputo.endpoint.NivelEntity;
import co.com.siscomputo.endpoint.PlantillaEntity;
import co.com.siscomputo.endpoint.ProcesoEntity;
import co.com.siscomputo.endpoint.ProcesosEntity;
import co.com.siscomputo.endpoint.SubprocesoEntity;
import co.com.siscomputo.endpoint.TiposDocumentalesEntity;
import co.com.siscomputo.endpoint.UsuarioEntity;
import co.com.siscomputo.gestiondocumental.entities.GrupoUsuarioAccionProcesoEntity;
import co.com.siscomputo.gestiondocumental.logic.GrupoDocumentoLogic;
import co.com.siscomputo.utilidades.DateToCalendar;
import co.com.siscomputo.utilidades.MensajesJSF;
import com.sun.org.apache.xerces.internal.jaxp.datatype.XMLGregorianCalendarImpl;
import java.io.IOException;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;
import javax.faces.context.FacesContext;
import javax.xml.datatype.XMLGregorianCalendar;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.DualListModel;
import org.primefaces.model.TreeNode;

/**
 * @author LENOVO
 */
@ManagedBean(name = "Documento")
@ViewScoped
public class DocumentoBean implements Serializable {

    private ArrayList<DocumentoEntity> lista;
    private ArrayList<DocumentoEntity> listaFiltro;
    private DocumentoEntity objetoDocumento;
    private DocumentoEntity objetoDocumentoInsercion;
    private ArrayList<ArrayList<ProcesoEntity>> listaProcesos;
    private ArrayList<HashMap<String, Integer>> desplegablesProcesos;
    private ArrayList<NivelEntity> listaNivel;
    private TreeNode arbolaux;
    private TreeNode raiz;
    private Integer tope;
    private Integer idProceso;
    private Integer idUsuario;
    private String consecutivo;
    private HashMap<String, GrupoUsuariosEntity> mapaGrupos;
    private ArrayList<GrupoUsuarioAccionProcesoEntity> usuarioAccionProcesoEntity;
    private ArrayList<ProcesoEntity> listaSeleccion;
    private TiposDocumentalesEntity Filtro1;
    private PlantillaEntity Filtro2;
    private AccionEntity Filtro3;
    private String Filtro4;
    private String Filtro5;

    private boolean ingresar;
    private boolean actualizar;
    private boolean eliminar;

    public HashMap<String, GrupoUsuariosEntity> getMapaGrupos() {
        return mapaGrupos;
    }

    public void setMapaGrupos(HashMap<String, GrupoUsuariosEntity> mapaGrupos) {
        this.mapaGrupos = mapaGrupos;
    }

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

    public DocumentoEntity getObjetoDocumento() {
        return objetoDocumento;
    }

    public void setObjetoDocumento(DocumentoEntity objetoDocumento) {
        this.objetoDocumento = objetoDocumento;
    }

    public DocumentoEntity getObjetoDocumentoInsercion() {
        return objetoDocumentoInsercion;
    }

    public void setObjetoDocumentoInsercion(DocumentoEntity objetoDocumentoInsercion) {
        this.objetoDocumentoInsercion = objetoDocumentoInsercion;
    }

    public ArrayList<ArrayList<ProcesoEntity>> getListaProcesos() {
        return listaProcesos;
    }

    public void setListaProcesos(ArrayList<ArrayList<ProcesoEntity>> listaProcesos) {
        this.listaProcesos = listaProcesos;
    }

    public ArrayList<NivelEntity> getListaNivel() {
        return listaNivel;
    }

    public void setListaNivel(ArrayList<NivelEntity> listaNivel) {
        this.listaNivel = listaNivel;
    }

    public TreeNode getRaiz() {
        return raiz;
    }

    public void setRaiz(TreeNode raiz) {
        this.raiz = raiz;
    }

    public Integer getTope() {
        return tope;
    }

    public void setTope(Integer tope) {
        this.tope = tope;
    }

    public TreeNode getArbolaux() {
        return arbolaux;
    }

    public void setArbolaux(TreeNode arbolaux) {
        this.arbolaux = arbolaux;
    }

    public ArrayList<GrupoUsuarioAccionProcesoEntity> getUsuarioAccionProcesoEntity() {
        return usuarioAccionProcesoEntity;
    }

    public void setUsuarioAccionProcesoEntity(ArrayList<GrupoUsuarioAccionProcesoEntity> usuarioAccionProcesoEntity) {
        this.usuarioAccionProcesoEntity = usuarioAccionProcesoEntity;
    }

    public String getConsecutivo() {
        return consecutivo;
    }

    public void setConsecutivo(String consecutivo) {
        this.consecutivo = consecutivo;
    }

    public Integer getIdProceso() {
        return idProceso;
    }

    public void setIdProceso(Integer idProceso) {
        this.idProceso = idProceso;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public ArrayList<HashMap<String, Integer>> getDesplegablesProcesos() {
        return desplegablesProcesos;
    }

    public void setDesplegablesProcesos(ArrayList<HashMap<String, Integer>> desplegablesProcesos) {
        this.desplegablesProcesos = desplegablesProcesos;
    }

    public ArrayList<ProcesoEntity> getListaSeleccion() {
        return listaSeleccion;
    }

    public void setListaSeleccion(ArrayList<ProcesoEntity> listaSeleccion) {
        this.listaSeleccion = listaSeleccion;
    }

    public TiposDocumentalesEntity getFiltro1() {
        return Filtro1;
    }

    public void setFiltro1(TiposDocumentalesEntity Filtro1) {
        this.Filtro1 = Filtro1;
    }

    public PlantillaEntity getFiltro2() {
        return Filtro2;
    }

    public void setFiltro2(PlantillaEntity Filtro2) {
        this.Filtro2 = Filtro2;
    }

    public AccionEntity getFiltro3() {
        return Filtro3;
    }

    public void setFiltro3(AccionEntity Filtro3) {
        this.Filtro3 = Filtro3;
    }

    public String getFiltro4() {
        return Filtro4;
    }

    public void setFiltro4(String Filtro4) {
        this.Filtro4 = Filtro4;
    }

    public String getFiltro5() {
        return Filtro5;
    }

    public void setFiltro5(String Filtro5) {
        this.Filtro5 = Filtro5;
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
        Filtro1 = new TiposDocumentalesEntity();
        //consultarDocumento();
        permisos();

    }

    public DocumentoBean() {
        System.out.println("Limpia??");
        objetoDocumento = new DocumentoEntity();
        objetoDocumentoInsercion = new DocumentoEntity();
        Filtro1 = new TiposDocumentalesEntity();
        Filtro2 = new PlantillaEntity();
        Filtro3 = new AccionEntity();
        Filtro4 = "";
        Filtro5 = "";
        nuevoDocumentoObjeto();
    }

    /**
     * Método que tra una lista de Documento
     */
    public void consultarDocumento() {
        try {
            DocumentoLogic documentoLogic = new DocumentoLogic();
            lista = documentoLogic.listaDocumento();
            NivelLogic nivelLogic = new NivelLogic();
            listaNivel = nivelLogic.listaNivel();
            ArrayList<ProcesoEntity> listaProcesosTodos = new ArrayList<>();
            ProcesoLogic procesoLogic = new ProcesoLogic();
            listaProcesosTodos = procesoLogic.listaProceso();
            listaProcesos = new ArrayList<>();
            Collections.reverse(listaNivel);
            for (NivelEntity nivel : listaNivel) {
                ArrayList<ProcesoEntity> lista = new ArrayList<>();
                for (ProcesoEntity proceso : listaProcesosTodos) {
                    if (nivel.getSecuenciaNivel() == proceso.getNivelProceso().getSecuenciaNivel()) {
                        //System.out.println("Proceso: " + proceso.getNombreProceso() + " - " + proceso.getNivelProceso().getSecuenciaNivel());
                        lista.add(proceso);
                    }
                }
                listaProcesos.add(lista);
            }
            armaArbol(listaProcesosTodos);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void armaArbol(ArrayList<ProcesoEntity> listaProcesoTodos) {
        raiz = new DefaultTreeNode("raiz", null);
        HashMap<ProcesoEntity, TreeNode> mapaApoyo = new HashMap<ProcesoEntity, TreeNode>();
        for (ArrayList<ProcesoEntity> listas : listaProcesos) {
            for (ProcesoEntity proc : listas) {
                mapaApoyo.put(proc, new DefaultTreeNode(proc));
                //System.out.println("Proc: " + proc.getNombreProceso() + " - " + proc.getNivelProceso().getSecuenciaNivel() + " id- " + proc.getIdProceso() + " asoc- " + proc.getAsociadoProceso());
            }
        }
        for (Map.Entry<ProcesoEntity, TreeNode> entrySet : mapaApoyo.entrySet()) {
            ProcesoEntity key = entrySet.getKey();
            TreeNode value = entrySet.getValue();
            if (key.getNivelProceso().getSecuenciaNivel() != 1) {

                mapaApoyo.get(ProcesoPorId(key.getAsociadoProceso(), listaProcesoTodos)).getChildren().add(value);
                //System.out.println("NODO HIJO: " + value.getData().toString()+" Con PADRE: "+value.getParent());
            } else {
                //System.out.println("NODO PADRE: " + value.getData().toString());
                raiz.getChildren().add(value);

            }

            //System.out.println("NODO: " + value.getData().toString());
        }
    }

    public ProcesoEntity ProcesoPorId(int idAsoc, ArrayList<ProcesoEntity> listaProcesoTodos) {
        ProcesoEntity retorna = new ProcesoEntity();
        for (ProcesoEntity proceso : listaProcesoTodos) {
            if (idAsoc == proceso.getIdProceso()) {
                retorna = proceso;
            }
        }
        return retorna;
    }

    /**
     * Método que permite insertar un Documento nuevo
     */
    public void instertarDocumento() {
        try {
            objetoDocumentoInsercion.setProcesoDocumento((ProcesoEntity) arbolaux.getData());
            DocumentoLogic documentoLogic = new DocumentoLogic();
            DocumentoEntity documentoEntity = documentoLogic.insertarDocumento(objetoDocumentoInsercion);
            GrupoDocumentoLogic grupoDocumentoLogic = new GrupoDocumentoLogic();
            GrupoDocumentoEntity grupoDocumentoEntity = new GrupoDocumentoEntity();
            for (GrupoUsuarioAccionProcesoEntity listaUAPE : usuarioAccionProcesoEntity) {
                grupoDocumentoEntity = new GrupoDocumentoEntity();
                grupoDocumentoEntity.setAccionGrupoDocumento(listaUAPE.getAccion());
                grupoDocumentoEntity.setDocumentoGrupoDocumento(documentoEntity);
                //System.out.println("GrupoDocumento: "+documentoEntity);
                if (Integer.parseInt(listaUAPE.getAccion().getOrdenAccion()) == 1) {
                    documentoEntity.setAccionDocumento(listaUAPE.getAccion());
                    documentoLogic.actualizarDocumento(documentoEntity);
                }
                XMLGregorianCalendar calendar = new XMLGregorianCalendarImpl();
                calendar.setYear(Integer.parseInt(listaUAPE.getFechaLimite().substring(6, 10)));
                calendar.setMonth(Integer.parseInt(listaUAPE.getFechaLimite().substring(3, 5)));
                calendar.setDay(Integer.parseInt(listaUAPE.getFechaLimite().substring(0, 2)));

                //grupoDocumentoEntity.setFecha(calendar);  
                grupoDocumentoEntity.setFecha(calendar);
                //System.out.println("CALENDAR: "+grupoDocumentoEntity.getFecha().toString());
                //System.out.println("Lista: "+listaUAPE.getAccion().getNombreAccion());
                //System.out.println("TTT: "+listaUAPE.getFechaLimite());
                for (Object nomb : listaUAPE.getSeleccionDual().getTarget()) {
                    //System.out.println("NOMB: "+nomb);
                    GrupoUsuariosEntity grupoUsuariosEntity = new GrupoUsuariosEntity();
                    grupoUsuariosEntity = mapaGrupos.get(nomb);
                    grupoDocumentoEntity.setGrupousuariosGrupoDocumento(grupoUsuariosEntity);
                    grupoDocumentoLogic.insertarGrupoDocumento(grupoDocumentoEntity);
                }
            }

            //System.out.println("OBJ: "+objetoDocumentoInsercion.getTipoDocumentalDocumento().getNombreTipoDocumental());
            FacesMessage msg = null;
            if (documentoEntity != null) {
                MensajesJSF.muestraMensajes("Documento insertado Correctamente: " + documentoEntity.getTituloDocumento(), "Mensaje");
                adicionarMetodoPtoteccionLista(documentoEntity);
            } else {
                MensajesJSF.muestraMensajes("Documento insertado Incorrectamente: " + documentoEntity.getTituloDocumento(), "Error");
                msg = new FacesMessage("", "inserción de Documento incorrecto");
            }
            usuarioAccionProcesoEntity = new ArrayList<>();
            RequestContext context = RequestContext.getCurrentInstance();
            context.update(":IngresarModal:asignados");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Método que añade un Documento visualmente
     *
     * @param objetoDocumento
     */
    private void adicionarMetodoPtoteccionLista(DocumentoEntity objetoDocumento) {
        PlantillaLogic plantillaLogic = new PlantillaLogic();
        PlantillaEntity plantilla = plantillaLogic.PlantillaPorId(objetoDocumento.getPlantilla().getIdPlantilla());
        objetoDocumento.setPlantilla(plantilla);
        TiposDocumentalesLogic tiposDocumentalesLogic = new TiposDocumentalesLogic();
        TiposDocumentalesEntity tiposDocumentalesEntity = tiposDocumentalesLogic.TipoDocumentalPorId(objetoDocumento.getTipoDocumentalDocumento().getIdTipoDocumental());
        objetoDocumento.setTipoDocumentalDocumento(tiposDocumentalesEntity);
        lista.add(objetoDocumento);
    }

    /**
     * Método que permite actualizar un Documento
     */
    public void actualizarDocumento() {
        DocumentoLogic metodoRecuperacionLogic = new DocumentoLogic();
        String valida = metodoRecuperacionLogic.actualizarDocumento(objetoDocumento);
        FacesMessage msg = null;
        if ("Ok".equalsIgnoreCase(valida)) {
            MensajesJSF.muestraMensajes("Documento actualizado Correctamente: " + objetoDocumento.getTituloDocumento(), "Mensaje");
            actualizarDocumentoLista(objetoDocumento);
        } else {
            MensajesJSF.muestraMensajes("Documento actualizado Incorrectamente: " + objetoDocumento.getTituloDocumento(), "Error");
        }
        nuevoDocumentoObjeto();
        RequestContext.getCurrentInstance().execute("PF('actualizarDocumento').hide()");
        RequestContext conte = RequestContext.getCurrentInstance();
        conte.update(":ActualizarModal:actualizarDocumentoModal");

    }

    /**
     * Método que actualiza visualmente la lista de Documento
     *
     * @param objetoDocumento
     */
    private void actualizarDocumentoLista(DocumentoEntity objetoDocumento) {
        try {
            ArrayList<DocumentoEntity> listaaux = new ArrayList<>();
            if (lista != null) {
                for (DocumentoEntity item : lista) {
                    int v1 = objetoDocumento.getIdDocumento();
                    int v2 = item.getIdDocumento();
                    if (v1 == v2) {
                        PlantillaLogic plantillaLogic = new PlantillaLogic();
                        PlantillaEntity plantilla = plantillaLogic.PlantillaPorId(objetoDocumento.getPlantilla().getIdPlantilla());
                        objetoDocumento.setPlantilla(plantilla);
                        TiposDocumentalesLogic tiposDocumentalesLogic = new TiposDocumentalesLogic();
                        TiposDocumentalesEntity tiposDocumentalesEntity = tiposDocumentalesLogic.TipoDocumentalPorId(objetoDocumento.getTipoDocumentalDocumento().getIdTipoDocumental());
                        objetoDocumento.setTipoDocumentalDocumento(tiposDocumentalesEntity);

                        listaaux.add(objetoDocumento);
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
        objetoDocumento = (DocumentoEntity) event.getObject();
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("documento", objetoDocumento);
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("documento.jsf");
        } catch (IOException ex) {
            Logger.getLogger(DocumentoBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        //FacesContext.getCurrentInstance().responseComplete();
        //System.out.println("select: "+objetoDocumento.getTituloDocumento());
    }

    /**
     * Método que elimina un Documento
     */
    public void eliminarDocumento() {
        DocumentoLogic metodoRecuperacionLogic = new DocumentoLogic();
        objetoDocumento.setEstadoDocumento("E");
        metodoRecuperacionLogic.actualizarDocumento(objetoDocumento);
        eliminarDocumentoLista(objetoDocumento);
        RequestContext.getCurrentInstance().execute("PF('actualizarDocumento').hide()");
        nuevoDocumentoObjeto();
    }

    /**
     * Método que elimina visualmente un objeto de la lista
     *
     * @param objetoDocumento
     */
    private void eliminarDocumentoLista(DocumentoEntity objetoDocumento) {
        Iterator itr = lista.iterator();
        while (itr.hasNext()) {
            DocumentoEntity metodoRecuperacionEntity = (DocumentoEntity) itr.next();
            if (metodoRecuperacionEntity.getIdDocumento() == objetoDocumento.getIdDocumento()) {
                itr.remove();
            }
        }
    }

    /**
     * Método que reinicia el objeto Documento
     */
    public void nuevoDocumentoObjeto() {
        objetoDocumento = new DocumentoEntity();
        objetoDocumentoInsercion = new DocumentoEntity();

        TiposDocumentalesEntity tiposDocumentalesEntity = new TiposDocumentalesEntity();
        tiposDocumentalesEntity.setIdTipoDocumental(-1);
        PlantillaEntity plantillaEntity = new PlantillaEntity();
        plantillaEntity.setIdPlantilla(-1);
        MacroprocesosEntity macroprocesosEntity = new MacroprocesosEntity();
        macroprocesosEntity.setIdMacroproceso(-1);
        ProcesosEntity procesosEntity = new ProcesosEntity();
        procesosEntity.setIdProcesos(-1);
        SubprocesoEntity subprocesoEntity = new SubprocesoEntity();
        subprocesoEntity.setIdSubproceso(-1);
        EmpresaEntity empresaEntity = new EmpresaEntity();
        empresaEntity.setIdEmpresa(-1);

        objetoDocumento.setTipoDocumentalDocumento(tiposDocumentalesEntity);
        objetoDocumento.setPlantilla(plantillaEntity);
        objetoDocumentoInsercion.setPlantilla(plantillaEntity);
        objetoDocumentoInsercion.setTipoDocumentalDocumento(tiposDocumentalesEntity);
        objetoDocumento.setEmpresaDocumento(empresaEntity);
        objetoDocumentoInsercion.setEmpresaDocumento(empresaEntity);
        NivelLogic nivelLogic = new NivelLogic();
        listaNivel = nivelLogic.listaNivel();
    }

    /**
     * Método que inicial las listas duales de selección de grupos de usuarios
     */
    public void iniciaAcciones() {
        AccionLogic accionLogic = new AccionLogic();
        ArrayList<AccionEntity> listaAccion = new ArrayList<>();
        listaAccion = accionLogic.listaAccion();
        ArrayList<GrupoProcesoEntity> listaGrupos = new ArrayList<>();
        GrupoProcesoLogic grupoProcesoLogic = new GrupoProcesoLogic();
        ArrayList<String> nombres;
        ArrayList<String> selecion = new ArrayList<>();
        DualListModel lista = new DualListModel();
        GrupoUsuarioAccionProcesoEntity usuaccipro = new GrupoUsuarioAccionProcesoEntity();
        usuarioAccionProcesoEntity = new ArrayList<>();
        mapaGrupos = new HashMap<String, GrupoUsuariosEntity>();
        for (AccionEntity accion : listaAccion) {
            usuaccipro = new GrupoUsuarioAccionProcesoEntity();
            nombres = new ArrayList<>();
            lista = new DualListModel<>();
            listaGrupos = grupoProcesoLogic.listaGruposProcesosPorAccion(accion.getIdAccion(), idProceso);
            usuaccipro.setAccion(accion);
            //System.out.println("ACCION: "+accion.getNombreAccion());
            for (GrupoProcesoEntity grupoproceso : listaGrupos) {
                //System.out.println("NOMBRE: "+grupoproceso.getGrupoUsuarioProceso().getNombreGrupoUsuarios());
                nombres.add(grupoproceso.getGrupoUsuarioProceso().getNombreGrupoUsuarios());
                mapaGrupos.put(grupoproceso.getGrupoUsuarioProceso().getNombreGrupoUsuarios(), grupoproceso.getGrupoUsuarioProceso());
            }
            usuaccipro.setNombres(nombres);
            usuaccipro.setSelecion(selecion);
            lista = new DualListModel(nombres, selecion);
            usuaccipro.setSeleccionDual(lista);
            Date fecha = new Date(System.currentTimeMillis());

            SimpleDateFormat forma = new SimpleDateFormat("dd/MM/yyyy");

            usuaccipro.setFechaLimite("" + forma.format(fecha));
            usuarioAccionProcesoEntity.add(usuaccipro);
        }

    }

    /**
     * Método que trae el consecutivo correspondiente al tip documental elegido
     */
    public void traeConsecutivo() {

        int idTipos = objetoDocumentoInsercion.getTipoDocumentalDocumento().getIdTipoDocumental();
        TiposDocumentalesLogic tiposDocumentalesLogic = new TiposDocumentalesLogic();
        TiposDocumentalesEntity tiposDocumentalesEntity = new TiposDocumentalesEntity();
        tiposDocumentalesEntity = tiposDocumentalesLogic.TipoDocumentalPorId(idTipos);
        System.out.println("TIPO: " + tiposDocumentalesEntity.getInicialesTipoDocuemntal());
        consecutivo = tiposDocumentalesEntity.getInicialesTipoDocuemntal();
    }

    public void evalua(TreeNode proceso) {
        ProcesoEntity procesoEntity = new ProcesoEntity();
        procesoEntity = (ProcesoEntity) proceso.getData();
        //System.out.println("INGRESA: "+procesoEntity.getNombreProceso());
        idProceso = procesoEntity.getIdProceso();
        iniciaAcciones();
    }

    public HashMap<String, Integer> ProcesosPorNivelAsociado(int nivel, Integer asociado) {
        HashMap<String, Integer> retorna = new HashMap<>();
        ListaAdministracionBean listaAdministracionBean = new ListaAdministracionBean();
        listaAdministracionBean.cambiarIdNvel(nivel);
        retorna = (HashMap<String, Integer>) listaAdministracionBean.getListaProcesoAsociado();
        return retorna;
    }

    public void Filtrar() {
        consultarDocumento();
        System.out.println("F1: " + Filtro1.getIdTipoDocumental());
        System.out.println("F2: " + Filtro2.getIdPlantilla());
        System.out.println("F3: " + Filtro3.getIdAccion());

        ArrayList<DocumentoEntity> listaaux = new ArrayList<>();
        ArrayList<DocumentoEntity> listaaux2 = new ArrayList<>();
        ArrayList<DocumentoEntity> listaaux3 = new ArrayList<>();
        ArrayList<DocumentoEntity> listaaux4 = new ArrayList<>();
        boolean nulo1 = false;
        boolean nulo2 = false;
        boolean nulo3 = false;
        boolean nulo4 = false;
        if (Filtro1 == null || Filtro1.getIdTipoDocumental() == 0) {
            listaaux = lista;
            nulo1 = true;
        } else {
            for (DocumentoEntity documento : lista) {
                if (documento.getTipoDocumentalDocumento().getIdTipoDocumental() == Filtro1.getIdTipoDocumental()) {
                    listaaux.add(documento);
                }
            }
        }

        if (Filtro2 == null || Filtro2.getIdPlantilla() == 0) {
            listaaux2 = listaaux;
            nulo2 = true;
        } else {
            for (DocumentoEntity documento : listaaux) {
                if (documento.getPlantilla().getIdPlantilla() == Filtro2.getIdPlantilla()) {
                    listaaux2.add(documento);
                }
            }
        }
        if (Filtro3 == null || Filtro3.getIdAccion() == 0) {
            listaaux3 = listaaux2;
            nulo3 = true;
        } else {
            for (DocumentoEntity documento : listaaux2) {
                if (documento.getAccionDocumento().getIdAccion() == Filtro3.getIdAccion()) {
                    listaaux3.add(documento);
                }
            }
        }
        if (Filtro4 == null || Filtro4.length() < 10) {
            listaaux4 = listaaux3;
            nulo4 = true;
        } else {

            for (DocumentoEntity documento : listaaux3) {
                /*int ano = Integer.parseInt(documento.getFechaDocumento().substring(0, 4));
                int mes = Integer.parseInt(documento.getFechaDocumento().substring(6, 7));
                int dia = Integer.parseInt(documento.getFechaDocumento().substring(9, 10));*/
                int dia2 = Integer.parseInt(Filtro4.substring(0, 2));
                int mes2 = Integer.parseInt(Filtro4.substring(3, 4));
                int ano2 = Integer.parseInt(Filtro4.substring(6, 10));
                System.out.println("FECHA d: " + documento.getFechaDocumento());
                System.out.println("FECHA: " + Filtro4);
                DateToCalendar dateToCalendar=new DateToCalendar();
                Date fecha = dateToCalendar.convertirInverso(documento.getFechaDocumento());
                Date fecha2 = new Date(ano2, mes2, dia2);

                System.out.println("Fecha 1: " + fecha.getTime());
                System.out.println("Fecha 2: " + fecha2.getTime());
                if (fecha.getTime() > fecha2.getTime()) {
                    System.out.println("Está después");
                    listaaux4.add(documento);
                } else {
                    System.out.println("Esta antes");
                }
            }
        }
        lista = listaaux4;
        if (nulo1 && nulo2 && nulo3 && nulo4) {
            consultarDocumento();
        }
    }

    public void Filtrar2() {
        DocumentoLogic documentoLogic = new DocumentoLogic();
        if (Filtro1 == null) {

        }
        if (Filtro2 == null) {

        }
        if (Filtro3 == null) {

        }
        System.out.println("F1: " + Filtro1.getIdTipoDocumental());
        lista = documentoLogic.documetosFiltrados(Filtro1.getIdTipoDocumental(), Filtro2.getIdPlantilla(), Filtro3.getIdAccion());
    }

    public HashMap<String, Integer> listaAccionesPorUsuario() {
        ListaGestionDocumentalBean listaGestionDocumentalBean = new ListaGestionDocumentalBean();
        idUsuario = ((UsuarioEntity) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario")).getIdUsuario();
        //System.out.println("idUsuario: " + idUsuario);
        listaGestionDocumentalBean.accionPorUsuario(idUsuario);
        return (HashMap<String, Integer>) listaGestionDocumentalBean.getListaAccionesPorUsuario();
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
