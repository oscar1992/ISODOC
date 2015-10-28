/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.siscomputo.administracion.logic;

import co.com.siscomputo.endpoint.AreaEntity;
import co.com.siscomputo.endpoint.EmpresaEntity;
import co.com.siscomputo.endpoint.Usuario;
import co.com.siscomputo.endpoint.Usuario_Service;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;

/**
 *
 * @author LENOVO
 */
public class EmpresaLogic {
    private Usuario_Service webService;
    private Usuario port;
    private List empresas;
    
    /**
     * Funcion con la cual inicializo el service y el port de los WebServices
     */
    public void webService() {
        webService = new Usuario_Service();
        port = webService.getUsuarioPort();
    }

    public EmpresaLogic() {
        init();
    }
    @PostConstruct
    private void init() {
        
    }

    public List getEmpresas() {
        return empresas;
    }

    public void setEmpresas(List empresas) {
        this.empresas = empresas;
    }
    /**
     * Método que trae la lista de Empresas
     * @return 
     */
    public ArrayList<EmpresaEntity> listaEmpresas(){
        ArrayList<EmpresaEntity> lista=new ArrayList<>();
        ArrayList<Object> listaObjeto;
        webService();
        listaObjeto=(ArrayList < Object>)port.listaEmpresa().getRetorna();
        for(Object item:listaObjeto){
            EmpresaEntity empresa=(EmpresaEntity)item;
            lista.add(empresa);
        }
        return lista;
    }
    /**
     * Método que permite ingresar un area
     * @param empresa 
     * @return 
     */
    public EmpresaEntity ingresarEmpresa(EmpresaEntity empresa){
        webService();
        EmpresaEntity emprRta=null;
        try {
            emprRta=port.ingresarEmpresa(empresa);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return emprRta;
    }
    /**
     * Método que actualizae un área
     * @param empresa
     * @return 
     */
    public String actualizarEmpresa(EmpresaEntity empresa){
        webService();
        String rta="";
        try {
            if(port.actualizarEmpresa(empresa)!=null){
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
