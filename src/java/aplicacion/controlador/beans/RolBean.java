package aplicacion.controlador.beans;

import aplicacion.hibernate.dao.IRolDAO;
import aplicacion.hibernate.dao.imp.RolDAOImp;
import aplicacion.modelo.dominio.Rol;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 * Representa un managedbean que solo interactua con la logica de negocio de la clase ROL.
 * @author Elias Acosta
 */
@ManagedBean
@ViewScoped
public class RolBean implements Serializable{
    private IRolDAO rolDAO;
    /**
     * Creates a new instance of RolBean
     */
    public RolBean() {
        rolDAO = new RolDAOImp();
    }
    
    //Metodos
    public void agregarRol(Rol rol){
        getRolDAO().agregarRol(rol);
    }
    
    public void eliminarRol(Rol rol){
        getRolDAO().eliminarRol(rol);
    }
    
    public void modificarRol(Rol rol){
        getRolDAO().modificarRol(rol);
    }
    
    public List<Rol>obtenerRol(){
        return getRolDAO().obtenerRoles();
    }
            
    //Getters y Setters
    public IRolDAO getRolDAO() {
        return rolDAO;
    }

    public void setRolDAO(IRolDAO rolDAO) {
        this.rolDAO = rolDAO;
    }
}
