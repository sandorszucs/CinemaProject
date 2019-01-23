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

//    @Column (name = "seat")
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "seat_id")
    private Seat seat;


}
