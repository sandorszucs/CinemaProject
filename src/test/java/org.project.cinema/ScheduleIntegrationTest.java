package org.project.cinema;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.project.CinemaApplication;
import org.project.domain.Seat;
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
import static org.assertj.core.api.Assertions.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

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
    //save
    public void testSave() throws ParseException {

        SeatDTO seat = new SeatDTO();
        seat.setRow(1);
        seat.setSeatNumber(1);

        SeatDTO seat2 = new SeatDTO();
        seat2.setRow(1);
        seat2.setSeatNumber(2);

        ReservedSeatDTO reservedSeat = new ReservedSeatDTO();
        reservedSeat.setSeat(seat);
        ReservedSeatDTO reservedSeat2 = new ReservedSeatDTO();
        reservedSeat2.setSeat(seat2);

        HallDTO hall = new HallDTO();
        hall.setCapacity(40);
        hall.setLocation("CJ");
        hall.setSeats(Arrays.asList(seat,seat2));

        MovieInfoDTO movieInfo = new MovieInfoDTO();
        movieInfo.setActor("Sanyika");
        movieInfo.setDirector("Sanyika");
        movieInfo.setGenre("Fantasy");
        movieInfo.setProduction(2019);
        movieInfo.setTitle("The best programmer");

        SimpleDateFormat dateformat2 = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
        String strdate2 = "02-04-2019 12:00:00";
        Date newdate = dateformat2.parse(strdate2);

        ScheduleDTO scheduleDTO = new ScheduleDTO();
        scheduleDTO.setHall(hall);
        scheduleDTO.setMovieInfo(movieInfo);
        scheduleDTO.setMovieStartTime(newdate);

        scheduleService.saveSchedule(scheduleDTO);


    }
    @Test
    public void deleteScheduleById () {
        scheduleService.deleteScheduleById(19);
    }

    @Test
    public void testAvailableSeat(){
        ScheduleDTO scheduleDTO = scheduleService.getScheduleById(5);
        List<Seat> getAllAvailableSeat = scheduleService.getAllAvailableSeat(scheduleDTO);
//        int allAvailableSeat = scheduleService.getAllAvailableSeat(scheduleDTO);

        assertThat(getAllAvailableSeat).isNotNull();
        assertThat(getAllAvailableSeat).isEqualTo(38);
    }

}
