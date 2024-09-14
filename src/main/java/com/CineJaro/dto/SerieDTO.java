package com.CineJaro.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class SerieDTO {
    @NotBlank(message = "El nombre de la serie es obligatorio")
    @Size(max = 100, message = "El nombre de la serie no puede tener más de 100 caracteres")
    private String nombreSerie;

    @NotBlank(message = "La duración es obligatoria")
    private String duracion;

    @NotBlank(message = "El género es obligatorio")
    private String genero;

    @NotBlank(message = "La fecha de estreno es obligatoria")
    private String fechaEstreno;

    @NotBlank(message = "El país es obligatorio")
    private String pais;

    private String img;

    // Constructor vacío
    public SerieDTO() {
    }

    // Constructor con todos los campos
    public SerieDTO(String nombreSerie, String duracion, String genero, String fechaEstreno, String pais, String img) {
        this.nombreSerie = nombreSerie;
        this.duracion = duracion;
        this.genero = genero;
        this.fechaEstreno = fechaEstreno;
        this.pais = pais;
        this.img = img;
    }

    // Getters y setters
    public String getNombreSerie() {
        return nombreSerie;
    }

    public void setNombreSerie(String nombreSerie) {
        this.nombreSerie = nombreSerie;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getFechaEstreno() {
        return fechaEstreno;
    }

    public void setFechaEstreno(String fechaEstreno) {
        this.fechaEstreno = fechaEstreno;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
    
}
