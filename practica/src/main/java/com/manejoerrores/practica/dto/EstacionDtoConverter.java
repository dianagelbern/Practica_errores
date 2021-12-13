package com.manejoerrores.practica.dto;

import com.manejoerrores.practica.model.Estacion;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EstacionDtoConverter {

    public GetEstacionDto estacionToGetEstacionDto(Estacion e){
        return GetEstacionDto.builder()
                .id(e.getId())
                .nombre(e.getNombre())
                .marca(e.getMarca())
                .ubicacion(e.getUbicacion())
                .servicios(e.getServicios())
                .tieneAutolavado(e.isTieneAutolavado())
                .precioGasoilEspecial(e.getPrecioGasoilEspecial())
                .precioGasolina95Octanos(e.getPrecioGasolina95Octanos())
                .precioGasoleoNormal(e.getPrecioGasoleoNormal())
                .precioGasolina98(e.getPrecioGasolina98())
                .fechaApertura(e.getFechaApertura()).build();
    }

    public Estacion createEstacionDtoTEstacion(CreateEstacionDto c){
        return Estacion.builder()
                .nombre(c.getNombre())
                .marca(c.getMarca())
                .ubicacion(c.getUbicacion())
                .servicios(c.getServicios())
                .tieneAutolavado(c.isTieneAutolavado())
                .precioGasoilEspecial(c.getPrecioGasoilEspecial())
                .precioGasolina95Octanos(c.getPrecioGasolina95Octanos())
                .precioGasoleoNormal(c.getPrecioGasoleoNormal())
                .precioGasolina98(c.getPrecioGasolina98())
                .fechaApertura(c.getFechaApertura()).build();
    }
}
