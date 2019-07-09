/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.modelo.dominio;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 *Clase ProductoOferta contiene una lista de Productos en Oferta
 * @author Full Stackers
 */
public class ProductoOferta implements Serializable{
    private String codigoOferta;
    private Byte descuento;
    private Set<Producto> listaProdOferta;
    private Date fechaInicio;
    private Date fechaFinal;
    
    public ProductoOferta() {
        listaProdOferta = new HashSet<>();
        fechaFinal = new Date();
        fechaInicio = new Date();
    }
    
    
    //GETTER AND SETTER
    
    /**
     * @return the listaProdOferta
     */
    public Set<Producto> getListaProdOferta() {
        return listaProdOferta;
    }

    /**
     * @param listaProdOferta the listaProdOferta to set
     */
    public void setListaProdOferta(Set<Producto> listaProdOferta) {
        this.listaProdOferta = listaProdOferta;
    }

    /**
     * @return the codigoOferta
     */
    public String getCodigoOferta() {
        return codigoOferta;
    }

    /**
     * @param codigoOferta the codigoOferta to set
     */
    public void setCodigoOferta(String codigoOferta) {
        this.codigoOferta = codigoOferta;
    }

    /**
     * @return the descuento
     */
    public Byte getDescuento() {
        return descuento;
    }

    /**
     * @param descuento the descuento to set
     */
    public void setDescuento(Byte descuento) {
        this.descuento = descuento;
    }

    /**
     * @return the fechaInicio
     */
    public Date getFechaInicio() {
        return fechaInicio;
    }

    /**
     * @param fechaInicio the fechaInicio to set
     */
    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    /**
     * @return the fechaFinal
     */
    public Date getFechaFinal() {
        return fechaFinal;
    }

    /**
     * @param fechaFinal the fechaFinal to set
     */
    public void setFechaFinal(Date fechaFinal) {
        this.fechaFinal = fechaFinal;
    }
    
    
    
}
