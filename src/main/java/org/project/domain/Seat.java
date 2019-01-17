package org.project.domain;

import javax.persistence.*;

@Entity
@Table(name = "seat")
public class Seat {

    @Id
    @Column(name = "row")
    @GeneratedValue (generator = "seat_generator")
    @SequenceGenerator(
            name = "seat_generator",
            sequenceName = "seat_sequence",
            initialValue = 1
    )

    private int row;
    @Column(name = "seatNumber")
    private int seatNumber;


    public Seat(int row, int seatNumber) {
        this.row = row;
        this.seatNumber = seatNumber;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }
}
