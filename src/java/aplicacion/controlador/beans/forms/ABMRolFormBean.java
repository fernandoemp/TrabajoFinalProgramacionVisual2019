package aplicacion.controlador.beans.forms;

import aplicacion.controlador.beans.RolBean;
import aplicacion.modelo.dominio.Rol;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Elias Acosta
 */
@ManagedBean
@ViewScoped
public class ABMRolFormBean implements Serializable {

    private Rol unRol;
    @ManagedProperty(value = "#{rolBean}")
    private RolBean rolBean;
    private List<Rol> listaRoles;

    /**
     * Creates a new instance of RolFormBean
     */
    public ABMRolFormBean() {
        listaRoles = new ArrayList<>();

    }

    @PostConstruct
    public void init() {
        unRol = new Rol();
        obtenerRoles();

    }

    //Metodos CRUD de rol
    public void agregarRol() {
        rolBean.agregarRol(unRol);
        FacesContext.getCurrentInstance().
                addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Exito!", "Se agrego un nuevo rol."));
        obtenerRoles();
    }

    public void eliminarRol(Rol unRol) {
        rolBean.eliminarRol(unRol);
        obtenerRoles();
    }

    public void modificarRol(Rol unRol) {
        rolBean.modificarRol(unRol);
        obtenerRoles();
    }

    public void obtenerRoles() {
        listaRoles = rolBean.obtenerRol();
    }

    //Getters y Setters
    public Rol getUnRol() {
        return unRol;
    }

    public void setUnRol(Rol unRol) {
        this.unRol = unRol;
    }

    public RolBean getRolBean() {
        return rolBean;
    }

    public void setRolBean(RolBean rolBean) {
        this.rolBean = rolBean;
    }

    public List<Rol> getListaRoles() {
        return listaRoles;
    }

    public void setListaRoles(List<Rol> listaRoles) {
        this.listaRoles = listaRoles;
    }

}
