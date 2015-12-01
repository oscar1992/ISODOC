package co.com.siscomputo.administracion.bean;

import co.com.siscomputo.administracion.logic.ModificadorLogic;
import co.com.siscomputo.administracion.logic.UsuarioLogic;
import co.com.siscomputo.endpoint.ModificadorEntity;
import co.com.siscomputo.endpoint.MenuPermisosEntity;
import co.com.siscomputo.endpoint.UsuarioEntity;
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
@ManagedBean(name = "Modificador")
@ViewScoped
public class ModificadorBean implements Serializable {

    private ArrayList<ModificadorEntity> lista;
    private ArrayList<ModificadorEntity> listaFiltro;
    private ModificadorEntity objetoModificador;
    private boolean ingresar;
    private boolean actualizar;
    private boolean eliminar;

    public ArrayList<ModificadorEntity> getLista() {
        return lista;
    }

    public void setLista(ArrayList<ModificadorEntity> lista) {
        this.lista = lista;
    }

    public ArrayList<ModificadorEntity> getListaFiltro() {
        return listaFiltro;
    }

    public void setListaFiltro(ArrayList<ModificadorEntity> listaFiltro) {
        this.listaFiltro = listaFiltro;
    }

    public ModificadorEntity getObjetoModificador() {
        return objetoModificador;
    }

    public void setObjetoModificador(ModificadorEntity objetoModificador) {
        this.objetoModificador = objetoModificador;
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
        consultarModificador();
        permisos();
    }

    public ModificadorBean() {
        objetoModificador = new ModificadorEntity();
        objetoModificador.setUsuarioModificador(new UsuarioEntity());
    }

    /**
     * Método que tra una lista de Aprobador Modificador
     */
    public void consultarModificador() {
        try {
            ModificadorLogic modificadorLogic = new ModificadorLogic();
            lista = modificadorLogic.listaModificador();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Método que permite insertar un Aprobador Modificador nuevo
     */
    public void instertarModificador() {
        try {
            ModificadorLogic modificadorLogic = new ModificadorLogic();
            ModificadorEntity modificadorEntity = modificadorLogic.insertarModificador(objetoModificador);
            FacesMessage msg = null;
            if (modificadorEntity != null) {
                msg = new FacesMessage("", "inserción de Aprobador Modificador correcto");
                adicionarMetodoPtoteccionLista(objetoModificador);
            } else {
                msg = new FacesMessage("", "inserción de Aprobador Modificador incorrecto");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Método que añade un Aprobador Modificador visualmente
     *
     * @param objetoModificador
     */
    private void adicionarMetodoPtoteccionLista(ModificadorEntity objetoModificador) {
        
        UsuarioLogic usuarioLogic=new UsuarioLogic();
        UsuarioEntity modificadorEntity = usuarioLogic.usuarioPorID(objetoModificador.getUsuarioModificador().getIdUsuario());
        objetoModificador.setUsuarioModificador(modificadorEntity);
        lista.add(objetoModificador);
    }

    /**
     * Método que permite actualizar un Aprobador Modificador
     */
    public void actualizarModificador() {
        ModificadorLogic metodoRecuperacionLogic = new ModificadorLogic();
        String valida = metodoRecuperacionLogic.actualizarModificador(objetoModificador);
        FacesMessage msg = null;
        if ("Ok".equalsIgnoreCase(valida)) {
            msg = new FacesMessage("", "actualización de Aprobador Modificador correcto");
            actualizarModificadorLista(objetoModificador);
        } else {
            msg = new FacesMessage("", "actualización de Aprobador Modificador incorrecto");
        }
        nuevoModificadorObjeto();
        RequestContext.getCurrentInstance().execute("PF('actualizarModificador').hide()");
    }

    /**
     * Método que actualiza visualmente la lista de Aprobador Modificador
     *
     * @param objetoModificador
     */
    private void actualizarModificadorLista(ModificadorEntity objetoModificador) {
        try {
            ArrayList<ModificadorEntity> listaaux = new ArrayList<>();
            if (lista != null) {
                for (ModificadorEntity item : lista) {
                    int v1 = objetoModificador.getIdModificador();
                    int v2 = item.getIdModificador();
                    if (v1 == v2) {
                        UsuarioLogic usuarioLogic = new UsuarioLogic();
                        UsuarioEntity usuarioEntity = usuarioLogic.usuarioPorID(objetoModificador.getUsuarioModificador().getIdUsuario());
                        objetoModificador.setUsuarioModificador(usuarioEntity);
                        listaaux.add(objetoModificador);
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
        objetoModificador = (ModificadorEntity) event.getObject();
        if (objetoModificador.getUsuarioModificador()== null) {
            UsuarioEntity pais = new UsuarioEntity();
            pais.setIdUsuario(-1);
            objetoModificador.setUsuarioModificador(pais);
        }
    }

    /**
     * Método que elimina un Aprobador Modificador
     */
    public void eliminarModificador() {
        ModificadorLogic metodoRecuperacionLogic = new ModificadorLogic();
        objetoModificador.setEstadoModificador("E");
        metodoRecuperacionLogic.actualizarModificador(objetoModificador);
        eliminarModificadorLista(objetoModificador);
        RequestContext.getCurrentInstance().execute("PF('actualizarModificador').hide()");
        nuevoModificadorObjeto();
    }

    /**
     * Método que elimina visualmente un objeto de la lista
     *
     * @param objetoModificador
     */
    private void eliminarModificadorLista(ModificadorEntity objetoModificador) {
        Iterator itr = lista.iterator();
        while (itr.hasNext()) {
            ModificadorEntity metodoRecuperacionEntity = (ModificadorEntity) itr.next();
            if (metodoRecuperacionEntity.getIdModificador() == objetoModificador.getIdModificador()) {
                itr.remove();
            }
        }
    }

    /**
     * Método que reinicia el objeto Aprobador Modificador
     */
    public void nuevoModificadorObjeto() {
        objetoModificador = new ModificadorEntity();
        UsuarioEntity usuario = new UsuarioEntity();
        usuario.setIdUsuario(-1);
        objetoModificador.setUsuarioModificador(usuario);
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
