package com.manejoerrores.practica.dto;

import com.manejoerrores.practica.validacion.anotaciones.FechaAdecuada;
import com.manejoerrores.practica.validacion.anotaciones.LatlongAdecuada;
import com.manejoerrores.practica.validacion.anotaciones.UniqueName;
import lombok.*;

import javax.persistence.Lob;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@LatlongAdecuada(ubicacionField = "ubicacion", message = "{estacion.ubicacion.latlon}")
@FechaAdecuada(fechaAperturaField = "fechaApertura", fechaRegistroField = "fechaRegistro", message = "{estacion.fecha.adecuada}")
public class CreateEstacionDto {


    @NotNull(message = "{estacion.nombre.blanck}")
    @NotEmpty(message = "{estacion.nombre.empty}")
    private String nombre;
    @NotNull(message = "{estacion.marca.null}")
    private String marca;
    @NotNull(message = "{estacion.ubicacion.null}")
    @UniqueName(message = "{estacion.ubicacion.unica}")
    private String ubicacion;
    @Lob
    private String servicios;
    @Builder.Default
    private boolean tieneAutolavado = false;
    @Min(value = 0, message = "{estacion.precioGasNormal.min}")
    @NotNull(message = "{estacion.precioGasNormal.null}")
    private double precioGasoleoNormal;
    @Min(value = 0, message = "{estacion.precioGas.min}")
    @NotNull(message = "{estacion.precioGas.null}")
    private double precioGasolina95Octanos;
    @Min(value = 0, message = "{estacion.precioGas.min}")
    private double precioGasoilEspecial;
    @Min(value = 0, message = "{estacion.precioGas.min}")
    private double precioGasolina98;
    @PastOrPresent(message = "{estacion.fecha.anterior}")
    private LocalDate fechaApertura;

    @Builder.Default
    private LocalDate fechaRegistro = LocalDate.now();
}
