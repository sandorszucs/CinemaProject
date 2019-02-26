package org.project.cinema;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.project.domain.*;
import org.project.dto.*;
import org.project.helper.ConverterHelper;
import org.project.persistence.ScheduleRepository;
import org.project.service.ScheduleService;

import java.util.Arrays;
import java.util.Date;

@RunWith(MockitoJUnitRunner.class)
public class ScheduleUnitTest {

    @Mock
    private ScheduleRepository repository;

    @Mock
    private ConverterHelper converterHelper;

    @InjectMocks
    private ScheduleService service;

    @Test
    public void testGetById () {
        Schedule scheduleReturned = new Schedule();

        Date date = new Date();
        date.setTime(System.currentTimeMillis());

        scheduleReturned.setId(3L);
        scheduleReturned.setHall(setupHall());
        scheduleReturned.setMovieInfo(setupMovieInfo());
        scheduleReturned.setReservedSeats(Arrays.asList(setupReservedSeat()));
        scheduleReturned.setMovieStartTime(date);

        ScheduleDTO scheduleDTO = new ScheduleDTO();
        scheduleDTO.setMovieStartTime(date);
        scheduleDTO.setId(scheduleReturned.getId());
        scheduleDTO.setHall(setupHallDTO());
        scheduleDTO.setReservedSeats(Arrays.asList(setupReservedSeatDTO()));
        scheduleDTO.setMovieInfo(setupMovieInfoDTO());


        Mockito.when(repository.findScheduleById(3L)).thenReturn(scheduleReturned);
        Mockito.when(converterHelper.convertScheduleToDto(scheduleReturned)).thenReturn(scheduleDTO);

        ScheduleDTO result = service.getScheduleById(3L);

        Assert.assertNotNull(result);
        Assert.assertEquals(3L, result.getId());
        Assert.assertEquals(result.getMovieInfo().getActor(),setupMovieInfo().getActor());
        Assert.assertEquals(result.getHall().getCapacity(), setupHall().getCapacity());
    }

    private HallDTO setupHallDTO(){
        HallDTO hallDTO = new HallDTO();
        Hall hall = setupHall();

        hallDTO.setLocation(hall.getLocation());
        hallDTO.setCapacity(hall.getCapacity());

        return hallDTO;
    }

    private ReservedSeatDTO setupReservedSeatDTO(){
        ReservedSeatDTO reservedSeatDTO = new ReservedSeatDTO();
        ReservedSeat reservedSeat = setupReservedSeat();



        return reservedSeatDTO;
    }


    private MovieInfoDTO setupMovieInfoDTO(){
        MovieInfoDTO movieInfoDTO = new MovieInfoDTO();
        MovieInfo movieInfo = setupMovieInfo();
        movieInfoDTO.setProduction(movieInfo.getProduction());
        movieInfoDTO.setDirector(movieInfo.getDirector());
        movieInfoDTO.setGenre(movieInfo.getGenre());
//        movieInfoDTO.setId();
        movieInfoDTO.setTitle(movieInfo.getTitle());
        movieInfoDTO.setActor(movieInfo.getActor());

        return movieInfoDTO;
    }

    private ReservedSeat setupReservedSeat () {
        Seat seat = new Seat();
        seat.setSeatNumber(1);
        seat.setRow(1);

        ReservedSeat reservedSeat = new ReservedSeat();
//        reservedSeat.setId(1L);
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

    private Hall setupHall () {
        Hall hall = new Hall();

        Seat seat = new Seat();
        seat.setSeatNumber(1);
        seat.setRow(1);

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
        hall.setSeats(Arrays.asList(seat,seat2));
        return hall;
    }

    private MovieInfo setupMovieInfo () {
        MovieInfo movieInfo = new MovieInfo();
        movieInfo.setId(1L);
        movieInfo.setTitle("Captain Marvel");
        movieInfo.setActor("Brie Larson, Samuel L. Jackson, Gemma Chan");
        movieInfo.setDirector("Anna Boden");
        movieInfo.setGenre("Action");
        movieInfo.setProduction(2019);
        return movieInfo;
    }
}
