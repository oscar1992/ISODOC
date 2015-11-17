/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.siscomputo.administracion.converter;

import co.com.siscomputo.endpoint.ListaAsignaPermisosPermiso;
import co.com.siscomputo.endpoint.PermisosEntity;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author LENOVO
 */
@FacesConverter("converterPermisosDisponibles")
public class ConverterPermisosDisponibles implements Converter{

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        System.out.println("Paso por aqui " + string );
        return "1";
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object object) {
        System.out.println("CONVERTER");
        if(object != null){
            String valor=""+object;
            //PermisosEntity permisos=(PermisosEntity) object;
            //String valor = ""+permisos.getIdPermiso();
            //System.out.println("Paso por aqui 2: " + permisos.getNombrePermiso());
            return valor;
        }else{
            return null;
        }        
    }
    
}
