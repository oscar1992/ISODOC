package co.com.siscomputo.administracion.bean;

import co.com.siscomputo.administracion.logic.AccionLogic;
import co.com.siscomputo.administracion.logic.GrupoProcesoLogic;
import co.com.siscomputo.administracion.logic.ProcesoLogic;
import co.com.siscomputo.endpoint.AccionEntity;
import co.com.siscomputo.endpoint.GrupoProcesoEntity;
import co.com.siscomputo.endpoint.GrupoUsuariosEntity;
import co.com.siscomputo.endpoint.MenuPermisosEntity;
import co.com.siscomputo.endpoint.ObjetoRetornaEntity;
import co.com.siscomputo.endpoint.ProcesoEntity;
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
import org.primefaces.event.TransferEvent;
import org.primefaces.model.DualListModel;

/**
 *
 * @author LENOVO
 */
@ManagedBean(name = "GrupoProceso")
@ViewScoped
public class GrupoProcesoBean implements Serializable {

    private ArrayList<GrupoProcesoEntity> lista;
    private ArrayList<GrupoProcesoEntity> listaFiltro;
    private GrupoProcesoEntity objetoGrupoProceso;
    private GrupoProcesoEntity objetoGrupoProcesoInsercion;
    private GrupoUsuariosEntity objetoGrupoUsuarios;
    private DualListModel<String> listaAcciones;
    private DualListModel<String> listaProcesos;
    private ArrayList<String> nombreAcciones;
    private ArrayList<String> nombreProcesos;
    private ArrayList<String> seleccionAcciones;
    private ArrayList<String> seleccionProcesos;
    private String nombreProceso;
    private Integer idGrupo;
    private Integer idProceso;
    private boolean ingresar;
    private boolean actualizar;
    private boolean eliminar;

    public ArrayList<GrupoProcesoEntity> getLista() {
        return lista;
    }

    public void setLista(ArrayList<GrupoProcesoEntity> lista) {
        this.lista = lista;
    }

    public ArrayList<GrupoProcesoEntity> getListaFiltro() {
        return listaFiltro;
    }

    public void setListaFiltro(ArrayList<GrupoProcesoEntity> listaFiltro) {
        this.listaFiltro = listaFiltro;
    }

    public GrupoProcesoEntity getObjetoGrupoProceso() {
        return objetoGrupoProceso;
    }

    public void setObjetoGrupoProceso(GrupoProcesoEntity objetoGrupoProceso) {
        this.objetoGrupoProceso = objetoGrupoProceso;
    }

    public GrupoProcesoEntity getObjetoGrupoProcesoInsercion() {
        return objetoGrupoProcesoInsercion;
    }

    public void setObjetoGrupoProcesoInsercion(GrupoProcesoEntity objetoGrupoProcesoInsercion) {
        this.objetoGrupoProcesoInsercion = objetoGrupoProcesoInsercion;
    }

    public GrupoUsuariosEntity getObjetoGrupoUsuarios() {
        return objetoGrupoUsuarios;
    }

    public void setObjetoGrupoUsuarios(GrupoUsuariosEntity objetoGrupoUsuarios) {
        this.objetoGrupoUsuarios = objetoGrupoUsuarios;
    }

    public DualListModel<String> getListaAcciones() {
        return listaAcciones;
    }

    public void setListaAcciones(DualListModel<String> listaAcciones) {
        this.listaAcciones = listaAcciones;
    }

    public DualListModel<String> getListaProcesos() {
        return listaProcesos;
    }

    public void setListaProcesos(DualListModel<String> listaProcesos) {
        this.listaProcesos = listaProcesos;
    }

    public ArrayList<String> getNombreAcciones() {
        return nombreAcciones;
    }

    public void setNombreAcciones(ArrayList<String> nombreAcciones) {
        this.nombreAcciones = nombreAcciones;
    }

    public ArrayList<String> getNombreProcesos() {
        return nombreProcesos;
    }

    public void setNombreProcesos(ArrayList<String> nombreProcesos) {
        this.nombreProcesos = nombreProcesos;
    }

    public ArrayList<String> getSeleccionAcciones() {
        return seleccionAcciones;
    }

    public void setSeleccionAcciones(ArrayList<String> seleccionAcciones) {
        this.seleccionAcciones = seleccionAcciones;
    }

    public ArrayList<String> getSeleccionProcesos() {
        return seleccionProcesos;
    }

    public void setSeleccionProcesos(ArrayList<String> seleccionProcesos) {
        this.seleccionProcesos = seleccionProcesos;
    }

    public String getNombreProceso() {
        return nombreProceso;
    }

    public void setNombreProceso(String nombreProceso) {
        this.nombreProceso = nombreProceso;
    }

    public Integer getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(Integer idGrupo) {
        this.idGrupo = idGrupo;
    }

    public Integer getIdProceso() {
        return idProceso;
    }

    public void setIdProceso(Integer idProceso) {
        this.idProceso = idProceso;
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
    }

    public GrupoProcesoBean() {
        objetoGrupoProceso = new GrupoProcesoEntity();
        objetoGrupoProcesoInsercion = new GrupoProcesoEntity();
        listaAcciones = new DualListModel<String>();
        listaProcesos = new DualListModel<String>();
        lista=new ArrayList<>();
        
    }

    /**
     * Método que trae una lista de Grupo de Usuarios y Procesos
     */
    public void consultarGrupoProceso() {
        try {
            GrupoProcesoLogic grupoProcesoLogic = new GrupoProcesoLogic();
            ArrayList<ProcesoEntity> listaProcesoEntity=new ArrayList<>();
            //System.out.println("IDGRUPOC: "+idGrupo);
            listaProcesoEntity = grupoProcesoLogic.listaGrupoProceso(idGrupo);
            for(ProcesoEntity grupoP:listaProcesoEntity){
                seleccionProcesos.add(grupoP.getNombreProceso());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void consultarAccionesPorProceso(){
        try {
            GrupoProcesoLogic grupoProcesoLogic = new GrupoProcesoLogic();
            ArrayList<GrupoProcesoEntity>listaAcciones=grupoProcesoLogic.listaGrupoProcesoAccion(idGrupo, idProceso);
            for(GrupoProcesoEntity proceso:listaAcciones){
                seleccionAcciones.add(proceso.getAccionGrupoProceso().getNombreAccion());
            }
        } catch (Exception e) {
        }
    } 

    /**
     * Método que carga la lista de acciones en el dual list model
     */
    public void cargaListaAcciones() {
        AccionLogic accionLogic = new AccionLogic();
        ArrayList<AccionEntity> listaAcciones2 = accionLogic.listaAccion();
        nombreAcciones = new ArrayList<>();
        seleccionAcciones = new ArrayList<>();
        consultarAccionesPorProceso();
        for (AccionEntity accion : listaAcciones2) {            
            nombreAcciones.add(accion.getNombreAccion());
        }
        this.listaAcciones = new DualListModel<>(nombreAcciones, seleccionAcciones);
    }

    public void cargarListaProcesos() {
        ProcesoLogic procesoLogic = new ProcesoLogic();
        ArrayList<ProcesoEntity> listaProcesos = procesoLogic.listaProceso();
        nombreProcesos = new ArrayList<>();
        seleccionProcesos = new ArrayList<>();
        consultarGrupoProceso();
        for (ProcesoEntity proceso : listaProcesos) {
            //System.out.println("Proc: "+proceso.getNombreProceso());
            nombreProcesos.add(proceso.getNombreProceso());
        }
        this.listaProcesos = new DualListModel<>(nombreProcesos, seleccionProcesos);
    }

    /**
     * Método que permite insertar un Grupo de Usuarios y Procesos nuevo
     */
    public void instertarGrupoProceso() {
        try {
            if (listaAcciones.getTarget().size() > 0) {
                
                GrupoProcesoLogic grupoProcesoLogic = new GrupoProcesoLogic();
                ObjetoRetornaEntity grupoProcesoEntity = grupoProcesoLogic.insertarGrupoProceso(objetoGrupoUsuarios, nombreProceso, (ArrayList<String>) listaAcciones.getTarget());

                FacesMessage msg = null;
                if (grupoProcesoEntity.getRetorna() != null) {
                    msg = new FacesMessage("", "inserción de Grupo de Usuarios y Procesos correcto");

                } else {
                    msg = new FacesMessage("", "inserción de Grupo de Usuarios y Procesos incorrecto");

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        RequestContext.getCurrentInstance().execute("PF('actualizarGrupoProceso').hide()");
    }

    /**
     * Método que permite actualizar un Grupo de Usuarios y Procesos
     */
    public void actualizarGrupoProceso() {
        GrupoProcesoLogic metodoRecuperacionLogic = new GrupoProcesoLogic();
        String valida = metodoRecuperacionLogic.actualizarGrupoProceso(objetoGrupoProceso);
        FacesMessage msg = null;
        if ("Ok".equalsIgnoreCase(valida)) {
            msg = new FacesMessage("", "actualización de Grupo de Usuarios y Procesos correcto");
            actualizarGrupoProcesoLista(objetoGrupoProceso);
        } else {
            msg = new FacesMessage("", "actualización de Grupo de Usuarios y Procesos incorrecto");
        }
        nuevoGrupoProcesoObjeto();
        RequestContext.getCurrentInstance().execute("PF('actualizarGrupoProceso').hide()");
    }

    /**
     * Método que actualiza visualmente la lista de Grupo de Usuarios y Procesos
     *
     * @param objetoGrupoProceso
     */
    private void actualizarGrupoProcesoLista(GrupoProcesoEntity objetoGrupoProceso) {
        try {
            ArrayList<GrupoProcesoEntity> listaaux = new ArrayList<>();
            if (lista != null) {
                for (GrupoProcesoEntity item : lista) {
                    int v1 = objetoGrupoProceso.getIdGrupoProceso();
                    int v2 = item.getIdGrupoProceso();
                    if (v1 == v2) {
                        listaaux.add(objetoGrupoProceso);
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
        objetoGrupoUsuarios = (GrupoUsuariosEntity) event.getObject();
        idGrupo=objetoGrupoUsuarios.getIdGrupoUsuarios();

        cargarListaProcesos();
    }
    /**
     * Método que que se llama al mover un proceso
     * @param event 
     */
    public void onSelect(TransferEvent event) {
        
        if(event.isAdd()){
        nombreProceso = (String) event.getItems().get(0);
        //System.out.println("Proceso: " + nombreProceso);
        RequestContext.getCurrentInstance().execute("PF('actualizarGrupoProceso').show()");
        cargaListaAcciones();
        }else{
            RequestContext.getCurrentInstance().execute("PF('actualizarGrupoProceso').hide()");
        }
    }
    
    /**
     * Método que que se llama al selecionar un proceso
     * @param event 
     */
    public void onSelect2(SelectEvent event) {        
        nombreProceso = (String) event.getObject();
        GrupoProcesoLogic grupoProcesoLogic=new GrupoProcesoLogic();
        ArrayList<ProcesoEntity>listaProc=grupoProcesoLogic.listaGrupoProceso(idGrupo);
        for(ProcesoEntity proceso:listaProc){
            if(nombreProceso.equals(proceso.getNombreProceso())){
                //System.out.println("existe: "+nombreProceso);
                idProceso=proceso.getIdProceso();                
                RequestContext.getCurrentInstance().execute("PF('actualizarGrupoProceso').show()");
                cargaListaAcciones();
                
            }
        }
        /*
        for(String nombre:nombreProcesos){
            if(nombre.equals(nombreProceso)){
                System.out.println("Proceso: " + nombreProceso);
            }else{
                
            }
        }
        */
        //
        //
    }
    
    /**
     * Método que elimina un Grupo de Usuarios y Procesos
     */
    public void eliminarGrupoProceso() {
        GrupoProcesoLogic metodoRecuperacionLogic = new GrupoProcesoLogic();
        //objetoGrupoProceso.setEstadoGrupoProceso("E");
        metodoRecuperacionLogic.actualizarGrupoProceso(objetoGrupoProceso);
        eliminarGrupoProcesoLista(objetoGrupoProceso);
        
        RequestContext.getCurrentInstance().execute("PF('actualizarGrupoProceso').hide()");
        nuevoGrupoProcesoObjeto();
    }

    /**
     * Método que elimina visualmente un objeto de la lista
     *
     * @param objetoGrupoProceso
     */
    private void eliminarGrupoProcesoLista(GrupoProcesoEntity objetoGrupoProceso) {
        Iterator itr = lista.iterator();
        while (itr.hasNext()) {
            GrupoProcesoEntity metodoRecuperacionEntity = (GrupoProcesoEntity) itr.next();
            if (metodoRecuperacionEntity.getIdGrupoProceso() == objetoGrupoProceso.getIdGrupoProceso()) {
                itr.remove();
            }
        }
    }

    /**
     * Método que reinicia el objeto Grupo de Usuarios y Procesos
     */
    public void nuevoGrupoProcesoObjeto() {
        objetoGrupoProceso = new GrupoProcesoEntity();
        objetoGrupoProcesoInsercion = new GrupoProcesoEntity();
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
