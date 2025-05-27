package com.grupo7.dsi.tpai.service;

import com.grupo7.dsi.tpai.models.MotivoFueraServicio;
import com.grupo7.dsi.tpai.service.repository.MotivoFueraServicioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MotivoFueraServicioService {

    private final MotivoFueraServicioRepository repository;

    public MotivoFueraServicioService(MotivoFueraServicioRepository repository) {
        this.repository = repository;
    }

    public MotivoFueraServicio save(MotivoFueraServicio motivo) {
        return repository.save(motivo);
    }

    public Optional<MotivoFueraServicio> findById(String comentario) {
        return repository.findById(comentario);
    }

    public List<MotivoFueraServicio> findAll() {
        return repository.findAll();
    }

    public void deleteById(String comentario) {
        repository.deleteById(comentario);
    }
}
