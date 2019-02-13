package org.project.service;

import org.project.domain.*;
import org.project.dto.*;
import org.project.helper.ConverterHelper;
import org.project.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private ConverterHelper converterHelper;


    public void setConverterHelper(ConverterHelper converterHelper) {
        this.converterHelper = converterHelper;
    }

    public Reservation saveReservation(ReservationDTO reservationDTO) {
        Long reservationId = reservationDTO.getId();
        Reservation reservationObject = convert(reservationDTO);

        try {
            return reservationRepository.save(reservationObject);
        } catch (Exception e2) {
            System.out.println("Your reservation could NOT be saved! Please, try again! " + e2);
            return new Reservation();
        }
    }

    private ReservationDTO convertToDto(Reservation reservation) {

        ReservationDTO reservationDTO = new ReservationDTO();

        ScheduleDTO scheduleDTO = new ScheduleDTO();
        List<ReservedSeatDTO> reservedSeatDTO = scheduleDTO.getReservedSeats();
        MovieInfoDTO movieInfoDTO = new MovieInfoDTO();
        PaymentDTO paymentDTO = new PaymentDTO();


        reservationDTO.setId(reservation.getId());
        reservationDTO.setTicketAvailableNr(reservation.getTicketAvailableNr());
        reservationDTO.setDateTime(reservation.getDateTime());
        reservationDTO.setPayed(reservation.getPayed());

        reservationDTO.setSchedule(scheduleDTO);
        reservationDTO.setReservedSeats(reservedSeatDTO);
        reservationDTO.setMovieInfo(movieInfoDTO);
        reservationDTO.setPayment(paymentDTO);

        return reservationDTO;
    }

    private Reservation convert(ReservationDTO reservationDTO) {
        Reservation reservation = new Reservation();
        Schedule schedule = new Schedule();
        Hall hall = converterHelper.convertHall(reservationDTO.getHall(), reservationDTO.getId());
        MovieInfo movieInfo = converterHelper.convertMovieInfo(reservationDTO.getMovieInfo(), reservationDTO.getId());
        User user = converterHelper.convertUser(reservationDTO.getUser());
        List<ReservedSeat> reservedSeat = converterHelper.convertReservedSeats(reservationDTO.getReservedSeats()); // kell egy s betu
        Payment payment = converterHelper.convertPayment(reservationDTO.getPayment());

        schedule.setHall(hall);

        reservation.setId(reservationDTO.getId());
        reservation.setTicketAvailableNr(reservationDTO.getTicketAvailableNr());
        reservation.setDateTime(reservationDTO.getDateTime());
        reservation.setPayed(reservationDTO.getPayed());

        reservation.setUser(user);

        reservation.setSchedule(schedule);
        reservation.setReservedSeat(reservedSeat);
        reservation.setMovieInfo(movieInfo);
        reservation.setPayment(payment);


        return reservation;
    }


    public ReservationDTO getReservationById(long id) {
        Reservation reserved = reservationRepository.findReservationById(id);
        if (reserved == null) {
            throw new IllegalArgumentException("No such ID found in the DataBase");
        }
        return convertToDto(reserved);
    }

    public ReservationDTO updateReservation(ReservationDTO dto) {
        Reservation reservation = reservationRepository.findOne(dto.getId());


        Schedule schedule = new Schedule();
        List<ReservedSeat> reservedSeat = new ArrayList<>();
        MovieInfo movieInfo = new MovieInfo();
        Payment payment = new Payment();

        reservation.setId(dto.getId());
        reservation.setTicketAvailableNr(dto.getTicketAvailableNr());
        reservation.setDateTime(dto.getDateTime());
        reservation.setPayed(dto.getPayed());

        reservation.setSchedule(schedule);
        reservation.setReservedSeat(reservedSeat);
        reservation.setMovieInfo(movieInfo);
        reservation.setPayment(payment);

        Reservation savedReservation = reservationRepository.save(reservation);
        return convertToDto(savedReservation);
    }

    public boolean deleteReservationById(long id) {
        if (reservationRepository.findOne(id) != null) {
            reservationRepository.delete(id);
            return true;
        }
        return false;
    }

    // BOOLEAN METHOD IS PAYED!
}