package org.project.persistence;

import org.project.domain.Hall;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface HallRepository extends PagingAndSortingRepository<Hall, Long> {

    Hall findHallById(long id);

}