/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.siscomputo.utilidades;

import co.com.siscomputo.endpoint.AccionEntity;
import java.util.Comparator;

/**
 *
 * @author LENOVO
 */
public class ComparadorAccion implements Comparator<AccionEntity>{
    @Override
    public int compare(AccionEntity a1, AccionEntity a2){
        return Integer.parseInt(a2.getOrdenAccion())-Integer.parseInt(a1.getOrdenAccion());
    }
   
}
