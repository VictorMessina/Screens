package com.br.projetoLP2.model;

import java.io.Serializable;

/**
 *
 * @author 31402836
 */
public class Movie implements Serializable {

    private int id_Movie;
    private String title;
    private int years;
    private String director;
    private int classification;
    private String genre;

    public Movie() {

    }

    public Movie(int id_Movie, String title, int years, String director, int classification, String genre) {
        this.id_Movie = id_Movie;
        this.title = title;
        this.years = years;
        this.director = director;
        this.classification = classification;
        this.genre = genre;
    }

    public Movie(String title, int years, String director, int classification, String genre) {
        this.id_Movie = -1;
        this.title = title;
        this.years = years;
        this.director = director;
        this.classification = classification;
        this.genre = genre;
    }

    public int getId_Movie() {
        return id_Movie;
    }

    public void setId_Movie(int id_Movie) {
        this.id_Movie = id_Movie;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYears() {
        return years;
    }

    public void setYears(int years) {
        this.years = years;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getClassification() {
        return classification;
    }

    public void setClassification(int classification) {
        this.classification = classification;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Movie{" + "id_Movie=" + id_Movie + ", title=" + title
                + ", years=" + years + ", director=" + director
                + ", classification=" + classification + ", genre=" + genre + '}';
    }
}
