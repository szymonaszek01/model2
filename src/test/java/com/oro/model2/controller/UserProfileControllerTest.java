package com.oro.model2.controller;

import com.oro.model2.entity.UserProfile;
import com.oro.model2.service.UserProfileService;
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

@WebMvcTest(UserProfileController.class)
class UserProfileControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserProfileService userProfileService;

    private static final String url = "/api/v1/user-profile";

    @Test
    void getUserProfilesByScreeningIdShouldReturnStatus200() throws Exception {
        List<UserProfile> userProfileList = List.of(UserProfile.builder().id(2L).email("email2@gmail.com").password("password2").firstname("Firstname2").lastname("Lastname2").age(19).build());

        when(userProfileService.getUserProfilesByScreeningId(2)).thenReturn(userProfileList);
        mockMvc.perform(get(url + "/screening/id/{id}", 2L)).andDo(print()).andExpect(status().isOk());
    }
}
