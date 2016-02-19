/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.siscomputo.proveedores.bean;

import co.com.siscomputo.endpoint.ContratosEntity;
import co.com.siscomputo.endpoint.EmpresaEntity;
import co.com.siscomputo.endpoint.LineaEntity;
import co.com.siscomputo.endpoint.MenuPermisosEntity;
import co.com.siscomputo.endpoint.ProveedoresEntity;
import co.com.siscomputo.endpoint.TipoMonedaEntity;
import co.com.siscomputo.endpoint.UsuarioEntity;
import co.com.siscomputo.proveedores.logic.AnexoContratoLogic;
import co.com.siscomputo.proveedores.logic.ContratoLogic;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author LENOVO
 */
@ManagedBean(name = "CreaContrato")
@ViewScoped
public class ContratosBean {
    
    private String fechaActual;
    private ContratosEntity objetoContratoInsercion;
    private UploadedFile archivo;
    private String ruta="";
    
    private boolean ingresar;
    private boolean actualizar;
    private boolean eliminar;
    
    public String getFechaActual() {
        return fechaActual;
    }

    public void setFechaActual(String fechaActual) {
        this.fechaActual = fechaActual;
    }

    public ContratosEntity getObjetoContratoInsercion() {
        return objetoContratoInsercion;
    }

    public void setObjetoContratoInsercion(ContratosEntity objetoContratoInsercion) {
        this.objetoContratoInsercion = objetoContratoInsercion;
    }

    public UploadedFile getArchivo() {
        return archivo;
    }

    public void setArchivo(UploadedFile archivo) {
        this.archivo = archivo;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
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
        fechaActual();
        nuevoObjetoProveedor();
        permisos();        
    }
    /**
     * Método que inicializa los elementos del bean
     */
    public void nuevoObjetoProveedor(){
        ProveedoresEntity proveedoresEntity=new ProveedoresEntity();
        proveedoresEntity.setIdProveedor(0);
        UsuarioEntity usuarioEntity=new UsuarioEntity();
        usuarioEntity.setIdUsuario(0);
        EmpresaEntity empresaEntity=new EmpresaEntity();
        empresaEntity.setIdEmpresa(0);
        TipoMonedaEntity tipoMonedaEntity=new TipoMonedaEntity();
        tipoMonedaEntity.setIdMoneda(0);
        LineaEntity lineaEntity=new LineaEntity();
        objetoContratoInsercion=new ContratosEntity();
        objetoContratoInsercion.setDocumentoContrato("AA");
        objetoContratoInsercion.setSupervisorContrato(usuarioEntity); 
        objetoContratoInsercion.setIdEmpresaContrato(empresaEntity);
        objetoContratoInsercion.setIdTipoMoneda(tipoMonedaEntity);
        objetoContratoInsercion.setIdLineaProveedor(lineaEntity);
        objetoContratoInsercion.setIdProveedorContrato(proveedoresEntity);
    }
    
    /**
     * Método que trae la fecha actual en la que se genera el documento
     */
    public void fechaActual() {
        Date fech = new Date(System.currentTimeMillis());
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        fechaActual = "" + format.format(fech);
    }
    
    public void subriArchivo(FileUploadEvent event) {
        //Systemut.println("sub");
        if (event.getFile().getSize() > 0) {
            try {
                archivo = event.getFile();

                alamcenarArchivo(event.getFile().getFileName(), event.getFile().getInputstream());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        RequestContext.getCurrentInstance().execute("PF('subir').hide()");
    }

    /**
     * Método que permite almacenar un archivo
     *
     * @param nombre
     * @param in
     * @throws java.io.FileNotFoundException
     */
    public String alamcenarArchivo(String nombre, InputStream in) throws FileNotFoundException, IOException {
        
        try {
            
            //RutasLogic rutasLogic=new RutasLogic();
            //ruta = rutasLogic.rutasPorTipo("DOCUMENTOS").getCarpetaRutas();
            ResourceBundle rb = ResourceBundle.getBundle("co.com.siscomputo.archivos.RUTAS");
            ruta = rb.getString("PROVEEDORES").trim();
            ruta += nombre;
            //Systemut.println("RUTA: " + ruta);
            OutputStream out = new FileOutputStream(new File(ruta));
            
            int read = 0;
            byte[] bytes = new byte[2048];
            while ((read = in.read(bytes)) != -1) {
                out.write(bytes, 0, read);
            }
            in.close();
            out.flush();
            out.close();
            //Systemut.println("Archivo Guardado");

            //objetoDocumentoInsercion.setRutaDocumento(ruta);
        } catch (IOException iOException) {
            iOException.printStackTrace();
        }
        return ruta;
    }
    
    public void insertarArchivo(){
        ContratoLogic contratoLogics=new ContratoLogic();
        ContratosEntity contratosEntity=new ContratosEntity();
        contratosEntity=contratoLogics.insertarContratos(objetoContratoInsercion);
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
                    //Systemut.println("nn: " + nivel2.getNombrePermiso() + "-" + nivel2.getAsociadoMenu() + " - " + idPer);
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
