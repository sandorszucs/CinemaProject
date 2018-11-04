package org.project;
import java.util.Date;

public class Schedule {

    private Hall hall;
    private MovieInfo movieInfo;
    private Date startTime;
    private Date movieStartTime;

    public Schedule(Hall hall, MovieInfo movieInfo, Date startTime, Date movieStartTime) {
        this.hall = hall;
        this.movieInfo = movieInfo;
        this.startTime = startTime;
        this.movieStartTime = movieStartTime;
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

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getMovieStartTime() {
        return movieStartTime;
    }

    public void setMovieStartTime(Date movieStartTime) {
        this.movieStartTime = movieStartTime;
    }


}
