package com.grupo7.dsi.tpai.service;

import com.grupo7.dsi.tpai.models.Perfil;
import com.grupo7.dsi.tpai.service.repository.PerfilRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PerfilService {

    private final PerfilRepository perfilRepository;

    public PerfilService(PerfilRepository perfilRepository) {
        this.perfilRepository = perfilRepository;
    }

    public Perfil save(Perfil perfil) {
        return perfilRepository.save(perfil);
    }

    public List<Perfil> findAll() {
        return perfilRepository.findAll();
    }

    public Optional<Perfil> findById(String nombre) {
        return perfilRepository.findById(nombre);
    }

    public void deleteById(String nombre) {
        perfilRepository.deleteById(nombre);
    }
}
