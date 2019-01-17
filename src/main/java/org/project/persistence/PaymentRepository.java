package org.project.persistence;

import org.project.domain.Payment;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PaymentRepository extends
        PagingAndSortingRepository<Payment, Long> {
}