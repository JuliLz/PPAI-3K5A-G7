package com.grupo7.dsi.tpai.service;

import com.grupo7.dsi.tpai.models.Reparacion;
import com.grupo7.dsi.tpai.service.repository.ReparacionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReparacionService {

    private final ReparacionRepository reparacionRepository;

    public ReparacionService(ReparacionRepository reparacionRepository) {
        this.reparacionRepository = reparacionRepository;
    }

    // Guardar una reparación
    public Reparacion save(Reparacion reparacion) {
        return reparacionRepository.save(reparacion);
    }

    // Obtener todas las reparaciones
    public List<Reparacion> findAll() {
        return reparacionRepository.findAll();
    }

    // Buscar por nroReparacion
    public Optional<Reparacion> findById(Integer id) {
        return reparacionRepository.findById(id);
    }

    // Eliminar por nroReparacion
    public void deleteById(Integer id) {
        reparacionRepository.deleteById(id);
    }
}