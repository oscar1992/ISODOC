package co.com.siscomputo.gestiondocumental.bean;

import co.com.siscomputo.administracion.logic.MacroProcesosLogic;
import co.com.siscomputo.administracion.logic.NivelLogic;
import co.com.siscomputo.administracion.logic.PlantillaLogic;
import co.com.siscomputo.administracion.logic.ProcesoLogic;
import co.com.siscomputo.administracion.logic.ProcesosLogic;
import co.com.siscomputo.administracion.logic.SubProcesosLogic;
import co.com.siscomputo.administracion.logic.TiposDocumentalesLogic;
import co.com.siscomputo.gestiondocumental.logic.DocumentoLogic;
import co.com.siscomputo.endpoint.DocumentoEntity;
import co.com.siscomputo.endpoint.MacroprocesosEntity;
import co.com.siscomputo.endpoint.MenuPermisosEntity;
import co.com.siscomputo.endpoint.NivelEntity;
import co.com.siscomputo.endpoint.PlantillaEntity;
import co.com.siscomputo.endpoint.ProcesoEntity;
import co.com.siscomputo.endpoint.ProcesosEntity;
import co.com.siscomputo.endpoint.SubprocesoEntity;
import co.com.siscomputo.endpoint.TiposDocumentalesEntity;
import co.com.siscomputo.gestiondocumental.entities.ArbolProcesoEntity;
import co.com.siscomputo.utilidades.ComparadorNivel;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;
import javax.faces.context.FacesContext;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;

/**
 *
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
    private ArrayList<NivelEntity> listaNivel;
    private ArbolProcesoEntity arbolaux;
    private TreeNode raiz;
    private Integer tope;
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

    public ArbolProcesoEntity getArbolaux() {
        return arbolaux;
    }

    public void setArbolaux(ArbolProcesoEntity arbolaux) {
        this.arbolaux = arbolaux;
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
        consultarDocumento();
        permisos();
    }

    public DocumentoBean() {
        objetoDocumento = new DocumentoEntity();
        objetoDocumentoInsercion = new DocumentoEntity();
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
            Collections.sort(listaNivel, new ComparadorNivel());
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
            iniciaArbolProcesos(listaProcesosTodos);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void iniciaArbolProcesos(ArrayList<ProcesoEntity> listaProcesosTodos) {
        ArrayList<ArbolProcesoEntity> arbol = new ArrayList<>();
        
        
        for (ProcesoEntity proceso2 : listaProcesos.get(0)) {
            tope = listaNivel.size();
            ArbolProcesoEntity arbolObjeto = new ArbolProcesoEntity();
            arbolObjeto.setIdProceso(proceso2.getIdProceso());
            arbolObjeto.setNombreProceso(proceso2.getNombreProceso());
            arbolObjeto.setListaProcesos(hijos(listaProcesosTodos, proceso2));
            arbol.add(arbolObjeto);
        }
        raiz = new DefaultTreeNode("raiz", null);
        TreeNode[] nodos = new TreeNode[arbol.size()];
        int i = 0;
        
        for (ArbolProcesoEntity arbolo : arbol) {
            nodos[i] = new DefaultTreeNode(arbolo.getNombreProceso(), raiz);
            TreeNode[] nodos2 = new TreeNode[arbolo.getListaProcesos().size()];
            int j = 0;
            //for (ArbolProcesoEntity proceso4 : arbolo.getListaProcesos()) {
            if (arbolo.getListaProcesos().isEmpty()) {
            } else {
                addNodos(arbolo.getListaProcesos(), nodos[i], j);
            }
            //}
            j = 0;
            i++;

        }
    }

    public void addNodos(ArrayList<ArbolProcesoEntity> listaProceso, TreeNode nodoi, int j) {
        TreeNode[] nodos = new TreeNode[listaProceso.size()];
        int j2 = 0;
        int tamalista=0;
        for (ArbolProcesoEntity proceso : listaProceso) {
            System.out.println("PROC: "+proceso.getNombreProceso());
            nodos[j] = new DefaultTreeNode(proceso.getNombreProceso(), nodoi);
            ArbolProcesoEntity arbol2 = proceso;
            if (arbol2.getListaProcesos().isEmpty()||arbol2.getListaProcesos()==null||tamalista>=listaProceso.size()) {
                System.out.println("Sale: "+tamalista);
            } else {
                addNodos(arbol2.getListaProcesos(), nodos[j], j2);                
            }
            tamalista++;
            j2++;
        }
        System.out.println("Fin Ciclo");

    }

    /**
     * Método que añade los procesod de un nivel inferior a sus padres a traves
     * del objeto de manejo de la clase arbolproceso
     *
     * @param listaProcesosTodos
     * @param procesoP
     * @return
     */
    public ArrayList<ArbolProcesoEntity> hijos(ArrayList<ProcesoEntity> listaProcesosTodos, ProcesoEntity procesoP) {
        ArrayList<ArbolProcesoEntity> retorna = new ArrayList<>();
        arbolaux=new ArbolProcesoEntity();
        ArrayList<ArbolProcesoEntity> listaN = new ArrayList<>();
        for (ProcesoEntity proceso : listaProcesosTodos) {
            if (proceso.getAsociadoProceso() == procesoP.getIdProceso()) {
                ProcesoEntity proceso2 = proceso;
                if (procesoP.getNivelProceso().getSecuenciaNivel()<=tope) {
                    System.out.println("tope: " + tope + " proc: " + procesoP.getNombreProceso());
                                      
                    listaN = hijos(listaProcesosTodos, proceso2);                    
                    arbolaux.setListaProcesos(listaN);
                    System.out.println("ListaN: "+arbolaux.getListaProcesos().size());
                }
                System.out.println("Proc: " + proceso.getNombreProceso() + " secu: " + procesoP.getNivelProceso().getSecuenciaNivel());
                arbolaux.setNombreProceso(proceso.getNombreProceso());
                arbolaux.setIdProceso(proceso.getIdProceso());
                System.out.println("///////////////");
                
                retorna.add(arbolaux);
                for (ArbolProcesoEntity ret : retorna) {
                    System.out.println("ProcX: " + ret.getNombreProceso() + " - " + ret.getIdProceso());
                }
            }
        }
        for (ArbolProcesoEntity ret : retorna) {
            System.out.println("Proc: " + ret.getNombreProceso() + " - " + ret.getIdProceso());
        }
        return retorna;
    }

    /**
     * Método que permite insertar un Documento nuevo
     */
    public void instertarDocumento() {
        try {
            DocumentoLogic documentoLogic = new DocumentoLogic();
            DocumentoEntity documentoEntity = documentoLogic.insertarDocumento(objetoDocumentoInsercion);
            FacesMessage msg = null;
            if (documentoEntity != null) {
                msg = new FacesMessage("", "inserción de Documento correcto");
                adicionarMetodoPtoteccionLista(documentoEntity);
            } else {
                msg = new FacesMessage("", "inserción de Documento incorrecto");
            }
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
        MacroProcesosLogic macroProcesosLogic = new MacroProcesosLogic();
        MacroprocesosEntity macroprocesosEntity = macroProcesosLogic.macroProcesoPorId(objetoDocumento.getMacroProcesoDocumento().getIdMacroproceso());
        ProcesosLogic procesosLogic = new ProcesosLogic();
        ProcesosEntity procesosEntity = procesosLogic.procesoPorId(objetoDocumento.getProcesoProcesoDocumento().getIdProcesos());
        SubProcesosLogic subProcesosLogic = new SubProcesosLogic();
        SubprocesoEntity subprocesoEntity = subProcesosLogic.subProcesoPorId(objetoDocumento.getSubProcesoProcesoDocumento().getIdSubproceso());
        objetoDocumento.setMacroProcesoDocumento(macroprocesosEntity);
        objetoDocumento.setProcesoProcesoDocumento(procesosEntity);
        objetoDocumento.setSubProcesoProcesoDocumento(subprocesoEntity);
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
            msg = new FacesMessage("", "actualización de Documento correcto");
            actualizarDocumentoLista(objetoDocumento);
        } else {
            msg = new FacesMessage("", "actualización de Documento incorrecto");
        }
        nuevoDocumentoObjeto();
        RequestContext.getCurrentInstance().execute("PF('actualizarDocumento').hide()");
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
                        MacroProcesosLogic macroProcesosLogic = new MacroProcesosLogic();
                        MacroprocesosEntity macroprocesosEntity = macroProcesosLogic.macroProcesoPorId(objetoDocumento.getMacroProcesoDocumento().getIdMacroproceso());
                        ProcesosLogic procesosLogic = new ProcesosLogic();
                        ProcesosEntity procesosEntity = procesosLogic.procesoPorId(objetoDocumento.getProcesoProcesoDocumento().getIdProcesos());
                        SubProcesosLogic subProcesosLogic = new SubProcesosLogic();
                        SubprocesoEntity subprocesoEntity = subProcesosLogic.subProcesoPorId(objetoDocumento.getSubProcesoProcesoDocumento().getIdSubproceso());
                        objetoDocumento.setMacroProcesoDocumento(macroprocesosEntity);
                        objetoDocumento.setProcesoProcesoDocumento(procesosEntity);
                        objetoDocumento.setSubProcesoProcesoDocumento(subprocesoEntity);
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