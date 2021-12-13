package com.manejoerrores.practica.model;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Estacion {

    @Id
    @GeneratedValue
    private Long id;

    private String nombre, marca, ubicacion, servicios;
    private boolean tieneAutolavado;
    private double precioGasoleoNormal, precioGasolina95Octanos, precioGasoilEspecial, precioGasolina98;

    private LocalDate fechaApertura;

}
