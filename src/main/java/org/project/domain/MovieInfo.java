package org.project.domain;

import javax.persistence.*;

@Entity
@Table(name = "movieInfo")
public class MovieInfo {

    @Id
    @Column(name = "Id")
    @GeneratedValue(generator = "movieInfo_generator")
    @SequenceGenerator(
            name = "movieInfo_generator",
            sequenceName = "movieInfo_sequence",
            initialValue = 1
    )
    private long id;

    @Column(name = "title")
    private String title;

    @Column(name = "production")
    private int production;

    @Column(name = "director")
    private String director;

    @Column(name = "actor")
    private String actor;

    @Column(name = "genre")
    private String genre;


    public MovieInfo(long id, String title, int production, String director, String actor, String genre) {
        this.id = id;
        this.title = title;
        this.production = production;
        this.director = director;
        this.actor = actor;
        this.genre = genre;
    }

    public MovieInfo() {
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
}
