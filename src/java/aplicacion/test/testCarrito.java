package aplicacion.test;

import aplicacion.hibernate.dao.IProductoElegidoDAO;
import aplicacion.hibernate.dao.IProductoDAO;
import aplicacion.hibernate.dao.IRolDAO;
import aplicacion.hibernate.dao.IUsuarioDAO;
import aplicacion.hibernate.dao.imp.ProductoElegidoDAOImp;
import aplicacion.hibernate.dao.imp.ProductoDAOImp;
import aplicacion.hibernate.dao.imp.RolDAOImp;
import aplicacion.hibernate.dao.imp.UsuarioDAOImp;
import aplicacion.modelo.dominio.Carrito;
import aplicacion.modelo.dominio.ProductoElegido;
import aplicacion.modelo.dominio.Producto;
import aplicacion.modelo.dominio.Rol;
import aplicacion.modelo.dominio.Usuario;
import java.util.Date;

/**
 *
 * @author Elias Acosta
 */
public class testCarrito {

    public static void main(String[] args) {
        Rol rolAdministrador = new Rol("Administrador", "Administra los productos");
        Rol rolConsumidor = new Rol("Consumidor", "Puede comprar productos");
        IRolDAO rolDAO = new RolDAOImp();
        rolDAO.agregarRol(rolAdministrador);
        rolDAO.agregarRol(rolConsumidor);
        Usuario usuario1 = new Usuario("Natalia", "Zerpa", (byte)12, 34, "nati@nati.com", "Nati615", "activa", rolAdministrador);
        Usuario usuario2 = new Usuario("Ramon", "Alvarez", (byte)32, 54, "ramon@ramon.com", "Ramon615", "activa", rolConsumidor);
        
        IUsuarioDAO usuarioDAO = new UsuarioDAOImp();
        usuarioDAO.crearUsuario(usuario1);
        usuarioDAO.crearUsuario(usuario2);
        
         Producto producto1 = new Producto("test", "test", Float.parseFloat("123"), 12, "asd", "sd", "Habilitada", Float.parseFloat("121"));
         Producto producto2 = new Producto("juguete", "muñecos", (float)34.5, 15, "toys", "sdf", "Habilitada", (float)65.3);
         IProductoDAO productoDAO=new ProductoDAOImp();
         productoDAO.agregarProducto(producto1);
         productoDAO.agregarProducto(producto2);
         
         Date fechaCarrito1 = new Date();
         Carrito carrito1 = new Carrito();
         carrito1.setUsuarioCliente(usuario1);
         carrito1.setFechaCarrito(fechaCarrito1);
         carrito1.setEstadoCarrito("ok");
         
         Date fechaCarrito2 = new Date();
         Carrito carrito2 = new Carrito();
         carrito2.setUsuarioCliente(usuario2);
         carrito2.setFechaCarrito(fechaCarrito2);
         carrito2.setEstadoCarrito("okey");
         
         ProductoElegido prodElegido1 = new ProductoElegido();
         prodElegido1.setProductoElegido(producto1);
         prodElegido1.setCantidadReservada(45);
         prodElegido1.setSubtotal(77.7);
         prodElegido1.setPrecioTotal(900.45);
         prodElegido1.setCarrito(carrito1);
         
         ProductoElegido prodElegido2 = new ProductoElegido();
         prodElegido2.setProductoElegido(producto2);
         prodElegido2.setCantidadReservada(135);
         prodElegido2.setSubtotal(45.12);
         prodElegido2.setPrecioTotal(2355.45);
         prodElegido2.setCarrito(carrito1);
         
         IProductoElegidoDAO productoElegidoDAO = new ProductoElegidoDAOImp();
         productoElegidoDAO.agregarProductoElegido(prodElegido1);
         productoElegidoDAO.agregarProductoElegido(prodElegido2);
    }
}
