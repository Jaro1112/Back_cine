package com.CineJaro.controllers;

import com.CineJaro.models.Serie;
import com.CineJaro.services.SerieService;
import com.CineJaro.dto.SerieDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/api/series")
public class SerieController {
    @Autowired
    private SerieService serieService;

    @GetMapping
    public List<Serie> getAllSeries() {
        return serieService.getAllSeries();
    }

    @PostMapping("/crear-serie")
    public ResponseEntity<Serie> crearSerie(@Valid @RequestBody SerieDTO serieDTO) {
        return ResponseEntity.ok(serieService.crearSerie(serieDTO));
    }

    @PutMapping("/editar-serie/{id}")
    public ResponseEntity<Serie> editarSerie(@PathVariable Long id, @Valid @RequestBody SerieDTO serieDTO) {
        return ResponseEntity.ok(serieService.editarSerie(id, serieDTO));
    }

    @DeleteMapping("/eliminar-serie/{id}")
    public ResponseEntity<?> eliminarSerie(@PathVariable Long id) {
        serieService.eliminarSerie(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Serie> getSerieById(@PathVariable Long id) {
        return ResponseEntity.ok(serieService.getSerieById(id));
    }
}