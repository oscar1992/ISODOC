/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.siscomputo.gestiondocumental.bean;

import co.com.siscomputo.administracion.bean.ListaAdministracionBean;
import co.com.siscomputo.administracion.logic.AccionLogic;
import co.com.siscomputo.administracion.logic.GrupoProcesoLogic;
import co.com.siscomputo.administracion.logic.MacroProcesosLogic;
import co.com.siscomputo.administracion.logic.NivelLogic;
import co.com.siscomputo.administracion.logic.PlantillaLogic;
import co.com.siscomputo.administracion.logic.ProcesoLogic;
import co.com.siscomputo.administracion.logic.ProcesosLogic;
import co.com.siscomputo.administracion.logic.SubProcesosLogic;
import co.com.siscomputo.administracion.logic.TiposDocumentalesLogic;
import co.com.siscomputo.endpoint.AccionEntity;
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
import co.com.siscomputo.gestiondocumental.entities.GrupoUsuarioAccionProcesoEntity;
import co.com.siscomputo.gestiondocumental.logic.DocumentoLogic;
import co.com.siscomputo.gestiondocumental.logic.GrupoDocumentoLogic;
import com.sun.org.apache.xerces.internal.jaxp.datatype.XMLGregorianCalendarImpl;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.xml.datatype.XMLGregorianCalendar;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.DualListModel;
import org.primefaces.model.TreeNode;

/**
 *
 * @author LENOVO
 */
@ManagedBean(name = "CrearDocumento")
@ViewScoped
public class crearDocumentoBean implements Serializable {

    private ArrayList<ProcesoEntity> lista;
    private ProcesoEntity objetoProceso;
    private Integer[] listaProcesosSeleccion;
    private HashMap<String, Integer>[] listaMapas;
    private String update;
    private DocumentoEntity objetoDocumento;
    private DocumentoEntity objetoDocumentoInsercion;
    private ArrayList<ArrayList<ProcesoEntity>> listaProcesos;
    private ArrayList<HashMap<String, Integer>> desplegablesProcesos;
    private ArrayList<NivelEntity> listaNivel;

    private Integer tope;
    private Integer idProceso;
    private String consecutivo;
    private HashMap<String, GrupoUsuariosEntity> mapaGrupos;
    private ArrayList<GrupoUsuarioAccionProcesoEntity> usuarioAccionProcesoEntity;
    private ArrayList<ProcesoEntity> listaSeleccion;
    private boolean ingresar;
    private boolean actualizar;
    private boolean eliminar;

    public ArrayList<ProcesoEntity> getLista() {
        return lista;
    }

    public void setLista(ArrayList<ProcesoEntity> lista) {
        this.lista = lista;
    }

    public ProcesoEntity getObjetoProceso() {
        return objetoProceso;
    }

    public void setObjetoProceso(ProcesoEntity objetoProceso) {
        this.objetoProceso = objetoProceso;
    }

    public Integer[] getListaProcesos() {
        return listaProcesosSeleccion;
    }

    public void setListaProcesos(Integer[] listaProcesosSeleccion) {
        this.listaProcesosSeleccion = listaProcesosSeleccion;
    }

    public String getUpdate() {
        return update;
    }

    public void setUpdate(String update) {
        this.update = update;
    }

    public HashMap<String, Integer>[] getListaMapas() {
        return listaMapas;
    }

    public void setListaMapas(HashMap<String, Integer>[] listaMapas) {
        this.listaMapas = listaMapas;
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

    public String getConsecutivo() {
        return consecutivo;
    }

    public void setConsecutivo(String consecutivo) {
        this.consecutivo = consecutivo;
    }

    public ArrayList<HashMap<String, Integer>> getDesplegablesProcesos() {
        return desplegablesProcesos;
    }

    public void setDesplegablesProcesos(ArrayList<HashMap<String, Integer>> desplegablesProcesos) {
        this.desplegablesProcesos = desplegablesProcesos;
    }

    public ArrayList<NivelEntity> getListaNivel() {
        return listaNivel;
    }

    public void setListaNivel(ArrayList<NivelEntity> listaNivel) {
        this.listaNivel = listaNivel;
    }



    public Integer getTope() {
        return tope;
    }

    public void setTope(Integer tope) {
        this.tope = tope;
    }

    public Integer getIdProceso() {
        return idProceso;
    }

    public void setIdProceso(Integer idProceso) {
        this.idProceso = idProceso;
    }

    public HashMap<String, GrupoUsuariosEntity> getMapaGrupos() {
        return mapaGrupos;
    }

    public void setMapaGrupos(HashMap<String, GrupoUsuariosEntity> mapaGrupos) {
        this.mapaGrupos = mapaGrupos;
    }

    public ArrayList<GrupoUsuarioAccionProcesoEntity> getUsuarioAccionProcesoEntity() {
        return usuarioAccionProcesoEntity;
    }

    public void setUsuarioAccionProcesoEntity(ArrayList<GrupoUsuarioAccionProcesoEntity> usuarioAccionProcesoEntity) {
        this.usuarioAccionProcesoEntity = usuarioAccionProcesoEntity;
    }

    public ArrayList<ProcesoEntity> getListaSeleccion() {
        return listaSeleccion;
    }

    public void setListaSeleccion(ArrayList<ProcesoEntity> listaSeleccion) {
        this.listaSeleccion = listaSeleccion;
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
        inicializa();
        cargaProcesos();
        permisos();
    }

    public void cargaProcesos() {
        try {
            ProcesoLogic procesoLogic = new ProcesoLogic();
            lista = procesoLogic.listaProceso();
            NivelLogic nivelLogic = new NivelLogic();
            int tama = nivelLogic.listaNivel().size();
            listaProcesosSeleccion = new Integer[tama];
            listaMapas = new HashMap[tama];
            //System.out.println("tama: " + tama);
            for (int i = 0; i < tama; i++) {
                //System.out.println("AA");
                listaMapas[i] = cargaDesplegable(i + 1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public HashMap<String, Integer> cargaDesplegable(Integer nivel) {
        //System.out.println("CAMB: " + nivel);
        HashMap<String, Integer> retorna = new HashMap<String, Integer>();
        for (ProcesoEntity proceso : lista) {
            if (proceso.getNivelProceso().getSecuenciaNivel() == nivel) {
                retorna.put(proceso.getNombreProceso(), proceso.getIdProceso());
            }
        }
        return retorna;
    }

    public void cambiaCombo(Integer nivel, Integer asociado) {
        HashMap<String, Integer> mapaux = new HashMap<String, Integer>();
        if (asociado == null) {
        } else {

            for (ProcesoEntity proceso : lista) {
                if (proceso.getAsociadoProceso() == asociado && proceso.getNivelProceso().getSecuenciaNivel() == nivel) {
                    mapaux.put(proceso.getNombreProceso(), proceso.getIdProceso());
                }
            }
        }

        if (nivel <= listaProcesosSeleccion.length) {

            listaMapas[(nivel - 1)] = mapaux;
            for (int i = nivel; i <= listaMapas.length; i++) {

                //System.out.println("NIVEL: "+i);
                update = "IngresarModal:tabla:" + (i - 1) + ":Desp";
                System.out.println("Update: " + update);
                if (i < listaMapas.length) {
                    listaMapas[i] = new HashMap<String, Integer>();
                    listaProcesosSeleccion[i] = null;
                }
                RequestContext context = RequestContext.getCurrentInstance();
                context.update(update);
            }

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
            ProcesoEntity procesoSeleccion=new ProcesoEntity();
            for(ProcesoEntity proceso:lista){
                if(proceso.getIdProceso()==idProceso){
                    procesoSeleccion=proceso;
                }
            }            
            objetoDocumentoInsercion.setProcesoDocumento(procesoSeleccion);
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
                grupoDocumentoEntity.setFecha(listaUAPE.getFechaLimite());
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
                msg = new FacesMessage("", "inserción de Documento correcto");

            } else {
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
        objetoDocumento.setMacroProcesoDocumento(macroprocesosEntity);
        objetoDocumento.setProcesoProcesoDocumento(procesosEntity);
        objetoDocumento.setSubProcesoProcesoDocumento(subprocesoEntity);
        objetoDocumentoInsercion.setMacroProcesoDocumento(macroprocesosEntity);
        objetoDocumentoInsercion.setProcesoProcesoDocumento(procesosEntity);
        objetoDocumentoInsercion.setSubProcesoProcesoDocumento(subprocesoEntity);
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

    public void evalua() {
        System.out.println("tama: " + listaProcesosSeleccion.length);
        boolean bandera = true;
        int i = 0;
        if (listaProcesosSeleccion[0] == null) {
            bandera = false;
        }
        while (bandera) {
            if (listaProcesosSeleccion[i] == null) {
                System.out.println("Selección: " + listaProcesosSeleccion[i - 1]);
                idProceso = listaProcesosSeleccion[i - 1];
                bandera = false;

            } else {
                i++;
                if (i > listaProcesosSeleccion.length) {
                    bandera = false;
                }
            }
        }
        for (Integer sele : listaProcesosSeleccion) {
            System.out.println("sell: " + sele);
        }

        //System.out.println("INGRESA: "+procesoEntity.getNombreProceso());
        iniciaAcciones();
    }

    public HashMap<String, Integer> ProcesosPorNivelAsociado(int nivel, Integer asociado) {
        HashMap<String, Integer> retorna = new HashMap<>();
        ListaAdministracionBean listaAdministracionBean = new ListaAdministracionBean();
        listaAdministracionBean.cambiarIdNvel(nivel);
        retorna = (HashMap<String, Integer>) listaAdministracionBean.getListaProcesoAsociado();
        return retorna;
    }

    public void inicializa() {
        objetoProceso = new ProcesoEntity();
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
