package com.grupo7.dsi.tpai.service.repository;

import com.grupo7.dsi.tpai.models.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpleadoRepository extends JpaRepository<Empleado, Integer> {
}