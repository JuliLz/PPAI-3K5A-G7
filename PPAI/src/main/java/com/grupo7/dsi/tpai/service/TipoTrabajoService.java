package com.grupo7.dsi.tpai.service;

import com.grupo7.dsi.tpai.models.TipoTrabajo;
import com.grupo7.dsi.tpai.service.repository.TipoTrabajoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TipoTrabajoService {

    private final TipoTrabajoRepository tipoTrabajoRepo;

    public TipoTrabajoService(TipoTrabajoRepository tipoTrabajoRepo) {
        this.tipoTrabajoRepo = tipoTrabajoRepo;
    }

    // Guardar un nuevo TipoTrabajo
    public TipoTrabajo save(TipoTrabajo tipoTrabajo) {
        return tipoTrabajoRepo.save(tipoTrabajo);
    }

    // Obtener todos los TipoTrabajo
    public List<TipoTrabajo> findAll() {
        return tipoTrabajoRepo.findAll();
    }

    // Buscar por nombre (clave primaria)
    public Optional<TipoTrabajo> findByNombre(String nombre) {
        return tipoTrabajoRepo.findById(nombre);
    }

    // Eliminar por nombre
    public void deleteByNombre(String nombre) {
        tipoTrabajoRepo.deleteById(nombre);
    }
}