package com.CineJaro.factories;

import com.CineJaro.models.Serie;
import com.CineJaro.dto.SerieDTO;
import org.springframework.stereotype.Component;

@Component
public class SerieFactory implements ContenidoFactory<Serie, SerieDTO> {
    @Override
    public Serie crearContenido(SerieDTO dto) {
        Serie serie = new Serie();
        serie.setNombreSerie(dto.getNombreSerie());
        serie.setDuracion(dto.getDuracion());
        serie.setGenero(dto.getGenero());
        serie.setFechaEstreno(dto.getFechaEstreno());
        serie.setPais(dto.getPais());
        serie.setImg(dto.getImg());
        return serie;
    }
}
