package org.project.service;

import org.project.domain.*;
import org.project.dto.*;
import org.project.helper.ConverterHelper;
import org.project.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private ConverterHelper converterHelper;

    @Autowired
    private ScheduleRepository scheduleRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SeatRepository seatRepository;


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

        reservationDTO.setId(reservation.getId());
        reservationDTO.setTicketAvailableNr(reservation.getTicketAvailableNr());
        reservationDTO.setDateTime(reservation.getDateTime());
        reservationDTO.setSchedule(scheduleDTO);
        reservationDTO.setReservedSeats(reservedSeatDTO);
        reservationDTO.setMovieInfo(movieInfoDTO);

        return reservationDTO;
    }

    private Reservation convert(ReservationDTO reservationDTO) {
        Reservation reservation = new Reservation();

        Schedule schedule = scheduleRepository.findOne(reservationDTO.getSchedule().getId());
        User user = userRepository.findOne(reservationDTO.getUser().getId());

        List <ReservedSeat> reservedSeats = new ArrayList<>();
        for (ReservedSeatDTO rv : reservationDTO.getReservedSeats()) {
            Seat seat = seatRepository.findOne(rv.getSeat().getId());
            ReservedSeat reservedSeat1 = new ReservedSeat();
            reservedSeat1.setSeat(seat);
            reservedSeat1.setUser(user);
            reservedSeat1.setSchedule(schedule);
            reservedSeats.add(reservedSeat1);
        }
        reservation.setReservedSeat(reservedSeats);
        reservation.setId(reservationDTO.getId());
        reservation.setTicketAvailableNr(reservationDTO.getTicketAvailableNr());
        reservation.setDateTime(reservationDTO.getDateTime());
        reservation.setUser(user);
        reservation.setSchedule(schedule);
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
        reservation.setId(dto.getId());
        reservation.setTicketAvailableNr(dto.getTicketAvailableNr());
        reservation.setDateTime(dto.getDateTime());
        reservation.setSchedule(schedule);
        reservation.setReservedSeat(reservedSeat);
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
}