package aplicacion.modelo.dominio;

import java.io.Serializable;

/**
 * Clase Producto contiene los atributos que tendra cada producto registrado
 * @author Full Stackers
 */

public class Producto implements Serializable{
    private Integer codigo;
    //codigo: representa el codigo unico de cada producto
    private String nombreProducto;
    //nombreProducto: representa el producto
    private String sector;
    //sector: nombre que representa un conjunto de productos que comparten las mismas caracteristicas
    private Float precio;
    //precio: representa el precio de venta del producto al publico
    private Integer stock;
    //stock: representa la cantidad dispronible del producto 
    private String marca;
    //marca: representa la marca del producto
    private Boolean prodOferta = false;
    //prodOferta: representa si un producto esta en oferta o no 
    private String dimension;
    //dimencion: representa las medidas del producto 
    private String imagen;
    //imagen: representa el nombre de la imagen
    private Float precioOferta;
    
    //CONSTRUCTORES
    /**
     * constructor sin parametros
     */
    public Producto() {
        
    }
    /**
     * 
     * @param codigo
     * @param nombreProducto
     * @param sector
     * @param precio
     * @param stock
     * @param marca
     * @param dimension
     * @param imagen
     * @param precioOferta 
     */
    public Producto(String nombreProducto, String sector, Float precio, Integer stock, String marca, String dimension, String imagen, Float precioOferta) {   
        this.nombreProducto = nombreProducto;
        this.sector = sector;
        this.precio = precio;
        this.stock = stock;
        this.marca = marca;
        this.dimension = dimension;
        this.imagen = imagen;
        this.precioOferta = precioOferta;
    }

    

   

    /**
     * @return the codigo
     */
    public Integer getCodigo() {
        return codigo;
    }

    /**
     * @return the dimension
     */
    public String getDimension() {
        return dimension;
    }

    /**
     * @return the imagen
     */
    public String getImagen() {
        return imagen;
    }

    /**
     * @return the marca
     */
    public String getMarca() {
        return marca;
    }

    /**
     * @return the nombreProducto
     */
    public String getNombreProducto() {
        return nombreProducto;
    }

    /**
     * @return the precio
     */
    public Float getPrecio() {
        return precio;
    }

    /**
     * @return the precioOferta
     */
    public Float getPrecioOferta() {
        return precioOferta;
    }

    /**
     * @return the prodOferta
     */
    public Boolean getProdOferta() {
        return prodOferta;
    }

    /**
     * @return the sector
     */
    public String getSector() {
        return sector;
    }

    /**
     * @return the stock
     */
    public Integer getStock() {
        return stock;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    /**
     * @param dimension the dimension to set
     */
    public void setDimension(String dimension) {
        this.dimension = dimension;
    }

    /**
     * @param imagen the imagen to set
     */
    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    /**
     * @param marca the marca to set
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * @param nombreProducto the nombreProducto to set
     */
    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    /**
     * @param precio the precio to set
     */
    public void setPrecio(Float precio) {
        this.precio = precio;
    }

    /**
     * @param precioOferta the precioOferta to set
     */
    public void setPrecioOferta(Float precioOferta) {
        this.precioOferta = precioOferta;
    }

    /**
     * @param prodOferta the prodOferta to set
     */
    public void setProdOferta(Boolean prodOferta) {
        this.prodOferta = prodOferta;
    }

    /**
     * @param sector the sector to set
     */
    public void setSector(String sector) {
        this.sector = sector;
    }

    /**
     * @param stock the stock to set
     */
    public void setStock(Integer stock) {
        this.stock = stock;
    }
     @Override
    public String toString() {
        return "Codigo del Producto: "+getCodigo()+"Nombre del producto: "+getNombreProducto()+"Precio del Producto: "+getPrecio()+
                "Stock del Producto: "+getStock()+"Sector del Producto: "+getSector()+"Dimension del Producto: "+getDimension()+"Marca del Producto: "+getMarca()+
                "Producto en Oferta: "+getProdOferta()+"Direccion de Imagen: "+getImagen()+"Precio del producto en Oferta"+getPrecioOferta();
    }
}
