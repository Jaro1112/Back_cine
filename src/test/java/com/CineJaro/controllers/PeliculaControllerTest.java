package com.CineJaro.controllers;

import com.CineJaro.services.PeliculaService;
import com.CineJaro.dto.PeliculaDTO;
import com.CineJaro.models.Pelicula;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
public class PeliculaControllerTest {

    @Autowired
    private MockMvc mockMvc;    

    @MockBean
    private PeliculaService peliculaService;

    @Test
    public void testCrearPelicula() throws Exception {
        PeliculaDTO peliculaDTO = new PeliculaDTO("Test", "120 min", "Acción", "2023-01-01", "USA", "url.jpg");
        Pelicula pelicula = new Pelicula(); // Asume que tienes un constructor o método para crear una Pelicula desde un DTO
        
        when(peliculaService.crearPelicula(any(PeliculaDTO.class))).thenReturn(pelicula);

        mockMvc.perform(post("/api/peliculas/crear-pelicula")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"nombrePelicula\":\"Test\",\"duracion\":\"120 min\",\"genero\":\"Acción\",\"fechaEstreno\":\"2023-01-01\",\"pais\":\"USA\",\"img\":\"url.jpg\"}"))
                .andExpect(status().isOk());
    }
}
