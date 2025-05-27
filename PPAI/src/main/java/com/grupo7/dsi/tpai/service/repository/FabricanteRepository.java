package com.grupo7.dsi.tpai.service.repository;

import com.grupo7.dsi.tpai.models.Fabricante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FabricanteRepository extends JpaRepository<Fabricante, String> {
}