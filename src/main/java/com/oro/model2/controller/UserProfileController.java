package com.oro.model2.controller;

import com.oro.model2.entity.UserProfile;
import com.oro.model2.service.UserProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/api/v1/user-profile")
@RestController
@RequiredArgsConstructor
public class UserProfileController {

    private final UserProfileService userProfileService;

    @GetMapping("/screening/id/{id}")
    public List<UserProfile> getUserProfilesByScreeningId(@PathVariable long id) {
        return userProfileService.getUserProfilesByScreeningId(id);
    }
}
