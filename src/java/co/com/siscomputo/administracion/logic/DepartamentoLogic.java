/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.siscomputo.administracion.logic;

import co.com.siscomputo.endpoint.DepartamentoEntity;
import co.com.siscomputo.endpoint.Usuario;
import co.com.siscomputo.endpoint.Usuario_Service;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public class DepartamentoLogic {
    private Usuario_Service webService;
    private Usuario port;
    private List departamentos;
    
    /**
     * Funcion con la cual inicializo el service y el port de los WebServices
     */
    public void webService() {
        webService = new Usuario_Service();
        port = webService.getUsuarioPort();
    }

    public List getDepartamentos() {
        return departamentos;
    }

    public void setDepartamentos(List departamentos) {
        this.departamentos = departamentos;
    }
    /**
     * Método que trae la lista de Departtamentos
     * @return 
     */
    public ArrayList<DepartamentoEntity> listaDepartamentos(){
        ArrayList<DepartamentoEntity> lista=new ArrayList<>();
        ArrayList<Object> listaobjeto;
        webService();
        listaobjeto=(ArrayList<Object>)port.listaDepartameno().getRetorna();
        for(Object item:listaobjeto){
            DepartamentoEntity departamentoEntity=(DepartamentoEntity)item;
            lista.add(departamentoEntity);
        }
        return lista;
    }
    /**
     * Método que permite ingresar un Departamento
     * @param departamentoEntity
     * @return 
     */
    public DepartamentoEntity ingresaDepartameto(DepartamentoEntity departamentoEntity){
        webService();
        DepartamentoEntity deptRta=null;
        try {
            deptRta=port.insertarDepartameno(departamentoEntity);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return deptRta;
    }
    
    public String actualizarDepartamento(DepartamentoEntity departamentoEntity){
        webService();
        String rta="";
        try {
            if(port.actualizarDepartameno(departamentoEntity)!=null){
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
    /**
     * Método que trae un solo departamento por ID
     * @param idDepto
     * @return 
     */
    public DepartamentoEntity deptoPorID(int idDepto){
        webService();
        return port.deptoPorId(idDepto);
    }
}
