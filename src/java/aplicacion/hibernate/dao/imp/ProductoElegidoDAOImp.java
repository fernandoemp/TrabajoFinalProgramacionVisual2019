package aplicacion.hibernate.dao.imp;

import aplicacion.hibernate.configuracion.HibernateUtil;
import aplicacion.modelo.dominio.ProductoElegido;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import aplicacion.hibernate.dao.IProductoElegidoDAO;

/**
 *
 * @author Windows
 */
public class ProductoElegidoDAOImp implements Serializable, IProductoElegidoDAO{

    @Override
    public void agregarProductoElegido(ProductoElegido productoElegido) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(productoElegido);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void eliminarProductoElegido(ProductoElegido productoElegido) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(productoElegido);
        session.getTransaction().commit();
        session.close();
    }
    
    @Override
    public void modificarProductoElegido(ProductoElegido productoElegido) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(productoElegido);
        session.getTransaction().commit();
        session.close();
    }
    
    @Override
    public List<ProductoElegido> obtenerProductosElegidos() {
       Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(ProductoElegido.class);
        List<ProductoElegido> allProductos = criteria.list();
        session.close();
        return allProductos;
    }
}
