package main.java.com.CineJaro.services;

import com.mycineavg.models.Pelicula;
import com.mycineavg.repositories.PeliculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PeliculaService {
    @Autowired
    private PeliculaRepository peliculaRepository;

    public List<Pelicula> getAllPeliculas() {
        return peliculaRepository.findAll();
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