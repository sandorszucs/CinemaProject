package org.project.service;

import org.project.domain.Hall;
import org.project.domain.MovieInfo;
import org.project.domain.ReservedSeat;
import org.project.domain.Schedule;
import org.project.dto.HallDTO;
import org.project.dto.MovieInfoDTO;
import org.project.dto.ReservedSeatDTO;
import org.project.dto.ScheduleDTO;
import org.project.persistence.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScheduleService {

    @Autowired
    private ScheduleRepository scheduleRepository;

    public void saveSchedule (ScheduleDTO scheduleDTO) {
        Long scheduleID = scheduleDTO.getId();
        if (scheduleID == null) {
            throw new IllegalArgumentException("Schedule ID cannot be null");
        }

        try {
            getScheduleById(scheduleID);
        } catch (Exception e) {
            Schedule scheduleObject = convert(scheduleDTO);
            try {
                scheduleRepository.save(scheduleObject);
            } catch (Exception scheduleError) {
                System.out.println("Your schedule could NOT be saved! Please, try again" + scheduleError);
            }
        }
    }

    private ScheduleDTO convertToDto (Schedule schedule) {
        ScheduleDTO scheduleDTO = new ScheduleDTO();
        HallDTO hallDTO = new HallDTO();
        MovieInfoDTO movieInfoDTO = new MovieInfoDTO();
        ReservedSeatDTO reservedSeatDTO = new ReservedSeatDTO();


        scheduleDTO.setId(schedule.getId());
        scheduleDTO.setMovieStartTime(schedule.getMovieStartTime());
        scheduleDTO.setHall(hallDTO);
        scheduleDTO.setMovieInfo(movieInfoDTO);
        scheduleDTO.setReservedSeats(reservedSeatDTO); // nem mukodik! hogyan implementaljam??????????????????????????????
        return scheduleDTO;
    }

    private Schedule convert (ScheduleDTO scheduleDTO) {

        Schedule schedule = new Schedule();
        Hall hall = new Hall(); // itt mi a baja?????????
        MovieInfo movieInfo = new MovieInfo();
        ReservedSeat reservedSeat = new ReservedSeat();

        schedule.setId(scheduleDTO.getId());
        schedule.setMovieStartTime(scheduleDTO.getMovieStartTime());
        schedule.setHall(hall);
        schedule.setMovieInfo(movieInfo);
        schedule.setReservedSeats(reservedSeat); ///////////// ugyan az ami a tobbinel

        return schedule;
    }

    public ScheduleDTO getScheduleById(long id) {
        Schedule schedule = scheduleRepository.findScheduleById(id);
        if (schedule == null) {
            throw new IllegalArgumentException("No such Schedule ID is found in the Database");
        }
        return convertToDto(schedule);
    }

    public ScheduleDTO updateSchedule (long id, ScheduleDTO dto) {

        Schedule schedule = scheduleRepository.findOne(id);
        Hall hall = new Hall();
        MovieInfo movieInfo = new MovieInfo();
        ReservedSeat reservedSeat = new ReservedSeat();


        schedule.setId(dto.getId());
        schedule.setMovieStartTime(dto.getMovieStartTime());
        schedule.setHall(hall);
        schedule.setMovieInfo(movieInfo);
        schedule.setReservedSeats(reservedSeat);

        Schedule savedSchedule = scheduleRepository.save(schedule)
        return convertToDto(savedSchedule);
    }

    public boolean deleteScheduleById (long id) {
        if (scheduleRepository.findOne(id) != null) {
            scheduleRepository.delete(id);
            return true;
        }
        return false;
    }

     //populate movie info method
}
