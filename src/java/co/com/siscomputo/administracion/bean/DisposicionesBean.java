 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.siscomputo.administracion.bean;

import co.com.siscomputo.administracion.logic.DisposicionesLogic;
import co.com.siscomputo.endpoint.DisposicionesEntity;
import co.com.siscomputo.endpoint.MenuPermisosEntity;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author LENOVO
 */
@ManagedBean(name = "Disposiciones")
public class DisposicionesBean implements Serializable {

    ArrayList<DisposicionesEntity> lista;
    ArrayList<DisposicionesEntity> listaFiltro;
    DisposicionesEntity disposiscionObjeto;
    private boolean ingresar;
    private boolean actualizar;
    private boolean eliminar;

    public ArrayList<DisposicionesEntity> getLista() {
        return lista;
    }

    public void setLista(ArrayList<DisposicionesEntity> lista) {
        this.lista = lista;
    }

    public ArrayList<DisposicionesEntity> getListaFiltro() {
        return listaFiltro;
    }

    public void setListaFiltro(ArrayList<DisposicionesEntity> listaFiltro) {
        this.listaFiltro = listaFiltro;
    }

    public DisposicionesEntity getDisposiscionObjeto() {
        return disposiscionObjeto;
    }

    public void setDisposiscionObjeto(DisposicionesEntity disposiscionObjeto) {
        this.disposiscionObjeto = disposiscionObjeto;
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
        consultarDisosiciones();
        permisos();
    }

    public DisposicionesBean() {
        disposiscionObjeto=new DisposicionesEntity();
    }
    
    
    /**
     * Método que trae la lista de dsipociciones disponibles
     */
    public void consultarDisosiciones() {
        try {
            DisposicionesLogic disposicionesLogic = new DisposicionesLogic();
            lista = disposicionesLogic.listaDisposiciones();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Método que inserta una disposición nueva
     */
    public void insertarDisposicion() {
        try {
            DisposicionesLogic disposicionesLogic = new DisposicionesLogic();
            DisposicionesEntity disposicionesEntity = disposicionesLogic.ingresaDisposicion(disposiscionObjeto);
            FacesMessage msg = null;
            if (disposicionesEntity != null) {
                msg = new FacesMessage("", "Inserción de disposición correcta" + disposicionesEntity.getNombreDisposiciones());
                adicionarDisposicionLista(disposiscionObjeto);
            } else {
                msg = new FacesMessage("", "Inserción de disposición incorrecta" + disposicionesEntity.getNombreDisposiciones());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        nuevoDisposicionObjeto();
        RequestContext.getCurrentInstance().execute("PF('insertarDisposicion').hide()");
    }

    /**
     * Método que añade una disposición visualmente
     *
     * @param disposiscionObjeto
     */
    public void adicionarDisposicionLista(DisposicionesEntity disposiscionObjeto) {
        lista.add(disposiscionObjeto);
    }
    /**
     * Método que actializa una Disposición
     */
    public void actualizarDisposicion() {
        DisposicionesLogic disposicionesLogic = new DisposicionesLogic();
        String valida = disposicionesLogic.actualizarDisposicion(disposiscionObjeto);
        FacesMessage msg=null;
        if ("Ok".equalsIgnoreCase(valida)) {
            actualizarDisposicionLista(disposiscionObjeto);
            msg=new FacesMessage("","Disposiciones actualizado correctamente"+disposiscionObjeto.getNombreDisposiciones());
        } else {
            msg=new FacesMessage("","Disposiciones actualizado incorrectamente"+disposiscionObjeto.getNombreDisposiciones());
        }       
        nuevoDisposicionObjeto();
        RequestContext.getCurrentInstance().execute("PF('actualizarDisposicion').hide()");
    }
    /**
     * Método que reinicia el objeto disposción 
     */
    public void nuevoDisposicionObjeto() {
        disposiscionObjeto=new DisposicionesEntity();
    }
    /**
     * Método que actualiza visualmente la lista de siaposiciones
     * @param disposiscionObjeto 
     */
    private void actualizarDisposicionLista(DisposicionesEntity disposiscionObjeto) {
        try {
            ArrayList<DisposicionesEntity> listaaux=new ArrayList<>();
            if(lista!=null){
                for(DisposicionesEntity item:lista){
                    if(disposiscionObjeto.getIdDisposirciones()==item.getIdDisposirciones()){
                        listaaux.add(disposiscionObjeto);
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
     * Método que se invoca al selecionar una fila de la tabla
     * @param event 
     */
    public void onRowSelect(SelectEvent event){
        disposiscionObjeto=(DisposicionesEntity)event.getObject();
        System.out.println("dispo:");
    }
    /**
     * Método que elimina una disposición
     */
    public void eliminarDisposicion(){
        DisposicionesLogic disposicionesLogic=new DisposicionesLogic();
        disposiscionObjeto.setEstadoDisposiciones("E");;
        disposicionesLogic.actualizarDisposicion(disposiscionObjeto);
        eliminarDisposisionLista(disposiscionObjeto);
        RequestContext.getCurrentInstance().execute("PF('actualizarDisposicion').hide()");
        nuevoDisposicionObjeto();
    }
    /**
     * Método que elimina visualmente una disposición de la lista
     * @param disposiscionObjeto 
     */
    private void eliminarDisposisionLista(DisposicionesEntity disposiscionObjeto) {
        Iterator itr=lista.iterator();
        while (itr.hasNext()) {
            DisposicionesEntity disposicionesEntity=(DisposicionesEntity) itr.next();
            if(disposicionesEntity.getIdDisposirciones()==disposiscionObjeto.getIdDisposirciones()){
                itr.remove();
            }
            
        }
        
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
