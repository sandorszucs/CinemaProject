package org.project.dto;

import org.project.domain.Hall;
import org.project.domain.MovieInfo;

import java.util.Date;
import java.util.Objects;

public class ReservationDTO {

    private int ticketAvailableNr;
    private Date dateTime;
    private Boolean isPayed;
    private Hall hall;
    private MovieInfo movieInfo;

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
                "ticketAvailableNr=" + ticketAvailableNr +
                ", dateTime=" + dateTime +
                ", isPayed=" + isPayed +
                ", hall=" + hall +
                ", movieInfo=" + movieInfo +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReservationDTO that = (ReservationDTO) o;
        return ticketAvailableNr == that.ticketAvailableNr &&
                Objects.equals(dateTime, that.dateTime) &&
                Objects.equals(isPayed, that.isPayed) &&
                Objects.equals(hall, that.hall) &&
                Objects.equals(movieInfo, that.movieInfo);
    }

    @Override
    public int hashCode() {

        return Objects.hash(ticketAvailableNr, dateTime, isPayed, hall, movieInfo);
    }
}

