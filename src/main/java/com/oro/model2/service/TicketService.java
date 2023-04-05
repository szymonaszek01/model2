package com.oro.model2.service;

import com.oro.model2.repository.TicketRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@AllArgsConstructor
@Service
public class TicketService {

    private final TicketRepository ticketRepository;

    public long countTicketsByUserProfileIdAndScreeningStartAndScreeningEnd(long userProfileId, String screeningStart, String screeningEnd) {
        LocalDateTime screeningStartAsLocalDateTime = LocalDateTime.parse(screeningStart);
        LocalDateTime screeningEndAsLocalDateTime = LocalDateTime.parse(screeningEnd);

        return ticketRepository.countAllTicketsByUserProfileIdAndScreeningStartAndScreeningEnd(userProfileId, screeningStartAsLocalDateTime, screeningEndAsLocalDateTime);
    }
}
