package org.project.cinema;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.project.CinemaApplication;
import org.project.dto.*;
import org.project.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.ConfigFileApplicationContextInitializer;
import org.springframework.boot.test.SpringApplicationContextLoader;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = CinemaApplication.class,
        loader = SpringApplicationContextLoader.class,
        initializers = ConfigFileApplicationContextInitializer.class)

public class ReservationIntegrationTest {

    @Autowired
    private ReservationService reservationService;

    @Test
    public void testSave() {
        long id = 7L;

        SeatDTO seat = new SeatDTO();
        seat.setId(id);
        seat.setRow(5);
        seat.setSeatNumber(4);

        SeatDTO seat2 = new SeatDTO();
        seat2.setId(5L);
        seat2.setRow(3);
        seat2.setSeatNumber(6);

        UserDTO user = new UserDTO();
        user.setId(11);
        user.setFirstName("George");
        user.setLastName("Smith");
        user.setPassword("firstpass");
        user.setTelephoneNumber("0740611695");
        user.setEmail("smith_george@gmail.com");

        MovieInfoDTO movieInfo = new MovieInfoDTO();
        movieInfo.setActor("Brie Larson, Samuel L. Jackson, Gemma Chan");
        movieInfo.setDirector("Anna Boden, Ryan Fleck");
        movieInfo.setGenre("Sci-Fi, Adventure, Action");
        movieInfo.setProduction(2019);
        movieInfo.setTitle("Captain Marvel");
        movieInfo.setId(7L);

        ReservedSeatDTO reservedSeat = new ReservedSeatDTO();
        reservedSeat.setId(id);
        reservedSeat.setSeat(seat);
        ReservedSeatDTO reservedSeat2 = new ReservedSeatDTO();
        reservedSeat2.setId(5L);
        reservedSeat2.setSeat(seat2);

        HallDTO hall = new HallDTO();
        hall.setCapacity(25);
        hall.setId(id);
        hall.setLocation("London");
        hall.setSeats(Arrays.asList(seat,seat2));

        ScheduleDTO scheduleDTO = new ScheduleDTO();
        scheduleDTO.setHall(hall);
        scheduleDTO.setMovieInfo(movieInfo);
        Date date  = new Date();
        date.setTime(System.currentTimeMillis());
        scheduleDTO.setMovieStartTime(date);
        scheduleDTO.setReservedSeats(Arrays.asList(reservedSeat,reservedSeat2));
        scheduleDTO.setId(id);

        PaymentDTO payment = new PaymentDTO();
        payment.setAmount(12);
        payment.setTransactionId(74569874);

        ReservationDTO reservationDTO = new ReservationDTO();
        reservationDTO.setId(70L);
        reservationDTO.setPayment(payment);
        reservationDTO.setMovieInfo(movieInfo);
        reservationDTO.setReservedSeats(Arrays.asList(reservedSeat,reservedSeat2));
        reservationDTO.setSchedule(scheduleDTO);
        reservationDTO.setPayed(true);
        reservationDTO.setTicketAvailableNr(20);
        reservationDTO.setHall(hall);
        Date movieDate = new Date();

        date.setTime(System.currentTimeMillis());
        reservationDTO.setDateTime(movieDate);
        reservationDTO.setUser(user);
        reservationService.saveReservation(reservationDTO);
    }
}