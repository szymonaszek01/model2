package com.oro.model2.controller;

import com.oro.model2.service.TicketService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(TicketController.class)
class TicketControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TicketService ticketService;

    private static final String url = "/api/v1/ticket";

    @Test
    void countAuditoriumsByFilmIdShouldReturnStatus200() throws Exception {
        long result = 1;

        when(ticketService.countTicketsByUserProfileIdAndScreeningStartAndScreeningEnd(2, "2023-03-12T12:00:00", "2023-08-12T12:00:00")).thenReturn(result);
        mockMvc.perform(get(url + "/user-profile/id/{id}/from/{from}/to/{to}", 2L, "2023-03-12T12:00:00", "2023-08-12T12:00:00")).andDo(print()).andExpect(status().isOk());
    }
}
