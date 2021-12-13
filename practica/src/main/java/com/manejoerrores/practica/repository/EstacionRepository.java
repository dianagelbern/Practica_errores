package com.manejoerrores.practica.repository;

import com.manejoerrores.practica.model.Estacion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstacionRepository extends JpaRepository<Estacion, Long> {
}
