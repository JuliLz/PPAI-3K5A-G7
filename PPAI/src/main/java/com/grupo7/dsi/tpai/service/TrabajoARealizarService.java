package com.grupo7.dsi.tpai.service;

import com.grupo7.dsi.tpai.models.TrabajoARealizar;
import com.grupo7.dsi.tpai.service.repository.TrabajoARealizarRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrabajoARealizarService {

    private final TrabajoARealizarRepository repository;

    public TrabajoARealizarService(TrabajoARealizarRepository repository) {
        this.repository = repository;
    }

    public Optional<TrabajoARealizar> findById(Integer id) {
        return repository.findById(id);
    }

    public List<TrabajoARealizar> findAll() {
        return repository.findAll();
    }

    public TrabajoARealizar save(TrabajoARealizar trabajo) {
        return repository.save(trabajo);
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
