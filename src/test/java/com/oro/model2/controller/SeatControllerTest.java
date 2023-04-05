package com.oro.model2.controller;

import com.oro.model2.service.SeatService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(SeatController.class)
class SeatControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SeatService seatService;

    private static final String url = "/api/v1/seat";

    @Test
    void countSeatsByAuditoriumIdAndScreeningIdShouldReturnStatus200() throws Exception {
        long result = 1;

        when(seatService.countSeatsByAuditoriumIdAndScreeningId(2, 2)).thenReturn(result);
        mockMvc.perform(get(url + "/auditorium/id/{auditoriumId}/screening/id/{screeningId}", 2L, 2L)).andDo(print()).andExpect(status().isOk());
    }
}
