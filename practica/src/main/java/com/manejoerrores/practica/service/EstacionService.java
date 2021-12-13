package com.manejoerrores.practica.service;

import com.manejoerrores.practica.dto.CreateEstacionDto;
import com.manejoerrores.practica.dto.EstacionDtoConverter;
import com.manejoerrores.practica.dto.GetEstacionDto;
import com.manejoerrores.practica.error.excepciones.ListEntityNotFoundException;
import com.manejoerrores.practica.error.excepciones.SingleEntityNotFoundException;
import com.manejoerrores.practica.model.Estacion;
import com.manejoerrores.practica.repository.EstacionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
//@RequiredArgsConstructor
public class EstacionService {

  //  private final EstacionRepository repository;
    @Autowired
    private EstacionRepository repository;

    public List<Estacion> findAll(){
        List<Estacion> result = repository.findAll();
        if (result.isEmpty()) {
            throw new ListEntityNotFoundException(GetEstacionDto.class);
        } else {
            return result;
        }
    }

    public Optional<Estacion> findById(Long id){
               if(repository.findById(id).isEmpty()){
                   throw new SingleEntityNotFoundException(id.toString(), Estacion.class);
               }else{
                   return repository.findById(id);
               }
    }

    public Estacion save(CreateEstacionDto create, EstacionDtoConverter converter){
        return repository.save((Estacion) converter.createEstacionDtoTEstacion(create));
    }

    public Estacion save(Estacion e){
        return repository.save(e);
    }

    public Estacion edit(CreateEstacionDto create, Estacion e){
        e.setNombre(create.getNombre());
        e.setMarca(create.getMarca());
        e.setFechaApertura(create.getFechaApertura());
        e.setServicios(create.getServicios());
        e.setPrecioGasoilEspecial(create.getPrecioGasoilEspecial());
        e.setPrecioGasoleoNormal(create.getPrecioGasoleoNormal());
        e.setPrecioGasolina95Octanos(create.getPrecioGasolina95Octanos());
        e.setPrecioGasolina98(create.getPrecioGasolina98());
        e.setTieneAutolavado(create.isTieneAutolavado());
        e.setUbicacion(create.getUbicacion());
        return repository.save(e);
    }

    public void deleteById(Estacion e){
        repository.delete(e);
    }

}
