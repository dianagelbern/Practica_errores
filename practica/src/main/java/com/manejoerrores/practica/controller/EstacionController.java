package com.manejoerrores.practica.controller;

import com.manejoerrores.practica.dto.EstacionDtoConverter;
import com.manejoerrores.practica.model.Estacion;
import com.manejoerrores.practica.service.EstacionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/estacion")
public class EstacionController {

    private final EstacionService service;
    private final EstacionDtoConverter converter;

    @GetMapping("/")
    private List<Estacion> findAll(){
        return service.findAll();
    }

    public Optional<Estacion> findById(@PathVariable Long id){
        return service.findById(id);
    }
}
