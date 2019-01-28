package org.project.dto;

import org.project.domain.Seat;

import java.util.Objects;

public class ReservedSeatDTO {

    private long id;
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
