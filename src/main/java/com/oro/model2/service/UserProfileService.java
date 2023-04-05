package com.oro.model2.service;

import com.oro.model2.entity.UserProfile;
import com.oro.model2.repository.TicketRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class UserProfileService {

    private final TicketRepository ticketRepository;

    public List<UserProfile> getUserProfilesByScreeningId(long screeningId) {
        return ticketRepository.findAllUserProfilesByScreeningId(screeningId);
    }
}
