package com.CineJaro.repositories;

import com.CineJaro.models.Serie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SerieRepository extends JpaRepository<Serie, Long> {
}