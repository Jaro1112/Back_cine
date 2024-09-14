package com.CineJaro.controllers;

import com.CineJaro.models.Pelicula;
import com.CineJaro.services.PeliculaService;
import com.CineJaro.dto.PeliculaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/api/peliculas")
public class PeliculaController {
    @Autowired
    private PeliculaService peliculaService;

    @GetMapping
    public List<Pelicula> getAllPeliculas() {
        return peliculaService.getAllPeliculas();
    }   

    @PostMapping("/crear-pelicula")
    public ResponseEntity<Pelicula> crearPelicula(@Valid @RequestBody PeliculaDTO peliculaDTO) {
        return ResponseEntity.ok(peliculaService.crearPelicula(peliculaDTO));
    }

    @PutMapping("/editar-pelicula/{id}")
    public ResponseEntity<Pelicula> editarPelicula(@PathVariable Long id, @RequestBody PeliculaDTO peliculaDTO) {
        return ResponseEntity.ok(peliculaService.editarPelicula(id, peliculaDTO));
    }

    @DeleteMapping("/eliminar-pelicula/{id}")
    public ResponseEntity<?> eliminarPelicula(@PathVariable Long id) {
        peliculaService.eliminarPelicula(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pelicula> getPeliculaById(@PathVariable Long id) {
        return ResponseEntity.ok(peliculaService.getPeliculaById(id));
    }
}