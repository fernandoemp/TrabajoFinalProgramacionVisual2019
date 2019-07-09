/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.controlador.beans;

import aplicacion.hibernate.dao.IRolDAO;
import aplicacion.hibernate.dao.IUsuarioDAO;
import aplicacion.hibernate.dao.imp.RolDAOImp;
import aplicacion.hibernate.dao.imp.UsuarioDAOImp;
import aplicacion.modelo.dominio.Rol;
import aplicacion.modelo.dominio.Usuario;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;

/**
 *
 * @author Fernando
 */
/**
 * Clase UsuarioBean ManagedBean que interactua con la logica del negocio
 *
 */
@ManagedBean
@ViewScoped
public class UsuarioBean implements Serializable {

    private IUsuarioDAO usuarioDAO;

    //usuarioDAO permite realizar la conexion con la implementacion
    /**
     * Constructor por defecto
     */
    public UsuarioBean() {
        usuarioDAO = new UsuarioDAOImp();
    }

    /**
     * modificarCuenta permite cambiar el estado de un usuario. 2 posibles
     * estados; cuenta habilitada e inhabilitada
     *
     * @param usuario contiene los datos de la cuenta a modificar su estuado
     */
    public void modificarCuenta(Usuario usuario) {
        usuarioDAO.modificarCuenta(usuario);
    }

    /**
     * crearUsuario permite crear un nuevo usuario si el email ingresado no se
     * encuentra ya registrado
     *
     * @param usuario contiene los datos del usuario que desea registrarse
     */
    public void crearUsuario(Usuario usuario) {
        if (usuario.getTipoCuenta().equals(new Rol())) {
            IRolDAO rolDAO = new RolDAOImp();
            Rol rolConsumidor = rolDAO.obtenerRol("Consumidor");
            usuario.setTipoCuenta(rolConsumidor);
        }
        getUsuarioDAO().crearUsuario(usuario);
    }

    /**
     * eliminarUsuario permite eliminar un usuario definitivamente
     *
     * @param usuario contiene los datos del usuario a eliminar
     */
    public void eliminarUsuario(Usuario usuario) {
        getUsuarioDAO().eliminarUsuario(usuario);
    }

    /**
     * obtenerUsuarios permite obtener una lista de usuarios registrados
     *
     * @return la lista de usuarios registrados
     */
    public List<Usuario> obtenerUsuarios() {
        return usuarioDAO.obtenerUsuarios();
    }

    /**
     * @return the usuarioDAO
     */
    public IUsuarioDAO getUsuarioDAO() {
        return usuarioDAO;
    }

    /**
     * Metodos getters & setters
     */
    /**
     * @param usuarioDAO the usuarioDAO to set
     */
    public void setUsuarioDAO(IUsuarioDAO usuarioDAO) {
        this.usuarioDAO = usuarioDAO;
    }
}
