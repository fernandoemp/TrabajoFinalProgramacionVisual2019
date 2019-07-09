/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.controlador.beans.forms;

import aplicacion.controlador.beans.UsuarioBean;
import aplicacion.modelo.dominio.Usuario;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;

/**
 *
 * @author Fernando
 */
/**
 * Clase ABMUsuarioFormBean ManagedBean que interactua con la vista respecto
 * todo lo referido a la gestion de usuarios
 */
@ManagedBean
@ViewScoped
public class ABMUsuarioFormBean implements Serializable {

    @ManagedProperty(value = "#{usuarioBean}")
    //Notacion ManagedProperty permite incrustar un managedBean para que pueda ser manejado por el managed
    //que lo instancia
    private UsuarioBean usuarioBean;
    //usuarioBean permite la conexion entre la vista y la logica del negocio
    private Usuario usuario;
    //usuario permite almacenar los datos de un nuevo usuario en el panel de registro
    private String emailBuscado;
    //emailBuscado permite almacenar un email que representara el id de una cuenta a buscarse en la base de datos
    private Integer dniBuscado;
    //dniBuscado permite almacenar un Integer para buscar coincidencia con el dni de los usuarios registrados
    private String rolBuscado;
    //rolBuscado permite almacenar un String para buscar coincidencia con el rol de los usuarios registrados
    private List<Usuario> listaUsuarios;
    //listaUsuarios permite almacenar la lista de usuarios registrados
    private List<Usuario> resultadoBusqueda;
    //listaResultado permite almacenar una lista con usuarios segun la busqeuda de caracteres ingresados en la seccion busqueda

    //listaUsuarios permite almacenar una lista de usuarios
    /**
     * Constructor por Defecto
     */
    public ABMUsuarioFormBean() {
        listaUsuarios = new ArrayList<>();
        resultadoBusqueda = new ArrayList<>();
        emailBuscado = "";
        usuario = new Usuario();
    }

    /**
     * Metodo PostConstructor
     */
    @PostConstruct
    public void init() {
        obtenerUsuarios();// ESTO DA ERROR SI LA BD ESTA VACIA
    }

    /**
     * buscarUsuarios permite buscar usuarios segun los caracteres ingresados
     * coincidentes con los emails de los usuarios
     */
    public void buscarUsuarios() {
        obtenerUsuarios();
        getResultadoBusqueda().clear();

        for (int i = 0; i < getListaUsuarios().size(); i++) {
            if (getListaUsuarios().get(i).getEmailUsuario().toLowerCase().startsWith(getEmailBuscado().toLowerCase())) {
                getResultadoBusqueda().add(getListaUsuarios().get(i));
            }
        }
        setEmailBuscado("");
    }

    /**
     * buscarUsuariosPorDni permite buscar usuarios segun los caracteres
     * ingresados coincidentes con el dni
     */
    public void buscarUsuariosPorDni() {
        obtenerUsuarios();
        getResultadoBusqueda().clear();

        for (int i = 0; i < getListaUsuarios().size(); i++) {
            if (getListaUsuarios().get(i).getDniUsuario().equals(getDniBuscado())) {
                getResultadoBusqueda().add(getListaUsuarios().get(i));
            }
        }
        setDniBuscado(null);
    }

    /**
     * buscarUsuariosPorRol permite buscar usuarios segun los caracteres
     * ingresados coincidentes con el rol
     */
    public void buscarUsuariosPorRol() {
        obtenerUsuarios();
        getResultadoBusqueda().clear();

        for (int i = 0; i < getListaUsuarios().size(); i++) {
            if (getListaUsuarios().get(i).getTipoCuenta().getTipoRol().toLowerCase().startsWith(getRolBuscado().toLowerCase())) {
                getResultadoBusqueda().add(getListaUsuarios().get(i));
            }
        }
        setEmailBuscado("");
    }

    /**
     * crearUsuario permite crear un nuevo usuario si el email ingresado no se
     * encuentra ya registrado
     */
    public void crearUsuario() {
        getUsuarioBean().crearUsuario(getUsuario());
        addMessageInfo("Operacion Realizada", "Usuario creado con exito");
    }

    /**
     * eliminarUsuario permite eliminar un usuario definitivamente
     *
     * @param usuario contiene los datos del usuario a eliminar
     */
    public void eliminarUsuario(Usuario usuario) {
        //if  permisoUsuarioHabilitado(usu.perfil, codoperacion, usu.nombreusu)
//        Usuario usu=(Usuario)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuarioLogueado");
//        System.out.println("usuario logueado" +usu.getEmailUsuario());
        getUsuarioBean().eliminarUsuario(usuario);
        addMessageInfo("Operacion Realizada", "Usuario " + usuario.getEmailUsuario() + " eliminado con exito");
        obtenerUsuarios();
    }

    /**
     * modificarCuenta permite cambiar el estado de un usuario. 2 posibles
     * estados; cuenta habilitada e inhabilitada
     *
     * @param usuario contiene los datos de la cuenta a modificar su estuado
     */
    public void modificarCuenta(Usuario usuario) {
        getUsuarioBean().modificarCuenta(usuario);
    }

    /**
     * obtenerUsuarios permite obtener una lista de usuarios registrados
     */
    public void obtenerUsuarios() {
        setListaUsuarios(getUsuarioBean().obtenerUsuarios());
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

    //METODOS GETTERS Y SETTERS

    /**
     * @return the dniBuscado
     */
    public Integer getDniBuscado() {
        return dniBuscado;
    }

    /**
     * @return the emailBuscado
     */
    public String getEmailBuscado() {
        return emailBuscado;
    }

    /**
     * @return the listaUsuarios
     */
    public List<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    /**
     * @return the resultadoBusqueda
     */
    public List<Usuario> getResultadoBusqueda() {
        return resultadoBusqueda;
    }

    /**
     * @return the rolBuscado
     */
    public String getRolBuscado() {
        return rolBuscado;
    }

    /**
     * @return the usuario
     */
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * @return the usuarioBean
     */
    public UsuarioBean getUsuarioBean() {
        return usuarioBean;
    }

    /**
     * @param dniBuscado the dniBuscado to set
     */
    public void setDniBuscado(Integer dniBuscado) {
        this.dniBuscado = dniBuscado;
    }

    /**
     * @param emailBuscado the emailBuscado to set
     */
    public void setEmailBuscado(String emailBuscado) {
        this.emailBuscado = emailBuscado;
    }

    /**
     * @param listaUsuarios the listaUsuarios to set
     */
    public void setListaUsuarios(List<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    /**
     * @param resultadoBusqueda the resultadoBusqueda to set
     */
    public void setResultadoBusqueda(List<Usuario> resultadoBusqueda) {
        this.resultadoBusqueda = resultadoBusqueda;
    }

    /**
     * @param rolBuscado the rolBuscado to set
     */
    public void setRolBuscado(String rolBuscado) {
        this.rolBuscado = rolBuscado;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    /**
     * @param usuarioBean the usuarioBean to set
     */
    public void setUsuarioBean(UsuarioBean usuarioBean) {
        this.usuarioBean = usuarioBean;
    }
    
}
