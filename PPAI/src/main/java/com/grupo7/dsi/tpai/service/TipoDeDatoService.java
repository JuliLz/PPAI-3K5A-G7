package com.grupo7.dsi.tpai.service;

import com.grupo7.dsi.tpai.models.TipoDeDato;
import com.grupo7.dsi.tpai.service.repository.TipoDeDatoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TipoDeDatoService {

    private final TipoDeDatoRepository tipoDeDatoRepository;

    public TipoDeDatoService(TipoDeDatoRepository tipoDeDatoRepository) {
        this.tipoDeDatoRepository = tipoDeDatoRepository;
    }

    public TipoDeDato save(TipoDeDato tipo) {
        return tipoDeDatoRepository.save(tipo);
    }

    public List<TipoDeDato> findAll() {
        return tipoDeDatoRepository.findAll();
    }

    public Optional<TipoDeDato> findById(String denominacion) {
        return tipoDeDatoRepository.findById(denominacion);
    }

    public void deleteById(String denominacion) {
        tipoDeDatoRepository.deleteById(denominacion);
    }
}
