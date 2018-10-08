import java.util.Date;

public class Reservation {
    private int ticketAvaibleNr;
    private Date date;
    private Date time;
    private Boolean isPayed;

    public Reservation(int ticketAvaibleNr, Date date, Date time, Boolean isPayed) {
        this.ticketAvaibleNr = ticketAvaibleNr;
        this.date = date;
        this.time = time;
        this.isPayed = isPayed;
    }

    public void selectSeat() {
    }

    public void changeSeat() {
    }

    public int getTicketAvaibleNr() {
        return ticketAvaibleNr;
    }

    public void setTicketAvaibleNr(int ticketAvaibleNr) {
        this.ticketAvaibleNr = ticketAvaibleNr;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Boolean getPayed() {
        return isPayed;
    }

    public void setPayed(Boolean payed) {
        isPayed = payed;
    }
}