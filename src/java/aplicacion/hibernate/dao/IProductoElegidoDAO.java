/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.hibernate.dao;

import aplicacion.modelo.dominio.ProductoElegido;
import java.util.List;

/**
 *
 * @author Windows
 */
public interface IProductoElegidoDAO {
    
    public void agregarProductoElegido(ProductoElegido productoElegido);
    public void eliminarProductoElegido(ProductoElegido productoElegido);
    public void modificarProductoElegido(ProductoElegido productoElegido);
    public List<ProductoElegido>obtenerProductosElegidos();
}
