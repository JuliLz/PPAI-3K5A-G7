package com.grupo7.dsi.tpai.service;

import com.grupo7.dsi.tpai.models.Fabricante;
import com.grupo7.dsi.tpai.service.repository.FabricanteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FabricanteService {

    private final FabricanteRepository fabricanteRepository;

    public FabricanteService(FabricanteRepository fabricanteRepository) {
        this.fabricanteRepository = fabricanteRepository;
    }

    public Fabricante save(Fabricante fabricante) {
        return fabricanteRepository.save(fabricante);
    }

    public List<Fabricante> findAll() {
        return fabricanteRepository.findAll();
    }

    public Optional<Fabricante> findById(String nombre) {
        return fabricanteRepository.findById(nombre);
    }

    public void deleteById(String nombre) {
        fabricanteRepository.deleteById(nombre);
    }
}