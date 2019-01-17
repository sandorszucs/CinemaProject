package org.project.domain;
import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "reservation")
public class Reservation {

    @Id
    @Column(name = "Id")
    @GeneratedValue(generator = "reservation_generator")
    @SequenceGenerator(
            name = "reservation_generator",
            sequenceName = "reservation_sequence",
            initialValue = 1
    )
    private long id;

    @Column(name = "ticketAvailableNr")
    private int ticketAvailableNr;

    @Column(name = "dateTime")
    private Date dateTime;

    @Column(name = "isPayed")
    private Boolean isPayed;

    @Column(name = "hall")
    private Hall hall;

    @Column (name = "movieInfo")
    private MovieInfo movieInfo;


    public Reservation(int ticketAvailableNr, Date dateTime, Boolean isPayed, Hall hall) {
        this.ticketAvailableNr = ticketAvailableNr;
        this.dateTime = dateTime;
        this.isPayed = isPayed;
        this.hall = hall;
    }

    public MovieInfo getMovieInfo() {
        return movieInfo;
    }

    public void setMovieInfo(MovieInfo movieInfo) {
        this.movieInfo = movieInfo;
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