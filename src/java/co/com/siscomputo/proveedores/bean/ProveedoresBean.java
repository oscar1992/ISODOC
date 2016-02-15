package co.com.siscomputo.proveedores.bean;

import co.com.siscomputo.administracion.logic.CiudadLogic;
import co.com.siscomputo.administracion.logic.PaisesLogic;
import co.com.siscomputo.endpoint.AnexoProveedorEntity;
import co.com.siscomputo.endpoint.CiudadEntity;
import co.com.siscomputo.endpoint.EmpresaEntity;
import co.com.siscomputo.endpoint.EstadoProveedorEntity;
import co.com.siscomputo.endpoint.LineaEntity;
import co.com.siscomputo.proveedores.logic.ProveedoresLogic;
import co.com.siscomputo.endpoint.ProveedoresEntity;
import co.com.siscomputo.endpoint.MenuPermisosEntity;
import co.com.siscomputo.endpoint.PaisEntity;
import co.com.siscomputo.endpoint.UsuarioEntity;
import co.com.siscomputo.proveedores.logic.AnexoProveedorLogic;
import co.com.siscomputo.proveedores.logic.EstadoProveedorLogic;
import co.com.siscomputo.utilidades.MensajesJSF;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.ResourceBundle;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;
import javax.faces.context.FacesContext;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author LENOVO
 */
@ManagedBean(name = "Proveedores")
@ViewScoped
public class ProveedoresBean implements Serializable {

    private ArrayList<ProveedoresEntity> lista;
    private ArrayList<ProveedoresEntity> listaFiltro;
    private ProveedoresEntity objetoProveedores;
    private ProveedoresEntity objetoProveedoresInsercion;
    private String fechaActual;
    private ArrayList<EstadoProveedorEntity> listaEstados;
    private ArrayList<PaisEntity> listaPais;
    private ArrayList<CiudadEntity> listaCiudad;
    private PaisEntity pais;
    private UploadedFile archivo;
    private String ruta;

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

    public ProveedoresEntity getObjetoProveedores() {
        return objetoProveedores;
    }

    public void setObjetoProveedores(ProveedoresEntity objetoProveedores) {
        this.objetoProveedores = objetoProveedores;
    }

    public ProveedoresEntity getObjetoProveedoresInsercion() {
        return objetoProveedoresInsercion;
    }

    public void setObjetoProveedoresInsercion(ProveedoresEntity objetoProveedoresInsercion) {
        this.objetoProveedoresInsercion = objetoProveedoresInsercion;
    }

    public String getFechaActual() {
        return fechaActual;
    }

    public void setFechaActual(String fechaActual) {
        this.fechaActual = fechaActual;
    }

    public ArrayList<EstadoProveedorEntity> getListaEstados() {
        return listaEstados;
    }

    public void setListaEstados(ArrayList<EstadoProveedorEntity> listaEstados) {
        this.listaEstados = listaEstados;
    }

    public ArrayList<PaisEntity> getListaPais() {
        return listaPais;
    }

    public void setListaPais(ArrayList<PaisEntity> listaPais) {
        this.listaPais = listaPais;
    }

    public PaisEntity getPais() {
        return pais;
    }

    public void setPais(PaisEntity pais) {
        this.pais = pais;
    }

    public ArrayList<CiudadEntity> getListaCiudad() {
        return listaCiudad;
    }

    public void setListaCiudad(ArrayList<CiudadEntity> listaCiudad) {
        this.listaCiudad = listaCiudad;
    }

    public UploadedFile getArchivo() {
        return archivo;
    }

    public void setArchivo(UploadedFile archivo) {
        this.archivo = archivo;
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
        consultarProveedores();
        permisos();
    }

    public ProveedoresBean() {
        fechaActual();
        caragaEstados();
        cargaPais();
        cargaCiudad();
        nuevoProveedoresObjeto();
        pais = new PaisEntity();
    }

    /**
     * Método que trae una lista de Proveedor
     */
    public void consultarProveedores() {
        try {
            ProveedoresLogic proveedoresLogic = new ProveedoresLogic();
            lista = proveedoresLogic.listaProveedores();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Método que permite insertar un Proveedor nuevo
     */
    public void instertarProveedores() {
        try {
            ProveedoresLogic proveedoresLogic = new ProveedoresLogic();
            ProveedoresEntity proveedoresEntity = proveedoresLogic.insertarProveedores(objetoProveedoresInsercion);
            FacesMessage msg = null;
            if (proveedoresEntity != null) {
                MensajesJSF.muestraMensajes("inserción de Proveedor correcto", "Mensaje");
                adicionarMetodoPtoteccionLista(proveedoresEntity);
                AnexoProveedorLogic anexoProveedorLogic = new AnexoProveedorLogic();
                AnexoProveedorEntity anexoProveedorEntity = new AnexoProveedorEntity();
                anexoProveedorEntity.setIdAnexoProveedor(proveedoresEntity.getIdProveedor());
                anexoProveedorEntity.setRutaAnexoProveedor(ruta);
                if (anexoProveedorLogic.insertarAnexoProveedor(anexoProveedorEntity) != null) {
                    System.out.println("Ingreso OK");
                }
            } else {
                MensajesJSF.muestraMensajes("inserción de Proveedor incorrecto", "Error");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        RequestContext.getCurrentInstance().execute("PF('insertarProveedores').hide()");
        RequestContext context = RequestContext.getCurrentInstance();
        context.update("IngresarModal:insertarProveedoresModal");
    }

    /**
     * Método que añade un Proveedor visualmente
     *
     * @param objetoProveedores
     */
    private void adicionarMetodoPtoteccionLista(ProveedoresEntity objetoProveedores) {
        lista.add(objetoProveedores);
    }

    /**
     * Método que permite actualizar un Proveedor
     */
    public void actualizarProveedores() {
        ProveedoresLogic metodoRecuperacionLogic = new ProveedoresLogic();
        String valida = metodoRecuperacionLogic.actualizarProveedores(objetoProveedores);
        FacesMessage msg = null;
        if ("Ok".equalsIgnoreCase(valida)) {
            MensajesJSF.muestraMensajes("actualización de Proveedor correcto", "Mensaje");
            actualizarProveedoresLista(objetoProveedores);
        } else {
            MensajesJSF.muestraMensajes("actualización de Proveedor incorrecto", "Error");
        }
        nuevoProveedoresObjeto();
        RequestContext.getCurrentInstance().execute("PF('actualizarProveedores').hide()");
    }

    /**
     * Método que actualiza visualmente la lista de Proveedor
     *
     * @param objetoProveedores
     */
    private void actualizarProveedoresLista(ProveedoresEntity objetoProveedores) {
        try {
            ArrayList<ProveedoresEntity> listaaux = new ArrayList<>();
            if (lista != null) {
                for (ProveedoresEntity item : lista) {
                    int v1 = objetoProveedores.getIdProveedor();
                    int v2 = item.getIdProveedor();
                    if (v1 == v2) {
                        listaaux.add(objetoProveedores);
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
        objetoProveedores = (ProveedoresEntity) event.getObject();
    }

    /**
     * Método que elimina un Proveedor
     */
    public void eliminarProveedores() {
        ProveedoresLogic metodoRecuperacionLogic = new ProveedoresLogic();
        objetoProveedores.setEstadoProveedores("E");
        metodoRecuperacionLogic.actualizarProveedores(objetoProveedores);
        eliminarProveedoresLista(objetoProveedores);
        RequestContext.getCurrentInstance().execute("PF('actualizarProveedores').hide()");
        nuevoProveedoresObjeto();
    }

    /**
     * Método que elimina visualmente un objeto de la lista
     *
     * @param objetoProveedores
     */
    private void eliminarProveedoresLista(ProveedoresEntity objetoProveedores) {
        Iterator itr = lista.iterator();
        while (itr.hasNext()) {
            ProveedoresEntity metodoRecuperacionEntity = (ProveedoresEntity) itr.next();
            if (metodoRecuperacionEntity.getIdProveedor() == objetoProveedores.getIdProveedor()) {
                itr.remove();
            }
        }
    }

    /**
     * Método que reinicia el objeto Proveedor
     */
    public void nuevoProveedoresObjeto() {
        objetoProveedores = new ProveedoresEntity();
        objetoProveedoresInsercion = new ProveedoresEntity();
        LineaEntity lineaEntity = new LineaEntity();
        EmpresaEntity empresaEntity = new EmpresaEntity();
        UsuarioEntity usuarioEntity = new UsuarioEntity();
        objetoProveedores.setUsuarioResponsable(usuarioEntity);
        objetoProveedoresInsercion.setUsuarioResponsable(usuarioEntity);
        objetoProveedores.setEmpresaProveedor(empresaEntity);
        objetoProveedoresInsercion.setEmpresaProveedor(empresaEntity);
        objetoProveedores.setLineaProveedores(lineaEntity);
        objetoProveedoresInsercion.setLineaProveedores(lineaEntity);
    }

    /**
     * Método que trae la fecha actual en la que se genera el documento
     */
    public void fechaActual() {
        Date fech = new Date(System.currentTimeMillis());
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        fechaActual = "" + format.format(fech);
    }

    public void caragaEstados() {
        EstadoProveedorLogic estadoProveedorLogic = new EstadoProveedorLogic();
        listaEstados = estadoProveedorLogic.listaEstadoProveedor();
    }

    public void cargaPais() {
        PaisesLogic paisesLogic = new PaisesLogic();
        listaPais = paisesLogic.listaPaises();
    }

    public void cargaCiudad() {
        if (pais != null) {
            System.out.println("pais no nulo");
            CiudadLogic ciudadLogic = new CiudadLogic();
            listaCiudad = ciudadLogic.ciudadPorPais(pais.getIdPais());
        } else {
            System.out.println("pais nulo");
            CiudadLogic ciudadLogic = new CiudadLogic();
            listaCiudad = ciudadLogic.listaCiudades();
        }
    }

    public void subriArchivo(FileUploadEvent event) {
        System.out.println("sub");
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
            System.out.println("RUTA: " + ruta);
            OutputStream out = new FileOutputStream(new File(ruta));
            int read = 0;
            byte[] bytes = new byte[2048];
            while ((read = in.read(bytes)) != -1) {
                out.write(bytes, 0, read);
            }
            in.close();
            out.flush();
            out.close();
            System.out.println("Archivo Guardado");

            //objetoDocumentoInsercion.setRutaDocumento(ruta);
        } catch (IOException iOException) {
            iOException.printStackTrace();
        }
        return ruta;
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
