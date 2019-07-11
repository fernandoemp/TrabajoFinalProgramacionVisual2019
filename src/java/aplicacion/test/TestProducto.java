/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.test;

import aplicacion.hibernate.dao.IProductoDAO;
import aplicacion.hibernate.dao.imp.ProductoDAOImp;
import aplicacion.modelo.dominio.Producto;

/**
 *
 * @author jack
 */
public class TestProducto {
    public static void main(String[] args) {
        IProductoDAO productoDAO = new ProductoDAOImp();
        //Producto nuevo = new Producto();
        Producto nuevo1 = new Producto();
        Producto nuevo2 = new Producto();
        
        /*nuevo.setDimension("25x35");
        nuevo.setImagen("test");
        nuevo.setMarca("lego");
        nuevo.setNombreProducto("lego");
        nuevo.setSector("5-10");
        nuevo.setPrecio(Float.parseFloat("344"));
        nuevo.setStock(Short.parseShort("344"));
        nuevo.setPrecioOferta(Float.parseFloat("45"));
        nuevo.setProdOferta(Boolean.TRUE);*/
        nuevo1.setNombreProducto("auto");
        nuevo1.setDimension("25x35");
        nuevo1.setImagen("test");
        nuevo1.setMarca("toys");
        nuevo1.setSector("5-10");
        nuevo1.setPrecio(Float.parseFloat("344"));
        nuevo1.setStock(12);
        nuevo1.setPrecioOferta(Float.parseFloat("45"));
        nuevo2.setDimension("25x35");
        nuevo2.setImagen("test");
        nuevo2.setMarca("lego");
        nuevo2.setNombreProducto("muñeco");
        nuevo2.setSector("5-10");
        nuevo2.setPrecio(Float.parseFloat("344"));
        nuevo2.setStock(15);
        nuevo2.setPrecioOferta(Float.parseFloat("45"));
        productoDAO.agregarProducto(nuevo1);
        productoDAO.agregarProducto(nuevo2);
        
        
        //productoDAO.eliminarProducto(nuevo);
    }
}
