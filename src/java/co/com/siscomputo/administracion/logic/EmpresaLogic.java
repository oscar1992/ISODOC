/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.siscomputo.administracion.logic;

import co.com.siscomputo.endpoint.EmpresaEntity;
import co.com.siscomputo.endpoint.Usuario;
import co.com.siscomputo.endpoint.Usuario_Service;
import co.com.siscomputo.utilidades.IurlWebService;
import co.com.siscomputo.utilidades.SingletonDirecciones;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.xml.ws.BindingProvider;

/**
 *
 * @author LENOVO
 */
public class EmpresaLogic implements IurlWebService{

    private List empresas;


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
        
        listaObjeto=(ArrayList < Object>)portUsuario().listaEmpresa().getRetorna();
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
        
        EmpresaEntity emprRta=null;
        try {
            emprRta=portUsuario().ingresarEmpresa(empresa);
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
        
        String rta="";
        try {
            if(portUsuario().actualizarEmpresa(empresa)!=null){
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
