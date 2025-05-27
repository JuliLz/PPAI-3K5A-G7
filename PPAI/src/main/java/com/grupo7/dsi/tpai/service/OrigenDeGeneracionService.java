package com.grupo7.dsi.tpai.service;

import com.grupo7.dsi.tpai.models.OrigenDeGeneracion;
import com.grupo7.dsi.tpai.service.repository.OrigenDeGeneracionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrigenDeGeneracionService {

    private final OrigenDeGeneracionRepository origenRepo;

    public OrigenDeGeneracionService(OrigenDeGeneracionRepository origenRepo) {
        this.origenRepo = origenRepo;
    }

    // Find all OrigenDeGeneracion
    public List<OrigenDeGeneracion> findAll() {
        return origenRepo.findAll();
    }

    // Find OrigenDeGeneracion by nombre
    public Optional<OrigenDeGeneracion> findByName(String nombre) {
        return origenRepo.findById(nombre);
    }

    // Guardar un nuevo OrigenDeGeneracion
    public OrigenDeGeneracion save(OrigenDeGeneracion origen) {
        return origenRepo.save(origen);
    }

    // Actualizar un OrigenDeGeneracion existente
    public void deleteByNombre(String nombre) {
        origenRepo.deleteById(nombre);
    }
}
