package org.project.dto;

import java.util.Objects;

public class SeatDTO {

    private long id;
    private int row;
    private int seatNumber;

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

    @Override
    public String toString() {
        return "SeatDTO{" +
                "id=" + id +
                ", row=" + row +
                ", seatNumber=" + seatNumber +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SeatDTO seatDTO = (SeatDTO) o;
        return id == seatDTO.id &&
                row == seatDTO.row &&
                seatNumber == seatDTO.seatNumber;
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, row, seatNumber);
    }
}
