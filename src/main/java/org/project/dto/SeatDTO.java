package org.project.dto;

import java.util.Objects;

public class SeatDTO {

    private int row;
    private int seatNumber;

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

    @Override
    public String toString() {
        return "SeatDTO{" +
                "row=" + row +
                ", seatNumber=" + seatNumber +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SeatDTO seatDTO = (SeatDTO) o;
        return row == seatDTO.row &&
                seatNumber == seatDTO.seatNumber;
    }

    @Override
    public int hashCode() {

        return Objects.hash(row, seatNumber);
    }
}
