/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.controlador.beans;

import aplicacion.hibernate.dao.IProductoDAO;
import aplicacion.hibernate.dao.imp.ProductoDAOImp;
import aplicacion.modelo.dominio.Producto;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 * 
 * @author FullStackers
 */
@ManagedBean
@ViewScoped
public class ProductoBean implements Serializable{
     private IProductoDAO productoDAO;

    public ProductoBean() {
        productoDAO = new ProductoDAOImp();
    }
    
    public void agregarProducto(Producto nuevo){
        productoDAO.agregarProducto(nuevo);
    }
    
    
    public void modificarProducto(Producto modificado){
        productoDAO.modificarProducto(modificado);
    }
    
    public void eliminarProducto(Producto borrado){
       productoDAO.eliminarProducto(borrado);
    }
    
    public List<Producto> obtenerProductos(){
        return productoDAO.obtenerProductos();
    }

    /**
     * @return the productoDAO
     */
    public IProductoDAO getProductoDAO() {
        return productoDAO;
    }

    /**
     * @param productoDAO the productoDAO to set
     */
    public void setProductoDAO(IProductoDAO productoDAO) {
        this.productoDAO = productoDAO;
    }
       
    
}
