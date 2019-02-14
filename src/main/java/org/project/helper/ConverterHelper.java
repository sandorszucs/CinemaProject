package org.project.helper;

import org.project.domain.*;
import org.project.dto.*;
import org.project.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConverterHelper {

    @Autowired
    private HallRepository hallRepository;

    @Autowired
    private MovieInfoRepository movieInfoRepository;

    @Autowired
    private SeatRepository seatRepository;

    @Autowired
    private ReservedSeatRepository reservedSeatRepository;

    @Autowired ScheduleRepository scheduleRepository;


    public List<ReservedSeat> convertReservedSeats(List<ReservedSeatDTO> reservedSeatDTOs){
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

    public Hall convertHall(HallDTO hallDTO, long id) {
        Hall hall = hallRepository.findHallById(id);
        if (hall == null){
            hall = new Hall();// if hall doesn't exist in the data base, ex: findById returns null, then create new hall Object
        }
        hall.setCapacity(hallDTO.getCapacity());
        hall.setId(hallDTO.getId());
        hall.setLocation(hallDTO.getLocation());
        List<Seat> seats = convertSeat(hallDTO.getSeats());
        hall.setSeats(seats);
        return hall;
    }

    public List<Seat> convertSeat(List<SeatDTO> seatDTOs){// example 5 seatDTO
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


    public MovieInfo convertMovieInfo(MovieInfoDTO movieDTO, long id){
        MovieInfo movieInfo = movieInfoRepository.findMovieInfoById(id);
        if(movieInfo == null){
            movieInfo = new MovieInfo();
        }
        movieInfo.setActor(movieDTO.getActor());
        movieInfo.setDirector(movieDTO.getDirector());
        movieInfo.setGenre(movieDTO.getGenre());
        movieInfo.setId(movieDTO.getId());
        movieInfo.setProduction(movieDTO.getProduction());
        movieInfo.setTitle(movieDTO.getTitle());

        return movieInfo;
    }

    public User convertUser(UserDTO userDTO) {
        User user = new User();
        user.setId(userDTO.getId());
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setPassword(userDTO.getPassword());
        user.setTelephoneNumber(userDTO.getTelephoneNumber());
        user.setEmail(userDTO.getEmail());
        return user;
    }

    public Payment convertPayment(PaymentDTO paymentDTO){
        Payment payment = new Payment();

        payment.setAmount(paymentDTO.getAmount());
        payment.setTransactionId(paymentDTO.getTransactionId());

        return payment;
    }

    public Schedule convertSchedule(ScheduleDTO scheduleDTO) {
        Schedule schedule = new Schedule();
        schedule.setMovieStartTime(scheduleDTO.getMovieStartTime());
        schedule.setId(scheduleDTO.getId());
        schedule.setMovieInfo(schedule.getMovieInfo());
        return schedule;
    }

}
