package org.project.dto;

import org.project.domain.Seat;

import java.util.List;
import java.util.Objects;

public class HallDTO {

    private long id;
    private String location;
    private int capacity;
    private List<Seat> seats;

    public List<Seat> getSeats() {
        return seats;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "HallDTO{" +
                "id=" + id +
                ", location='" + location + '\'' +
                ", capacity=" + capacity +
                ", seats=" + seats +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HallDTO hallDTO = (HallDTO) o;
        return id == hallDTO.id &&
                capacity == hallDTO.capacity &&
                Objects.equals(location, hallDTO.location) &&
                Objects.equals(seats, hallDTO.seats);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, location, capacity, seats);
    }
}
