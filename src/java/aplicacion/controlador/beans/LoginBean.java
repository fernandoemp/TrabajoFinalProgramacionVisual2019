/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.controlador.beans;

import aplicacion.hibernate.dao.IUsuarioDAO;
import aplicacion.hibernate.dao.imp.UsuarioDAOImp;
import aplicacion.modelo.dominio.Usuario;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Fernando
 */
/**
 * Clase LoginBean permite la conexion de usuarios y mantenerlos en sesion
 * durante su recorrido por la aplicacion web
 *
 */
@ManagedBean
@SessionScoped
public class LoginBean implements Serializable {

    private IUsuarioDAO usuarioDAO;
    //usuarioDAO permite realizar la conexion con la implementacion

    /**
     * Constructor por defecto
     */
    public LoginBean() {
        usuarioDAO = new UsuarioDAOImp();
    }

    /**
     * iniciarSesion permite enviar parametros con los datos de la cuenta que
     * intenta iniciar sesion en la web y asi poder verificar si la cuenta
     * existe o no
     *
     * @param emailLogin representa el email logueado
     * @param passLogin representa la contraseña logueada
     * @return un objeto de tipo Usuario, si fue encontrado con los datos del
     * usuario, y sino retorna null
     */
    public Usuario iniciarSesion(String emailLogin, String passLogin) {
        return usuarioDAO.iniciarSesion(emailLogin, passLogin);
    }

    /**
     * METODOS GETTERS Y SETTERS
     */
    /**
     * @return the usuarioDAO
     */
    public IUsuarioDAO getUsuarioDAO() {
        return usuarioDAO;
    }

    /**
     * @param usuarioDAO the usuarioDAO to set
     */
    public void setUsuarioDAO(IUsuarioDAO usuarioDAO) {
        this.usuarioDAO = usuarioDAO;
    }
}
