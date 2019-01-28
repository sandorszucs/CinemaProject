package org.project.dto;

import org.project.domain.Hall;
import org.project.domain.MovieInfo;
import org.project.domain.ReservedSeat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class ScheduleDTO {

    private long id;
    private Hall hall;
    private MovieInfo movieInfo;
    private Date movieStartTime;
    private List<ReservedSeat> reservedSeats = new ArrayList<>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<ReservedSeat> getReservedSeats() {
        return reservedSeats;
    }

    public void setReservedSeats(List<ReservedSeat> reservedSeats) {
        this.reservedSeats = reservedSeats;
    }

    public Hall getHall() {
        return hall;
    }

    public void setHall(Hall hall) {
        this.hall = hall;
    }

    public MovieInfo getMovieInfo() {
        return movieInfo;
    }

    public void setMovieInfo(MovieInfo movieInfo) {
        this.movieInfo = movieInfo;
    }

    public Date getMovieStartTime() {
        return movieStartTime;
    }

    public void setMovieStartTime(Date movieStartTime) {
        this.movieStartTime = movieStartTime;
    }


    @Override
    public String toString() {
        return "ScheduleDTO{" +
                "id=" + id +
                ", hall=" + hall +
                ", movieInfo=" + movieInfo +
                ", movieStartTime=" + movieStartTime +
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
                Objects.equals(movieInfo, that.movieInfo) &&
                Objects.equals(movieStartTime, that.movieStartTime) &&
                Objects.equals(reservedSeats, that.reservedSeats);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, hall, movieInfo, movieStartTime, reservedSeats);
    }
}
