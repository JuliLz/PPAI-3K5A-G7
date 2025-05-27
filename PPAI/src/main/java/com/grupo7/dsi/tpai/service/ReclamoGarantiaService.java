package com.grupo7.dsi.tpai.service;

import com.grupo7.dsi.tpai.models.ReclamoGarantia;
import com.grupo7.dsi.tpai.service.repository.ReclamoGarantiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReclamoGarantiaService {

    @Autowired
    private ReclamoGarantiaRepository reclamoRepository;

    public ReclamoGarantia create(ReclamoGarantia claim) {
        return reclamoRepository.save(claim);
    }

    public ReclamoGarantia findById(Integer id) {
        return reclamoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No se encuentra el reclamo con la id: " + id));
    }

    public List<ReclamoGarantia> findAll() {
        return reclamoRepository.findAll();
    }

    public void deleteById(Integer id) {
        ReclamoGarantia existing = findById(id);
        reclamoRepository.delete(existing);
    }
}