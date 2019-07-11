/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.hibernate.dao;

import aplicacion.modelo.dominio.Rol;
import java.util.List;

/**
 *
 * @author Elias Acosta
 */
public interface IRolDAO {
    public void agregarRol(Rol rol);
    public void modificarRol(Rol rol);
    public void eliminarRol(Rol rol);
    public List<Rol>obtenerRoles();
    public Rol obtenerRol(String rol);
}
