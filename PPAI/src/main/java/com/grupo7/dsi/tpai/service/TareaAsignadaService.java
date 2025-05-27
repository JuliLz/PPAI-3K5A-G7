package com.grupo7.dsi.tpai.service;

import com.grupo7.dsi.tpai.models.TareaAsignada;
import com.grupo7.dsi.tpai.service.repository.TareaAsignadaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TareaAsignadaService {

    @Autowired
    private TareaAsignadaRepository tareaAsignadaRepository;

    public TareaAsignada save(TareaAsignada tareaAsignada) {
        return tareaAsignadaRepository.save(tareaAsignada);
    }

    public List<TareaAsignada> findAll() {
        return tareaAsignadaRepository.findAll();
    }

    public Optional<TareaAsignada> findById(Integer id) {
        return tareaAsignadaRepository.findById(id);
    }

    public void deleteById(Integer id) {
        tareaAsignadaRepository.deleteById(id);
    }
}
