package com.oro.model2.service;

import com.oro.model2.repository.TicketRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class SeatService {

    private final TicketRepository ticketRepository;

    public long countSeatsByAuditoriumIdAndScreeningId(long auditoriumId, long screeningId) {
        return ticketRepository.countAllSeatsByAuditoriumIdAndScreeningId(auditoriumId, screeningId);
    }
}
