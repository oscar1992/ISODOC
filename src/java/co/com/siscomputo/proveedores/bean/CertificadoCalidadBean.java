package co.com.siscomputo.proveedores.bean;

import co.com.siscomputo.proveedores.logic.CertificadoCalidadLogic;
import co.com.siscomputo.endpoint.CertificadoCalidadEntity;
import co.com.siscomputo.endpoint.MenuPermisosEntity;
import co.com.siscomputo.utilidades.MensajesJSF;
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
@ManagedBean(name = "CertificadoCalidad")
@ViewScoped
public class CertificadoCalidadBean implements Serializable{
    private ArrayList<CertificadoCalidadEntity> lista;
    private ArrayList<CertificadoCalidadEntity> listaFiltro;
    private CertificadoCalidadEntity objetoCertificadoCalidad;
    private CertificadoCalidadEntity objetoCertificadoCalidadInsercion;
    private boolean ingresar;
    private boolean actualizar;
    private boolean eliminar;

    public ArrayList<CertificadoCalidadEntity> getLista() {
        return lista;
    }

    public void setLista(ArrayList<CertificadoCalidadEntity> lista) {
        this.lista = lista;
    }

    public ArrayList<CertificadoCalidadEntity> getListaFiltro() {
        return listaFiltro;
    }

    public void setListaFiltro(ArrayList<CertificadoCalidadEntity> listaFiltro) {
        this.listaFiltro = listaFiltro;
    }

    public CertificadoCalidadEntity getObjetoCertificadoCalidad() {
        return objetoCertificadoCalidad;
    }

    public void setObjetoCertificadoCalidad(CertificadoCalidadEntity objetoCertificadoCalidad) {
        this.objetoCertificadoCalidad = objetoCertificadoCalidad;
    }

    public CertificadoCalidadEntity getObjetoCertificadoCalidadInsercion() {
        return objetoCertificadoCalidadInsercion;
    }

    public void setObjetoCertificadoCalidadInsercion(CertificadoCalidadEntity objetoCertificadoCalidadInsercion) {
        this.objetoCertificadoCalidadInsercion = objetoCertificadoCalidadInsercion;
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
        consultarCertificadoCalidad();
        permisos();
    }
    public CertificadoCalidadBean() {
        objetoCertificadoCalidad=new CertificadoCalidadEntity();
        objetoCertificadoCalidadInsercion=new CertificadoCalidadEntity();
    }
    /**
     * Método que trae una lista de Certificado de Calidad
     */
    public void consultarCertificadoCalidad(){
        try {
            CertificadoCalidadLogic certificadoCalidadLogic=new CertificadoCalidadLogic();
            lista=certificadoCalidadLogic.listaCertificadoCalidad();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * Método que permite insertar un Certificado de Calidad nuevo
     */
    public void instertarCertificadoCalidad(){
        try {
            CertificadoCalidadLogic certificadoCalidadLogic=new CertificadoCalidadLogic();
            CertificadoCalidadEntity certificadoCalidadEntity=certificadoCalidadLogic.insertarCertificadoCalidad(objetoCertificadoCalidadInsercion);
            FacesMessage msg=null;
            if(certificadoCalidadEntity!=null){
                MensajesJSF.muestraMensajes("inserción de Certificado de Calidad correcto", "Mensaje");
                adicionarMetodoPtoteccionLista(certificadoCalidadEntity);
            }else{
                MensajesJSF.muestraMensajes("inserción de Certificado de Calidad incorrecto", "Error");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        RequestContext.getCurrentInstance().execute("PF('insertarCertificadoCalidad').hide()");
        RequestContext context = RequestContext.getCurrentInstance();
        context.update("IngresarModal:insertarCertificadoCalidadModal");
    }
    /**
     * Método que añade un Certificado de Calidad visualmente
     * @param objetoCertificadoCalidad 
     */
    private void adicionarMetodoPtoteccionLista(CertificadoCalidadEntity objetoCertificadoCalidad) {
        lista.add(objetoCertificadoCalidad);
    }
/**
     * Método que permite actualizar un Certificado de Calidad
     */
    public void actualizarCertificadoCalidad(){
        CertificadoCalidadLogic metodoRecuperacionLogic=new CertificadoCalidadLogic();
        String valida=metodoRecuperacionLogic.actualizarCertificadoCalidad(objetoCertificadoCalidad);
        FacesMessage msg=null;
        if("Ok".equalsIgnoreCase(valida)){
            MensajesJSF.muestraMensajes("actualización de Certificado de Calidad correcto", "Mensaje");
            actualizarCertificadoCalidadLista(objetoCertificadoCalidad);
        }else{
            MensajesJSF.muestraMensajes("actualización de Certificado de Calidad incorrecto", "Error");
        }
        nuevoCertificadoCalidadObjeto();
        RequestContext.getCurrentInstance().execute("PF('actualizarCertificadoCalidad').hide()");
    }
    /**
     * Método que actualiza visualmente la lista de Certificado de Calidad
     * @param objetoCertificadoCalidad 
     */
    private void actualizarCertificadoCalidadLista(CertificadoCalidadEntity objetoCertificadoCalidad) {
        try {
            ArrayList<CertificadoCalidadEntity>listaaux=new ArrayList<>();
            if(lista!=null){
                for(CertificadoCalidadEntity item:lista){
                    int v1=objetoCertificadoCalidad.getIdCertificado();
                    int v2=item.getIdCertificado();
                    if(v1==v2){
                        listaaux.add(objetoCertificadoCalidad);
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
        objetoCertificadoCalidad=(CertificadoCalidadEntity)event.getObject();
    }
    /**
    Método que elimina un Certificado de Calidad
    */
    public void eliminarCertificadoCalidad(){
        CertificadoCalidadLogic metodoRecuperacionLogic=new CertificadoCalidadLogic();
        //objetoCertificadoCalidad.setEstadoCertificadoCalidad("E");
        metodoRecuperacionLogic.actualizarCertificadoCalidad(objetoCertificadoCalidad);
        eliminarCertificadoCalidadLista(objetoCertificadoCalidad);
        RequestContext.getCurrentInstance().execute("PF('actualizarCertificadoCalidad').hide()");
        nuevoCertificadoCalidadObjeto();
    }
    /**
     * Método que elimina visualmente un objeto de la lista
     * @param objetoCertificadoCalidad 
     */
    private void eliminarCertificadoCalidadLista(CertificadoCalidadEntity objetoCertificadoCalidad) {
        Iterator itr=lista.iterator();
        while(itr.hasNext()){
            CertificadoCalidadEntity metodoRecuperacionEntity=(CertificadoCalidadEntity) itr.next();
            if(metodoRecuperacionEntity.getIdCertificado()==objetoCertificadoCalidad.getIdCertificado()){
                itr.remove();
            }
        }
    }
    /**
     * Método que reinicia el objeto Certificado de Calidad
     */
    public void nuevoCertificadoCalidadObjeto() {
        objetoCertificadoCalidad=new CertificadoCalidadEntity();
        objetoCertificadoCalidadInsercion=new CertificadoCalidadEntity();
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