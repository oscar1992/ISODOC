/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.siscomputo.administracion.logic;

import co.com.siscomputo.endpoint.SedeEntity;
import co.com.siscomputo.endpoint.Usuario;
import co.com.siscomputo.endpoint.Usuario_Service;
import co.com.siscomputo.utilidades.IurlWebService;
import co.com.siscomputo.utilidades.SingletonDirecciones;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.xml.ws.BindingProvider;

/**
 *
 * @author LENOVO
 */
@ManagedBean(name = "SedesLogic")
@ViewScoped
public class SedesLogic implements IurlWebService{

    private List sedes;
    private SedeEntity sedeObjeto;
    


    public SedesLogic() {
        init();
    }
    
    public void init(){
        
        sedes=(List)portUsuario().listaSede().getRetorna();
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
        
        return portUsuario().sedePorId(idSede);
    }
    /**
     * Método que trae la lista de Sedes
     * @return 
     */
    public ArrayList<SedeEntity> listaSedes(){
        ArrayList<SedeEntity> lista=new ArrayList<>();
        ArrayList<Object> listaObjeto;
        
        listaObjeto=(ArrayList<Object>)portUsuario().listaSede().getRetorna();
        for(Object item:listaObjeto){
            SedeEntity sede=(SedeEntity)item;
            lista.add(sede);
        }
        return lista;
    }
    /**
     * Método que permite ingresar una Sede
     * @param sede
     * @return 
     */
    public SedeEntity ingresaSede(SedeEntity sede){
        
        SedeEntity sedeRta=null;
        try {
            sedeRta=portUsuario().ingresaSede(sede);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sedeRta;
    }
    /**
     * Método que actualizae una sede
     * @param sede
     * @return 
     */
    public String actualizarSede(SedeEntity sede){
        
        String rta="";
        try {
            if(portUsuario().actualizaSede(sede)!=null){
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
