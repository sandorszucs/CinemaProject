package org.project.persistence;

import org.project.domain.Seat;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface SeatRepository extends PagingAndSortingRepository<Seat, Long> {

    Seat findSeatById(long id);

}