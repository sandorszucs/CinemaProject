package org.project.cinema;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.project.CinemaApplication;
import org.project.dto.*;
import org.project.persistence.HallRepository;
import org.project.persistence.MovieInfoRepository;
import org.project.persistence.ReservedSeatRepository;
import org.project.persistence.SeatRepository;
import org.project.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.ConfigFileApplicationContextInitializer;
import org.springframework.boot.test.SpringApplicationContextLoader;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = CinemaApplication.class,
        loader = SpringApplicationContextLoader.class,
        initializers = ConfigFileApplicationContextInitializer.class)

public class ScheduleIntegrationTest {
    @Autowired
    private ScheduleService scheduleService;

    @Autowired
    private MovieInfoRepository movieInfoRepository;

    @Autowired
    private HallRepository hallRepository;

    @Autowired
    private SeatRepository seatRepository;

    @Autowired
    private ReservedSeatRepository reservedSeatRepository;

    @Test
    @Rollback(false)
    public void testSave() {
        long id = 1L;

        SeatDTO seat = new SeatDTO();
        seat.setId(id);
        seat.setRow(1);
        seat.setSeatNumber(1);

        HallDTO hall = new HallDTO();
        hall.setCapacity(45);
        hall.setId(id);
        hall.setLocation("CJ");
        hall.setSeats(Arrays.asList(seat));

        MovieInfoDTO movieInfo = new MovieInfoDTO();
        movieInfo.setActor("Sanyika");
        movieInfo.setDirector("Sanyika");
        movieInfo.setGenre("Sanyika");
        movieInfo.setId(id);
        movieInfo.setMovieType("Sanyika");

/*
        ReservedSeatDTO reservedSeat = new ReservedSeatDTO();
        reservedSeat.setId(id);
        reservedSeat.setSeat(seat2);
        ReservedSeatDTO reservedSeat2 = new ReservedSeatDTO();
        reservedSeat.setId(id);
        reservedSeat.setSeat(seat5);


        ScheduleDTO scheduleDTO = new ScheduleDTO();
        scheduleDTO.setHall(hall);
        scheduleDTO.setMovieInfo(movieInfo);
        scheduleDTO.setMovieStartTime(new Date(01/01/2019));
        scheduleDTO.setReservedSeats(Arrays.asList(reservedSeat,reservedSeat2));
        scheduleDTO.setId(id);


        scheduleService.saveSchedule(scheduleDTO);
*/
//        ScheduleDTO result = scheduleService.getScheduleById(id);
//
//        Assertions.assertThat(result.getMovieStartTime())
    }

}
