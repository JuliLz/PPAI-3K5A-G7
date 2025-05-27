package com.grupo7.dsi.tpai.service;

import com.grupo7.dsi.tpai.models.MotivoTipo;
import com.grupo7.dsi.tpai.service.repository.MotivoTipoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MotivoTipoService {

    private final MotivoTipoRepository motivoTipoRepo;

    public MotivoTipoService(MotivoTipoRepository motivoTipoRepo) {
        this.motivoTipoRepo = motivoTipoRepo;
    }

    // Guardar un nuevo MotivoTipo
    public MotivoTipo save(MotivoTipo motivo) {
        return motivoTipoRepo.save(motivo);
    }

    // Obtener todos los MotivoTipo
    public List<MotivoTipo> findAll() {
        return motivoTipoRepo.findAll();
    }

    // Buscar por descripcion (clave primaria)
    public Optional<MotivoTipo> findByDescripcion(String descripcion) {
        return motivoTipoRepo.findById(descripcion);
    }

    // Eliminar por descripcion
    public void deleteByDescripcion(String descripcion) {
        motivoTipoRepo.deleteById(descripcion);
    }
}