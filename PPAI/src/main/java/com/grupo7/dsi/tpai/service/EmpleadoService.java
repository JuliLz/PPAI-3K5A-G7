package com.grupo7.dsi.tpai.service;

import com.grupo7.dsi.tpai.models.Empleado;
import com.grupo7.dsi.tpai.service.repository.EmpleadoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpleadoService {

    private final EmpleadoRepository repository;

    public EmpleadoService(EmpleadoRepository repository) {
        this.repository = repository;
    }

    public Optional<Empleado> findById(Integer id) {
        return repository.findById(id);
    }

    public List<Empleado> findAll() {
        return repository.findAll();
    }

    public Empleado save(Empleado empleado) {
        return repository.save(empleado);
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
