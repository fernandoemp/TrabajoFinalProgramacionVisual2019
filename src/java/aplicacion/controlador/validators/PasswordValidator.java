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
 * @author FERNANDO
 */
@FacesValidator
public class PasswordValidator implements Validator, Serializable {

    @Override
    public void validate(FacesContext fc, UIComponent uic, Object o) throws ValidatorException {

        boolean booleanMay = false, booleanMin = false, booleanNum = false;
        String pass = o.toString();

        for (int i = 0; i < pass.length(); i++) {
            System.out.println(pass.charAt(i));
            if (pass.charAt(i) >= 'a' && pass.charAt(i) <= 'z') {
                booleanMin = true;

            }
            if (pass.charAt(i) >= 'A' && pass.charAt(i) <= 'Z') {
                booleanMay = true;

            }
            if (pass.charAt(i) >= '0' && pass.charAt(i) <= '9') {
                booleanNum = true;

            }
        }
        System.out.println("1" + booleanMay + "2" + booleanMin + "3" + booleanNum);
        if (booleanMay == false || booleanMin == false || booleanNum == false) {
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "La contraseña no es segura. Debera contener minimo 5 caracteres; 1 Mayuscula, 1 Minuscula y 1 numero", ""));

        }
    }
}
