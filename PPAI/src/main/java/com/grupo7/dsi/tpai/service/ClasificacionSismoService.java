package com.grupo7.dsi.tpai.service;

import com.grupo7.dsi.tpai.models.ClasificacionSismo;
import com.grupo7.dsi.tpai.service.repository.ClasificacionSismoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClasificacionSismoService {

    @Autowired
    private final ClasificacionSismoRepository clasificacionSismoRepository;

    public ClasificacionSismoService(ClasificacionSismoRepository clasificacionSismoRepository) {
        this.clasificacionSismoRepository = clasificacionSismoRepository;
    }

    public ClasificacionSismo save(ClasificacionSismo cs) {
        return clasificacionSismoRepository.save(cs);
    }

    public List<ClasificacionSismo> findAll() {
        return clasificacionSismoRepository.findAll();
    }

    public Optional<ClasificacionSismo> findById(String nombre) {
        return clasificacionSismoRepository.findById(nombre);
    }

    public void deleteById(String nombre) {
        clasificacionSismoRepository.deleteById(nombre);
    }
}
