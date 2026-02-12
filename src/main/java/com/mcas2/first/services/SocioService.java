package com.mcas2.first.services;

import com.mcas2.first.models.SocioModel;
import com.mcas2.first.repositories.SocioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SocioService {
    private final SocioRepository socioRepository;

    public SocioService(SocioRepository socioRepository) {
        this.socioRepository = socioRepository;
    }

    public Optional<SocioModel> obtener(String id) {
        return socioRepository.findById(id);
    }

    public List<SocioModel> listar(){
        List<SocioModel> socios = socioRepository.findAll();
        if (socios.isEmpty()) {
            System.out.println("DEBUG: SocioDDBB vacía, no preocuparse.");
        }
        return socios;
    }
}
