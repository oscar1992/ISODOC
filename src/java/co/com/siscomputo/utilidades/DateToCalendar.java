/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.siscomputo.utilidades;

import java.util.Date;
import java.util.GregorianCalendar;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 *
 * @author LENOVO
 */
public class DateToCalendar {

    public XMLGregorianCalendar convertir(Date fecha) throws DatatypeConfigurationException {
        if (fecha == null) {
            return null;
        } else {
            GregorianCalendar calendar = new GregorianCalendar();
            calendar.setTime(fecha);
            return DatatypeFactory.newInstance().newXMLGregorianCalendar(calendar);
        }
    }

    public Date convertirInverso(XMLGregorianCalendar fecha) {
        Date retorna = new Date();
        retorna = fecha.toGregorianCalendar().getTime();
        return retorna;
    }
}
