package com.oro.model2.controller;

import com.oro.model2.entity.Film;
import com.oro.model2.service.FilmService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/api/v1/film")
@RestController
@RequiredArgsConstructor
public class FilmController {

    private final FilmService filmService;

    @GetMapping("/auditorium/id/{id}")
    public List<Film> getFilmsByAuditoriumId(@PathVariable long id) {
        return filmService.getFilmsByAuditoriumId(id);
    }
}
