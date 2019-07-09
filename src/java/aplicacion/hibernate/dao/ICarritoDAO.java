package aplicacion.hibernate.dao;

import aplicacion.modelo.dominio.Carrito;
import java.util.List;

/**
 *
 * @author Elias Acosta
 */
public interface ICarritoDAO {
    public void agregarCarrito(Carrito carrito);
    public void modificarCarrito(Carrito carrito);
    public void eliminarCarrito(Carrito carrito);
    public List<Carrito>obtenerCarritos();
}
