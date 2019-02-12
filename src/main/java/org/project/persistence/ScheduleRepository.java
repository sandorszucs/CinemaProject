package org.project.persistence;

import org.project.domain.Schedule;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ScheduleRepository extends PagingAndSortingRepository<Schedule, Long> {


    Schedule findScheduleById (long id);
}