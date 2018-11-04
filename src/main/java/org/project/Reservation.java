package org.project;
import java.util.Date;

public class Reservation {
    private int ticketAvailableNr;
    private Date dateTime;
    private Boolean isPayed;


    public Reservation(int ticketAvailableNr, Date dateTime, Boolean isPayed) {
        this.ticketAvailableNr = ticketAvailableNr;
        this.dateTime = dateTime;
        this.isPayed = isPayed;
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
}