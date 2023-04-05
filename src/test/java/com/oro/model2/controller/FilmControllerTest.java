package com.oro.model2.controller;

import com.oro.model2.entity.Film;
import com.oro.model2.service.FilmService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(FilmController.class)
class FilmControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private FilmService filmService;

    private static final String url = "/api/v1/film";

    @Test
    void getFilmsByAuditoriumIdShouldReturnStatus200() throws Exception {
        List<Film> filmList = List.of(Film.builder().id(2L).name("Iron man 3").build(), Film.builder().id(3L).name("Toy story 3").build());

        when(filmService.getFilmsByAuditoriumId(2)).thenReturn(filmList);
        mockMvc.perform(get(url + "/auditorium/id/{id}", 2L)).andDo(print()).andExpect(status().isOk());
    }
}
