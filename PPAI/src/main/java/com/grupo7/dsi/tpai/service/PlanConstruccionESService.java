package com.grupo7.dsi.tpai.service;

import com.grupo7.dsi.tpai.models.PlanConstruccionES;
import com.grupo7.dsi.tpai.service.repository.PlanConstruccionESRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlanConstruccionESService {

    @Autowired
    private PlanConstruccionESRepository repository;

    public List<PlanConstruccionES> findAll() {
        return repository.findAll();
    }

    public Optional<PlanConstruccionES> findById(Integer id) {
        return repository.findById(id);
    }

    public PlanConstruccionES save(PlanConstruccionES plan) {
        return repository.save(plan);
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}