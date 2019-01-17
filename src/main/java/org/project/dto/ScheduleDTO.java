package org.project.dto;

import org.project.domain.Hall;
import org.project.domain.MovieInfo;

import java.util.Date;
import java.util.Objects;

public class ScheduleDTO {

    private Hall hall;
    private MovieInfo movieInfo;
    private Date movieStartTime;


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
                "hall=" + hall +
                ", movieInfo=" + movieInfo +
                ", movieStartTime=" + movieStartTime +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ScheduleDTO that = (ScheduleDTO) o;
        return Objects.equals(hall, that.hall) &&
                Objects.equals(movieInfo, that.movieInfo) &&
                Objects.equals(movieStartTime, that.movieStartTime);
    }

    @Override
    public int hashCode() {

        return Objects.hash(hall, movieInfo, movieStartTime);
    }
}
