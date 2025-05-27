package com.grupo7.dsi.tpai.service;

import com.grupo7.dsi.tpai.models.EventoSismico;
import com.grupo7.dsi.tpai.models.EventoSismicoId;
import com.grupo7.dsi.tpai.service.repository.EventoSismicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventoSismicoService {

    private final EventoSismicoRepository eventoSismicoRepository;

    @Autowired
    public EventoSismicoService(EventoSismicoRepository eventoSismicoRepository) {
        this.eventoSismicoRepository = eventoSismicoRepository;
    }

    public List<EventoSismico> findAll() {
        return eventoSismicoRepository.findAll();
    }

    public Optional<EventoSismico> findById(EventoSismicoId id) {
        return eventoSismicoRepository.findById(id);
    }

    public EventoSismico save(EventoSismico evento) {
        return eventoSismicoRepository.save(evento);
    }

    public void deleteById(EventoSismicoId id) {
        eventoSismicoRepository.deleteById(id);
    }
}