package com.grupo7.dsi.tpai.service;

import com.grupo7.dsi.tpai.models.ModeloSismografo;
import com.grupo7.dsi.tpai.models.ModeloSismografoId;
import com.grupo7.dsi.tpai.service.repository.ModeloSismografoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ModeloSismografoService {

    private final ModeloSismografoRepository modeloSismografoRepository;

    public ModeloSismografoService(ModeloSismografoRepository modeloSismografoRepository) {
        this.modeloSismografoRepository = modeloSismografoRepository;
    }

    public List<ModeloSismografo> findAll() {
        return modeloSismografoRepository.findAll();
    }

    public Optional<ModeloSismografo> findById(ModeloSismografoId id) {
        return modeloSismografoRepository.findById(id);
    }

    public ModeloSismografo save(ModeloSismografo modelo) {
        return modeloSismografoRepository.save(modelo);
    }

    public void deleteById(ModeloSismografoId id) {
        modeloSismografoRepository.deleteById(id);
    }
}
