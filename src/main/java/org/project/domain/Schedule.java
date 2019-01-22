package org.project.domain;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "schedules")
public class Schedule {

    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "hall_generator")
    @SequenceGenerator(
            name = "hall_generator",
            sequenceName = "hall_sequence",
            initialValue = 1
    )

    private long id;

    @Column (name = "name")
    private Hall hall;

    @Column(name = "movieInfo")
    private MovieInfo movieInfo;

    @Column(name = "movieStartTime")
    private Date movieStartTime;

    public Schedule(long id, Hall hall, MovieInfo movieInfo, Date movieStartTime) {
        this.id = id;
        this.hall = hall;
        this.movieInfo = movieInfo;
        this.movieStartTime = movieStartTime;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
