package org.project.cinema;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.project.domain.Reservation;
import org.project.persistence.ReservationRepository;
import org.project.service.ReservationService;

@RunWith(MockitoJUnitRunner.class)
public class ReservationUnitTest {

    @Mock
    private ReservationRepository repository;

    @InjectMocks
    private ReservationService service;

    @Test
    public void testGetById() {
        Reservation reservationReturned = new Reservation();








    }
}
