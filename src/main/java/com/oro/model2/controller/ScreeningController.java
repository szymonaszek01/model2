package com.oro.model2.controller;

import com.oro.model2.entity.Screening;
import com.oro.model2.service.ScreeningService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/api/v1/screening")
@RestController
@RequiredArgsConstructor
public class ScreeningController {

    private final ScreeningService screeningService;

    @GetMapping("/auditorium/id/{id}")
    public List<Screening> getScreeningsByAuditoriumId(@PathVariable long id) {
        return screeningService.getScreeningsByAuditoriumId(id);
    }

    @GetMapping("/film/id/{id}")
    public List<Screening> getScreeningsByFilmId(@PathVariable long id) {
        return screeningService.getScreeningsByFilmId(id);
    }

    @GetMapping("/film/name/{name}")
    public List<Screening> getScreeningsByAuditoriumName(@PathVariable String name) {
        return screeningService.getScreeningsByFilmName(name);
    }

    @GetMapping("/user-profile/id/{id}")
    public List<Screening> getScreeningsByUserProfileId(@PathVariable long id) {
        return screeningService.getScreeningsByUserProfileId(id);
    }

    @GetMapping("/user-profile/email/{email}")
    public List<Screening> getScreeningsByUserProfileEmail(@PathVariable String email) {
        return screeningService.getScreeningsByUserProfileEmail(email);
    }
}
