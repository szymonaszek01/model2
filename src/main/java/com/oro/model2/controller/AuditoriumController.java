package com.oro.model2.controller;

import com.oro.model2.service.AuditoriumService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v1/auditorium")
@RestController
@RequiredArgsConstructor
public class AuditoriumController {

    private final AuditoriumService auditoriumService;

    @GetMapping("/film/id/{id}")
    public long countAuditoriumsByFilmId(@PathVariable long id) {
        return auditoriumService.countAuditoriumsByFilmId(id);
    }
}
