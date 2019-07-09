package aplicacion.modelo.dominio;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Representa la orden de un carrito que puede llegar a comprar o no un cliente.
 * @author Elias Acosta
 */
public class Carrito implements Serializable{
    private Integer codigoCarrito;
    private Usuario usuarioCliente;
    private Date fechaCarrito;
    private String estadoCarrito;
    private Set listaProductosElegidos;

    public Carrito() {
        usuarioCliente = new Usuario();
        fechaCarrito = new Date();
        listaProductosElegidos = new HashSet();
    }

    /**
     * Constructor parametrizado
     * @param usuarioCliente el dueño del carrito.
     * @param fechaCarrito el dia en qse creo el carrito
     * @param estadoCarrito puede ser comprado, reservado,
     * @param listaProductosElegidos contiene todos los productos reservados
     */
    public Carrito(Usuario usuarioCliente,Date fechaCarrito, String estadoCarrito, Set listaProductosElegidos) {
        this.fechaCarrito = fechaCarrito;
        this.usuarioCliente = usuarioCliente;
        this.estadoCarrito = estadoCarrito;
        this.listaProductosElegidos = listaProductosElegidos;
    }
    
    //Getters y Setters

    public Integer getCodigoCarrito() {
        return codigoCarrito;
    }

    public void setCodigoCarrito(Integer codigoCarrito) {
        this.codigoCarrito = codigoCarrito;
    }

    public Usuario getUsuarioCliente() {
        return usuarioCliente;
    }

    public void setUsuarioCliente(Usuario usuarioCliente) {
        this.usuarioCliente = usuarioCliente;
    }

    public Date getFechaCarrito() {
        return fechaCarrito;
    }

    public void setFechaCarrito(Date fechaCarrito) {
        this.fechaCarrito = fechaCarrito;
    }

    public String getEstadoCarrito() {
        return estadoCarrito;
    }

    public void setEstadoCarrito(String estadoCarrito) {
        this.estadoCarrito = estadoCarrito;
    }

    public Set getListaProductosElegidos() {
        return listaProductosElegidos;
    }

    public void setListaProductosElegidos(Set listaProductosElegidos) {
        this.listaProductosElegidos = listaProductosElegidos;
    }

    @Override
    public String toString() {
        return "Carrito{" + "codigoCarrito=" + codigoCarrito + ", usuarioCliente=" + usuarioCliente + ", fechaCarrito=" + fechaCarrito + ", estadoCarrito=" + estadoCarrito + ", listaProductosElegidos=" + listaProductosElegidos + '}';
    }
    
}
