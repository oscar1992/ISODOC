/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.siscomputo.gestiondocumental.bean;

import co.com.siscomputo.endpoint.DocumentoEntity;
import co.com.siscomputo.endpoint.MenuPermisosEntity;
import co.com.siscomputo.gestiondocumental.logic.DocumentoLogic;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;

/**
 *
 * @author LENOVO
 */
public class PorEstadoBean {
    private ArrayList<DocumentoEntity> lista;
    private ArrayList<DocumentoEntity> listaFiltro;
    private ArrayList<ArrayList<DocumentoEntity>> documentosAccion;
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

    public ArrayList<ArrayList<DocumentoEntity>> getDocumentosAccion() {
        return documentosAccion;
    }

    public void setDocumentosAccion(ArrayList<ArrayList<DocumentoEntity>> documentosAccion) {
        this.documentosAccion = documentosAccion;
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
        
    }
    
    public void cargaPorAccion(){
        //DocumentoLogic
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
