/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.siscomputo.administracion.logic;

import co.com.siscomputo.endpoint.SedeEntity;
import co.com.siscomputo.endpoint.Usuario;
import co.com.siscomputo.endpoint.Usuario_Service;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author LENOVO
 */
@ManagedBean(name = "SedesLogic")
@ViewScoped
public class SedesLogic {
    private Usuario_Service webService;
    private Usuario port;
    private List sedes;
    private SedeEntity sedeObjeto;
    
    /**
     * Funcion con la cual inicializo el service y el port de los WebServices
     */
    public void webService() {
        webService = new Usuario_Service();
        port = webService.getUsuarioPort();
    }

    public SedesLogic() {
        init();
    }
    
    public void init(){
        webService();
        sedes=(List)port.listaSede().getRetorna();
    }

    public List getSedes() {
        return sedes;
    }

    public void setSedes(List sedes) {
        this.sedes = sedes;
    }

    public SedeEntity getSedeObjeto() {
        return sedeObjeto;
    }

    public void setSedeObjeto(SedeEntity sedeObjeto) {
        this.sedeObjeto = sedeObjeto;
    }
    /**
     * Método que trae una única sede filtrad por su ID
     * @param idSede
     * @return 
     */
    public SedeEntity sedePorId(int idSede){
        webService();
        return port.sedePorId(idSede);
    }
    
    public ArrayList<SedeEntity> listaSedes(){
        ArrayList<SedeEntity> lista=new ArrayList<>();
        ArrayList<Object> listaObjeto;
        webService();
        listaObjeto=(ArrayList<Object>)port.listaSede().getRetorna();
        for(Object item:listaObjeto){
            SedeEntity sede=(SedeEntity)item;
            lista.add(sede);
        }
        return lista;
    }
    public SedeEntity ingresaSede(SedeEntity sede){
        webService();
        SedeEntity sedeRta=null;
        try {
            sedeRta=port.ingresaSede(sede);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sedeRta;
    }
    
    public String actualizarSede(SedeEntity sede){
        webService();
        String rta="";
        try {
            if(port.actualizaSede(sede)!=null){
                rta="Ok";
            }else{
                rta="Error";
            }
        } catch (Exception e) {
            e.printStackTrace();
            rta="Exception";
        }
        return rta;
    }
}   
