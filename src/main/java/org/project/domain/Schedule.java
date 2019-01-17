package org.project.domain;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "schedule")
public class Schedule {

    @Id
    @Column(name = "hall")
    @GeneratedValue(generator = "hall_generator")
    @SequenceGenerator(
            name = "hall_generator",
            sequenceName = "hall_sequence",
            initialValue = 1
    )
    private Hall hall;

    @Column(name = "movieInfo")
    private MovieInfo movieInfo;

    @Column(name = "movieStartTime")
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
