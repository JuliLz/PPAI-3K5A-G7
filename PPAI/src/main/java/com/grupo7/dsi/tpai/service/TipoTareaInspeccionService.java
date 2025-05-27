package com.grupo7.dsi.tpai.service;

import com.grupo7.dsi.tpai.models.TipoTareaInspeccion;
import com.grupo7.dsi.tpai.service.repository.TipoTareaInspeccionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TipoTareaInspeccionService {

    private final TipoTareaInspeccionRepository tipoTareaInspeccionRepository;

    public TipoTareaInspeccionService(TipoTareaInspeccionRepository tipoTareaInspeccionRepository) {
        this.tipoTareaInspeccionRepository = tipoTareaInspeccionRepository;
    }

    public TipoTareaInspeccion save(TipoTareaInspeccion tipo) {
        return tipoTareaInspeccionRepository.save(tipo);
    }

    public List<TipoTareaInspeccion> findAll() {
        return tipoTareaInspeccionRepository.findAll();
    }

    public Optional<TipoTareaInspeccion> findById(Integer codigo) {
        return tipoTareaInspeccionRepository.findById(codigo);
    }

    public void deleteById(Integer codigo) {
        tipoTareaInspeccionRepository.deleteById(codigo);
    }
}
