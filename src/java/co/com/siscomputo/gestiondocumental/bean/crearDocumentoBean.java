/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.siscomputo.gestiondocumental.bean;

import co.com.siscomputo.administracion.bean.ListaAdministracionBean;
import co.com.siscomputo.administracion.logic.AccionLogic;
import co.com.siscomputo.administracion.logic.GrupoProcesoLogic;
import co.com.siscomputo.administracion.logic.NivelLogic;
import co.com.siscomputo.administracion.logic.PlantillaLogic;
import co.com.siscomputo.administracion.logic.ProcesoLogic;
import co.com.siscomputo.administracion.logic.RutasLogic;
import co.com.siscomputo.administracion.logic.TiposDocumentalesLogic;
import co.com.siscomputo.administracion.logic.UsuarioLogic;
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
import co.com.siscomputo.endpoint.UsuarioDocumentoEntity;
import co.com.siscomputo.endpoint.UsuarioEntity;
import co.com.siscomputo.gestiondocumental.entities.GrupoUsuarioAccionProcesoEntity;
import co.com.siscomputo.gestiondocumental.logic.DocumentoLogic;
import co.com.siscomputo.gestiondocumental.logic.GrupoDocumentoLogic;
import co.com.siscomputo.gestiondocumental.logic.UsuarioDocumentoLogic;
import co.com.siscomputo.utilidades.DateToCalendar;
import co.com.siscomputo.utilidades.MensajesJSF;
import com.sun.org.apache.xerces.internal.jaxp.datatype.XMLGregorianCalendarImpl;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import static java.util.Arrays.stream;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import static java.util.stream.StreamSupport.stream;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.XMLGregorianCalendar;
import org.primefaces.context.RequestContext;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.event.TransferEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.DualListModel;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.UploadedFile;

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
    private ArrayList<String> aux;
    private boolean flag;
    private HashMap<String, GrupoUsuariosEntity> mapaGrupos;
    private ArrayList<GrupoUsuarioAccionProcesoEntity> usuarioAccionProcesoEntity;
    private ArrayList<ProcesoEntity> listaSeleccion;
    private HashMap<String, Integer> listaIdsUsuarios;
    private UploadedFile archivo;
    private StreamedContent archivo2;

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

    public HashMap<String, Integer> getListaIdsUsuarios() {
        return listaIdsUsuarios;
    }

    public void setListaIdsUsuarios(HashMap<String, Integer> listaIdsUsuarios) {
        this.listaIdsUsuarios = listaIdsUsuarios;
    }

    public UploadedFile getArchivo() {
        return archivo;
    }

    public void setArchivo(UploadedFile archivo) {
        this.archivo = archivo;
    }

    public StreamedContent getArchivo2() {
        return archivo2;
    }

    public void setArchivo2(StreamedContent archivo2) {
        this.archivo2 = archivo2;
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
            System.out.println("TAMA: " + listaIdsUsuarios.size());
            for (Map.Entry<String, Integer> entrySet : listaIdsUsuarios.entrySet()) {
                String nom = entrySet.getKey();
                Integer id = entrySet.getValue();
                System.out.println("NOMBRE: " + nom + " || " + id);
            }

            ProcesoEntity procesoSeleccion = new ProcesoEntity();
            for (ProcesoEntity proceso : lista) {
                if (proceso.getIdProceso() == idProceso) {
                    procesoSeleccion = proceso;
                }
            }
            objetoDocumentoInsercion.setProcesoDocumento(procesoSeleccion);
            DocumentoLogic documentoLogic = new DocumentoLogic();
            
            Date fechaActual=new Date(System.currentTimeMillis());
            Calendar cal = Calendar.getInstance();
            cal.set(Calendar.DAY_OF_MONTH, fechaActual.getDay());
            cal.set(Calendar.MONTH, fechaActual.getMonth());
            cal.set(Calendar.YEAR, fechaActual.getYear());    
            
            DateToCalendar dateToCalendar=new DateToCalendar();
            try {
                XMLGregorianCalendar cale=dateToCalendar.convertir(fechaActual);
                System.out.println("cale: "+cale.toString());
                objetoDocumentoInsercion.setFechaDocumento(cale);
            } catch (DatatypeConfigurationException ex) {
                Logger.getLogger(crearDocumentoBean.class.getName()).log(Level.SEVERE, null, ex);
            }
            DocumentoEntity documentoEntity=new DocumentoEntity();
            documentoEntity = documentoLogic.insertarDocumento(objetoDocumentoInsercion);
            
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
                //calendar.setYear();
                calendar.setMonth(Integer.parseInt(listaUAPE.getFechaLimite().substring(3, 5)));
                calendar.setDay(Integer.parseInt(listaUAPE.getFechaLimite().substring(0, 2)));
                Date fechaaux=new Date(Integer.parseInt(listaUAPE.getFechaLimite().substring(6, 10)), Integer.parseInt(listaUAPE.getFechaLimite().substring(3, 5)), Integer.parseInt(listaUAPE.getFechaLimite().substring(0, 2)));
                //grupoDocumentoEntity.setFecha(calendar);  
                
                grupoDocumentoEntity.setFecha(dateToCalendar.convertir(fechaaux));
                System.out.println("FECHA: "+grupoDocumentoEntity.getFecha().toString());
                //System.out.println("CALENDAR: "+grupoDocumentoEntity.getFecha().toString());
                System.out.println("Lista: " + listaUAPE.getAccion().getNombreAccion());
                //System.out.println("TTT: "+listaUAPE.getFechaLimite());}
                System.out.println("listaU: " + listaUAPE.getSeleccionDual().getTarget().size());
                for (Object nomb : listaUAPE.getSeleccionDual().getTarget()) {
                    System.out.println("NOMB: " + nomb);
                    int ids = listaIdsUsuarios.get(nomb);
                    UsuarioLogic usuarioLogic = new UsuarioLogic();
                    UsuarioEntity usuarioEntity = usuarioLogic.usuarioPorID(ids);
                    UsuarioDocumentoLogic usuarioDocumentoLogic = new UsuarioDocumentoLogic();
                    UsuarioDocumentoEntity usuarioDocumentoEntity = new UsuarioDocumentoEntity();
                    usuarioDocumentoEntity.setDocumentoUsuarioDocumento(documentoEntity);
                    usuarioDocumentoEntity.setUsuarioUsuarioDocumento(usuarioEntity);
                    usuarioDocumentoLogic.insertarUsuarioDocumento(usuarioDocumentoEntity);
                    System.out.println("IDS: " + ids);
                    GrupoUsuariosEntity grupoUsuariosEntity = new GrupoUsuariosEntity();
                    grupoUsuariosEntity = mapaGrupos.get(nomb);
                    grupoDocumentoEntity.setGrupousuariosGrupoDocumento(grupoUsuariosEntity);
                    grupoDocumentoLogic.insertarGrupoDocumento(grupoDocumentoEntity);
                }
            }
            
            //documentoEntity.setRutaDocumento(alamcenarArchivo(archivo.getFileName(), archivo.getInputstream()));
            //System.out.println("OBJ: "+objetoDocumentoInsercion.getTipoDocumentalDocumento().getNombreTipoDocumental());
            FacesMessage msg = null;
            if (documentoEntity != null) {
                
                MensajesJSF.muestraMensajes("inserción de Documento correcto", "Mensaje");

            } else {
                MensajesJSF.muestraMensajes("inserción de Documento incorrecto", "Error");
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
            //usuaccipro.setNombres(nombres);
            //usuaccipro.setSelecion(selecion);
            usuaccipro.setListaGrupos(nombres);
            lista = new DualListModel(new ArrayList<String>(), selecion);
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
        listaIdsUsuarios = new HashMap<>();
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

    /**
     * Método que trae un proceso por nivel y por asociado
     *
     * @param nivel
     * @param asociado
     * @return
     */
    public HashMap<String, Integer> ProcesosPorNivelAsociado(int nivel, Integer asociado) {
        HashMap<String, Integer> retorna = new HashMap<>();
        ListaAdministracionBean listaAdministracionBean = new ListaAdministracionBean();
        listaAdministracionBean.cambiarIdNvel(nivel);
        retorna = (HashMap<String, Integer>) listaAdministracionBean.getListaProcesoAsociado();
        return retorna;
    }

    public void buscaUsuarios() {
        for (GrupoUsuarioAccionProcesoEntity nombre : usuarioAccionProcesoEntity) {
            if (nombre.getGrupo() == null) {
                ArrayList<String> source = new ArrayList<>();
                source.add("");
                DualListModel listad = new DualListModel(new ArrayList<String>(), new ArrayList<String>());
                nombre.setSeleccionDual(listad);
            } else {
                System.out.println("Usuarios: " + nombre.getGrupo().toString());
                GrupoUsuariosEntity gue = mapaGrupos.get(nombre.getGrupo().toString());
                UsuarioLogic usuarioLogic = new UsuarioLogic();
                ArrayList<String> nombreUsuario = new ArrayList<>();
                ArrayList<UsuarioEntity> usuarios = usuarioLogic.usuariosPorGrupo(gue.getIdGrupoUsuarios());
                for (UsuarioEntity usuario : usuarios) {
                    nombreUsuario.add(usuario.getNombre());

                    if (listaIdsUsuarios == null) {

                    } else {
                        listaIdsUsuarios.put(usuario.getNombre(), usuario.getIdUsuario());
                    }
                    System.out.println("USU: " + usuario.getNombre());
                }
                ArrayList<String> auxnombres = nombreUsuario;
                nombre.setListaUsuarios(auxnombres);
                DualListModel listad = new DualListModel(nombreUsuario, nombre.getSeleccionDual().getTarget());
                nombre.setSeleccionDual(listad);
            }
        }
    }

    /**
     * Método que limita a un solo usuario los picklists
     *
     *
     * @param event
     */
    public void limita(TransferEvent event) throws InterruptedException {

        //flag = true;
        if (event == null) {
            System.out.println("nuloo");
        } else {
            if (event.isAdd()) {
                for (GrupoUsuarioAccionProcesoEntity nombre : usuarioAccionProcesoEntity) {
                    if (nombre.getAccion().getIdAccion()!=1) {
                    }else{
                        ArrayList<String> listaAaux = new ArrayList<String>();
                        int suma = 0;
                        ArrayList<String> listaC = new ArrayList<String>();

                        nombre.getSeleccionDual().setTarget(listaC);
                        System.out.println(flag);
                        if (flag == true) {
                            nombre.setListaUsuarios((ArrayList<String>) nombre.getSeleccionDual().getSource());
                            //System.out.println("TAMA: " + nombre.getListaUsuarios().size());
                            suma = 1;
                        } else {
                            suma = 0;
                        }
                        String[] listaB = null;
                        if (nombre.getListaUsuarios() == null) {
                        } else {

                            listaAaux = nombre.getListaUsuarios();
                            listaB = new String[(listaAaux.size()) + suma];
                            //System.out.println("TAMA2: " + nombre.getListaUsuarios().size());

                            listaC = (ArrayList<String>) event.getItems();
                            

                            if (flag) {
                                listaAaux.addAll((Collection<? extends String>) event.getItems());
                                flag = false;
                            }
                            nombre.setListaUsuarios(listaAaux);
                            for (Object trae : nombre.getListaUsuarios()) {
                                //System.out.println("Lista Aantes: " + trae.toString());
                            }
                            if (listaC.size() > 1) {
                                //listaC.addAll(nombre.getSeleccionDual().getTarget());
                                //System.out.println("Se pasó: "+listaC.size());
                                listaB =new String[listaAaux.size()];
                                for (int i = 0; i < listaAaux.size(); i++) {                                    
                                        listaB[i] = listaAaux.get(i);
                                                                           
                                }
                                listaC = new ArrayList<>();
                            } else {
                                for (int i = 0; i < listaAaux.size(); i++) {
                                    //System.out.println("A: " + listaAaux.get(i));
                                    listaB[i] = listaAaux.get(i);
                                }
                            }
                            for (String nombb : listaC) {
                                //System.out.println("LISTA C:" + nombb);
                            }
                            //System.out.println("LISTAC: " + listaC.size());
                            int id = -1;
                            for (int i = 0; i < listaB.length; i++) {
                                for (int j = 0; j < listaC.size(); j++) {
                                    //System.out.println("COMPARA: " + listaB[i] + " - " + listaC.get(j));
                                    if (listaB[i].equalsIgnoreCase(listaC.get(j))) {
                                        id = i;
                                        //System.out.println("ID: " + id);
                                    }
                                }
                            }
                            try {

                                listaB[id] = null;
                                String[] listaborra2 = new String[listaB.length - 1];
                                int j = 0;
                                for (int i = 0; i < listaB.length; i++) {
                                    //System.out.println("QUIEN: " + listaB[i]);
                                    if (listaB[i] == null || listaB[i].equalsIgnoreCase("null")) {
                                        //System.out.println("Nulo: " + listaB[i]);
                                    } else {
                                        listaborra2[j] = listaB[i];
                                        //System.out.println("listaborra[" + j + "]: " + listaborra2[j]);
                                        j++;
                                    }
                                }
                                listaB = new String[listaborra2.length];
                                listaB = listaborra2;

                            } catch (Exception e) {
                                System.out.println("Exception: " + e);
                            }

                            for (String nombb : listaB) {
                                System.out.println("Lista B: " + nombb);
                            }

                            nombre.getListaUsuarios().stream().forEach((trae) -> {
                                System.out.println("Lista A: " + trae);
                            });
                        }
                        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXx");
                        if (nombre.getListaUsuarios() == null) {

                        } else {
                            ArrayList listaBaux = new ArrayList();
                            for (int i = 0; i < listaB.length; i++) {
                                listaBaux.add(listaB[i]);
                            }
                            nombre.getSeleccionDual().setSource(listaBaux);
                            nombre.getSeleccionDual().setTarget(listaC);
                        }
                    }
                }
            }
        }
    }
    
    public void subriArchivo(FileUploadEvent event){
        System.out.println("sub");
        if (event.getFile().getSize() > 0) {
                try {
                    archivo=event.getFile();
                    
                    alamcenarArchivo(event.getFile().getFileName(), event.getFile().getInputstream());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        RequestContext.getCurrentInstance().execute("PF('subir').hide()");
    }
    
    /**
     * Método que permite almacenar un archivo
     * @param nombre
     * @param in
     * @throws java.io.FileNotFoundException
     */
    public String alamcenarArchivo(String nombre, InputStream in) throws FileNotFoundException, IOException {
        String ruta="";
        try {
            //RutasLogic rutasLogic=new RutasLogic();
            //ruta = rutasLogic.rutasPorTipo("DOCUMENTOS").getCarpetaRutas();
            ResourceBundle rb=ResourceBundle.getBundle("co.com.siscomputo.archivos.RUTAS");
            ruta=rb.getString("DOCUMENTOS").trim();
            ruta += nombre;
            System.out.println("RUTA: " + ruta);
            OutputStream out = new FileOutputStream(new File(ruta));
            int read = 0;
            byte[] bytes = new byte[2048];
            while ((read = in.read(bytes)) != -1) {
                out.write(bytes, 0, read);
            }
            in.close();
            out.flush();
            out.close();
            System.out.println("Archivo Guardado");
            objetoDocumentoInsercion.setRutaDocumento(ruta);
        } catch (IOException iOException) {
            iOException.printStackTrace();
        }
        return ruta;
    }
    
    public void inicializa() {
        objetoProceso = new ProcesoEntity();
        flag = true;
    }
    /**
     * Método que selecciona un archivo de plantilla para descargar
     */
   public void seleccionaDescarga() throws FileNotFoundException{
       PlantillaLogic plantillaLogic=new PlantillaLogic();
       PlantillaEntity plantillaEntity=plantillaLogic.PlantillaPorId(objetoDocumentoInsercion.getPlantilla().getIdPlantilla());
       System.out.println("RUTA: "+plantillaEntity.getRutaPlantilla()+" NOM: "+plantillaEntity.getNombrePlantilla());
       InputStream stream=new FileInputStream(plantillaEntity.getRutaPlantilla());               
       archivo2=new DefaultStreamedContent(stream, "", nombreArchivo(plantillaEntity.getRutaPlantilla()));  
   }
    
   public String nombreArchivo(String url){
       String aux = null;
       for(int i=url.length()-1;i>=0;i--){
           if(url.charAt(i)=='/'){
               aux=url.substring(i, url.length());
           }
       }
       return aux;
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
