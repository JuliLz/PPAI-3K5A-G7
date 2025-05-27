package com.grupo7.dsi.tpai.service.repository;

import com.grupo7.dsi.tpai.models.SerieTemporal;
import com.grupo7.dsi.tpai.models.SerieTemporalId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SerieTemporalRepository extends JpaRepository<SerieTemporal, SerieTemporalId> {
}