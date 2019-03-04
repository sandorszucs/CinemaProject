package org.project.persistence;

import org.project.domain.ReservedSeat;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ReservedSeatRepository extends PagingAndSortingRepository<ReservedSeat, Long> {

    ReservedSeat findReservedSeatById(long id);
}
