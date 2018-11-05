package org.project;
import java.util.Date;

public class Schedule {

    private Hall hall;
    private MovieInfo movieInfo;
    private Date movieStartTime;

    public Schedule(Hall hall, MovieInfo movieInfo, Date movieStartTime) {
        this.hall = hall;
        this.movieInfo = movieInfo;
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

    public Date getMovieStartTime() {
        return movieStartTime;
    }

    public void setMovieStartTime(Date movieStartTime) {
        this.movieStartTime = movieStartTime;
    }


}
