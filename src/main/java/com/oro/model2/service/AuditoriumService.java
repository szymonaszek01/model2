package com.oro.model2.service;

import com.oro.model2.repository.ScreeningRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class AuditoriumService {

    private final ScreeningRepository screeningRepository;

    public long countAuditoriumsByFilmId(long filmId) {
        return screeningRepository.countAllAuditoriumsByFilmId(filmId);
    }
}
