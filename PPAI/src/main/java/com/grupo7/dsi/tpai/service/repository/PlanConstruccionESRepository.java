package com.grupo7.dsi.tpai.service.repository;

import com.grupo7.dsi.tpai.models.PlanConstruccionES;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanConstruccionESRepository extends JpaRepository<PlanConstruccionES, Integer> {
}