package org.project.domain;

public class MovieInfo {

    private int id;
    private String title;
    private String movieType;
    private String director;
    private String[] cast;
    private String venue;

    public MovieInfo(int id, String title, String movieType, String director, String[] cast, String venue) {
        this.id = id;
        this.title = title;
        this.movieType = movieType;
        this.director = director;
        this.cast = cast;
        this.venue = venue;
    }

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
}
