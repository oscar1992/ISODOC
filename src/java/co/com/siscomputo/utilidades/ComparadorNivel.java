/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.siscomputo.utilidades;

import co.com.siscomputo.endpoint.NivelEntity;
import java.util.Comparator;

/**
 *
 * @author LENOVO
 */
public class ComparadorNivel implements Comparator<NivelEntity>{

    @Override
    public int compare(NivelEntity o1, NivelEntity o2) {
        return o1.getSecuenciaNivel()-o2.getSecuenciaNivel();
    }
    
}
