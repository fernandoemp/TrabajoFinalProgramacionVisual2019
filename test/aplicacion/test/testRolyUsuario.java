/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.test;

import aplicacion.hibernate.dao.IRolDAO;
import aplicacion.hibernate.dao.IUsuarioDAO;
import aplicacion.hibernate.dao.imp.RolDAOImp;
import aplicacion.hibernate.dao.imp.UsuarioDAOImp;
import aplicacion.modelo.dominio.Rol;
import aplicacion.modelo.dominio.Usuario;

/**
 *
 * @author FERNANDO
 */
public class testRolyUsuario {

    public static void main(String[] args) {
        Rol rolAdmin = new Rol("ADMIN", "El usuario puede realizar operaciones de gestion en la pagina");
        Rol rolAdministrativo = new Rol("Administrativo", "El usuario puede administrar los catalogos");
        Rol rolConsumidor = new Rol("Consumidor", "El usuario puede ver y comprar");
        IRolDAO rolDAO = new RolDAOImp();
        rolDAO.agregarRol(rolAdmin);
        rolDAO.agregarRol(rolAdministrativo);
        rolDAO.agregarRol(rolConsumidor);
        
        Usuario usuario = new Usuario("Fernando", "Murguia", Byte.parseByte("23"), 39200693, "fernandoemanuelmp@gmail.com", "Fer123", "Habilitada", rolAdmin);
        IUsuarioDAO usuarioDAO = new UsuarioDAOImp();
        usuarioDAO.crearUsuario(usuario);

    }

}
