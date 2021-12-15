package com.manejoerrores.practica.validacion.validadores;

import com.manejoerrores.practica.validacion.anotaciones.LatlongAdecuada;
import org.springframework.beans.PropertyAccessorFactory;
import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class LatlongAdecuadaValidator implements ConstraintValidator<LatlongAdecuada, Object> {

    private String ubicacionField;

    @Override
    public void initialize(LatlongAdecuada constraintAnnotation) {
        ubicacionField = constraintAnnotation.ubicacionField();
    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        String ubicacion = (String) PropertyAccessorFactory.forBeanPropertyAccess(o).getPropertyValue(ubicacionField);
        String verify = "^[-+]?([1-8]?\\d(\\.\\d+)?|90(\\.0+)?),\\s*[-+]?(180(\\.0+)?|((1[0-7]\\d)|([1-9]?\\d))(\\.\\d+)?)$";
        return StringUtils.hasText(ubicacion) && ubicacion.matches(verify);
    }
}
