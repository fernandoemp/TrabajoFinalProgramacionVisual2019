/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.hibernate.dao;

import aplicacion.modelo.dominio.Usuario;
import java.util.List;

/**
 *
 * @author FERNANDO
 */
public interface IUsuarioDAO {

    public void crearUsuario(Usuario usuario);

    public void eliminarUsuario(Usuario usuario);

    public Usuario iniciarSesion(String emailLogin, String passLogin);

    public void modificarCuenta(Usuario usuario);

    public List<Usuario> obtenerUsuarios();

}

