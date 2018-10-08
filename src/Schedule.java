import java.util.Date;

public class Schedule {

    private Hall hall;
    private MovieInfo movieInfo;
    private Date startTime;

    public Schedule(Hall hall, MovieInfo movieInfo, Date startTime) {
        this.hall = hall;
        this.movieInfo = movieInfo;
        this.startTime = startTime;
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
}
