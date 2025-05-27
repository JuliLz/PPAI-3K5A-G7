package com.grupo7.dsi.tpai.service.repository;

import com.grupo7.dsi.tpai.models.ModeloSismografo;
import com.grupo7.dsi.tpai.models.ModeloSismografoId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModeloSismografoRepository extends JpaRepository<ModeloSismografo, ModeloSismografoId> {
}
