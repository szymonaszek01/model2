package com.oro.model2.repository;

import com.oro.model2.entity.Film;
import com.oro.model2.entity.Screening;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScreeningRepository extends JpaRepository<Screening, Long> {

    @Query("SELECT DISTINCT s.film FROM Screening s WHERE s.auditorium.id = :auditoriumId")
    List<Film> findAllFilmsByAuditoriumId(long auditoriumId);

    @Query("SELECT s FROM Screening s WHERE s.auditorium.id = :auditoriumId")
    List<Screening> findAllScreeningsByAuditoriumId(long auditoriumId);

    @Query("SELECT s FROM Screening s WHERE s.film.id = :filmId")
    List<Screening> findAllScreeningsByFilmId(long filmId);

    @Query("SELECT s FROM Screening s WHERE s.film.name = :name")
    List<Screening> findAllScreeningsByFilmName(String name);

    @Query("SELECT COUNT(s.auditorium) FROM Screening s WHERE s.film.id = :filmId")
    long countAllAuditoriumsByFilmId(long filmId);
}
