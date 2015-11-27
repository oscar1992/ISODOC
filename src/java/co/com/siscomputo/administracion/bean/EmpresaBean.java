/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.siscomputo.administracion.bean;

import co.com.siscomputo.administracion.logic.EmpresaLogic;
import co.com.siscomputo.endpoint.EmpresaEntity;
import co.com.siscomputo.endpoint.MenuPermisosEntity;
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
@ManagedBean(name = "Empresas")
@ViewScoped
public class EmpresaBean {
    private ArrayList<EmpresaEntity> lista;
    private ArrayList<EmpresaEntity> listaFiltro;
    private EmpresaEntity empresaObjeto;
    private EmpresaEntity empresaObjetoInsercion;
    private boolean ingresar ;
    private boolean actualizar;
    private boolean eliminar;

    public ArrayList<EmpresaEntity> getLista() {
        return lista;
    }

    public void setLista(ArrayList<EmpresaEntity> lista) {
        this.lista = lista;
    }

    public ArrayList<EmpresaEntity> getListaFiltro() {
        return listaFiltro;
    }

    public void setListaFiltro(ArrayList<EmpresaEntity> listaFiltro) {
        this.listaFiltro = listaFiltro;
    }

    public EmpresaEntity getEmpresaObjeto() {
        return empresaObjeto;
    }

    public void setEmpresaObjeto(EmpresaEntity empresaObjeto) {
        this.empresaObjeto = empresaObjeto;
    }

    public EmpresaEntity getEmpresaObjetoInsercion() {
        return empresaObjetoInsercion;
    }

    public void setEmpresaObjetoInsercion(EmpresaEntity empresaObjetoInsercion) {
        this.empresaObjetoInsercion = empresaObjetoInsercion;
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
        consultarEmpresas();
        permisos();
    }
    /**
     * Método que inicializa el objeto Empresa
     */
    public EmpresaBean() {
        empresaObjeto=new EmpresaEntity();
    }
    
    
    /**
     * Método que trae la lista de Empresas del servicio web
     */
    public void consultarEmpresas(){
        try {
            EmpresaLogic empresaLogic=new EmpresaLogic();
            lista=empresaLogic.listaEmpresas();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * Método que ingresa una Empresa nueva a traves del servicio web
     */
    public void ingresarEmpresa(){
        try {
            EmpresaLogic empresaLogic=new EmpresaLogic();
            EmpresaEntity empresaEntity=empresaLogic.ingresarEmpresa(empresaObjetoInsercion);
            FacesMessage msg=null;
            if(empresaEntity != null){
                msg=new FacesMessage("", "Empresa Ingresada Correctamente: "+empresaEntity.getNombreEmpresa());
                adicionarEmpresaLista(empresaEntity);
            }else{
                msg=new FacesMessage("", "Empresa Ingresada Incorrectamente: "+empresaEntity.getNombreEmpresa());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        RequestContext.getCurrentInstance().execute("PF('insertarEmpresa').hide()");
        nuevaEmpresa();
    }
    /**
     * Método que añade a la lista la sede en la vista
     * @param empresaEntity  
     */
    private void adicionarEmpresaLista(EmpresaEntity empresaEntity) {
        lista.add(empresaEntity);
    }
    /**
     * Método que envia una Empresa para ser actualizada
     */
    public void actualizarEmpresa(){
        EmpresaLogic empresaLogic=new EmpresaLogic();
        String valida=empresaLogic.actualizarEmpresa(empresaObjeto);
        FacesMessage msg=null;
        if("Ok".equalsIgnoreCase(valida)){
            actualizarListaEmpresa(empresaObjeto);
        }else if("Error".equalsIgnoreCase(valida)){
            
        }
        nuevaEmpresa();
        RequestContext.getCurrentInstance().execute("PF('actualizarEmpresa').hide()");
    }
    /**
     * Método que actualiza la lista visual de la tabla
     * @param empresaObjeto 
     */
    private void actualizarListaEmpresa(EmpresaEntity empresaObjeto) {
        try {
            ArrayList<EmpresaEntity>listaaux=new ArrayList<>();
            if(lista!=null){
                for(EmpresaEntity item:lista){
                    if(empresaObjeto.getIdEmpresa()==item.getIdEmpresa()){
                        listaaux.add(empresaObjeto);
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
     * Método que se llama con la selsción de una sede
     * @param event 
     */
    public  void onRowSelect(SelectEvent event){
        empresaObjeto=(EmpresaEntity) event.getObject();
    }
    /**
     * Método que "elimina" una Empresa actualizando su estado
     */
    
    public void eliminarEmpresa(){
        EmpresaLogic empresaLogic=new EmpresaLogic();
        empresaObjeto.setEstadoEmpresa("E");
        empresaLogic.actualizarEmpresa(empresaObjeto);
        eliminarEmpresaLista(empresaObjeto);
        nuevaEmpresa();
        RequestContext.getCurrentInstance().execute("PF('eliminarEmpresa').hide()");
    }
    /**
     * Método que elimina una Empresa en la tabla visual
     * @param empresaEntity 
     */
    public void eliminarEmpresaLista(EmpresaEntity empresaEntity){
        Iterator itr=lista.iterator();
        while (itr.hasNext()) {
            EmpresaEntity empresa=(EmpresaEntity)itr.next();
            if(empresa.getIdEmpresa()==empresaEntity.getIdEmpresa()){
                itr.remove();
            }
            
        }
    }
    /**
     * Método que reinicia el objeto Empresa
     */
    public void nuevaEmpresa(){
        empresaObjeto=new EmpresaEntity();
        empresaObjetoInsercion=new EmpresaEntity();
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
