package com.grupo7.dsi.tpai.service;

import com.grupo7.dsi.tpai.models.OrdenDeInspeccion;
import com.grupo7.dsi.tpai.service.repository.OrdenDeInspeccionRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class OrdenDeInspeccionService {

    private final OrdenDeInspeccionRepository repository;

    public OrdenDeInspeccionService(OrdenDeInspeccionRepository repository) {
        this.repository = repository;
    }

    public List<OrdenDeInspeccion> findAll() {
        return repository.findAll();
    }

    public Optional<OrdenDeInspeccion> findById(Integer numeroOrden) {
        return repository.findById(numeroOrden);
    }

    public OrdenDeInspeccion save(OrdenDeInspeccion orden) {
        return repository.save(orden);
    }

    public void deleteById(Integer numeroOrden) {
        repository.deleteById(numeroOrden);
    }
}