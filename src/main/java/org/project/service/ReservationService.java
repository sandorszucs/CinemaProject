package org.project.service;

import org.project.domain.Reservation;
import org.project.dto.ReservationDTO;
import org.project.persistence.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;

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

        reservationDTO.setId(reservation.getId());
        reservationDTO.setTicketAvailableNr(reservation.getTicketAvailableNr());
        reservationDTO.setDateTime(reservation.getDateTime());
        reservationDTO.setPayed(reservation.getPayed());

        reservationDTO.setSchedule(reservation.getSchedule());
        reservationDTO.setReservedervation.(reservation.getPayed());
        reservationDTO.setMovieInfoSeat(reservation.getReservedSeat());
        reservationDTO.setPayment(reservation.getPayment());
        return reservationDTO;
    }

    private Reservation convert(ReservationDTO reservationDTO) {
        Reservation reservation = new Reservation();
        reservation.setId(reservationDTO.getId());
        reservation.setTicketAvailableNr(reservationDTO.getTicketAvailableNr());
        reservation.setDateTime(reservationDTO.getDateTime());
        reservation.setPayed(reservationDTO.getPayed());
        reservation.setUser(reservationDTO.getUser());
        reservation.setMovieInfo(reservationDTO.getMovieInfo());
        reservation.setSchedule(reservationDTO.getSchedule());
        reservation.setReservedSeat(reservationDTO.getReservedSeat());
        reservation.setPayment(reservationDTO.getPayment());
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

        reservation.setId(dto.getId());
        reservation.setTicketAvailableNr(dto.getTicketAvailableNr());
        reservation.setDateTime(dto.getDateTime());
        reservation.setPayed(dto.getPayed());
//        reservation.setUser(dto.getUser());
//        reservation.setMovieInfo(dto.getMovieInfo());  -------------------------- NOT WORKING
//        reservation.setSchedule(dto.getSchedule());
//        reservation.setReservedSeat(dto.getReservedSeat());
//        reservation.setPayment(dto.getPayment());

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
