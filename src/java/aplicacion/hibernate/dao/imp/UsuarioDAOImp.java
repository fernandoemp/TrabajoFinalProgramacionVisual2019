/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.hibernate.dao.imp;

import aplicacion.hibernate.dao.IUsuarioDAO;
import aplicacion.hibernate.configuracion.HibernateUtil;
import aplicacion.modelo.dominio.Usuario;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Fernando
 */
/**
 * Clase IusuarioDAOImp
 *
 */
public class UsuarioDAOImp implements Serializable, IUsuarioDAO {

    public UsuarioDAOImp() {

    }

    /**
     * crearUsuario permite crear una nueva cuenta en el sistema
     *
     * @param usuario contiene los datos de la nueva cuenta a ser creada
     */
    @Override
    public void crearUsuario(Usuario usuario) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(usuario);
        session.getTransaction().commit();
        session.close();
    }

    /**
     * eliminarUsuario permite eliminar el usuario que es elegido desde la vista
     *
     * @param usuario contiene los datos del usuario a ser borrado
     */
    @Override
    public void eliminarUsuario(Usuario usuario) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(usuario);
        session.getTransaction().commit();
        session.close();
    }
    /**
     * iniciarSesion permite ingresar al usuario al sistema, mostrando las respectivas parte de la web respecto su  rol
     * @param emailLogin es el string donde se almaceno el email con el que inicia sesion
     * @param passLogin es el string en donde se almacena la contraseña con la cual inicia sesion
     * @return un objeto tipo usuario, con datos o nulo, segun se encuentre o no la cuenta en la base de datos
     */
    @Override
    public Usuario iniciarSesion(String emailLogin, String passLogin) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Usuario.class);
        criteria.add(Restrictions.like("emailUsuario", emailLogin));
        criteria.add(Restrictions.like("passUsuario", passLogin));
        Usuario usuario = null;
        if (!criteria.list().isEmpty()) {
            usuario = (Usuario) criteria.list().get(0);
        }
        session.close();
        return usuario;
    }
    /**
     * modificarCuenta
     * permite modificar una cuenta elegida desde la vista
     * @param usuario es el objeto a modificar
     */
    @Override
    public void modificarCuenta(Usuario usuario) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(usuario);
        session.getTransaction().commit();
        session.close();
    }
    /**
     * obtenerUsuarios
     * permite obtener la lista de usuarios registrados
     * @return una lista de usuarios
     */
    @Override
    public List<Usuario> obtenerUsuarios() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Usuario.class);
        List<Usuario> usuarios = criteria.list();
        session.close();
        return usuarios;
    }

}
