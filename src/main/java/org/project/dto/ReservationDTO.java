package org.project.dto;


import java.util.Date;
import java.util.List;
import java.util.Objects;

public class ReservationDTO {

    private long id;
    private int ticketAvailableNr;
    private Date dateTime;

    private HallDTO hall;
    private MovieInfoDTO movieInfo;
    private ScheduleDTO schedule;
    private List<ReservedSeatDTO> reservedSeat;
    private UserDTO user;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getTicketAvailableNr() {
        return ticketAvailableNr;
    }

    public void setTicketAvailableNr(int ticketAvailableNr) {
        this.ticketAvailableNr = ticketAvailableNr;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public HallDTO getHall() {
        return hall;
    }

    public void setHall(HallDTO hall) {
        this.hall = hall;
    }

    public MovieInfoDTO getMovieInfo() {
        return movieInfo;
    }

    public void setMovieInfo(MovieInfoDTO movieInfo) {
        this.movieInfo = movieInfo;
    }

    public ScheduleDTO getSchedule() {
        return schedule;
    }

    public void setSchedule(ScheduleDTO schedule) {
        this.schedule = schedule;
    }

    public List<ReservedSeatDTO> getReservedSeats() {
        return reservedSeat;
    }

    public void setReservedSeats(List<ReservedSeatDTO> reservedSeat) {
        this.reservedSeat = reservedSeat;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }


    @Override
    public String toString() {
        return "ReservationDTO{" +
                "id=" + id +
                ", ticketAvailableNr=" + ticketAvailableNr +
                ", dateTime=" + dateTime +
                ", hall=" + hall +
                ", movieInfo=" + movieInfo +
                ", schedule=" + schedule +
                ", reservedSeat=" + reservedSeat +
                ", user=" + user +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReservationDTO that = (ReservationDTO) o;
        return id == that.id &&
                ticketAvailableNr == that.ticketAvailableNr &&
                Objects.equals(dateTime, that.dateTime) &&
                Objects.equals(hall, that.hall) &&
                Objects.equals(movieInfo, that.movieInfo) &&
                Objects.equals(schedule, that.schedule) &&
                Objects.equals(reservedSeat, that.reservedSeat) &&
                Objects.equals(user, that.user);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, ticketAvailableNr, dateTime, hall, movieInfo, schedule, reservedSeat, user);
    }
}

