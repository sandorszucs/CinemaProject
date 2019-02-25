package org.project.cinema;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.project.domain.*;
import org.project.dto.ScheduleDTO;
import org.project.persistence.ScheduleRepository;
import org.project.service.ScheduleService;

import java.util.Arrays;
import java.util.Date;

@RunWith(MockitoJUnitRunner.class)
public class ScheduleUnitTest {

    @Mock
    private ScheduleRepository repository;

    @InjectMocks
    private ScheduleService service;

    @Test
    public void testGetById () {
        Schedule scheduleReturned = new Schedule();

        Date date = new Date();
        date.setTime(System.currentTimeMillis());

        scheduleReturned.setId(3L);
        scheduleReturned.setHall(getHall());
        scheduleReturned.setMovieInfo(getMovieInfo());
//        scheduleReturned.setReservedSeats(getReservedSeat());
        scheduleReturned.setMovieStartTime(date);

        Mockito.doReturn(scheduleReturned).when(repository).findOne(3L);
        ScheduleDTO scheduleDTO = service.getScheduleById(3L);

        Assert.assertNotNull(scheduleDTO);
        Assert.assertEquals(7L, scheduleDTO.getId());
        Assert.assertEquals(getMovieInfo(),getMovieInfo());
        Assert.assertEquals(getHall(), getHall());
        Assert.assertEquals(getReservedSeat(),getReservedSeat());
    }

    private ReservedSeat getReservedSeat () {


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
        schedule.setMovieInfo(getMovieInfo());
        schedule.setHall(getHall());
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

    private Hall getHall () {
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

    private MovieInfo getMovieInfo () {
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
