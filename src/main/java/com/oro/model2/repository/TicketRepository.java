package com.oro.model2.repository;

import com.oro.model2.entity.Screening;
import com.oro.model2.entity.Ticket;
import com.oro.model2.entity.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {

    @Query("SELECT DISTINCT t.reservation.userProfile FROM Ticket t WHERE t.screening.id = :id")
    List<UserProfile> findAllUserProfilesByScreeningId(long id);

    @Query("SELECT t.screening FROM Ticket t WHERE t.reservation.userProfile.id = :id")
    List<Screening> findAllScreeningsByUserProfileId(long id);

    @Query("SELECT t.screening FROM Ticket t WHERE t.reservation.userProfile.email = :email")
    List<Screening> findAllScreeningsByUserProfileEmail(String email);

    @Query("SELECT COUNT(t.seat) FROM Ticket t WHERE t.screening.auditorium.id = :auditoriumId AND t.screening.id = :screeningId")
    long countAllSeatsByAuditoriumIdAndScreeningId(long auditoriumId, long screeningId);

    @Query("SELECT COUNT(t) FROM Ticket t WHERE t.reservation.userProfile.id = :userProfileId AND t.screening.screeningStart >= :screeningStart AND t.screening.screeningEnd <= :screeningEnd")
    long countAllTicketsByUserProfileIdAndScreeningStartAndScreeningEnd(long userProfileId, LocalDateTime screeningStart, LocalDateTime screeningEnd);
}
