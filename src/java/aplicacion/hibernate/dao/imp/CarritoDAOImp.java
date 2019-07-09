package aplicacion.hibernate.dao.imp;

import aplicacion.hibernate.configuracion.HibernateUtil;
import aplicacion.modelo.dominio.Carrito;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import aplicacion.hibernate.dao.ICarritoDAO;

/**
 *
 * @author Elias Acosta
 */
public class CarritoDAOImp implements Serializable, ICarritoDAO{

    @Override
    public void agregarCarrito(Carrito carrito) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(carrito);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void modificarCarrito(Carrito carrito) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(carrito);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void eliminarCarrito(Carrito carrito) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(carrito);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<Carrito> obtenerCarritos() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Carrito.class);
        List<Carrito> carritos = criteria.list();
        session.close();
        return carritos;
    }
    
}
