package com.grupo7.dsi.tpai.service.repository;

import com.grupo7.dsi.tpai.models.OrdenDeInspeccion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdenDeInspeccionRepository extends JpaRepository<OrdenDeInspeccion, Integer> {
    // Podés agregar métodos personalizados si los necesitás
}