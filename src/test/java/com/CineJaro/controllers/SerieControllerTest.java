package com.CineJaro.controllers;

import com.CineJaro.services.SerieService;
import com.CineJaro.dto.SerieDTO;
import com.CineJaro.models.Serie;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(SerieController.class)
public class SerieControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SerieService serieService;

    @Test
    public void testCrearSerie() throws Exception {
        SerieDTO serieDTO = new SerieDTO("Test Serie", "30 min", "Comedia", "2023-01-01", "USA", "url.jpg");
        Serie serie = new Serie(); // Asume que tienes un constructor o método para crear una Serie desde un DTO
        
        when(serieService.crearSerie(any(SerieDTO.class))).thenReturn(serie);

        mockMvc.perform(post("/api/series/crear-serie")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"nombreSerie\":\"Test Serie\",\"duracion\":\"30 min\",\"genero\":\"Comedia\",\"fechaEstreno\":\"2023-01-01\",\"pais\":\"USA\",\"img\":\"url.jpg\"}"))
                .andExpect(status().isOk());
    }
}
