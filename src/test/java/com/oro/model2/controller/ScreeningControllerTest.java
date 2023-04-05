package com.oro.model2.controller;

import com.oro.model2.entity.Auditorium;
import com.oro.model2.entity.Film;
import com.oro.model2.entity.Screening;
import com.oro.model2.service.ScreeningService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ScreeningController.class)
class ScreeningControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ScreeningService screeningService;

    private static final String url = "/api/v1/screening";

    @Test
    void getScreeningsByAuditoriumIdShouldReturnStatus200() throws Exception {
        List<Film> filmList = List.of(Film.builder().id(1L).name("Fast and furious 10").build(), Film.builder().id(2L).name("Iron man 3").build());

        List<Auditorium> auditoriumList = List.of(Auditorium.builder().id(2L).name("Auditorium 2").capacity(100).build());

        List<Screening> screeningList = List.of(Screening.builder().id(1L).film(filmList.get(0)).cost(BigDecimal.valueOf(60)).screeningStart(LocalDateTime.now()).screeningEnd(LocalDateTime.now().plusHours(2)).auditorium(auditoriumList.get(0)).build(), Screening.builder().id(2L).film(filmList.get(1)).cost(BigDecimal.valueOf(70)).screeningStart(LocalDateTime.now().plusHours(2)).screeningEnd(LocalDateTime.now().plusHours(4)).auditorium(auditoriumList.get(0)).build());

        when(screeningService.getScreeningsByAuditoriumId(2)).thenReturn(screeningList);
        mockMvc.perform(get(url + "/auditorium/id/{id}", 2L)).andDo(print()).andExpect(status().isOk());
    }
}
