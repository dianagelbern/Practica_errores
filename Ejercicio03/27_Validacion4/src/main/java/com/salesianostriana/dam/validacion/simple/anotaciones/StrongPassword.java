package com.salesianostriana.dam.validacion.simple.anotaciones;

import com.salesianostriana.dam.validacion.simple.validadores.StrongPasswordValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = StrongPasswordValidator.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface StrongPassword {

    String message() default "la contraseña no cumple con los requisitos de validación especificados";
    Class<?> [] groups() default {};
    Class <? extends Payload> [] payload() default {};

    String passwordField();
    int min() default 3;
    int max() default 10;
    boolean hasUpper() default false;
    boolean hasLower() default false;
    boolean hasNumber() default false;
    boolean hasAlpha() default false;
    boolean hasOthers() default false;


}
