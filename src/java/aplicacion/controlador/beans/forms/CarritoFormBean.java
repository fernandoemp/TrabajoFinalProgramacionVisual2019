package aplicacion.controlador.beans.forms;

import aplicacion.controlador.beans.CarritoBean;
import aplicacion.controlador.beans.ProductoElegidoBean;
import aplicacion.modelo.dominio.Carrito;
import aplicacion.modelo.dominio.ProductoElegido;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
/**
 *
 * @author Elias Acosta
 */
@ManagedBean
@ViewScoped
public class CarritoFormBean implements Serializable{
    private Carrito unCarrito;
    @ManagedProperty(value="#{carritoBean}")
    private CarritoBean carritoBean;
    @ManagedProperty(value="#{productoElegidoBean}")
    private ProductoElegidoBean productoElegidoBean;
    private List<Carrito> carritos;
    private Integer codigoIngresado;
    private Carrito carritoBuscado;
    private String fechaVencimiento;
    private List<ProductoElegido> productosElegidos;
    private Double precioFinal;
    
    public CarritoFormBean() {
        carritos = new ArrayList<>();
        productosElegidos = new ArrayList<>();
    }
    
    @PostConstruct
    public void init(){
        unCarrito = new Carrito();
        setCarritoBuscado(new Carrito());
        obtenerCarritos();
    }
    
    //Metodos CRUD de Carrito.
    public void agregarCarrito(){
        carritoBean.agregarCarrito(unCarrito);
    }
    
    public void eliminarCarrito(){
        getCarritoBean().eliminarCarrito(unCarrito);
    }
    
    public void modificarCarrito(Carrito carrito){
        getCarritoBean().modificarCarrito(carrito);
    }
    
    public void obtenerCarritos(){
        carritos=getCarritoBean().obtenerCarritos();
    }

     public void verificarCarrito(){
         setPrecioFinal(0.00);
         SimpleDateFormat d = new SimpleDateFormat("dd-MM-yy");
        Date fecha = new Date();
        Boolean obtenido = false;
        FacesContext context = FacesContext.getCurrentInstance();
        for(int i = 0; i < carritos.size() && obtenido != true; i++){
            if (carritos.get(i).getCodigoCarrito().equals(getCodigoIngresado())) {
                setCarritoBuscado(carritos.get(i));
                fecha.setHours(fecha.getHours()+24);
                fechaVencimiento = DateFormat.getDateInstance().format(fecha);
                productosElegidos.clear();
                for (int j = 0; j < getProductoElegidoBean().obtenerProductoElegido().size(); j++){
                    if (getProductoElegidoBean().obtenerProductoElegido().get(j).getCarrito().getCodigoCarrito() == codigoIngresado){  
                    productosElegidos.add(getProductoElegidoBean().obtenerProductoElegido().get(j));
                    }
                }
              for (int k = 0; k < productosElegidos.size(); k++){
                    precioFinal = precioFinal + productosElegidos.get(k).getPrecioTotal();
              }
                obtenido = true;
            }   
            }
            if (obtenido == false){
                context.addMessage(null,
                  new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR",
                       "No existe una compra con el codigo especificado"));        
            }
    }   
    public Carrito getUnCarrito() {
        return unCarrito;
    }

    public void setUnCarrito(Carrito unCarrito) {
        this.unCarrito = unCarrito;
    }

    public CarritoBean getCarritoBean() {
        return carritoBean;
    }

    public void setCarritoBean(CarritoBean carritoBean) {
        this.carritoBean = carritoBean;
    }

    public List<Carrito> getCarritos() {
        return carritos;
    }

    public void setCarritos(List<Carrito> carritos) {
        this.carritos = carritos;
    }

    /**
     * @return the codigoIngresado
     */
    public Integer getCodigoIngresado() {
        return codigoIngresado;
    }

    /**
     * @param codigoIngresado the codigoIngresado to set
     */
    public void setCodigoIngresado(Integer codigoIngresado) {
        this.codigoIngresado = codigoIngresado;
    }

    /**
     * @return the carritoBuscado
     */
    public Carrito getCarritoBuscado() {
        return carritoBuscado;
    }

    /**
     * @param carritoBuscado the carritoBuscado to set
     */
    public void setCarritoBuscado(Carrito carritoBuscado) {
        this.carritoBuscado = carritoBuscado;
    }

    /**
     * @return the fechaVencimiento
     */
    public String getFechaVencimiento() {
        return fechaVencimiento;
    }

    /**
     * @param fechaVencimiento the fechaVencimiento to set
     */
    public void setFechaVencimiento(String fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    /**
     * @return the productosElegidos
     */
    public List<ProductoElegido> getProductosElegidos() {
        return productosElegidos;
    }

    /**
     * @param productosElegidos the productosElegidos to set
     */
    public void setProductosElegidos(List<ProductoElegido> productosElegidos) {
        this.productosElegidos = productosElegidos;
    }

    /**
     * @return the productoElegidoBean
     */
    public ProductoElegidoBean getProductoElegidoBean() {
        return productoElegidoBean;
    }

    /**
     * @param productoElegidoBean the productoElegidoBean to set
     */
    public void setProductoElegidoBean(ProductoElegidoBean productoElegidoBean) {
        this.productoElegidoBean = productoElegidoBean;
    }

    /**
     * @return the precioFinal
     */
    public Double getPrecioFinal() {
        return precioFinal;
    }

    /**
     * @param precioFinal the precioFinal to set
     */
    public void setPrecioFinal(Double precioFinal) {
        this.precioFinal = precioFinal;
    }
    
}
