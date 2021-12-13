package com.manejoerrores.practica;

import com.manejoerrores.practica.dto.CreateEstacionDto;
import com.manejoerrores.practica.model.Estacion;
import com.manejoerrores.practica.service.EstacionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class MainDePrueba {

    private final EstacionService servicio;

    @PostConstruct
    public void prueba(){

        Estacion repsol = Estacion.builder()
                .nombre("Estación de Servicio Repsol")
                .fechaApertura(LocalDate.of(2004, 02, 22))
                .marca("Repsol")
                .tieneAutolavado(true)
                .ubicacion("37.3838284,-6.0271693")
                .precioGasoleoNormal(1.19)
                .precioGasoilEspecial(1.85)
                .precioGasolina95Octanos(.95)
                .precioGasolina98(1.20)
                .servicios("Acércate a nuestras estaciones de servicio y hazte con los nuevos artículos de Mickey Mouse")
                .build();

        Estacion cepsa = Estacion.builder()
                .nombre("Estación de Servicio Cepsa")
                .fechaApertura(LocalDate.of(2016, 11, 12))
                .marca("Cepsa")
                .tieneAutolavado(true)
                .ubicacion("37.3687826,-6.014993")
                .precioGasoleoNormal(1.20)
                .precioGasoilEspecial(1.95)
                .precioGasolina95Octanos(1.95)
                .precioGasolina98(1.40)
                .servicios("Acércate a nuestras estaciones de servicio y en la compra de una de nuestras ofertas especiales te regalamos un kit de viaje")
                .build();

        servicio.save(repsol);
        servicio.save(cepsa);
    }


}
