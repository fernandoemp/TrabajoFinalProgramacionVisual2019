package aplicacion.hibernate.dao.imp;

import aplicacion.hibernate.configuracion.HibernateUtil;
import aplicacion.hibernate.dao.IRolDAO;
import aplicacion.modelo.dominio.Rol;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 * Representa la impliementacion de la interface IRolDAO.
 * @author Elias Acosta
 */
public class RolDAOImp implements Serializable, IRolDAO{
//Implementacion de metodos abstractos.
    @Override
    public void agregarRol(Rol rol) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(rol);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void modificarRol(Rol rol) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(rol);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void eliminarRol(Rol rol) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(rol);
        session.getTransaction().commit();
        session.close();
    }
    
    @Override
    public Rol obtenerRol(String rol) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Rol.class);
        criteria.add(Restrictions.like("tipoRol", rol));
     
        Rol rolBuscado = null;
        if (!criteria.list().isEmpty()) {
            rolBuscado = (Rol) criteria.list().get(0);
        }
        session.close();
        return rolBuscado;
    }
    @Override
    public List<Rol> obtenerRoles() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Rol.class);
        List<Rol> roles = criteria.list();
        session.close();
        return roles;
    }

    
    
}
