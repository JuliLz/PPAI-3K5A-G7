package com.grupo7.dsi.tpai.service;

import com.grupo7.dsi.tpai.models.EstacionSismologica;
import com.grupo7.dsi.tpai.service.repository.EstacionSismologicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstacionSismologicaService {

    @Autowired
    private EstacionSismologicaRepository estacionRepo;

    public EstacionSismologica save(EstacionSismologica estacion) {
        return estacionRepo.save(estacion);
    }

    public Optional<EstacionSismologica> findById(Integer id) {
        return estacionRepo.findById(id);
    }

    public List<EstacionSismologica> findAll() {
        return estacionRepo.findAll();
    }

    public void deleteById(Integer id) {
        estacionRepo.deleteById(id);
    }
}