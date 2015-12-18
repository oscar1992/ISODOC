package co.com.siscomputo.administracion.logic;

import co.com.siscomputo.endpoint.AccionEntity;
import co.com.siscomputo.endpoint.Administacion;
import co.com.siscomputo.endpoint.Administacion_Service;
import co.com.siscomputo.endpoint.GrupoProcesoEntity;
import co.com.siscomputo.endpoint.GrupoUsuariosEntity;
import co.com.siscomputo.endpoint.ObjetoRetornaEntity;
import co.com.siscomputo.endpoint.ProcesoEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public class GrupoProcesoLogic {

    private Administacion_Service webService;
    private Administacion port;
    private List grupoProceso;

    /**
     * Funcion con la cual inicializo el service y el port de los WebServices
     */
    public void webService() {
        webService = new Administacion_Service();
        port = webService.getAdministacionPort();
    }

    public List getGrupoProceso() {
        return grupoProceso;
    }

    public void setGrupoProceso(List grupoProceso) {
        this.grupoProceso = grupoProceso;
    }

    /**
     * Método que trae una lista de Grupo de Usuarios y Procesos
     *
     * @return
     */
    public ArrayList<ProcesoEntity> listaGrupoProceso(int idGrupo) {
        webService();
        ArrayList<ProcesoEntity> listaaux = new ArrayList<>();
        ArrayList<Object> listaObjeto = (ArrayList<Object>) port.listaGrupoProceso(idGrupo).getRetorna();
        for (Object obj : listaObjeto) {
            ProcesoEntity objectProceso = (ProcesoEntity) obj;
            listaaux.add(objectProceso);
        }
        return listaaux;
    }
    /**
     * Método que trae una lista de Grupo de Usuarios y Procesos
     *
     * @return
     */
    public ArrayList<GrupoProcesoEntity> listaGrupoProcesoAccion(int idGrupo, int idProceso) {
        webService();
        ArrayList<GrupoProcesoEntity> listaaux = new ArrayList<>();
        ArrayList<Object> listaObjeto = (ArrayList<Object>) port.listaGrupoProcesoAccion(idGrupo, idProceso).getRetorna();
        for (Object obj : listaObjeto) {
            GrupoProcesoEntity objectProceso = (GrupoProcesoEntity) obj;
            listaaux.add(objectProceso);
        }
        return listaaux;
    }

    /**
     * Método que permite ingresar un Grupo de Usuarios y Procesosnuevo
     *
     * @param objeto
     * @return
     */
    public ObjetoRetornaEntity insertarGrupoProceso(GrupoUsuariosEntity grupoUsuarios, String procesoEntity, ArrayList<String> listaAcciones) {
        webService();
        ObjetoRetornaEntity dispoRta = null;
        ProcesoLogic procesoLogic=new ProcesoLogic();
        ArrayList<ProcesoEntity> listaProceso=procesoLogic.listaProceso();
        ProcesoEntity procesoEntitySelecionado=new ProcesoEntity();
        for(ProcesoEntity proceso:listaProceso){
            if(procesoEntity.equals(proceso.getNombreProceso())){
                
                procesoEntitySelecionado=proceso;
            }
        }
        AccionLogic accionLogic=new AccionLogic();
        ArrayList<AccionEntity>listaAccionesWS=accionLogic.listaAccion();
        ArrayList<AccionEntity>listaAccionesEnvia=new ArrayList<>();
        for(AccionEntity accion:listaAccionesWS){
            for(String nombre:listaAcciones){
                if(nombre.equals(accion.getNombreAccion())){
          
                    listaAccionesEnvia.add(accion);
                }
            }
        }
        GrupoProcesoEntity objeto=new GrupoProcesoEntity();
        ArrayList<GrupoProcesoEntity>listaGuarda=new ArrayList<>();
        for(AccionEntity accion:listaAccionesEnvia){
            objeto.setGrupoUsuarioProceso(grupoUsuarios);
            objeto.setProcesoGrupoProceso(procesoEntitySelecionado);
            objeto.setAccionGrupoProceso(accion);
            //System.out.println("ACC: "+objeto.getAccionGrupoProceso().getNombreAccion());
            listaGuarda.add(objeto);
            objeto=new GrupoProcesoEntity();
        }
        for(GrupoProcesoEntity grupoP:listaGuarda){
            System.out.println("ACCI: "+grupoP.getAccionGrupoProceso().getNombreAccion());
        }
        try {
            port.limpiaUsuarioGrupoProceso(grupoUsuarios.getIdGrupoUsuarios(), procesoEntitySelecionado.getIdProceso());
            dispoRta = port.insertarGrupoProceso(listaGuarda);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dispoRta;
    }

    /**
     * Método que permite actualizar un Grupo de Usuarios y Procesos
     *
     * @param metodo
     * @return
     */
    public String actualizarGrupoProceso(GrupoProcesoEntity objeto) {
        webService();
        String rta = "";
        try {
            if (port.actualizarGrupoProceso(objeto) != null) {
                rta = "Ok";
            } else {
                rta = "Error";
            }
        } catch (Exception e) {
            rta = "Error";
            e.printStackTrace();
        }
        return rta;
    }
    
    public ArrayList<GrupoProcesoEntity> listaGruposProcesosPorAccion(int idAccion){
        webService();
        ArrayList<GrupoProcesoEntity> listaaux = new ArrayList<>();
        ArrayList<Object> listaObjeto = (ArrayList<Object>) port.listaGrupoProcesoPorAccion(idAccion).getRetorna();
        for (Object obj : listaObjeto) {
            GrupoProcesoEntity objectProceso = (GrupoProcesoEntity) obj;
            
            listaaux.add(objectProceso);
        }
        return listaaux;
    }
}
