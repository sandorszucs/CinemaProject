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

import java.util.ArrayList;
import java.util.List;

@Service
public class ScheduleService {

    @Autowired
    private ScheduleRepository scheduleRepository;

    public Schedule saveSchedule (ScheduleDTO scheduleDTO) {
        Schedule scheduleObject = convert(scheduleDTO);
        return scheduleRepository.save(scheduleObject);
    }



    private ScheduleDTO convertToDto (Schedule schedule) {
        ScheduleDTO scheduleDTO = new ScheduleDTO();
        HallDTO hallDTO = new HallDTO();
        MovieInfoDTO movieInfoDTO = new MovieInfoDTO();
        List<ReservedSeatDTO> reservedSeatDTO = new ArrayList<>();


        scheduleDTO.setId(schedule.getId());
        scheduleDTO.setMovieStartTime(schedule.getMovieStartTime());
        scheduleDTO.setHall(hallDTO);
        scheduleDTO.setMovieInfo(movieInfoDTO);
        scheduleDTO.setReservedSeats(reservedSeatDTO);
        return scheduleDTO;
    }

    private Schedule convert (ScheduleDTO scheduleDTO) {

        Schedule schedule = new Schedule();
        Hall hall = new Hall();
        MovieInfo movieInfo = new MovieInfo();
        List<ReservedSeat> reservedSeat = new ArrayList<>();

        schedule.setId(scheduleDTO.getId());
        schedule.setMovieStartTime(scheduleDTO.getMovieStartTime());
        schedule.setHall(hall);
        schedule.setMovieInfo(movieInfo);
        schedule.setReservedSeats(reservedSeat);

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
        List<ReservedSeat> reservedSeat = new ArrayList<>();


        schedule.setId(dto.getId());
        schedule.setMovieStartTime(dto.getMovieStartTime());
        schedule.setHall(hall);
        schedule.setMovieInfo(movieInfo);
        schedule.setReservedSeats(reservedSeat);

        Schedule savedSchedule = scheduleRepository.save(schedule);
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
