package com.CineJaro.services;

import com.CineJaro.models.Pelicula;
import com.CineJaro.repositories.PeliculaRepository;
import com.CineJaro.dto.PeliculaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import com.CineJaro.exceptions.ResourceNotFoundException;

@Service
public class PeliculaService {
    @Autowired
    private PeliculaRepository peliculaRepository;

    public List<Pelicula> getAllPeliculas() {
        System.out.println("Obteniendo todas las películas");
        List<Pelicula> peliculas = peliculaRepository.findAll();
        System.out.println("Número de películas obtenidas: " + peliculas.size());
        return peliculas;
    }
    public Pelicula crearPelicula(PeliculaDTO peliculaDTO) {
        Pelicula pelicula = new Pelicula();
        pelicula.setNombrePelicula(peliculaDTO.getNombrePelicula());
        pelicula.setDuracion(peliculaDTO.getDuracion());
        pelicula.setGenero(peliculaDTO.getGenero());
        pelicula.setFechaEstreno(peliculaDTO.getFechaEstreno());
        pelicula.setPais(peliculaDTO.getPais());
        pelicula.setImg(peliculaDTO.getImg());
        return peliculaRepository.save(pelicula);
    }

    public Pelicula editarPelicula(Long id, PeliculaDTO peliculaDTO) {
        Pelicula pelicula = peliculaRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Película no encontrada con id: " + id));
        pelicula.setNombrePelicula(peliculaDTO.getNombrePelicula());
        pelicula.setDuracion(peliculaDTO.getDuracion());
        pelicula.setGenero(peliculaDTO.getGenero());
        pelicula.setFechaEstreno(peliculaDTO.getFechaEstreno());
        pelicula.setPais(peliculaDTO.getPais());
        pelicula.setImg(peliculaDTO.getImg());
        return peliculaRepository.save(pelicula);
    }

    public void eliminarPelicula(Long id) {
        if (!peliculaRepository.existsById(id)) {
            throw new ResourceNotFoundException("Película no encontrada con id: " + id);
        }
        peliculaRepository.deleteById(id);
    }

    public Pelicula getPeliculaById(Long id) {
        return peliculaRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Película no encontrada con id: " + id));
    }

    // 
}