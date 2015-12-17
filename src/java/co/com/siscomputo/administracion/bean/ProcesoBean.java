package co.com.siscomputo.administracion.bean;

import co.com.siscomputo.administracion.logic.NivelLogic;
import co.com.siscomputo.administracion.logic.ProcesoLogic;
import co.com.siscomputo.endpoint.ProcesoEntity;
import co.com.siscomputo.endpoint.MenuPermisosEntity;
import co.com.siscomputo.endpoint.NivelEntity;
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
@ManagedBean(name = "Proceso")
@ViewScoped
public class ProcesoBean implements Serializable {

    private ArrayList<ProcesoEntity> lista;
    private ArrayList<ProcesoEntity> listaFiltro;
    private ProcesoEntity objetoProceso;
    private ProcesoEntity objetoProcesoInsercion;
    private String nombreAsociado;
    private boolean ingresar;
    private boolean actualizar;
    private boolean eliminar;

    public ArrayList<ProcesoEntity> getLista() {
        return lista;
    }

    public void setLista(ArrayList<ProcesoEntity> lista) {
        this.lista = lista;
    }

    public ArrayList<ProcesoEntity> getListaFiltro() {
        return listaFiltro;
    }

    public void setListaFiltro(ArrayList<ProcesoEntity> listaFiltro) {
        this.listaFiltro = listaFiltro;
    }

    public ProcesoEntity getObjetoProceso() {
        return objetoProceso;
    }

    public void setObjetoProceso(ProcesoEntity objetoProceso) {
        this.objetoProceso = objetoProceso;
    }

    public ProcesoEntity getObjetoProcesoInsercion() {
        return objetoProcesoInsercion;
    }

    public void setObjetoProcesoInsercion(ProcesoEntity objetoProcesoInsercion) {
        this.objetoProcesoInsercion = objetoProcesoInsercion;
    }

    public String getNombreAsociado() {
        return nombreAsociado;
    }

    public void setNombreAsociado(String nombreAsociado) {
        this.nombreAsociado = nombreAsociado;
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
        consultarProceso();
        permisos();
    }

    public ProcesoBean() {
        nuevoProcesoObjeto();
    }

    /**
     * Método que trae una lista de Procesos
     */
    public void consultarProceso() {
        try {
            ProcesoLogic procesoLogic = new ProcesoLogic();
            lista = procesoLogic.listaProceso();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Método que permite insertar un Procesos nuevo
     */
    public void instertarProceso() {
        try {
            ProcesoLogic procesoLogic = new ProcesoLogic();
            ProcesoEntity procesoEntity = procesoLogic.insertarProceso(objetoProcesoInsercion);
            System.out.println("-" + objetoProcesoInsercion.getNivelProceso());
            FacesMessage msg = null;
            if (procesoEntity != null) {
                msg = new FacesMessage("", "inserción de Procesos correcto");
                adicionarMetodoPtoteccionLista(procesoEntity);
            } else {
                msg = new FacesMessage("", "inserción de Procesos incorrecto");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Método que añade un Procesos visualmente
     *
     * @param objetoProceso
     */
    private void adicionarMetodoPtoteccionLista(ProcesoEntity objetoProceso) {
        NivelLogic nivelLogic = new NivelLogic();
        ArrayList<NivelEntity> listaNiveles = nivelLogic.listaNivel();
        NivelEntity nivelEntity = new NivelEntity();
        for (NivelEntity nivel : listaNiveles) {
            if (nivel.getIdNivel() == objetoProceso.getNivelProceso().getIdNivel()) {
                nivelEntity = nivel;
            }
        }
        objetoProceso.setNivelProceso(nivelEntity);
        lista.add(objetoProceso);
    }

    /**
     * Método que permite actualizar un Procesos
     */
    public void actualizarProceso() {
        ProcesoLogic metodoRecuperacionLogic = new ProcesoLogic();
        String valida = metodoRecuperacionLogic.actualizarProceso(objetoProceso);
        FacesMessage msg = null;
        if ("Ok".equalsIgnoreCase(valida)) {
            msg = new FacesMessage("", "actualización de Procesos correcto");
            actualizarProcesoLista(objetoProceso);
        } else {
            msg = new FacesMessage("", "actualización de Procesos incorrecto");
        }
        nuevoProcesoObjeto();
        RequestContext.getCurrentInstance().execute("PF('actualizarProceso').hide()");
    }

    /**
     * Método que actualiza visualmente la lista de Procesos
     *
     * @param objetoProceso
     */
    private void actualizarProcesoLista(ProcesoEntity objetoProceso) {
        try {
            ArrayList<ProcesoEntity> listaaux = new ArrayList<>();
            if (lista != null) {
                for (ProcesoEntity item : lista) {
                    int v1 = objetoProceso.getIdProceso();
                    int v2 = item.getIdProceso();
                    if (v1 == v2) {
                        NivelLogic nivelLogic = new NivelLogic();
                        ArrayList<NivelEntity> listaNiveles = nivelLogic.listaNivel();
                        NivelEntity nivelEntity = new NivelEntity();
                        for (NivelEntity nivel : listaNiveles) {
                            if (nivel.getIdNivel() == objetoProceso.getNivelProceso().getIdNivel()) {
                                nivelEntity = nivel;
                            }
                        }
                        objetoProceso.setNivelProceso(nivelEntity);
                        listaaux.add(objetoProceso);
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
        objetoProceso = (ProcesoEntity) event.getObject();
    }

    /**
     * Método que elimina un Procesos
     */
    public void eliminarProceso() {
        ProcesoLogic metodoRecuperacionLogic = new ProcesoLogic();
        objetoProceso.setEstadoProceso("E");
        metodoRecuperacionLogic.actualizarProceso(objetoProceso);
        eliminarProcesoLista(objetoProceso);
        RequestContext.getCurrentInstance().execute("PF('actualizarProceso').hide()");
        nuevoProcesoObjeto();
    }

    /**
     * Método que elimina visualmente un objeto de la lista
     *
     * @param objetoProceso
     */
    private void eliminarProcesoLista(ProcesoEntity objetoProceso) {
        Iterator itr = lista.iterator();
        while (itr.hasNext()) {
            ProcesoEntity metodoRecuperacionEntity = (ProcesoEntity) itr.next();
            if (metodoRecuperacionEntity.getIdProceso() == objetoProceso.getIdProceso()) {
                itr.remove();
            }
        }
    }

    /**
     * Método que reinicia el objeto Procesos
     */
    public void nuevoProcesoObjeto() {
        objetoProceso = new ProcesoEntity();
        objetoProcesoInsercion = new ProcesoEntity();
        NivelEntity nivel = new NivelEntity();
        nivel.setIdNivel(-1);
        objetoProceso.setNivelProceso(nivel);
        objetoProcesoInsercion.setNivelProceso(nivel);
    }

    /**
     * Método que cambia el id por el nombre de un proceso
     *
     * @param idProceso
     */
    public String nombreProceso(int idProceso) {
        ProcesoLogic procesoLogic = new ProcesoLogic();
        System.out.println("pp: " + idProceso);
        nombreAsociado = procesoLogic.procesoPorId(idProceso).getNombreProceso();
        return nombreAsociado;
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
