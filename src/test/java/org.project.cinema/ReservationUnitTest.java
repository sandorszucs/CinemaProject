package org.project.cinema;

import static org.assertj.core.api.Assertions.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.project.domain.*;
import org.project.dto.*;
import org.project.helper.ConverterHelper;
import org.project.persistence.ReservationRepository;
import org.project.service.ReservationService;

import java.util.Arrays;
import java.util.Date;

@RunWith(MockitoJUnitRunner.class)
public class ReservationUnitTest {

    @Mock
    private ReservationRepository repository;

    @Mock
    private ConverterHelper converterHelper;

    @InjectMocks
    private ReservationService service;

    @Test
    public void testGetById() {

        Date date = new Date();
        date.setTime(System.currentTimeMillis());

        Reservation reservationReturned = setupExpectedReservation(date);
        ReservationDTO reservationDTO = setupExpectedReservationDTO(reservationReturned);

        Mockito.when(repository.findReservationById(2L)).thenReturn(reservationReturned);
        Mockito.when(converterHelper.convertReservationToDto(reservationReturned)).thenReturn(reservationDTO);

        ReservationDTO result = service.getReservationById(2L);

        assertThat(result).as("Expected ReservationDTO cannot be null").isNotNull();
        assertThat(result.getId()).as("The found reservation dto's id has to be equal to 2").isEqualByComparingTo(2L);
    }

    private Reservation setupExpectedReservation(Date date) {
        Reservation reservationReturned = new Reservation();

        reservationReturned.setId(2L);
        reservationReturned.setDateTime(date);
        reservationReturned.setReservedSeat(Arrays.asList(setupReservedSeat()));
        reservationReturned.setUser(setupUser());
        reservationReturned.setSchedule(setupSchedule());
        return reservationReturned;
    }

    private ReservationDTO setupExpectedReservationDTO(Reservation reservation) {
        ReservationDTO reservationDTO = new ReservationDTO();
        reservationDTO.setId(reservation.getId());
        reservationDTO.setDateTime(reservation.getDateTime());
        return reservationDTO;
    }

    private Schedule setupSchedule() {
        Schedule schedule = new Schedule();
        schedule.setId(2L);
        schedule.setHall(setupHall());
        schedule.setMovieInfo(setupMovieInfo());
        schedule.setReservedSeats(Arrays.asList(setupReservedSeat()));

        Date date = new Date();
        date.setTime(System.currentTimeMillis());
        schedule.setMovieStartTime(date);

        return schedule;
    }

    private ScheduleDTO setupScheduleDTO() {
        ScheduleDTO scheduleDTO = new ScheduleDTO();
        Schedule schedule = setupSchedule();

        scheduleDTO.setId(schedule.getId());
        scheduleDTO.setMovieStartTime(schedule.getMovieStartTime());
        scheduleDTO.setMovieInfo(setupMovieInfoDTO());

        return scheduleDTO;
    }

    private User setupUser() {
        User user = new User();
        user.setId(1L);
        user.setFirstName("Boda");
        user.setLastName("Patrick");
        user.setEmail("boda_patrick@gmail.com");
        user.setPassword("secpass");
        user.setTelephoneNumber("0740611695");
        return user;
    }

    private UserDTO setupUserDTO() {
        UserDTO userDTO = new UserDTO();
        User user = setupUser();
        userDTO.setId(user.getId());
        userDTO.setFirstName(user.getFirstName());
        userDTO.setLastName(user.getLastName());
        userDTO.setEmail(user.getEmail());
        userDTO.setPassword(user.getPassword());
        userDTO.setTelephoneNumber(user.getTelephoneNumber());
        return userDTO;
    }

    private ReservedSeatDTO setupReservedSeatDTO() {
        ReservedSeatDTO reservedSeatDTO = new ReservedSeatDTO();

        return reservedSeatDTO;
    }

    private ReservedSeat setupReservedSeat() {

        Seat seat = new Seat();
        seat.setSeatNumber(2);
        seat.setRow(2);

        ReservedSeat reservedSeat = new ReservedSeat();
        reservedSeat.setSeat(seat);

        Seat seat2 = new Seat();
        seat2.setSeatNumber(1);
        seat2.setRow(2);

        ReservedSeat reservedSeat2 = new ReservedSeat();
        reservedSeat2.setSeat(seat2);

        Schedule schedule = new Schedule();
        schedule.setId(1L);
        Date date = new Date();
        date.setTime(System.currentTimeMillis());
        schedule.setMovieStartTime(date);
        schedule.setMovieInfo(setupMovieInfo());
        schedule.setHall(setupHall());
        schedule.setReservedSeats(Arrays.asList(reservedSeat, reservedSeat2));
        reservedSeat.setSchedule(schedule);

        User user = new User();
        user.setId(7L);
        user.setFirstName("Sandor");
        user.setLastName("Szucs");
        user.setPassword("unitpass");
        user.setEmail("szucslfc@gmail.com");
        user.setTelephoneNumber("0740123456");
        reservedSeat.setUser(user);

        return reservedSeat;
    }

    private Hall setupHall() {
        Hall hall = new Hall();

        Seat seat = new Seat();
        seat.setSeatNumber(2);
        seat.setRow(2);

        Seat seat2 = new Seat();
        seat2.setSeatNumber(2);
        seat2.setRow(1);

        ReservedSeat reservedSeat = new ReservedSeat();
        reservedSeat.setSeat(seat);
        ReservedSeat reservedSeat2 = new ReservedSeat();
        reservedSeat2.setSeat(seat2);


        hall.setId(1L);
        hall.setLocation("Universal");
        hall.setCapacity(40);
        hall.setSeats(Arrays.asList(seat, seat2));
        return hall;
    }

    private MovieInfo setupMovieInfo() {
        MovieInfo movieInfo = new MovieInfo();
        movieInfo.setId(2L);
        movieInfo.setTitle("What Men Want");
        movieInfo.setActor("Wendi McLendon-Covey, Taraji P.Henson, Max Greenfield");
        movieInfo.setDirector("Adam Shankman");
        movieInfo.setGenre("Comedy");
        movieInfo.setProduction(2019);
        return movieInfo;
    }

    private MovieInfoDTO setupMovieInfoDTO() {
        MovieInfoDTO movieInfoDTO = new MovieInfoDTO();
        MovieInfo movieInfo = setupMovieInfo();
        movieInfoDTO.setProduction(movieInfo.getProduction());
        movieInfoDTO.setDirector(movieInfo.getDirector());
        movieInfoDTO.setGenre(movieInfo.getGenre());
        movieInfoDTO.setTitle(movieInfo.getTitle());
        movieInfoDTO.setActor(movieInfo.getActor());
        return movieInfoDTO;
    }
}