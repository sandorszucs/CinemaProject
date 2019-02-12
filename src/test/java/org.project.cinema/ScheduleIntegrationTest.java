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
        long id = 4L;

        SeatDTO seat = new SeatDTO();
        seat.setId(id);
        seat.setRow(1);
        seat.setSeatNumber(1);

        SeatDTO seat2 = new SeatDTO();
        seat2.setId(5L);
        seat2.setRow(1);
        seat2.setSeatNumber(2);


        HallDTO hall = new HallDTO();
        hall.setCapacity(45);
        hall.setId(id);
        hall.setLocation("CJ");
        hall.setSeats(Arrays.asList(seat,seat2));

        MovieInfoDTO movieInfo = new MovieInfoDTO();
        movieInfo.setActor("Sanyika");
        movieInfo.setDirector("Sanyika");
        movieInfo.setGenre("Fantasy");
        movieInfo.setId(id);
        movieInfo.setProduction(2019);
        movieInfo.setTitle("The best programmer");


        ReservedSeatDTO reservedSeat = new ReservedSeatDTO();
        reservedSeat.setId(id);
        reservedSeat.setSeat(seat);
        ReservedSeatDTO reservedSeat2 = new ReservedSeatDTO();
        reservedSeat2.setId(5L);
        reservedSeat2.setSeat(seat2);


        ScheduleDTO scheduleDTO = new ScheduleDTO();
        scheduleDTO.setHall(hall);
        scheduleDTO.setMovieInfo(movieInfo);
        Date date  = new Date();
        date.setTime(System.currentTimeMillis());
        scheduleDTO.setMovieStartTime(date);
        scheduleDTO.setReservedSeats(Arrays.asList(reservedSeat,reservedSeat2));
        scheduleDTO.setId(id);


        scheduleService.saveSchedule(scheduleDTO);

//        ScheduleDTO result = scheduleService.getScheduleById(id);
//
//        Assertions.assertThat(result.getMovieStartTime())
    }

}
