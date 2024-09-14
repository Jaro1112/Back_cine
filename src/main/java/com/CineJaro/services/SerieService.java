package com.CineJaro.services;

import com.CineJaro.factories.SerieFactory;
import com.CineJaro.models.Serie;
import com.CineJaro.repositories.SerieRepository;
import com.CineJaro.dto.SerieDTO;
import com.CineJaro.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SerieService {
    @Autowired
    private SerieRepository serieRepository;

    @Autowired
    private SerieFactory serieFactory;

    public List<Serie> getAllSeries() {
        return serieRepository.findAll();
    }

    public Serie crearSerie(SerieDTO serieDTO) {
        Serie serie = serieFactory.crearContenido(serieDTO);
        return serieRepository.save(serie);
    }

    public Serie editarSerie(Long id, SerieDTO serieDTO) {
        Serie serie = serieRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Serie no encontrada con id: " + id));
        serie.setNombreSerie(serieDTO.getNombreSerie());
        serie.setDuracion(serieDTO.getDuracion());
        serie.setGenero(serieDTO.getGenero());
        serie.setFechaEstreno(serieDTO.getFechaEstreno());
        serie.setPais(serieDTO.getPais());
        serie.setImg(serieDTO.getImg());
        return serieRepository.save(serie);
    }

    public void eliminarSerie(Long id) {
        if (!serieRepository.existsById(id)) {
            throw new ResourceNotFoundException("Serie no encontrada con id: " + id);
        }
        serieRepository.deleteById(id);
    }

    public Serie getSerieById(Long id) {
        return serieRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Serie no encontrada con id: " + id));
    }
}