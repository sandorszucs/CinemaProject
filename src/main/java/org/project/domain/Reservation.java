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


    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "movieInfo_id")
    private MovieInfo movieInfo;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "schedule_id")
    private Schedule schedule;



    @OneToMany (fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "RESERVATION_SEAT_TABLE") // am creat bine tabelul de legatura?
    @JoinColumn (name = "reservedSeat_id")
    private List<ReservedSeat> reservedSeat = new ArrayList<>();

    @OneToOne (fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "payment_id")
    private Payment payment;

    public Reservation(long id, int ticketAvailableNr, Date dateTime, Boolean isPayed) {
        this.id = id;
        this.ticketAvailableNr = ticketAvailableNr;
        this.dateTime = dateTime;
        this.isPayed = isPayed;
    }

    public MovieInfo getMovieInfo() {
        return movieInfo;
    }

    public void setMovieInfo(MovieInfo movieInfo) {
        this.movieInfo = movieInfo;
    }

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

}