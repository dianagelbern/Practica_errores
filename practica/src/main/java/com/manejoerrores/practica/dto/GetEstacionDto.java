package com.manejoerrores.practica.dto;

import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class GetEstacionDto {

    private Long id;

    private String nombre, marca, ubicacion, servicios;
    private boolean tieneAutolavado;
    private double precioGasoleoNormal, precioGasolina95Octanos, precioGasoilEspecial, precioGasolina98;

    private LocalDate fechaApertura;
    private LocalDate fechaRegistro;
}
