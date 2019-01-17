package org.project.dto;

import org.project.domain.Hall;
import org.project.domain.Schedule;
import org.project.domain.User;

import java.util.List;
import java.util.Objects;

public class CinemaDTO {

    private User user;
    private Schedule schedule;
    private List<Hall> hall;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    public List<Hall> getHall() {
        return hall;
    }

    public void setHall(List<Hall> hall) {
        this.hall = hall;
    }

    @Override
    public String toString() {
        return "CinemaDTO{" +
                "user=" + user +
                ", schedule=" + schedule +
                ", hall=" + hall +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CinemaDTO cinemaDTO = (CinemaDTO) o;
        return Objects.equals(user, cinemaDTO.user) &&
                Objects.equals(schedule, cinemaDTO.schedule) &&
                Objects.equals(hall, cinemaDTO.hall);
    }

    @Override
    public int hashCode() {

        return Objects.hash(user, schedule, hall);
    }
}
