package com.manejoerrores.practica.validacion.anotaciones;

import com.manejoerrores.practica.validacion.validadores.UbicacionAdecuadaValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = UbicacionAdecuadaValidator.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface UbicacionAdecuada {

    String message() default "La ubicación introducida no es adecuada";
    Class<?>[] groups() default {};
    Class<? extends Payload> [] payload() default {};

    String ubicacionField();
}
