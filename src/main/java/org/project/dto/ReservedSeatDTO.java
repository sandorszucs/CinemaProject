package org.project.dto;

import java.util.Objects;

public class ReservedSeatDTO {

    private long id;
    private SeatDTO seat;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public SeatDTO getSeat() {
        return seat;
    }

    public void setSeat(SeatDTO seat) {
        this.seat = seat;
    }

    @Override
    public String toString() {
        return "ReservedSeatDTO{" +
                "id=" + id +
                ", seat=" + seat +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReservedSeatDTO that = (ReservedSeatDTO) o;
        return id == that.id &&
                Objects.equals(seat, that.seat);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, seat);
    }
}
