/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.siscomputo.proveedores.bean;

import co.com.siscomputo.endpoint.DocumentoEntity;
import co.com.siscomputo.endpoint.MenuPermisosEntity;
import co.com.siscomputo.endpoint.ProveedoresEntity;
import co.com.siscomputo.gestiondocumental.bean.DocumentoBean;
import co.com.siscomputo.proveedores.logic.ProveedoresLogic;
import co.com.siscomputo.utilidades.DateToCalendar;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.xml.datatype.DatatypeConfigurationException;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author LENOVO
 */

@ManagedBean(name="ProveedoresFiltro")
@ViewScoped
public class ProveedoresFiltro {
    
    private ArrayList<ProveedoresEntity>lista;
    private ArrayList<ProveedoresEntity>listaFiltro;
    private ProveedoresEntity objetoProveedores;
    private Integer Filtro1;
    private Integer Filtro2;
    private Integer Filtro3;
    private Integer Filtro4;
    private Integer Filtro5;
    private Integer Filtro6;
    private Integer Filtro7;
    private Integer Filtro8;
    private Integer Filtro9;
    private String Filtro10;
    private String Filtro11;
    
    private boolean ingresar;
    private boolean actualizar;
    private boolean eliminar;

    public ArrayList<ProveedoresEntity> getLista() {
        return lista;
    }

    public void setLista(ArrayList<ProveedoresEntity> lista) {
        this.lista = lista;
    }

    public ArrayList<ProveedoresEntity> getListaFiltro() {
        return listaFiltro;
    }

    public void setListaFiltro(ArrayList<ProveedoresEntity> listaFiltro) {
        this.listaFiltro = listaFiltro;
    }

    public Integer getFiltro1() {
        return Filtro1;
    }

    public void setFiltro1(Integer Filtro1) {
        this.Filtro1 = Filtro1;
    }

    public Integer getFiltro2() {
        return Filtro2;
    }

    public void setFiltro2(Integer Filtro2) {
        this.Filtro2 = Filtro2;
    }

    public Integer getFiltro3() {
        return Filtro3;
    }

    public void setFiltro3(Integer Filtro3) {
        this.Filtro3 = Filtro3;
    }

    public Integer getFiltro4() {
        return Filtro4;
    }

    public void setFiltro4(Integer Filtro4) {
        this.Filtro4 = Filtro4;
    }

    public Integer getFiltro5() {
        return Filtro5;
    }

    public void setFiltro5(Integer Filtro5) {
        this.Filtro5 = Filtro5;
    }

    public Integer getFiltro6() {
        return Filtro6;
    }

    public void setFiltro6(Integer Filtro6) {
        this.Filtro6 = Filtro6;
    }

    public Integer getFiltro7() {
        return Filtro7;
    }

    public void setFiltro7(Integer Filtro7) {
        this.Filtro7 = Filtro7;
    }

    public Integer getFiltro8() {
        return Filtro8;
    }

    public void setFiltro8(Integer Filtro8) {
        this.Filtro8 = Filtro8;
    }

    public Integer getFiltro9() {
        return Filtro9;
    }

    public void setFiltro9(Integer Filtro9) {
        this.Filtro9 = Filtro9;
    }

    public String getFiltro10() {
        return Filtro10;
    }

    public void setFiltro10(String Filtro10) {
        this.Filtro10 = Filtro10;
    }

    public String getFiltro11() {
        return Filtro11;
    }

    public void setFiltro11(String Filtro11) {
        this.Filtro11 = Filtro11;
    }

    public ProveedoresEntity getObjetoProveedores() {
        return objetoProveedores;
    }

    public void setObjetoProveedores(ProveedoresEntity objetoProveedores) {
        this.objetoProveedores = objetoProveedores;
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
        permisos();
    }
    /**
     * Método que guarda en sesión un objeto de proveedores y redirecciona a una página de actualización
     * @param event 
     */
    public void onRowSelect(SelectEvent event) {
        objetoProveedores = (ProveedoresEntity) event.getObject();
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("proveedor", objetoProveedores);
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("documento.jsf");
        } catch (IOException ex) {
            Logger.getLogger(DocumentoBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        //FacesContext.getCurrentInstance().responseComplete();
        //System.out.println("select: "+objetoDocumento.getTituloDocumento());
    }
    
    public void nuevoProveedoresObjeto(){
        
    }
    /**
     * Método que filtra los proveedores por criterios
     */
    public void filtro(){
        ProveedoresLogic proveedoresLogic=new ProveedoresLogic();
        Date fecha=new Date();
        Date fecha2=new Date();
        if(Filtro10==null){
            
        }else{
            int dia = 0;
            int mes = 0;
            int ano = 0;
            try {
                if(Filtro10.length()>9){
                dia = Integer.parseInt(Filtro10.substring(0, 2));
                //System.out.println("DIA: "+dia);
                mes = Integer.parseInt(Filtro10.substring(3, 5));
                //System.out.println("MES: "+mes);
                ano = Integer.parseInt(Filtro10.substring(6, 10));
                }
            } catch (Exception e) {
                e.printStackTrace();
                dia=0;
                mes=0;
                ano=0;
            }
            Calendar cal = Calendar.getInstance();
            cal.set(Calendar.DAY_OF_MONTH, dia);
            cal.set(Calendar.MONTH, mes - 1);
            cal.set(Calendar.YEAR, ano);
            fecha= cal.getTime();
        }
        if(Filtro11==null){
            
        }else{
            int dia2 = 0;
            int mes2 = 0;
            int ano2 = 0;
            try {
                if(Filtro11.length()>9){
                dia2 = Integer.parseInt(Filtro11.substring(0, 2));
                //System.out.println("DIA: "+dia);
                mes2 = Integer.parseInt(Filtro11.substring(3, 5));
                //System.out.println("MES: "+mes);
                ano2 = Integer.parseInt(Filtro11.substring(6, 10));
                }
            } catch (Exception e) {
                e.printStackTrace();
                dia2=0;
                mes2=0;
                ano2=0;
            }
            Calendar cal = Calendar.getInstance();
            cal.set(Calendar.DAY_OF_MONTH, dia2);
            cal.set(Calendar.MONTH, mes2 - 1);
            cal.set(Calendar.YEAR, ano2);
            fecha2= cal.getTime();
        }
        DateToCalendar dateToCalendar=new DateToCalendar();
        try {
            lista=proveedoresLogic.proveedoresFiltro(Filtro1, Filtro2, Filtro3, Filtro4, Filtro5, Filtro6, Filtro7, Filtro8, Filtro9, dateToCalendar.convertir(fecha), dateToCalendar.convertir(fecha2));
        } catch (Exception e) {
            e.printStackTrace();
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
