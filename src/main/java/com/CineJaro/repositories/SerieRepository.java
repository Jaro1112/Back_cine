package main.java.com.CineJaro.repositories;

import com.mycineavg.models.Serie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SerieRepository extends JpaRepository<Serie, Long> {
}