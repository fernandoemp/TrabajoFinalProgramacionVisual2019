/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.controlador.beans;

import aplicacion.modelo.dominio.Usuario;
import java.io.Serializable;
import java.util.Properties;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.swing.JOptionPane;
import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Windows
 */
@ManagedBean
@ViewScoped
public class MailBean implements Serializable{
    
//    private Usuario usuarioLogueado;
    
    /**
     * Creates a new instance of MailBean
     */
    public MailBean() {
    }
    
    public void enviarMail(Integer codigo) {
        Usuario usuarioLogueado = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuarioLogueado");
        System.out.println(usuarioLogueado);
        try{
            Properties props = new Properties();
            props.setProperty("mail.smtp.host", "smtp.gmail.com");
            props.setProperty("mail.smtp.starttls.enable", "true");
            props.setProperty("mail.smtp.port", "587");
            props.setProperty("mail.smtp.auth", "true");
            
            Session session = Session.getDefaultInstance(props);
    
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress("fullstackerspv2019@gmail.com"));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(usuarioLogueado.getEmailUsuario()));
            message.setSubject("Mail de prueba");
            message.setText("Ha realizado su compra! Debe acercarse a la sucursal central con su factura para realizar el pago y retiro de su compra. Su factura la puede ver ingresando el siguiente numero en la pagina: "+codigo);
            
            Transport t = session.getTransport("smtp");
            t.connect("fullstackerspv2019", "PV2019XD");
            t.sendMessage(message, message.getRecipients(Message.RecipientType.TO));
            t.close();
            
        }catch(AddressException ex){
            
        }catch(MessagingException ex){
            
        }
    }
}
