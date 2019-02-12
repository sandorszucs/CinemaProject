package org.project.service;

import org.project.domain.*;
import org.project.dto.*;
import org.project.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ScheduleService {

    @Autowired
    private ScheduleRepository scheduleRepository;

    @Autowired
    private HallRepository hallRepository;

    @Autowired
    private MovieInfoRepository movieInfoRepository;

    @Autowired
    private SeatRepository seatRepository;

    @Autowired
    private ReservedSeatRepository reservedSeatRepository;

    public Schedule saveSchedule(ScheduleDTO scheduleDTO) {
        Schedule scheduleObject = convert(scheduleDTO);
        return scheduleRepository.save(scheduleObject);
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
        Hall hall = convertHall(scheduleDTO,scheduleDTO.getId());
        MovieInfo movieInfo = convertMovieInfo(scheduleDTO,scheduleDTO.getId());

        List<ReservedSeat> reservedSeat = convertReservedSeats(scheduleDTO.getReservedSeats());

        schedule.setId(scheduleDTO.getId());
        schedule.setMovieStartTime(scheduleDTO.getMovieStartTime());

        schedule.setHall(hall);
        schedule.setMovieInfo(movieInfo);
        schedule.setReservedSeats(reservedSeat);

        return schedule;
    }

    private List<ReservedSeat> convertReservedSeats(List<ReservedSeatDTO> reservedSeatDTOs){
        List<ReservedSeat> reservedSeats = new ArrayList<>();
        for(ReservedSeatDTO seatDTO : reservedSeatDTOs){
            ReservedSeat reservedSeat = reservedSeatRepository.findReservedSeatById(seatDTO.getId());
             if(reservedSeat == null){
                 reservedSeat = new ReservedSeat();
             }
            reservedSeat.setId(seatDTO.getId());
            List<Seat> seat = convertSeat(Arrays.asList(seatDTO.getSeat()));
            reservedSeat.setSeat(seat.get(0));

            reservedSeats.add(reservedSeat);
        }
        return reservedSeats;
    }

    private Hall convertHall(ScheduleDTO scheduleDTO, long id) {
        Hall hall = hallRepository.findHallById(id);
        if (hall == null){
            hall = new Hall();// if hall doesn't exist in the data base, ex: findById returns null, then create new hall Object
        }
        hall.setCapacity(scheduleDTO.getHall().getCapacity());
        hall.setId(scheduleDTO.getHall().getId());
        hall.setLocation(scheduleDTO.getHall().getLocation());
        List<Seat> seats = convertSeat(scheduleDTO.getHall().getSeats());
        hall.setSeats(seats);
        return hall;
    }

    private List<Seat> convertSeat(List<SeatDTO> seatDTOs){// example 5 seatDTO
        List<Seat> seats = new ArrayList<>();
        for(SeatDTO seatDTO : seatDTOs){//for every seatDTO in the list of 5
            Seat seat = seatRepository.findSeatById(seatDTO.getId());
            if(seat == null){
                seat = new Seat();
            }

            seat.setId(seatDTO.getId());
            seat.setRow(seatDTO.getRow());
            seat.setSeatNumber(seatDTO.getSeatNumber());
            seats.add(seat);
        }
        return seats; //returns list of seats which were converted from seatDTO
    }


    private MovieInfo convertMovieInfo(ScheduleDTO scheduleDTO, long id){
        MovieInfo movieInfo = movieInfoRepository.findMovieInfoById(id);
          if(movieInfo == null){
              movieInfo = new MovieInfo();
          }
        movieInfo.setActor(scheduleDTO.getMovieInfo().getActor());
        movieInfo.setDirector(scheduleDTO.getMovieInfo().getDirector());
        movieInfo.setGenre(scheduleDTO.getMovieInfo().getGenre());
        movieInfo.setId(scheduleDTO.getMovieInfo().getId());
        movieInfo.setProduction(scheduleDTO.getMovieInfo().getProduction());
        movieInfo.setTitle(scheduleDTO.getMovieInfo().getTitle());

        return movieInfo;
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
