package com.manejoerrores.practica.validacion.anotaciones;

import com.manejoerrores.practica.validacion.validadores.UniqueNameValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.FIELD}) //Indica donde podemos utilizar la anotación, en este caso en métodos y atributos de la clase
@Retention(RetentionPolicy.RUNTIME) //Indica el momento en el que está disponible la anotación(en este caso en la ejecución)
@Constraint(validatedBy = UniqueNameValidator.class) //Indicamos que la anotación es una restricción y la clase que utilizaremos para la validación
public @interface UniqueName {

    //Es el mensaje que se mostrará en caso de que se produzca un error
    String message() default "El nombre debe ser único";

    //Definimos bajo que circunstancias será lanzada
    Class<?>[] groups() default {};

    //Su uso es raro pero se debe incluir por ser standar de Spring
    Class<? extends Payload>[] payload() default {};
}
