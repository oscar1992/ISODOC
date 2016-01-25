package co.com.siscomputo.administracion.bean;

import co.com.siscomputo.administracion.logic.ElaboradorLogic;
import co.com.siscomputo.administracion.logic.UsuarioLogic;
import co.com.siscomputo.endpoint.ElaboradorEntity;
import co.com.siscomputo.endpoint.MenuPermisosEntity;
import co.com.siscomputo.endpoint.UsuarioEntity;
import co.com.siscomputo.utilidades.MensajesJSF;
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

/**
 *
 * @author LENOVO
 */
@ManagedBean(name = "Elaborador")
@ViewScoped
public class ElaboradorBean implements Serializable {

    private ArrayList<ElaboradorEntity> lista;
    private ArrayList<ElaboradorEntity> listaFiltro;
    private ElaboradorEntity objetoElaborador;
    private ElaboradorEntity objetoElaboradorInsercion;
    private boolean ingresar;
    private boolean actualizar;
    private boolean eliminar;

    public ArrayList<ElaboradorEntity> getLista() {
        return lista;
    }

    public void setLista(ArrayList<ElaboradorEntity> lista) {
        this.lista = lista;
    }

    public ArrayList<ElaboradorEntity> getListaFiltro() {
        return listaFiltro;
    }

    public void setListaFiltro(ArrayList<ElaboradorEntity> listaFiltro) {
        this.listaFiltro = listaFiltro;
    }

    public ElaboradorEntity getObjetoElaborador() {
        return objetoElaborador;
    }

    public void setObjetoElaborador(ElaboradorEntity objetoElaborador) {
        this.objetoElaborador = objetoElaborador;
    }

    public ElaboradorEntity getObjetoElaboradorInsercion() {
        return objetoElaboradorInsercion;
    }

    public void setObjetoElaboradorInsercion(ElaboradorEntity objetoElaboradorInsercion) {
        this.objetoElaboradorInsercion = objetoElaboradorInsercion;
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
        consultarElaborador();
        permisos();
    }

    public ElaboradorBean() {
        objetoElaborador = new ElaboradorEntity();
        objetoElaboradorInsercion = new ElaboradorEntity();
        objetoElaborador.setUsuarioElaborador(new UsuarioEntity());
        objetoElaboradorInsercion.setUsuarioElaborador(new UsuarioEntity());
    }

    /**
     * Método que tra una lista de Aprobador Elaborador
     */
    public void consultarElaborador() {
        try {
            ElaboradorLogic elaboradorLogic = new ElaboradorLogic();
            lista = elaboradorLogic.listaElaborador();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Método que permite insertar un Aprobador Elaborador nuevo
     */
    public void instertarElaborador() {
        System.out.println("INSERTA");
        try {
            ElaboradorLogic elaboradorLogic = new ElaboradorLogic();
            ElaboradorEntity elaboradorEntity = elaboradorLogic.insertarElaborador(objetoElaboradorInsercion);
            FacesMessage msg = null;
            if (elaboradorEntity != null) {
                MensajesJSF.muestraMensajes( "inserción de Aprobador Elaborador correcto", "Mensaje");
                adicionarMetodoPtoteccionLista(elaboradorEntity);
            } else {
                MensajesJSF.muestraMensajes( "inserción de Aprobador Elaborador incorrecto", "Error");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Método que añade un Aprobador Elaborador visualmente
     *
     * @param objetoElaborador
     */
    private void adicionarMetodoPtoteccionLista(ElaboradorEntity objetoElaborador) {
        
        UsuarioLogic usuarioLogic=new UsuarioLogic();
        UsuarioEntity usuarioEntity = usuarioLogic.usuarioPorID(objetoElaborador.getUsuarioElaborador().getIdUsuario());
        objetoElaborador.setUsuarioElaborador(usuarioEntity);        
        lista.add(objetoElaborador);
    }

    /**
     * Método que permite actualizar un Aprobador Elaborador
     */
    public void actualizarElaborador() {
        ElaboradorLogic metodoRecuperacionLogic = new ElaboradorLogic();
        String valida = metodoRecuperacionLogic.actualizarElaborador(objetoElaborador);
        FacesMessage msg = null;
        if ("Ok".equalsIgnoreCase(valida)) {
            MensajesJSF.muestraMensajes( "actualización de Aprobador Elaborador correcto", "Mensaje");
            actualizarElaboradorLista(objetoElaborador);
        } else {
            MensajesJSF.muestraMensajes( "actualización de Aprobador Elaborador incorrecto", "Error");
        }
        nuevoElaboradorObjeto();
        RequestContext.getCurrentInstance().execute("PF('actualizarElaborador').hide()");
    }

    /**
     * Método que actualiza visualmente la lista de Aprobador Elaborador
     *
     * @param objetoElaborador
     */
    private void actualizarElaboradorLista(ElaboradorEntity objetoElaborador) {
        try {
            ArrayList<ElaboradorEntity> listaaux = new ArrayList<>();
            if (lista != null) {
                for (ElaboradorEntity item : lista) {
                    int v1 = objetoElaborador.getIdElaborador();
                    int v2 = item.getIdElaborador();
                    if (v1 == v2) {
                        UsuarioLogic usuarioLogic = new UsuarioLogic();
                        UsuarioEntity usuarioEntity = usuarioLogic.usuarioPorID(objetoElaborador .getUsuarioElaborador().getIdUsuario());
                        objetoElaborador.setUsuarioElaborador(usuarioEntity);
                        listaaux.add(objetoElaborador);
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
        objetoElaborador = (ElaboradorEntity) event.getObject();
        if (objetoElaborador.getUsuarioElaborador()== null) {
            UsuarioEntity usuarioEntity = new UsuarioEntity();
            usuarioEntity.setIdUsuario(-1);
            objetoElaborador.setUsuarioElaborador(usuarioEntity);
        }
    }
    
    public void onRowSelect2(SelectEvent event){        
        objetoElaboradorInsercion.setUsuarioElaborador((UsuarioEntity) event.getObject());
        System.out.println("USU: "+((UsuarioEntity) event.getObject()).getNombre());
    }
    /**
     * Método que elimina un Aprobador Elaborador
     */
    public void eliminarElaborador() {
        ElaboradorLogic metodoRecuperacionLogic = new ElaboradorLogic();
        objetoElaborador.setEstadoElaborador("E");
        metodoRecuperacionLogic.actualizarElaborador(objetoElaborador);
        eliminarElaboradorLista(objetoElaborador);
        RequestContext.getCurrentInstance().execute("PF('actualizarElaborador').hide()");
        nuevoElaboradorObjeto();
        MensajesJSF.muestraMensajes( "Eliminación de Aprobador Elaborador correcto", "Mensaje");
    }

    /**
     * Método que elimina visualmente un objeto de la lista
     *
     * @param objetoElaborador
     */
    private void eliminarElaboradorLista(ElaboradorEntity objetoElaborador) {
        Iterator itr = lista.iterator();
        while (itr.hasNext()) {
            ElaboradorEntity metodoRecuperacionEntity = (ElaboradorEntity) itr.next();
            if (metodoRecuperacionEntity.getIdElaborador() == objetoElaborador.getIdElaborador()) {
                itr.remove();
            }
        }
    }

    /**
     * Método que reinicia el objeto Aprobador Elaborador
     */
    public void nuevoElaboradorObjeto() {
        objetoElaborador = new ElaboradorEntity();
        objetoElaboradorInsercion = new ElaboradorEntity();
        UsuarioEntity usuario = new UsuarioEntity();
        usuario.setIdUsuario(-1);
        objetoElaborador.setUsuarioElaborador(usuario);
        objetoElaboradorInsercion.setUsuarioElaborador(usuario);
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
