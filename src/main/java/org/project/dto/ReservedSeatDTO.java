package org.project.dto;

import java.util.Objects;

public class ReservedSeatDTO {

    private long id;
    private SeatDTO seat;
    private UserDTO user;
    private ScheduleDTO schedule;
    private ReservationDTO reservation;

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public ScheduleDTO getSchedule() {
        return schedule;
    }

    public void setSchedule(ScheduleDTO schedule) {
        this.schedule = schedule;
    }

    public ReservationDTO getReservation() {
        return reservation;
    }

    public void setReservation(ReservationDTO reservation) {
        this.reservation = reservation;
    }

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
                ", user=" + user +
                ", schedule=" + schedule +
                ", reservation=" + reservation +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReservedSeatDTO that = (ReservedSeatDTO) o;
        return id == that.id &&
                Objects.equals(seat, that.seat) &&
                Objects.equals(user, that.user) &&
                Objects.equals(schedule, that.schedule) &&
                Objects.equals(reservation, that.reservation);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, seat, user, schedule, reservation);
    }
}
