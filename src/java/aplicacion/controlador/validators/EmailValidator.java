/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.controlador.validators;

import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author Fernando
 */
@FacesValidator
public class EmailValidator implements Validator, Serializable {

    @Override
    public void validate(FacesContext fc, UIComponent uic, Object o) throws ValidatorException {
        String emailIngresado = o.toString();
        if (!emailIngresado.contains("@") || !emailIngresado.contains(".com") || emailIngresado.contains(" ") )  {
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "El email " + emailIngresado + " no tiene un patron de email valido: ejemplo@email.com", ""));
        }
    }
}
