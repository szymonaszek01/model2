package com.oro.model2.controller;

import com.oro.model2.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v1/ticket")
@RestController
@RequiredArgsConstructor
public class TicketController {

    private final TicketService ticketService;

    @GetMapping("/user-profile/id/{id}/from/{from}/to/{to}")
    public long countAuditoriumsByFilmId(@PathVariable long id, @PathVariable String from, @PathVariable String to) {
        return ticketService.countTicketsByUserProfileIdAndScreeningStartAndScreeningEnd(id, from, to);
    }
}
