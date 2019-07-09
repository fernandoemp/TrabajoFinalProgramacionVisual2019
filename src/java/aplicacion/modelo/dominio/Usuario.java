/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.modelo.dominio;


import java.io.Serializable;

/**
 *
 * @author FullStackers
 */
/**
 * Clase Usuario contiene los atributos que tendra cada cuenta registrada
 *
 */
public class Usuario implements Serializable {

    private String nombreUsuario;
    //nombreUsuario: representa el nombre del usuario

    private String apellidoUsuario;
    //apellidoUsuario: representa el apellido del usuario

    private Integer dniUsuario;
    //dniUsuario: representa el dni del usuario

    private Byte edadUsuario;
    //edadUsuario: representa la edad del usuario

    private String emailUsuario;
    //emailUsuario: representa el correo electronico del usuario, con el cual
    //funcionara como id de la cuenta. Clave primaria en la base de datos.

    private String passUsuario;
    //passUsuario: representa la contraseña de la cuenta del usuario

    private String estadoCuenta = "Habilitada";
    /**
     * Agregado fuera de los requerimientos del proyecto: considero algo logico
     * posee esta caracteristica, y no unicamente la eliminacion de una cuenta
     * de forma permanente. estadoCuenta: permite establecer el estado de una
     * cuenta de un usuario. Se aplica a usuarios administrativos. Las cuentas
     * de clientes siempre tendra el estado "Habilitada". Las cuentas de
     * empleados pueden tener el estado "Habilitada" o "Inhabilitada" El estado
     * "Inhabilitada" puede darse por "x" suceso como por ejemplo, suspencion
     * del mismo, lo cual da la posibilidad de que se requiera la activacion de
     * la cuenta mas adelante. Por defecto establezco que las cuentas tendran el
     * estado "Habilitada". Tendran otro valor distinto solamente si se la
     * bloquea la cuenta desde el menu del administrador.
     */
//    Rol rolConsumidor = new Rol("Consumidor", "El usuario puede ver y comprar");
        
    private Rol tipoCuenta;           

    //tipoCuenta: permite establecer si es una cuenta consumidor, administrativo o admin.
    //por defecto un usuario que se registra obtendra el rol de consumidor.

    //CONSTRUCTORES
    /**
     * Constructor por defecto
     */
    public Usuario() {
        tipoCuenta = new Rol();
    }

    /**
     * @param nombreUsuario permite almacenar el nombre del usuario
     * @param apellidoUsuario permite almacenar el apellido del usuario
     * @param edadUsuario permite almacenar la edad del usuario
     * @param dniUsuario permite almacenar el numero de documento nacional de
     * identidad del usuario
     * @param emailUsuario permite almacenar el correo electronico del usuario
     * @param passUsuario permite almacenar la contraseña de la cuenta del
     * usuario
     * @param estadoCuenta permite establecer si la cuenta está activa o no.
     * @param tipoCuenta permite establecer que tipo de cuenta es.
     *
     */
    public Usuario(String nombreUsuario, String apellidoUsuario, Byte edadUsuario, Integer dniUsuario, String emailUsuario, String passUsuario, String estadoCuenta, Rol tipoCuenta) {
        this.nombreUsuario = nombreUsuario;
        this.apellidoUsuario = apellidoUsuario;
        this.edadUsuario = edadUsuario;
        this.dniUsuario = dniUsuario;
        this.emailUsuario = emailUsuario;
        this.passUsuario = passUsuario;
        this.estadoCuenta = estadoCuenta;
        this.tipoCuenta = tipoCuenta;
    }

    public Usuario(String nombreUsuario, String apellidoUsuario, Integer dniUsuario, Byte edadUsuario, String emailUsuario, String passUsuario) {
        this.nombreUsuario = nombreUsuario;
        this.apellidoUsuario = apellidoUsuario;
        this.dniUsuario = dniUsuario;
        this.edadUsuario = edadUsuario;
        this.emailUsuario = emailUsuario;
        this.passUsuario = passUsuario;
    }
    
    /**
     * METODOS GETTERS & SETTERS
     */
    /**
     * @return the apellidoUsuario
     */
    public String getApellidoUsuario() {
        return apellidoUsuario;
    }

    /**
     * @return the dniUsuario
     */
    public Integer getDniUsuario() {
        return dniUsuario;
    }

    /**
     * @return the edadUsuario
     */
    public Byte getEdadUsuario() {
        return edadUsuario;
    }

    /**
     * @return the emailUsuario
     */
    public String getEmailUsuario() {
        return emailUsuario;
    }

    /**
     * @return the estadoCuenta
     */
    public String getEstadoCuenta() {
        return estadoCuenta;
    }

    /**
     * @return the nombreUsuario
     */
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    /**
     * @return the passUsuario
     */
    public String getPassUsuario() {
        return passUsuario;
    }

    /**
     * @return the tipoCuenta
     */
    public Rol getTipoCuenta() {
        return tipoCuenta;
    }

    /**
     * @param apellidoUsuario the apellidoUsuario to set
     */
    public void setApellidoUsuario(String apellidoUsuario) {
        this.apellidoUsuario = apellidoUsuario;
    }

    /**
     * @param dniUsuario the dniUsuario to set
     */
    public void setDniUsuario(Integer dniUsuario) {
        this.dniUsuario = dniUsuario;
    }

    /**
     * @param edadUsuario the edadUsuario to set
     */
    public void setEdadUsuario(Byte edadUsuario) {
        this.edadUsuario = edadUsuario;
    }

    /**
     * @param emailUsuario the emailUsuario to set
     */
    public void setEmailUsuario(String emailUsuario) {
        this.emailUsuario = emailUsuario;
    }

    /**
     * @param estadoCuenta the estadoCuenta to set
     */
    public void setEstadoCuenta(String estadoCuenta) {
        this.estadoCuenta = estadoCuenta;
    }

    /**
     * @param nombreUsuario the nombreUsuario to set
     */
    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    /**
     * @param passUsuario the passUsuario to set
     */
    public void setPassUsuario(String passUsuario) {
        this.passUsuario = passUsuario;
    }

    /**
     * @param tipoCuenta the tipoCuenta to set
     */
    public void setTipoCuenta(Rol tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    /**
     * Metodo ToString
     */
    @Override
    public String toString() {
        return "Usuario{" + "nombreUsuario=" + nombreUsuario + ", apellidoUsuario=" + apellidoUsuario + ", edadUsuario=" + edadUsuario + ", dniUsuario=" + dniUsuario + ", emailUsuario=" + emailUsuario + ", passUsuario=" + passUsuario + ", estadoCuenta=" + estadoCuenta + ", tipoCuenta=" + tipoCuenta + '}';
    }

}
