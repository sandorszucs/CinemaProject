package org.project.dto;

import org.project.domain.Hall;
import org.project.domain.MovieInfo;
import org.project.domain.ReservedSeat;

import java.util.Date;
import java.util.List;
import java.util.Objects;

public class ScheduleDTO {

    private long id;

    private HallDTO hall;
    private Date movieStartTime;
    private MovieInfoDTO movieInfo;
    private List<ReservedSeatDTO> reservedSeats;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public HallDTO getHall() {
        return hall;
    }

    public void setHall(HallDTO hall) {
        this.hall = hall;
    }

    public Date getMovieStartTime() {
        return movieStartTime;
    }

    public void setMovieStartTime(Date movieStartTime) {
        this.movieStartTime = movieStartTime;
    }

    public MovieInfoDTO getMovieInfo() {
        return movieInfo;
    }

    public void setMovieInfo(MovieInfoDTO movieInfo) {
        this.movieInfo = movieInfo;
    }

    public List<ReservedSeatDTO> getReservedSeats() {
        return reservedSeats;
    }

    public void setReservedSeats(List<ReservedSeatDTO> reservedSeats) {
        this.reservedSeats = reservedSeats;
    }

    @Override
    public String toString() {
        return "ScheduleDTO{" +
                "id=" + id +
                ", hall=" + hall +
                ", movieStartTime=" + movieStartTime +
                ", movieInfo=" + movieInfo +
                ", reservedSeats=" + reservedSeats +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ScheduleDTO that = (ScheduleDTO) o;
        return id == that.id &&
                Objects.equals(hall, that.hall) &&
                Objects.equals(movieStartTime, that.movieStartTime) &&
                Objects.equals(movieInfo, that.movieInfo) &&
                Objects.equals(reservedSeats, that.reservedSeats);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, hall, movieStartTime, movieInfo, reservedSeats);
    }
}
