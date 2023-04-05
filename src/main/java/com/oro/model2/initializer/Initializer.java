package com.oro.model2.initializer;

import com.oro.model2.entity.*;
import com.oro.model2.repository.*;
import com.oro.model2.util.Constant;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RequiredArgsConstructor
@Component
public class Initializer implements CommandLineRunner {

    private final AuditoriumRepository auditoriumRepository;

    private final DiscountRepository discountRepository;

    private final FilmRepository filmRepository;

    private final ReservationRepository reservationRepository;

    private final ScreeningRepository screeningRepository;

    private final SeatRepository seatRepository;

    private final TicketRepository ticketRepository;

    private final UserProfileRepository userProfileRepository;

    private final List<Auditorium> auditoriumList = new ArrayList<>();

    private final List<Discount> discountList = new ArrayList<>();

    private final List<Film> filmList = new ArrayList<>();

    private final List<Reservation> reservationList = new ArrayList<>();

    private final List<Screening> screeningList = new ArrayList<>();

    private final List<Seat> seatList = new ArrayList<>();

    private final List<Ticket> ticketList = new ArrayList<>();

    private final List<UserProfile> userProfileList = new ArrayList<>();

    @Override
    public void run(String... args) throws Exception {
        initializeAuditoriums();
        initializeDiscounts();
        initializeFilms();
        initializeUserProfiles();
        initializeReservations();
        initializeScreenings();
        initializeSeats();
        initializeTickets();

        auditoriumRepository.saveAll(auditoriumList);
        discountRepository.saveAll(discountList);
        filmRepository.saveAll(filmList);
        userProfileRepository.saveAll(userProfileList);
        reservationRepository.saveAll(reservationList);
        screeningRepository.saveAll(screeningList);
        seatRepository.saveAll(seatList);
        ticketRepository.saveAll(ticketList);
    }

    private void initializeAuditoriums() {
        auditoriumList.addAll(
            Arrays.asList(
                Auditorium.builder().id(1L).name("Auditorium 1").capacity(100).build(),
                Auditorium.builder().id(2L).name("Auditorium 2").capacity(100).build(),
                Auditorium.builder().id(3L).name("Auditorium 3").capacity(100).build()
            )
        );
    }

    private void initializeDiscounts() {
        discountList.addAll(
            Arrays.asList(
                Discount.builder().id(1L).name("Student").percentage(51).build(),
                Discount.builder().id(2L).name("Military").percentage(78).build(),
                Discount.builder().id(3L).name("Pensioners").percentage(37).build()
            )
        );
    }

    private void initializeFilms() {
        filmList.addAll(
            Arrays.asList(
                Film.builder().id(1L).name("Fast and furious 10").build(),
                Film.builder().id(2L).name("Iron man 3").build(),
                Film.builder().id(3L).name("Toy story 3").build(),
                Film.builder().id(4L).name("Top gun Maverick").build()
            )
        );
    }

    private void initializeUserProfiles() {
        userProfileList.addAll(
            Arrays.asList(
                UserProfile.builder().id(1L).email("email1@gmail.com").password("password1").firstname("Firstname1").lastname("Lastname1").age(18).build(),
                UserProfile.builder().id(2L).email("email2@gmail.com").password("password2").firstname("Firstname2").lastname("Lastname2").age(19).build(),
                UserProfile.builder().id(3L).email("email3@gmail.com").password("password3").firstname("Firstname3").lastname("Lastname3").age(20).build()
            )
        );
    }

    private void initializeScreenings() {
        screeningList.addAll(
            Arrays.asList(
                Screening.builder().id(1L).film(filmList.get(0)).cost(BigDecimal.valueOf(60)).screeningStart(LocalDateTime.now()).screeningEnd(LocalDateTime.now().plusHours(2)).auditorium(auditoriumList.get(0)).build(),
                Screening.builder().id(2L).film(filmList.get(1)).cost(BigDecimal.valueOf(70)).screeningStart(LocalDateTime.now()).screeningEnd(LocalDateTime.now().plusHours(2)).auditorium(auditoriumList.get(1)).build(),
                Screening.builder().id(3L).film(filmList.get(2)).cost(BigDecimal.valueOf(80)).screeningStart(LocalDateTime.now()).screeningEnd(LocalDateTime.now().plusHours(2)).auditorium(auditoriumList.get(1)).build(),
                Screening.builder().id(4L).film(filmList.get(3)).cost(BigDecimal.valueOf(80)).screeningStart(LocalDateTime.now()).screeningEnd(LocalDateTime.now().plusHours(2)).auditorium(auditoriumList.get(2)).build()
            )
        );
    }

    private void initializeSeats() {
        seatList.addAll(
            Arrays.asList(
                Seat.builder().id(1L).row(1).number(1).auditorium(auditoriumList.get(0)).build(),
                Seat.builder().id(2L).row(2).number(2).auditorium(auditoriumList.get(1)).build(),
                Seat.builder().id(3L).row(3).number(3).auditorium(auditoriumList.get(2)).build()
            )
        );
    }

    private void initializeReservations() {
        reservationList.addAll(
            Arrays.asList(
                Reservation.builder().id(1L).userProfile(userProfileList.get(0)).status(Constant.APPROVED).build(),
                Reservation.builder().id(2L).userProfile(userProfileList.get(1)).status(Constant.WAITING_FOR_APPROVAL).build(),
                Reservation.builder().id(3L).userProfile(userProfileList.get(2)).status(Constant.WAITING_FOR_APPROVAL).build()
            )
        );
    }

    private void initializeTickets() {
        ticketList.addAll(
            Arrays.asList(
                Ticket.builder().id(1L).discount(discountList.get(0)).seat(seatList.get(0)).screening(screeningList.get(0)).reservation(reservationList.get(0)).build(),
                Ticket.builder().id(2L).discount(discountList.get(1)).seat(seatList.get(1)).screening(screeningList.get(1)).reservation(reservationList.get(1)).build(),
                Ticket.builder().id(3L).discount(discountList.get(2)).seat(seatList.get(2)).screening(screeningList.get(2)).reservation(reservationList.get(2)).build()
            )
        );
    }
}
