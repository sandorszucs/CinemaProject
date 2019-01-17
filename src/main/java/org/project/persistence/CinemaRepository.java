package org.project.persistence;

import org.project.domain.Cinema;
import org.springframework.data.repository.PagingAndSortingRepository;


public interface CinemaRepository extends
        PagingAndSortingRepository<Cinema, Long> {
}
