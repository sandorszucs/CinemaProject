package org.project.persistence;

import org.project.domain.User;
import org.springframework.data.repository.PagingAndSortingRepository;


public interface UserRepository extends PagingAndSortingRepository <User, Long> {
    User findUserById (long id);
    User findByEmail (String email);
}
