package com.grupo7.dsi.tpai.service;

import com.grupo7.dsi.tpai.models.Suscripcion;
import com.grupo7.dsi.tpai.service.repository.SuscripcionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SuscripcionService {

    private final SuscripcionRepository suscripcionRepository;

    public SuscripcionService(SuscripcionRepository suscripcionRepository) {
        this.suscripcionRepository = suscripcionRepository;
    }

    public Suscripcion save(Suscripcion suscripcion) {
        return suscripcionRepository.save(suscripcion);
    }

    public Optional<Suscripcion> findById(Long id) {
        return suscripcionRepository.findById(id);
    }

    public List<Suscripcion> findAll() {
        return suscripcionRepository.findAll();
    }

    public void deleteById(Long id) {
        suscripcionRepository.deleteById(id);
    }
}
