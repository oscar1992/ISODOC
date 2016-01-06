
package co.com.siscomputo.endpoint;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "GestionDocumental", targetNamespace = "http://endpoint.siscomputo.com.co/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface GestionDocumental {


    /**
     * 
     * @return
     *     returns co.com.siscomputo.endpoint.ObjetoRetornaEntity
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "listaDocumento", targetNamespace = "http://endpoint.siscomputo.com.co/", className = "co.com.siscomputo.endpoint.ListaDocumento")
    @ResponseWrapper(localName = "listaDocumentoResponse", targetNamespace = "http://endpoint.siscomputo.com.co/", className = "co.com.siscomputo.endpoint.ListaDocumentoResponse")
    @Action(input = "http://endpoint.siscomputo.com.co/GestionDocumental/listaDocumentoRequest", output = "http://endpoint.siscomputo.com.co/GestionDocumental/listaDocumentoResponse")
    public ObjetoRetornaEntity listaDocumento();

    /**
     * 
     * @return
     *     returns co.com.siscomputo.endpoint.ObjetoRetornaEntity
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "listaDocumentoRol", targetNamespace = "http://endpoint.siscomputo.com.co/", className = "co.com.siscomputo.endpoint.ListaDocumentoRol")
    @ResponseWrapper(localName = "listaDocumentoRolResponse", targetNamespace = "http://endpoint.siscomputo.com.co/", className = "co.com.siscomputo.endpoint.ListaDocumentoRolResponse")
    @Action(input = "http://endpoint.siscomputo.com.co/GestionDocumental/listaDocumentoRolRequest", output = "http://endpoint.siscomputo.com.co/GestionDocumental/listaDocumentoRolResponse")
    public ObjetoRetornaEntity listaDocumentoRol();

    /**
     * 
     * @param objeto
     * @return
     *     returns co.com.siscomputo.endpoint.DocumentoRolEntity
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "insertarDocumentoRol", targetNamespace = "http://endpoint.siscomputo.com.co/", className = "co.com.siscomputo.endpoint.InsertarDocumentoRol")
    @ResponseWrapper(localName = "insertarDocumentoRolResponse", targetNamespace = "http://endpoint.siscomputo.com.co/", className = "co.com.siscomputo.endpoint.InsertarDocumentoRolResponse")
    @Action(input = "http://endpoint.siscomputo.com.co/GestionDocumental/insertarDocumentoRolRequest", output = "http://endpoint.siscomputo.com.co/GestionDocumental/insertarDocumentoRolResponse")
    public DocumentoRolEntity insertarDocumentoRol(
        @WebParam(name = "objeto", targetNamespace = "")
        DocumentoRolEntity objeto);

    /**
     * 
     * @param objeto
     * @return
     *     returns co.com.siscomputo.endpoint.DocumentoRolEntity
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "actualizarDocumentoRol", targetNamespace = "http://endpoint.siscomputo.com.co/", className = "co.com.siscomputo.endpoint.ActualizarDocumentoRol")
    @ResponseWrapper(localName = "actualizarDocumentoRolResponse", targetNamespace = "http://endpoint.siscomputo.com.co/", className = "co.com.siscomputo.endpoint.ActualizarDocumentoRolResponse")
    @Action(input = "http://endpoint.siscomputo.com.co/GestionDocumental/actualizarDocumentoRolRequest", output = "http://endpoint.siscomputo.com.co/GestionDocumental/actualizarDocumentoRolResponse")
    public DocumentoRolEntity actualizarDocumentoRol(
        @WebParam(name = "objeto", targetNamespace = "")
        DocumentoRolEntity objeto);

    /**
     * 
     * @param objeto
     * @return
     *     returns co.com.siscomputo.endpoint.DocumentoEntity
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "actualizarDocumento", targetNamespace = "http://endpoint.siscomputo.com.co/", className = "co.com.siscomputo.endpoint.ActualizarDocumento")
    @ResponseWrapper(localName = "actualizarDocumentoResponse", targetNamespace = "http://endpoint.siscomputo.com.co/", className = "co.com.siscomputo.endpoint.ActualizarDocumentoResponse")
    @Action(input = "http://endpoint.siscomputo.com.co/GestionDocumental/actualizarDocumentoRequest", output = "http://endpoint.siscomputo.com.co/GestionDocumental/actualizarDocumentoResponse")
    public DocumentoEntity actualizarDocumento(
        @WebParam(name = "objeto", targetNamespace = "")
        DocumentoEntity objeto);

    /**
     * 
     * @param objeto
     * @return
     *     returns co.com.siscomputo.endpoint.DocumentoEntity
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "insertarDocumento", targetNamespace = "http://endpoint.siscomputo.com.co/", className = "co.com.siscomputo.endpoint.InsertarDocumento")
    @ResponseWrapper(localName = "insertarDocumentoResponse", targetNamespace = "http://endpoint.siscomputo.com.co/", className = "co.com.siscomputo.endpoint.InsertarDocumentoResponse")
    @Action(input = "http://endpoint.siscomputo.com.co/GestionDocumental/insertarDocumentoRequest", output = "http://endpoint.siscomputo.com.co/GestionDocumental/insertarDocumentoResponse")
    public DocumentoEntity insertarDocumento(
        @WebParam(name = "objeto", targetNamespace = "")
        DocumentoEntity objeto);

    /**
     * 
     * @param objeto
     * @return
     *     returns co.com.siscomputo.endpoint.DocumentoProcesoEntity
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "actualizarDocumentoProceso", targetNamespace = "http://endpoint.siscomputo.com.co/", className = "co.com.siscomputo.endpoint.ActualizarDocumentoProceso")
    @ResponseWrapper(localName = "actualizarDocumentoProcesoResponse", targetNamespace = "http://endpoint.siscomputo.com.co/", className = "co.com.siscomputo.endpoint.ActualizarDocumentoProcesoResponse")
    @Action(input = "http://endpoint.siscomputo.com.co/GestionDocumental/actualizarDocumentoProcesoRequest", output = "http://endpoint.siscomputo.com.co/GestionDocumental/actualizarDocumentoProcesoResponse")
    public DocumentoProcesoEntity actualizarDocumentoProceso(
        @WebParam(name = "objeto", targetNamespace = "")
        DocumentoProcesoEntity objeto);

    /**
     * 
     * @param objeto
     * @return
     *     returns co.com.siscomputo.endpoint.DocumentoProcesoEntity
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "insertarDocumentoProceso", targetNamespace = "http://endpoint.siscomputo.com.co/", className = "co.com.siscomputo.endpoint.InsertarDocumentoProceso")
    @ResponseWrapper(localName = "insertarDocumentoProcesoResponse", targetNamespace = "http://endpoint.siscomputo.com.co/", className = "co.com.siscomputo.endpoint.InsertarDocumentoProcesoResponse")
    @Action(input = "http://endpoint.siscomputo.com.co/GestionDocumental/insertarDocumentoProcesoRequest", output = "http://endpoint.siscomputo.com.co/GestionDocumental/insertarDocumentoProcesoResponse")
    public DocumentoProcesoEntity insertarDocumentoProceso(
        @WebParam(name = "objeto", targetNamespace = "")
        DocumentoProcesoEntity objeto);

    /**
     * 
     * @return
     *     returns co.com.siscomputo.endpoint.ObjetoRetornaEntity
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "listaDocumentoProceso", targetNamespace = "http://endpoint.siscomputo.com.co/", className = "co.com.siscomputo.endpoint.ListaDocumentoProceso")
    @ResponseWrapper(localName = "listaDocumentoProcesoResponse", targetNamespace = "http://endpoint.siscomputo.com.co/", className = "co.com.siscomputo.endpoint.ListaDocumentoProcesoResponse")
    @Action(input = "http://endpoint.siscomputo.com.co/GestionDocumental/listaDocumentoProcesoRequest", output = "http://endpoint.siscomputo.com.co/GestionDocumental/listaDocumentoProcesoResponse")
    public ObjetoRetornaEntity listaDocumentoProceso();

    /**
     * 
     * @param accionE
     * @return
     *     returns co.com.siscomputo.endpoint.ObjetoRetornaEntity
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "listaDocumentoPorAccion", targetNamespace = "http://endpoint.siscomputo.com.co/", className = "co.com.siscomputo.endpoint.ListaDocumentoPorAccion")
    @ResponseWrapper(localName = "listaDocumentoPorAccionResponse", targetNamespace = "http://endpoint.siscomputo.com.co/", className = "co.com.siscomputo.endpoint.ListaDocumentoPorAccionResponse")
    @Action(input = "http://endpoint.siscomputo.com.co/GestionDocumental/listaDocumentoPorAccionRequest", output = "http://endpoint.siscomputo.com.co/GestionDocumental/listaDocumentoPorAccionResponse")
    public ObjetoRetornaEntity listaDocumentoPorAccion(
        @WebParam(name = "AccionE", targetNamespace = "")
        AccionEntity accionE);

}
