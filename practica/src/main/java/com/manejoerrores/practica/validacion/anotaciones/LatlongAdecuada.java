package com.manejoerrores.practica.validacion.anotaciones;

import com.manejoerrores.practica.validacion.validadores.LatlongAdecuadaValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = LatlongAdecuadaValidator.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface LatlongAdecuada {

    String message() default "La latitud y longitud deben ser reales";
    Class<?>[] groups() default {};
    Class<? extends Payload> [] payload() default {};

    String ubicacionField();
}
