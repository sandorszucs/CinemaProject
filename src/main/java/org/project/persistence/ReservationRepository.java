package org.project.persistence;

import org.project.domain.Reservation;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Date;

public interface ReservationRepository extends
        PagingAndSortingRepository<Reservation, Long> {

    Reservation findReservationById(long id);
}