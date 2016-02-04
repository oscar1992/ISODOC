/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.siscomputo.administracion.logic;

import co.com.siscomputo.endpoint.DepartamentoEntity;
import co.com.siscomputo.utilidades.IurlWebService;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public class DepartamentoLogic implements IurlWebService{

    private List departamentos;
    


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
        
        listaobjeto=(ArrayList<Object>)portUsuario().listaDepartameno().getRetorna();
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
        
        DepartamentoEntity deptRta=null;
        try {
            deptRta=portUsuario().insertarDepartameno(departamentoEntity);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return deptRta;
    }
    /**
     * Método que permite actualizar un departamento
     * @param departamentoEntity
     * @return 
     */
    public String actualizarDepartamento(DepartamentoEntity departamentoEntity){
        
        String rta="";
        try {
            if(portUsuario().actualizarDepartameno(departamentoEntity)!=null){
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
        
        return portUsuario().deptoPorId(idDepto);
    }
}
