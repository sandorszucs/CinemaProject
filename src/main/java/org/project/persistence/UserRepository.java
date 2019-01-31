package org.project.persistence;

import org.project.domain.User;
import org.springframework.data.repository.PagingAndSortingRepository;


public interface UserRepository extends
        PagingAndSortingRepository <User, Long> {

    User findByFirstName(String firstName);
    User findByLastName (String lastName);
    User findByEmail (String email);
}
