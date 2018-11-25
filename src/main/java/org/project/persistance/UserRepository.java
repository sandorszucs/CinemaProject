package org.project.persistance;

import org.project.domain.User;
import org.springframework.data.repository.PagingAndSortingRepository;

public class UserRepository extends
        PagingAndSortingRepository <User, Long> {
}
