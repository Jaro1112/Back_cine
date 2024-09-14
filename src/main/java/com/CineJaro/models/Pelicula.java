package main.java.com.CineJaro.models;

import javax.persistence.*;

@Entity
public class Pelicula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombrePelicula;
    private String duracion;
    private String genero;
    private String fechaEstreno;
    private String pais;
    private String img;

    // Getters y setters
}