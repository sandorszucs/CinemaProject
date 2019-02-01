package org.project.domain;

import javax.persistence.*;

@Entity
@Table(name = "reserved_seats")
public class ReservedSeat {

    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "reservedSeats_generator")
    @SequenceGenerator(
            name = "reservedSeats_generator",
            sequenceName = "reservedSeats_sequence",
            initialValue = 1
    )
    private long id;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Seat seat;

    @OneToOne
    private User user;


    @OneToOne
    private Schedule schedule;

    @OneToOne
    private Reservation reservation;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }
}
