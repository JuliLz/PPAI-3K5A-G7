package com.grupo7.dsi.tpai.service;

import com.grupo7.dsi.tpai.models.AlcanceSismo;
import com.grupo7.dsi.tpai.service.repository.AlcanceSismoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlcanceSismoService {

    private final AlcanceSismoRepository alcanceSismoRepository;

    public AlcanceSismoService(AlcanceSismoRepository alcanceSismoRepository) {
        this.alcanceSismoRepository = alcanceSismoRepository;
    }

    // Buscar todos los AlcanceSismo
    public List<AlcanceSismo> findAll() {
        return alcanceSismoRepository.findAll();
    }

    // Buscar por nombre
    public Optional<AlcanceSismo> findByNombre(String nombre) {
        return alcanceSismoRepository.findById(nombre);
    }

    // Guardar nuevo, validando que no exista previamente
    public AlcanceSismo save(AlcanceSismo alcanceSismo) {
        return alcanceSismoRepository.save(alcanceSismo);

    }

    // Actualizar uno existente
    public AlcanceSismo update(AlcanceSismo alcanceSismo) {
        if (!alcanceSismoRepository.existsById(alcanceSismo.getNombre())) {
            throw new IllegalStateException("No se puede actualizar: el alcance no existe");
        }
        return alcanceSismoRepository.save(alcanceSismo);
    }

    // Eliminar por nombre
    public void deleteByNombre(String nombre) {
        if (!alcanceSismoRepository.existsById(nombre)) {
            throw new IllegalStateException("No se puede eliminar: el alcance no existe");
        }
        alcanceSismoRepository.deleteById(nombre);
    }
}