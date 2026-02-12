package com.mcas2.first.controllers;

import com.mcas2.first.models.SocioModel;
import com.mcas2.first.repositories.SocioRepository;
import com.mcas2.first.services.SocioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class SocioController {
    private final SocioService socioService;

    public SocioController(SocioService socioService) {
        this.socioService = socioService;
    }

    @GetMapping("/socio/{id}")
    public ResponseEntity<SocioModel> encontrarPorID(@PathVariable("id") String id) {
        Optional<SocioModel> socioOpt = socioService.obtener(id);
        return socioOpt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/socios/todos")
    public List<SocioModel> listarSocios() {
        return socioService.listar();
    }

    @GetMapping("/socios")
    public List<SocioModel> filtrarSocios(
            @RequestParam(value = "nombre", required = false) String nombre,
            @RequestParam(value = "apellidos", required = false) String apellidos
    ) {
        if (nombre == null && apellidos == null) {
            return socioService.listar();
        }
        if (nombre == null) {
            return socioService.listar().stream().filter(socio -> socio.getApellidos().contains(apellidos)).toList();
        } else if (apellidos == null) {
            return socioService.listar().stream().filter(socio -> socio.getNombre().contains(nombre)).toList();
        } else {
            return socioService.listar().stream().filter(socio -> socio.getApellidos().contains(apellidos) && socio.getNombre().contains(nombre)).toList();
        }
    }
}
