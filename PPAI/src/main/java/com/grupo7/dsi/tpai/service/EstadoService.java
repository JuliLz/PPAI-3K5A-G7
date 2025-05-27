package com.grupo7.dsi.tpai.service;

import com.grupo7.dsi.tpai.models.Estado;
import com.grupo7.dsi.tpai.models.EstadoId;
import com.grupo7.dsi.tpai.service.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstadoService {

    @Autowired
    private EstadoRepository estadoRepository;

    public List<Estado> findAll() {
        return estadoRepository.findAll();
    }

    public Optional<Estado> findById(String nombre, String ambito) {
        EstadoId id = new EstadoId(nombre, ambito);
        return estadoRepository.findById(id);
    }

    public Estado save(Estado estado) {
        return estadoRepository.save(estado);
    }

    public void deleteById(String nombre, String ambito) {
        EstadoId id = new EstadoId(nombre, ambito);
        estadoRepository.deleteById(id);
    }
}