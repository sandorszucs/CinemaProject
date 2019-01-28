package org.project.domain;

import javax.persistence.*;

@Entity
@Table(name = "reservedSeats")
public class ReservedSeat {

    @Id
    @Column(name = "Id")
    @GeneratedValue(generator = "reservedSeats_generator")
    @SequenceGenerator(
            name = "reservedSeats_generator",
            sequenceName = "reservedSeats_sequence",
            initialValue = 1
    )
    private long id;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "seat_id")
    private Seat seat;

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
