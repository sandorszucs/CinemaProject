package org.project.service;

import org.project.domain.*;
import org.project.dto.*;
import org.project.persistence.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    public void saveReservation(ReservationDTO reservationDTO) {
        Long reservationId = reservationDTO.getId();
        if (reservationId == null) {
            throw new IllegalArgumentException("Reservation id cannot be null");
        }
        try {
            getReservationById(reservationId);
        } catch (Exception e) {
            Reservation reservationObject = convert(reservationDTO);
            try {
                reservationRepository.save(reservationObject);
            } catch (Exception e2) {
                System.out.println("Your reservation could NOT be saved! Please, try again! " + e2);
            }
        }
    }

    private ReservationDTO convertToDto(Reservation reservation) {

        ReservationDTO reservationDTO = new ReservationDTO();
        ScheduleDTO scheduleDTO = new ScheduleDTO();
        List<ReservedSeatDTO> reservedSeatDTO = new ArrayList<>();
        MovieInfoDTO movieInfoDTO = new MovieInfoDTO();
        PaymentDTO paymentDTO = new PaymentDTO();

        reservationDTO.setId(reservation.getId());
        reservationDTO.setTicketAvailableNr(reservation.getTicketAvailableNr());
        reservationDTO.setDateTime(reservation.getDateTime());
        reservationDTO.setPayed(reservation.getPayed());


        reservationDTO.setSchedule(scheduleDTO);
        reservationDTO.setReservedSeat(reservedSeatDTO);
        reservationDTO.setMovieInfo(movieInfoDTO);
        reservationDTO.setPayment(paymentDTO);
        return reservationDTO;
    }

    private Reservation convert(ReservationDTO reservationDTO) {

        Reservation reservation = new Reservation();
        Schedule schedule = new Schedule();
        List<ReservedSeat> reservedSeat = new ArrayList<>() ;
        MovieInfo movieInfo = new MovieInfo();
        Payment payment = new Payment();

        reservation.setId(reservationDTO.getId());
        reservation.setTicketAvailableNr(reservationDTO.getTicketAvailableNr());
        reservation.setDateTime(reservationDTO.getDateTime());
        reservation.setPayed(reservationDTO.getPayed());

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

    public ReservationDTO updateReservation(long id, ReservationDTO dto) {
        Reservation reservation = reservationRepository.findOne(id);

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
