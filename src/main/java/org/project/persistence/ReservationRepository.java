package org.project.persistence;

import org.project.domain.Reservation;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ReservationRepository extends
        PagingAndSortingRepository<Reservation, Long> {
}