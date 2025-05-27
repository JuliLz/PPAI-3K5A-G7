package com.grupo7.dsi.tpai.service;

import com.grupo7.dsi.tpai.models.Sismografo;
import com.grupo7.dsi.tpai.service.repository.SismografoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SismografoService {

    @Autowired
    private SismografoRepository sismografoRepository;

    public List<Sismografo> findAll() {
        return sismografoRepository.findAll();
    }

    public Optional<Sismografo> findById(Integer id) {
        return sismografoRepository.findById(id);
    }

    public Sismografo save(Sismografo sismografo) {
        return sismografoRepository.save(sismografo);
    }

    public void deleteById(Integer id) {
        sismografoRepository.deleteById(id);
    }
}