package org.project.cinema;

import static org.assertj.core.api.Assertions.*;
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
        Date date = new Date();
        date.setTime(System.currentTimeMillis());

        final Schedule scheduleReturned = setupExpectedSchedule(date);
        ScheduleDTO scheduleDTO = setupExpectedScheduleDTO(date, scheduleReturned);

        Mockito.when(repository.findScheduleById(3L)).thenReturn(scheduleReturned);
        Mockito.when(converterHelper.convertScheduleToDto(scheduleReturned)).thenReturn(scheduleDTO);

        ScheduleDTO result = service.getScheduleById(3L);

        assertThat(result).as("Expected scheduleDTO cannot be null").isNotNull();
        assertThat(result.getId()).as("The found schedule dto's id has to be equal to 3").isEqualByComparingTo(3L);
        assertThat(result.getMovieInfo().getActor()).as("Actor has to be the same as the one saved to the data base").isEqualTo(setupMovieInfo().getActor());
        assertThat(result.getMovieStartTime()).as("Movie start time should be + ", date).isEqualTo(date);
        assertThat(result.getHall().getCapacity()).as("The capacity of the hall shuld be 40 seats").isEqualTo(40);
    }
    
    private Schedule setupExpectedSchedule(Date date){
        Schedule scheduleReturned = new Schedule();
        scheduleReturned.setId(3L);
        scheduleReturned.setHall(setupHall());
        scheduleReturned.setMovieInfo(setupMovieInfo());
        scheduleReturned.setReservedSeats(Arrays.asList(setupReservedSeat()));
        scheduleReturned.setMovieStartTime(date);
        
        return scheduleReturned;
    }
    
    private ScheduleDTO setupExpectedScheduleDTO(Date date, Schedule schedule){
        ScheduleDTO scheduleDTO = new ScheduleDTO();
        scheduleDTO.setMovieStartTime(date);
        scheduleDTO.setId(schedule.getId());
        scheduleDTO.setHall(setupHallDTO());
        scheduleDTO.setReservedSeats(Arrays.asList(setupReservedSeatDTO()));
        scheduleDTO.setMovieInfo(setupMovieInfoDTO());
        return scheduleDTO;
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
        return reservedSeatDTO;
    }


    private MovieInfoDTO setupMovieInfoDTO(){
        MovieInfoDTO movieInfoDTO = new MovieInfoDTO();
        MovieInfo movieInfo = setupMovieInfo();
        movieInfoDTO.setProduction(movieInfo.getProduction());
        movieInfoDTO.setDirector(movieInfo.getDirector());
        movieInfoDTO.setGenre(movieInfo.getGenre());
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
