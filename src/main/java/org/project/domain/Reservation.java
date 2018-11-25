package org.project.domain;
import java.util.Date;

public class Reservation {
    private int ticketAvailableNr;
    private Date dateTime;
    private Boolean isPayed;
    private Hall hall;
    private MovieInfo movieInfo;


    public Reservation(int ticketAvailableNr, Date dateTime, Boolean isPayed, Hall hall) {
        this.ticketAvailableNr = ticketAvailableNr;
        this.dateTime = dateTime;
        this.isPayed = isPayed;
        this.hall = hall;
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

    public void makeReservation() {
        movieInfo.getTitle();
    };
}