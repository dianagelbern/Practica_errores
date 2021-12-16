package com.salesianostriana.dam.validacion.simple.validadores;

import com.salesianostriana.dam.validacion.simple.anotaciones.StrongPassword;
import org.springframework.beans.PropertyAccessorFactory;
import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StrongPasswordValidator implements ConstraintValidator<StrongPassword, Object> {

    private String passwordField;
    private int min;
    private int max;
    private boolean hasUpper;
    private boolean hasLower;
    private boolean hasNumber;
    private boolean hasAlpha;
    private boolean hasOthers;

    @Override
    public void initialize(StrongPassword constraintAnnotation) {
        passwordField = constraintAnnotation.passwordField();
        min = constraintAnnotation.min();
        max = constraintAnnotation.max();
        hasUpper = constraintAnnotation.hasUpper();
        hasLower = constraintAnnotation.hasLower();
        hasNumber = constraintAnnotation.hasNumber();
        hasAlpha = constraintAnnotation.hasAlpha();
        hasOthers = constraintAnnotation.hasOthers();
    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        String verify = "";
        String password = (String) PropertyAccessorFactory.forBeanPropertyAccess(o).getPropertyValue(passwordField);

        if (hasLower){
            verify = verify +("(?=.*[a-z])");
        }
        if (hasUpper){
            verify = verify +("(?=.*[A-Z])");
        }
        if (hasNumber){
            verify = verify +("(?=.*[0-9])");
        }
        if (hasOthers){
            verify = verify +("(?=.*[.,$-_])");
        }

        Pattern p = Pattern.compile(verify);
        Matcher m = p.matcher(verify);
    /*
        System.out.printf("Condicion del metodo: %s",  m.matches() && password.length() >= min && password.length() <= max);
        System.out.printf("Patron: %s", m);
    */
        return  m.matches() && password.length() >= min && password.length() <= max;
    }

}
