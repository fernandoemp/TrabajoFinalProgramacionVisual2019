package aplicacion.controlador.beans;

import aplicacion.hibernate.dao.imp.CarritoDAOImp;
import aplicacion.modelo.dominio.Carrito;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import aplicacion.hibernate.dao.ICarritoDAO;

/**
 *
 * @author Elias Acosta
 */
@ManagedBean
@ViewScoped
public class CarritoBean implements Serializable{
    private ICarritoDAO carritoDAO;
    
    public CarritoBean() {
        carritoDAO = new CarritoDAOImp();
    }
    
    //Metodos
    public void agregarCarrito(Carrito carrito){
        carritoDAO.agregarCarrito(carrito);
    }
    
    public void eliminarCarrito(Carrito carrito){
        carritoDAO.eliminarCarrito(carrito);
    }
    
    public void modificarCarrito(Carrito carrito){
        carritoDAO.modificarCarrito(carrito);
    }
    
    public List<Carrito> obtenerCarritos(){
        return carritoDAO.obtenerCarritos();
    }
    
    //Getters y Setters
    public ICarritoDAO getCarritoDAO() {
        return carritoDAO;
    }

    public void setCarritoDAO(ICarritoDAO carritoDAO) {
        this.carritoDAO = carritoDAO;
    }
    
}
