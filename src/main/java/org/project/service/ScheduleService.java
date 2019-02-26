package org.project.service;

import org.project.domain.*;
import org.project.dto.*;
import org.project.helper.ConverterHelper;
import org.project.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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


    public boolean canSellMoreTickets (ScheduleDTO scheduleDTO){
        List<SeatDTO> allAvailableSeat = getAllAvailableSeat(scheduleDTO.getId());
        if (allAvailableSeat.size() > 0){
            System.out.println("There are " + allAvailableSeat + " More available tickets");
            return true;
        }
        return false;
    }

    @Transactional
    public List<SeatDTO> getAllAvailableSeat (long scheduleId){
        Schedule scheduleById = scheduleRepository.findOne(scheduleId);
        List<SeatDTO> freeSeats = new ArrayList<>();

        List<Seat> seats = scheduleById.getHall().getSeats();
        List<ReservedSeat> reservedSeats = scheduleById.getReservedSeats();
        if(seats != null) {
            for (Seat seat : seats) {
                for (ReservedSeat reservedSeat : reservedSeats) {
                    if (reservedSeat.getSeat().getId() != seat.getId()) {
                        freeSeats.add(converterHelper.convertToSeatDto(seat));
                        seats.add(seat);
                    }
                }
            }
        }
        return freeSeats;
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
        return converterHelper.convertScheduleToDto(schedule);
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
        return converterHelper.convertScheduleToDto(savedSchedule);
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

        @Transactional
    public List<ScheduleDTO> getSchedules() {
        Iterator<Schedule> iterator = scheduleRepository.findAll().iterator();
        List<ScheduleDTO> list = new ArrayList<>();

        while (iterator.hasNext()) {
            Schedule schedule = iterator.next();
            ScheduleDTO scheduleDTO = converterHelper.convertScheduleToDto(schedule);
            list.add(scheduleDTO);
        }
        return list;
    }

//    public List<HallDTO> getHalls(long id) {
//        Iterator <Hall> iterator = scheduleRepository.findScheduleById(id);
//        List<HallDTO> list = new ArrayList<>();
//
//        while (iterator.hasNext()) {
//            Hall hall = iterator.next();
//            HallDTO hallDTO = converterHelper.convertHallToDto(hall);
//            list.add(hallDTO);
//        }
//        return list;
//    }
}