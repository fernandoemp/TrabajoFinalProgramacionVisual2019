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
import java.util.Objects;
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
    private Integer cantidadUnidadesPedidas;
    private List<ProductoElegido> productosElegidos;
    private Producto productoPedido;

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
       productoBean.obtenerProductos();

    }

    public void agregarProductoElegido() {
        Usuario usuarioLogueado = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuarioLogueado");
        if (productoPedido.getStock() < getCantidadUnidadesPedidas()) {
            addMessageError("ERROR", "Debe seleccionar/ingresar una cantidad menor o igual al stock disponible");
        } else {
            carritoCreado.setUsuarioCliente(usuarioLogueado);
            carritoCreado.setFechaCarrito(new Date());
            carritoCreado.setEstadoCarrito("Pendiente");

            unProductoElegido.setProductoElegido(productoPedido);
            unProductoElegido.setCantidadReservada(getCantidadUnidadesPedidas());
            unProductoElegido.setCarrito(carritoCreado);
            unProductoElegido.setSubtotal((double) productoPedido.getPrecio() * getCantidadUnidadesPedidas());
            unProductoElegido.setPrecioTotal((double) productoPedido.getPrecio() * getCantidadUnidadesPedidas());

            productosElegidos.add(unProductoElegido);
            productoElegidoBean.agregarProductoElegido(unProductoElegido);
            addMessageInfo(unProductoElegido.getProductoElegido().getNombreProducto(), "fue agregado al carrito!");
            unProductoElegido = new ProductoElegido();
        }
    }

    public void eliminarProductoElegido(ProductoElegido productoElegido) {
        productosElegidos.remove(productoElegido);
    }

    public void finalizarCarrito() {
        for (int i = 0; i < productoBean.obtenerProductos().size(); i++) {
            for (int j = 0; j < productosElegidos.size(); j++) {
                if (Objects.equals(productoBean.obtenerProductos().get(i).getCodigo(), productosElegidos.get(j).getProductoElegido().getCodigo())) {
                    Integer resultado = productoBean.obtenerProductos().get(i).getStock() - productosElegidos.get(j).getCantidadReservada();
                    Producto producto = productoBean.obtenerProductos().get(i);
                    producto.setStock(resultado);
                    productoBean.modificarProducto(producto);
                }
            }
        }
        carritoCreado.setListaProductosElegidos(new HashSet(productosElegidos));
        getCarritoBean().agregarCarrito(carritoCreado);
        getMailBean().enviarMail(carritoCreado.getCodigoCarrito());
        carritoCreado = new Carrito();
        productosElegidos.clear();
        ABMProductoFormBean.listaProductos=productoBean.obtenerProductos();
    }

    public void modificarProductoElegido() {
        productoElegidoBean.modificarProductoElegido(unProductoElegido);
    }

    public List<ProductoElegido> obtenerProductosElegidos() {
        listaProductoElegido = productoElegidoBean.obtenerProductoElegidos();
        return listaProductoElegido;
    }

    //Mensajes
    /**
     * addMessageInfo
     *
     * @param summary permite mostrar el resumen del mensaje informativo
     * @param detail permite mostrar otro mensaje mas detallado
     */
    public void addMessageInfo(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    /**
     * addMessageError
     *
     * @param summary permite mostrar el resumen del mensaje de error
     * @param detail permite mostrar otro mensaje mas detallado
     */
    public void addMessageError(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
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
     * @return the cantidadUnidadesPedidas
     */
    public Integer getCantidadUnidadesPedidas() {
        return cantidadUnidadesPedidas;
    }

    /**
     * @param cantidadUnidadesPedidas the cantidadUnidadesPedidas to set
     */
    public void setCantidadUnidadesPedidas(Integer cantidadUnidadesPedidas) {
        this.cantidadUnidadesPedidas = cantidadUnidadesPedidas;
    }

}
