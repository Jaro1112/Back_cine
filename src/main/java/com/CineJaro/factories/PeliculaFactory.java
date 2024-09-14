package com.CineJaro.factories;

import com.CineJaro.models.Pelicula;
import com.CineJaro.dto.PeliculaDTO;
import org.springframework.stereotype.Component;

@Component
public class PeliculaFactory implements ContenidoFactory<Pelicula, PeliculaDTO> {
    @Override
    public Pelicula crearContenido(PeliculaDTO dto) {
        Pelicula pelicula = new Pelicula();
        pelicula.setNombrePelicula(dto.getNombrePelicula());
        pelicula.setDuracion(dto.getDuracion());
        pelicula.setGenero(dto.getGenero());
        pelicula.setFechaEstreno(dto.getFechaEstreno());
        pelicula.setPais(dto.getPais());
        pelicula.setImg(dto.getImg());
        return pelicula;
    }
}
