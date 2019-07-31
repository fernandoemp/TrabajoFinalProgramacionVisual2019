package aplicacion.controlador.beans;

import aplicacion.modelo.dominio.ProductoElegido;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import aplicacion.hibernate.dao.IProductoElegidoDAO;
import aplicacion.hibernate.dao.imp.ProductoElegidoDAOImp;

/**
 *
 * @author Windows
 */
@ManagedBean
@ViewScoped
public class ProductoElegidoBean implements Serializable{
    
    private IProductoElegidoDAO productoElegidoDAO;

    public ProductoElegidoBean() {
        productoElegidoDAO =  new ProductoElegidoDAOImp();
    }
    
    public void agregarProductoElegido(ProductoElegido productoElegido){
        productoElegidoDAO.agregarProductoElegido(productoElegido);
    }
    
    public void eliminarProductoElegido(ProductoElegido productoElegido){
        productoElegidoDAO.eliminarProductoElegido(productoElegido);
    }
    
    public void modificarProductoElegido(ProductoElegido productoElegido){
        productoElegidoDAO.modificarProductoElegido(productoElegido);
    }
    
    public List<ProductoElegido> obtenerProductoElegidos(){
        return productoElegidoDAO.obtenerProductosElegidos();
    }

    public IProductoElegidoDAO getProductoElegidoDAO() {
        return productoElegidoDAO;
    }

    public void setProductoElegidoDAO(IProductoElegidoDAO productoElegidoDAO) {
        this.productoElegidoDAO = productoElegidoDAO;
    }
    
}
