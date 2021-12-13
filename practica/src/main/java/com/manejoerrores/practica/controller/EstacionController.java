package com.manejoerrores.practica.controller;

import com.manejoerrores.practica.dto.CreateEstacionDto;
import com.manejoerrores.practica.dto.EstacionDtoConverter;
import com.manejoerrores.practica.dto.GetEstacionDto;
import com.manejoerrores.practica.model.Estacion;
import com.manejoerrores.practica.service.EstacionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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

    @GetMapping("/{id}")
    public Optional<Estacion> findById(@PathVariable Long id){
        return service.findById(id);
    }

    @PostMapping("/")
    public Estacion create(@Valid @RequestBody CreateEstacionDto dto){
        return service.save(dto, converter);
    }

    @PutMapping("/{id}")
    public Estacion edit(@Valid @RequestBody CreateEstacionDto dto, Estacion e){
        return service.edit(dto, e);
    }

    @DeleteMapping("/{id}")
    public void delete(Estacion e){
        service.deleteById(e);
    }

}
