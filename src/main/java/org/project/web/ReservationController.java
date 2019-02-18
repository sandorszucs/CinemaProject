package org.project.web;

import org.project.dto.ReservationDTO;
import org.project.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ReservationController {

    @Autowired
    private ReservationService reservationService;


    @RequestMapping(path = "/reservation/{id}", method = RequestMethod.GET)
    public ReservationDTO getReservation(@PathVariable("id") long id) {
        return reservationService.getReservationById(id);
    }

    @ResponseBody
    @RequestMapping(path = "/reservation", method = RequestMethod.POST)
    public ReservationDTO saveReservation(@RequestBody ReservationDTO reservationDTO) {
        reservationService.saveReservation(reservationDTO);
        return reservationDTO;
    }


    @RequestMapping(path = "/reservation/{id}", method = RequestMethod.PUT)
    public ReservationDTO updateReservation(@PathVariable long id, @RequestBody ReservationDTO dto) {
        return reservationService.updateReservation(id, dto);
    }

    @RequestMapping(path = "/reservation/{id}", method = RequestMethod.DELETE)
    public void deleteReservation(@PathVariable("id") long id) {
        reservationService.deleteReservationById(id);
    }
}