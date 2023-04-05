package com.oro.model2.service;

import com.oro.model2.entity.Film;
import com.oro.model2.repository.ScreeningRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class FilmService {

    private final ScreeningRepository screeningRepository;

    public List<Film> getFilmsByAuditoriumId(long auditoriumId) {
        return screeningRepository.findAllFilmsByAuditoriumId(auditoriumId);
    }
}
