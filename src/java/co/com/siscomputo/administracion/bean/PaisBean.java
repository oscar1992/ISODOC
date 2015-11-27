package co.com.siscomputo.administracion.bean;

import co.com.siscomputo.administracion.logic.PaisesLogic;
import co.com.siscomputo.endpoint.MenuPermisosEntity;
import co.com.siscomputo.endpoint.PaisEntity;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author LENOVO
 */
@ManagedBean(name = "Paises")
@ViewScoped
public class PaisBean implements Serializable {

    private ArrayList<PaisEntity> lista;
    private ArrayList<PaisEntity> listaFiltro;
    private PaisEntity paisObjeto;
    private PaisEntity paisObjetoInsercion;
    private boolean ingresar;
    private boolean actualizar;
    private boolean eliminar;

    public ArrayList<PaisEntity> getLista() {
        return lista;
    }

    public void setLista(ArrayList<PaisEntity> lista) {
        this.lista = lista;
    }

    public ArrayList<PaisEntity> getListaFiltro() {
        return listaFiltro;
    }

    public void setListaFiltro(ArrayList<PaisEntity> listaFiltro) {
        this.listaFiltro = listaFiltro;
    }

    public PaisEntity getPaisObjeto() {
        return paisObjeto;
    }

    public void setPaisObjeto(PaisEntity paisObjeto) {
        this.paisObjeto = paisObjeto;
    }

    public PaisEntity getPaisObjetoInsercion() {
        return paisObjetoInsercion;
    }

    public void setPaisObjetoInsercion(PaisEntity paisObjetoInsercion) {
        this.paisObjetoInsercion = paisObjetoInsercion;
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
        consultarPaises();
        permisos();
    }

    public PaisBean() {
        paisObjeto = new PaisEntity();
        paisObjetoInsercion = new PaisEntity();

    }
    /**
     * Método que trae la lista de Paises del servicio web
     */
    public void consultarPaises() {
        try {
            PaisesLogic paisesLogic = new PaisesLogic();
            lista = paisesLogic.listaPaises();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Método que ingresa un Pais nuevo a traves del servicio web
     */
    public void ingresarPais() {
        try {
            PaisesLogic paisesLogic = new PaisesLogic();
            PaisEntity paisEntity = paisesLogic.ingresaPais(paisObjetoInsercion);
            FacesMessage msg = null;
            if (paisEntity != null) {
                msg = new FacesMessage("", "País Ingresado Correctamente: " + paisEntity.getNombrePais());
                adicionarPaisLista(paisEntity);
            } else {
                msg = new FacesMessage("", "País Ingresado Incorrectamente: " + paisEntity.getNombrePais());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        RequestContext.getCurrentInstance().execute("PF('insertarPais').hide()");
        
    }

    /**
     * Método que añade a la lista el país en la vista
     *
     * @param paisEntity
     */
    private void adicionarPaisLista(PaisEntity paisEntity) {
        lista.add(paisEntity);
    }

    /**
     * Método que envia un País para ser actualizada
     */
    public void actualizarPais() {
        PaisesLogic paisesLogic = new PaisesLogic();
        String valida = paisesLogic.actualizarPais(paisObjeto);
        FacesMessage msg = null;
        if ("Ok".equalsIgnoreCase(valida)) {
            actualizarListaPais(paisObjeto);
        } else if ("Error".equalsIgnoreCase(valida)) {

        }
        nuevoPais();
        RequestContext.getCurrentInstance().execute("PF('actualizarPais').hide()");
    }

    /**
     * Método que actualiza la lista visual de la tabla
     *
     * @param paisObjeto
     */
    private void actualizarListaPais(PaisEntity paisObjeto) {
        try {
            ArrayList<PaisEntity> listaaux = new ArrayList<>();
            if (lista != null) {
                for (PaisEntity item : lista) {
                    if (paisObjeto.getIdPais() == item.getIdPais()) {
                        listaaux.add(paisObjeto);
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
     * Método que se llama con la selección de un País
     *
     * @param event
     */
    public void onRowSelect(SelectEvent event) {
        paisObjeto = (PaisEntity) event.getObject();
    }

    /**
     * Método que "elimina" un Pais actualizando su estado
     */
    public void eliminarPais() {
        PaisesLogic paisesLogic = new PaisesLogic();
        paisObjeto.setEstadoPais("E");
        paisesLogic.actualizarPais(paisObjeto);
        eliminarPaisLista(paisObjeto);
        paisObjeto = new PaisEntity();
        RequestContext.getCurrentInstance().execute("PF('eliminarPais').hide()");
    }

    /**
     * Método que elimina un país en la tabla visual
     *
     * @param paisObjeto
     */
    private void eliminarPaisLista(PaisEntity paisObjeto) {
        Iterator itr = lista.iterator();
        while (itr.hasNext()) {
            PaisEntity pais = (PaisEntity) itr.next();
            if (pais.getIdPais() == paisObjeto.getIdPais()) {
                itr.remove();
            }
        }
    }

    /**
     * Método que reinicia el objeto pais
     */
    public void nuevoPais() {
        paisObjeto = new PaisEntity();
        paisObjetoInsercion = new PaisEntity();
        //System.out.println("PAIS: "+paisObjeto.getNombrePais());
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
