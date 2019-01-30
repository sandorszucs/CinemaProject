package org.project.dto;

import java.util.Objects;

public class MovieInfoDTO {

    private long id;
    private String title;
    private String movieType;
    private String director;
    private String actor;
    private String venue;

    public MovieInfoDTO(long id, String title, String movieType, String director, String actor, String venue) {
        this.id = id;
        this.title = title;
        this.movieType = movieType;
        this.director = director;
        this.actor = actor;
        this.venue = venue;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
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
                ", actor='" + actor + '\'' +
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
                Objects.equals(actor, that.actor) &&
                Objects.equals(venue, that.venue);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, title, movieType, director, actor, venue);
    }
}
