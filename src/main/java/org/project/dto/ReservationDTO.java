package org.project.dto;

import org.project.domain.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class ReservationDTO {

    private long id;
    private int ticketAvailableNr;
    private Date dateTime;
    private Boolean isPayed;
    private Hall hall;
    private MovieInfo movieInfo;
    private Schedule schedule;
    private List<ReservedSeat> reservedSeat = new ArrayList<>();
    private Payment payment;

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    public List<ReservedSeat> getReservedSeat() {
        return reservedSeat;
    }

    public void setReservedSeat(List<ReservedSeat> reservedSeat) {
        this.reservedSeat = reservedSeat;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getTicketAvailableNr() {
        return ticketAvailableNr;
    }

    public void setTicketAvailableNr(int ticketAvailableNr) {
        this.ticketAvailableNr = ticketAvailableNr;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public Boolean getPayed() {
        return isPayed;
    }

    public void setPayed(Boolean payed) {
        isPayed = payed;
    }

    public Hall getHall() {
        return hall;
    }

    public void setHall(Hall hall) {
        this.hall = hall;
    }

    public MovieInfo getMovieInfo() {
        return movieInfo;
    }

    public void setMovieInfo(MovieInfo movieInfo) {
        this.movieInfo = movieInfo;
    }

    @Override
    public String toString() {
        return "ReservationDTO{" +
                "id=" + id +
                ", ticketAvailableNr=" + ticketAvailableNr +
                ", dateTime=" + dateTime +
                ", isPayed=" + isPayed +
                ", hall=" + hall +
                ", movieInfo=" + movieInfo +
                ", schedule=" + schedule +
                ", reservedSeat=" + reservedSeat +
                ", payment=" + payment +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReservationDTO that = (ReservationDTO) o;
        return id == that.id &&
                ticketAvailableNr == that.ticketAvailableNr &&
                Objects.equals(dateTime, that.dateTime) &&
                Objects.equals(isPayed, that.isPayed) &&
                Objects.equals(hall, that.hall) &&
                Objects.equals(movieInfo, that.movieInfo) &&
                Objects.equals(schedule, that.schedule) &&
                Objects.equals(reservedSeat, that.reservedSeat) &&
                Objects.equals(payment, that.payment);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, ticketAvailableNr, dateTime, isPayed, hall, movieInfo, schedule, reservedSeat, payment);
    }
}

