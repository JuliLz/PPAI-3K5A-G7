package com.grupo7.dsi.tpai.service;

import com.grupo7.dsi.tpai.models.ApreciacionTipo;
import com.grupo7.dsi.tpai.service.repository.ApreciacionTipoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ApreciacionTipoService {

    private final ApreciacionTipoRepository apreciacionTipoRepository;

    public ApreciacionTipoService(ApreciacionTipoRepository apreciacionTipoRepository) {
        this.apreciacionTipoRepository = apreciacionTipoRepository;
    }

    public ApreciacionTipo save(ApreciacionTipo apreciacionTipo) {
        return apreciacionTipoRepository.save(apreciacionTipo);
    }

    public List<ApreciacionTipo> findAll() {
        return apreciacionTipoRepository.findAll();
    }

    public Optional<ApreciacionTipo> findById(String color) {
        return apreciacionTipoRepository.findById(color);
    }

    public void deleteById(String color) {
        apreciacionTipoRepository.deleteById(color);
    }
}
