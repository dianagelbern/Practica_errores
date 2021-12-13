package com.manejoerrores.practica.service;

import com.manejoerrores.practica.model.Estacion;
import com.manejoerrores.practica.repository.EstacionRepository;
import com.manejoerrores.practica.service.base.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EstacionService extends BaseService<Estacion, Long, EstacionRepository> {

    @Override
    public List<Estacion> findAll() {
        return super.findAll();
    }

    @Override
    public Optional<Estacion> findById(Long aLong) {
        return super.findById(aLong);
    }

    @Override
    public Estacion save(Estacion estacion) {
        return super.save(estacion);
    }

    @Override
    public Estacion edit(Estacion estacion) {
        return super.edit(estacion);
    }

    @Override
    public void delete(Estacion estacion) {
        super.delete(estacion);
    }

    @Override
    public void deleteById(Long aLong) {
        super.deleteById(aLong);
    }
}
