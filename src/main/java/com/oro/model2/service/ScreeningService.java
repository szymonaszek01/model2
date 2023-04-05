package com.oro.model2.service;

import com.oro.model2.entity.Screening;
import com.oro.model2.repository.ScreeningRepository;
import com.oro.model2.repository.TicketRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ScreeningService {

    private final ScreeningRepository screeningRepository;

    private final TicketRepository ticketRepository;

    public List<Screening> getScreeningsByAuditoriumId(long auditoriumId) {
        return screeningRepository.findAllScreeningsByAuditoriumId(auditoriumId);
    }

    public List<Screening> getScreeningsByFilmId(long filmId) {
        return screeningRepository.findAllScreeningsByFilmId(filmId);
    }

    public List<Screening> getScreeningsByFilmName(String name) {
        return screeningRepository.findAllScreeningsByFilmName(name);
    }

    public List<Screening> getScreeningsByUserProfileId(long userProfileId) {
        return ticketRepository.findAllScreeningsByUserProfileId(userProfileId);
    }

    public List<Screening> getScreeningsByUserProfileEmail(String email) {
        return ticketRepository.findAllScreeningsByUserProfileEmail(email);
    }
}
