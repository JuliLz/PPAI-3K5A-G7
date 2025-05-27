package com.grupo7.dsi.tpai.service.repository;

import com.grupo7.dsi.tpai.models.TipoTrabajo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoTrabajoRepository extends JpaRepository<TipoTrabajo, String> {
}
