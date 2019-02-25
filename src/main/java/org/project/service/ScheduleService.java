package org.project.service;

import org.project.domain.*;
import org.project.dto.*;
import org.project.helper.ConverterHelper;
import org.project.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

@Service
public class ScheduleService {

    @Autowired
    private ScheduleRepository scheduleRepository;

    @Autowired
    private ConverterHelper converterHelper;

    public Schedule saveSchedule(ScheduleDTO scheduleDTO) {
        Schedule scheduleObject = convert(scheduleDTO);
        return scheduleRepository.save(scheduleObject);
    }

    @Transactional
    public List<ScheduleDTO> getSchedules() {
        Iterator<Schedule> iterator =
                scheduleRepository.findAll().iterator();
        List<ScheduleDTO> list = new ArrayList<>();

        while (iterator.hasNext()) {
            Schedule schedule = iterator.next();
            ScheduleDTO scheduleDTO = convertToDto(schedule);
            list.add(scheduleDTO);
        }
        return list;
    }

    public boolean canSellMoreTickets (ScheduleDTO scheduleDTO){
        List<Seat> allAvailableSeat = getAllAvailableSeat(scheduleDTO);
        if (allAvailableSeat.size() > 0){
            System.out.println("There are " + allAvailableSeat + " More available tickets");
            return true;
        }
        return false;
    }

    public List<Seat> getAllAvailableSeat (ScheduleDTO scheduleDTO){
        List<SeatDTO> seats = new ArrayList<>();
//        Schedule scheduleObject = convert(scheduleDTO);
//
        List<SeatDTO> seatDTOs = scheduleDTO.getHall().getSeats();
        List<ReservedSeatDTO> reservedSeats = scheduleDTO.getReservedSeats();
        if(seats != null) {
            for (SeatDTO seat : seatDTOs) {
                for (ReservedSeatDTO reservedSeatDTO : reservedSeats) {
                    if (reservedSeatDTO.getSeat() != seat) {
                        seats.add(seat);
                    }
                }
            }
        }
        List<Seat> availableSeats = converterHelper.convertSeat(seats);
        return availableSeats;
    }


    private ScheduleDTO convertToDto(Schedule schedule) {
        ScheduleDTO scheduleDTO = new ScheduleDTO();
        HallDTO hallDTO = new HallDTO();
        MovieInfoDTO movieInfoDTO = new MovieInfoDTO();
        List<ReservedSeatDTO> reservedSeatDTO = scheduleDTO.getReservedSeats();

        scheduleDTO.setId(schedule.getId());
        scheduleDTO.setMovieStartTime(schedule.getMovieStartTime());
        scheduleDTO.setHall(hallDTO);
        scheduleDTO.setMovieInfo(movieInfoDTO);
        scheduleDTO.setReservedSeats(reservedSeatDTO);
        return scheduleDTO;
    }

    private Schedule convert(ScheduleDTO scheduleDTO) {
        Schedule schedule = new Schedule();
        Hall hall = converterHelper.convertHall(scheduleDTO.getHall(),scheduleDTO.getId());
        MovieInfo movieInfo = converterHelper.convertMovieInfo(scheduleDTO.getMovieInfo(),scheduleDTO.getId());
        schedule.setId(scheduleDTO.getId());
        schedule.setMovieStartTime(scheduleDTO.getMovieStartTime());
        schedule.setHall(hall);
        schedule.setMovieInfo(movieInfo);

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

    public void setConverterHelper(ConverterHelper converterHelper) {
        this.converterHelper = converterHelper;
    }
}