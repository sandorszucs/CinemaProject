package org.project.domain;
public class Seat {

    private int row;
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
