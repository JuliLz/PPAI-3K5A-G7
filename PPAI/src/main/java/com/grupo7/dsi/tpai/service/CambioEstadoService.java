package com.grupo7.dsi.tpai.service;

import com.grupo7.dsi.tpai.models.CambioEstado;
import com.grupo7.dsi.tpai.models.CambioEstadoId;
import com.grupo7.dsi.tpai.service.repository.CambioEstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CambioEstadoService {

    @Autowired
    private CambioEstadoRepository repository;

    public List<CambioEstado> findAll() {
        return repository.findAll();
    }

    public Optional<CambioEstado> findById(CambioEstadoId id) {
        return repository.findById(id);
    }

    public CambioEstado save(CambioEstado cambioEstado) {
        return repository.save(cambioEstado);
    }

    public void deleteById(CambioEstadoId id) {
        repository.deleteById(id);
    }
}