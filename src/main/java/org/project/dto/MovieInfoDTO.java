package org.project.dto;

import java.util.Objects;

public class MovieInfoDTO {

    private long id;
    private String title;
    private int production;
    private String director;
    private String actor;
    private String genre;

    public MovieInfoDTO(long id, String title, int production, String director, String actor, String genre) {
        this.id = id;
        this.title = title;
        this.production = production;
        this.director = director;
        this.actor = actor;
        this.genre = genre;
    }

    public MovieInfoDTO() {
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

    public int getProduction() {
        return production;
    }

    public void setProduction(int production) {
        this.production = production;
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

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "MovieInfoDTO{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", production=" + production +
                ", director='" + director + '\'' +
                ", actor='" + actor + '\'' +
                ", genre='" + genre + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MovieInfoDTO that = (MovieInfoDTO) o;
        return id == that.id &&
                production == that.production &&
                Objects.equals(title, that.title) &&
                Objects.equals(director, that.director) &&
                Objects.equals(actor, that.actor) &&
                Objects.equals(genre, that.genre);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, title, production, director, actor, genre);
    }
}
