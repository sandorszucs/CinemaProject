package org.project.cinema;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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
    public void testSave() throws JsonProcessingException {

        Date date  = new Date();
        date.setTime(System.currentTimeMillis());

        ReservationDTO reservationDTO = new ReservationDTO();
        reservationDTO.setScheduleId(5);
        reservationDTO.setReservedSeats(Arrays.asList("2_3","4_1"));

        date.setTime(System.currentTimeMillis());
        reservationDTO.setUserId(1L);

        ObjectMapper m = new ObjectMapper();
        System.out.println( m.writeValueAsString(reservationDTO));
        reservationService.saveReservation(reservationDTO);
    }
}