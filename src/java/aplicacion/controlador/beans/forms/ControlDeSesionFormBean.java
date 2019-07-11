/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.controlador.beans.forms;

import aplicacion.modelo.dominio.Usuario;
import java.io.IOException;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Fernando
 */
/**
 * ControlDeSesionFormBean permite detectar si un usuario está logueado y
 * tambien de acuerdo a su rol, renderizar ciertas partes de la pagina
 */
@ManagedBean
@ViewScoped
public class ControlDeSesionFormBean implements Serializable {

    /**
     * Creates a new instance of ControlDeSesionFormBean
     */
    public ControlDeSesionFormBean() {

    }

    public void verificarSesion() {
        try {
            FacesContext fc = FacesContext.getCurrentInstance();
            Usuario user = (Usuario) fc.getExternalContext().getSessionMap().get("usuarioLogueado");
            if (user == null || user.getTipoCuenta().getTipoRol().equals("Consumidor")) {
                fc.getExternalContext().redirect("principal.xhtml");
            }

        } catch (IOException e) {
            System.out.println(e);
        }
    }

    /**
     * Permite verificar si un usuario es de tipo consumidor
     *
     * @return un valor true o false este logueado y sea de tipo consumidor
     */
    public boolean verificarSesionUserConsumidor() {

        FacesContext fc = FacesContext.getCurrentInstance();

        Usuario user = (Usuario) fc.getExternalContext().getSessionMap().get("usuarioLogueado");

        return user != null && user.getTipoCuenta().getTipoRol().equals("Consumidor");
    }

    /**
     * Permite verificar si un usuario es de tipo administrativo
     *
     * @return un valor true o false este logueado y sea de tipo administrativo
     */
    public boolean verificarSesionUserAdministrativo() {
        FacesContext fc = FacesContext.getCurrentInstance();

        Usuario user = (Usuario) fc.getExternalContext().getSessionMap().get("usuarioLogueado");
        return user != null && user.getTipoCuenta().getTipoRol().equals("Administrativo");
    }

    /**
     * Permite verificar si un usuario es de tipo ADMIN
     *
     * @return un valor true o false este logueado y sea de tipo ADMIN
     */
    public boolean verificarSesionUserAdmin() {
        FacesContext fc = FacesContext.getCurrentInstance();

        Usuario user = (Usuario) fc.getExternalContext().getSessionMap().get("usuarioLogueado");

        return user != null && user.getTipoCuenta().getTipoRol().equals("ADMIN");
    }

    public boolean verificarSesionUserNull() {
        FacesContext fc = FacesContext.getCurrentInstance();

        Usuario user = (Usuario) fc.getExternalContext().getSessionMap().get("usuarioLogueado");

        return user != null;
    }

    //Mensajes
    /**
     * addMessageInfo
     *
     * @param summary permite mostrar el resumen del mensaje informativo
     * @param detail permite mostrar otro mensaje mas detallado
     */
    public void addMessageInfo(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    /**
     * addMessageError
     *
     * @param summary permite mostrar el resumen del mensaje de error
     * @param detail permite mostrar otro mensaje mas detallado
     */
    public void addMessageError(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

}
