package com.manejoerrores.practica.validacion.validadores;

import com.manejoerrores.practica.repository.EstacionRepository;
import com.manejoerrores.practica.validacion.anotaciones.UniqueName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.ConstraintViolation;

public class UniqueNameValidator implements ConstraintValidator<UniqueName, String> {

    @Autowired
    //Inyectamos al repo que es donde previamente creamos el existByNombre
    private EstacionRepository repository;

    //
    @Override
    public void initialize(UniqueName constraintAnnotation) {
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return StringUtils.hasText(s) && !repository.existsByNombre(s);
    }
}
