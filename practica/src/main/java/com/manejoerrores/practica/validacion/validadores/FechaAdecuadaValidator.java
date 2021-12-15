package com.manejoerrores.practica.validacion.validadores;

import com.manejoerrores.practica.validacion.anotaciones.FechaAdecuada;
import org.springframework.beans.PropertyAccessorFactory;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;

public class FechaAdecuadaValidator implements ConstraintValidator<FechaAdecuada, Object> {

    private String fechaAperturaField;
    private String fechaRegistroField;

    @Override
    public void initialize(FechaAdecuada constraintAnnotation) {
        fechaAperturaField = constraintAnnotation.fechaAperturaField();
        fechaRegistroField = constraintAnnotation.fechaRegistroField();
    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        LocalDate fechaApertura = (LocalDate) PropertyAccessorFactory.forBeanPropertyAccess(o).getPropertyValue(fechaAperturaField);
        LocalDate fechaRegistro = (LocalDate) PropertyAccessorFactory.forBeanPropertyAccess(o).getPropertyValue(fechaRegistroField);
        return fechaRegistro.isAfter(fechaApertura);
    }
}
