package com.grupo7.dsi.tpai.service.repository;

import com.grupo7.dsi.tpai.models.Estado;
import com.grupo7.dsi.tpai.models.EstadoId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstadoRepository extends JpaRepository<Estado, EstadoId> {
}