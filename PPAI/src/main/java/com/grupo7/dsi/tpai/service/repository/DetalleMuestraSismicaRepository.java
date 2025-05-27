package com.grupo7.dsi.tpai.service.repository;

import com.grupo7.dsi.tpai.models.DetalleMuestraSismica;
import com.grupo7.dsi.tpai.models.DetalleMuestraSismicaId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DetalleMuestraSismicaRepository extends JpaRepository<DetalleMuestraSismica, DetalleMuestraSismicaId> {
    // Podés agregar métodos personalizados si querés
}
