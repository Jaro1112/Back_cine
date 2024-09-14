package com.CineJaro.services;

import com.CineJaro.factories.PeliculaFactory;
import com.CineJaro.models.Pelicula;
import com.CineJaro.repositories.PeliculaRepository;
import com.CineJaro.dto.PeliculaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.CacheEvict;

import java.util.List;
import com.CineJaro.exceptions.ResourceNotFoundException;

@Service
public class PeliculaService {
    @Autowired
    private PeliculaRepository peliculaRepository;
    
    @Autowired
    private PeliculaFactory peliculaFactory;

    @Cacheable("peliculas")
    public List<Pelicula> getAllPeliculas() {
        System.out.println("Obteniendo todas las películas de la base de datos");
        List<Pelicula> peliculas = peliculaRepository.findAll();
        System.out.println("Número de películas obtenidas: " + peliculas.size());
        return peliculas;
    }

    @CacheEvict(value = "peliculas", allEntries = true)
    public Pelicula crearPelicula(PeliculaDTO peliculaDTO) {
        Pelicula pelicula = peliculaFactory.crearContenido(peliculaDTO);
        return peliculaRepository.save(pelicula);
    }

    @Cacheable(value = "peliculas", key = "#id")
    public Pelicula getPeliculaById(Long id) {
        return peliculaRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Película no encontrada con id: " + id));
    }

    @CacheEvict(value = "peliculas", allEntries = true)
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

    @CacheEvict(value = "peliculas", allEntries = true)
    public void eliminarPelicula(Long id) {
        if (!peliculaRepository.existsById(id)) {
            throw new ResourceNotFoundException("Película no encontrada con id: " + id);
        }
        peliculaRepository.deleteById(id);
    }

    // 
}