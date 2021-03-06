package co.com.siscomputo.administracion.bean;

import co.com.siscomputo.administracion.logic.ExtensionesLogic;
import co.com.siscomputo.administracion.logic.PlantillaLogic;
import co.com.siscomputo.administracion.logic.RutasLogic;
import co.com.siscomputo.endpoint.ExtensionesEntity;
import co.com.siscomputo.endpoint.PlantillaEntity;
import co.com.siscomputo.endpoint.MenuPermisosEntity;
import co.com.siscomputo.utilidades.MensajesJSF;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.ArrayList;
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
@ManagedBean(name = "Plantilla")
@ViewScoped
public class PlantillaBean implements Serializable {

    private ArrayList<PlantillaEntity> lista;
    private ArrayList<PlantillaEntity> listaFiltro;
    private PlantillaEntity objetoPlantilla;
    private PlantillaEntity objetoPlantillaInsercion;
    private UploadedFile file;
    private String extensiones;
    private boolean ingresar;
    private boolean actualizar;
    private boolean eliminar;

    public ArrayList<PlantillaEntity> getLista() {
        return lista;
    }

    public void setLista(ArrayList<PlantillaEntity> lista) {
        this.lista = lista;
    }

    public ArrayList<PlantillaEntity> getListaFiltro() {
        return listaFiltro;
    }

    public void setListaFiltro(ArrayList<PlantillaEntity> listaFiltro) {
        this.listaFiltro = listaFiltro;
    }

    public PlantillaEntity getObjetoPlantilla() {
        return objetoPlantilla;
    }

    public void setObjetoPlantilla(PlantillaEntity objetoPlantilla) {
        this.objetoPlantilla = objetoPlantilla;
    }

    public PlantillaEntity getObjetoPlantillaInsercion() {
        return objetoPlantillaInsercion;
    }

    public void setObjetoPlantillaInsercion(PlantillaEntity objetoPlantillaInsercion) {
        this.objetoPlantillaInsercion = objetoPlantillaInsercion;
    }

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }

    public String getExtensiones() {
        return extensiones;
    }

    public void setExtensiones(String extensiones) {
        this.extensiones = extensiones;
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
        consultarPlantilla();
        permisos();
    }

    public PlantillaBean() {
        objetoPlantilla = new PlantillaEntity();
        objetoPlantillaInsercion = new PlantillaEntity();
        
    }

    /**
     * Método que tra una lista de Plantilla de Gestión Documental
     */
    public void consultarPlantilla() {
        try {
            PlantillaLogic plantillaLogic = new PlantillaLogic();
            lista = plantillaLogic.listaPlantilla();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void subriArchivo(FileUploadEvent event){
        if (event.getFile().getSize() > 0) {
                try {
                    alamcenarArchivo(event.getFile().getFileName(), event.getFile().getInputstream());
                } catch (IOException iOException) {
                    iOException.printStackTrace();
                }
            }
    }
    /**
     * Método que permite insertar un Plantilla de Gestión Documental nuevo
     */
    public void instertarPlantilla() {
        try {
            PlantillaLogic plantillaLogic = new PlantillaLogic();
            
            PlantillaEntity plantillaEntity = plantillaLogic.insertarPlantilla(objetoPlantillaInsercion);
            FacesMessage msg = null;
            if (plantillaEntity != null) {
                MensajesJSF.muestraMensajes( "inserción de Plantilla de Gestión Documental correcto", "Mensaje");
                adicionarMetodoPtoteccionLista(plantillaEntity);
            } else {
                MensajesJSF.muestraMensajes( "inserción de Plantilla de Gestión Documental incorrecto", "Error");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Método que añade un Plantilla de Gestión Documental visualmente
     *
     * @param objetoPlantilla
     */
    private void adicionarMetodoPtoteccionLista(PlantillaEntity objetoPlantilla) {
        lista.add(objetoPlantilla);
    }

    /**
     * Método que permite actualizar un Plantilla de Gestión Documental
     */
    public void actualizarPlantilla() {
        PlantillaLogic metodoRecuperacionLogic = new PlantillaLogic();
        String valida = metodoRecuperacionLogic.actualizarPlantilla(objetoPlantilla);
        FacesMessage msg = null;
        if ("Ok".equalsIgnoreCase(valida)) {
            MensajesJSF.muestraMensajes( "actualización de Plantilla de Gestión Documental correcto", "Mensaje");
            actualizarPlantillaLista(objetoPlantilla);
        } else {
            MensajesJSF.muestraMensajes( "actualización de Plantilla de Gestión Documental incorrecto", "Error");
        }
        nuevoPlantillaObjeto();
        RequestContext.getCurrentInstance().execute("PF('actualizarPlantilla').hide()");
    }

    /**
     * Método que actualiza visualmente la lista de Plantilla de Gestión
     * Documental
     *
     * @param objetoPlantilla
     */
    private void actualizarPlantillaLista(PlantillaEntity objetoPlantilla) {
        try {
            ArrayList<PlantillaEntity> listaaux = new ArrayList<>();
            if (lista != null) {
                for (PlantillaEntity item : lista) {
                    System.out.println("V1: " + objetoPlantilla.getIdPlantilla());
                    System.out.println("V2: " + item.getIdPlantilla());
                    int v1 = objetoPlantilla.getIdPlantilla();
                    int v2 = item.getIdPlantilla();
                    if (v1 == v2) {
                        listaaux.add(objetoPlantilla);
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
        objetoPlantilla = (PlantillaEntity) event.getObject();
    }

    /**
     * Método que elimina un Plantilla de Gestión Documental
     */
    public void eliminarPlantilla() {
        PlantillaLogic metodoRecuperacionLogic = new PlantillaLogic();
        objetoPlantilla.setEstadoPlantilla("E");
        metodoRecuperacionLogic.actualizarPlantilla(objetoPlantilla);
        eliminarPlantillaLista(objetoPlantilla);
        RequestContext.getCurrentInstance().execute("PF('actualizarPlantilla').hide()");
        nuevoPlantillaObjeto();
        MensajesJSF.muestraMensajes( "actualización de Plantilla de Gestión Documental correcto", "Mensaje");
    }

    /**
     * Método que elimina visualmente un objeto de la lista
     *
     * @param objetoPlantilla
     */
    private void eliminarPlantillaLista(PlantillaEntity objetoPlantilla) {
        Iterator itr = lista.iterator();
        while (itr.hasNext()) {
            PlantillaEntity metodoRecuperacionEntity = (PlantillaEntity) itr.next();
            if (metodoRecuperacionEntity.getIdPlantilla() == objetoPlantilla.getIdPlantilla()) {
                itr.remove();
            }
        }
    }

    /**
     * Método que reinicia el objeto Plantilla de Gestión Documental
     */
    public void nuevoPlantillaObjeto() {
        objetoPlantilla = new PlantillaEntity();
        objetoPlantillaInsercion = new PlantillaEntity();
    }

    /**
     * Método que permite almacenar un archivo
     * @param nombre
     * @param in
     * @throws java.io.FileNotFoundException
     */
    public void alamcenarArchivo(String nombre, InputStream in) throws FileNotFoundException, IOException {
        try {
            //RutasLogic rutasLogic=new RutasLogic();
            //String ruta = rutasLogic.rutasPorTipo("PRUEBA").getCarpetaRutas();
            ResourceBundle rb=ResourceBundle.getBundle("co.com.siscomputo.archivos.RUTAS");
            String ruta=rb.getString("PRUEBA").trim();
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
            objetoPlantillaInsercion.setRutaPlantilla(ruta);
        } catch (IOException iOException) {
            iOException.printStackTrace();
        }
    }
    
    public void limitaExtensiones(){
        extensiones="";
        ExtensionesLogic extensionesLogic=new ExtensionesLogic();
        ArrayList<ExtensionesEntity> listaExte=extensionesLogic.listaExtensiones();
        for(ExtensionesEntity exte:listaExte){
            extensiones+="|"+exte.getTipoExtensiones();
        }
        System.out.println("Extensiones: "+extensiones);
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
