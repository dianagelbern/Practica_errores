package com.manejoerrores.practica.validacion.anotaciones;



import com.manejoerrores.practica.validacion.validadores.FechaAdecuadaValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.time.LocalDate;

@Constraint(validatedBy = FechaAdecuadaValidator.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface FechaAdecuada {

    String message() default "La fecha de apertura debe ser antes a la de registro";
    Class<?> [] groups() default {};
    Class <? extends Payload> [] payload() default {};

    String fechaAperturaField();
    String fechaRegistroField();
}
