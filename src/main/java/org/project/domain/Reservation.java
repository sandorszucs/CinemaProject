package org.project.domain;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "reservations")
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

    @Column(name = "createdDateTime")
    private Date dateTime;

    @Column(name = "isPayed")
    private Boolean isPayed;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "seat_id")
    private Seat seat;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "movieInfo_id")
    private MovieInfo movieInfo;

    private Schedule schedule; // am adaugat un obiect de schedule in reservation?
    private List<Seat> reservedSeat = new ArrayList<>(); // am creat o lista in reservation care imi mentine ce loc a fost rezervat?
    private Payment payment; // ez meglenne?

    public Reservation(long id, int ticketAvailableNr, Date dateTime, Boolean isPayed) {
        this.id = id;
        this.ticketAvailableNr = ticketAvailableNr;
        this.dateTime = dateTime;
        this.isPayed = isPayed;
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

}