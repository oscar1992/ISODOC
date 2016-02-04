/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.siscomputo.gestiondocumental.logic;

import co.com.siscomputo.endpoint.UsuarioDocumentoEntity;
import co.com.siscomputo.utilidades.IurlWebService;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public class UsuarioDocumentoLogic implements IurlWebService{

    private List usuarioDocumento;
    


    public List getUsuarioDocumento() {
        return usuarioDocumento;
    }

    public void setUsuarioDocumento(List usuarioDocumento) {
        this.usuarioDocumento = usuarioDocumento;
    }
    
    /**
     * Método que trae una lista de Usuarios por Documento
     *
     * @return
     */
    public ArrayList<UsuarioDocumentoEntity> listaUsuarioDocumento() {
        
        ArrayList<UsuarioDocumentoEntity> listaaux = new ArrayList<>();
        ArrayList<Object> listaObjeto = (ArrayList<Object>) portGestion().listaUsuarioDocumento().getRetorna();
        for (Object obj : listaObjeto) {
            UsuarioDocumentoEntity objectgrupoDocumento = (UsuarioDocumentoEntity) obj;
            listaaux.add(objectgrupoDocumento);
        }
        return listaaux;
    }
    /**
     * Método que permite ingresar un Usuarios por Documentonuevo
     *
     * @param objeto
     * @return
     */
    public UsuarioDocumentoEntity insertarUsuarioDocumento(UsuarioDocumentoEntity objeto) {
        UsuarioDocumentoEntity dispoRta = null;
        try {
            
            //System.out.println("OBJETOT: "+objeto.getFecha().toString());
            dispoRta = portGestion().insertarUsuarioDocumento(objeto);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dispoRta;
    }

    /**
     * Método que permite actualizar un Usuarios por Documento
     *
     * @param metodo
     * @return
     */
    public String actualizarUsuarioDocumento(UsuarioDocumentoEntity objeto) {
        
        String rta = "";
        try {
            if (portGestion().actualizarUsuarioDocumento(objeto) != null) {
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
}
