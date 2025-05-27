package com.grupo7.dsi.tpai.service;

import com.grupo7.dsi.tpai.models.SerieTemporal;
import com.grupo7.dsi.tpai.models.SerieTemporalId;
import com.grupo7.dsi.tpai.service.repository.SerieTemporalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SerieTemporalService {

    @Autowired
    private SerieTemporalRepository serieTemporalRepository;

    public List<SerieTemporal> findAll() {
        return serieTemporalRepository.findAll();
    }

    public Optional<SerieTemporal> findById(SerieTemporalId id) {
        return serieTemporalRepository.findById(id);
    }

    public SerieTemporal save(SerieTemporal serieTemporal) {
        return serieTemporalRepository.save(serieTemporal);
    }

    public void deleteById(SerieTemporalId id) {
        serieTemporalRepository.deleteById(id);
    }
}