package com.grupo7.dsi.tpai.service;

import com.grupo7.dsi.tpai.models.MagnitudRichter;
import com.grupo7.dsi.tpai.service.repository.MagnitudRichterRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MagnitudRichterService {

    private final MagnitudRichterRepository magnitudRichterRepository;

    public MagnitudRichterService(MagnitudRichterRepository magnitudRichterRepository) {
        this.magnitudRichterRepository = magnitudRichterRepository;
    }

    public MagnitudRichter save(MagnitudRichter magnitud) {
        return magnitudRichterRepository.save(magnitud);
    }

    public List<MagnitudRichter> findAll() {
        return magnitudRichterRepository.findAll();
    }

    public Optional<MagnitudRichter> findById(Float numero) {
        return magnitudRichterRepository.findById(numero);
    }

    public void deleteById(Float numero) {
        magnitudRichterRepository.deleteById(numero);
    }
}
