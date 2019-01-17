package org.project.dto;

import java.util.Objects;

public class HallDTO {

    private String location;
    private int capacity;

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
                "location='" + location + '\'' +
                ", capacity=" + capacity +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HallDTO hallDTO = (HallDTO) o;
        return capacity == hallDTO.capacity &&
                Objects.equals(location, hallDTO.location);
    }

    @Override
    public int hashCode() {

        return Objects.hash(location, capacity);
    }
}
