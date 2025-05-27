package com.grupo7.dsi.tpai.service;

import com.grupo7.dsi.tpai.models.MuestraSismica;
import com.grupo7.dsi.tpai.service.repository.MuestraSismicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MuestraSismicaService {

    @Autowired
    private MuestraSismicaRepository muestraSismicaRepository;

    public List<MuestraSismica> findAll() {
        return muestraSismicaRepository.findAll();
    }

    public Optional<MuestraSismica> findById(Integer id) {
        return muestraSismicaRepository.findById(id);
    }

    public MuestraSismica save(MuestraSismica muestra) {
        return muestraSismicaRepository.save(muestra);
    }

    public void delete(Integer id) {
        muestraSismicaRepository.deleteById(id);
    }
}