package org.project.domain;

import javax.persistence.*;

@Entity
@Table(name = "seats")
public class Seat {

    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "seat_generator")
    @SequenceGenerator(
            name = "seat_generator",
            sequenceName = "seat_sequence",
            initialValue = 1
    )
    private long id;

    @Column(name = "row")
    private int row;
    @Column(name = "seatNumber")
    private int seatNumber;

    public Seat(long id, int row, int seatNumber) {
        this.id = id;
        this.row = row;
        this.seatNumber = seatNumber;
    }

    public Seat(){

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
