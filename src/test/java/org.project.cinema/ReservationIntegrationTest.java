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

        SeatDTO seat = new SeatDTO();
        seat.setId(5);

        SeatDTO seat2 = new SeatDTO();
        seat2.setId(6);

        UserDTO user = new UserDTO();
        user.setId(1);

        ReservedSeatDTO reservedSeat = new ReservedSeatDTO();
        reservedSeat.setSeat(seat);
        reservedSeat.setUser(user);
        ReservedSeatDTO reservedSeat2 = new ReservedSeatDTO();
        reservedSeat2.setSeat(seat2);
        reservedSeat2.setUser(user);

        ScheduleDTO scheduleDTO = new ScheduleDTO();
        scheduleDTO.setId(5);

        Date date  = new Date();
        date.setTime(System.currentTimeMillis());
        scheduleDTO.setMovieStartTime(date);

        scheduleDTO.setReservedSeats(Arrays.asList(reservedSeat,reservedSeat2));

        ReservationDTO reservationDTO = new ReservationDTO();
        reservationDTO.setSchedule(scheduleDTO);
        reservationDTO.setTicketAvailableNr(20);
        reservationDTO.setReservedSeats(Arrays.asList(reservedSeat,reservedSeat2));

        Date movieDate = new Date();

        date.setTime(System.currentTimeMillis());
        reservationDTO.setDateTime(movieDate);
        reservationDTO.setUser(user);

        reservationService.saveReservation(reservationDTO);
    }
}