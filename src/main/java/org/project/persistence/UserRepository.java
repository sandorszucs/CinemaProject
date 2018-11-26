package org.project.persistence;

import org.project.domain.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

public interface UserRepository extends
        PagingAndSortingRepository <User, Long> {
}
