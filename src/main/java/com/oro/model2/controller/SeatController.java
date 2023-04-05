package com.oro.model2.controller;

import com.oro.model2.service.SeatService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v1/seat")
@RestController
@RequiredArgsConstructor
public class SeatController {

    private final SeatService seatService;

    @GetMapping("/auditorium/id/{auditoriumId}/screening/id/{screeningId}")
    public long countSeatsByAuditoriumIdAndScreeningId(@PathVariable long auditoriumId, @PathVariable long screeningId) {
        return seatService.countSeatsByAuditoriumIdAndScreeningId(auditoriumId, screeningId);
    }
}
