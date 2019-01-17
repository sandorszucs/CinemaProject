package org.project.dto;

import java.util.Arrays;
import java.util.Objects;

public class MovieInfoDTO {

    private int id;
    private String title;
    private String movieType;
    private String director;
    private String[] cast;
    private String venue;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMovieType() {
        return movieType;
    }

    public void setMovieType(String movieType) {
        this.movieType = movieType;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String[] getCast() {
        return cast;
    }

    public void setCast(String[] cast) {
        this.cast = cast;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    @Override
    public String toString() {
        return "MovieInfoDTO{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", movieType='" + movieType + '\'' +
                ", director='" + director + '\'' +
                ", cast=" + Arrays.toString(cast) +
                ", venue='" + venue + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MovieInfoDTO that = (MovieInfoDTO) o;
        return id == that.id &&
                Objects.equals(title, that.title) &&
                Objects.equals(movieType, that.movieType) &&
                Objects.equals(director, that.director) &&
                Arrays.equals(cast, that.cast) &&
                Objects.equals(venue, that.venue);
    }

    @Override
    public int hashCode() {

        int result = Objects.hash(id, title, movieType, director, venue);
        result = 31 * result + Arrays.hashCode(cast);
        return result;
    }
}
