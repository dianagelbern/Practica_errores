package com.manejoerrores.practica.validacion.validadores;

import com.manejoerrores.practica.validacion.anotaciones.UbicacionAdecuada;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UbicacionAdecuadaValidator implements ConstraintValidator<UbicacionAdecuada, Object> {
    @Override
    public void initialize(UbicacionAdecuada constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        return false;
    }
}
