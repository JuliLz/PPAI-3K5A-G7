package com.grupo7.dsi.tpai.service;


import com.grupo7.dsi.tpai.models.DetalleMuestraSismica;
import com.grupo7.dsi.tpai.models.DetalleMuestraSismicaId;
import com.grupo7.dsi.tpai.service.repository.DetalleMuestraSismicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DetalleMuestraSismicaService {

    @Autowired
    private DetalleMuestraSismicaRepository repository;

    public DetalleMuestraSismica save(DetalleMuestraSismica detalle) {
        return repository.save(detalle);
    }

    public List<DetalleMuestraSismica> findAll() {
        return repository.findAll();
    }

    public DetalleMuestraSismica buscfindById(DetalleMuestraSismicaId id) {
        return repository.findById(id).orElse(null);
    }

    public void deleteById(DetalleMuestraSismicaId id) {
        repository.deleteById(id);
    }
}