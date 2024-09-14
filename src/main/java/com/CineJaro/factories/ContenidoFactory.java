package com.CineJaro.factories;

public interface ContenidoFactory<T, D> {
    T crearContenido(D dto);
}
