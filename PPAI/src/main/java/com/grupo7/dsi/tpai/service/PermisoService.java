package com.grupo7.dsi.tpai.service;

import com.grupo7.dsi.tpai.models.Permiso;
import com.grupo7.dsi.tpai.service.repository.PermisoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PermisoService {

    private final PermisoRepository permisoRepo;

    public PermisoService(PermisoRepository permisoRepo) {
        this.permisoRepo = permisoRepo;
    }

    // Guardar un nuevo Permiso
    public Permiso save(Permiso permiso) {
        return permisoRepo.save(permiso);
    }

    // Obtener todos los Permisos
    public List<Permiso> findAll() {
        return permisoRepo.findAll();
    }

    // Buscar por nombre (clave primaria)
    public Optional<Permiso> findByNombre(String nombre) {
        return permisoRepo.findById(nombre);
    }

    // Eliminar por nombre
    public void deleteByNombre(String nombre) {
        permisoRepo.deleteById(nombre);
    }
}