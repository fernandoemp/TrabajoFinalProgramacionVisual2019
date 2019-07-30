package aplicacion.controlador.beans.forms;

import aplicacion.controlador.beans.CarritoBean;
import aplicacion.controlador.beans.MailBean;
import aplicacion.controlador.beans.ProductoBean;
import aplicacion.controlador.beans.ProductoElegidoBean;
import aplicacion.modelo.dominio.Carrito;
import aplicacion.modelo.dominio.Producto;
import aplicacion.modelo.dominio.ProductoElegido;
import aplicacion.modelo.dominio.Usuario;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Windows
 */
@ManagedBean
@ViewScoped
public class ProductoElegidoFormBean implements Serializable {

    @ManagedProperty(value = "#{productoBean}")
    private ProductoBean productoBean;

    @ManagedProperty(value = "#{productoElegidoBean}")
    private ProductoElegidoBean productoElegidoBean;
    @ManagedProperty(value = "#{carritoBean}")
    private CarritoBean carritoBean;
    @ManagedProperty(value = "#{mailBean}")
    private MailBean mailBean;
    private ProductoElegido unProductoElegido;
    private List<ProductoElegido> listaProductoElegido;
    private Carrito carritoCreado;
    private Integer cantidad;
    private List<ProductoElegido> productosElegidos;
    private Producto productoPedido;
    private Integer stockProductoPedido;

    /**
     * Creates a new instance of DetalleProductoFormBean
     */
    public ProductoElegidoFormBean() {
        unProductoElegido = new ProductoElegido();
        carritoCreado = new Carrito();
        productosElegidos = new ArrayList<>();
        productoPedido = new Producto();

    }

    @PostConstruct
    public void init() {

    }

    public void agregarProductoElegido() {
        Usuario usuarioLogueado = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuarioLogueado");
        if (productoPedido.getStock() < cantidad) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR", "Debe seleccionar una cantidad menor o igual al stock disponible"));
        } else {
            carritoCreado.setUsuarioCliente(usuarioLogueado);
            carritoCreado.setFechaCarrito(new Date());
            carritoCreado.setEstadoCarrito("Pendiente");

            unProductoElegido.setCantidadReservada(cantidad);
            unProductoElegido.setCarrito(carritoCreado);
            unProductoElegido.setProductoElegido(productoPedido);
            unProductoElegido.setPrecioTotal((double) productoPedido.getPrecio() * cantidad);
            unProductoElegido.setSubtotal((double) productoPedido.getPrecio() * cantidad);
            productosElegidos.add(unProductoElegido);
            productoElegidoBean.agregarProductoElegido(unProductoElegido);
            unProductoElegido = new ProductoElegido();

        }
    }

    public void eliminarProductoElegido(ProductoElegido productoElegido) {
        productosElegidos.remove(productoElegido);
    }

    public void finalizarCarrito() {
        Producto producto = new Producto();
        for (int i = 0; i < productoBean.obtenerProductos().size(); i++) {
            for (int j = 0; j < productosElegidos.size(); j++) {
                if (productoBean.obtenerProductos().get(i).getCodigo() == productosElegidos.get(j).getProductoElegido().getCodigo()) {
//                    System.out.println(productoBean.obtenerProductos().get(i).getCodigo());
//                    System.out.println(productosElegidos.get(j).getProductoElegido().getCodigo());
                    Integer resultado = productoBean.obtenerProductos().get(i).getStock() - productosElegidos.get(j).getCantidadReservada();
//                    System.out.println(resultado);
                    producto = productoBean.obtenerProductos().get(i);
                    producto.setStock(resultado);
                    productoBean.modificarProducto(producto);
//                    System.out.println(producto);
//                    System.out.println("Stock " + productoBean.obtenerProductos().get(i).getStock());

                }
            }
        }
        carritoCreado.setListaProductosElegidos(new HashSet(productosElegidos));
//      System.out.println(carritoCreado);
        getCarritoBean().agregarCarrito(carritoCreado);
        getMailBean().enviarMail(carritoCreado.getCodigoCarrito());
        carritoCreado = new Carrito();
        productosElegidos.clear();
    }

    public void modificarProductoElegido() {
        productoElegidoBean.modificarProductoElegido(unProductoElegido);
    }

    public List<ProductoElegido> obtenerProductosElegidos() {
        listaProductoElegido = productoElegidoBean.obtenerProductoElegido();
        return listaProductoElegido;
    }

    /**
     * @return the cantidad
     */
    public Integer getCantidad() {
        return cantidad;
    }

    /**
     * @param cantidad the cantidad to set
     */
    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * @return the unProductoElegido
     */
    public ProductoElegido getUnProductoElegido() {
        return unProductoElegido;
    }

    /**
     * @param unProductoElegido the unProductoElegido to set
     */
    public void setUnProductoElegido(ProductoElegido unProductoElegido) {
        this.unProductoElegido = unProductoElegido;
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
     * @return the listaProductoElegido
     */
    public List<ProductoElegido> getListaProductoElegido() {
        return listaProductoElegido;
    }

    /**
     * @param listaProductoElegido the listaProductoElegido to set
     */
    public void setListaProductoElegido(List<ProductoElegido> listaProductoElegido) {
        this.listaProductoElegido = listaProductoElegido;
    }

    /**
     * @return the carritoCreado
     */
    public Carrito getCarritoCreado() {
        return carritoCreado;
    }

    /**
     * @param carritoCreado the carritoCreado to set
     */
    public void setCarritoCreado(Carrito carritoCreado) {
        this.carritoCreado = carritoCreado;
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
     * @return the productoPedido
     */
    public Producto getProductoPedido() {
        return productoPedido;
    }

    /**
     * @param productoPedido the productoPedido to set
     */
    public void setProductoPedido(Producto productoPedido) {
        this.productoPedido = productoPedido;
        stockProductoPedido = productoPedido.getStock();
//        System.out.println("test stock:" + stockProductoPedido);
    }

    /**
     * @return the carritoBean
     */
    public CarritoBean getCarritoBean() {
        return carritoBean;
    }

    /**
     * @param carritoBean the carritoBean to set
     */
    public void setCarritoBean(CarritoBean carritoBean) {
        this.carritoBean = carritoBean;
    }

    /**
     * @return the mailBean
     */
    public MailBean getMailBean() {
        return mailBean;
    }

    /**
     * @param mailBean the mailBean to set
     */
    public void setMailBean(MailBean mailBean) {
        this.mailBean = mailBean;
    }

    /**
     * @return the productoBean
     */
    public ProductoBean getProductoBean() {
        return productoBean;
    }

    /**
     * @param productoBean the productoBean to set
     */
    public void setProductoBean(ProductoBean productoBean) {
        this.productoBean = productoBean;
    }

    /**
     * @return the stockProductoPedido
     */
    public Integer getStockProductoPedido() {
        return stockProductoPedido;
    }

    /**
     * @param stockProductoPedido the stockProductoPedido to set
     */
    public void setStockProductoPedido(Integer stockProductoPedido) {
        this.stockProductoPedido = stockProductoPedido;
    }

}
