package com.grupo7.dsi.tpai.service;

import com.grupo7.dsi.tpai.models.Rol;
import com.grupo7.dsi.tpai.service.repository.RolRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RolService {

    private final RolRepository rolRepository;

    public RolService(RolRepository rolRepository) {
        this.rolRepository = rolRepository;
    }

    public Rol save(Rol rol) {
        return rolRepository.save(rol);
    }

    public List<Rol> findAll() {
        return rolRepository.findAll();
    }

    public Optional<Rol> findById(String nombre) {
        return rolRepository.findById(nombre);
    }

    public void deleteById(String nombre) {
        rolRepository.deleteById(nombre);
    }
}
