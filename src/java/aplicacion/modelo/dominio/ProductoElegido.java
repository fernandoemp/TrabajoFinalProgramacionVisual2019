package aplicacion.modelo.dominio;

import java.io.Serializable;

/**
 * Representa a un producto reservado en un carrito
 * @author Windows
 */
public class ProductoElegido implements Serializable{
    private Integer codigoProductoElegido;
    private Producto productoElegido;
    private Integer cantidadReservada;
    private Double precioTotal;
    private Double subtotal;
    private Carrito carrito;
    

    public ProductoElegido() {
        productoElegido = new Producto();
        carrito = new Carrito();
    }
    
    /**
     * 
     * @param productoElegido producto en el carrito
     * @param cantidadReservada cantidad de ese producto
     * @param precioTotal 
     * @param subtotal
     * @param carrito carrito al que pertenece
     */
    public ProductoElegido(Producto productoElegido, Integer cantidadReservada, Double precioTotal, Double subtotal, Carrito carrito) {
        this.productoElegido = productoElegido;
        this.cantidadReservada = cantidadReservada;
        this.precioTotal = precioTotal;
        this.subtotal = subtotal;
        this.carrito = carrito;
    }

    //GETTERS Y SETTERS

    public Integer getCodigoProductoElegido() {
        return codigoProductoElegido;
    }

    public void setCodigoProductoElegido(Integer codigoProductoElegido) {
        this.codigoProductoElegido = codigoProductoElegido;
    }
    
    public Producto getProductoElegido() {
        return productoElegido;
    }

    public void setProductoElegido(Producto productoElegido) {
        this.productoElegido = productoElegido;
    }
    
    public Integer getCantidadReservada() {
        return cantidadReservada;
    }

    public void setCantidadReservada(Integer cantidadReservada) {
        this.cantidadReservada = cantidadReservada;
    }

    public Double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(Double precioTotal) {
        this.precioTotal = precioTotal;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }    

    public Carrito getCarrito() {
        return carrito;
    }

    public void setCarrito(Carrito carrito) {
        this.carrito = carrito;
    }

    @Override
    public String toString() {
        return "ProductoElegido{" + "productoElegido=" + productoElegido + ", cantidadReservada=" + cantidadReservada + ", precioTotal=" + precioTotal + ", subtotal=" + subtotal + '}';
    }
    
}
