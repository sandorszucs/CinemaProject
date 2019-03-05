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

    public void setConverterHelper(ConverterHelper converterHelper) {
        this.converterHelper = converterHelper;
    }

    public Reservation saveReservation(ReservationDTO reservationDTO) {
        Reservation reservationObject = converterHelper.convertReservation(reservationDTO);

        try {
            return reservationRepository.save(reservationObject);
        } catch (Exception e2) {
            System.out.println("Your reservation could NOT be saved! Please, try again! " + e2);
            return new Reservation();
        }
    }

    public ReservationDTO getReservationById(long id) {
        Reservation reserved = reservationRepository.findReservationById(id);
        if (reserved == null) {
            throw new IllegalArgumentException("No such ID found in the DataBase");
        }
        return converterHelper.convertReservationToDto(reserved);
    }

    public ReservationDTO updateReservation(long id, ReservationDTO dto) {
        Reservation reservation = reservationRepository.findOne(id);

        Schedule schedule = new Schedule();
        List<ReservedSeat> reservedSeat = new ArrayList<>();
        reservation.setId(dto.getId());
        reservation.setDateTime(dto.getDateTime());
        reservation.setSchedule(schedule);
        reservation.setReservedSeat(reservedSeat);
        Reservation savedReservation = reservationRepository.save(reservation);
        return converterHelper.convertReservationToDto(savedReservation);
    }

    public boolean deleteReservationById(long id) {
        if (reservationRepository.findOne(id) != null) {
            reservationRepository.delete(id);
            return true;
        }
        return false;
    }
}