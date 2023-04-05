package com.oro.model2.controller;

import com.oro.model2.entity.Film;
import com.oro.model2.service.AuditoriumService;
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

@WebMvcTest(AuditoriumController.class)
class AuditoriumControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AuditoriumService auditoriumService;

    private static final String url = "/api/v1/auditorium";


    @Test
    void countAuditoriumsByFilmIdShouldReturnStatus200() throws Exception {
        long result = 1;

        when(auditoriumService.countAuditoriumsByFilmId(2)).thenReturn(result);
        mockMvc.perform(get(url + "/film/id/{id}", 2L)).andDo(print()).andExpect(status().isOk());
    }
}
